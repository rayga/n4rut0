package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest implements SafeParcelable {
    public static final Creator<OpenContentsRequest> CREATOR;
    final int mVersionCode;
    final int zzagr;
    final DriveId zzahP;
    final int zzajV;

    static {
        CREATOR = new zzbi();
    }

    OpenContentsRequest(int versionCode, DriveId id, int mode, int baseRequestId) {
        this.mVersionCode = versionCode;
        this.zzahP = id;
        this.zzagr = mode;
        this.zzajV = baseRequestId;
    }

    public OpenContentsRequest(DriveId id, int mode, int baseRequestId) {
        this(1, id, mode, baseRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbi.zza(this, dest, flags);
    }
}
