package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzc implements Creator<Bucket> {
    static void zza(Bucket bucket, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, bucket.zzkH());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, bucket.getVersionCode());
        zzb.zza(parcel, 2, bucket.zzrw());
        zzb.zza(parcel, 3, bucket.getSession(), i, false);
        zzb.zzc(parcel, 4, bucket.zzru());
        zzb.zzc(parcel, 5, bucket.getDataSets(), false);
        zzb.zzc(parcel, 6, bucket.getBucketType());
        zzb.zza(parcel, 7, bucket.zzrv());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzem(x0);
    }

    public Bucket zzcv(Parcel parcel) {
        long j = 0;
        List list = null;
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        int i2 = 0;
        Session session = null;
        long j2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    j2 = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j = zza.zzi(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    session = (Session) zza.zza(parcel, zzai, Session.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    list = zza.zzc(parcel, zzai, DataSet.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    z = zza.zzc(parcel, zzai);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Bucket(i3, j2, j, session, i2, list, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public Bucket[] zzem(int i) {
        return new Bucket[i];
    }
}
