package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzg implements Creator<PlaceFilter> {
    static void zza(PlaceFilter placeFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, placeFilter.zzaDm, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, placeFilter.mVersionCode);
        zzb.zza(parcel, 3, placeFilter.zzaDz);
        zzb.zzc(parcel, 4, placeFilter.zzaDp, false);
        zzb.zzb(parcel, 6, placeFilter.zzaDo, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzha(x0);
    }

    public PlaceFilter zzeD(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzaj = zza.zzaj(parcel);
        List list2 = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list3 = zza.zzB(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    list = zza.zzc(parcel, zzai, UserDataType.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    list2 = zza.zzC(parcel, zzai);
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
            return new PlaceFilter(i, list3, z, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PlaceFilter[] zzha(int i) {
        return new PlaceFilter[i];
    }
}
