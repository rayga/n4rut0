package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzk implements Creator<LocationRequestInternal> {
    static void zza(LocationRequestInternal locationRequestInternal, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, locationRequestInternal.zzaqq, i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, locationRequestInternal.getVersionCode());
        zzb.zza(parcel, 2, locationRequestInternal.zzaCU);
        zzb.zza(parcel, 3, locationRequestInternal.zzaCV);
        zzb.zza(parcel, 4, locationRequestInternal.zzaCW);
        zzb.zzc(parcel, 5, locationRequestInternal.zzaCX, false);
        zzb.zza(parcel, 6, locationRequestInternal.mTag, false);
        zzb.zza(parcel, 7, locationRequestInternal.zzaCY);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzew(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgR(x0);
    }

    public LocationRequestInternal zzew(Parcel parcel) {
        String str = null;
        boolean z = true;
        boolean z2 = false;
        int zzaj = zza.zzaj(parcel);
        List list = LocationRequestInternal.zzaCT;
        boolean z3 = true;
        boolean z4 = false;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    locationRequest = (LocationRequest) zza.zza(parcel, zzai, LocationRequest.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z4 = zza.zzc(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z3 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    list = zza.zzc(parcel, zzai, ClientIdentity.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    z2 = zza.zzc(parcel, zzai);
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
            return new LocationRequestInternal(i, locationRequest, z4, z3, z, list, str, z2);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public LocationRequestInternal[] zzgR(int i) {
        return new LocationRequestInternal[i];
    }
}
