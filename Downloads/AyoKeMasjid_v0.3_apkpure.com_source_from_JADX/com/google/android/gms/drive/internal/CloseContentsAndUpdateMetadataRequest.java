package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Creator<CloseContentsAndUpdateMetadataRequest> CREATOR;
    final int mVersionCode;
    final String zzagM;
    final boolean zzagN;
    final DriveId zzahP;
    final MetadataBundle zzahQ;
    final Contents zzahR;
    final int zzahS;
    final int zzahT;
    final boolean zzahU;

    static {
        CREATOR = new zzg();
    }

    CloseContentsAndUpdateMetadataRequest(int versionCode, DriveId id, MetadataBundle metadataChangeSet, Contents contentsReference, boolean notifyOnCompletion, String trackingTag, int commitStrategy, int contentsRequestId, boolean isContentsValidForConflictDetection) {
        this.mVersionCode = versionCode;
        this.zzahP = id;
        this.zzahQ = metadataChangeSet;
        this.zzahR = contentsReference;
        this.zzagN = notifyOnCompletion;
        this.zzagM = trackingTag;
        this.zzahS = commitStrategy;
        this.zzahT = contentsRequestId;
        this.zzahU = isContentsValidForConflictDetection;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId id, MetadataBundle metadataChangeSet, int contentsRequestId, boolean isContentsValidForConflictDetection, ExecutionOptions executionOptions) {
        this(1, id, metadataChangeSet, null, executionOptions.zzqm(), executionOptions.zzql(), executionOptions.zzqn(), contentsRequestId, isContentsValidForConflictDetection);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
