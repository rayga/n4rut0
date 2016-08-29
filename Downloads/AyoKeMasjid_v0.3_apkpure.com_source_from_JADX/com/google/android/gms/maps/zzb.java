package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.vision.barcode.Barcode;

public class zzb implements Creator<StreetViewPanoramaOptions> {
    static void zza(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, streetViewPanoramaOptions.getPosition(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, streetViewPanoramaOptions.zzwT());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, streetViewPanoramaOptions.zzwJ());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, streetViewPanoramaOptions.zzwU());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, streetViewPanoramaOptions.zzwV());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, streetViewPanoramaOptions.zzwF());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhv(x0);
    }

    public StreetViewPanoramaOptions zzeV(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int zzaj = zza.zzaj(parcel);
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) zza.zza(parcel, zzai, StreetViewPanoramaCamera.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    latLng = (LatLng) zza.zza(parcel, zzai, LatLng.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    num = zza.zzh(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    b5 = zza.zze(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    b4 = zza.zze(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    b3 = zza.zze(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    b2 = zza.zze(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    b = zza.zze(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public StreetViewPanoramaOptions[] zzhv(int i) {
        return new StreetViewPanoramaOptions[i];
    }
}
