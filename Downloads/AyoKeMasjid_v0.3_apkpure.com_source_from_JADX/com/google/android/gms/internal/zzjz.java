package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zza;

abstract class zzjz extends zza<ProxyResult, zzjw> {
    public zzjz(GoogleApiClient googleApiClient) {
        super(Auth.zzQL, googleApiClient);
    }

    protected abstract void zza(Context context, zzjy com_google_android_gms_internal_zzjy) throws RemoteException;

    protected final void zza(zzjw com_google_android_gms_internal_zzjw) throws RemoteException {
        zza(com_google_android_gms_internal_zzjw.getContext(), (zzjy) com_google_android_gms_internal_zzjw.zzoA());
    }

    protected /* synthetic */ Result zzb(Status status) {
        return zzo(status);
    }

    protected ProxyResult zzo(Status status) {
        return new zzkb(status);
    }
}
