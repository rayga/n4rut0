package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

public class Credential implements SafeParcelable {
    public static final Creator<Credential> CREATOR;
    public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
    private final String mName;
    final int mVersionCode;
    private final String zzRa;
    private final String zzRb;
    private final Uri zzRc;
    private final List<IdToken> zzRd;
    private final String zzRe;
    private final String zzRf;
    private final String zzRg;
    private final String zzRh;
    private final String zzwj;

    public static class Builder {
        private String mName;
        private String zzRa;
        private String zzRb;
        private Uri zzRc;
        private List<IdToken> zzRd;
        private String zzRe;
        private String zzRf;
        private String zzRg;
        private String zzRh;
        private final String zzwj;

        public Builder(Credential credential) {
            this.zzwj = credential.zzwj;
            this.mName = credential.mName;
            this.zzRc = credential.zzRc;
            this.zzRd = credential.zzRd;
            this.zzRe = credential.zzRe;
            this.zzRf = credential.zzRf;
            this.zzRg = credential.zzRg;
            this.zzRa = credential.zzRa;
            this.zzRb = credential.zzRb;
            this.zzRh = credential.zzRh;
        }

        public Builder(String id) {
            this.zzwj = id;
        }

        public Credential build() {
            if (TextUtils.isEmpty(this.zzRe) || TextUtils.isEmpty(this.zzRf)) {
                return new Credential(2, this.zzRa, this.zzRb, this.zzwj, this.mName, this.zzRc, this.zzRd, this.zzRe, this.zzRf, this.zzRg, this.zzRh);
            }
            throw new IllegalStateException("Only one of password or accountType may be set");
        }

        public Builder setAccountType(String accountType) {
            String scheme = Uri.parse(accountType).getScheme();
            boolean z = "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
            zzx.zzZ(z);
            this.zzRf = accountType;
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        public Builder setPassword(String password) {
            this.zzRe = password;
            return this;
        }

        public Builder setProfilePictureUri(Uri profilePictureUri) {
            this.zzRc = profilePictureUri;
            return this;
        }
    }

    static {
        CREATOR = new zza();
    }

    Credential(int version, String internalCredentialId, String internalServerContext, String id, String name, Uri profilePictureUri, List<IdToken> idTokens, String password, String accountType, String generatedPassword, String generatedHintId) {
        this.mVersionCode = version;
        this.zzRa = internalCredentialId;
        this.zzRb = internalServerContext;
        this.zzwj = (String) zzx.zzv(id);
        this.mName = name;
        this.zzRc = profilePictureUri;
        this.zzRd = idTokens == null ? Collections.emptyList() : Collections.unmodifiableList(idTokens);
        this.zzRe = password;
        this.zzRf = accountType;
        this.zzRg = generatedPassword;
        this.zzRh = generatedHintId;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) other;
        return TextUtils.equals(this.zzwj, credential.zzwj) && TextUtils.equals(this.mName, credential.mName) && zzw.equal(this.zzRc, credential.zzRc) && TextUtils.equals(this.zzRe, credential.zzRe) && TextUtils.equals(this.zzRf, credential.zzRf) && TextUtils.equals(this.zzRg, credential.zzRg);
    }

    public String getAccountType() {
        return this.zzRf;
    }

    public String getGeneratedPassword() {
        return this.zzRg;
    }

    public String getId() {
        return this.zzwj;
    }

    public String getName() {
        return this.mName;
    }

    public String getPassword() {
        return this.zzRe;
    }

    public Uri getProfilePictureUri() {
        return this.zzRc;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzwj, this.mName, this.zzRc, this.zzRe, this.zzRf, this.zzRg);
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public String zzlr() {
        return this.zzRa;
    }

    public String zzls() {
        return this.zzRb;
    }

    public List<IdToken> zzlt() {
        return this.zzRd;
    }

    public String zzlu() {
        return this.zzRh;
    }
}
