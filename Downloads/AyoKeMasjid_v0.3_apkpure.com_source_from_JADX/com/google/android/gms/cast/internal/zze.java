package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.location.places.Place;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zze extends zzj<zzi> {
    private static final zzl zzTy;
    private static final Object zzXf;
    private static final Object zzXg;
    private final Listener zzTk;
    private double zzUJ;
    private boolean zzUK;
    private ApplicationMetadata zzWN;
    private final CastDevice zzWO;
    private final Map<String, MessageReceivedCallback> zzWP;
    private final long zzWQ;
    private zzb zzWR;
    private String zzWS;
    private boolean zzWT;
    private boolean zzWU;
    private boolean zzWV;
    private int zzWW;
    private int zzWX;
    private final AtomicLong zzWY;
    private String zzWZ;
    private String zzXa;
    private Bundle zzXb;
    private final Map<Long, com.google.android.gms.common.api.zzc.zzb<Status>> zzXc;
    private com.google.android.gms.common.api.zzc.zzb<ApplicationConnectionResult> zzXd;
    private com.google.android.gms.common.api.zzc.zzb<Status> zzXe;

    private static final class zza implements ApplicationConnectionResult {
        private final String zzGY;
        private final Status zzQA;
        private final ApplicationMetadata zzXh;
        private final String zzXi;
        private final boolean zzXj;

        public zza(Status status) {
            this(status, null, null, null, false);
        }

        public zza(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.zzQA = status;
            this.zzXh = applicationMetadata;
            this.zzXi = str;
            this.zzGY = str2;
            this.zzXj = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.zzXh;
        }

        public String getApplicationStatus() {
            return this.zzXi;
        }

        public String getSessionId() {
            return this.zzGY;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public boolean getWasLaunched() {
            return this.zzXj;
        }
    }

    private static class zzb extends com.google.android.gms.cast.internal.zzj.zza {
        private final Handler mHandler;
        private final AtomicReference<zze> zzXk;

        /* renamed from: com.google.android.gms.cast.internal.zze.zzb.1 */
        class C02651 implements Runnable {
            final /* synthetic */ zze zzXl;
            final /* synthetic */ int zzXm;
            final /* synthetic */ zzb zzXn;

            C02651(zzb com_google_android_gms_cast_internal_zze_zzb, zze com_google_android_gms_cast_internal_zze, int i) {
                this.zzXn = com_google_android_gms_cast_internal_zze_zzb;
                this.zzXl = com_google_android_gms_cast_internal_zze;
                this.zzXm = i;
            }

            public void run() {
                if (this.zzXl.zzTk != null) {
                    this.zzXl.zzTk.onApplicationDisconnected(this.zzXm);
                }
            }
        }

        /* renamed from: com.google.android.gms.cast.internal.zze.zzb.2 */
        class C02662 implements Runnable {
            final /* synthetic */ zze zzXl;
            final /* synthetic */ zzb zzXn;
            final /* synthetic */ DeviceStatus zzXo;

            C02662(zzb com_google_android_gms_cast_internal_zze_zzb, zze com_google_android_gms_cast_internal_zze, DeviceStatus deviceStatus) {
                this.zzXn = com_google_android_gms_cast_internal_zze_zzb;
                this.zzXl = com_google_android_gms_cast_internal_zze;
                this.zzXo = deviceStatus;
            }

            public void run() {
                this.zzXl.zza(this.zzXo);
            }
        }

        /* renamed from: com.google.android.gms.cast.internal.zze.zzb.3 */
        class C02673 implements Runnable {
            final /* synthetic */ zze zzXl;
            final /* synthetic */ zzb zzXn;
            final /* synthetic */ ApplicationStatus zzXp;

            C02673(zzb com_google_android_gms_cast_internal_zze_zzb, zze com_google_android_gms_cast_internal_zze, ApplicationStatus applicationStatus) {
                this.zzXn = com_google_android_gms_cast_internal_zze_zzb;
                this.zzXl = com_google_android_gms_cast_internal_zze;
                this.zzXp = applicationStatus;
            }

            public void run() {
                this.zzXl.zza(this.zzXp);
            }
        }

        /* renamed from: com.google.android.gms.cast.internal.zze.zzb.4 */
        class C02684 implements Runnable {
            final /* synthetic */ String zzTb;
            final /* synthetic */ zze zzXl;
            final /* synthetic */ zzb zzXn;
            final /* synthetic */ String zzXq;

            C02684(zzb com_google_android_gms_cast_internal_zze_zzb, zze com_google_android_gms_cast_internal_zze, String str, String str2) {
                this.zzXn = com_google_android_gms_cast_internal_zze_zzb;
                this.zzXl = com_google_android_gms_cast_internal_zze;
                this.zzTb = str;
                this.zzXq = str2;
            }

            public void run() {
                synchronized (this.zzXl.zzWP) {
                    MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.zzXl.zzWP.get(this.zzTb);
                }
                if (messageReceivedCallback != null) {
                    messageReceivedCallback.onMessageReceived(this.zzXl.zzWO, this.zzTb, this.zzXq);
                    return;
                }
                zze.zzTy.zzb("Discarded message for unknown namespace '%s'", this.zzTb);
            }
        }

        public zzb(zze com_google_android_gms_cast_internal_zze) {
            this.zzXk = new AtomicReference(com_google_android_gms_cast_internal_zze);
            this.mHandler = new Handler(com_google_android_gms_cast_internal_zze.getLooper());
        }

        private void zza(zze com_google_android_gms_cast_internal_zze, long j, int i) {
            synchronized (com_google_android_gms_cast_internal_zze.zzXc) {
                com.google.android.gms.common.api.zzc.zzb com_google_android_gms_common_api_zzc_zzb = (com.google.android.gms.common.api.zzc.zzb) com_google_android_gms_cast_internal_zze.zzXc.remove(Long.valueOf(j));
            }
            if (com_google_android_gms_common_api_zzc_zzb != null) {
                com_google_android_gms_common_api_zzc_zzb.zzn(new Status(i));
            }
        }

        private boolean zza(zze com_google_android_gms_cast_internal_zze, int i) {
            synchronized (zze.zzXg) {
                if (com_google_android_gms_cast_internal_zze.zzXe != null) {
                    com_google_android_gms_cast_internal_zze.zzXe.zzn(new Status(i));
                    com_google_android_gms_cast_internal_zze.zzXe = null;
                    return true;
                }
                return false;
            }
        }

        public boolean isDisposed() {
            return this.zzXk.get() == null;
        }

        public void onApplicationDisconnected(int statusCode) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzXk.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                com_google_android_gms_cast_internal_zze.zzWZ = null;
                com_google_android_gms_cast_internal_zze.zzXa = null;
                zza(com_google_android_gms_cast_internal_zze, statusCode);
                if (com_google_android_gms_cast_internal_zze.zzTk != null) {
                    this.mHandler.post(new C02651(this, com_google_android_gms_cast_internal_zze, statusCode));
                }
            }
        }

        public void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzXk.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                com_google_android_gms_cast_internal_zze.zzWN = applicationMetadata;
                com_google_android_gms_cast_internal_zze.zzWZ = applicationMetadata.getApplicationId();
                com_google_android_gms_cast_internal_zze.zzXa = str2;
                synchronized (zze.zzXf) {
                    if (com_google_android_gms_cast_internal_zze.zzXd != null) {
                        com_google_android_gms_cast_internal_zze.zzXd.zzn(new zza(new Status(0), applicationMetadata, str, str2, z));
                        com_google_android_gms_cast_internal_zze.zzXd = null;
                    }
                }
            }
        }

        public void zza(String str, double d, boolean z) {
            zze.zzTy.zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void zza(String str, long j, int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzXk.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, j, i);
            }
        }

        public void zzaU(int i) {
            zze zzmG = zzmG();
            if (zzmG != null) {
                zze.zzTy.zzb("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
                if (i != 0) {
                    zzmG.zzbz(2);
                }
            }
        }

        public void zzaV(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzXk.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                synchronized (zze.zzXf) {
                    if (com_google_android_gms_cast_internal_zze.zzXd != null) {
                        com_google_android_gms_cast_internal_zze.zzXd.zzn(new zza(new Status(i)));
                        com_google_android_gms_cast_internal_zze.zzXd = null;
                    }
                }
            }
        }

        public void zzaW(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzXk.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, i);
            }
        }

        public void zzaX(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzXk.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, i);
            }
        }

        public void zzb(ApplicationStatus applicationStatus) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzXk.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.zzTy.zzb("onApplicationStatusChanged", new Object[0]);
                this.mHandler.post(new C02673(this, com_google_android_gms_cast_internal_zze, applicationStatus));
            }
        }

        public void zzb(DeviceStatus deviceStatus) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzXk.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.zzTy.zzb("onDeviceStatusChanged", new Object[0]);
                this.mHandler.post(new C02662(this, com_google_android_gms_cast_internal_zze, deviceStatus));
            }
        }

        public void zzb(String str, byte[] bArr) {
            if (((zze) this.zzXk.get()) != null) {
                zze.zzTy.zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
            }
        }

        public void zzd(String str, long j) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzXk.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, j, 0);
            }
        }

        public zze zzmG() {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzXk.getAndSet(null);
            if (com_google_android_gms_cast_internal_zze == null) {
                return null;
            }
            com_google_android_gms_cast_internal_zze.zzmv();
            return com_google_android_gms_cast_internal_zze;
        }

        public void zzs(String str, String str2) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzXk.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.zzTy.zzb("Receive (type=text, ns=%s) %s", str, str2);
                this.mHandler.post(new C02684(this, com_google_android_gms_cast_internal_zze, str, str2));
            }
        }
    }

    static {
        zzTy = new zzl("CastClientImpl");
        zzXf = new Object();
        zzXg = new Object();
    }

    public zze(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzWO = castDevice;
        this.zzTk = listener;
        this.zzWQ = j;
        this.zzWP = new HashMap();
        this.zzWY = new AtomicLong(0);
        this.zzXc = new HashMap();
        zzmv();
    }

    private void zza(ApplicationStatus applicationStatus) {
        boolean z;
        String zzms = applicationStatus.zzms();
        if (zzf.zza(zzms, this.zzWS)) {
            z = false;
        } else {
            this.zzWS = zzms;
            z = true;
        }
        zzTy.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzWT));
        if (this.zzTk != null && (z || this.zzWT)) {
            this.zzTk.onApplicationStatusChanged();
        }
        this.zzWT = false;
    }

    private void zza(DeviceStatus deviceStatus) {
        boolean z;
        ApplicationMetadata applicationMetadata = deviceStatus.getApplicationMetadata();
        if (!zzf.zza(applicationMetadata, this.zzWN)) {
            this.zzWN = applicationMetadata;
            this.zzTk.onApplicationMetadataChanged(this.zzWN);
        }
        double zzmy = deviceStatus.zzmy();
        if (zzmy == Double.NaN || Math.abs(zzmy - this.zzUJ) <= 1.0E-7d) {
            z = false;
        } else {
            this.zzUJ = zzmy;
            z = true;
        }
        boolean zzmH = deviceStatus.zzmH();
        if (zzmH != this.zzUK) {
            this.zzUK = zzmH;
            z = true;
        }
        zzTy.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzWU));
        if (this.zzTk != null && (z || this.zzWU)) {
            this.zzTk.onVolumeChanged();
        }
        int zzmz = deviceStatus.zzmz();
        if (zzmz != this.zzWW) {
            this.zzWW = zzmz;
            z = true;
        } else {
            z = false;
        }
        zzTy.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzWU));
        if (this.zzTk != null && (z || this.zzWU)) {
            this.zzTk.onActiveInputStateChanged(this.zzWW);
        }
        zzmz = deviceStatus.zzmA();
        if (zzmz != this.zzWX) {
            this.zzWX = zzmz;
            z = true;
        } else {
            z = false;
        }
        zzTy.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzWU));
        if (this.zzTk != null && (z || this.zzWU)) {
            this.zzTk.onStandbyStateChanged(this.zzWX);
        }
        this.zzWU = false;
    }

    private void zzc(com.google.android.gms.common.api.zzc.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) {
        synchronized (zzXf) {
            if (this.zzXd != null) {
                this.zzXd.zzn(new zza(new Status(GamesStatusCodes.STATUS_REQUEST_TOO_MANY_RECIPIENTS)));
            }
            this.zzXd = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult;
        }
    }

    private void zze(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
        synchronized (zzXg) {
            if (this.zzXe != null) {
                com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status.zzn(new Status(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE));
                return;
            }
            this.zzXe = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status;
        }
    }

    private void zzmB() {
        zzTy.zzb("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zzWP) {
            this.zzWP.clear();
        }
    }

    private void zzmC() throws IllegalStateException {
        if (!this.zzWV || this.zzWR == null || this.zzWR.isDisposed()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    private void zzmv() {
        this.zzWV = false;
        this.zzWW = -1;
        this.zzWX = -1;
        this.zzWN = null;
        this.zzWS = null;
        this.zzUJ = 0.0d;
        this.zzUK = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnect() {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = zzTy;
        r1 = "disconnect(); ServiceListener=%s, isConnected=%b";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = r6.zzWR;
        r2[r4] = r3;
        r3 = r6.isConnected();
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r5] = r3;
        r0.zzb(r1, r2);
        r0 = r6.zzWR;
        r1 = 0;
        r6.zzWR = r1;
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r0 = r0.zzmG();
        if (r0 != 0) goto L_0x0031;
    L_0x0027:
        r0 = zzTy;
        r1 = "already disposed, so short-circuiting";
        r2 = new java.lang.Object[r4];
        r0.zzb(r1, r2);
    L_0x0030:
        return;
    L_0x0031:
        r6.zzmB();
        r0 = r6.isConnected();	 Catch:{ RemoteException -> 0x004d }
        if (r0 != 0) goto L_0x0040;
    L_0x003a:
        r0 = r6.isConnecting();	 Catch:{ RemoteException -> 0x004d }
        if (r0 == 0) goto L_0x0049;
    L_0x0040:
        r0 = r6.zzoA();	 Catch:{ RemoteException -> 0x004d }
        r0 = (com.google.android.gms.cast.internal.zzi) r0;	 Catch:{ RemoteException -> 0x004d }
        r0.disconnect();	 Catch:{ RemoteException -> 0x004d }
    L_0x0049:
        super.disconnect();
        goto L_0x0030;
    L_0x004d:
        r0 = move-exception;
        r1 = zzTy;	 Catch:{ all -> 0x0063 }
        r2 = "Error while disconnecting the controller interface: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0063 }
        r4 = 0;
        r5 = r0.getMessage();	 Catch:{ all -> 0x0063 }
        r3[r4] = r5;	 Catch:{ all -> 0x0063 }
        r1.zzb(r0, r2, r3);	 Catch:{ all -> 0x0063 }
        super.disconnect();
        goto L_0x0030;
    L_0x0063:
        r0 = move-exception;
        super.disconnect();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.zze.disconnect():void");
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        zzmC();
        return this.zzWN;
    }

    public String getApplicationStatus() throws IllegalStateException {
        zzmC();
        return this.zzWS;
    }

    public boolean isMute() throws IllegalStateException {
        zzmC();
        return this.zzUK;
    }

    public void onConnectionFailed(ConnectionResult result) {
        super.onConnectionFailed(result);
        zzmB();
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzaA(iBinder);
    }

    public void zzV(boolean z) throws IllegalStateException, RemoteException {
        ((zzi) zzoA()).zza(z, this.zzUJ, this.zzUK);
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        zzTy.zzb("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_1) {
            this.zzWV = true;
            this.zzWT = true;
            this.zzWU = true;
        } else {
            this.zzWV = false;
        }
        if (i == Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_1) {
            this.zzXb = new Bundle();
            this.zzXb.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        zzf.zzbL(str);
        zzbK(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zzWP) {
                this.zzWP.put(str, messageReceivedCallback);
            }
            ((zzi) zzoA()).zzbP(str);
        }
    }

    public void zza(String str, LaunchOptions launchOptions, com.google.android.gms.common.api.zzc.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.common.api.zzc.zzb) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzi) zzoA()).zza(str, launchOptions);
    }

    public void zza(String str, com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) throws IllegalStateException, RemoteException {
        zze((com.google.android.gms.common.api.zzc.zzb) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
        ((zzi) zzoA()).zzbO(str);
    }

    public void zza(String str, String str2, com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            zzf.zzbL(str);
            zzmC();
            long incrementAndGet = this.zzWY.incrementAndGet();
            try {
                this.zzXc.put(Long.valueOf(incrementAndGet), com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
                ((zzi) zzoA()).zza(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.zzXc.remove(Long.valueOf(incrementAndGet));
            }
        }
    }

    public void zza(String str, boolean z, com.google.android.gms.common.api.zzc.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.common.api.zzc.zzb) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzi) zzoA()).zzf(str, z);
    }

    protected zzi zzaA(IBinder iBinder) {
        return com.google.android.gms.cast.internal.zzi.zza.zzaB(iBinder);
    }

    public void zzb(String str, String str2, com.google.android.gms.common.api.zzc.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.common.api.zzc.zzb) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzi) zzoA()).zzt(str, str2);
    }

    public void zzbK(String str) throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zzWP) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.zzWP.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((zzi) zzoA()).zzbQ(str);
            } catch (Throwable e) {
                zzTy.zzb(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void zzd(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) throws IllegalStateException, RemoteException {
        zze((com.google.android.gms.common.api.zzc.zzb) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
        ((zzi) zzoA()).zzmI();
    }

    public void zze(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((zzi) zzoA()).zza(d, this.zzUJ, this.zzUK);
    }

    protected String zzfA() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String zzfB() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    protected Bundle zzli() {
        Bundle bundle = new Bundle();
        zzTy.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzWZ, this.zzXa);
        this.zzWO.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzWQ);
        this.zzWR = new zzb(this);
        bundle.putParcelable("listener", new BinderWrapper(this.zzWR.asBinder()));
        if (this.zzWZ != null) {
            bundle.putString("last_application_id", this.zzWZ);
            if (this.zzXa != null) {
                bundle.putString("last_session_id", this.zzXa);
            }
        }
        return bundle;
    }

    public int zzmA() throws IllegalStateException {
        zzmC();
        return this.zzWX;
    }

    public Bundle zzmw() {
        if (this.zzXb == null) {
            return super.zzmw();
        }
        Bundle bundle = this.zzXb;
        this.zzXb = null;
        return bundle;
    }

    public void zzmx() throws IllegalStateException, RemoteException {
        ((zzi) zzoA()).zzmx();
    }

    public double zzmy() throws IllegalStateException {
        zzmC();
        return this.zzUJ;
    }

    public int zzmz() throws IllegalStateException {
        zzmC();
        return this.zzWW;
    }
}
