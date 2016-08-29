package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LoyaltyPointsBalance implements SafeParcelable {
    public static final Creator<LoyaltyPointsBalance> CREATOR;
    private final int mVersionCode;
    String zzaWz;
    String zzaYA;
    double zzaYB;
    long zzaYC;
    int zzaYD;
    int zzaYz;

    static {
        CREATOR = new zzd();
    }

    LoyaltyPointsBalance() {
        this.mVersionCode = 1;
        this.zzaYD = -1;
        this.zzaYz = -1;
        this.zzaYB = -1.0d;
    }

    LoyaltyPointsBalance(int versionCode, int balanceInt, String balanceString, double balanceDouble, String currencyCode, long currencyMicros, int balanceType) {
        this.mVersionCode = versionCode;
        this.zzaYz = balanceInt;
        this.zzaYA = balanceString;
        this.zzaYB = balanceDouble;
        this.zzaWz = currencyCode;
        this.zzaYC = currencyMicros;
        this.zzaYD = balanceType;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
