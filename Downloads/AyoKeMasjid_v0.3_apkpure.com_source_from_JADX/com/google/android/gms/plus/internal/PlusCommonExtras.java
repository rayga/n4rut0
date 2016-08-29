package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import org.bpmikc.akm.BuildConfig;

public class PlusCommonExtras implements SafeParcelable {
    public static final zzf CREATOR;
    private final int mVersionCode;
    private String zzaLu;
    private String zzaLv;

    static {
        CREATOR = new zzf();
    }

    public PlusCommonExtras() {
        this.mVersionCode = 1;
        this.zzaLu = BuildConfig.FLAVOR;
        this.zzaLv = BuildConfig.FLAVOR;
    }

    PlusCommonExtras(int versionCode, String gpsrc, String clientCallingPackage) {
        this.mVersionCode = versionCode;
        this.zzaLu = gpsrc;
        this.zzaLv = clientCallingPackage;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.mVersionCode == plusCommonExtras.mVersionCode && zzw.equal(this.zzaLu, plusCommonExtras.zzaLu) && zzw.equal(this.zzaLv, plusCommonExtras.zzaLv);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzaLu, this.zzaLv);
    }

    public String toString() {
        return zzw.zzu(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("Gpsrc", this.zzaLu).zzg("ClientCallingPackage", this.zzaLv).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }

    public void zzA(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", zzc.zza(this));
    }

    public String zzyJ() {
        return this.zzaLu;
    }

    public String zzyK() {
        return this.zzaLv;
    }
}
