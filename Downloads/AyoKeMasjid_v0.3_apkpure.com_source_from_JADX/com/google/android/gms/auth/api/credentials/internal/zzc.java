package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;

public final class zzc implements CredentialsApi {

    private static class zza extends zza {
        private zzb<Status> zzRC;

        zza(zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            this.zzRC = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzl(Status status) {
            this.zzRC.zzn(status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzc.1 */
    class C11871 extends zzd<CredentialRequestResult> {
        final /* synthetic */ CredentialRequest zzRy;
        final /* synthetic */ zzc zzRz;

        /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzc.1.1 */
        class C11761 extends zza {
            final /* synthetic */ C11871 zzRA;

            C11761(C11871 c11871) {
                this.zzRA = c11871;
            }

            public void zza(Status status, Credential credential) {
                this.zzRA.zza(new zzb(status, credential));
            }
        }

        C11871(zzc com_google_android_gms_auth_api_credentials_internal_zzc, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
            this.zzRz = com_google_android_gms_auth_api_credentials_internal_zzc;
            this.zzRy = credentialRequest;
            super(googleApiClient);
        }

        protected void zza(Context context, zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
            com_google_android_gms_auth_api_credentials_internal_zzh.zza(new C11761(this), this.zzRy);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzn(status);
        }

        protected CredentialRequestResult zzn(Status status) {
            return zzb.zzm(status);
        }
    }

    /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzc.2 */
    class C11882 extends zzd<Status> {
        final /* synthetic */ Credential zzRB;
        final /* synthetic */ zzc zzRz;

        C11882(zzc com_google_android_gms_auth_api_credentials_internal_zzc, GoogleApiClient googleApiClient, Credential credential) {
            this.zzRz = com_google_android_gms_auth_api_credentials_internal_zzc;
            this.zzRB = credential;
            super(googleApiClient);
        }

        protected void zza(Context context, zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
            com_google_android_gms_auth_api_credentials_internal_zzh.zza(new zza(this), new SaveRequest(this.zzRB));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzc.3 */
    class C11893 extends zzd<Status> {
        final /* synthetic */ Credential zzRB;
        final /* synthetic */ zzc zzRz;

        C11893(zzc com_google_android_gms_auth_api_credentials_internal_zzc, GoogleApiClient googleApiClient, Credential credential) {
            this.zzRz = com_google_android_gms_auth_api_credentials_internal_zzc;
            this.zzRB = credential;
            super(googleApiClient);
        }

        protected void zza(Context context, zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
            com_google_android_gms_auth_api_credentials_internal_zzh.zza(new zza(this), new DeleteRequest(this.zzRB));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.auth.api.credentials.internal.zzc.4 */
    class C11904 extends zzd<Status> {
        final /* synthetic */ zzc zzRz;

        C11904(zzc com_google_android_gms_auth_api_credentials_internal_zzc, GoogleApiClient googleApiClient) {
            this.zzRz = com_google_android_gms_auth_api_credentials_internal_zzc;
            super(googleApiClient);
        }

        protected void zza(Context context, zzh com_google_android_gms_auth_api_credentials_internal_zzh) throws RemoteException {
            com_google_android_gms_auth_api_credentials_internal_zzh.zza(new zza(this));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    public PendingResult<Status> delete(GoogleApiClient client, Credential credential) {
        return client.zzb(new C11893(this, client, credential));
    }

    public PendingResult<Status> disableAutoSignIn(GoogleApiClient client) {
        return client.zzb(new C11904(this, client));
    }

    public PendingResult<CredentialRequestResult> request(GoogleApiClient client, CredentialRequest request) {
        return client.zza(new C11871(this, client, request));
    }

    public PendingResult<Status> save(GoogleApiClient client, Credential credential) {
        return client.zzb(new C11882(this, client, credential));
    }
}
