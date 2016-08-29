package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

public final class RawDataSet implements SafeParcelable {
    public static final Creator<RawDataSet> CREATOR;
    final int mVersionCode;
    public final boolean zzanA;
    public final int zzaow;
    public final int zzaoy;
    public final List<RawDataPoint> zzaoz;

    static {
        CREATOR = new zzo();
    }

    public RawDataSet(int versionCode, int dataSourceIndex, int dataTypeIndex, List<RawDataPoint> rawDataPoints, boolean serverHasMoreData) {
        this.mVersionCode = versionCode;
        this.zzaow = dataSourceIndex;
        this.zzaoy = dataTypeIndex;
        this.zzaoz = rawDataPoints;
        this.zzanA = serverHasMoreData;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.mVersionCode = 3;
        this.zzaoz = dataSet.zzk(uniqueDataSources);
        this.zzanA = dataSet.zzrv();
        this.zzaow = zzs.zza(dataSet.getDataSource(), uniqueDataSources);
        this.zzaoy = zzs.zza(dataSet.getDataType(), uniqueDataTypes);
    }

    private boolean zza(RawDataSet rawDataSet) {
        return this.zzaow == rawDataSet.zzaow && this.zzanA == rawDataSet.zzanA && zzw.equal(this.zzaoz, rawDataSet.zzaoz);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataSet) && zza((RawDataSet) o));
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaow));
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s]}", new Object[]{Integer.valueOf(this.zzaow), this.zzaoz});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzo.zza(this, parcel, flags);
    }
}
