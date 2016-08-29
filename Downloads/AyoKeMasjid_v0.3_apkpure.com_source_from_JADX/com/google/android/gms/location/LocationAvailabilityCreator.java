package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class LocationAvailabilityCreator implements Creator<LocationAvailability> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(LocationAvailability locationAvailability, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, locationAvailability.zzaBS);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, locationAvailability.getVersionCode());
        zzb.zzc(parcel, 2, locationAvailability.zzaBT);
        zzb.zza(parcel, 3, locationAvailability.zzaBU);
        zzb.zzc(parcel, 4, locationAvailability.zzaBV);
        zzb.zzH(parcel, zzak);
    }

    public LocationAvailability createFromParcel(Parcel parcel) {
        int i = 1;
        int zzaj = zza.zzaj(parcel);
        int i2 = 0;
        int i3 = GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE;
        long j = 0;
        int i4 = 1;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i4 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i3 = zza.zzg(parcel, zzai);
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
            return new LocationAvailability(i2, i3, i4, i, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public LocationAvailability[] newArray(int size) {
        return new LocationAvailability[size];
    }
}
