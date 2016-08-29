package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class GiftCardWalletObject implements SafeParcelable {
    public static final Creator<GiftCardWalletObject> CREATOR;
    final int mVersionCode;
    String pin;
    long zzaWA;
    String zzaWB;
    CommonWalletObject zzaWv;
    String zzaWw;
    String zzaWx;
    long zzaWy;
    String zzaWz;

    static {
        CREATOR = new zzg();
    }

    GiftCardWalletObject() {
        this.zzaWv = CommonWalletObject.zzCn().zzCo();
        this.mVersionCode = 1;
    }

    GiftCardWalletObject(int versionCode, CommonWalletObject commonWalletObject, String cardNumber, String pin, String cardIdentifier, long balanceMicros, String balanceCurrencyCode, long balanceUpdateTime, String eventNumber) {
        this.zzaWv = CommonWalletObject.zzCn().zzCo();
        this.mVersionCode = versionCode;
        this.zzaWv = commonWalletObject;
        this.zzaWw = cardNumber;
        this.pin = pin;
        this.zzaWy = balanceMicros;
        this.zzaWz = balanceCurrencyCode;
        this.zzaWA = balanceUpdateTime;
        this.zzaWB = eventNumber;
        this.zzaWx = cardIdentifier;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzaWv.getId();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
