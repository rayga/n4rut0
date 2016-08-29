package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<NearbyAlertRequest> {
    static void zza(NearbyAlertRequest nearbyAlertRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, nearbyAlertRequest.zzvW());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, nearbyAlertRequest.getVersionCode());
        zzb.zzc(parcel, 2, nearbyAlertRequest.zzvZ());
        zzb.zza(parcel, 3, nearbyAlertRequest.zzwa(), i, false);
        zzb.zza(parcel, 4, nearbyAlertRequest.zzwb(), i, false);
        zzb.zza(parcel, 5, nearbyAlertRequest.zzwc());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgZ(x0);
    }

    public NearbyAlertRequest zzeC(Parcel parcel) {
        NearbyAlertFilter nearbyAlertFilter = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = -1;
        PlaceFilter placeFilter = null;
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
                    placeFilter = (PlaceFilter) zza.zza(parcel, zzai, PlaceFilter.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    nearbyAlertFilter = (NearbyAlertFilter) zza.zza(parcel, zzai, NearbyAlertFilter.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
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
            return new NearbyAlertRequest(i3, i2, i, placeFilter, nearbyAlertFilter, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public NearbyAlertRequest[] zzgZ(int i) {
        return new NearbyAlertRequest[i];
    }
}
