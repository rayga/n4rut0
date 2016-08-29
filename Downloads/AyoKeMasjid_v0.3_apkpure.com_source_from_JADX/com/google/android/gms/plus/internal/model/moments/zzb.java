package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.HashSet;
import java.util.Set;

public class zzb implements Creator<MomentEntity> {
    static void zza(MomentEntity momentEntity, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        Set set = momentEntity.zzaLT;
        if (set.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, momentEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, momentEntity.zzwj, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, momentEntity.zzaMO, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, momentEntity.zzaMG, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, momentEntity.zzaMP, i, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, momentEntity.zzFz, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziJ(x0);
    }

    public MomentEntity zzfU(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        ItemScopeEntity itemScopeEntity = null;
        String str2 = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            ItemScopeEntity itemScopeEntity3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str3 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case Barcode.PHONE /*4*/:
                    itemScopeEntity3 = (ItemScopeEntity) zza.zza(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    itemScopeEntity2 = itemScopeEntity3;
                    break;
                case Barcode.PRODUCT /*5*/:
                    str2 = zza.zzo(parcel, zzai);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case Barcode.SMS /*6*/:
                    itemScopeEntity3 = (ItemScopeEntity) zza.zza(parcel, zzai, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    itemScopeEntity = itemScopeEntity3;
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
            return new MomentEntity(hashSet, i, str3, itemScopeEntity2, str2, itemScopeEntity, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public MomentEntity[] zziJ(int i) {
        return new MomentEntity[i];
    }
}
