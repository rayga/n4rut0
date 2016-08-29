package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable {
    public static final Creator<ProxyCard> CREATOR;
    private final int mVersionCode;
    int zzaXA;
    int zzaXB;
    String zzaXy;
    String zzaXz;

    static {
        CREATOR = new zzq();
    }

    ProxyCard(int versionCode, String pan, String cvn, int expirationMonth, int expirationYear) {
        this.mVersionCode = versionCode;
        this.zzaXy = pan;
        this.zzaXz = cvn;
        this.zzaXA = expirationMonth;
        this.zzaXB = expirationYear;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.zzaXz;
    }

    public int getExpirationMonth() {
        return this.zzaXA;
    }

    public int getExpirationYear() {
        return this.zzaXB;
    }

    public String getPan() {
        return this.zzaXy;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzq.zza(this, out, flags);
    }
}
