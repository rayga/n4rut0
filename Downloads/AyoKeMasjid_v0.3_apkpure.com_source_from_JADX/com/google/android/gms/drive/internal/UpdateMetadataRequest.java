package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class UpdateMetadataRequest implements SafeParcelable {
    public static final Creator<UpdateMetadataRequest> CREATOR;
    final int mVersionCode;
    final DriveId zzahP;
    final MetadataBundle zzahQ;

    static {
        CREATOR = new zzbv();
    }

    UpdateMetadataRequest(int versionCode, DriveId id, MetadataBundle metadataChangeSet) {
        this.mVersionCode = versionCode;
        this.zzahP = id;
        this.zzahQ = metadataChangeSet;
    }

    public UpdateMetadataRequest(DriveId id, MetadataBundle metadataChangeSet) {
        this(1, id, metadataChangeSet);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbv.zza(this, dest, flags);
    }
}
