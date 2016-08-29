package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query implements SafeParcelable {
    public static final Creator<Query> CREATOR;
    final int mVersionCode;
    final List<DriveSpace> zzahq;
    private final Set<DriveSpace> zzahr;
    final LogicalFilter zzall;
    final String zzalm;
    final SortOrder zzaln;
    final List<String> zzalo;
    final boolean zzalp;

    public static class Builder {
        private Set<DriveSpace> zzahr;
        private String zzalm;
        private SortOrder zzaln;
        private List<String> zzalo;
        private boolean zzalp;
        private final List<Filter> zzalq;

        public Builder() {
            this.zzalq = new ArrayList();
        }

        public Builder(Query query) {
            this.zzalq = new ArrayList();
            this.zzalq.add(query.getFilter());
            this.zzalm = query.getPageToken();
            this.zzaln = query.getSortOrder();
            this.zzalo = query.zzrd();
            this.zzalp = query.zzre();
            this.zzahr = query.zzrf();
        }

        public Builder addFilter(Filter filter) {
            if (!(filter instanceof MatchAllFilter)) {
                this.zzalq.add(filter);
            }
            return this;
        }

        public Query build() {
            return new Query(this.zzalm, this.zzaln, this.zzalo, this.zzalp, this.zzahr, null);
        }

        @Deprecated
        public Builder setPageToken(String token) {
            this.zzalm = token;
            return this;
        }

        public Builder setSortOrder(SortOrder sortOrder) {
            this.zzaln = sortOrder;
            return this;
        }
    }

    static {
        CREATOR = new zza();
    }

    Query(int versionCode, LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields, boolean shouldIncludeParents, List<DriveSpace> spacesList) {
        this(versionCode, clause, pageToken, sortOrder, requestedMetadataFields, shouldIncludeParents, spacesList, spacesList == null ? null : new HashSet(spacesList));
    }

    private Query(int versionCode, LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields, boolean shouldIncludeParents, List<DriveSpace> spacesList, Set<DriveSpace> spaces) {
        this.mVersionCode = versionCode;
        this.zzall = clause;
        this.zzalm = pageToken;
        this.zzaln = sortOrder;
        this.zzalo = requestedMetadataFields;
        this.zzalp = shouldIncludeParents;
        this.zzahq = spacesList;
        this.zzahr = spaces;
    }

    private Query(LogicalFilter clause, String pageToken, SortOrder sortOrder, List<String> requestedMetadataFields, boolean shouldIncludeParents, Set<DriveSpace> spaces) {
        this(1, clause, pageToken, sortOrder, requestedMetadataFields, shouldIncludeParents, spaces == null ? null : new ArrayList(spaces), spaces);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.zzall;
    }

    @Deprecated
    public String getPageToken() {
        return this.zzalm;
    }

    public SortOrder getSortOrder() {
        return this.zzaln;
    }

    public String toString() {
        return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[]{this.zzall, this.zzaln, this.zzalm, this.zzahq});
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public List<String> zzrd() {
        return this.zzalo;
    }

    public boolean zzre() {
        return this.zzalp;
    }

    public Set<DriveSpace> zzrf() {
        return this.zzahr;
    }
}
