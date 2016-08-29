package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
    public static final Creator<OfferWalletObject> CREATOR;
    private final int mVersionCode;
    CommonWalletObject zzaWv;
    String zzaXu;
    String zzhL;

    static {
        CREATOR = new zzn();
    }

    OfferWalletObject() {
        this.mVersionCode = 3;
    }

    OfferWalletObject(int versionCode, String id, String redemptionCode, CommonWalletObject commonWalletObject) {
        this.mVersionCode = versionCode;
        this.zzaXu = redemptionCode;
        if (versionCode < 3) {
            this.zzaWv = CommonWalletObject.zzCn().zzfu(id).zzCo();
        } else {
            this.zzaWv = commonWalletObject;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzaWv.getId();
    }

    public String getRedemptionCode() {
        return this.zzaXu;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }
}
