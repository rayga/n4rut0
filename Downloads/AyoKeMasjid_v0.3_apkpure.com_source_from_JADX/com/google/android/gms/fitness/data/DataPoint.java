package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmh;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint implements SafeParcelable {
    public static final Creator<DataPoint> CREATOR;
    private final int mVersionCode;
    private long zzanB;
    private long zzanC;
    private final Value[] zzanD;
    private DataSource zzanE;
    private long zzanF;
    private long zzanG;
    private final DataSource zzanm;

    static {
        CREATOR = new zzd();
    }

    DataPoint(int versionCode, DataSource dataSource, long timestampNanos, long startTimeNanos, Value[] values, DataSource originalDataSource, long rawTimestamp, long insertionTimeMillis) {
        this.mVersionCode = versionCode;
        this.zzanm = dataSource;
        this.zzanE = originalDataSource;
        this.zzanB = timestampNanos;
        this.zzanC = startTimeNanos;
        this.zzanD = values;
        this.zzanF = rawTimestamp;
        this.zzanG = insertionTimeMillis;
    }

    private DataPoint(DataSource dataSource) {
        this.mVersionCode = 4;
        this.zzanm = (DataSource) zzx.zzb((Object) dataSource, (Object) "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.zzanD = new Value[fields.size()];
        int i = 0;
        for (Field format : fields) {
            this.zzanD[i] = new Value(format.getFormat());
            i++;
        }
    }

    public DataPoint(DataSource dataSource, DataSource originalDataSource, RawDataPoint rawDataPoint) {
        this(4, dataSource, zza(Long.valueOf(rawDataPoint.zzanB), 0), zza(Long.valueOf(rawDataPoint.zzanC), 0), rawDataPoint.zzanD, originalDataSource, zza(Long.valueOf(rawDataPoint.zzanF), 0), zza(Long.valueOf(rawDataPoint.zzanG), 0));
    }

    DataPoint(List<DataSource> dataSources, RawDataPoint rawDataPoint) {
        this(zza((List) dataSources, rawDataPoint.zzaow), zza((List) dataSources, rawDataPoint.zzaox), rawDataPoint);
    }

    public static DataPoint create(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    public static DataPoint extract(Intent intent) {
        return intent == null ? null : (DataPoint) zzc.zza(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    private static long zza(Long l, long j) {
        return l != null ? l.longValue() : j;
    }

    private static DataSource zza(List<DataSource> list, int i) {
        return (i < 0 || i >= list.size()) ? null : (DataSource) list.get(i);
    }

    private boolean zza(DataPoint dataPoint) {
        return zzw.equal(this.zzanm, dataPoint.zzanm) && this.zzanB == dataPoint.zzanB && this.zzanC == dataPoint.zzanC && Arrays.equals(this.zzanD, dataPoint.zzanD) && zzw.equal(this.zzanE, dataPoint.zzanE);
    }

    private void zzen(int i) {
        zzx.zzb(i == getDataType().getFields().size(), "Attempting to insert %s values, but needed %s: %s", Integer.valueOf(i), Integer.valueOf(getDataType().getFields().size()), getDataType().getFields());
    }

    private boolean zzrx() {
        return getDataType() == DataType.TYPE_LOCATION_SAMPLE;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof DataPoint) && zza((DataPoint) o));
    }

    public DataSource getDataSource() {
        return this.zzanm;
    }

    public DataType getDataType() {
        return this.zzanm.getDataType();
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzanB, TimeUnit.NANOSECONDS);
    }

    public DataSource getOriginalDataSource() {
        return this.zzanE;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzanC, TimeUnit.NANOSECONDS);
    }

    public long getTimestamp(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzanB, TimeUnit.NANOSECONDS);
    }

    public long getTimestampNanos() {
        return this.zzanB;
    }

    public Value getValue(Field field) {
        return this.zzanD[getDataType().indexOf(field)];
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanm, Long.valueOf(this.zzanB), Long.valueOf(this.zzanC));
    }

    public DataPoint setFloatValues(float... values) {
        zzen(values.length);
        for (int i = 0; i < values.length; i++) {
            this.zzanD[i].setFloat(values[i]);
        }
        return this;
    }

    public DataPoint setIntValues(int... values) {
        zzen(values.length);
        for (int i = 0; i < values.length; i++) {
            this.zzanD[i].setInt(values[i]);
        }
        return this;
    }

    public DataPoint setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
        this.zzanC = timeUnit.toNanos(startTime);
        this.zzanB = timeUnit.toNanos(endTime);
        return this;
    }

    public DataPoint setTimestamp(long timestamp, TimeUnit timeUnit) {
        this.zzanB = timeUnit.toNanos(timestamp);
        if (zzrx() && zzmh.zza(timeUnit)) {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            this.zzanB = zzmh.zza(this.zzanB, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public String toString() {
        String str = "DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}";
        Object[] objArr = new Object[7];
        objArr[0] = Arrays.toString(this.zzanD);
        objArr[1] = Long.valueOf(this.zzanC);
        objArr[2] = Long.valueOf(this.zzanB);
        objArr[3] = Long.valueOf(this.zzanF);
        objArr[4] = Long.valueOf(this.zzanG);
        objArr[5] = this.zzanm.toDebugString();
        objArr[6] = this.zzanE != null ? this.zzanE.toDebugString() : "N/A";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzd.zza(this, parcel, flags);
    }

    public long zzrA() {
        return this.zzanG;
    }

    public void zzrB() {
        zzx.zzb(getDataType().getName().equals(getDataSource().getDataType().getName()), "Conflicting data types found %s vs %s", getDataType(), getDataType());
        zzx.zzb(this.zzanB > 0, "Data point does not have the timestamp set: %s", this);
        zzx.zzb(this.zzanC <= this.zzanB, "Data point with start time greater than end time found: %s", this);
    }

    public long zzrC() {
        return this.zzanC;
    }

    public Value[] zzry() {
        return this.zzanD;
    }

    public long zzrz() {
        return this.zzanF;
    }
}
