package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzf implements Creator<DataSource> {
    static void zza(DataSource dataSource, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dataSource.getDataType(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataSource.getVersionCode());
        zzb.zza(parcel, 2, dataSource.getName(), false);
        zzb.zzc(parcel, 3, dataSource.getType());
        zzb.zza(parcel, 4, dataSource.getDevice(), i, false);
        zzb.zza(parcel, 5, dataSource.zzrF(), i, false);
        zzb.zza(parcel, 6, dataSource.getStreamName(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcy(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeq(x0);
    }

    public DataSource zzcy(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = zza.zzaj(parcel);
        Application application = null;
        Device device = null;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    dataType = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    device = (Device) zza.zza(parcel, zzai, Device.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    application = (Application) zza.zza(parcel, zzai, Application.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    str = zza.zzo(parcel, zzai);
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
            return new DataSource(i2, dataType, str2, i, device, application, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DataSource[] zzeq(int i) {
        return new DataSource[i];
    }
}
