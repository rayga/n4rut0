package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.query.Query;

public class zzbl implements Creator<QueryRequest> {
    static void zza(QueryRequest queryRequest, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, queryRequest.mVersionCode);
        zzb.zza(parcel, 2, queryRequest.zzajY, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzby(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdm(x0);
    }

    public QueryRequest zzby(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    query = (Query) zza.zza(parcel, zzai, Query.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new QueryRequest(i, query);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public QueryRequest[] zzdm(int i) {
        return new QueryRequest[i];
    }
}
