package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet implements SafeParcelable {
    public static final Creator<FullWallet> CREATOR;
    private final int mVersionCode;
    String zzaWi;
    String zzaWj;
    ProxyCard zzaWk;
    String zzaWl;
    Address zzaWm;
    Address zzaWn;
    String[] zzaWo;
    UserAddress zzaWp;
    UserAddress zzaWq;
    InstrumentInfo[] zzaWr;
    PaymentMethodToken zzaWs;

    static {
        CREATOR = new zze();
    }

    private FullWallet() {
        this.mVersionCode = 1;
    }

    FullWallet(int versionCode, String googleTransactionId, String merchantTransactionId, ProxyCard proxyCard, String email, Address billingAddress, Address shippingAddress, String[] paymentDescriptions, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos, PaymentMethodToken paymentMethodToken) {
        this.mVersionCode = versionCode;
        this.zzaWi = googleTransactionId;
        this.zzaWj = merchantTransactionId;
        this.zzaWk = proxyCard;
        this.zzaWl = email;
        this.zzaWm = billingAddress;
        this.zzaWn = shippingAddress;
        this.zzaWo = paymentDescriptions;
        this.zzaWp = buyerBillingAddress;
        this.zzaWq = buyerShippingAddress;
        this.zzaWr = instrumentInfos;
        this.zzaWs = paymentMethodToken;
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

    public PaymentMethodToken getPaymentMethodToken() {
        return this.zzaWs;
    }

    public ProxyCard getProxyCard() {
        return this.zzaWk;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzaWn;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }
}
