package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest implements SafeParcelable {
    public static final Creator<CloseContentsRequest> CREATOR;
    final int mVersionCode;
    final Contents zzahR;
    final int zzahT;
    final Boolean zzahV;

    static {
        CREATOR = new zzh();
    }

    CloseContentsRequest(int versionCode, Contents contentsReference, Boolean saveResults, int contentsRequestId) {
        this.mVersionCode = versionCode;
        this.zzahR = contentsReference;
        this.zzahV = saveResults;
        this.zzahT = contentsRequestId;
    }

    public CloseContentsRequest(int contentsRequestId, boolean saveResults) {
        this(1, null, Boolean.valueOf(saveResults), contentsRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
