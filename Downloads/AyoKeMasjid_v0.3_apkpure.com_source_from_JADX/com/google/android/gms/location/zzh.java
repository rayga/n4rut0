package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzh implements Creator<LocationSettingsStates> {
    static void zza(LocationSettingsStates locationSettingsStates, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, locationSettingsStates.isGpsUsable());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, locationSettingsStates.getVersionCode());
        zzb.zza(parcel, 2, locationSettingsStates.isNetworkLocationUsable());
        zzb.zza(parcel, 3, locationSettingsStates.isBleUsable());
        zzb.zza(parcel, 4, locationSettingsStates.isGpsPresent());
        zzb.zza(parcel, 5, locationSettingsStates.isNetworkLocationPresent());
        zzb.zza(parcel, 6, locationSettingsStates.isBlePresent());
        zzb.zza(parcel, 7, locationSettingsStates.zzvM());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzet(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgL(x0);
    }

    public LocationSettingsStates zzet(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    z7 = zza.zzc(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z6 = zza.zzc(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z5 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    z4 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z3 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
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
            return new LocationSettingsStates(i, z7, z6, z5, z4, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public LocationSettingsStates[] zzgL(int i) {
        return new LocationSettingsStates[i];
    }
}
