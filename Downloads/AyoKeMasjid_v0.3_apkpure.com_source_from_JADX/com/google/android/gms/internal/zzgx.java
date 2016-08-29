package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzhj.zza;
import java.util.HashMap;

@zzgk
public class zzgx extends zzb implements zzhb {
    private zzd zzGg;
    private String zzGh;
    private boolean zzGi;
    private HashMap<String, zzgy> zzGj;

    /* renamed from: com.google.android.gms.internal.zzgx.1 */
    class C03781 implements Runnable {
        final /* synthetic */ zzgx zzGk;
        final /* synthetic */ zza zzoA;

        C03781(zzgx com_google_android_gms_internal_zzgx, zza com_google_android_gms_internal_zzhj_zza) {
            this.zzGk = com_google_android_gms_internal_zzgx;
            this.zzoA = com_google_android_gms_internal_zzhj_zza;
        }

        public void run() {
            this.zzGk.zzb(new zzhj(this.zzoA, null, null, null, null, null, null));
        }
    }

    public zzgx(Context context, AdSizeParcel adSizeParcel, zzeh com_google_android_gms_internal_zzeh, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, null, com_google_android_gms_internal_zzeh, versionInfoParcel, null);
        this.zzGj = new HashMap();
    }

    public void destroy() {
        zzx.zzch("destroy must be called on the main UI thread.");
        for (String str : this.zzGj.keySet()) {
            try {
                zzgy com_google_android_gms_internal_zzgy = (zzgy) this.zzGj.get(str);
                if (!(com_google_android_gms_internal_zzgy == null || com_google_android_gms_internal_zzgy.zzfQ() == null)) {
                    com_google_android_gms_internal_zzgy.zzfQ().destroy();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaE("Fail to destroy adapter: " + str);
            }
        }
    }

    public boolean isLoaded() {
        zzx.zzch("isLoaded must be called on the main UI thread.");
        return this.zzos.zzqd == null && this.zzos.zzqe == null && this.zzos.zzqg != null && !this.zzGi;
    }

    public void onRewardedVideoAdClosed() {
        if (this.zzGg != null) {
            try {
                this.zzGg.onRewardedVideoAdClosed();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdClosed().", e);
            }
        }
    }

    public void onRewardedVideoAdLeftApplication() {
        if (this.zzGg != null) {
            try {
                this.zzGg.onRewardedVideoAdLeftApplication();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLeftApplication().", e);
            }
        }
    }

    public void onRewardedVideoAdOpened() {
        zza(this.zzos.zzqg, false);
        if (this.zzGg != null) {
            try {
                this.zzGg.onRewardedVideoAdOpened();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdOpened().", e);
            }
        }
    }

    public void onRewardedVideoStarted() {
        zzp.zzbJ().zza(this.zzos.context, this.zzos.zzqb.zzIz, this.zzos.zzqg, this.zzos.zzpZ, false, this.zzos.zzqg.zzyQ.zzys);
        if (this.zzGg != null) {
            try {
                this.zzGg.onRewardedVideoStarted();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onVideoStarted().", e);
            }
        }
    }

    public void pause() {
        zzx.zzch("pause must be called on the main UI thread.");
        for (String str : this.zzGj.keySet()) {
            try {
                zzgy com_google_android_gms_internal_zzgy = (zzgy) this.zzGj.get(str);
                if (!(com_google_android_gms_internal_zzgy == null || com_google_android_gms_internal_zzgy.zzfQ() == null)) {
                    com_google_android_gms_internal_zzgy.zzfQ().pause();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaE("Fail to pause adapter: " + str);
            }
        }
    }

    public void resume() {
        zzx.zzch("resume must be called on the main UI thread.");
        for (String str : this.zzGj.keySet()) {
            try {
                zzgy com_google_android_gms_internal_zzgy = (zzgy) this.zzGj.get(str);
                if (!(com_google_android_gms_internal_zzgy == null || com_google_android_gms_internal_zzgy.zzfQ() == null)) {
                    com_google_android_gms_internal_zzgy.zzfQ().resume();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaE("Fail to resume adapter: " + str);
            }
        }
    }

    public void setUserId(String userId) {
        zzx.zzch("setUserId must be called on the main UI thread.");
        this.zzGh = userId;
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        zzx.zzch("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(rewardedVideoAdRequestParcel.zzpZ)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Invalid ad unit id. Aborting.");
            return;
        }
        this.zzGi = false;
        this.zzos.zzpZ = rewardedVideoAdRequestParcel.zzpZ;
        super.zza(rewardedVideoAdRequestParcel.zzDy);
    }

    public void zza(zzd com_google_android_gms_ads_internal_reward_client_zzd) {
        zzx.zzch("setRewardedVideoAdListener must be called on the main UI thread.");
        this.zzGg = com_google_android_gms_ads_internal_reward_client_zzd;
    }

    public void zza(RewardItemParcel rewardItemParcel) {
        zzp.zzbJ().zza(this.zzos.context, this.zzos.zzqb.zzIz, this.zzos.zzqg, this.zzos.zzpZ, false, this.zzos.zzqg.zzyQ.zzyt);
        if (this.zzGg != null) {
            try {
                if (this.zzos.zzqg == null || this.zzos.zzqg.zzGG == null || TextUtils.isEmpty(this.zzos.zzqg.zzGG.zzyB)) {
                    this.zzGg.zza(new zzgv(rewardItemParcel.type, rewardItemParcel.zzGE));
                } else {
                    this.zzGg.zza(new zzgv(this.zzos.zzqg.zzGG.zzyB, this.zzos.zzqg.zzGG.zzyC));
                }
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onRewarded().", e);
            }
        }
    }

    public void zza(zza com_google_android_gms_internal_zzhj_zza, zzcd com_google_android_gms_internal_zzcd) {
        if (com_google_android_gms_internal_zzhj_zza.errorCode != -2) {
            zzhu.zzHK.post(new C03781(this, com_google_android_gms_internal_zzhj_zza));
            return;
        }
        this.zzos.zzqz = 0;
        this.zzos.zzqe = new zzhe(this.zzos.context, this.zzGh, com_google_android_gms_internal_zzhj_zza, this);
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("AdRenderer: " + this.zzos.zzqe.getClass().getName());
        this.zzos.zzqe.zzgn();
    }

    public boolean zza(zzhj com_google_android_gms_internal_zzhj, zzhj com_google_android_gms_internal_zzhj2) {
        if (this.zzGg != null) {
            try {
                this.zzGg.onRewardedVideoAdLoaded();
            } catch (Throwable e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdLoaded().", e);
            }
        }
        return true;
    }

    public zzgy zzar(String str) {
        Throwable th;
        zzgy com_google_android_gms_internal_zzgy = (zzgy) this.zzGj.get(str);
        if (com_google_android_gms_internal_zzgy != null) {
            return com_google_android_gms_internal_zzgy;
        }
        try {
            zzgy com_google_android_gms_internal_zzgy2 = new zzgy(this.zzow.zzab(str), this);
            try {
                this.zzGj.put(str, com_google_android_gms_internal_zzgy2);
                return com_google_android_gms_internal_zzgy2;
            } catch (Throwable e) {
                Throwable th2 = e;
                com_google_android_gms_internal_zzgy = com_google_android_gms_internal_zzgy2;
                th = th2;
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to instantiate adapter " + str, th);
                return com_google_android_gms_internal_zzgy;
            }
        } catch (Exception e2) {
            th = e2;
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to instantiate adapter " + str, th);
            return com_google_android_gms_internal_zzgy;
        }
    }

    protected boolean zze(int i) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaE("Failed to load ad: " + i);
        if (this.zzGg == null) {
            return false;
        }
        try {
            this.zzGg.onRewardedVideoAdFailedToLoad(i);
            return true;
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call RewardedVideoAdListener.onAdFailedToLoad().", e);
            return false;
        }
    }

    public void zzfO() {
        zzx.zzch("showAd must be called on the main UI thread.");
        if (isLoaded()) {
            this.zzGi = true;
            zzgy zzar = zzar(this.zzos.zzqg.zzyS);
            if (zzar != null && zzar.zzfQ() != null) {
                try {
                    zzar.zzfQ().showVideo();
                    return;
                } catch (Throwable e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call showVideo.", e);
                    return;
                }
            }
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaE("The reward video has not loaded.");
    }

    public void zzfP() {
        onAdClicked();
    }
}
