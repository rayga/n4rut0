package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.AddressConstants.Extras;

public final class UserAddress implements SafeParcelable {
    public static final Creator<UserAddress> CREATOR;
    private final int mVersionCode;
    String name;
    String phoneNumber;
    String zzFF;
    String zzaAC;
    String zzaAD;
    String zzaAE;
    String zzaAF;
    String zzaAG;
    String zzaAH;
    String zzaAI;
    String zzaAJ;
    String zzaAK;
    boolean zzaAL;
    String zzaAM;
    String zzaAN;

    static {
        CREATOR = new zzb();
    }

    UserAddress() {
        this.mVersionCode = 1;
    }

    UserAddress(int versionCode, String name, String address1, String address2, String address3, String address4, String address5, String administrativeArea, String locality, String countryCode, String postalCode, String sortingCode, String phoneNumber, boolean isPostBox, String companyName, String emailAddress) {
        this.mVersionCode = versionCode;
        this.name = name;
        this.zzaAC = address1;
        this.zzaAD = address2;
        this.zzaAE = address3;
        this.zzaAF = address4;
        this.zzaAG = address5;
        this.zzaAH = administrativeArea;
        this.zzaAI = locality;
        this.zzFF = countryCode;
        this.zzaAJ = postalCode;
        this.zzaAK = sortingCode;
        this.phoneNumber = phoneNumber;
        this.zzaAL = isPostBox;
        this.zzaAM = companyName;
        this.zzaAN = emailAddress;
    }

    public static UserAddress fromIntent(Intent data) {
        return (data == null || !data.hasExtra(Extras.EXTRA_ADDRESS)) ? null : (UserAddress) data.getParcelableExtra(Extras.EXTRA_ADDRESS);
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.zzaAC;
    }

    public String getAddress2() {
        return this.zzaAD;
    }

    public String getAddress3() {
        return this.zzaAE;
    }

    public String getAddress4() {
        return this.zzaAF;
    }

    public String getAddress5() {
        return this.zzaAG;
    }

    public String getAdministrativeArea() {
        return this.zzaAH;
    }

    public String getCompanyName() {
        return this.zzaAM;
    }

    public String getCountryCode() {
        return this.zzFF;
    }

    public String getEmailAddress() {
        return this.zzaAN;
    }

    public String getLocality() {
        return this.zzaAI;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPostalCode() {
        return this.zzaAJ;
    }

    public String getSortingCode() {
        return this.zzaAK;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isPostBox() {
        return this.zzaAL;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
