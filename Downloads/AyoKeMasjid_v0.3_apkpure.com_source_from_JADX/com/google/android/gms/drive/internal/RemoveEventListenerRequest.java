package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Creator<RemoveEventListenerRequest> CREATOR;
    final int mVersionCode;
    final int zzafk;
    final DriveId zzags;

    static {
        CREATOR = new zzbm();
    }

    RemoveEventListenerRequest(int versionCode, DriveId driveId, int eventType) {
        this.mVersionCode = versionCode;
        this.zzags = driveId;
        this.zzafk = eventType;
    }

    public RemoveEventListenerRequest(DriveId id, int eventType) {
        this(1, id, eventType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbm.zza(this, dest, flags);
    }
}
