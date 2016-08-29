package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UnsubscribeResourceRequest implements SafeParcelable {
    public static final Creator<UnsubscribeResourceRequest> CREATOR;
    final int mVersionCode;
    final DriveId zzahP;

    static {
        CREATOR = new zzbt();
    }

    UnsubscribeResourceRequest(int versionCode, DriveId id) {
        this.mVersionCode = versionCode;
        this.zzahP = id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbt.zza(this, dest, flags);
    }
}
