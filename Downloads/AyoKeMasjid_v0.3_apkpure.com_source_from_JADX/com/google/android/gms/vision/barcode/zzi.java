package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode.PersonName;

public class zzi implements Creator<PersonName> {
    static void zza(PersonName personName, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, personName.versionCode);
        zzb.zza(parcel, 2, personName.formattedName, false);
        zzb.zza(parcel, 3, personName.pronunciation, false);
        zzb.zza(parcel, 4, personName.prefix, false);
        zzb.zza(parcel, 5, personName.first, false);
        zzb.zza(parcel, 6, personName.middle, false);
        zzb.zza(parcel, 7, personName.last, false);
        zzb.zza(parcel, 8, personName.suffix, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjy(x0);
    }

    public PersonName zzgu(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str7 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str6 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new PersonName(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PersonName[] zzjy(int i) {
        return new PersonName[i];
    }
}
