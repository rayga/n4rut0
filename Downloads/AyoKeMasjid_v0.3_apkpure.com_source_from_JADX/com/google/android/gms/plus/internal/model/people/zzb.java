package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.plus.internal.model.people.PersonEntity.AgeRangeEntity;
import java.util.HashSet;
import java.util.Set;

public class zzb implements Creator<AgeRangeEntity> {
    static void zza(AgeRangeEntity ageRangeEntity, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        Set set = ageRangeEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, ageRangeEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, ageRangeEntity.zzaNk);
        }
        if (set.contains(Integer.valueOf(3))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, ageRangeEntity.zzaNl);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziL(x0);
    }

    public AgeRangeEntity zzfW(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i3 = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AgeRangeEntity(hashSet, i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AgeRangeEntity[] zziL(int i) {
        return new AgeRangeEntity[i];
    }
}
