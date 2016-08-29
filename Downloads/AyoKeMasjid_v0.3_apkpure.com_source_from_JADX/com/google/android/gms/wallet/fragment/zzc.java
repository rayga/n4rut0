package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzc implements Creator<WalletFragmentStyle> {
    static void zza(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, walletFragmentStyle.mVersionCode);
        zzb.zza(parcel, 2, walletFragmentStyle.zzaYk, false);
        zzb.zzc(parcel, 3, walletFragmentStyle.zzaYl);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkh(x0);
    }

    public WalletFragmentStyle zzhb(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public WalletFragmentStyle[] zzkh(int i) {
        return new WalletFragmentStyle[i];
    }
}
