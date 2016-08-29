package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmg;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
    public static final Creator<BleDevice> CREATOR;
    private final String mName;
    private final int mVersionCode;
    private final String zzanu;
    private final List<String> zzanv;
    private final List<DataType> zzanw;

    static {
        CREATOR = new zzb();
    }

    BleDevice(int versionCode, String address, String name, List<String> profiles, List<DataType> dataTypes) {
        this.mVersionCode = versionCode;
        this.zzanu = address;
        this.mName = name;
        this.zzanv = Collections.unmodifiableList(profiles);
        this.zzanw = Collections.unmodifiableList(dataTypes);
    }

    private boolean zza(BleDevice bleDevice) {
        return this.mName.equals(bleDevice.mName) && this.zzanu.equals(bleDevice.zzanu) && zzmg.zza(bleDevice.zzanv, this.zzanv) && zzmg.zza(this.zzanw, bleDevice.zzanw);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof BleDevice) && zza((BleDevice) o));
    }

    public String getAddress() {
        return this.zzanu;
    }

    public List<DataType> getDataTypes() {
        return this.zzanw;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getSupportedProfiles() {
        return this.zzanv;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzanu, this.zzanv, this.zzanw);
    }

    public String toString() {
        return zzw.zzu(this).zzg("name", this.mName).zzg("address", this.zzanu).zzg("dataTypes", this.zzanw).zzg("supportedProfiles", this.zzanv).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
