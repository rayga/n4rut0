package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UpdatePermissionRequest implements SafeParcelable {
    public static final Creator<UpdatePermissionRequest> CREATOR;
    final int mVersionCode;
    final String zzagM;
    final String zzagY;
    final DriveId zzags;
    final boolean zzahM;
    final int zzakb;

    static {
        CREATOR = new zzbw();
    }

    UpdatePermissionRequest(int versionCode, DriveId driveId, String accountIdentifier, int newRole, boolean sendEventOnCompletion, String trackingTag) {
        this.mVersionCode = versionCode;
        this.zzags = driveId;
        this.zzagY = accountIdentifier;
        this.zzakb = newRole;
        this.zzahM = sendEventOnCompletion;
        this.zzagM = trackingTag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbw.zza(this, dest, flags);
    }
}
