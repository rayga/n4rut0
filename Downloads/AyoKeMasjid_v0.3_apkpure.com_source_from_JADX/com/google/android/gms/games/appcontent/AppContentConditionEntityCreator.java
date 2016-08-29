package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class AppContentConditionEntityCreator implements Creator<AppContentConditionEntity> {
    static void zza(AppContentConditionEntity appContentConditionEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, appContentConditionEntity.zztq(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, appContentConditionEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentConditionEntity.zztr(), false);
        zzb.zza(parcel, 3, appContentConditionEntity.zzts(), false);
        zzb.zza(parcel, 4, appContentConditionEntity.zztt(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfF(x0);
    }

    public AppContentConditionEntity zzdK(Parcel parcel) {
        Bundle bundle = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new AppContentConditionEntity(i, str3, str2, str, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AppContentConditionEntity[] zzfF(int i) {
        return new AppContentConditionEntity[i];
    }
}
