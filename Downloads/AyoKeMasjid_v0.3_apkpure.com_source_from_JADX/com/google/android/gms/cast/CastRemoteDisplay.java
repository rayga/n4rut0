package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;

public final class CastRemoteDisplay {
    public static final Api<CastRemoteDisplayOptions> API;
    public static final CastRemoteDisplayApi CastRemoteDisplayApi;
    private static final zzc<zzkm> zzQf;
    private static final zza<zzkm, CastRemoteDisplayOptions> zzQg;

    public interface CastRemoteDisplaySessionCallbacks {
        void onRemoteDisplayEnded(Status status);
    }

    /* renamed from: com.google.android.gms.cast.CastRemoteDisplay.1 */
    static class C06981 extends zza<zzkm, CastRemoteDisplayOptions> {
        C06981() {
        }

        public zzkm zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, CastRemoteDisplayOptions castRemoteDisplayOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkm(context, looper, com_google_android_gms_common_internal_zzf, castRemoteDisplayOptions.zzTg, castRemoteDisplayOptions.zzTw, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface CastRemoteDisplaySessionResult extends Result {
        Display getPresentationDisplay();
    }

    public static final class CastRemoteDisplayOptions implements HasOptions {
        final CastDevice zzTg;
        final CastRemoteDisplaySessionCallbacks zzTw;

        public static final class Builder {
            CastDevice zzTj;
            CastRemoteDisplaySessionCallbacks zzTx;

            public Builder(CastDevice castDevice, CastRemoteDisplaySessionCallbacks callbacks) {
                zzx.zzb((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                this.zzTj = castDevice;
                this.zzTx = callbacks;
            }

            public CastRemoteDisplayOptions build() {
                return new CastRemoteDisplayOptions();
            }
        }

        private CastRemoteDisplayOptions(Builder builder) {
            this.zzTg = builder.zzTj;
            this.zzTw = builder.zzTx;
        }
    }

    static {
        zzQf = new zzc();
        zzQg = new C06981();
        API = new Api("CastRemoteDisplay.API", zzQg, zzQf);
        CastRemoteDisplayApi = new zzkl(zzQf);
    }

    private CastRemoteDisplay() {
    }
}
