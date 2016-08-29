package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class DeleteResourceRequest implements SafeParcelable {
    public static final Creator<DeleteResourceRequest> CREATOR;
    final int mVersionCode;
    final DriveId zzahP;

    static {
        CREATOR = new zzp();
    }

    DeleteResourceRequest(int versionCode, DriveId id) {
        this.mVersionCode = versionCode;
        this.zzahP = id;
    }

    public DeleteResourceRequest(DriveId id) {
        this(1, id);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzp.zza(this, dest, flags);
    }
}
