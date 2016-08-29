package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PaymentMethodToken implements SafeParcelable {
    public static final Creator<PaymentMethodToken> CREATOR;
    private final int mVersionCode;
    String zzaJf;
    int zzaXv;

    static {
        CREATOR = new zzo();
    }

    private PaymentMethodToken() {
        this.mVersionCode = 1;
    }

    PaymentMethodToken(int versionCode, int tokenizationType, String token) {
        this.mVersionCode = versionCode;
        this.zzaXv = tokenizationType;
        this.zzaJf = token;
    }

    public int describeContents() {
        return 0;
    }

    public int getPaymentMethodTokenizationType() {
        return this.zzaXv;
    }

    public String getToken() {
        return this.zzaJf;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzo.zza(this, out, flags);
    }
}
