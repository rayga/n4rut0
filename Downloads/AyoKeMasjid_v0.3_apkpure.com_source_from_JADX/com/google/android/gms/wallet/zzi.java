package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzi implements Creator<LineItem> {
    static void zza(LineItem lineItem, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, lineItem.getVersionCode());
        zzb.zza(parcel, 2, lineItem.description, false);
        zzb.zza(parcel, 3, lineItem.zzaWE, false);
        zzb.zza(parcel, 4, lineItem.zzaWF, false);
        zzb.zza(parcel, 5, lineItem.zzaWb, false);
        zzb.zzc(parcel, 6, lineItem.zzaWG);
        zzb.zza(parcel, 7, lineItem.zzaWc, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjR(x0);
    }

    public LineItem zzgM(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public LineItem[] zzjR(int i) {
        return new LineItem[i];
    }
}
