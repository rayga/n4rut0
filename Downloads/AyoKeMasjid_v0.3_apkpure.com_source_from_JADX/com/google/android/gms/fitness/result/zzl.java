package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzl implements Creator<SyncInfoResult> {
    static void zza(SyncInfoResult syncInfoResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, syncInfoResult.getStatus(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, syncInfoResult.getVersionCode());
        zzb.zza(parcel, 2, syncInfoResult.zzsH());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfu(x0);
    }

    public SyncInfoResult zzdA(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Status status = null;
        long j = 0;
        while (parcel.dataPosition() < zzaj) {
            Status status2;
            int i2;
            long j2;
            int zzai = zza.zzai(parcel);
            long j3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    j3 = j;
                    status2 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    i2 = i;
                    j2 = j3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j2 = zza.zzi(parcel, zzai);
                    status2 = status;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    j3 = j;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzai);
                    j2 = j3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    j2 = j;
                    status2 = status;
                    i2 = i;
                    break;
            }
            status = status2;
            i = i2;
            j = j2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SyncInfoResult(i, status, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SyncInfoResult[] zzfu(int i) {
        return new SyncInfoResult[i];
    }
}
