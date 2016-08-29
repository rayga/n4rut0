package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode.Email;

public class zzg implements Creator<Email> {
    static void zza(Email email, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, email.versionCode);
        zzb.zzc(parcel, 2, email.type);
        zzb.zza(parcel, 3, email.address, false);
        zzb.zza(parcel, 4, email.subject, false);
        zzb.zza(parcel, 5, email.body, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjw(x0);
    }

    public Email zzgs(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Email(i2, i, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public Email[] zzjw(int i) {
        return new Email[i];
    }
}
