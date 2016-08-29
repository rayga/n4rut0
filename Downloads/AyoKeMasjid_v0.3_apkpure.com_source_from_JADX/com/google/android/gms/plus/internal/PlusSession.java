package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

public class PlusSession implements SafeParcelable {
    public static final zzh CREATOR;
    private final int mVersionCode;
    private final String zzQE;
    private final String zzWq;
    private final String zzaLA;
    private final String zzaLB;
    private final String zzaLC;
    private final PlusCommonExtras zzaLD;
    private final String[] zzaLx;
    private final String[] zzaLy;
    private final String[] zzaLz;

    static {
        CREATOR = new zzh();
    }

    PlusSession(int versionCode, String accountName, String[] requestedScopes, String[] visibleActions, String[] requiredFeatures, String packageNameForAuth, String callingPackageName, String applicationName, String clientId_DEPRECATED, PlusCommonExtras extras) {
        this.mVersionCode = versionCode;
        this.zzQE = accountName;
        this.zzaLx = requestedScopes;
        this.zzaLy = visibleActions;
        this.zzaLz = requiredFeatures;
        this.zzaLA = packageNameForAuth;
        this.zzaLB = callingPackageName;
        this.zzWq = applicationName;
        this.zzaLC = clientId_DEPRECATED;
        this.zzaLD = extras;
    }

    public PlusSession(String accountName, String[] requestedScopes, String[] visibleActions, String[] requiredFeatures, String packageNameForAuth, String callingPackageName, String applicationName, PlusCommonExtras extra) {
        this.mVersionCode = 1;
        this.zzQE = accountName;
        this.zzaLx = requestedScopes;
        this.zzaLy = visibleActions;
        this.zzaLz = requiredFeatures;
        this.zzaLA = packageNameForAuth;
        this.zzaLB = callingPackageName;
        this.zzWq = applicationName;
        this.zzaLC = null;
        this.zzaLD = extra;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusSession)) {
            return false;
        }
        PlusSession plusSession = (PlusSession) obj;
        return this.mVersionCode == plusSession.mVersionCode && zzw.equal(this.zzQE, plusSession.zzQE) && Arrays.equals(this.zzaLx, plusSession.zzaLx) && Arrays.equals(this.zzaLy, plusSession.zzaLy) && Arrays.equals(this.zzaLz, plusSession.zzaLz) && zzw.equal(this.zzaLA, plusSession.zzaLA) && zzw.equal(this.zzaLB, plusSession.zzaLB) && zzw.equal(this.zzWq, plusSession.zzWq) && zzw.equal(this.zzaLC, plusSession.zzaLC) && zzw.equal(this.zzaLD, plusSession.zzaLD);
    }

    public String getAccountName() {
        return this.zzQE;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzQE, this.zzaLx, this.zzaLy, this.zzaLz, this.zzaLA, this.zzaLB, this.zzWq, this.zzaLC, this.zzaLD);
    }

    public String toString() {
        return zzw.zzu(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("accountName", this.zzQE).zzg("requestedScopes", this.zzaLx).zzg("visibleActivities", this.zzaLy).zzg("requiredFeatures", this.zzaLz).zzg("packageNameForAuth", this.zzaLA).zzg("callingPackageName", this.zzaLB).zzg("applicationName", this.zzWq).zzg("extra", this.zzaLD.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }

    public String zzml() {
        return this.zzWq;
    }

    public String[] zzyL() {
        return this.zzaLx;
    }

    public String[] zzyM() {
        return this.zzaLy;
    }

    public String[] zzyN() {
        return this.zzaLz;
    }

    public String zzyO() {
        return this.zzaLA;
    }

    public String zzyP() {
        return this.zzaLB;
    }

    public String zzyQ() {
        return this.zzaLC;
    }

    public PlusCommonExtras zzyR() {
        return this.zzaLD;
    }

    public Bundle zzyS() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.zzaLD.zzA(bundle);
        return bundle;
    }
}
