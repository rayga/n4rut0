package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode.GeoPoint;

public class zzh implements Creator<GeoPoint> {
    static void zza(GeoPoint geoPoint, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, geoPoint.versionCode);
        zzb.zza(parcel, 2, geoPoint.lat);
        zzb.zza(parcel, 3, geoPoint.lng);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjx(x0);
    }

    public GeoPoint zzgt(Parcel parcel) {
        double d = 0.0d;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    d2 = zza.zzm(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    d = zza.zzm(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new GeoPoint(i, d2, d);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public GeoPoint[] zzjx(int i) {
        return new GeoPoint[i];
    }
}
