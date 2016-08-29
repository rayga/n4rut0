package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ControlProgressRequest implements SafeParcelable {
    public static final Creator<ControlProgressRequest> CREATOR;
    final int mVersionCode;
    final DriveId zzags;
    final int zzahW;
    final int zzahX;

    static {
        CREATOR = new zzi();
    }

    ControlProgressRequest(int versionCode, int controllerType, int methodCode, DriveId driveId) {
        this.mVersionCode = versionCode;
        this.zzahW = controllerType;
        this.zzahX = methodCode;
        this.zzags = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
