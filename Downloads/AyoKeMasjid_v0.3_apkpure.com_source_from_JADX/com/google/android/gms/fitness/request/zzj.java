package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzj implements Creator<DataTypeReadRequest> {
    static void zza(DataTypeReadRequest dataTypeReadRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataTypeReadRequest.getName(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataTypeReadRequest.getVersionCode());
        zzb.zza(parcel, 3, dataTypeReadRequest.zzsc(), false);
        zzb.zza(parcel, 4, dataTypeReadRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeN(x0);
    }

    public DataTypeReadRequest zzcU(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        String str2 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str = zza.zzo(parcel, zzai);
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
            return new DataTypeReadRequest(i, str2, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DataTypeReadRequest[] zzeN(int i) {
        return new DataTypeReadRequest[i];
    }
}
