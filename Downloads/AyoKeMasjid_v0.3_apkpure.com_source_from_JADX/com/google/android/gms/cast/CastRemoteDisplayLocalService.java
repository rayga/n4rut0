package com.google.android.gms.cast;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.C0197R;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplayOptions;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CastRemoteDisplayLocalService extends Service {
    private static final Object zzTA;
    private static AtomicBoolean zzTB;
    private static CastRemoteDisplayLocalService zzTP;
    private static final zzl zzTy;
    private static final int zzTz;
    private Handler mHandler;
    private Notification mNotification;
    private String zzSX;
    private GoogleApiClient zzTC;
    private CastRemoteDisplaySessionCallbacks zzTD;
    private Callbacks zzTE;
    private zzb zzTF;
    private NotificationSettings zzTG;
    private Boolean zzTH;
    private PendingIntent zzTI;
    private CastDevice zzTJ;
    private Display zzTK;
    private Context zzTL;
    private ServiceConnection zzTM;
    private MediaRouter zzTN;
    private final Callback zzTO;
    private final IBinder zzTQ;

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.2 */
    static class C02602 implements ServiceConnection {
        final /* synthetic */ CastDevice zzTS;
        final /* synthetic */ NotificationSettings zzTT;
        final /* synthetic */ Context zzTU;
        final /* synthetic */ Callbacks zzTV;
        final /* synthetic */ String zzTe;

        C02602(String str, CastDevice castDevice, NotificationSettings notificationSettings, Context context, Callbacks callbacks) {
            this.zzTe = str;
            this.zzTS = castDevice;
            this.zzTT = notificationSettings;
            this.zzTU = context;
            this.zzTV = callbacks;
        }

        public void onServiceConnected(ComponentName className, IBinder binder) {
            CastRemoteDisplayLocalService zzlZ = ((zza) binder).zzlZ();
            if (zzlZ == null || !zzlZ.zza(this.zzTe, this.zzTS, this.zzTT, this.zzTU, this, this.zzTV)) {
                CastRemoteDisplayLocalService.zzTy.zzc("Connected but unable to get the service instance", new Object[0]);
                this.zzTV.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
                CastRemoteDisplayLocalService.zzTB.set(false);
                try {
                    this.zzTU.unbindService(this);
                } catch (IllegalArgumentException e) {
                    CastRemoteDisplayLocalService.zzTy.zzb("No need to unbind service, already unbound", new Object[0]);
                }
            }
        }

        public void onServiceDisconnected(ComponentName arg0) {
            CastRemoteDisplayLocalService.zzTy.zzb("onServiceDisconnected", new Object[0]);
            this.zzTV.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_DISCONNECTED, "Service Disconnected"));
            CastRemoteDisplayLocalService.zzTB.set(false);
            try {
                this.zzTU.unbindService(this);
            } catch (IllegalArgumentException e) {
                CastRemoteDisplayLocalService.zzTy.zzb("No need to unbind service, already unbound", new Object[0]);
            }
        }
    }

    public interface Callbacks {
        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    public static final class NotificationSettings {
        private Notification mNotification;
        private PendingIntent zzTX;
        private String zzTY;
        private String zzTZ;

        public static final class Builder {
            private NotificationSettings zzUa;

            public Builder() {
                this.zzUa = new NotificationSettings();
            }

            public NotificationSettings build() {
                if (this.zzUa.mNotification != null) {
                    if (!TextUtils.isEmpty(this.zzUa.zzTY)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    } else if (!TextUtils.isEmpty(this.zzUa.zzTZ)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    } else if (this.zzUa.zzTX != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zzUa.zzTY) && TextUtils.isEmpty(this.zzUa.zzTZ) && this.zzUa.zzTX == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zzUa;
            }

            public Builder setNotification(Notification notification) {
                this.zzUa.mNotification = notification;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent notificationPendingIntent) {
                this.zzUa.zzTX = notificationPendingIntent;
                return this;
            }

            public Builder setNotificationText(String notificationText) {
                this.zzUa.zzTZ = notificationText;
                return this;
            }

            public Builder setNotificationTitle(String notificationTitle) {
                this.zzUa.zzTY = notificationTitle;
                return this;
            }
        }

        private NotificationSettings() {
        }

        private NotificationSettings(NotificationSettings newSettings) {
            this.mNotification = newSettings.mNotification;
            this.zzTX = newSettings.zzTX;
            this.zzTY = newSettings.zzTY;
            this.zzTZ = newSettings.zzTZ;
        }
    }

    private class zza extends Binder {
        final /* synthetic */ CastRemoteDisplayLocalService zzTR;

        private zza(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzTR = castRemoteDisplayLocalService;
        }

        CastRemoteDisplayLocalService zzlZ() {
            return this.zzTR;
        }
    }

    private static final class zzb extends BroadcastReceiver {
        private zzb() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT")) {
                CastRemoteDisplayLocalService.zzTy.zzb("disconnecting", new Object[0]);
                CastRemoteDisplayLocalService.stopService();
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.1 */
    class C06991 extends Callback {
        final /* synthetic */ CastRemoteDisplayLocalService zzTR;

        C06991(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzTR = castRemoteDisplayLocalService;
        }

        public void onRouteUnselected(MediaRouter router, RouteInfo info) {
            this.zzTR.zzaZ("onRouteUnselected");
            if (this.zzTR.zzTJ == null) {
                this.zzTR.zzaZ("onRouteUnselected, no device was selected");
            } else if (CastDevice.getFromBundle(info.getExtras()).getDeviceId().equals(this.zzTR.zzTJ.getDeviceId())) {
                CastRemoteDisplayLocalService.stopService();
            } else {
                this.zzTR.zzaZ("onRouteUnselected, device does not match");
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.3 */
    class C07003 implements CastRemoteDisplaySessionCallbacks {
        final /* synthetic */ CastRemoteDisplayLocalService zzTR;

        /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.3.1 */
        class C02611 implements Runnable {
            final /* synthetic */ C07003 zzTW;

            C02611(C07003 c07003) {
                this.zzTW = c07003;
            }

            public void run() {
                CastRemoteDisplayLocalService.zzQ(false);
            }
        }

        C07003(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzTR = castRemoteDisplayLocalService;
        }

        public void onRemoteDisplayEnded(Status status) {
            CastRemoteDisplayLocalService.zzTy.zzb(String.format("Cast screen has ended: %d", new Object[]{Integer.valueOf(status.getStatusCode())}), new Object[0]);
            if (this.zzTR.mHandler != null) {
                this.zzTR.mHandler.post(new C02611(this));
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.4 */
    class C07014 implements ResultCallback<CastRemoteDisplaySessionResult> {
        final /* synthetic */ CastRemoteDisplayLocalService zzTR;

        C07014(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzTR = castRemoteDisplayLocalService;
        }

        public /* synthetic */ void onResult(Result x0) {
            zza((CastRemoteDisplaySessionResult) x0);
        }

        public void zza(CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
            if (castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                CastRemoteDisplayLocalService.zzTy.zzb("startRemoteDisplay successful", new Object[0]);
                synchronized (CastRemoteDisplayLocalService.zzTA) {
                    if (CastRemoteDisplayLocalService.zzTP == null) {
                        CastRemoteDisplayLocalService.zzTy.zzb("Remote Display started but session already cancelled", new Object[0]);
                        this.zzTR.zzlR();
                        return;
                    }
                    Display presentationDisplay = castRemoteDisplaySessionResult.getPresentationDisplay();
                    if (presentationDisplay != null) {
                        this.zzTR.zza(presentationDisplay);
                    } else {
                        CastRemoteDisplayLocalService.zzTy.zzc("Cast Remote Display session created without display", new Object[0]);
                    }
                    CastRemoteDisplayLocalService.zzTB.set(false);
                    if (this.zzTR.zzTL != null && this.zzTR.zzTM != null) {
                        try {
                            this.zzTR.zzTL.unbindService(this.zzTR.zzTM);
                        } catch (IllegalArgumentException e) {
                            CastRemoteDisplayLocalService.zzTy.zzb("No need to unbind service, already unbound", new Object[0]);
                        }
                        this.zzTR.zzTM = null;
                        this.zzTR.zzTL = null;
                        return;
                    }
                    return;
                }
            }
            CastRemoteDisplayLocalService.zzTy.zzc("Connection was not successful", new Object[0]);
            this.zzTR.zzlR();
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.5 */
    class C07025 implements ResultCallback<CastRemoteDisplaySessionResult> {
        final /* synthetic */ CastRemoteDisplayLocalService zzTR;

        C07025(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzTR = castRemoteDisplayLocalService;
        }

        public /* synthetic */ void onResult(Result x0) {
            zza((CastRemoteDisplaySessionResult) x0);
        }

        public void zza(CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
            if (castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                this.zzTR.zzaZ("remote display stopped");
            } else {
                this.zzTR.zzaZ("Unable to stop the remote display, result unsuccessful");
            }
            this.zzTR.zzTK = null;
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.6 */
    class C07036 implements ConnectionCallbacks {
        final /* synthetic */ CastRemoteDisplayLocalService zzTR;

        C07036(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzTR = castRemoteDisplayLocalService;
        }

        public void onConnected(Bundle bundle) {
            this.zzTR.zzaZ("onConnected");
            this.zzTR.zzlP();
        }

        public void onConnectionSuspended(int cause) {
            CastRemoteDisplayLocalService.zzTy.zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[]{this, Integer.valueOf(cause)}), new Object[0]);
        }
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplayLocalService.7 */
    class C07047 implements OnConnectionFailedListener {
        final /* synthetic */ CastRemoteDisplayLocalService zzTR;

        C07047(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzTR = castRemoteDisplayLocalService;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            this.zzTR.zzbc("Connection failed: " + connectionResult);
            this.zzTR.zzlR();
        }
    }

    static {
        zzTy = new zzl("CastRemoteDisplayLocalService");
        zzTz = C0197R.id.cast_notification_id;
        zzTA = new Object();
        zzTB = new AtomicBoolean(false);
    }

    public CastRemoteDisplayLocalService() {
        this.zzTO = new C06991(this);
        this.zzTQ = new zza();
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzTA) {
            castRemoteDisplayLocalService = zzTP;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zzTy.zzW(true);
    }

    public static void startService(Context activityContext, Class<? extends CastRemoteDisplayLocalService> serviceClass, String applicationId, CastDevice device, NotificationSettings notificationSettings, Callbacks callbacks) {
        zzTy.zzb("Starting Service", new Object[0]);
        synchronized (zzTA) {
            if (zzTP != null) {
                zzTy.zzf("An existing service had not been stopped before starting one", new Object[0]);
                zzQ(true);
            }
        }
        zzb(activityContext, (Class) serviceClass);
        zzx.zzb((Object) activityContext, (Object) "activityContext is required.");
        zzx.zzb((Object) serviceClass, (Object) "serviceClass is required.");
        zzx.zzb((Object) applicationId, (Object) "applicationId is required.");
        zzx.zzb((Object) device, (Object) "device is required.");
        zzx.zzb((Object) notificationSettings, (Object) "notificationSettings is required.");
        zzx.zzb((Object) callbacks, (Object) "callbacks is required.");
        if (notificationSettings.mNotification == null && notificationSettings.zzTX == null) {
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        } else if (zzTB.getAndSet(true)) {
            zzTy.zzc("Service is already being started, startService has been called twice", new Object[0]);
        } else {
            Intent intent = new Intent(activityContext, serviceClass);
            activityContext.startService(intent);
            activityContext.bindService(intent, new C02602(applicationId, device, notificationSettings, activityContext, callbacks), 64);
        }
    }

    public static void stopService() {
        zzQ(false);
    }

    private void zzP(boolean z) {
        zzaZ("Stopping Service");
        if (!(z || this.zzTN == null)) {
            zzaZ("Setting default route");
            this.zzTN.selectRoute(this.zzTN.getDefaultRoute());
        }
        if (this.zzTF != null) {
            zzaZ("Unregistering notification receiver");
            unregisterReceiver(this.zzTF);
        }
        zzlS();
        zzlT();
        zzlO();
        if (this.zzTC != null) {
            this.zzTC.disconnect();
            this.zzTC = null;
        }
        if (!(this.zzTL == null || this.zzTM == null)) {
            try {
                this.zzTL.unbindService(this.zzTM);
            } catch (IllegalArgumentException e) {
                zzaZ("No need to unbind service, already unbound");
            }
            this.zzTM = null;
            this.zzTL = null;
        }
        this.zzSX = null;
        this.zzTC = null;
        this.mNotification = null;
        this.zzTK = null;
    }

    private static void zzQ(boolean z) {
        zzTy.zzb("Stopping Service", new Object[0]);
        zzTB.set(false);
        synchronized (zzTA) {
            if (zzTP == null) {
                zzTy.zzc("Service is already being stopped", new Object[0]);
                return;
            }
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzTP;
            zzTP = null;
            castRemoteDisplayLocalService.zzP(z);
        }
    }

    private Notification zzR(boolean z) {
        int i;
        int i2;
        CharSequence string;
        zzaZ("createDefaultNotification");
        int i3 = getApplicationInfo().labelRes;
        CharSequence zzb = this.zzTG.zzTY;
        CharSequence zzc = this.zzTG.zzTZ;
        if (z) {
            i = C0197R.string.cast_notification_connected_message;
            i2 = C0197R.drawable.cast_ic_notification_on;
        } else {
            i = C0197R.string.cast_notification_connecting_message;
            i2 = C0197R.drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(zzb)) {
            zzb = getString(i3);
        }
        if (TextUtils.isEmpty(zzc)) {
            string = getString(i, new Object[]{this.zzTJ.getFriendlyName()});
        } else {
            string = zzc;
        }
        return new Builder(this).setContentTitle(zzb).setContentText(string).setContentIntent(this.zzTG.zzTX).setSmallIcon(i2).setOngoing(true).addAction(17301560, getString(C0197R.string.cast_notification_disconnect), zzlU()).build();
    }

    private GoogleApiClient zza(CastDevice castDevice) {
        return new GoogleApiClient.Builder(this, new C07036(this), new C07047(this)).addApi(CastRemoteDisplay.API, new CastRemoteDisplayOptions.Builder(castDevice, this.zzTD).build()).build();
    }

    private void zza(Display display) {
        this.zzTK = display;
        if (this.zzTH.booleanValue()) {
            this.mNotification = zzR(true);
            startForeground(zzTz, this.mNotification);
        }
        if (this.zzTE != null) {
            this.zzTE.onRemoteDisplaySessionStarted(this);
            this.zzTE = null;
        }
        onCreatePresentation(this.zzTK);
    }

    private boolean zza(String str, CastDevice castDevice, NotificationSettings notificationSettings, Context context, ServiceConnection serviceConnection, Callbacks callbacks) {
        zzaZ("startRemoteDisplaySession");
        zzx.zzch("Starting the Cast Remote Display must be done on the main thread");
        synchronized (zzTA) {
            if (zzTP != null) {
                zzTy.zzf("An existing service had not been stopped before starting one", new Object[0]);
                return false;
            }
            zzTP = this;
            this.zzTE = callbacks;
            this.zzSX = str;
            this.zzTJ = castDevice;
            this.zzTL = context;
            this.zzTM = serviceConnection;
            this.zzTN = MediaRouter.getInstance(getApplicationContext());
            MediaRouteSelector build = new MediaRouteSelector.Builder().addControlCategory(CastMediaControlIntent.categoryForCast(this.zzSX)).build();
            zzaZ("addMediaRouterCallback");
            this.zzTN.addCallback(build, this.zzTO, 4);
            this.mHandler = new Handler(getMainLooper());
            this.mNotification = notificationSettings.mNotification;
            this.zzTF = new zzb();
            registerReceiver(this.zzTF, new IntentFilter("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"));
            this.zzTG = new NotificationSettings(null);
            if (this.zzTG.mNotification == null) {
                this.zzTH = Boolean.valueOf(true);
                this.mNotification = zzR(false);
            } else {
                this.zzTH = Boolean.valueOf(false);
                this.mNotification = this.zzTG.mNotification;
            }
            startForeground(zzTz, this.mNotification);
            this.zzTC = zza(castDevice);
            this.zzTC.connect();
            return true;
        }
    }

    private void zzaZ(String str) {
        zzTy.zzb("[Instance: %s] %s", this, str);
    }

    private static void zzb(Context context, Class cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), Barcode.ITF);
            if (serviceInfo != null && serviceInfo.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
    }

    private void zzbc(String str) {
        zzTy.zzc("[Instance: %s] %s", this, str);
    }

    private void zzlO() {
        if (this.zzTN != null) {
            zzx.zzch("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzaZ("removeMediaRouterCallback");
            this.zzTN.removeCallback(this.zzTO);
        }
    }

    private void zzlP() {
        zzaZ("startRemoteDisplay");
        if (this.zzTC == null || !this.zzTC.isConnected()) {
            zzTy.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(this.zzTC, this.zzSX).setResultCallback(new C07014(this));
        }
    }

    private void zzlQ() {
        zzaZ("stopRemoteDisplay");
        if (this.zzTC == null || !this.zzTC.isConnected()) {
            zzTy.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(this.zzTC).setResultCallback(new C07025(this));
        }
    }

    private void zzlR() {
        if (this.zzTE != null) {
            this.zzTE.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
            this.zzTE = null;
        }
        stopService();
    }

    private void zzlS() {
        zzaZ("stopRemoteDisplaySession");
        zzlQ();
        onDismissPresentation();
    }

    private void zzlT() {
        zzaZ("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
    }

    private PendingIntent zzlU() {
        if (this.zzTI == null) {
            this.zzTI = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), DriveFile.MODE_READ_ONLY);
        }
        return this.zzTI;
    }

    protected Display getDisplay() {
        return this.zzTK;
    }

    public IBinder onBind(Intent intent) {
        zzaZ("onBind");
        return this.zzTQ;
    }

    public void onCreate() {
        super.onCreate();
        this.zzTD = new C07003(this);
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    public int onStartCommand(Intent intent, int flags, int startId) {
        zzaZ("onStartCommand");
        return 2;
    }

    public void updateNotificationSettings(NotificationSettings notificationSettings) {
        zzx.zzb((Object) notificationSettings, (Object) "notificationSettings is required.");
        if (this.zzTG == null) {
            throw new IllegalStateException("No current notification settings to update");
        }
        if (!this.zzTH.booleanValue()) {
            zzx.zzb(notificationSettings.mNotification, (Object) "notification is required.");
            this.mNotification = notificationSettings.mNotification;
            this.zzTG.mNotification = this.mNotification;
        } else if (notificationSettings.mNotification != null) {
            throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
        } else {
            if (notificationSettings.zzTX != null) {
                this.zzTG.zzTX = notificationSettings.zzTX;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzTY)) {
                this.zzTG.zzTY = notificationSettings.zzTY;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzTZ)) {
                this.zzTG.zzTZ = notificationSettings.zzTZ;
            }
            this.mNotification = zzR(true);
        }
        startForeground(zzTz, this.mNotification);
    }
}
