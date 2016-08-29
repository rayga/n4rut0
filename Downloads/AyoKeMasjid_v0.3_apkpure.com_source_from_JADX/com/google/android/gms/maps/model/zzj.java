package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzj implements Creator<StreetViewPanoramaCamera> {
    static void zza(StreetViewPanoramaCamera streetViewPanoramaCamera, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, streetViewPanoramaCamera.getVersionCode());
        zzb.zza(parcel, 2, streetViewPanoramaCamera.zoom);
        zzb.zza(parcel, 3, streetViewPanoramaCamera.tilt);
        zzb.zza(parcel, 4, streetViewPanoramaCamera.bearing);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzff(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhF(x0);
    }

    public StreetViewPanoramaCamera zzff(Parcel parcel) {
        float f = 0.0f;
        int zzaj = zza.zzaj(parcel);
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    f2 = zza.zzl(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    f3 = zza.zzl(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    f = zza.zzl(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new StreetViewPanoramaCamera(i, f2, f3, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public StreetViewPanoramaCamera[] zzhF(int i) {
        return new StreetViewPanoramaCamera[i];
    }
}
