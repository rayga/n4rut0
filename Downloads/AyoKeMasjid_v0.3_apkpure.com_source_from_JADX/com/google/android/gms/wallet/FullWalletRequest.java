package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest implements SafeParcelable {
    public static final Creator<FullWalletRequest> CREATOR;
    private final int mVersionCode;
    String zzaWi;
    String zzaWj;
    Cart zzaWt;

    public final class Builder {
        final /* synthetic */ FullWalletRequest zzaWu;

        private Builder(FullWalletRequest fullWalletRequest) {
            this.zzaWu = fullWalletRequest;
        }

        public FullWalletRequest build() {
            return this.zzaWu;
        }

        public Builder setCart(Cart cart) {
            this.zzaWu.zzaWt = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.zzaWu.zzaWi = googleTransactionId;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzaWu.zzaWj = merchantTransactionId;
            return this;
        }
    }

    static {
        CREATOR = new zzf();
    }

    FullWalletRequest() {
        this.mVersionCode = 1;
    }

    FullWalletRequest(int versionCode, String googleTransactionId, String merchantTransactionId, Cart cart) {
        this.mVersionCode = versionCode;
        this.zzaWi = googleTransactionId;
        this.zzaWj = merchantTransactionId;
        this.zzaWt = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return new Builder(null);
    }

    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.zzaWt;
    }

    public String getGoogleTransactionId() {
        return this.zzaWi;
    }

    public String getMerchantTransactionId() {
        return this.zzaWj;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }
}
