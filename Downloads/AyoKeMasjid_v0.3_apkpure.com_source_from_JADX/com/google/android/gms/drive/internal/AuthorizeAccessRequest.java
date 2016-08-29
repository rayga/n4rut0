package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Creator<AuthorizeAccessRequest> CREATOR;
    final int mVersionCode;
    final DriveId zzags;
    final long zzahN;

    static {
        CREATOR = new zzc();
    }

    AuthorizeAccessRequest(int versionCode, long appId, DriveId driveId) {
        this.mVersionCode = versionCode;
        this.zzahN = appId;
        this.zzags = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
