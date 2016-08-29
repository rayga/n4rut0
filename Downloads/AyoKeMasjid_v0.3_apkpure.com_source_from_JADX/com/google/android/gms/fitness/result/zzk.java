package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.ArrayList;
import java.util.List;

public class zzk implements Creator<SessionStopResult> {
    static void zza(SessionStopResult sessionStopResult, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sessionStopResult.getVersionCode());
        zzb.zza(parcel, 2, sessionStopResult.getStatus(), i, false);
        zzb.zzc(parcel, 3, sessionStopResult.getSessions(), false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzft(x0);
    }

    public SessionStopResult zzdz(Parcel parcel) {
        List list = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            Status status2;
            ArrayList zzc;
            int zzai = zza.zzai(parcel);
            List list2;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzai, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    zzc = zza.zzc(parcel, zzai, Session.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    List list3 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzai);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzc = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SessionStopResult(i, status, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SessionStopResult[] zzft(int i) {
        return new SessionStopResult[i];
    }
}
