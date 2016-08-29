package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzo implements Creator<RawDataSet> {
    static void zza(RawDataSet rawDataSet, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, rawDataSet.zzaow);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, rawDataSet.mVersionCode);
        zzb.zzc(parcel, 2, rawDataSet.zzaoy);
        zzb.zzc(parcel, 3, rawDataSet.zzaoz, false);
        zzb.zza(parcel, 4, rawDataSet.zzanA);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzex(x0);
    }

    public RawDataSet zzcF(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    list = zza.zzc(parcel, zzai, RawDataPoint.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new RawDataSet(i3, i2, i, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public RawDataSet[] zzex(int i) {
        return new RawDataSet[i];
    }
}
