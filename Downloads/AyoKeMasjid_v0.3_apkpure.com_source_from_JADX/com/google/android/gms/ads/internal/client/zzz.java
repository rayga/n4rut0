package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzci;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzfr;
import com.google.android.gms.internal.zzfv;

public class zzz {
    private final Context mContext;
    private final zzg zznK;
    private String zzoZ;
    private AppEventListener zzsK;
    private zza zzsn;
    private AdListener zzso;
    private final zzeg zztk;
    private zzr zztm;
    private String zztn;
    private InAppPurchaseListener zztp;
    private PlayStorePurchaseListener zztq;
    private OnCustomRenderedAdLoadedListener zztr;
    private PublisherInterstitialAd zzts;

    public zzz(Context context) {
        this(context, zzg.zzcA(), null);
    }

    public zzz(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzg.zzcA(), publisherInterstitialAd);
    }

    public zzz(Context context, zzg com_google_android_gms_ads_internal_client_zzg, PublisherInterstitialAd publisherInterstitialAd) {
        this.zztk = new zzeg();
        this.mContext = context;
        this.zznK = com_google_android_gms_ads_internal_client_zzg;
        this.zzts = publisherInterstitialAd;
    }

    private void zzM(String str) throws RemoteException {
        if (this.zzoZ == null) {
            zzN(str);
        }
        this.zztm = zzk.zzcF().zzb(this.mContext, new AdSizeParcel(), this.zzoZ, this.zztk);
        if (this.zzso != null) {
            this.zztm.zza(new zzc(this.zzso));
        }
        if (this.zzsn != null) {
            this.zztm.zza(new zzb(this.zzsn));
        }
        if (this.zzsK != null) {
            this.zztm.zza(new zzi(this.zzsK));
        }
        if (this.zztp != null) {
            this.zztm.zza(new zzfr(this.zztp));
        }
        if (this.zztq != null) {
            this.zztm.zza(new zzfv(this.zztq), this.zztn);
        }
        if (this.zztr != null) {
            this.zztm.zza(new zzci(this.zztr));
        }
    }

    private void zzN(String str) {
        if (this.zztm == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public AdListener getAdListener() {
        return this.zzso;
    }

    public String getAdUnitId() {
        return this.zzoZ;
    }

    public AppEventListener getAppEventListener() {
        return this.zzsK;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zztp;
    }

    public String getMediationAdapterClassName() {
        try {
            if (this.zztm != null) {
                return this.zztm.getMediationAdapterClassName();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zztr;
    }

    public boolean isLoaded() {
        boolean z = false;
        try {
            if (this.zztm != null) {
                z = this.zztm.isReady();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public boolean isLoading() {
        boolean z = false;
        try {
            if (this.zztm != null) {
                z = this.zztm.isLoading();
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to check if ad is loading.", e);
        }
        return z;
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.zzso = adListener;
            if (this.zztm != null) {
                this.zztm.zza(adListener != null ? new zzc(adListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String adUnitId) {
        if (this.zzoZ != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzoZ = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzsK = appEventListener;
            if (this.zztm != null) {
                this.zztm.zza(appEventListener != null ? new zzi(appEventListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the AppEventListener.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.zztq != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.zztp = inAppPurchaseListener;
            if (this.zztm != null) {
                this.zztm.zza(inAppPurchaseListener != null ? new zzfr(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zztr = onCustomRenderedAdLoadedListener;
            if (this.zztm != null) {
                this.zztm.zza(onCustomRenderedAdLoadedListener != null ? new zzci(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the OnCustomRenderedAdLoadedListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        if (this.zztp != null) {
            throw new IllegalStateException("In app purchase parameter has already been set.");
        }
        try {
            this.zztq = playStorePurchaseListener;
            this.zztn = publicKey;
            if (this.zztm != null) {
                this.zztm.zza(playStorePurchaseListener != null ? new zzfv(playStorePurchaseListener) : null, publicKey);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the play store purchase parameter.", e);
        }
    }

    public void show() {
        try {
            zzN("show");
            this.zztm.showInterstitial();
        } catch (Throwable e) {
            zzb.zzd("Failed to show interstitial.", e);
        }
    }

    public void zza(zza com_google_android_gms_ads_internal_client_zza) {
        try {
            this.zzsn = com_google_android_gms_ads_internal_client_zza;
            if (this.zztm != null) {
                this.zztm.zza(com_google_android_gms_ads_internal_client_zza != null ? new zzb(com_google_android_gms_ads_internal_client_zza) : null);
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to set the AdClickListener.", e);
        }
    }

    public void zza(zzx com_google_android_gms_ads_internal_client_zzx) {
        try {
            if (this.zztm == null) {
                zzM("loadAd");
            }
            if (this.zztm.zza(this.zznK.zza(this.mContext, com_google_android_gms_ads_internal_client_zzx))) {
                this.zztk.zze(com_google_android_gms_ads_internal_client_zzx.zzcN());
            }
        } catch (Throwable e) {
            zzb.zzd("Failed to load ad.", e);
        }
    }
}
