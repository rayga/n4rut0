package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.vision.barcode.Barcode;

public class zzk implements Creator<PlaceRequest> {
    static void zza(PlaceRequest placeRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, placeRequest.mVersionCode);
        zzb.zza(parcel, 2, placeRequest.zzwa(), i, false);
        zzb.zza(parcel, 3, placeRequest.getInterval());
        zzb.zzc(parcel, 4, placeRequest.getPriority());
        zzb.zza(parcel, 5, placeRequest.getExpirationTime());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhf(x0);
    }

    public PlaceRequest zzeH(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        PlaceFilter placeFilter = null;
        long j = PlaceRequest.zzaDJ;
        int i2 = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        long j2 = Long.MAX_VALUE;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    placeFilter = (PlaceFilter) zza.zza(parcel, zzai, PlaceFilter.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    j2 = zza.zzi(parcel, zzai);
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
            return new PlaceRequest(i, placeFilter, j, i2, j2);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PlaceRequest[] zzhf(int i) {
        return new PlaceRequest[i];
    }
}
