package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CreateWalletObjectsRequest implements SafeParcelable {
    public static final Creator<CreateWalletObjectsRequest> CREATOR;
    private final int mVersionCode;
    LoyaltyWalletObject zzaWf;
    OfferWalletObject zzaWg;
    GiftCardWalletObject zzaWh;

    static {
        CREATOR = new zzd();
    }

    CreateWalletObjectsRequest() {
        this.mVersionCode = 3;
    }

    CreateWalletObjectsRequest(int versionCode, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject, GiftCardWalletObject giftCardWalletObject) {
        this.mVersionCode = versionCode;
        this.zzaWf = loyaltyWalletObject;
        this.zzaWg = offerWalletObject;
        this.zzaWh = giftCardWalletObject;
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
