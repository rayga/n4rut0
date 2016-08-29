package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemovePermissionRequest implements SafeParcelable {
    public static final Creator<RemovePermissionRequest> CREATOR;
    final int mVersionCode;
    final String zzagM;
    final String zzagY;
    final DriveId zzags;
    final boolean zzahM;

    static {
        CREATOR = new zzbn();
    }

    RemovePermissionRequest(int versionCode, DriveId driveId, String accountIdentifier, boolean sendEventOnCompletion, String trackingTag) {
        this.mVersionCode = versionCode;
        this.zzags = driveId;
        this.zzagY = accountIdentifier;
        this.zzahM = sendEventOnCompletion;
        this.zzagM = trackingTag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbn.zza(this, dest, flags);
    }
}
