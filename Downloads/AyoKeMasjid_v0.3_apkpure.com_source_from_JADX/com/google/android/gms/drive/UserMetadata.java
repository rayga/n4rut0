package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata implements SafeParcelable {
    public static final Creator<UserMetadata> CREATOR;
    final int mVersionCode;
    final String zzahg;
    final String zzahh;
    final String zzahi;
    final boolean zzahj;
    final String zzahk;

    static {
        CREATOR = new zzj();
    }

    UserMetadata(int versionCode, String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this.mVersionCode = versionCode;
        this.zzahg = permissionId;
        this.zzahh = displayName;
        this.zzahi = pictureUrl;
        this.zzahj = isAuthenticatedUser;
        this.zzahk = emailAddress;
    }

    public UserMetadata(String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this(1, permissionId, displayName, pictureUrl, isAuthenticatedUser, emailAddress);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.zzahg, this.zzahh, this.zzahi, Boolean.valueOf(this.zzahj), this.zzahk});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
