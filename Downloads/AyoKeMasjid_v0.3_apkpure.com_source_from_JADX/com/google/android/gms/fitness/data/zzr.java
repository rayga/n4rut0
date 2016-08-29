package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzr implements Creator<Subscription> {
    static void zza(Subscription subscription, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, subscription.getDataSource(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, subscription.getVersionCode());
        zzb.zza(parcel, 2, subscription.getDataType(), i, false);
        zzb.zza(parcel, 3, subscription.zzrP());
        zzb.zzc(parcel, 4, subscription.getAccuracyMode());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeB(x0);
    }

    public Subscription zzcI(Parcel parcel) {
        DataType dataType = null;
        int i = 0;
        int zzaj = zza.zzaj(parcel);
        long j = 0;
        DataSource dataSource = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    dataSource = (DataSource) zza.zza(parcel, zzai, DataSource.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    dataType = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    i = zza.zzg(parcel, zzai);
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
            return new Subscription(i2, dataSource, dataType, j, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public Subscription[] zzeB(int i) {
        return new Subscription[i];
    }
}
