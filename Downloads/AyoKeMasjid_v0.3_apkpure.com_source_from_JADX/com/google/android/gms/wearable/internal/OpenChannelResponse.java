package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OpenChannelResponse implements SafeParcelable {
    public static final Creator<OpenChannelResponse> CREATOR;
    public final int statusCode;
    public final int versionCode;
    public final ChannelImpl zzaZR;

    static {
        CREATOR = new zzbc();
    }

    OpenChannelResponse(int versionCode, int statusCode, ChannelImpl channel) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzaZR = channel;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbc.zza(this, dest, flags);
    }
}
