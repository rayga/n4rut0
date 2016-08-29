package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

public class FitnessDataSourcesRequest implements SafeParcelable {
    public static final Creator<FitnessDataSourcesRequest> CREATOR;
    private final int mVersionCode;
    private final List<DataType> zzanw;

    static {
        CREATOR = new zza();
    }

    FitnessDataSourcesRequest(int versionCode, List<DataType> dataTypes) {
        this.mVersionCode = versionCode;
        this.zzanw = dataTypes;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzanw);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return zzw.zzu(this).zzg("dataTypes", this.zzanw).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }
}
