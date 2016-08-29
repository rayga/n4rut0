package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CancelPendingActionsRequest implements SafeParcelable {
    public static final Creator<CancelPendingActionsRequest> CREATOR;
    final int mVersionCode;
    final List<String> zzahv;

    static {
        CREATOR = new zze();
    }

    CancelPendingActionsRequest(int versionCode, List<String> trackingTags) {
        this.mVersionCode = versionCode;
        this.zzahv = trackingTags;
    }

    public CancelPendingActionsRequest(List<String> trackingTags) {
        this(1, trackingTags);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
