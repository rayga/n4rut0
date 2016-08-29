package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmu.zza;

public class DataTypeReadRequest implements SafeParcelable {
    public static final Creator<DataTypeReadRequest> CREATOR;
    private final String mName;
    private final int mVersionCode;
    private final String zzOZ;
    private final zzmu zzaqb;

    static {
        CREATOR = new zzj();
    }

    DataTypeReadRequest(int versionCode, String name, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzaqb = callback == null ? null : zza.zzbw(callback);
        this.zzOZ = packageName;
    }

    public DataTypeReadRequest(String name, zzmu callback, String packageName) {
        this.mVersionCode = 2;
        this.mName = name;
        this.zzaqb = callback;
        this.zzOZ = packageName;
    }

    private boolean zzb(DataTypeReadRequest dataTypeReadRequest) {
        return zzw.equal(this.mName, dataTypeReadRequest.mName);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataTypeReadRequest) && zzb((DataTypeReadRequest) o));
    }

    public String getName() {
        return this.mName;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName);
    }

    public String toString() {
        return zzw.zzu(this).zzg("name", this.mName).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    public IBinder zzsc() {
        return this.zzaqb.asBinder();
    }
}
