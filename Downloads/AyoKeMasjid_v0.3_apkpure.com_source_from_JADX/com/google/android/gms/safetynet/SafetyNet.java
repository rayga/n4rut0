package com.google.android.gms.safetynet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzpw;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzpy;

public final class SafetyNet {
    public static final Api<NoOptions> API;
    public static final SafetyNetApi SafetyNetApi;
    public static final zzc<zzpx> zzQf;
    public static final zza<zzpx, NoOptions> zzQg;
    public static final zzc zzaNC;

    /* renamed from: com.google.android.gms.safetynet.SafetyNet.1 */
    static class C08231 extends zza<zzpx, NoOptions> {
        C08231() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzr(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzpx zzr(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzpx(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        zzQf = new zzc();
        zzQg = new C08231();
        API = new Api("SafetyNet.API", zzQg, zzQf);
        SafetyNetApi = new zzpw();
        zzaNC = new zzpy();
    }

    private SafetyNet() {
    }
}
