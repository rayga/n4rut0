package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzqa.zza;

public class zzqb extends zzj<zzqa> {
    public zzqb(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, context.getMainLooper(), 73, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzdF(iBinder);
    }

    protected zzqa zzdF(IBinder iBinder) {
        return zza.zzdE(iBinder);
    }

    protected String zzfA() {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }

    protected String zzfB() {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }
}
