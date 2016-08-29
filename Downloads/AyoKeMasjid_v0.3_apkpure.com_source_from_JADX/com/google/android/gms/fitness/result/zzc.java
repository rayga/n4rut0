package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;
import java.util.List;

public class zzc implements Creator<DataReadResult> {
    static void zza(DataReadResult dataReadResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzd(parcel, 1, dataReadResult.zzsD(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataReadResult.getVersionCode());
        zzb.zza(parcel, 2, dataReadResult.getStatus(), i, false);
        zzb.zzd(parcel, 3, dataReadResult.zzsC(), false);
        zzb.zzc(parcel, 5, dataReadResult.zzsB());
        zzb.zzc(parcel, 6, dataReadResult.zzrE(), false);
        zzb.zzc(parcel, 7, dataReadResult.zzsE(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfl(x0);
    }

    public DataReadResult zzdr(Parcel parcel) {
        int i = 0;
        List list = null;
        int zzaj = zza.zzaj(parcel);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List list2 = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    zza.zza(parcel, zzai, arrayList, getClass().getClassLoader());
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    status = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    zza.zza(parcel, zzai, arrayList2, getClass().getClassLoader());
                    break;
                case Barcode.PRODUCT /*5*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    list2 = zza.zzc(parcel, zzai, DataSource.CREATOR);
                    break;
                case Barcode.TEXT /*7*/:
                    list = zza.zzc(parcel, zzai, DataType.CREATOR);
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
            return new DataReadResult(i2, arrayList, status, arrayList2, i, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DataReadResult[] zzfl(int i) {
        return new DataReadResult[i];
    }
}
