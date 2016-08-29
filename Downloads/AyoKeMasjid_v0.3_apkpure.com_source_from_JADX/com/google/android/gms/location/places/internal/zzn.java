package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzn implements Creator<PlaceLocalization> {
    static void zza(PlaceLocalization placeLocalization, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, placeLocalization.name, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, placeLocalization.versionCode);
        zzb.zza(parcel, 2, placeLocalization.address, false);
        zzb.zza(parcel, 3, placeLocalization.zzaEK, false);
        zzb.zza(parcel, 4, placeLocalization.zzaEL, false);
        zzb.zzb(parcel, 5, placeLocalization.zzaEM, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhm(x0);
    }

    public PlaceLocalization zzeM(Parcel parcel) {
        List list = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    list = zza.zzC(parcel, zzai);
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
            return new PlaceLocalization(i, str4, str3, str2, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PlaceLocalization[] zzhm(int i) {
        return new PlaceLocalization[i];
    }
}
