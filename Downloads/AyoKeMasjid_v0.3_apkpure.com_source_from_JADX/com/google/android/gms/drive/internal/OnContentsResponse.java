package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse implements SafeParcelable {
    public static final Creator<OnContentsResponse> CREATOR;
    final int mVersionCode;
    final Contents zzaiD;
    final boolean zzajI;

    static {
        CREATOR = new zzav();
    }

    OnContentsResponse(int versionCode, Contents contents, boolean outOfDate) {
        this.mVersionCode = versionCode;
        this.zzaiD = contents;
        this.zzajI = outOfDate;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzav.zza(this, dest, flags);
    }

    public Contents zzqN() {
        return this.zzaiD;
    }

    public boolean zzqO() {
        return this.zzajI;
    }
}
