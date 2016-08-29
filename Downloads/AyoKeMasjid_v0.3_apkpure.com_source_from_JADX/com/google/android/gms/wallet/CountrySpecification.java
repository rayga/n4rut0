package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR;
    private final int mVersionCode;
    String zzFF;

    static {
        CREATOR = new zzc();
    }

    CountrySpecification(int versionCode, String countryCode) {
        this.mVersionCode = versionCode;
        this.zzFF = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.mVersionCode = 1;
        this.zzFF = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.zzFF;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
