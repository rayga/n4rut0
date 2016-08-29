package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetPermissionsRequest implements SafeParcelable {
    public static final Creator<GetPermissionsRequest> CREATOR;
    final int mVersionCode;
    final DriveId zzags;

    static {
        CREATOR = new zzaj();
    }

    GetPermissionsRequest(int versionCode, DriveId driveId) {
        this.mVersionCode = versionCode;
        this.zzags = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaj.zza(this, dest, flags);
    }
}
