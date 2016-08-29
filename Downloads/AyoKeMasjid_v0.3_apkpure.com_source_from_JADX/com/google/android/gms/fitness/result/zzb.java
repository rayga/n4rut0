package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzb implements Creator<DailyTotalResult> {
    static void zza(DailyTotalResult dailyTotalResult, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, dailyTotalResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dailyTotalResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, dailyTotalResult.getTotal(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfk(x0);
    }

    public DailyTotalResult zzdq(Parcel parcel) {
        DataSet dataSet = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            DataSet dataSet2;
            Status status2;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    dataSet2 = dataSet;
                    status2 = status3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    dataSet2 = (DataSet) zza.zza(parcel, zzai, DataSet.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    DataSet dataSet3 = dataSet;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzai);
                    dataSet2 = dataSet3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    dataSet2 = dataSet;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new DailyTotalResult(i, status, dataSet);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DailyTotalResult[] zzfk(int i) {
        return new DailyTotalResult[i];
    }
}
