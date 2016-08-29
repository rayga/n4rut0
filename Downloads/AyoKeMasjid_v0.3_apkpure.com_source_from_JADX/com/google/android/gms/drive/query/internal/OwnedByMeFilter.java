package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class OwnedByMeFilter extends AbstractFilter {
    public static final zzo CREATOR;
    final int mVersionCode;

    static {
        CREATOR = new zzo();
    }

    public OwnedByMeFilter() {
        this(1);
    }

    OwnedByMeFilter(int versionCode) {
        this.mVersionCode = versionCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzo.zza(this, out, flags);
    }

    public <F> F zza(zzf<F> com_google_android_gms_drive_query_internal_zzf_F) {
        return com_google_android_gms_drive_query_internal_zzf_F.zzri();
    }
}
