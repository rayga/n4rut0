package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzq implements Creator<SessionDataSet> {
    static void zza(SessionDataSet sessionDataSet, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, sessionDataSet.getSession(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sessionDataSet.mVersionCode);
        zzb.zza(parcel, 2, sessionDataSet.zzrO(), i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeA(x0);
    }

    public SessionDataSet zzcH(Parcel parcel) {
        DataSet dataSet = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Session session = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            DataSet dataSet2;
            Session session2;
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    Session session3 = (Session) zza.zza(parcel, zzai, Session.CREATOR);
                    dataSet2 = dataSet;
                    session2 = session3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    dataSet2 = (DataSet) zza.zza(parcel, zzai, DataSet.CREATOR);
                    session2 = session;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    DataSet dataSet3 = dataSet;
                    session2 = session;
                    i2 = zza.zzg(parcel, zzai);
                    dataSet2 = dataSet3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    dataSet2 = dataSet;
                    session2 = session;
                    i2 = i;
                    break;
            }
            i = i2;
            session = session2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == zzaj) {
            return new SessionDataSet(i, session, dataSet);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SessionDataSet[] zzeA(int i) {
        return new SessionDataSet[i];
    }
}
