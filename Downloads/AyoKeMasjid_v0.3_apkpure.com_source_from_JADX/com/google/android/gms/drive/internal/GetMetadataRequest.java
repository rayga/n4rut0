package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetMetadataRequest implements SafeParcelable {
    public static final Creator<GetMetadataRequest> CREATOR;
    final int mVersionCode;
    final DriveId zzahP;
    final boolean zzajq;

    static {
        CREATOR = new zzai();
    }

    GetMetadataRequest(int versionCode, DriveId id, boolean forceFromServer) {
        this.mVersionCode = versionCode;
        this.zzahP = id;
        this.zzajq = forceFromServer;
    }

    public GetMetadataRequest(DriveId id, boolean forceFromServer) {
        this(1, id, forceFromServer);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzai.zza(this, dest, flags);
    }
}
