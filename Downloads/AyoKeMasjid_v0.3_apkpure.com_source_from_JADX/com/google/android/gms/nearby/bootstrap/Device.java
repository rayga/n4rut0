package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class Device implements SafeParcelable {
    public static final Creator<Device> CREATOR;
    private final String description;
    private final String name;
    final int versionCode;
    private final String zzaIZ;
    private final byte zzaJa;

    static {
        CREATOR = new zzb();
    }

    Device(int versionCode, String name, String description, String deviceId, byte deviceType) {
        this.versionCode = versionCode;
        this.name = zzx.zzcs(name);
        this.description = (String) zzx.zzv(description);
        this.zzaIZ = (String) zzx.zzv(deviceId);
        zzx.zzb(deviceType <= 3, (Object) "Unknown device type");
        this.zzaJa = deviceType;
    }

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceId() {
        return this.zzaIZ;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + ": " + this.description + "[" + this.zzaJa + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public byte zzyc() {
        return this.zzaJa;
    }
}
