package com.google.android.gms.panorama;

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
import com.google.android.gms.internal.zzpi;
import com.google.android.gms.internal.zzpj;

public final class Panorama {
    public static final Api<NoOptions> API;
    public static final PanoramaApi PanoramaApi;
    public static final zzc<zzpj> zzQf;
    static final zza<zzpj, NoOptions> zzQg;

    /* renamed from: com.google.android.gms.panorama.Panorama.1 */
    static class C08211 extends zza<zzpj, NoOptions> {
        C08211() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzq(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzpj zzq(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzpj(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static {
        zzQf = new zzc();
        zzQg = new C08211();
        API = new Api("Panorama.API", zzQg, zzQf);
        PanoramaApi = new zzpi();
    }

    private Panorama() {
    }
}
