package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncOptInStatusResponse implements SafeParcelable {
    public static final Creator<GetCloudSyncOptInStatusResponse> CREATOR;
    public final int statusCode;
    public final int versionCode;
    public final boolean zzbav;
    public final boolean zzbaw;

    static {
        CREATOR = new zzal();
    }

    GetCloudSyncOptInStatusResponse(int versionCode, int statusCode, boolean isOptInOrOutDone, boolean isOptedIn) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbav = isOptInOrOutDone;
        this.zzbaw = isOptedIn;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzal.zza(this, dest, flags);
    }
}
