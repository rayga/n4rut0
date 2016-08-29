package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.internal.zzb.zza;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;

public class zzd extends zzj<zzb> {
    private final zze zzRS;

    public zzd(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zze com_google_android_gms_auth_api_signin_zze, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 87, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzRS = (zze) zzx.zzv(com_google_android_gms_auth_api_signin_zze);
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzaz(iBinder);
    }

    protected zzb zzaz(IBinder iBinder) {
        return zza.zzay(iBinder);
    }

    protected String zzfA() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
