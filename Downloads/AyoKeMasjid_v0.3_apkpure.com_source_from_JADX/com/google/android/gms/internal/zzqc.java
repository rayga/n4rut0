package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

public class zzqc implements SearchAuthApi {

    static abstract class zza extends com.google.android.gms.internal.zzpz.zza {
        zza() {
        }

        public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
            throw new UnsupportedOperationException();
        }

        public void zzbc(Status status) {
            throw new UnsupportedOperationException();
        }
    }

    static class zzd implements GoogleNowAuthResult {
        private final Status zzQA;
        private final GoogleNowAuthState zzaNU;

        zzd(Status status, GoogleNowAuthState googleNowAuthState) {
            this.zzQA = status;
            this.zzaNU = googleNowAuthState;
        }

        public GoogleNowAuthState getGoogleNowAuthState() {
            return this.zzaNU;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    static class zzb extends com.google.android.gms.common.api.zzc.zza<Status, zzqb> {
        private final GoogleApiClient zzTC;
        private final String zzaNN;
        private final boolean zzaNQ;

        /* renamed from: com.google.android.gms.internal.zzqc.zzb.1 */
        class C11841 extends zza {
            final /* synthetic */ zzb zzaNR;

            C11841(zzb com_google_android_gms_internal_zzqc_zzb) {
                this.zzaNR = com_google_android_gms_internal_zzqc_zzb;
            }

            public void zzbc(Status status) {
                if (this.zzaNR.zzaNQ) {
                    Log.d("SearchAuth", "ClearTokenImpl success");
                }
                this.zzaNR.zza((Result) status);
            }
        }

        protected zzb(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzQf, googleApiClient);
            this.zzaNQ = Log.isLoggable("SearchAuth", 3);
            this.zzTC = googleApiClient;
            this.zzaNN = str;
        }

        protected void zza(zzqb com_google_android_gms_internal_zzqb) throws RemoteException {
            if (this.zzaNQ) {
                Log.d("SearchAuth", "ClearTokenImpl started");
            }
            String packageName = this.zzTC.getContext().getPackageName();
            ((zzqa) com_google_android_gms_internal_zzqb.zzoA()).zzb(new C11841(this), packageName, this.zzaNN);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            if (this.zzaNQ) {
                Log.d("SearchAuth", "ClearTokenImpl received failure: " + status.getStatusMessage());
            }
            return status;
        }
    }

    static class zzc extends com.google.android.gms.common.api.zzc.zza<GoogleNowAuthResult, zzqb> {
        private final GoogleApiClient zzTC;
        private final boolean zzaNQ;
        private final String zzaNS;

        /* renamed from: com.google.android.gms.internal.zzqc.zzc.1 */
        class C11851 extends zza {
            final /* synthetic */ zzc zzaNT;

            C11851(zzc com_google_android_gms_internal_zzqc_zzc) {
                this.zzaNT = com_google_android_gms_internal_zzqc_zzc;
            }

            public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
                if (this.zzaNT.zzaNQ) {
                    Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                }
                this.zzaNT.zza(new zzd(status, googleNowAuthState));
            }
        }

        protected zzc(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzQf, googleApiClient);
            this.zzaNQ = Log.isLoggable("SearchAuth", 3);
            this.zzTC = googleApiClient;
            this.zzaNS = str;
        }

        protected void zza(zzqb com_google_android_gms_internal_zzqb) throws RemoteException {
            if (this.zzaNQ) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            String packageName = this.zzTC.getContext().getPackageName();
            ((zzqa) com_google_android_gms_internal_zzqb.zzoA()).zza(new C11851(this), packageName, this.zzaNS);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbd(status);
        }

        protected GoogleNowAuthResult zzbd(Status status) {
            if (this.zzaNQ) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl received failure: " + status.getStatusMessage());
            }
            return new zzd(status, null);
        }
    }

    public PendingResult<Status> clearToken(GoogleApiClient client, String accessToken) {
        return client.zza(new zzb(client, accessToken));
    }

    public PendingResult<GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient client, String webAppClientId) {
        return client.zza(new zzc(client, webAppClientId));
    }
}
