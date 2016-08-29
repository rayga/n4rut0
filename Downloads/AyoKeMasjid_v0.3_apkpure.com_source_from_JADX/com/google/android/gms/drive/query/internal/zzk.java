package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.ArrayList;
import java.util.List;

public class zzk implements Creator<LogicalFilter> {
    static void zza(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, logicalFilter.mVersionCode);
        zzb.zza(parcel, 1, logicalFilter.zzalv, i, false);
        zzb.zzc(parcel, 2, logicalFilter.zzalK, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdM(x0);
    }

    public LogicalFilter zzbY(Parcel parcel) {
        List list = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < zzaj) {
            int i2;
            Operator operator2;
            ArrayList zzc;
            int zzai = zza.zzai(parcel);
            List list2;
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    Operator operator3 = (Operator) zza.zza(parcel, zzai, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzc = zza.zzc(parcel, zzai, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    List list3 = list;
                    operator2 = operator;
                    i2 = zza.zzg(parcel, zzai);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    zzc = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzaj) {
            return new LogicalFilter(i, operator, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public LogicalFilter[] zzdM(int i) {
        return new LogicalFilter[i];
    }
}
