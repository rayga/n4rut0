package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
    public static final Creator<SetResourceParentsRequest> CREATOR;
    final int mVersionCode;
    final DriveId zzajZ;
    final List<DriveId> zzaka;

    static {
        CREATOR = new zzbq();
    }

    SetResourceParentsRequest(int versionCode, DriveId targetId, List<DriveId> parentIds) {
        this.mVersionCode = versionCode;
        this.zzajZ = targetId;
        this.zzaka = parentIds;
    }

    public SetResourceParentsRequest(DriveId targetId, List<DriveId> parentIds) {
        this(1, targetId, parentIds);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbq.zza(this, dest, flags);
    }
}
