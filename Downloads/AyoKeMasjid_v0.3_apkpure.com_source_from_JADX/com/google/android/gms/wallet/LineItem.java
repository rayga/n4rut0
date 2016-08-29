package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem implements SafeParcelable {
    public static final Creator<LineItem> CREATOR;
    String description;
    private final int mVersionCode;
    String zzaWE;
    String zzaWF;
    int zzaWG;
    String zzaWb;
    String zzaWc;

    public final class Builder {
        final /* synthetic */ LineItem zzaWH;

        private Builder(LineItem lineItem) {
            this.zzaWH = lineItem;
        }

        public LineItem build() {
            return this.zzaWH;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzaWH.zzaWc = currencyCode;
            return this;
        }

        public Builder setDescription(String description) {
            this.zzaWH.description = description;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.zzaWH.zzaWE = quantity;
            return this;
        }

        public Builder setRole(int role) {
            this.zzaWH.zzaWG = role;
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.zzaWH.zzaWb = totalPrice;
            return this;
        }

        public Builder setUnitPrice(String unitPrice) {
            this.zzaWH.zzaWF = unitPrice;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    static {
        CREATOR = new zzi();
    }

    LineItem() {
        this.mVersionCode = 1;
        this.zzaWG = 0;
    }

    LineItem(int versionCode, String description, String quantity, String unitPrice, String totalPrice, int role, String currencyCode) {
        this.mVersionCode = versionCode;
        this.description = description;
        this.zzaWE = quantity;
        this.zzaWF = unitPrice;
        this.zzaWb = totalPrice;
        this.zzaWG = role;
        this.zzaWc = currencyCode;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder(null);
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzaWc;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.zzaWE;
    }

    public int getRole() {
        return this.zzaWG;
    }

    public String getTotalPrice() {
        return this.zzaWb;
    }

    public String getUnitPrice() {
        return this.zzaWF;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
