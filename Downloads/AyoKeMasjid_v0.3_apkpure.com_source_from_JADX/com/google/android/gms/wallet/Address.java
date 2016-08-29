package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address implements SafeParcelable {
    public static final Creator<Address> CREATOR;
    private final int mVersionCode;
    String name;
    String phoneNumber;
    String zzFF;
    String zzaAC;
    String zzaAD;
    String zzaAE;
    String zzaAJ;
    boolean zzaAL;
    String zzaAM;
    String zzaVZ;
    String zzaWa;

    static {
        CREATOR = new zza();
    }

    Address() {
        this.mVersionCode = 1;
    }

    Address(int versionCode, String name, String address1, String address2, String address3, String countryCode, String city, String state, String postalCode, String phoneNumber, boolean isPostBox, String companyName) {
        this.mVersionCode = versionCode;
        this.name = name;
        this.zzaAC = address1;
        this.zzaAD = address2;
        this.zzaAE = address3;
        this.zzFF = countryCode;
        this.zzaVZ = city;
        this.zzaWa = state;
        this.zzaAJ = postalCode;
        this.phoneNumber = phoneNumber;
        this.zzaAL = isPostBox;
        this.zzaAM = companyName;
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

    public String getCity() {
        return this.zzaVZ;
    }

    public String getCompanyName() {
        return this.zzaAM;
    }

    public String getCountryCode() {
        return this.zzFF;
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

    public String getState() {
        return this.zzaWa;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isPostBox() {
        return this.zzaAL;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
