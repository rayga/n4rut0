package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzg implements Creator<DataTypeResult> {
    static void zza(DataTypeResult dataTypeResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataTypeResult.getStatus(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataTypeResult.getVersionCode());
        zzb.zza(parcel, 3, dataTypeResult.getDataType(), i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfp(x0);
    }

    public DataTypeResult zzdv(Parcel parcel) {
        DataType dataType = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            DataType dataType2;
            Status status2;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    dataType2 = dataType;
                    status2 = status3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    dataType2 = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    DataType dataType3 = dataType;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzai);
                    dataType2 = dataType3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    dataType2 = dataType;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataType = dataType2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new DataTypeResult(i, status, dataType);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DataTypeResult[] zzfp(int i) {
        return new DataTypeResult[i];
    }
}
