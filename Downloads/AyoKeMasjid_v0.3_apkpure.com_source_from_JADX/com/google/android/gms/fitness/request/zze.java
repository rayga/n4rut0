package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<DataInsertRequest> {
    static void zza(DataInsertRequest dataInsertRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataInsertRequest.zzrO(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataInsertRequest.getVersionCode());
        zzb.zza(parcel, 2, dataInsertRequest.zzsc(), false);
        zzb.zza(parcel, 3, dataInsertRequest.getPackageName(), false);
        zzb.zza(parcel, 4, dataInsertRequest.zzsg());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeI(x0);
    }

    public DataInsertRequest zzcP(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        IBinder iBinder = null;
        DataSet dataSet = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    dataSet = (DataSet) zza.zza(parcel, zzai, DataSet.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    z = zza.zzc(parcel, zzai);
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
            return new DataInsertRequest(i, dataSet, iBinder, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DataInsertRequest[] zzeI(int i) {
        return new DataInsertRequest[i];
    }
}
