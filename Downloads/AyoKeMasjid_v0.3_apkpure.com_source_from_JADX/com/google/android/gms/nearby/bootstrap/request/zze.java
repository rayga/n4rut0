package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<EnableTargetRequest> {
    static void zza(EnableTargetRequest enableTargetRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, enableTargetRequest.getName(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, enableTargetRequest.versionCode);
        zzb.zza(parcel, 2, enableTargetRequest.getDescription(), false);
        zzb.zza(parcel, 3, enableTargetRequest.zzyh(), false);
        zzb.zza(parcel, 4, enableTargetRequest.zzyi(), false);
        zzb.zza(parcel, 5, enableTargetRequest.zzsc(), false);
        zzb.zza(parcel, 6, enableTargetRequest.zzyc());
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhZ(x0);
    }

    public EnableTargetRequest zzfr(Parcel parcel) {
        byte b = (byte) 0;
        IBinder iBinder = null;
        int zzaj = zza.zzaj(parcel);
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        String str = null;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str2 = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    iBinder3 = zza.zzp(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    iBinder2 = zza.zzp(parcel, zzai);
                    break;
                case Barcode.PRODUCT /*5*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    b = zza.zze(parcel, zzai);
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
            return new EnableTargetRequest(i, str2, str, b, iBinder3, iBinder2, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public EnableTargetRequest[] zzhZ(int i) {
        return new EnableTargetRequest[i];
    }
}
