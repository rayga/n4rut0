package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.reward.client.zzb.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzgk;
import com.google.android.gms.internal.zzgw;

@zzgk
public class zzf extends zzg<zzc> {
    public zzf() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    private zzb zzb(Context context, zzeg com_google_android_gms_internal_zzeg) {
        Throwable e;
        try {
            return zza.zzZ(((zzc) zzar(context)).zza(zze.zzx(context), com_google_android_gms_internal_zzeg, 7895000));
        } catch (RemoteException e2) {
            e = e2;
            zzb.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        } catch (zzg.zza e3) {
            e = e3;
            zzb.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    public zzb zza(Context context, zzeg com_google_android_gms_internal_zzeg) {
        if (zzk.zzcE().zzR(context)) {
            zzb zzb = zzb(context, com_google_android_gms_internal_zzeg);
            if (zzb != null) {
                return zzb;
            }
        }
        zzb.zzaC("Using RewardedVideoAd from the client jar.");
        return new zzgw(context, com_google_android_gms_internal_zzeg, new VersionInfoParcel(7895000, 7895000, true));
    }

    protected zzc zzac(IBinder iBinder) {
        return zzc.zza.zzaa(iBinder);
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzac(iBinder);
    }
}
