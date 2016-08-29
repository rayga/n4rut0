package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzlc.zza;

public class zzla extends zzj<zzlc> {
    public zzla(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzaO(iBinder);
    }

    protected zzlc zzaO(IBinder iBinder) {
        return zza.zzaQ(iBinder);
    }

    public String zzfA() {
        return "com.google.android.gms.common.service.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
}
