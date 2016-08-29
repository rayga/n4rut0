package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR;
    final int mVersionCode;
    final String zzagM;
    final boolean zzahM;
    final Contents zzahR;
    final MetadataBundle zzaib;
    final Integer zzaic;
    final DriveId zzaid;
    final int zzaie;
    final int zzaif;

    static {
        CREATOR = new zzm();
    }

    CreateFileRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference, Integer fileType, boolean sendEventOnCompletion, String trackingTag, int createStrategy, int openContentsRequestId) {
        if (!(contentsReference == null || openContentsRequestId == 0)) {
            zzx.zzb(contentsReference.getRequestId() == openContentsRequestId, (Object) "inconsistent contents reference");
        }
        if ((fileType == null || fileType.intValue() == 0) && contentsReference == null && openContentsRequestId == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.mVersionCode = versionCode;
        this.zzaid = (DriveId) zzx.zzv(parentDriveId);
        this.zzaib = (MetadataBundle) zzx.zzv(metadata);
        this.zzahR = contentsReference;
        this.zzaic = fileType;
        this.zzagM = trackingTag;
        this.zzaie = createStrategy;
        this.zzahM = sendEventOnCompletion;
        this.zzaif = openContentsRequestId;
    }

    public CreateFileRequest(DriveId parentDriveId, MetadataBundle metadata, int openContentsRequestId, int fileType, ExecutionOptions executionOptions) {
        this(2, parentDriveId, metadata, null, Integer.valueOf(fileType), executionOptions.zzqm(), executionOptions.zzql(), executionOptions.zzqn(), openContentsRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }
}
