package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.location.internal.zzj;

public class ActivityRecognition {
    public static final Api<NoOptions> API;
    public static final ActivityRecognitionApi ActivityRecognitionApi;
    public static final String CLIENT_NAME = "activity_recognition";
    private static final zzc<zzj> zzQf;
    private static final com.google.android.gms.common.api.Api.zza<zzj, NoOptions> zzQg;

    /* renamed from: com.google.android.gms.location.ActivityRecognition.1 */
    static class C08141 extends com.google.android.gms.common.api.Api.zza<zzj, NoOptions> {
        C08141() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzm(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzj zzm(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzj(context, looper, connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzj> {
        public zza(GoogleApiClient googleApiClient) {
            super(ActivityRecognition.zzQf, googleApiClient);
        }
    }

    static {
        zzQf = new zzc();
        zzQg = new C08141();
        API = new Api("ActivityRecognition.API", zzQg, zzQf);
        ActivityRecognitionApi = new com.google.android.gms.location.internal.zza();
    }

    private ActivityRecognition() {
    }
}
