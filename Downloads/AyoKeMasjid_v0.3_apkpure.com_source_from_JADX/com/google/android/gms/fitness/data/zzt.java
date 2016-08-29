package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzt implements Creator<Value> {
    static void zza(Value value, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, value.getFormat());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, value.getVersionCode());
        zzb.zza(parcel, 2, value.isSet());
        zzb.zza(parcel, 3, value.zzrM());
        zzb.zza(parcel, 4, value.zzrU(), false);
        zzb.zza(parcel, 5, value.zzrV(), false);
        zzb.zza(parcel, 6, value.zzrW(), false);
        zzb.zza(parcel, 7, value.zzrX(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeC(x0);
    }

    public Value zzcJ(Parcel parcel) {
        boolean z = false;
        float[] fArr = null;
        int zzaj = zza.zzaj(parcel);
        float f = 0.0f;
        int[] iArr = null;
        Bundle bundle = null;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    f = zza.zzl(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    bundle = zza.zzq(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    iArr = zza.zzu(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    fArr = zza.zzx(parcel, zzai);
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
            return new Value(i2, i, z, f, str, bundle, iArr, fArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public Value[] zzeC(int i) {
        return new Value[i];
    }
}
