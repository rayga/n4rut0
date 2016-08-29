package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class AppIdentifier implements SafeParcelable {
    public static final Creator<AppIdentifier> CREATOR;
    private final int mVersionCode;
    private final String zzaoA;

    static {
        CREATOR = new zza();
    }

    AppIdentifier(int versionCode, String identifier) {
        this.mVersionCode = versionCode;
        this.zzaoA = zzx.zzh(identifier, "Missing application identifier value");
    }

    public AppIdentifier(String identifier) {
        this(1, identifier);
    }

    public int describeContents() {
        return 0;
    }

    public String getIdentifier() {
        return this.zzaoA;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
