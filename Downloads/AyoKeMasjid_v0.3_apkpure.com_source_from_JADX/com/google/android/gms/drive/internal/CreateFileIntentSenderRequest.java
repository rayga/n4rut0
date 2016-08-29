package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<CreateFileIntentSenderRequest> CREATOR;
    final int mVersionCode;
    final String zzagU;
    final DriveId zzagX;
    final int zzagq;
    final MetadataBundle zzaib;
    final Integer zzaic;

    static {
        CREATOR = new zzl();
    }

    CreateFileIntentSenderRequest(int versionCode, MetadataBundle metadata, int requestId, String title, DriveId startFolder, Integer fileType) {
        this.mVersionCode = versionCode;
        this.zzaib = metadata;
        this.zzagq = requestId;
        this.zzagU = title;
        this.zzagX = startFolder;
        this.zzaic = fileType;
    }

    public CreateFileIntentSenderRequest(MetadataBundle metadata, int requestId, String title, DriveId startFolder, int fileType) {
        this(1, metadata, requestId, title, startFolder, Integer.valueOf(fileType));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }
}
