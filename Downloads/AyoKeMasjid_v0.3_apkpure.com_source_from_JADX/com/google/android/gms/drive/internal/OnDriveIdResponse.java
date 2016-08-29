package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Creator<OnDriveIdResponse> CREATOR;
    final int mVersionCode;
    DriveId zzahP;

    static {
        CREATOR = new zzay();
    }

    OnDriveIdResponse(int versionCode, DriveId driveId) {
        this.mVersionCode = versionCode;
        this.zzahP = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzahP;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzay.zza(this, dest, flags);
    }
}
