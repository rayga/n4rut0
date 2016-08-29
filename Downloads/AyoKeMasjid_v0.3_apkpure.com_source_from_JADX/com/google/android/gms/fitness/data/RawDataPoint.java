package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint implements SafeParcelable {
    public static final Creator<RawDataPoint> CREATOR;
    final int mVersionCode;
    public final long zzanB;
    public final long zzanC;
    public final Value[] zzanD;
    public final long zzanF;
    public final long zzanG;
    public final int zzaow;
    public final int zzaox;

    static {
        CREATOR = new zzn();
    }

    public RawDataPoint(int versionCode, long timestampNanos, long startTimeNanos, Value[] values, int dataSourceIndex, int originalDataSourceIndex, long rawTimestamp, long insertionTimeMillis) {
        this.mVersionCode = versionCode;
        this.zzanB = timestampNanos;
        this.zzanC = startTimeNanos;
        this.zzaow = dataSourceIndex;
        this.zzaox = originalDataSourceIndex;
        this.zzanF = rawTimestamp;
        this.zzanG = insertionTimeMillis;
        this.zzanD = values;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> dataSources) {
        this.mVersionCode = 4;
        this.zzanB = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
        this.zzanC = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
        this.zzanD = dataPoint.zzry();
        this.zzaow = zzs.zza(dataPoint.getDataSource(), dataSources);
        this.zzaox = zzs.zza(dataPoint.getOriginalDataSource(), dataSources);
        this.zzanF = dataPoint.zzrz();
        this.zzanG = dataPoint.zzrA();
    }

    private boolean zza(RawDataPoint rawDataPoint) {
        return this.zzanB == rawDataPoint.zzanB && this.zzanC == rawDataPoint.zzanC && Arrays.equals(this.zzanD, rawDataPoint.zzanD) && this.zzaow == rawDataPoint.zzaow && this.zzaox == rawDataPoint.zzaox && this.zzanF == rawDataPoint.zzanF;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataPoint) && zza((RawDataPoint) o));
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzanB), Long.valueOf(this.zzanC));
    }

    public String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.zzanD), Long.valueOf(this.zzanC), Long.valueOf(this.zzanB), Integer.valueOf(this.zzaow), Integer.valueOf(this.zzaox)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzn.zza(this, parcel, flags);
    }
}
