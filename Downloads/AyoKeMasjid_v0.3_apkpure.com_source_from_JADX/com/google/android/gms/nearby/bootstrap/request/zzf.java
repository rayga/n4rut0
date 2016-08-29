package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzf implements Creator<SendDataRequest> {
    static void zza(SendDataRequest sendDataRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, sendDataRequest.zzye(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sendDataRequest.versionCode);
        zzb.zza(parcel, 2, sendDataRequest.getData(), false);
        zzb.zza(parcel, 3, sendDataRequest.zzsc(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzia(x0);
    }

    public SendDataRequest zzfs(Parcel parcel) {
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        byte[] bArr = null;
        Device device = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            Device device2;
            IBinder iBinder2;
            byte[] bArr2;
            int zzai = zza.zzai(parcel);
            IBinder iBinder3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    byte[] bArr3 = bArr;
                    device2 = (Device) zza.zza(parcel, zzai, Device.CREATOR);
                    iBinder2 = iBinder;
                    bArr2 = bArr3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    device2 = device;
                    i2 = i;
                    iBinder3 = iBinder;
                    bArr2 = zza.zzr(parcel, zzai);
                    iBinder2 = iBinder3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    iBinder2 = zza.zzp(parcel, zzai);
                    bArr2 = bArr;
                    device2 = device;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    iBinder3 = iBinder;
                    bArr2 = bArr;
                    device2 = device;
                    i2 = zza.zzg(parcel, zzai);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    iBinder2 = iBinder;
                    bArr2 = bArr;
                    device2 = device;
                    i2 = i;
                    break;
            }
            i = i2;
            device = device2;
            bArr = bArr2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SendDataRequest(i, device, bArr, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SendDataRequest[] zzia(int i) {
        return new SendDataRequest[i];
    }
}
