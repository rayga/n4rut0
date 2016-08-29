package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.ads.internal.client.zzv.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzgk;

@zzgk
public class zzac extends zzg<zzw> {
    public zzac() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    private zzv zzu(Context context) {
        try {
            return zza.zzo(((zzw) zzar(context)).zza(zze.zzx(context), 7895000));
        } catch (Throwable e) {
            zzb.zzd("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (Throwable e2) {
            zzb.zzd("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzq(iBinder);
    }

    protected zzw zzq(IBinder iBinder) {
        return zzw.zza.zzp(iBinder);
    }

    public zzv zzt(Context context) {
        if (zzk.zzcE().zzR(context)) {
            zzv zzu = zzu(context);
            if (zzu != null) {
                return zzu;
            }
        }
        zzb.zzaC("Using MobileAdsSettingManager from the client jar.");
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(7895000, 7895000, true);
        return zzm.zzq(context);
    }
}
