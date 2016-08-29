package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.ArrayList;
import java.util.List;

public class zzf implements Creator<DataStatsResult> {
    static void zza(DataStatsResult dataStatsResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataStatsResult.getStatus(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataStatsResult.getVersionCode());
        zzb.zzc(parcel, 2, dataStatsResult.zzsF(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfo(x0);
    }

    public DataStatsResult zzdu(Parcel parcel) {
        List list = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            Status status2;
            ArrayList zzc;
            int zzai = zza.zzai(parcel);
            List list2;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzc = zza.zzc(parcel, zzai, DataSourceStatsResult.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    List list3 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzai);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzc = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzaj) {
            return new DataStatsResult(i, status, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DataStatsResult[] zzfo(int i) {
        return new DataStatsResult[i];
    }
}
