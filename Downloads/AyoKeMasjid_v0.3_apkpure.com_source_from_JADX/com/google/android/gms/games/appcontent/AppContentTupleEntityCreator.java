package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class AppContentTupleEntityCreator implements Creator<AppContentTupleEntity> {
    static void zza(AppContentTupleEntity appContentTupleEntity, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, appContentTupleEntity.getName(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, appContentTupleEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentTupleEntity.getValue(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfH(x0);
    }

    public AppContentTupleEntity zzdM(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
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
            return new AppContentTupleEntity(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public AppContentTupleEntity[] zzfH(int i) {
        return new AppContentTupleEntity[i];
    }
}
