package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzmr.zza;

public class DailyTotalRequest implements SafeParcelable {
    public static final Creator<DailyTotalRequest> CREATOR;
    private final int mVersionCode;
    private final String zzOZ;
    private final DataType zzanl;
    private final zzmr zzapF;

    static {
        CREATOR = new zzc();
    }

    DailyTotalRequest(int versionCode, IBinder callback, DataType dataType, String packageName) {
        this.mVersionCode = versionCode;
        this.zzapF = zza.zzbt(callback);
        this.zzanl = dataType;
        this.zzOZ = packageName;
    }

    public DailyTotalRequest(zzmr callback, DataType dataType, String packageName) {
        this.mVersionCode = 1;
        this.zzapF = callback;
        this.zzanl = dataType;
        this.zzOZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public DataType getDataType() {
        return this.zzanl;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("DailyTotalRequest{%s}", new Object[]{this.zzanl.zzrH()});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzc.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        return this.zzapF.asBinder();
    }
}
