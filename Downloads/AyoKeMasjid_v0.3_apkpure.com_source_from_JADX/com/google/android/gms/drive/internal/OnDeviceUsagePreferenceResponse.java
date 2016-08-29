package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
    public static final Creator<OnDeviceUsagePreferenceResponse> CREATOR;
    final int mVersionCode;
    final FileUploadPreferencesImpl zzajJ;

    static {
        CREATOR = new zzaw();
    }

    OnDeviceUsagePreferenceResponse(int versionCode, FileUploadPreferencesImpl preferences) {
        this.mVersionCode = versionCode;
        this.zzajJ = preferences;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaw.zza(this, dest, flags);
    }

    public FileUploadPreferencesImpl zzqP() {
        return this.zzajJ;
    }
}
