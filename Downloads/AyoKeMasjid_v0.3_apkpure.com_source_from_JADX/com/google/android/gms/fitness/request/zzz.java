package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzz implements Creator<SessionUnregistrationRequest> {
    static void zza(SessionUnregistrationRequest sessionUnregistrationRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, sessionUnregistrationRequest.zzso(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sessionUnregistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionUnregistrationRequest.zzsc(), false);
        zzb.zza(parcel, 3, sessionUnregistrationRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfd(x0);
    }

    public SessionUnregistrationRequest zzdj(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            PendingIntent pendingIntent2;
            String str2;
            IBinder iBinder2;
            int zzai = zza.zzai(parcel);
            String str3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    IBinder iBinder3 = iBinder;
                    pendingIntent2 = (PendingIntent) zza.zza(parcel, zzai, PendingIntent.CREATOR);
                    str2 = str;
                    iBinder2 = iBinder3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    str3 = str;
                    iBinder2 = zza.zzp(parcel, zzai);
                    str2 = str3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    str3 = str;
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = zza.zzg(parcel, zzai);
                    str2 = str3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    str2 = str;
                    iBinder2 = iBinder;
                    pendingIntent2 = pendingIntent;
                    i2 = i;
                    break;
            }
            i = i2;
            pendingIntent = pendingIntent2;
            iBinder = iBinder2;
            str = str2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SessionUnregistrationRequest(i, pendingIntent, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SessionUnregistrationRequest[] zzfd(int i) {
        return new SessionUnregistrationRequest[i];
    }
}
