package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
    public static final Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR;
    final int mVersionCode;
    final String zzajo;
    final boolean zzajp;

    static {
        CREATOR = new zzah();
    }

    GetDriveIdFromUniqueIdentifierRequest(int versionCode, String uniqueIdentifier, boolean isInAppFolder) {
        this.mVersionCode = versionCode;
        this.zzajo = uniqueIdentifier;
        this.zzajp = isInAppFolder;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzah.zza(this, dest, flags);
    }
}
