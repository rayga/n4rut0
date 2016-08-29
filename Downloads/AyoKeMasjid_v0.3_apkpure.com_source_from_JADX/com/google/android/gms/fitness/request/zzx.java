package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzx implements Creator<SessionStartRequest> {
    static void zza(SessionStartRequest sessionStartRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, sessionStartRequest.getSession(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sessionStartRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionStartRequest.zzsc(), false);
        zzb.zza(parcel, 3, sessionStartRequest.getPackageName(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfb(x0);
    }

    public SessionStartRequest zzdh(Parcel parcel) {
        String str = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        IBinder iBinder = null;
        Session session = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            Session session2;
            String str2;
            IBinder iBinder2;
            int zzai = zza.zzai(parcel);
            String str3;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    IBinder iBinder3 = iBinder;
                    session2 = (Session) zza.zza(parcel, zzai, Session.CREATOR);
                    str2 = str;
                    iBinder2 = iBinder3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    session2 = session;
                    i2 = i;
                    str3 = str;
                    iBinder2 = zza.zzp(parcel, zzai);
                    str2 = str3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzo(parcel, zzai);
                    iBinder2 = iBinder;
                    session2 = session;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    str3 = str;
                    iBinder2 = iBinder;
                    session2 = session;
                    i2 = zza.zzg(parcel, zzai);
                    str2 = str3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    str2 = str;
                    iBinder2 = iBinder;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            iBinder = iBinder2;
            str = str2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SessionStartRequest(i, session, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SessionStartRequest[] zzfb(int i) {
        return new SessionStartRequest[i];
    }
}
