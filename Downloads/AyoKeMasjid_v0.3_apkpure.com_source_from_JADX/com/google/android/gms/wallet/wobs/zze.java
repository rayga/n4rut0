package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<LoyaltyPoints> {
    static void zza(LoyaltyPoints loyaltyPoints, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, loyaltyPoints.getVersionCode());
        zzb.zza(parcel, 2, loyaltyPoints.label, false);
        zzb.zza(parcel, 3, loyaltyPoints.zzaYy, i, false);
        zzb.zza(parcel, 4, loyaltyPoints.type, false);
        zzb.zza(parcel, 5, loyaltyPoints.zzaWR, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzko(x0);
    }

    public LoyaltyPoints zzhg(Parcel parcel) {
        TimeInterval timeInterval = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        LoyaltyPointsBalance loyaltyPointsBalance = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    loyaltyPointsBalance = (LoyaltyPointsBalance) zza.zza(parcel, zzai, LoyaltyPointsBalance.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    timeInterval = (TimeInterval) zza.zza(parcel, zzai, TimeInterval.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LoyaltyPoints(i, str2, loyaltyPointsBalance, str, timeInterval);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public LoyaltyPoints[] zzko(int i) {
        return new LoyaltyPoints[i];
    }
}
