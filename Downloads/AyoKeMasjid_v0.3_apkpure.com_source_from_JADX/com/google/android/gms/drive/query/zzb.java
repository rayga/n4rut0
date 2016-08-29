package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;

public class zzb implements Creator<SortOrder> {
    static void zza(SortOrder sortOrder, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, sortOrder.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, sortOrder.zzalt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, sortOrder.zzalu);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdE(x0);
    }

    public SortOrder zzbQ(Parcel parcel) {
        boolean z = false;
        int zzaj = zza.zzaj(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list = zza.zzc(parcel, zzai, FieldWithSortOrder.CREATOR);
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
            return new SortOrder(i, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public SortOrder[] zzdE(int i) {
        return new SortOrder[i];
    }
}
