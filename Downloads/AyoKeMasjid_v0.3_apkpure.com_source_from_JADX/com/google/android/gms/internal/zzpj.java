package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzph.zza;

public class zzpj extends zzj<zzph> {
    public zzpj(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 3, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    public /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzds(iBinder);
    }

    public zzph zzds(IBinder iBinder) {
        return zza.zzdr(iBinder);
    }

    protected String zzfA() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }
}
