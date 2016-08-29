package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class MilestoneEntityCreator implements Creator<MilestoneEntity> {
    static void zza(MilestoneEntity milestoneEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, milestoneEntity.getMilestoneId(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, milestoneEntity.getVersionCode());
        zzb.zza(parcel, 2, milestoneEntity.getCurrentProgress());
        zzb.zza(parcel, 3, milestoneEntity.getTargetProgress());
        zzb.zza(parcel, 4, milestoneEntity.getCompletionRewardData(), false);
        zzb.zzc(parcel, 5, milestoneEntity.getState());
        zzb.zza(parcel, 6, milestoneEntity.getEventId(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgh(x0);
    }

    public MilestoneEntity zzdZ(Parcel parcel) {
        long j = 0;
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        byte[] bArr = null;
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    bArr = zza.zzr(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new MilestoneEntity(i2, str2, j2, j, bArr, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public MilestoneEntity[] zzgh(int i) {
        return new MilestoneEntity[i];
    }
}
