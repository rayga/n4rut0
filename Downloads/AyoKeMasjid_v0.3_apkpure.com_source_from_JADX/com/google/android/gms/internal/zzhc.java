package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zzgk
public class zzhc extends zza {
    private zzhd zzGq;
    private zzha zzGw;
    private zzhb zzGx;

    public zzhc(zzhb com_google_android_gms_internal_zzhb) {
        this.zzGx = com_google_android_gms_internal_zzhb;
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd, RewardItemParcel rewardItemParcel) {
        if (this.zzGx != null) {
            this.zzGx.zza(rewardItemParcel);
        }
    }

    public void zza(zzha com_google_android_gms_internal_zzha) {
        this.zzGw = com_google_android_gms_internal_zzha;
    }

    public void zza(zzhd com_google_android_gms_internal_zzhd) {
        this.zzGq = com_google_android_gms_internal_zzhd;
    }

    public void zzb(zzd com_google_android_gms_dynamic_zzd, int i) {
        if (this.zzGw != null) {
            this.zzGw.zzJ(i);
        }
    }

    public void zzc(zzd com_google_android_gms_dynamic_zzd, int i) {
        if (this.zzGq != null) {
            this.zzGq.zzb(zze.zzp(com_google_android_gms_dynamic_zzd).getClass().getName(), i);
        }
    }

    public void zzg(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzGw != null) {
            this.zzGw.zzfS();
        }
    }

    public void zzh(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzGq != null) {
            this.zzGq.zzas(zze.zzp(com_google_android_gms_dynamic_zzd).getClass().getName());
        }
    }

    public void zzi(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzGx != null) {
            this.zzGx.onRewardedVideoAdOpened();
        }
    }

    public void zzj(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzGx != null) {
            this.zzGx.onRewardedVideoStarted();
        }
    }

    public void zzk(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzGx != null) {
            this.zzGx.onRewardedVideoAdClosed();
        }
    }

    public void zzl(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzGx != null) {
            this.zzGx.zzfP();
        }
    }

    public void zzm(zzd com_google_android_gms_dynamic_zzd) {
        if (this.zzGx != null) {
            this.zzGx.onRewardedVideoAdLeftApplication();
        }
    }
}
