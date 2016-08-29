package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.games.Games;

public class DailyTotalResult implements Result, SafeParcelable {
    public static final Creator<DailyTotalResult> CREATOR;
    private final int mVersionCode;
    private final Status zzQA;
    private final DataSet zzaoD;

    static {
        CREATOR = new zzb();
    }

    DailyTotalResult(int versionCode, Status status, DataSet dataSet) {
        this.mVersionCode = versionCode;
        this.zzQA = status;
        this.zzaoD = dataSet;
    }

    public DailyTotalResult(DataSet dataSet, Status status) {
        this.mVersionCode = 1;
        this.zzQA = status;
        this.zzaoD = dataSet;
    }

    public static DailyTotalResult zzQ(Status status) {
        return new DailyTotalResult(null, status);
    }

    private boolean zzb(DailyTotalResult dailyTotalResult) {
        return this.zzQA.equals(dailyTotalResult.zzQA) && zzw.equal(this.zzaoD, dailyTotalResult.zzaoD);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DailyTotalResult) && zzb((DailyTotalResult) that));
    }

    public Status getStatus() {
        return this.zzQA;
    }

    public DataSet getTotal() {
        return this.zzaoD;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzQA, this.zzaoD);
    }

    public String toString() {
        return zzw.zzu(this).zzg(Games.EXTRA_STATUS, this.zzQA).zzg("dataPoint", this.zzaoD).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
