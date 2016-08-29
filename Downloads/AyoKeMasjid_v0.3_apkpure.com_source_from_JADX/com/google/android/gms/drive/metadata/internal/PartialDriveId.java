package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class PartialDriveId implements SafeParcelable {
    public static final Creator<PartialDriveId> CREATOR;
    final int mVersionCode;
    final String zzagC;
    final long zzagD;
    final int zzagE;

    static {
        CREATOR = new zzm();
    }

    PartialDriveId(int versionCode, String resourceId, long sqlId, int resourceType) {
        this.mVersionCode = versionCode;
        this.zzagC = resourceId;
        this.zzagD = sqlId;
        this.zzagE = resourceType;
    }

    public PartialDriveId(String resourceId, long sqlId, int resourceType) {
        this(1, resourceId, sqlId, resourceType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzm.zza(this, out, flags);
    }

    public DriveId zzD(long j) {
        return new DriveId(this.zzagC, this.zzagD, j, this.zzagE);
    }
}
