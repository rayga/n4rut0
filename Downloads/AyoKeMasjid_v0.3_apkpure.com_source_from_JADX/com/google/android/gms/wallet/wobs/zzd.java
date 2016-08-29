package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzd implements Creator<LoyaltyPointsBalance> {
    static void zza(LoyaltyPointsBalance loyaltyPointsBalance, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, loyaltyPointsBalance.getVersionCode());
        zzb.zzc(parcel, 2, loyaltyPointsBalance.zzaYz);
        zzb.zza(parcel, 3, loyaltyPointsBalance.zzaYA, false);
        zzb.zza(parcel, 4, loyaltyPointsBalance.zzaYB);
        zzb.zza(parcel, 5, loyaltyPointsBalance.zzaWz, false);
        zzb.zza(parcel, 6, loyaltyPointsBalance.zzaYC);
        zzb.zzc(parcel, 7, loyaltyPointsBalance.zzaYD);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkn(x0);
    }

    public LoyaltyPointsBalance zzhf(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    d = zza.zzm(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LoyaltyPointsBalance(i3, i, str2, d, str, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public LoyaltyPointsBalance[] zzkn(int i) {
        return new LoyaltyPointsBalance[i];
    }
}
