package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode.DriverLicense;

public class zzf implements Creator<DriverLicense> {
    static void zza(DriverLicense driverLicense, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, driverLicense.versionCode);
        zzb.zza(parcel, 2, driverLicense.documentType, false);
        zzb.zza(parcel, 3, driverLicense.firstName, false);
        zzb.zza(parcel, 4, driverLicense.middleName, false);
        zzb.zza(parcel, 5, driverLicense.lastName, false);
        zzb.zza(parcel, 6, driverLicense.gender, false);
        zzb.zza(parcel, 7, driverLicense.addressStreet, false);
        zzb.zza(parcel, 8, driverLicense.addressCity, false);
        zzb.zza(parcel, 9, driverLicense.addressState, false);
        zzb.zza(parcel, 10, driverLicense.addressZip, false);
        zzb.zza(parcel, 11, driverLicense.licenseNumber, false);
        zzb.zza(parcel, 12, driverLicense.issueDate, false);
        zzb.zza(parcel, 13, driverLicense.expiryDate, false);
        zzb.zza(parcel, 14, driverLicense.birthDate, false);
        zzb.zza(parcel, 15, driverLicense.issuingCountry, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjv(x0);
    }

    public DriverLicense zzgr(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str6 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    str7 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    str8 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    str9 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    str10 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    str11 = zza.zzo(parcel, zzai);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    str12 = zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    str13 = zza.zzo(parcel, zzai);
                    break;
                case Place.TYPE_CAFE /*15*/:
                    str14 = zza.zzo(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new DriverLicense(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DriverLicense[] zzjv(int i) {
        return new DriverLicense[i];
    }
}
