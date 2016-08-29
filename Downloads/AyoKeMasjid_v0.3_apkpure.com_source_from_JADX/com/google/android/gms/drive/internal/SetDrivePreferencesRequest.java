package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class SetDrivePreferencesRequest implements SafeParcelable {
    public static final Creator<SetDrivePreferencesRequest> CREATOR;
    final int mVersionCode;
    final DrivePreferences zzajM;

    static {
        CREATOR = new zzbo();
    }

    SetDrivePreferencesRequest(int versionCode, DrivePreferences prefs) {
        this.mVersionCode = versionCode;
        this.zzajM = prefs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbo.zza(this, dest, flags);
    }
}
