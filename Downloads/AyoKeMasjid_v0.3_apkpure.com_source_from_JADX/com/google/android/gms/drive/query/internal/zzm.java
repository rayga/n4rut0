package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzm implements Creator<NotFilter> {
    static void zza(NotFilter notFilter, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, notFilter.mVersionCode);
        zzb.zza(parcel, 1, notFilter.zzalL, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzca(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdO(x0);
    }

    public NotFilter zzca(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    filterHolder = (FilterHolder) zza.zza(parcel, zzai, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public NotFilter[] zzdO(int i) {
        return new NotFilter[i];
    }
}
