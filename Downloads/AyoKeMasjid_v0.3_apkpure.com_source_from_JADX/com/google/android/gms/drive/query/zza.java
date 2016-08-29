package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zza implements Creator<Query> {
    static void zza(Query query, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, query.mVersionCode);
        zzb.zza(parcel, 1, query.zzall, i, false);
        zzb.zza(parcel, 3, query.zzalm, false);
        zzb.zza(parcel, 4, query.zzaln, i, false);
        zzb.zzb(parcel, 5, query.zzalo, false);
        zzb.zza(parcel, 6, query.zzalp);
        zzb.zzc(parcel, 7, query.zzahq, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdD(x0);
    }

    public Query zzbP(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzaj = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        List list2 = null;
        SortOrder sortOrder = null;
        String str = null;
        LogicalFilter logicalFilter = null;
        int i = 0;
        while (parcel.dataPosition() < zzaj) {
            int zzai = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, LogicalFilter.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzai);
                    break;
                case Barcode.PHONE /*4*/:
                    sortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzai, SortOrder.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    list2 = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzai);
                    break;
                case Barcode.SMS /*6*/:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai);
                    break;
                case Barcode.TEXT /*7*/:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzai, DriveSpace.CREATOR);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzai);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzai);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaj) {
            return new Query(i, logicalFilter, str, sortOrder, list2, z, list);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public Query[] zzdD(int i) {
        return new Query[i];
    }
}
