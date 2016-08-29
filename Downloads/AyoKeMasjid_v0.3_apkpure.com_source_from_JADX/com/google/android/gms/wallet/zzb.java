package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;

public class zzb implements Creator<Cart> {
    static void zza(Cart cart, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, cart.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, cart.zzaWb, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, cart.zzaWc, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, cart.zzaWd, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjK(x0);
    }

    public Cart zzgF(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        ArrayList arrayList = new ArrayList();
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
                    arrayList = zza.zzc(parcel, zzai, LineItem.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public Cart[] zzjK(int i) {
        return new Cart[i];
    }
}
