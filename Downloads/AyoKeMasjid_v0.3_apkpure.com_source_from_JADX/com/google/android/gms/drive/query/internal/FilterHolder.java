package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder implements SafeParcelable {
    public static final Creator<FilterHolder> CREATOR;
    final int mVersionCode;
    private final Filter zzagW;
    final FieldOnlyFilter zzalA;
    final LogicalFilter zzalB;
    final NotFilter zzalC;
    final InFilter<?> zzalD;
    final MatchAllFilter zzalE;
    final HasFilter zzalF;
    final FullTextSearchFilter zzalG;
    final OwnedByMeFilter zzalH;
    final ComparisonFilter<?> zzalz;

    static {
        CREATOR = new zzd();
    }

    FilterHolder(int versionCode, ComparisonFilter<?> comparisonField, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> containsFilter, MatchAllFilter matchAllFilter, HasFilter<?> hasFilter, FullTextSearchFilter fullTextSearchFilter, OwnedByMeFilter ownedByMeFilter) {
        this.mVersionCode = versionCode;
        this.zzalz = comparisonField;
        this.zzalA = fieldOnlyFilter;
        this.zzalB = logicalFilter;
        this.zzalC = notFilter;
        this.zzalD = containsFilter;
        this.zzalE = matchAllFilter;
        this.zzalF = hasFilter;
        this.zzalG = fullTextSearchFilter;
        this.zzalH = ownedByMeFilter;
        if (this.zzalz != null) {
            this.zzagW = this.zzalz;
        } else if (this.zzalA != null) {
            this.zzagW = this.zzalA;
        } else if (this.zzalB != null) {
            this.zzagW = this.zzalB;
        } else if (this.zzalC != null) {
            this.zzagW = this.zzalC;
        } else if (this.zzalD != null) {
            this.zzagW = this.zzalD;
        } else if (this.zzalE != null) {
            this.zzagW = this.zzalE;
        } else if (this.zzalF != null) {
            this.zzagW = this.zzalF;
        } else if (this.zzalG != null) {
            this.zzagW = this.zzalG;
        } else if (this.zzalH != null) {
            this.zzagW = this.zzalH;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter filter) {
        zzx.zzb((Object) filter, (Object) "Null filter.");
        this.mVersionCode = 2;
        this.zzalz = filter instanceof ComparisonFilter ? (ComparisonFilter) filter : null;
        this.zzalA = filter instanceof FieldOnlyFilter ? (FieldOnlyFilter) filter : null;
        this.zzalB = filter instanceof LogicalFilter ? (LogicalFilter) filter : null;
        this.zzalC = filter instanceof NotFilter ? (NotFilter) filter : null;
        this.zzalD = filter instanceof InFilter ? (InFilter) filter : null;
        this.zzalE = filter instanceof MatchAllFilter ? (MatchAllFilter) filter : null;
        this.zzalF = filter instanceof HasFilter ? (HasFilter) filter : null;
        this.zzalG = filter instanceof FullTextSearchFilter ? (FullTextSearchFilter) filter : null;
        this.zzalH = filter instanceof OwnedByMeFilter ? (OwnedByMeFilter) filter : null;
        if (this.zzalz == null && this.zzalA == null && this.zzalB == null && this.zzalC == null && this.zzalD == null && this.zzalE == null && this.zzalF == null && this.zzalG == null && this.zzalH == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.zzagW = filter;
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzagW;
    }

    public String toString() {
        return String.format("FilterHolder[%s]", new Object[]{this.zzagW});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
