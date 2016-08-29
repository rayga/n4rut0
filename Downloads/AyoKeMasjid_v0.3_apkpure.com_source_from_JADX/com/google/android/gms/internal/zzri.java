package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzrd.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class zzri extends zzg<zzrd> {
    private static zzri zzaYt;

    protected zzri() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    private static zzri zzCm() {
        if (zzaYt == null) {
            zzaYt = new zzri();
        }
        return zzaYt;
    }

    public static zzra zza(Activity activity, zzc com_google_android_gms_dynamic_zzc, WalletFragmentOptions walletFragmentOptions, zzrb com_google_android_gms_internal_zzrb) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((zzrd) zzCm().zzar(activity)).zza(zze.zzx(activity), com_google_android_gms_dynamic_zzc, walletFragmentOptions, com_google_android_gms_internal_zzrb);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzdW(iBinder);
    }

    protected zzrd zzdW(IBinder iBinder) {
        return zza.zzdS(iBinder);
    }
}
