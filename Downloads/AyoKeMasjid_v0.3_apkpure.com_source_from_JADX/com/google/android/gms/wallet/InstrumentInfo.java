package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo implements SafeParcelable {
    public static final Creator<InstrumentInfo> CREATOR;
    private final int mVersionCode;
    private String zzaWC;
    private String zzaWD;

    static {
        CREATOR = new zzh();
    }

    InstrumentInfo(int versionCode, String instrumentType, String instrumentDetails) {
        this.mVersionCode = versionCode;
        this.zzaWC = instrumentType;
        this.zzaWD = instrumentDetails;
    }

    public int describeContents() {
        return 0;
    }

    public String getInstrumentDetails() {
        return this.zzaWD;
    }

    public String getInstrumentType() {
        return this.zzaWC;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }
}
