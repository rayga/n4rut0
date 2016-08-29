package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class zzn implements Creator<OfferWalletObject> {
    static void zza(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, offerWalletObject.getVersionCode());
        zzb.zza(parcel, 2, offerWalletObject.zzhL, false);
        zzb.zza(parcel, 3, offerWalletObject.zzaXu, false);
        zzb.zza(parcel, 4, offerWalletObject.zzaWv, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjW(x0);
    }

    public OfferWalletObject zzgR(Parcel parcel) {
        CommonWalletObject commonWalletObject = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
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
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    commonWalletObject = (CommonWalletObject) zza.zza(parcel, zzai, CommonWalletObject.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new OfferWalletObject(i, str2, str, commonWalletObject);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public OfferWalletObject[] zzjW(int i) {
        return new OfferWalletObject[i];
    }
}
