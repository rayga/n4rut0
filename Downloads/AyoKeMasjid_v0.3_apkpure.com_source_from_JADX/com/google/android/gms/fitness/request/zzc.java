package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzc implements Creator<DailyTotalRequest> {
    static void zza(DailyTotalRequest dailyTotalRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, dailyTotalRequest.zzsc(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dailyTotalRequest.getVersionCode());
        zzb.zza(parcel, 2, dailyTotalRequest.getDataType(), i, false);
        zzb.zza(parcel, 3, dailyTotalRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeG(x0);
    }

    public DailyTotalRequest zzcN(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        DataType dataType = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            IBinder zzp;
            String str2;
            DataType dataType2;
            int zzai = zza.zzai(parcel);
            String str3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    DataType dataType3 = dataType;
                    zzp = zza.zzp(parcel, zzai);
                    str2 = str;
                    dataType2 = dataType3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzp = iBinder;
                    i2 = i;
                    str3 = str;
                    dataType2 = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    str2 = str3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
                    dataType2 = dataType;
                    zzp = iBinder;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    str3 = str;
                    dataType2 = dataType;
                    zzp = iBinder;
                    i2 = zza.zzg(parcel, zzai);
                    str2 = str3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    str2 = str;
                    dataType2 = dataType;
                    zzp = iBinder;
                    i2 = i;
                    break;
            }
            i = i2;
            iBinder = zzp;
            dataType = dataType2;
            str = str2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new DailyTotalRequest(i, iBinder, dataType, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DailyTotalRequest[] zzeG(int i) {
        return new DailyTotalRequest[i];
    }
}
