package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class CredentialRequest implements SafeParcelable {
    public static final Creator<CredentialRequest> CREATOR;
    final int mVersionCode;
    private final boolean zzRj;
    private final String[] zzRk;
    private final CredentialPickerConfig zzRl;
    private final CredentialPickerConfig zzRm;

    public static final class Builder {
        private boolean zzRj;
        private String[] zzRk;
        private CredentialPickerConfig zzRl;
        private CredentialPickerConfig zzRm;

        public CredentialRequest build() {
            if (this.zzRk == null) {
                this.zzRk = new String[0];
            }
            if (this.zzRj || this.zzRk.length != 0) {
                return new CredentialRequest();
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public Builder setAccountTypes(String... accountTypes) {
            this.zzRk = accountTypes;
            return this;
        }

        public Builder setCredentialHintPickerConfig(CredentialPickerConfig config) {
            this.zzRm = config;
            return this;
        }

        public Builder setCredentialPickerConfig(CredentialPickerConfig config) {
            this.zzRl = config;
            return this;
        }

        public Builder setSupportsPasswordLogin(boolean supportsPasswordLogin) {
            this.zzRj = supportsPasswordLogin;
            return this;
        }
    }

    static {
        CREATOR = new zzc();
    }

    CredentialRequest(int version, boolean supportsPasswordLogin, String[] accountTypes, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialHintPickerConfig) {
        this.mVersionCode = version;
        this.zzRj = supportsPasswordLogin;
        this.zzRk = (String[]) zzx.zzv(accountTypes);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzRl = credentialPickerConfig;
        if (credentialHintPickerConfig == null) {
            credentialHintPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzRm = credentialHintPickerConfig;
    }

    private CredentialRequest(Builder builder) {
        this(2, builder.zzRj, builder.zzRk, builder.zzRl, builder.zzRm);
    }

    public int describeContents() {
        return 0;
    }

    public String[] getAccountTypes() {
        return this.zzRk;
    }

    public CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzRm;
    }

    public CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzRl;
    }

    public boolean getSupportsPasswordLogin() {
        return this.zzRj;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
