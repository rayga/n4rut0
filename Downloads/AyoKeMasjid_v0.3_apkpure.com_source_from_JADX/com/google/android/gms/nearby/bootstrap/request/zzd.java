package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzd implements Creator<DisconnectRequest> {
    static void zza(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, disconnectRequest.zzye(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, disconnectRequest.versionCode);
        zzb.zza(parcel, 2, disconnectRequest.zzsc(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhY(x0);
    }

    public DisconnectRequest zzfq(Parcel parcel) {
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Device device = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            IBinder iBinder2;
            Device device2;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    Device device3 = (Device) zza.zza(parcel, zzai, Device.CREATOR);
                    iBinder2 = iBinder;
                    device2 = device3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    iBinder2 = zza.zzp(parcel, zzai);
                    device2 = device;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    IBinder iBinder3 = iBinder;
                    device2 = device;
                    i2 = zza.zzg(parcel, zzai);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    iBinder2 = iBinder;
                    device2 = device;
                    i2 = i;
                    break;
            }
            i = i2;
            device = device2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new DisconnectRequest(i, device, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DisconnectRequest[] zzhY(int i) {
        return new DisconnectRequest[i];
    }
}
