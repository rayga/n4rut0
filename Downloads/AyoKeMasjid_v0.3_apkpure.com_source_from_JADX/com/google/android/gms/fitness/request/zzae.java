package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzae implements Creator<UnsubscribeRequest> {
    static void zza(UnsubscribeRequest unsubscribeRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, unsubscribeRequest.getDataType(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, unsubscribeRequest.getVersionCode());
        zzb.zza(parcel, 2, unsubscribeRequest.getDataSource(), i, false);
        zzb.zza(parcel, 3, unsubscribeRequest.zzsc(), false);
        zzb.zza(parcel, 4, unsubscribeRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfi(x0);
    }

    public UnsubscribeRequest zzdo(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        DataSource dataSource = null;
        DataType dataType = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    dataType = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    dataSource = (DataSource) zza.zza(parcel, zzai, DataSource.CREATOR);
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
            return new UnsubscribeRequest(i, dataType, dataSource, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public UnsubscribeRequest[] zzfi(int i) {
        return new UnsubscribeRequest[i];
    }
}
