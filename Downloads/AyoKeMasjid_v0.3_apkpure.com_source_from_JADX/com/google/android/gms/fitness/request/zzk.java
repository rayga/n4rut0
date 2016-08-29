package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzk implements Creator<DeleteAllUserDataRequest> {
    static void zza(DeleteAllUserDataRequest deleteAllUserDataRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, deleteAllUserDataRequest.zzsc(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, deleteAllUserDataRequest.getVersionCode());
        zzb.zza(parcel, 2, deleteAllUserDataRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeO(x0);
    }

    public DeleteAllUserDataRequest zzcV(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    iBinder = zza.zzp(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str = zza.zzo(parcel, zzai);
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
            return new DeleteAllUserDataRequest(i, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public DeleteAllUserDataRequest[] zzeO(int i) {
        return new DeleteAllUserDataRequest[i];
    }
}
