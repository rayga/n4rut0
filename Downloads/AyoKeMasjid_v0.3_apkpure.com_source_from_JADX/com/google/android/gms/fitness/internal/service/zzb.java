package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzb implements Creator<FitnessUnregistrationRequest> {
    static void zza(FitnessUnregistrationRequest fitnessUnregistrationRequest, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, fitnessUnregistrationRequest.getDataSource(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, fitnessUnregistrationRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeE(x0);
    }

    public FitnessUnregistrationRequest zzcL(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    dataSource = (DataSource) zza.zza(parcel, zzai, DataSource.CREATOR);
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
            return new FitnessUnregistrationRequest(i, dataSource);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public FitnessUnregistrationRequest[] zzeE(int i) {
        return new FitnessUnregistrationRequest[i];
    }
}
