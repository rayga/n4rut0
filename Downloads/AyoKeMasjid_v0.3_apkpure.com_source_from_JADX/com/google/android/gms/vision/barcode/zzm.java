package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode.WiFi;

public class zzm implements Creator<WiFi> {
    static void zza(WiFi wiFi, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, wiFi.versionCode);
        zzb.zza(parcel, 2, wiFi.ssid, false);
        zzb.zza(parcel, 3, wiFi.password, false);
        zzb.zzc(parcel, 4, wiFi.encryptionType);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgy(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjC(x0);
    }

    public WiFi zzgy(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new WiFi(i2, str2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public WiFi[] zzjC(int i) {
        return new WiFi[i];
    }
}
