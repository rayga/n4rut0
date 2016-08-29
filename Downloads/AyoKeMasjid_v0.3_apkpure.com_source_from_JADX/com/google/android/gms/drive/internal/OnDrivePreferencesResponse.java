package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class OnDrivePreferencesResponse implements SafeParcelable {
    public static final Creator<OnDrivePreferencesResponse> CREATOR;
    final int mVersionCode;
    DrivePreferences zzajM;

    static {
        CREATOR = new zzaz();
    }

    OnDrivePreferencesResponse(int versionCode, DrivePreferences prefs) {
        this.mVersionCode = versionCode;
        this.zzajM = prefs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaz.zza(this, dest, flags);
    }
}
