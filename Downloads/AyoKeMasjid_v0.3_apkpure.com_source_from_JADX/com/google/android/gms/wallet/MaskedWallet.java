package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet implements SafeParcelable {
    public static final Creator<MaskedWallet> CREATOR;
    private final int mVersionCode;
    String zzaWi;
    String zzaWj;
    String zzaWl;
    Address zzaWm;
    Address zzaWn;
    String[] zzaWo;
    UserAddress zzaWp;
    UserAddress zzaWq;
    InstrumentInfo[] zzaWr;
    LoyaltyWalletObject[] zzaXb;
    OfferWalletObject[] zzaXc;

    public final class Builder {
        final /* synthetic */ MaskedWallet zzaXd;

        private Builder(MaskedWallet maskedWallet) {
            this.zzaXd = maskedWallet;
        }

        public MaskedWallet build() {
            return this.zzaXd;
        }

        public Builder setBillingAddress(Address billingAddress) {
            this.zzaXd.zzaWm = billingAddress;
            return this;
        }

        public Builder setBuyerBillingAddress(UserAddress buyerBillingAddress) {
            this.zzaXd.zzaWp = buyerBillingAddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress buyerShippingAddress) {
            this.zzaXd.zzaWq = buyerShippingAddress;
            return this;
        }

        public Builder setEmail(String email) {
            this.zzaXd.zzaWl = email;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.zzaXd.zzaWi = googleTransactionId;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo[] instrumentInfos) {
            this.zzaXd.zzaWr = instrumentInfos;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzaXd.zzaWj = merchantTransactionId;
            return this;
        }

        public Builder setPaymentDescriptions(String[] paymentDescriptions) {
            this.zzaXd.zzaWo = paymentDescriptions;
            return this;
        }

        public Builder setShippingAddress(Address shippingAddress) {
            this.zzaXd.zzaWn = shippingAddress;
            return this;
        }

        @Deprecated
        public Builder zza(LoyaltyWalletObject[] loyaltyWalletObjectArr) {
            this.zzaXd.zzaXb = loyaltyWalletObjectArr;
            return this;
        }

        @Deprecated
        public Builder zza(OfferWalletObject[] offerWalletObjectArr) {
            this.zzaXd.zzaXc = offerWalletObjectArr;
            return this;
        }
    }

    static {
        CREATOR = new zzk();
    }

    private MaskedWallet() {
        this.mVersionCode = 2;
    }

    MaskedWallet(int versionCode, String googleTransactionId, String merchantTransactionId, String[] paymentDescriptions, String email, Address billingAddress, Address shippingAddress, LoyaltyWalletObject[] loyaltyWalletObjects, OfferWalletObject[] offerWalletObjects, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos) {
        this.mVersionCode = versionCode;
        this.zzaWi = googleTransactionId;
        this.zzaWj = merchantTransactionId;
        this.zzaWo = paymentDescriptions;
        this.zzaWl = email;
        this.zzaWm = billingAddress;
        this.zzaWn = shippingAddress;
        this.zzaXb = loyaltyWalletObjects;
        this.zzaXc = offerWalletObjects;
        this.zzaWp = buyerBillingAddress;
        this.zzaWq = buyerShippingAddress;
        this.zzaWr = instrumentInfos;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        zzx.zzv(maskedWallet);
        return zzCh().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail()).zza(maskedWallet.zzCi()).zza(maskedWallet.zzCj()).setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public static Builder zzCh() {
        MaskedWallet maskedWallet = new MaskedWallet();
        maskedWallet.getClass();
        return new Builder(null);
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.zzaWm;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.zzaWp;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.zzaWq;
    }

    public String getEmail() {
        return this.zzaWl;
    }

    public String getGoogleTransactionId() {
        return this.zzaWi;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.zzaWr;
    }

    public String getMerchantTransactionId() {
        return this.zzaWj;
    }

    public String[] getPaymentDescriptions() {
        return this.zzaWo;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzaWn;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    @Deprecated
    public LoyaltyWalletObject[] zzCi() {
        return this.zzaXb;
    }

    @Deprecated
    public OfferWalletObject[] zzCj() {
        return this.zzaXc;
    }
}
