package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.AttestationResult;
import com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult;
import java.util.List;

public class zzpw implements SafetyNetApi {

    static class zza implements AttestationResult {
        private final Status zzQA;
        private final AttestationData zzaNH;

        public zza(Status status, AttestationData attestationData) {
            this.zzQA = status;
            this.zzaNH = attestationData;
        }

        public String getJwsResult() {
            return this.zzaNH == null ? null : this.zzaNH.getJwsResult();
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    static class zzd implements SafeBrowsingResult {
        private Status zzQA;
        private String zzaNB;
        private final SafeBrowsingData zzaNL;

        public zzd(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzQA = status;
            this.zzaNL = safeBrowsingData;
            this.zzaNB = null;
            if (this.zzaNL != null) {
                this.zzaNB = this.zzaNL.getMetadata();
            } else {
                this.zzQA = new Status(8);
            }
        }

        public String getMetadata() {
            return this.zzaNB;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    static abstract class zzb extends zzpt<AttestationResult> {
        protected zzpu zzaNI;

        /* renamed from: com.google.android.gms.internal.zzpw.zzb.1 */
        class C11821 extends zzps {
            final /* synthetic */ zzb zzaNJ;

            C11821(zzb com_google_android_gms_internal_zzpw_zzb) {
                this.zzaNJ = com_google_android_gms_internal_zzpw_zzb;
            }

            public void zza(Status status, AttestationData attestationData) {
                this.zzaNJ.zza(new zza(status, attestationData));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaNI = new C11821(this);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzba(status);
        }

        protected AttestationResult zzba(Status status) {
            return new zza(status, null);
        }
    }

    static abstract class zzc extends zzpt<SafeBrowsingResult> {
        protected zzpu zzaNI;

        /* renamed from: com.google.android.gms.internal.zzpw.zzc.1 */
        class C11831 extends zzps {
            final /* synthetic */ zzc zzaNK;

            C11831(zzc com_google_android_gms_internal_zzpw_zzc) {
                this.zzaNK = com_google_android_gms_internal_zzpw_zzc;
            }

            public void zza(Status status, SafeBrowsingData safeBrowsingData) {
                this.zzaNK.zza(new zzd(status, safeBrowsingData));
            }
        }

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzaNI = new C11831(this);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbb(status);
        }

        protected SafeBrowsingResult zzbb(Status status) {
            return new zzd(status, null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpw.1 */
    class C13961 extends zzb {
        final /* synthetic */ byte[] zzaND;
        final /* synthetic */ zzpw zzaNE;

        C13961(zzpw com_google_android_gms_internal_zzpw, GoogleApiClient googleApiClient, byte[] bArr) {
            this.zzaNE = com_google_android_gms_internal_zzpw;
            this.zzaND = bArr;
            super(googleApiClient);
        }

        protected void zza(zzpx com_google_android_gms_internal_zzpx) throws RemoteException {
            com_google_android_gms_internal_zzpx.zza(this.zzaNI, this.zzaND);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpw.2 */
    class C13972 extends zzc {
        final /* synthetic */ zzpw zzaNE;
        final /* synthetic */ List zzaNF;
        final /* synthetic */ String zzaNG;

        C13972(zzpw com_google_android_gms_internal_zzpw, GoogleApiClient googleApiClient, List list, String str) {
            this.zzaNE = com_google_android_gms_internal_zzpw;
            this.zzaNF = list;
            this.zzaNG = str;
            super(googleApiClient);
        }

        protected void zza(zzpx com_google_android_gms_internal_zzpx) throws RemoteException {
            com_google_android_gms_internal_zzpx.zza(this.zzaNI, this.zzaNF, 1, this.zzaNG);
        }
    }

    public PendingResult<AttestationResult> attest(GoogleApiClient googleApiClient, byte[] nonce) {
        return googleApiClient.zza(new C13961(this, googleApiClient, nonce));
    }

    public PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, List<Integer> threatTypes, String uri) {
        if (threatTypes == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(uri)) {
            return googleApiClient.zza(new C13972(this, googleApiClient, threatTypes, uri));
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }
}
