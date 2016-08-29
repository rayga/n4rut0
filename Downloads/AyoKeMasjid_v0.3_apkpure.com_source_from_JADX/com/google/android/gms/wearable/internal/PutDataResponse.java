package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PutDataResponse implements SafeParcelable {
    public static final Creator<PutDataResponse> CREATOR;
    public final int statusCode;
    public final int versionCode;
    public final DataItemParcelable zzbaA;

    static {
        CREATOR = new zzbe();
    }

    PutDataResponse(int versionCode, int statusCode, DataItemParcelable dataItem) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbaA = dataItem;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbe.zza(this, dest, flags);
    }
}
