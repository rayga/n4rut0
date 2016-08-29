package com.google.android.gms.appinvite;

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
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjj;

public final class AppInvite {
    public static final Api<NoOptions> API;
    public static final AppInviteApi AppInviteApi;
    public static final zzc<zzjj> zzQf;
    private static final zza<zzjj, NoOptions> zzQg;

    /* renamed from: com.google.android.gms.appinvite.AppInvite.1 */
    static class C06911 extends zza<zzjj, NoOptions> {
        C06911() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzb(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzjj zzb(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjj(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
        }
    }

    static {
        zzQf = new zzc();
        zzQg = new C06911();
        API = new Api("AppInvite.API", zzQg, zzQf);
        AppInviteApi = new zzji();
    }

    private AppInvite() {
    }
}
