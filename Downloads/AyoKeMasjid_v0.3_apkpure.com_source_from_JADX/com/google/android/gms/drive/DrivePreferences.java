package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DrivePreferences implements SafeParcelable {
    public static final Creator<DrivePreferences> CREATOR;
    final int mVersionCode;
    final boolean zzagG;

    static {
        CREATOR = new zze();
    }

    DrivePreferences(int versionCode, boolean syncOverWifiOnly) {
        this.mVersionCode = versionCode;
        this.zzagG = syncOverWifiOnly;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }
}
