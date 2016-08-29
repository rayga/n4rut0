package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzd implements Creator<FilterHolder> {
    static void zza(FilterHolder filterHolder, Parcel parcel, int i) {
        int zzak = zzb.zzak(parcel);
        zzb.zza(parcel, 1, filterHolder.zzalz, i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, filterHolder.mVersionCode);
        zzb.zza(parcel, 2, filterHolder.zzalA, i, false);
        zzb.zza(parcel, 3, filterHolder.zzalB, i, false);
        zzb.zza(parcel, 4, filterHolder.zzalC, i, false);
        zzb.zza(parcel, 5, filterHolder.zzalD, i, false);
        zzb.zza(parcel, 6, filterHolder.zzalE, i, false);
        zzb.zza(parcel, 7, filterHolder.zzalF, i, false);
        zzb.zza(parcel, 8, filterHolder.zzalG, i, false);
        zzb.zza(parcel, 9, filterHolder.zzalH, i, false);
        zzb.zzH(parcel, zzak);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdI(x0);
    }

    public FilterHolder zzbU(Parcel parcel) {
        OwnedByMeFilter ownedByMeFilter = null;
        int zzaj = zza.zzaj(parcel);
        int i = 0;
        FullTextSearchFilter fullTextSearchFilter = null;
        HasFilter hasFilter = null;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < zzaj) {
            int zzai = zza.zzai(parcel);
            switch (zza.zzbH(zzai)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    comparisonFilter = (ComparisonFilter) zza.zza(parcel, zzai, ComparisonFilter.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    fieldOnlyFilter = (FieldOnlyFilter) zza.zza(parcel, zzai, FieldOnlyFilter.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    logicalFilter = (LogicalFilter) zza.zza(parcel, zzai, LogicalFilter.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    notFilter = (NotFilter) zza.zza(parcel, zzai, NotFilter.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    inFilter = (InFilter) zza.zza(parcel, zzai, InFilter.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    matchAllFilter = (MatchAllFilter) zza.zza(parcel, zzai, MatchAllFilter.CREATOR);
                    break;
                case Barcode.TEXT /*7*/:
                    hasFilter = (HasFilter) zza.zza(parcel, zzai, HasFilter.CREATOR);
                    break;
                case Barcode.URL /*8*/:
                    fullTextSearchFilter = (FullTextSearchFilter) zza.zza(parcel, zzai, FullTextSearchFilter.CREATOR);
                    break;
                case Barcode.WIFI /*9*/:
                    ownedByMeFilter = (OwnedByMeFilter) zza.zza(parcel, zzai, OwnedByMeFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter, fullTextSearchFilter, ownedByMeFilter);
        }
        throw new zza.zza("Overread allowed size end=" + zzaj, parcel);
    }

    public FilterHolder[] zzdI(int i) {
        return new FilterHolder[i];
    }
}
