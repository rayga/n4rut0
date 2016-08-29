package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class ApplicationStatus implements SafeParcelable {
    public static final Creator<ApplicationStatus> CREATOR;
    private final int mVersionCode;
    private String zzWF;

    static {
        CREATOR = new zza();
    }

    public ApplicationStatus() {
        this(1, null);
    }

    ApplicationStatus(int versionCode, String applicationStatusText) {
        this.mVersionCode = versionCode;
        this.zzWF = applicationStatusText;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationStatus)) {
            return false;
        }
        return zzf.zza(this.zzWF, ((ApplicationStatus) obj).zzWF);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzWF);
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public String zzms() {
        return this.zzWF;
    }
}
