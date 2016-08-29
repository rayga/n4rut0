package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletObjectMessage implements SafeParcelable {
    public static final Creator<WalletObjectMessage> CREATOR;
    String body;
    private final int mVersionCode;
    String zzaYE;
    TimeInterval zzaYH;
    UriData zzaYI;
    UriData zzaYJ;

    static {
        CREATOR = new zzi();
    }

    WalletObjectMessage() {
        this.mVersionCode = 1;
    }

    WalletObjectMessage(int versionCode, String header, String body, TimeInterval displayInterval, UriData actionUri, UriData imageUri) {
        this.mVersionCode = versionCode;
        this.zzaYE = header;
        this.body = body;
        this.zzaYH = displayInterval;
        this.zzaYI = actionUri;
        this.zzaYJ = imageUri;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
