package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zza implements Creator<Credential> {
    static void zza(Credential credential, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, (int) Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_1, credential.zzlr(), false);
        zzb.zza(parcel, 1, credential.getId(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, credential.mVersionCode);
        zzb.zza(parcel, 2, credential.getName(), false);
        zzb.zza(parcel, 3, credential.getProfilePictureUri(), i, false);
        zzb.zza(parcel, (int) Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_2, credential.zzls(), false);
        zzb.zzc(parcel, 4, credential.zzlt(), false);
        zzb.zza(parcel, 5, credential.getPassword(), false);
        zzb.zza(parcel, 6, credential.getAccountType(), false);
        zzb.zza(parcel, 7, credential.getGeneratedPassword(), false);
        zzb.zza(parcel, 8, credential.zzlu(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzat(x0);
    }

    public Credential zzD(Parcel parcel) {
        String str = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        List list = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, Uri.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, IdToken.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_1 /*1001*/:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_ADMINISTRATIVE_AREA_LEVEL_2 /*1002*/:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Credential(i, str8, str7, str6, str5, uri, list, str4, str3, str2, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public Credential[] zzat(int i) {
        return new Credential[i];
    }
}
