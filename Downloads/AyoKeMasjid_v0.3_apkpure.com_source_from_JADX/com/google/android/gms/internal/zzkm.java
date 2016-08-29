package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzkp.zza;

public class zzkm extends zzj<zzko> implements DeathRecipient {
    private static final zzl zzTy;
    private CastDevice zzTj;
    private CastRemoteDisplaySessionCallbacks zzYd;

    /* renamed from: com.google.android.gms.internal.zzkm.1 */
    class C11461 extends zza {
        final /* synthetic */ zzkp zzYe;
        final /* synthetic */ zzkm zzYf;

        C11461(zzkm com_google_android_gms_internal_zzkm, zzkp com_google_android_gms_internal_zzkp) {
            this.zzYf = com_google_android_gms_internal_zzkm;
            this.zzYe = com_google_android_gms_internal_zzkp;
        }

        public void zzaZ(int i) throws RemoteException {
            zzkm.zzTy.zzb("onRemoteDisplayEnded", new Object[0]);
            if (this.zzYe != null) {
                this.zzYe.zzaZ(i);
            }
            if (this.zzYf.zzYd != null) {
                this.zzYf.zzYd.onRemoteDisplayEnded(new Status(i));
            }
        }
    }

    static {
        zzTy = new zzl("CastRemoteDisplayClientImpl");
    }

    public zzkm(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastDevice castDevice, CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 83, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        zzTy.zzb("instance created", new Object[0]);
        this.zzYd = castRemoteDisplaySessionCallbacks;
        this.zzTj = castDevice;
    }

    public void binderDied() {
    }

    public void disconnect() {
        zzTy.zzb("disconnect", new Object[0]);
        this.zzYd = null;
        this.zzTj = null;
        try {
            ((zzko) zzoA()).disconnect();
        } catch (RemoteException e) {
        } finally {
            super.disconnect();
        }
    }

    public /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzaC(iBinder);
    }

    public void zza(zzkn com_google_android_gms_internal_zzkn) throws RemoteException {
        zzTy.zzb("stopRemoteDisplay", new Object[0]);
        ((zzko) zzoA()).zza(com_google_android_gms_internal_zzkn);
    }

    public void zza(zzkn com_google_android_gms_internal_zzkn, int i) throws RemoteException {
        ((zzko) zzoA()).zza(com_google_android_gms_internal_zzkn, i);
    }

    public void zza(zzkn com_google_android_gms_internal_zzkn, zzkp com_google_android_gms_internal_zzkp, String str) throws RemoteException {
        zzTy.zzb("startRemoteDisplay", new Object[0]);
        ((zzko) zzoA()).zza(com_google_android_gms_internal_zzkn, new C11461(this, com_google_android_gms_internal_zzkp), this.zzTj.getDeviceId(), str);
    }

    public zzko zzaC(IBinder iBinder) {
        return zzko.zza.zzaE(iBinder);
    }

    protected String zzfA() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }
}
