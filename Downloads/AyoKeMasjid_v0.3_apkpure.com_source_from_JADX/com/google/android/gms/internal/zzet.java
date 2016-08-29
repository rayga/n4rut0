package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzgk
public final class zzet<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzej zzyY;

    /* renamed from: com.google.android.gms.internal.zzet.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ zzet zzze;
        final /* synthetic */ ErrorCode zzzf;

        AnonymousClass10(zzet com_google_android_gms_internal_zzet, ErrorCode errorCode) {
            this.zzze = com_google_android_gms_internal_zzet;
            this.zzzf = errorCode;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdFailedToLoad(zzeu.zza(this.zzzf));
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.1 */
    class C03501 implements Runnable {
        final /* synthetic */ zzet zzze;

        C03501(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdClicked();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.2 */
    class C03512 implements Runnable {
        final /* synthetic */ zzet zzze;

        C03512(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdOpened();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.3 */
    class C03523 implements Runnable {
        final /* synthetic */ zzet zzze;

        C03523(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdLoaded();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.4 */
    class C03534 implements Runnable {
        final /* synthetic */ zzet zzze;

        C03534(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdClosed();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.5 */
    class C03545 implements Runnable {
        final /* synthetic */ zzet zzze;
        final /* synthetic */ ErrorCode zzzf;

        C03545(zzet com_google_android_gms_internal_zzet, ErrorCode errorCode) {
            this.zzze = com_google_android_gms_internal_zzet;
            this.zzzf = errorCode;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdFailedToLoad(zzeu.zza(this.zzzf));
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.6 */
    class C03556 implements Runnable {
        final /* synthetic */ zzet zzze;

        C03556(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdLeftApplication();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.7 */
    class C03567 implements Runnable {
        final /* synthetic */ zzet zzze;

        C03567(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdOpened();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.8 */
    class C03578 implements Runnable {
        final /* synthetic */ zzet zzze;

        C03578(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdLoaded();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzet.9 */
    class C03589 implements Runnable {
        final /* synthetic */ zzet zzze;

        C03589(zzet com_google_android_gms_internal_zzet) {
            this.zzze = com_google_android_gms_internal_zzet;
        }

        public void run() {
            try {
                this.zzze.zzyY.onAdClosed();
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
            }
        }
    }

    public zzet(zzej com_google_android_gms_internal_zzej) {
        this.zzyY = com_google_android_gms_internal_zzej;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaC("Adapter called onClick.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdClicked();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClicked.", e);
                return;
            }
        }
        zzb.zzaE("onClick must be called on the main UI thread.");
        zza.zzIy.post(new C03501(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaC("Adapter called onDismissScreen.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdClosed();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzb.zzaE("onDismissScreen must be called on the main UI thread.");
        zza.zzIy.post(new C03534(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaC("Adapter called onDismissScreen.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdClosed();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdClosed.", e);
                return;
            }
        }
        zzb.zzaE("onDismissScreen must be called on the main UI thread.");
        zza.zzIy.post(new C03589(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        zzb.zzaC("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdFailedToLoad(zzeu.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzb.zzaE("onFailedToReceiveAd must be called on the main UI thread.");
        zza.zzIy.post(new C03545(this, errorCode));
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        zzb.zzaC("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdFailedToLoad(zzeu.zza(errorCode));
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzb.zzaE("onFailedToReceiveAd must be called on the main UI thread.");
        zza.zzIy.post(new AnonymousClass10(this, errorCode));
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaC("Adapter called onLeaveApplication.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzb.zzaE("onLeaveApplication must be called on the main UI thread.");
        zza.zzIy.post(new C03556(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaC("Adapter called onLeaveApplication.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        zzb.zzaE("onLeaveApplication must be called on the main UI thread.");
        zza.zzIy.post(new Runnable() {
            final /* synthetic */ zzet zzze;

            {
                this.zzze = r1;
            }

            public void run() {
                try {
                    this.zzze.zzyY.onAdLeftApplication();
                } catch (Throwable e) {
                    zzb.zzd("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaC("Adapter called onPresentScreen.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdOpened();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzb.zzaE("onPresentScreen must be called on the main UI thread.");
        zza.zzIy.post(new C03567(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaC("Adapter called onPresentScreen.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdOpened();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdOpened.", e);
                return;
            }
        }
        zzb.zzaE("onPresentScreen must be called on the main UI thread.");
        zza.zzIy.post(new C03512(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzaC("Adapter called onReceivedAd.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzb.zzaE("onReceivedAd must be called on the main UI thread.");
        zza.zzIy.post(new C03578(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzaC("Adapter called onReceivedAd.");
        if (zzk.zzcE().zzgI()) {
            try {
                this.zzyY.onAdLoaded();
                return;
            } catch (Throwable e) {
                zzb.zzd("Could not call onAdLoaded.", e);
                return;
            }
        }
        zzb.zzaE("onReceivedAd must be called on the main UI thread.");
        zza.zzIy.post(new C03523(this));
    }
}
