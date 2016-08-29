package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzl implements Creator<MatchAllFilter> {
    static void zza(MatchAllFilter matchAllFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, matchAllFilter.mVersionCode);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdN(x0);
    }

    public MatchAllFilter zzbZ(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = zza.zzg(parcel, zzai);
                    break;
                default:
                    zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new MatchAllFilter(i);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public MatchAllFilter[] zzdN(int i) {
        return new MatchAllFilter[i];
    }
}
