package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.zze;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzjq;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzjs;
import com.google.android.gms.internal.zzjw;
import com.google.android.gms.internal.zzka;

public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API;
    public static final CredentialsApi CredentialsApi;
    public static final Api<zza> PROXY_API;
    public static final ProxyApi ProxyApi;
    public static final zzc<zzjw> zzQL;
    public static final zzc<zze> zzQM;
    public static final zzc<zzjs> zzQN;
    public static final zzc<zzd> zzQO;
    private static final com.google.android.gms.common.api.Api.zza<zzjw, zza> zzQP;
    private static final com.google.android.gms.common.api.Api.zza<zze, AuthCredentialsOptions> zzQQ;
    private static final com.google.android.gms.common.api.Api.zza<zzjs, NoOptions> zzQR;
    private static final com.google.android.gms.common.api.Api.zza<zzd, com.google.android.gms.auth.api.signin.zze> zzQS;
    public static final Api<com.google.android.gms.auth.api.signin.zze> zzQT;
    public static final Api<NoOptions> zzQU;
    public static final zzjq zzQV;
    public static final com.google.android.gms.auth.api.signin.zzd zzQW;

    /* renamed from: com.google.android.gms.auth.api.Auth.1 */
    static class C06931 extends com.google.android.gms.common.api.Api.zza<zzjw, zza> {
        C06931() {
        }

        public zzjw zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zza com_google_android_gms_auth_api_Auth_zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjw(context, looper, com_google_android_gms_common_internal_zzf, com_google_android_gms_auth_api_Auth_zza, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.Auth.2 */
    static class C06942 extends com.google.android.gms.common.api.Api.zza<zze, AuthCredentialsOptions> {
        C06942() {
        }

        public zze zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zze(context, looper, com_google_android_gms_common_internal_zzf, authCredentialsOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.Auth.3 */
    static class C06953 extends com.google.android.gms.common.api.Api.zza<zzjs, NoOptions> {
        C06953() {
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzd(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzjs zzd(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjs(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.Auth.4 */
    static class C06964 extends com.google.android.gms.common.api.Api.zza<zzd, com.google.android.gms.auth.api.signin.zze> {
        C06964() {
        }

        public zzd zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, com.google.android.gms.auth.api.signin.zze com_google_android_gms_auth_api_signin_zze, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzd(context, looper, com_google_android_gms_common_internal_zzf, com_google_android_gms_auth_api_signin_zze, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class AuthCredentialsOptions implements Optional {
        private final String zzQX;
        private final PasswordSpecification zzQY;

        public static class Builder {
            private PasswordSpecification zzQY;

            public Builder() {
                this.zzQY = PasswordSpecification.zzRo;
            }
        }

        public Bundle zzli() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.zzQX);
            bundle.putParcelable("password_specification", this.zzQY);
            return bundle;
        }
    }

    public static final class zza implements Optional {
        private final Bundle zzQZ;

        public Bundle zzlq() {
            return new Bundle(this.zzQZ);
        }
    }

    static {
        zzQL = new zzc();
        zzQM = new zzc();
        zzQN = new zzc();
        zzQO = new zzc();
        zzQP = new C06931();
        zzQQ = new C06942();
        zzQR = new C06953();
        zzQS = new C06964();
        PROXY_API = new Api("Auth.PROXY_API", zzQP, zzQL);
        CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzQQ, zzQM);
        zzQT = new Api("Auth.SIGN_IN_API", zzQS, zzQO);
        zzQU = new Api("Auth.ACCOUNT_STATUS_API", zzQR, zzQN);
        ProxyApi = new zzka();
        CredentialsApi = new com.google.android.gms.auth.api.credentials.internal.zzc();
        zzQV = new zzjr();
        zzQW = new com.google.android.gms.auth.api.signin.internal.zzc();
    }

    private Auth() {
    }
}
