package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CloseChannelResponse implements SafeParcelable {
    public static final Creator<CloseChannelResponse> CREATOR;
    public final int statusCode;
    public final int versionCode;

    static {
        CREATOR = new zzu();
    }

    CloseChannelResponse(int versionCode, int statusCode) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzu.zza(this, dest, flags);
    }
}
