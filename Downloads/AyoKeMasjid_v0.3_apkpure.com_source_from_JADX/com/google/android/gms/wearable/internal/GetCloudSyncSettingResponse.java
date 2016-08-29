package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncSettingResponse implements SafeParcelable {
    public static final Creator<GetCloudSyncSettingResponse> CREATOR;
    public final boolean enabled;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new zzam();
    }

    GetCloudSyncSettingResponse(int versionCode, int statusCode, boolean enabled) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.enabled = enabled;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzam.zza(this, dest, flags);
    }
}
