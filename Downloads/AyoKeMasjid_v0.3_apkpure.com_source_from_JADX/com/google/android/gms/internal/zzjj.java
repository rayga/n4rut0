package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzjl.zza;

public class zzjj extends zzj<zzjl> {
    private final String zzQl;

    public zzjj(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 77, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzQl = com_google_android_gms_common_internal_zzf.zzol();
    }

    private Bundle zzlj() {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", this.zzQl);
        return bundle;
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzai(iBinder);
    }

    public void zza(zzjk com_google_android_gms_internal_zzjk, String str) {
        try {
            ((zzjl) zzoA()).zza(com_google_android_gms_internal_zzjk, str);
        } catch (RemoteException e) {
        }
    }

    protected zzjl zzai(IBinder iBinder) {
        return zza.zzak(iBinder);
    }

    public void zzb(zzjk com_google_android_gms_internal_zzjk, String str) {
        try {
            ((zzjl) zzoA()).zzb(com_google_android_gms_internal_zzjk, str);
        } catch (RemoteException e) {
        }
    }

    protected String zzfA() {
        return "com.google.android.gms.appinvite.service.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    protected Bundle zzli() {
        return zzlj();
    }
}
