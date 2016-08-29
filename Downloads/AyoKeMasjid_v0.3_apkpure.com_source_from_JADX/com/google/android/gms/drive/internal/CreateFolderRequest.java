package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFolderRequest implements SafeParcelable {
    public static final Creator<CreateFolderRequest> CREATOR;
    final int mVersionCode;
    final MetadataBundle zzaib;
    final DriveId zzaid;

    static {
        CREATOR = new zzn();
    }

    CreateFolderRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata) {
        this.mVersionCode = versionCode;
        this.zzaid = (DriveId) zzx.zzv(parentDriveId);
        this.zzaib = (MetadataBundle) zzx.zzv(metadata);
    }

    public CreateFolderRequest(DriveId parentDriveId, MetadataBundle metadata) {
        this(1, parentDriveId, metadata);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }
}
