package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MobileAds {

    public static final class Settings {
        private final zzab zznU;

        public Settings() {
            this.zznU = new zzab();
        }

        public String getTrackingId() {
            return this.zznU.getTrackingId();
        }

        public boolean isGoogleAnalyticsEnabled() {
            return this.zznU.isGoogleAnalyticsEnabled();
        }

        public Settings setGoogleAnalyticsEnabled(boolean enable) {
            this.zznU.zzk(enable);
            return this;
        }

        public Settings setTrackingId(String trackingId) {
            this.zznU.zzO(trackingId);
            return this;
        }

        zzab zzaG() {
            return this.zznU;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzaa.zzcU().getRewardedVideoAdInstance(context);
    }

    public static void initialize(Context context, String applicationCode) {
        initialize(context, applicationCode, null);
    }

    public static void initialize(Context context, String applicationCode, Settings settings) {
        zzaa.zzcU().zza(context, applicationCode, settings == null ? null : settings.zzaG());
    }
}
