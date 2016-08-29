package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSourcesResult implements Result, SafeParcelable {
    public static final Creator<DataSourcesResult> CREATOR;
    private final int mVersionCode;
    private final Status zzQA;
    private final List<DataSource> zzapG;

    static {
        CREATOR = new zze();
    }

    DataSourcesResult(int versionCode, List<DataSource> dataSources, Status status) {
        this.mVersionCode = versionCode;
        this.zzapG = Collections.unmodifiableList(dataSources);
        this.zzQA = status;
    }

    public DataSourcesResult(List<DataSource> dataSources, Status status) {
        this.mVersionCode = 3;
        this.zzapG = Collections.unmodifiableList(dataSources);
        this.zzQA = status;
    }

    public static DataSourcesResult zzR(Status status) {
        return new DataSourcesResult(Collections.emptyList(), status);
    }

    private boolean zzb(DataSourcesResult dataSourcesResult) {
        return this.zzQA.equals(dataSourcesResult.zzQA) && zzw.equal(this.zzapG, dataSourcesResult.zzapG);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSourcesResult) && zzb((DataSourcesResult) that));
    }

    public List<DataSource> getDataSources() {
        return this.zzapG;
    }

    public List<DataSource> getDataSources(DataType dataType) {
        List arrayList = new ArrayList();
        for (DataSource dataSource : this.zzapG) {
            if (dataSource.getDataType().equals(dataType)) {
                arrayList.add(dataSource);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzQA;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzQA, this.zzapG);
    }

    public String toString() {
        return zzw.zzu(this).zzg(Games.EXTRA_STATUS, this.zzQA).zzg("dataSets", this.zzapG).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
