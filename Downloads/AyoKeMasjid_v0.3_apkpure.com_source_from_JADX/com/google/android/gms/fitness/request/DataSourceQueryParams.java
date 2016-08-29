package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceQueryParams implements SafeParcelable {
    public static final Creator<DataSourceQueryParams> CREATOR;
    final int mVersionCode;
    public final long zzQD;
    public final long zzanC;
    public final DataSource zzanm;
    public final int zzapP;
    public final long zzapU;
    public final int zzapV;

    static {
        CREATOR = new zzg();
    }

    DataSourceQueryParams(int versionCode, DataSource dataSource, long id, long startTimeNanos, long endTimeNanos, int limit, int readBehind) {
        this.mVersionCode = versionCode;
        this.zzanm = dataSource;
        this.zzQD = id;
        this.zzanC = startTimeNanos;
        this.zzapU = endTimeNanos;
        this.zzapP = limit;
        this.zzapV = readBehind;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
