package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.ArrayList;
import java.util.List;

public class zze implements Creator<DataSet> {
    static void zza(DataSet dataSet, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataSet.getDataSource(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataSet.getVersionCode());
        zzb.zza(parcel, 2, dataSet.getDataType(), i, false);
        zzb.zzd(parcel, 3, dataSet.zzrD(), false);
        zzb.zzc(parcel, 4, dataSet.zzrE(), false);
        zzb.zza(parcel, 5, dataSet.zzrv());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzep(x0);
    }

    public DataSet zzcx(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzaj = zza.zzaj(parcel);
        List arrayList = new ArrayList();
        DataType dataType = null;
        DataSource dataSource = null;
        int i = 0;
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
                    zza.zza(parcel, zzai, arrayList, getClass().getClassLoader());
                    break;
                case Barcode.PHONE /*4*/:
                    list = zza.zzc(parcel, zzai, DataSource.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z = zza.zzc(parcel, zzai);
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
            return new DataSet(i, dataSource, dataType, arrayList, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DataSet[] zzep(int i) {
        return new DataSet[i];
    }
}
