package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzj implements Creator<ValuesRemovedDetails> {
    static void zza(ValuesRemovedDetails valuesRemovedDetails, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, valuesRemovedDetails.mVersionCode);
        zzb.zzc(parcel, 2, valuesRemovedDetails.mIndex);
        zzb.zzc(parcel, 3, valuesRemovedDetails.zzamf);
        zzb.zzc(parcel, 4, valuesRemovedDetails.zzamg);
        zzb.zza(parcel, 5, valuesRemovedDetails.zzamG, false);
        zzb.zzc(parcel, 6, valuesRemovedDetails.zzamH);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeg(x0);
    }

    public ValuesRemovedDetails zzcr(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i5 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ValuesRemovedDetails(i5, i4, i3, i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ValuesRemovedDetails[] zzeg(int i) {
        return new ValuesRemovedDetails[i];
    }
}
