package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.plus.internal.model.people.PersonEntity.NameEntity;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.HashSet;
import java.util.Set;

public class zzg implements Creator<NameEntity> {
    static void zza(NameEntity nameEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set set = nameEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, nameEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, nameEntity.zzaMr, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, nameEntity.zzaNr, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, nameEntity.zzaMu, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, nameEntity.zzaNs, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, nameEntity.zzaNt, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, nameEntity.zzaNu, true);
        }
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziQ(x0);
    }

    public NameEntity zzgb(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str6 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str5 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Barcode.PHONE /*4*/:
                    str4 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case Barcode.PRODUCT /*5*/:
                    str3 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Barcode.SMS /*6*/:
                    str2 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case Barcode.TEXT /*7*/:
                    str = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new NameEntity(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public NameEntity[] zziQ(int i) {
        return new NameEntity[i];
    }
}
