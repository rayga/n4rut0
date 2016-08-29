package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;

public class DataTypeResult implements Result, SafeParcelable {
    public static final Creator<DataTypeResult> CREATOR;
    private final int mVersionCode;
    private final Status zzQA;
    private final DataType zzanl;

    static {
        CREATOR = new zzg();
    }

    DataTypeResult(int versionCode, Status status, DataType dataType) {
        this.mVersionCode = versionCode;
        this.zzQA = status;
        this.zzanl = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.mVersionCode = 2;
        this.zzQA = status;
        this.zzanl = dataType;
    }

    public static DataTypeResult zzS(Status status) {
        return new DataTypeResult(status, null);
    }

    private boolean zzb(DataTypeResult dataTypeResult) {
        return this.zzQA.equals(dataTypeResult.zzQA) && zzw.equal(this.zzanl, dataTypeResult.zzanl);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataTypeResult) && zzb((DataTypeResult) that));
    }

    public DataType getDataType() {
        return this.zzanl;
    }

    public Status getStatus() {
        return this.zzQA;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzQA, this.zzanl);
    }

    public String toString() {
        return zzw.zzu(this).zzg(Games.EXTRA_STATUS, this.zzQA).zzg("dataType", this.zzanl).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
