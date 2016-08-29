package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DataSet implements SafeParcelable {
    public static final Creator<DataSet> CREATOR;
    private final int mVersionCode;
    private boolean zzanA;
    private final List<DataPoint> zzanH;
    private final List<DataSource> zzanI;
    private final DataType zzanl;
    private final DataSource zzanm;

    static {
        CREATOR = new zze();
    }

    DataSet(int versionCode, DataSource dataSource, DataType dataType, List<RawDataPoint> dataPoints, List<DataSource> uniqueDataSources, boolean serverHasMoreData) {
        this.zzanA = false;
        this.mVersionCode = versionCode;
        this.zzanm = dataSource;
        this.zzanl = dataSource.getDataType();
        this.zzanA = serverHasMoreData;
        this.zzanH = new ArrayList(dataPoints.size());
        if (versionCode < 2) {
            uniqueDataSources = Collections.singletonList(dataSource);
        }
        this.zzanI = uniqueDataSources;
        for (RawDataPoint dataPoint : dataPoints) {
            this.zzanH.add(new DataPoint(this.zzanI, dataPoint));
        }
    }

    public DataSet(DataSource dataSource) {
        this.zzanA = false;
        this.mVersionCode = 3;
        this.zzanm = (DataSource) zzx.zzv(dataSource);
        this.zzanl = dataSource.getDataType();
        this.zzanH = new ArrayList();
        this.zzanI = new ArrayList();
        this.zzanI.add(this.zzanm);
    }

    public DataSet(RawDataSet dataSet, List<DataSource> uniqueDataSources) {
        this.zzanA = false;
        this.mVersionCode = 3;
        this.zzanm = (DataSource) zzb(uniqueDataSources, dataSet.zzaow);
        this.zzanl = this.zzanm.getDataType();
        this.zzanI = uniqueDataSources;
        this.zzanA = dataSet.zzanA;
        List<RawDataPoint> list = dataSet.zzaoz;
        this.zzanH = new ArrayList(list.size());
        for (RawDataPoint dataPoint : list) {
            this.zzanH.add(new DataPoint(this.zzanI, dataPoint));
        }
    }

    public static DataSet create(DataSource dataSource) {
        zzx.zzb((Object) dataSource, (Object) "DataSource should be specified");
        return new DataSet(dataSource);
    }

    private boolean zza(DataSet dataSet) {
        return zzw.equal(getDataType(), dataSet.getDataType()) && zzw.equal(this.zzanm, dataSet.zzanm) && zzw.equal(this.zzanH, dataSet.zzanH) && this.zzanA == dataSet.zzanA;
    }

    private static <T> T zzb(List<T> list, int i) {
        return (i < 0 || i >= list.size()) ? null : list.get(i);
    }

    public void add(DataPoint dataPoint) {
        Object[] objArr = new Object[]{dataPoint.getDataSource(), this.zzanm};
        zzx.zzb(dataPoint.getDataSource().getStreamIdentifier().equals(this.zzanm.getStreamIdentifier()), "Conflicting data sources found %s vs %s", objArr);
        dataPoint.zzrB();
        zzb(dataPoint);
    }

    public void addAll(Iterable<DataPoint> dataPoints) {
        for (DataPoint add : dataPoints) {
            add(add);
        }
    }

    public DataPoint createDataPoint() {
        return DataPoint.create(this.zzanm);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataSet) && zza((DataSet) o));
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzanH);
    }

    public DataSource getDataSource() {
        return this.zzanm;
    }

    public DataType getDataType() {
        return this.zzanm.getDataType();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanm);
    }

    public boolean isEmpty() {
        return this.zzanH.isEmpty();
    }

    public String toString() {
        List zzrD = zzrD();
        String str = "DataSet{%s %s}";
        Object[] objArr = new Object[2];
        objArr[0] = this.zzanm.toDebugString();
        if (this.zzanH.size() >= 10) {
            zzrD = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.zzanH.size()), zzrD.subList(0, 5)});
        }
        objArr[1] = zzrD;
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }

    public void zzb(DataPoint dataPoint) {
        this.zzanH.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.zzanI.contains(originalDataSource)) {
            this.zzanI.add(originalDataSource);
        }
    }

    public void zzb(Iterable<DataPoint> iterable) {
        for (DataPoint zzb : iterable) {
            zzb(zzb);
        }
    }

    List<RawDataPoint> zzk(List<DataSource> list) {
        List<RawDataPoint> arrayList = new ArrayList(this.zzanH.size());
        for (DataPoint rawDataPoint : this.zzanH) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    List<RawDataPoint> zzrD() {
        return zzk(this.zzanI);
    }

    List<DataSource> zzrE() {
        return this.zzanI;
    }

    public boolean zzrv() {
        return this.zzanA;
    }
}
