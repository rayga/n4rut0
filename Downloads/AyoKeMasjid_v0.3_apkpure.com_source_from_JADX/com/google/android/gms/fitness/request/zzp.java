package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzp implements Creator<ListSubscriptionsRequest> {
    static void zza(ListSubscriptionsRequest listSubscriptionsRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, listSubscriptionsRequest.getDataType(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, listSubscriptionsRequest.getVersionCode());
        zzb.zza(parcel, 2, listSubscriptionsRequest.zzsc(), false);
        zzb.zza(parcel, 3, listSubscriptionsRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeS(x0);
    }

    public ListSubscriptionsRequest zzcZ(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        DataType dataType = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            DataType dataType2;
            String str2;
            IBinder iBinder2;
            int zzai = zza.zzai(parcel);
            String str3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    IBinder iBinder3 = iBinder;
                    dataType2 = (DataType) zza.zza(parcel, zzai, DataType.CREATOR);
                    str2 = str;
                    iBinder2 = iBinder3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    dataType2 = dataType;
                    i2 = i;
                    str3 = str;
                    iBinder2 = zza.zzp(parcel, zzai);
                    str2 = str3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
                    iBinder2 = iBinder;
                    dataType2 = dataType;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    str3 = str;
                    iBinder2 = iBinder;
                    dataType2 = dataType;
                    i2 = zza.zzg(parcel, zzai);
                    str2 = str3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    str2 = str;
                    iBinder2 = iBinder;
                    dataType2 = dataType;
                    i2 = i;
                    break;
            }
            i = i2;
            dataType = dataType2;
            iBinder = iBinder2;
            str = str2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new ListSubscriptionsRequest(i, dataType, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ListSubscriptionsRequest[] zzeS(int i) {
        return new ListSubscriptionsRequest[i];
    }
}
