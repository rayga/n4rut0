package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Creator<OnDownloadProgressResponse> CREATOR;
    final int mVersionCode;
    final long zzajK;
    final long zzajL;

    static {
        CREATOR = new zzax();
    }

    OnDownloadProgressResponse(int versionCode, long bytesLoaded, long bytesExpected) {
        this.mVersionCode = versionCode;
        this.zzajK = bytesLoaded;
        this.zzajL = bytesExpected;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzax.zza(this, dest, flags);
    }

    public long zzqQ() {
        return this.zzajK;
    }

    public long zzqR() {
        return this.zzajL;
    }
}
