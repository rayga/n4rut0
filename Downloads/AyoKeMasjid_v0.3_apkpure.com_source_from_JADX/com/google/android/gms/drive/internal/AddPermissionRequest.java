package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class AddPermissionRequest implements SafeParcelable {
    public static final Creator<AddPermissionRequest> CREATOR;
    final int mVersionCode;
    final String zzagM;
    final DriveId zzags;
    final Permission zzahJ;
    final boolean zzahK;
    final String zzahL;
    final boolean zzahM;

    static {
        CREATOR = new zzb();
    }

    AddPermissionRequest(int versionCode, DriveId driveId, Permission permission, boolean sendNotificationEmail, String emailMessage, boolean sendEventOnCompletion, String trackingTag) {
        this.mVersionCode = versionCode;
        this.zzags = driveId;
        this.zzahJ = permission;
        this.zzahK = sendNotificationEmail;
        this.zzahL = emailMessage;
        this.zzahM = sendEventOnCompletion;
        this.zzagM = trackingTag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
