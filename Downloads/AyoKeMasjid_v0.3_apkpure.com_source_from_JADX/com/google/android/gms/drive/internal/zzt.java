package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzg;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.internal.zzs.zza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzt extends zzj<zzal> {
    private final String zzQl;
    final ConnectionCallbacks zzadB;
    private final Bundle zzaip;
    private final boolean zzaiq;
    private DriveId zzair;
    private DriveId zzais;
    final Map<DriveId, Map<ChangeListener, zzad>> zzait;
    final Map<zzc, zzad> zzaiu;
    final Map<DriveId, Map<zzi, zzad>> zzaiv;
    final Map<DriveId, Map<zzi, zzad>> zzaiw;

    /* renamed from: com.google.android.gms.drive.internal.zzt.1 */
    class C12741 extends zza {
        final /* synthetic */ zzad zzaiA;
        final /* synthetic */ zzt zzaiB;
        final /* synthetic */ DriveId zzaix;
        final /* synthetic */ int zzaiy;
        final /* synthetic */ ChangesAvailableOptions zzaiz;

        C12741(zzt com_google_android_gms_drive_internal_zzt, GoogleApiClient googleApiClient, DriveId driveId, int i, ChangesAvailableOptions changesAvailableOptions, zzad com_google_android_gms_drive_internal_zzad) {
            this.zzaiB = com_google_android_gms_drive_internal_zzt;
            this.zzaix = driveId;
            this.zzaiy = i;
            this.zzaiz = changesAvailableOptions;
            this.zzaiA = com_google_android_gms_drive_internal_zzad;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new AddEventListenerRequest(this.zzaix, this.zzaiy, this.zzaiz), this.zzaiA, null, new zzbr(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzt.2 */
    class C12752 extends zza {
        final /* synthetic */ zzad zzaiA;
        final /* synthetic */ zzt zzaiB;
        final /* synthetic */ DriveId zzaix;
        final /* synthetic */ int zzaiy;

        C12752(zzt com_google_android_gms_drive_internal_zzt, GoogleApiClient googleApiClient, DriveId driveId, int i, zzad com_google_android_gms_drive_internal_zzad) {
            this.zzaiB = com_google_android_gms_drive_internal_zzt;
            this.zzaix = driveId;
            this.zzaiy = i;
            this.zzaiA = com_google_android_gms_drive_internal_zzad;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new RemoveEventListenerRequest(this.zzaix, this.zzaiy), this.zzaiA, null, new zzbr(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzt.3 */
    class C12763 extends zza {
        final /* synthetic */ zzt zzaiB;
        final /* synthetic */ DriveId zzaix;
        final /* synthetic */ int zzaiy;
        final /* synthetic */ ChangesAvailableOptions zzaiz;

        C12763(zzt com_google_android_gms_drive_internal_zzt, GoogleApiClient googleApiClient, DriveId driveId, int i, ChangesAvailableOptions changesAvailableOptions) {
            this.zzaiB = com_google_android_gms_drive_internal_zzt;
            this.zzaix = driveId;
            this.zzaiy = i;
            this.zzaiz = changesAvailableOptions;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new AddEventListenerRequest(this.zzaix, this.zzaiy, this.zzaiz), null, null, new zzbr(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzt.4 */
    class C12774 extends zza {
        final /* synthetic */ zzt zzaiB;
        final /* synthetic */ DriveId zzaix;
        final /* synthetic */ int zzaiy;

        C12774(zzt com_google_android_gms_drive_internal_zzt, GoogleApiClient googleApiClient, DriveId driveId, int i) {
            this.zzaiB = com_google_android_gms_drive_internal_zzt;
            this.zzaix = driveId;
            this.zzaiy = i;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new RemoveEventListenerRequest(this.zzaix, this.zzaiy), null, null, new zzbr(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzt.5 */
    class C12785 extends zza {
        final /* synthetic */ zzt zzaiB;
        final /* synthetic */ List zzaiC;

        C12785(zzt com_google_android_gms_drive_internal_zzt, GoogleApiClient googleApiClient, List list) {
            this.zzaiB = com_google_android_gms_drive_internal_zzt;
            this.zzaiC = list;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new CancelPendingActionsRequest(this.zzaiC), new zzbr(this));
        }
    }

    public zzt(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzait = new HashMap();
        this.zzaiu = new HashMap();
        this.zzaiv = new HashMap();
        this.zzaiw = new HashMap();
        this.zzQl = com_google_android_gms_common_internal_zzf.zzol();
        this.zzadB = connectionCallbacks;
        this.zzaip = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                this.zzaiq = false;
            case CompletionEvent.STATUS_FAILURE /*1*/:
                ServiceInfo serviceInfo = ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
                if (serviceInfo.exported) {
                    this.zzaiq = true;
                    return;
                }
                throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId) {
        zzx.zzb(zzg.zza(i, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        return googleApiClient.zzb(new C12774(this, googleApiClient, driveId, i));
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId, ChangesAvailableOptions changesAvailableOptions) {
        zzx.zzb(zzg.zza(i, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        if (this.zzaiq) {
            return googleApiClient.zzb(new C12763(this, googleApiClient, driveId, i, changesAvailableOptions));
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId, zzad com_google_android_gms_drive_internal_zzad) {
        return googleApiClient.zzb(new C12752(this, googleApiClient, driveId, i, com_google_android_gms_drive_internal_zzad));
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId, zzad com_google_android_gms_drive_internal_zzad, ChangesAvailableOptions changesAvailableOptions) {
        return googleApiClient.zzb(new C12741(this, googleApiClient, driveId, i, changesAvailableOptions, com_google_android_gms_drive_internal_zzad));
    }

    PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, List<String> pendingTags) {
        boolean z = true;
        zzx.zzZ(pendingTags != null);
        if (pendingTags.isEmpty()) {
            z = false;
        }
        zzx.zzZ(z);
        zzx.zza(isConnected(), (Object) "Client must be connected");
        return apiClient.zzb(new C12785(this, apiClient, pendingTags));
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzal) zzoA()).zza(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        synchronized (this.zzait) {
            this.zzait.clear();
        }
        synchronized (this.zzaiu) {
            this.zzaiu.clear();
        }
        synchronized (this.zzaiv) {
            this.zzaiv.clear();
        }
        synchronized (this.zzaiw) {
            this.zzaiw.clear();
        }
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzaR(iBinder);
    }

    PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId, null);
    }

    PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> com_google_android_gms_drive_internal_zzr_zzj;
        zzx.zzb(zzg.zza(1, driveId), (Object) "id");
        zzx.zzb((Object) changeListener, (Object) "listener");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        synchronized (this.zzait) {
            Map map;
            zzad com_google_android_gms_drive_internal_zzad;
            Map map2 = (Map) this.zzait.get(driveId);
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.zzait.put(driveId, hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            zzad com_google_android_gms_drive_internal_zzad2 = (zzad) map.get(changeListener);
            if (com_google_android_gms_drive_internal_zzad2 == null) {
                com_google_android_gms_drive_internal_zzad = new zzad(getLooper(), getContext(), 1, changeListener);
                map.put(changeListener, com_google_android_gms_drive_internal_zzad);
            } else if (com_google_android_gms_drive_internal_zzad2.zzcK(1)) {
                com_google_android_gms_drive_internal_zzr_zzj = new zzj(googleApiClient, Status.zzaaD);
            } else {
                com_google_android_gms_drive_internal_zzad = com_google_android_gms_drive_internal_zzad2;
            }
            com_google_android_gms_drive_internal_zzad.zzcJ(1);
            com_google_android_gms_drive_internal_zzr_zzj = zza(googleApiClient, 1, driveId, com_google_android_gms_drive_internal_zzad, null);
        }
        return com_google_android_gms_drive_internal_zzr_zzj;
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzair = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.zzais = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    protected zzal zzaR(IBinder iBinder) {
        return zzal.zza.zzaS(iBinder);
    }

    PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId);
    }

    PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> com_google_android_gms_drive_internal_zzr_zzj;
        zzx.zzb(zzg.zza(1, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        zzx.zzb((Object) changeListener, (Object) "listener");
        synchronized (this.zzait) {
            Map map = (Map) this.zzait.get(driveId);
            if (map == null) {
                com_google_android_gms_drive_internal_zzr_zzj = new zzj(googleApiClient, Status.zzaaD);
            } else {
                zzad com_google_android_gms_drive_internal_zzad = (zzad) map.remove(changeListener);
                if (com_google_android_gms_drive_internal_zzad == null) {
                    com_google_android_gms_drive_internal_zzr_zzj = new zzj(googleApiClient, Status.zzaaD);
                } else {
                    if (map.isEmpty()) {
                        this.zzait.remove(driveId);
                    }
                    com_google_android_gms_drive_internal_zzr_zzj = zza(googleApiClient, 1, driveId, com_google_android_gms_drive_internal_zzad);
                }
            }
        }
        return com_google_android_gms_drive_internal_zzr_zzj;
    }

    protected String zzfA() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    protected Bundle zzli() {
        String packageName = getContext().getPackageName();
        zzx.zzv(packageName);
        zzx.zzY(!zzoy().zzoj().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.zzQl)) {
            bundle.putString("proxy_package_name", this.zzQl);
        }
        bundle.putAll(this.zzaip);
        return bundle;
    }

    public boolean zzlm() {
        return (getContext().getPackageName().equals(this.zzQl) && zzqE()) ? false : true;
    }

    public boolean zzoC() {
        return true;
    }

    boolean zzqE() {
        return GooglePlayServicesUtil.zze(getContext(), Process.myUid());
    }

    public zzal zzqF() throws DeadObjectException {
        return (zzal) zzoA();
    }

    public DriveId zzqG() {
        return this.zzair;
    }

    public DriveId zzqH() {
        return this.zzais;
    }

    public boolean zzqI() {
        return this.zzaiq;
    }
}
