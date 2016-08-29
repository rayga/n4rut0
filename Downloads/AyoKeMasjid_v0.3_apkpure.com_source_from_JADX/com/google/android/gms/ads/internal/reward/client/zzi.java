package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class zzi implements RewardedVideoAd {
    private final Context mContext;
    private String zzGh;
    private RewardedVideoAdListener zzGm;
    private final zzb zzGn;
    private final Object zzpc;

    public zzi(Context context, zzb com_google_android_gms_ads_internal_reward_client_zzb) {
        this.zzpc = new Object();
        this.zzGn = com_google_android_gms_ads_internal_reward_client_zzb;
        this.mContext = context;
    }

    public void destroy() {
        synchronized (this.zzpc) {
            if (this.zzGn == null) {
                return;
            }
            try {
                this.zzGn.destroy();
            } catch (Throwable e) {
                zzb.zzd("Could not forward destroy to RewardedVideoAd", e);
            }
        }
    }

    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.zzpc) {
            rewardedVideoAdListener = this.zzGm;
        }
        return rewardedVideoAdListener;
    }

    public String getUserId() {
        String str;
        synchronized (this.zzpc) {
            str = this.zzGh;
        }
        return str;
    }

    public boolean isLoaded() {
        boolean z = false;
        synchronized (this.zzpc) {
            if (this.zzGn == null) {
            } else {
                try {
                    z = this.zzGn.isLoaded();
                } catch (Throwable e) {
                    zzb.zzd("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    public void loadAd(String adUnitId, AdRequest adRequest) {
        synchronized (this.zzpc) {
            if (this.zzGn == null) {
                return;
            }
            try {
                this.zzGn.zza(zzg.zzcA().zza(this.mContext, adRequest.zzaF(), adUnitId));
            } catch (Throwable e) {
                zzb.zzd("Could not forward loadAd to RewardedVideoAd", e);
            }
        }
    }

    public void pause() {
        synchronized (this.zzpc) {
            if (this.zzGn == null) {
                return;
            }
            try {
                this.zzGn.pause();
            } catch (Throwable e) {
                zzb.zzd("Could not forward pause to RewardedVideoAd", e);
            }
        }
    }

    public void resume() {
        synchronized (this.zzpc) {
            if (this.zzGn == null) {
                return;
            }
            try {
                this.zzGn.resume();
            } catch (Throwable e) {
                zzb.zzd("Could not forward resume to RewardedVideoAd", e);
            }
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener listener) {
        synchronized (this.zzpc) {
            this.zzGm = listener;
            if (this.zzGn != null) {
                try {
                    this.zzGn.zza(new zzg(listener));
                } catch (Throwable e) {
                    zzb.zzd("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    public void setUserId(String userId) {
        synchronized (this.zzpc) {
            if (TextUtils.isEmpty(this.zzGh)) {
                this.zzGh = userId;
                if (this.zzGn != null) {
                    try {
                        this.zzGn.setUserId(userId);
                    } catch (Throwable e) {
                        zzb.zzd("Could not forward setUserId to RewardedVideoAd", e);
                    }
                }
                return;
            }
            zzb.zzaE("A user id has already been set, ignoring.");
        }
    }

    public void show() {
        synchronized (this.zzpc) {
            if (this.zzGn == null) {
                return;
            }
            try {
                this.zzGn.show();
            } catch (Throwable e) {
                zzb.zzd("Could not forward show to RewardedVideoAd", e);
            }
        }
    }
}
