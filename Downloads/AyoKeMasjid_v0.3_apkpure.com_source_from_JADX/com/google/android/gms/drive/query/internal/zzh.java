package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzh implements Creator<FullTextSearchFilter> {
    static void zza(FullTextSearchFilter fullTextSearchFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, fullTextSearchFilter.mVersionCode);
        zzb.zza(parcel, 1, fullTextSearchFilter.mValue, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdJ(x0);
    }

    public FullTextSearchFilter zzbV(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
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
            return new FullTextSearchFilter(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public FullTextSearchFilter[] zzdJ(int i) {
        return new FullTextSearchFilter[i];
    }
}
