package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzi implements Creator<RegisterSectionInfo> {
    static void zza(RegisterSectionInfo registerSectionInfo, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, registerSectionInfo.name, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, registerSectionInfo.mVersionCode);
        zzb.zza(parcel, 2, registerSectionInfo.zzPA, false);
        zzb.zza(parcel, 3, registerSectionInfo.zzPB);
        zzb.zzc(parcel, 4, registerSectionInfo.weight);
        zzb.zza(parcel, 5, registerSectionInfo.zzPC);
        zzb.zza(parcel, 6, registerSectionInfo.zzPD, false);
        zzb.zza(parcel, 7, registerSectionInfo.zzPE, i, false);
        zzb.zza(parcel, 8, registerSectionInfo.zzPF, false);
        zzb.zza(parcel, 11, registerSectionInfo.zzPG, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzy(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzal(x0);
    }

    public RegisterSectionInfo[] zzal(int i) {
        return new RegisterSectionInfo[i];
    }

    public RegisterSectionInfo zzy(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 1;
        int[] iArr = null;
        Feature[] featureArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
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
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    featureArr = (Feature[]) zza.zzb(parcel, zzai, Feature.CREATOR);
                    break;
                case Barcode.URL /*8*/:
                    iArr = zza.zzu(parcel, zzai);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    str = zza.zzo(parcel, zzai);
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
            return new RegisterSectionInfo(i2, str4, str3, z2, i, z, str2, featureArr, iArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }
}
