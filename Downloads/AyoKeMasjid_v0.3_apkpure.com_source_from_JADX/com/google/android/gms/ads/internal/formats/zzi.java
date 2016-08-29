package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zzi implements Creator<NativeAdOptionsParcel> {
    static void zza(NativeAdOptionsParcel nativeAdOptionsParcel, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, nativeAdOptionsParcel.versionCode);
        zzb.zza(parcel, 2, nativeAdOptionsParcel.zzwn);
        zzb.zzc(parcel, 3, nativeAdOptionsParcel.zzwo);
        zzb.zza(parcel, 4, nativeAdOptionsParcel.zzwp);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzp(x0);
    }

    public NativeAdOptionsParcel zzf(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z2 = zza.zzc(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new NativeAdOptionsParcel(i2, z2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public NativeAdOptionsParcel[] zzp(int i) {
        return new NativeAdOptionsParcel[i];
    }
}
