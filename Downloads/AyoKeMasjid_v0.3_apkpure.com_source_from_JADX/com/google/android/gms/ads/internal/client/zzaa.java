package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.client.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.zzeg;

public class zzaa {
    private static final Object zzpm;
    private static zzaa zztt;
    private zzv zztu;
    private RewardedVideoAd zztv;

    static {
        zzpm = new Object();
    }

    private zzaa() {
    }

    public static zzaa zzcU() {
        zzaa com_google_android_gms_ads_internal_client_zzaa;
        synchronized (zzpm) {
            if (zztt == null) {
                zztt = new zzaa();
            }
            com_google_android_gms_ads_internal_client_zzaa = zztt;
        }
        return com_google_android_gms_ads_internal_client_zzaa;
    }

    public RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (zzpm) {
            if (this.zztv != null) {
                rewardedVideoAd = this.zztv;
            } else {
                this.zztv = new zzi(context, zzk.zzcJ().zza(context, new zzeg()));
                rewardedVideoAd = this.zztv;
            }
        }
        return rewardedVideoAd;
    }

    public void zza(Context context, String str, zzab com_google_android_gms_ads_internal_client_zzab) {
        synchronized (zzpm) {
            if (this.zztu != null) {
            } else if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            } else if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("applicationCode cannot be empty.");
            } else {
                try {
                    this.zztu = zzk.zzcH().zzt(context);
                    this.zztu.zza(str, com_google_android_gms_ads_internal_client_zzab == null ? null : new MobileAdsSettingsParcel(com_google_android_gms_ads_internal_client_zzab));
                } catch (RemoteException e) {
                    zzb.zzaE("Fail to initialize mobile ads setting manager");
                }
            }
        }
    }
}
