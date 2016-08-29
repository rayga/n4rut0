package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.zzb;

public class zzrg implements Payments {

    /* renamed from: com.google.android.gms.internal.zzrg.1 */
    class C13981 extends zzb {
        final /* synthetic */ int zzaAy;
        final /* synthetic */ zzrg zzaYm;

        C13981(zzrg com_google_android_gms_internal_zzrg, GoogleApiClient googleApiClient, int i) {
            this.zzaYm = com_google_android_gms_internal_zzrg;
            this.zzaAy = i;
            super(googleApiClient);
        }

        protected void zza(zzrh com_google_android_gms_internal_zzrh) {
            com_google_android_gms_internal_zzrh.zzki(this.zzaAy);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzrg.2 */
    class C13992 extends zzb {
        final /* synthetic */ int zzaAy;
        final /* synthetic */ zzrg zzaYm;
        final /* synthetic */ MaskedWalletRequest zzaYn;

        C13992(zzrg com_google_android_gms_internal_zzrg, GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i) {
            this.zzaYm = com_google_android_gms_internal_zzrg;
            this.zzaYn = maskedWalletRequest;
            this.zzaAy = i;
            super(googleApiClient);
        }

        protected void zza(zzrh com_google_android_gms_internal_zzrh) {
            com_google_android_gms_internal_zzrh.zza(this.zzaYn, this.zzaAy);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzrg.3 */
    class C14003 extends zzb {
        final /* synthetic */ int zzaAy;
        final /* synthetic */ zzrg zzaYm;
        final /* synthetic */ FullWalletRequest zzaYo;

        C14003(zzrg com_google_android_gms_internal_zzrg, GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i) {
            this.zzaYm = com_google_android_gms_internal_zzrg;
            this.zzaYo = fullWalletRequest;
            this.zzaAy = i;
            super(googleApiClient);
        }

        protected void zza(zzrh com_google_android_gms_internal_zzrh) {
            com_google_android_gms_internal_zzrh.zza(this.zzaYo, this.zzaAy);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzrg.4 */
    class C14014 extends zzb {
        final /* synthetic */ int zzaAy;
        final /* synthetic */ zzrg zzaYm;
        final /* synthetic */ String zzaYp;
        final /* synthetic */ String zzaYq;

        C14014(zzrg com_google_android_gms_internal_zzrg, GoogleApiClient googleApiClient, String str, String str2, int i) {
            this.zzaYm = com_google_android_gms_internal_zzrg;
            this.zzaYp = str;
            this.zzaYq = str2;
            this.zzaAy = i;
            super(googleApiClient);
        }

        protected void zza(zzrh com_google_android_gms_internal_zzrh) {
            com_google_android_gms_internal_zzrh.zze(this.zzaYp, this.zzaYq, this.zzaAy);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzrg.5 */
    class C14025 extends zzb {
        final /* synthetic */ zzrg zzaYm;
        final /* synthetic */ NotifyTransactionStatusRequest zzaYr;

        C14025(zzrg com_google_android_gms_internal_zzrg, GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.zzaYm = com_google_android_gms_internal_zzrg;
            this.zzaYr = notifyTransactionStatusRequest;
            super(googleApiClient);
        }

        protected void zza(zzrh com_google_android_gms_internal_zzrh) {
            com_google_android_gms_internal_zzrh.zza(this.zzaYr);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzrg.6 */
    class C14036 extends zzb {
        final /* synthetic */ int zzaAy;
        final /* synthetic */ zzrg zzaYm;

        C14036(zzrg com_google_android_gms_internal_zzrg, GoogleApiClient googleApiClient, int i) {
            this.zzaYm = com_google_android_gms_internal_zzrg;
            this.zzaAy = i;
            super(googleApiClient);
        }

        protected void zza(zzrh com_google_android_gms_internal_zzrh) {
            com_google_android_gms_internal_zzrh.zzkj(this.zzaAy);
            zza(Status.zzaaD);
        }
    }

    public void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        googleApiClient.zza(new C14014(this, googleApiClient, googleTransactionId, merchantTransactionId, requestCode));
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        googleApiClient.zza(new C13981(this, googleApiClient, requestCode));
    }

    public void isNewUser(GoogleApiClient googleApiClient, int requestCode) {
        googleApiClient.zza(new C14036(this, googleApiClient, requestCode));
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        googleApiClient.zza(new C14003(this, googleApiClient, request, requestCode));
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        googleApiClient.zza(new C13992(this, googleApiClient, request, requestCode));
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        googleApiClient.zza(new C14025(this, googleApiClient, request));
    }
}
