package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzaa implements Creator<StartBleScanRequest> {
    static void zza(StartBleScanRequest startBleScanRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, startBleScanRequest.getDataTypes(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, startBleScanRequest.getVersionCode());
        zzb.zza(parcel, 2, startBleScanRequest.zzsy(), false);
        zzb.zzc(parcel, 3, startBleScanRequest.getTimeoutSecs());
        zzb.zza(parcel, 4, startBleScanRequest.zzsc(), false);
        zzb.zza(parcel, 5, startBleScanRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfe(x0);
    }

    public StartBleScanRequest zzdk(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list = zza.zzc(parcel, zzai, DataType.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new StartBleScanRequest(i2, list, iBinder2, i, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public StartBleScanRequest[] zzfe(int i) {
        return new StartBleScanRequest[i];
    }
}
