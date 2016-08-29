package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzd implements Creator<DataSourceStatsResult> {
    static void zza(DataSourceStatsResult dataSourceStatsResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataSourceStatsResult.zzanm, i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataSourceStatsResult.mVersionCode);
        zzb.zza(parcel, 2, dataSourceStatsResult.zzQD);
        zzb.zza(parcel, 3, dataSourceStatsResult.zzaqJ);
        zzb.zza(parcel, 4, dataSourceStatsResult.zzaqK);
        zzb.zza(parcel, 5, dataSourceStatsResult.zzaqL);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzds(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfm(x0);
    }

    public DataSourceStatsResult zzds(Parcel parcel) {
        boolean z = false;
        long j = 0;
        int zzaj = zza.zzaj(parcel);
        DataSource dataSource = null;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    dataSource = (DataSource) zza.zza(parcel, zzai, DataSource.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j3 = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    j = zza.zzi(parcel, zzai);
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
            return new DataSourceStatsResult(i, dataSource, j3, z, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DataSourceStatsResult[] zzfm(int i) {
        return new DataSourceStatsResult[i];
    }
}
