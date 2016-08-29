package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverPhotoEntity;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.HashSet;
import java.util.Set;

public class zze implements Creator<CoverPhotoEntity> {
    static void zza(CoverPhotoEntity coverPhotoEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        Set set = coverPhotoEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, coverPhotoEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, coverPhotoEntity.zznQ);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, coverPhotoEntity.zzF, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zzc(parcel, 4, coverPhotoEntity.zznP);
        }
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziO(x0);
    }

    public CoverPhotoEntity zzfZ(Parcel parcel) {
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        Set hashSet = new HashSet();
        String str = null;
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
                    str = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case Barcode.PHONE /*4*/:
                    i = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new CoverPhotoEntity(hashSet, i3, i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public CoverPhotoEntity[] zziO(int i) {
        return new CoverPhotoEntity[i];
    }
}
