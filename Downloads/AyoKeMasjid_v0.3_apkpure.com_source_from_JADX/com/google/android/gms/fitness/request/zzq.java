package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzq implements Creator<ReadRawRequest> {
    static void zza(ReadRawRequest readRawRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, readRawRequest.zzsc(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, readRawRequest.getVersionCode());
        zzb.zza(parcel, 2, readRawRequest.getPackageName(), false);
        zzb.zzc(parcel, 3, readRawRequest.zzsn(), false);
        zzb.zza(parcel, 4, readRawRequest.zzsi());
        zzb.zza(parcel, 5, readRawRequest.zzsh());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzda(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeT(x0);
    }

    public ReadRawRequest zzda(Parcel parcel) {
        List list = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        boolean z2 = false;
        String str = null;
        IBinder iBinder = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    list = zza.zzc(parcel, zzai, DataSourceQueryParams.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
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
            return new ReadRawRequest(i, iBinder, str, list, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ReadRawRequest[] zzeT(int i) {
        return new ReadRawRequest[i];
    }
}
