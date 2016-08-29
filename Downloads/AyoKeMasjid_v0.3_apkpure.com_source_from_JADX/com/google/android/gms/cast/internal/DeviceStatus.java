package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class DeviceStatus implements SafeParcelable {
    public static final Creator<DeviceStatus> CREATOR;
    private final int mVersionCode;
    private double zzUJ;
    private boolean zzUK;
    private int zzWW;
    private int zzWX;
    private ApplicationMetadata zzXh;

    static {
        CREATOR = new zzg();
    }

    public DeviceStatus() {
        this(3, Double.NaN, false, -1, null, -1);
    }

    DeviceStatus(int versionCode, double volume, boolean muteState, int activeInputState, ApplicationMetadata applicationMetadata, int standbyState) {
        this.mVersionCode = versionCode;
        this.zzUJ = volume;
        this.zzUK = muteState;
        this.zzWW = activeInputState;
        this.zzXh = applicationMetadata;
        this.zzWX = standbyState;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceStatus)) {
            return false;
        }
        DeviceStatus deviceStatus = (DeviceStatus) obj;
        return this.zzUJ == deviceStatus.zzUJ && this.zzUK == deviceStatus.zzUK && this.zzWW == deviceStatus.zzWW && zzf.zza(this.zzXh, deviceStatus.zzXh) && this.zzWX == deviceStatus.zzWX;
    }

    public ApplicationMetadata getApplicationMetadata() {
        return this.zzXh;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Double.valueOf(this.zzUJ), Boolean.valueOf(this.zzUK), Integer.valueOf(this.zzWW), this.zzXh, Integer.valueOf(this.zzWX));
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }

    public int zzmA() {
        return this.zzWX;
    }

    public boolean zzmH() {
        return this.zzUK;
    }

    public double zzmy() {
        return this.zzUJ;
    }

    public int zzmz() {
        return this.zzWW;
    }
}
