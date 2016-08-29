package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.location.GeofenceStatusCodes;

public class zzb implements Creator<FieldOnlyFilter> {
    static void zza(FieldOnlyFilter fieldOnlyFilter, Parcel parcel, int i) {
        int zzak = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, fieldOnlyFilter.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, fieldOnlyFilter.zzalw, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdG(x0);
    }

    public FieldOnlyFilter zzbS(Parcel parcel) {
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzai, MetadataBundle.CREATOR);
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
            return new FieldOnlyFilter(i, metadataBundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public FieldOnlyFilter[] zzdG(int i) {
        return new FieldOnlyFilter[i];
    }
}
