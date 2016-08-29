package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzc implements Creator<FieldWithSortOrder> {
    static void zza(FieldWithSortOrder fieldWithSortOrder, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, fieldWithSortOrder.mVersionCode);
        zzb.zza(parcel, 1, fieldWithSortOrder.zzakc, false);
        zzb.zza(parcel, 2, fieldWithSortOrder.zzaly);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdH(x0);
    }

    public FieldWithSortOrder zzbT(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str = zza.zzo(parcel, zzai);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z = zza.zzc(parcel, zzai);
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
            return new FieldWithSortOrder(i, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public FieldWithSortOrder[] zzdH(int i) {
        return new FieldWithSortOrder[i];
    }
}
