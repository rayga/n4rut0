package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Creator<Cart> CREATOR;
    private final int mVersionCode;
    String zzaWb;
    String zzaWc;
    ArrayList<LineItem> zzaWd;

    public final class Builder {
        final /* synthetic */ Cart zzaWe;

        private Builder(Cart cart) {
            this.zzaWe = cart;
        }

        public Builder addLineItem(LineItem lineItem) {
            this.zzaWe.zzaWd.add(lineItem);
            return this;
        }

        public Cart build() {
            return this.zzaWe;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzaWe.zzaWc = currencyCode;
            return this;
        }

        public Builder setLineItems(List<LineItem> lineItems) {
            this.zzaWe.zzaWd.clear();
            this.zzaWe.zzaWd.addAll(lineItems);
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.zzaWe.zzaWb = totalPrice;
            return this;
        }
    }

    static {
        CREATOR = new zzb();
    }

    Cart() {
        this.mVersionCode = 1;
        this.zzaWd = new ArrayList();
    }

    Cart(int versionCode, String totalPrice, String currencyCode, ArrayList<LineItem> lineItems) {
        this.mVersionCode = versionCode;
        this.zzaWb = totalPrice;
        this.zzaWc = currencyCode;
        this.zzaWd = lineItems;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder(null);
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzaWc;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.zzaWd;
    }

    public String getTotalPrice() {
        return this.zzaWb;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
