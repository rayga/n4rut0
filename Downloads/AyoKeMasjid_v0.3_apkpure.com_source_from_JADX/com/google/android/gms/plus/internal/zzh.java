package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzh implements Creator<PlusSession> {
    static void zza(PlusSession plusSession, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, plusSession.getAccountName(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, plusSession.getVersionCode());
        zzb.zza(parcel, 2, plusSession.zzyL(), false);
        zzb.zza(parcel, 3, plusSession.zzyM(), false);
        zzb.zza(parcel, 4, plusSession.zzyN(), false);
        zzb.zza(parcel, 5, plusSession.zzyO(), false);
        zzb.zza(parcel, 6, plusSession.zzyP(), false);
        zzb.zza(parcel, 7, plusSession.zzml(), false);
        zzb.zza(parcel, 8, plusSession.zzyQ(), false);
        zzb.zza(parcel, 9, plusSession.zzyR(), i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziH(x0);
    }

    public PlusSession zzfS(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str5 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    strArr3 = zza.zzA(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    strArr2 = zza.zzA(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    strArr = zza.zzA(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str4 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    str3 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    plusCommonExtras = (PlusCommonExtras) zza.zza(parcel, zzai, PlusCommonExtras.CREATOR);
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
            return new PlusSession(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public PlusSession[] zziH(int i) {
        return new PlusSession[i];
    }
}
