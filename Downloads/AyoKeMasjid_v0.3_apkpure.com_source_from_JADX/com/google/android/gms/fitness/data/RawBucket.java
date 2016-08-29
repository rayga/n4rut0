package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket implements SafeParcelable {
    public static final Creator<RawBucket> CREATOR;
    final int mVersionCode;
    public final long zzMS;
    public final boolean zzanA;
    public final long zzann;
    public final Session zzanp;
    public final List<RawDataSet> zzany;
    public final int zzanz;
    public final int zzaov;

    static {
        CREATOR = new zzm();
    }

    public RawBucket(int versionCode, long startTimeMillis, long endTimeMillis, Session session, int activity, List<RawDataSet> dataSets, int bucketType, boolean serverHasMoreData) {
        this.mVersionCode = versionCode;
        this.zzMS = startTimeMillis;
        this.zzann = endTimeMillis;
        this.zzanp = session;
        this.zzaov = activity;
        this.zzany = dataSets;
        this.zzanz = bucketType;
        this.zzanA = serverHasMoreData;
    }

    public RawBucket(Bucket bucket, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.mVersionCode = 2;
        this.zzMS = bucket.getStartTime(TimeUnit.MILLISECONDS);
        this.zzann = bucket.getEndTime(TimeUnit.MILLISECONDS);
        this.zzanp = bucket.getSession();
        this.zzaov = bucket.zzru();
        this.zzanz = bucket.getBucketType();
        this.zzanA = bucket.zzrv();
        List<DataSet> dataSets = bucket.getDataSets();
        this.zzany = new ArrayList(dataSets.size());
        for (DataSet rawDataSet : dataSets) {
            this.zzany.add(new RawDataSet(rawDataSet, uniqueDataSources, uniqueDataTypes));
        }
    }

    private boolean zza(RawBucket rawBucket) {
        return this.zzMS == rawBucket.zzMS && this.zzann == rawBucket.zzann && this.zzaov == rawBucket.zzaov && zzw.equal(this.zzany, rawBucket.zzany) && this.zzanz == rawBucket.zzanz && this.zzanA == rawBucket.zzanA;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawBucket) && zza((RawBucket) o));
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzMS), Long.valueOf(this.zzann), Integer.valueOf(this.zzanz));
    }

    public String toString() {
        return zzw.zzu(this).zzg("startTime", Long.valueOf(this.zzMS)).zzg("endTime", Long.valueOf(this.zzann)).zzg("activity", Integer.valueOf(this.zzaov)).zzg("dataSets", this.zzany).zzg("bucketType", Integer.valueOf(this.zzanz)).zzg("serverHasMoreData", Boolean.valueOf(this.zzanA)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzm.zza(this, parcel, flags);
    }
}
