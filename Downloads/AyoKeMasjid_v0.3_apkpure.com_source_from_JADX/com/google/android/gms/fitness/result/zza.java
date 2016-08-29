package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class zza implements Creator<BleDevicesResult> {
    static void zza(BleDevicesResult bleDevicesResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, bleDevicesResult.getClaimedBleDevices(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, bleDevicesResult.getVersionCode());
        zzb.zza(parcel, 2, bleDevicesResult.getStatus(), i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfj(x0);
    }

    public BleDevicesResult zzdp(Parcel parcel) {
        Status status = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, BleDevice.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    status = (Status) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, Status.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new BleDevicesResult(i, list, status);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public BleDevicesResult[] zzfj(int i) {
        return new BleDevicesResult[i];
    }
}
