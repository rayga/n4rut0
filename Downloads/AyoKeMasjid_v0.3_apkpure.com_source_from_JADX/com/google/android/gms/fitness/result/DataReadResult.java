package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataReadResult implements Result, SafeParcelable {
    public static final Creator<DataReadResult> CREATOR;
    private final int mVersionCode;
    private final Status zzQA;
    private final List<DataSource> zzanI;
    private final List<DataSet> zzany;
    private final List<Bucket> zzaqG;
    private int zzaqH;
    private final List<DataType> zzaqI;

    static {
        CREATOR = new zzc();
    }

    DataReadResult(int versionCode, List<RawDataSet> dataSets, Status status, List<RawBucket> buckets, int batchCount, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.mVersionCode = versionCode;
        this.zzQA = status;
        this.zzaqH = batchCount;
        this.zzanI = uniqueDataSources;
        this.zzaqI = uniqueDataTypes;
        this.zzany = new ArrayList(dataSets.size());
        for (RawDataSet dataSet : dataSets) {
            this.zzany.add(new DataSet(dataSet, uniqueDataSources));
        }
        this.zzaqG = new ArrayList(buckets.size());
        for (RawBucket bucket : buckets) {
            this.zzaqG.add(new Bucket(bucket, uniqueDataSources));
        }
    }

    public DataReadResult(List<DataSet> dataSets, List<Bucket> buckets, Status status) {
        this.mVersionCode = 5;
        this.zzany = dataSets;
        this.zzQA = status;
        this.zzaqG = buckets;
        this.zzaqH = 1;
        this.zzanI = new ArrayList();
        this.zzaqI = new ArrayList();
    }

    public static DataReadResult zza(Status status, DataReadRequest dataReadRequest) {
        List arrayList = new ArrayList();
        for (DataSource create : dataReadRequest.getDataSources()) {
            arrayList.add(DataSet.create(create));
        }
        for (DataType dataType : dataReadRequest.getDataTypes()) {
            arrayList.add(DataSet.create(new Builder().setDataType(dataType).setType(1).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void zza(Bucket bucket, List<Bucket> list) {
        for (Bucket bucket2 : list) {
            if (bucket2.zzb(bucket)) {
                for (DataSet zza : bucket.getDataSets()) {
                    zza(zza, bucket2.getDataSets());
                }
                return;
            }
        }
        this.zzaqG.add(bucket);
    }

    private void zza(DataSet dataSet, List<DataSet> list) {
        for (DataSet dataSet2 : list) {
            if (dataSet2.getDataSource().equals(dataSet.getDataSource())) {
                dataSet2.zzb(dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean zzc(DataReadResult dataReadResult) {
        return this.zzQA.equals(dataReadResult.zzQA) && zzw.equal(this.zzany, dataReadResult.zzany) && zzw.equal(this.zzaqG, dataReadResult.zzaqG);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadResult) && zzc((DataReadResult) that));
    }

    public List<Bucket> getBuckets() {
        return this.zzaqG;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet dataSet : this.zzany) {
            if (dataSource.equals(dataSet.getDataSource())) {
                return dataSet;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{dataSource.getStreamIdentifier()}));
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzany) {
            if (dataType.equals(dataSet.getDataType())) {
                return dataSet;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{dataType.getName()}));
    }

    public List<DataSet> getDataSets() {
        return this.zzany;
    }

    public Status getStatus() {
        return this.zzQA;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzQA, this.zzany, this.zzaqG);
    }

    public String toString() {
        return zzw.zzu(this).zzg(Games.EXTRA_STATUS, this.zzQA).zzg("dataSets", this.zzany.size() > 5 ? this.zzany.size() + " data sets" : this.zzany).zzg("buckets", this.zzaqG.size() > 5 ? this.zzaqG.size() + " buckets" : this.zzaqG).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public void zzb(DataReadResult dataReadResult) {
        for (DataSet zza : dataReadResult.getDataSets()) {
            zza(zza, this.zzany);
        }
        for (Bucket zza2 : dataReadResult.getBuckets()) {
            zza(zza2, this.zzaqG);
        }
    }

    List<DataSource> zzrE() {
        return this.zzanI;
    }

    public int zzsB() {
        return this.zzaqH;
    }

    List<RawBucket> zzsC() {
        List<RawBucket> arrayList = new ArrayList(this.zzaqG.size());
        for (Bucket rawBucket : this.zzaqG) {
            arrayList.add(new RawBucket(rawBucket, this.zzanI, this.zzaqI));
        }
        return arrayList;
    }

    List<RawDataSet> zzsD() {
        List<RawDataSet> arrayList = new ArrayList(this.zzany.size());
        for (DataSet rawDataSet : this.zzany) {
            arrayList.add(new RawDataSet(rawDataSet, this.zzanI, this.zzaqI));
        }
        return arrayList;
    }

    List<DataType> zzsE() {
        return this.zzaqI;
    }
}
