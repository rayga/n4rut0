package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DriveSpace implements SafeParcelable {
    public static final Creator<DriveSpace> CREATOR;
    public static final DriveSpace zzagH;
    public static final DriveSpace zzagI;
    public static final DriveSpace zzagJ;
    public static final Set<DriveSpace> zzagK;
    public static final String zzagL;
    private final String mName;
    final int mVersionCode;

    static {
        CREATOR = new zzg();
        zzagH = new DriveSpace("DRIVE");
        zzagI = new DriveSpace("APP_DATA_FOLDER");
        zzagJ = new DriveSpace("PHOTOS");
        zzagK = Collections.unmodifiableSet(new HashSet(Arrays.asList(new DriveSpace[]{zzagH, zzagI, zzagJ})));
        zzagL = TextUtils.join(",", zzagK.toArray());
    }

    DriveSpace(int versionCode, String name) {
        this.mVersionCode = versionCode;
        this.mName = (String) zzx.zzv(name);
    }

    private DriveSpace(String name) {
        this(1, name);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return (o == null || o.getClass() != DriveSpace.class) ? false : this.mName.equals(((DriveSpace) o).mName);
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return 1247068382 ^ this.mName.hashCode();
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }
}
