package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.wearable.internal.zzay;
import com.google.android.gms.wearable.internal.zzba;
import com.google.android.gms.wearable.internal.zzbl;
import com.google.android.gms.wearable.internal.zzbn;
import com.google.android.gms.wearable.internal.zzbp;
import com.google.android.gms.wearable.internal.zzd;
import com.google.android.gms.wearable.internal.zzi;
import com.google.android.gms.wearable.internal.zzk;
import com.google.android.gms.wearable.internal.zzv;
import com.google.android.gms.wearable.internal.zzw;

public class Wearable {
    public static final Api<WearableOptions> API;
    public static final CapabilityApi CapabilityApi;
    public static final ChannelApi ChannelApi;
    public static final DataApi DataApi;
    public static final MessageApi MessageApi;
    public static final NodeApi NodeApi;
    public static final zzc<zzbn> zzQf;
    private static final zza<zzbn, WearableOptions> zzQg;
    public static final zzc zzaYX;
    public static final zza zzaYY;
    public static final zzf zzaYZ;
    public static final zzi zzaZa;
    public static final zzk zzaZb;

    /* renamed from: com.google.android.gms.wearable.Wearable.1 */
    static class C08461 extends zza<zzbn, WearableOptions> {
        C08461() {
        }

        public zzbn zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                WearableOptions wearableOptions2 = new WearableOptions(null);
            }
            return new zzbn(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
        }
    }

    public static final class WearableOptions implements Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions();
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    static {
        DataApi = new zzw();
        CapabilityApi = new zzi();
        MessageApi = new zzay();
        NodeApi = new zzba();
        ChannelApi = new zzk();
        zzaYX = new com.google.android.gms.wearable.internal.zzf();
        zzaYY = new zzd();
        zzaYZ = new zzv();
        zzaZa = new zzbl();
        zzaZb = new zzbp();
        zzQf = new zzc();
        zzQg = new C08461();
        API = new Api("Wearable.API", zzQg, zzQf);
    }

    private Wearable() {
    }
}
