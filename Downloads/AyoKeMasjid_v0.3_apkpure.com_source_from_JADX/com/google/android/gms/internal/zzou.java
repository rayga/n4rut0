package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzoz.zza;

public class zzou extends zzj<zzoz> {
    public zzou(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 69, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzcY(iBinder);
    }

    protected zzoz zzcY(IBinder iBinder) {
        return zza.zzdc(iBinder);
    }

    protected String zzfA() {
        return "com.google.android.gms.nearby.bootstrap.service.NearbyBootstrapService.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService";
    }
}
