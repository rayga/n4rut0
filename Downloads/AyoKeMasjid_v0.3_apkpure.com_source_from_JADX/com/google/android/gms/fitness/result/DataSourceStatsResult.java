package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceStatsResult implements SafeParcelable {
    public static final Creator<DataSourceStatsResult> CREATOR;
    final int mVersionCode;
    public final long zzQD;
    public final DataSource zzanm;
    public final boolean zzaqJ;
    public final long zzaqK;
    public final long zzaqL;

    static {
        CREATOR = new zzd();
    }

    DataSourceStatsResult(int versionCode, DataSource dataSource, long id, boolean isRemote, long minEndTimeNanos, long maxEndTimeNanos) {
        this.mVersionCode = versionCode;
        this.zzanm = dataSource;
        this.zzQD = id;
        this.zzaqJ = isRemote;
        this.zzaqK = minEndTimeNanos;
        this.zzaqL = maxEndTimeNanos;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
