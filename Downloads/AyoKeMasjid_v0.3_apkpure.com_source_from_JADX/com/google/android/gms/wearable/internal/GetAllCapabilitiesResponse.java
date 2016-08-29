package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class GetAllCapabilitiesResponse implements SafeParcelable {
    public static final Creator<GetAllCapabilitiesResponse> CREATOR;
    public final int statusCode;
    public final int versionCode;
    final List<CapabilityInfoParcelable> zzbar;

    static {
        CREATOR = new zzag();
    }

    GetAllCapabilitiesResponse(int versionCode, int statusCode, List<CapabilityInfoParcelable> capabilities) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbar = capabilities;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzag.zza(this, dest, flags);
    }
}
