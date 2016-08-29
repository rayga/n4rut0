package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class zzg implements Creator<DataType> {
    static void zza(DataType dataType, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataType.getName(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataType.getVersionCode());
        zzb.zzc(parcel, 2, dataType.getFields(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzer(x0);
    }

    public DataType zzcz(Parcel parcel) {
        List list = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    list = zza.zzc(parcel, zzai, Field.CREATOR);
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
            return new DataType(i, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DataType[] zzer(int i) {
        return new DataType[i];
    }
}
