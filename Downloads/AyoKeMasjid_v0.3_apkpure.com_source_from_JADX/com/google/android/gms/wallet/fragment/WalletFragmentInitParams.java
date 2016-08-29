package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Creator<WalletFragmentInitParams> CREATOR;
    final int mVersionCode;
    private String zzQE;
    private MaskedWalletRequest zzaXS;
    private MaskedWallet zzaXT;
    private int zzaYg;

    public final class Builder {
        final /* synthetic */ WalletFragmentInitParams zzaYh;

        private Builder(WalletFragmentInitParams walletFragmentInitParams) {
            this.zzaYh = walletFragmentInitParams;
        }

        public WalletFragmentInitParams build() {
            boolean z = true;
            boolean z2 = (this.zzaYh.zzaXT != null && this.zzaYh.zzaXS == null) || (this.zzaYh.zzaXT == null && this.zzaYh.zzaXS != null);
            zzx.zza(z2, (Object) "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            if (this.zzaYh.zzaYg < 0) {
                z = false;
            }
            zzx.zza(z, (Object) "masked wallet request code is required and must be non-negative");
            return this.zzaYh;
        }

        public Builder setAccountName(String accountName) {
            this.zzaYh.zzQE = accountName;
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedWallet) {
            this.zzaYh.zzaXT = maskedWallet;
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest request) {
            this.zzaYh.zzaXS = request;
            return this;
        }

        public Builder setMaskedWalletRequestCode(int requestCode) {
            this.zzaYh.zzaYg = requestCode;
            return this;
        }
    }

    static {
        CREATOR = new zza();
    }

    private WalletFragmentInitParams() {
        this.mVersionCode = 1;
        this.zzaYg = -1;
    }

    WalletFragmentInitParams(int versionCode, String accountName, MaskedWalletRequest maskedWalletRequest, int maskedWalletRequestCode, MaskedWallet maskedWallet) {
        this.mVersionCode = versionCode;
        this.zzQE = accountName;
        this.zzaXS = maskedWalletRequest;
        this.zzaYg = maskedWalletRequestCode;
        this.zzaXT = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder(null);
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.zzQE;
    }

    public MaskedWallet getMaskedWallet() {
        return this.zzaXT;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.zzaXS;
    }

    public int getMaskedWalletRequestCode() {
        return this.zzaYg;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
