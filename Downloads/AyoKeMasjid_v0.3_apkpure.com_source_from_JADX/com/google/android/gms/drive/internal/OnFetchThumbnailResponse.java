package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnFetchThumbnailResponse implements SafeParcelable {
    public static final Creator<OnFetchThumbnailResponse> CREATOR;
    final int mVersionCode;
    final ParcelFileDescriptor zzajS;

    static {
        CREATOR = new zzbb();
    }

    OnFetchThumbnailResponse(int versionCode, ParcelFileDescriptor thumbnailPfd) {
        this.mVersionCode = versionCode;
        this.zzajS = thumbnailPfd;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbb.zza(this, dest, flags | 1);
    }
}
