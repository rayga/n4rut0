package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzf implements Creator<FullWalletRequest> {
    static void zza(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, fullWalletRequest.getVersionCode());
        zzb.zza(parcel, 2, fullWalletRequest.zzaWi, false);
        zzb.zza(parcel, 3, fullWalletRequest.zzaWj, false);
        zzb.zza(parcel, 4, fullWalletRequest.zzaWt, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjO(x0);
    }

    public FullWalletRequest zzgJ(Parcel parcel) {
        Cart cart = null;
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
                    cart = (Cart) zza.zza(parcel, zzai, Cart.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public FullWalletRequest[] zzjO(int i) {
        return new FullWalletRequest[i];
    }
}
