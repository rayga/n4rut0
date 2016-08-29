package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.plus.internal.model.people.PersonEntity.ImageEntity;
import java.util.HashSet;
import java.util.Set;

public class zzf implements Creator<ImageEntity> {
    static void zza(ImageEntity imageEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set set = imageEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, imageEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, imageEntity.zzF, true);
        }
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzga(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziP(x0);
    }

    public ImageEntity zzga(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ImageEntity(hashSet, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ImageEntity[] zziP(int i) {
        return new ImageEntity[i];
    }
}
