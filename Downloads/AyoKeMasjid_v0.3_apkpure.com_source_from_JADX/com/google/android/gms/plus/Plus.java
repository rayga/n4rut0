package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zzpn;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;
import com.google.android.gms.plus.internal.zze;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API;
    public static final Account AccountApi;
    public static final Moments MomentsApi;
    public static final People PeopleApi;
    public static final Scope SCOPE_PLUS_LOGIN;
    public static final Scope SCOPE_PLUS_PROFILE;
    public static final zzc<zze> zzQf;
    static final com.google.android.gms.common.api.Api.zza<zze, PlusOptions> zzQg;
    public static final zzb zzaLc;
    public static final zza zzaLd;

    /* renamed from: com.google.android.gms.plus.Plus.1 */
    static class C08221 extends com.google.android.gms.common.api.Api.zza<zze, PlusOptions> {
        C08221() {
        }

        public int getPriority() {
            return 2;
        }

        public zze zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new zze(context, looper, com_google_android_gms_common_internal_zzf, new PlusSession(com_google_android_gms_common_internal_zzf.zzog().name, zzly.zzc(com_google_android_gms_common_internal_zzf.zzoj()), (String[]) plusOptions.zzaLf.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()), connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class PlusOptions implements Optional {
        final String zzaLe;
        final Set<String> zzaLf;

        public static final class Builder {
            String zzaLe;
            final Set<String> zzaLf;

            public Builder() {
                this.zzaLf = new HashSet();
            }

            public Builder addActivityTypes(String... activityTypes) {
                zzx.zzb((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.zzaLf.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.zzaLe = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.zzaLe = null;
            this.zzaLf = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.zzaLe = builder.zzaLe;
            this.zzaLf = builder.zzaLf;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zze> {
        public zza(GoogleApiClient googleApiClient) {
            super(Plus.zzQf, googleApiClient);
        }
    }

    static {
        zzQf = new zzc();
        zzQg = new C08221();
        API = new Api("Plus.API", zzQg, zzQf);
        SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
        SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
        MomentsApi = new zzpq();
        PeopleApi = new zzpr();
        AccountApi = new zzpn();
        zzaLc = new zzpp();
        zzaLd = new zzpo();
    }

    private Plus() {
    }

    public static zze zzf(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (zze) googleApiClient.zza(zzQf) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
    }
}
