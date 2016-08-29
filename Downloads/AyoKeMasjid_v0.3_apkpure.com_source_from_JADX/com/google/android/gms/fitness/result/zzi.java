package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzi implements Creator<ReadRawResult> {
    static void zza(ReadRawResult readRawResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, readRawResult.zzqA(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, readRawResult.getVersionCode());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfr(x0);
    }

    public ReadRawResult zzdx(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    dataHolder = (DataHolder) zza.zza(parcel, zzai, DataHolder.CREATOR);
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
            return new ReadRawResult(i, dataHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ReadRawResult[] zzfr(int i) {
        return new ReadRawResult[i];
    }
}
