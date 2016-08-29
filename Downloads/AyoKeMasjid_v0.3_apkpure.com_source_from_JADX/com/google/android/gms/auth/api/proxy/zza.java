package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zza implements Creator<ProxyGrpcRequest> {
    static void zza(ProxyGrpcRequest proxyGrpcRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, proxyGrpcRequest.hostname, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, proxyGrpcRequest.versionCode);
        zzb.zzc(parcel, 2, proxyGrpcRequest.port);
        zzb.zza(parcel, 3, proxyGrpcRequest.timeoutMillis);
        zzb.zza(parcel, 4, proxyGrpcRequest.body, false);
        zzb.zza(parcel, 5, proxyGrpcRequest.method, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaA(x0);
    }

    public ProxyGrpcRequest zzK(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        long j = 0;
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    bArr = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new ProxyGrpcRequest(i2, str2, i, j, bArr, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public ProxyGrpcRequest[] zzaA(int i) {
        return new ProxyGrpcRequest[i];
    }
}
