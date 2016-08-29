package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<LandmarkParcel> {
    static void zza(LandmarkParcel landmarkParcel, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, landmarkParcel.versionCode);
        zzb.zza(parcel, 2, landmarkParcel.f10x);
        zzb.zza(parcel, 3, landmarkParcel.f11y);
        zzb.zzc(parcel, 4, landmarkParcel.type);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjH(x0);
    }

    public LandmarkParcel zzgC(Parcel parcel) {
        int i = 0;
        float f = 0.0f;
        int zzaj = zza.zzaj(parcel);
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    f2 = zza.zzl(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    f = zza.zzl(parcel, zzai);
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
            return new LandmarkParcel(i2, f2, f, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public LandmarkParcel[] zzjH(int i) {
        return new LandmarkParcel[i];
    }
}
