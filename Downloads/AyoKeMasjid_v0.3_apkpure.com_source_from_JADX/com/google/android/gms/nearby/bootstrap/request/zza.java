package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.nearby.bootstrap.Device;
import com.google.android.gms.vision.barcode.Barcode;

public class zza implements Creator<ConnectRequest> {
    static void zza(ConnectRequest connectRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, connectRequest.zzye(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, connectRequest.versionCode);
        zzb.zza(parcel, 2, connectRequest.getName(), false);
        zzb.zza(parcel, 3, connectRequest.getDescription(), false);
        zzb.zza(parcel, 4, connectRequest.zzyh(), false);
        zzb.zza(parcel, 5, connectRequest.zzyi(), false);
        zzb.zza(parcel, 6, connectRequest.zzsc(), false);
        zzb.zza(parcel, 7, connectRequest.zzyc());
        zzb.zza(parcel, 8, connectRequest.zzyf());
        zzb.zza(parcel, 9, connectRequest.getToken(), false);
        zzb.zza(parcel, 10, connectRequest.zzyg());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhV(x0);
    }

    public ConnectRequest zzfn(Parcel parcel) {
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        Device device = null;
        String str = null;
        String str2 = null;
        byte b = (byte) 0;
        long j = 0;
        String str3 = null;
        byte b2 = (byte) 0;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    device = (Device) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, Device.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    b = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
                    break;
                case Barcode.URL /*8*/:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case Barcode.WIFI /*9*/:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.GEO /*10*/:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzai);
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
            return new ConnectRequest(i, device, str, str2, b, j, str3, b2, iBinder, iBinder2, iBinder3);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ConnectRequest[] zzhV(int i) {
        return new ConnectRequest[i];
    }
}
