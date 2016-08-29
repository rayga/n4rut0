package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzar;
import com.google.android.gms.internal.zzrx;

public class ChangeSequenceNumber implements SafeParcelable {
    public static final Creator<ChangeSequenceNumber> CREATOR;
    final int mVersionCode;
    final long zzagm;
    final long zzagn;
    final long zzago;
    private volatile String zzagp;

    static {
        CREATOR = new zza();
    }

    ChangeSequenceNumber(int versionCode, long sequenceNumber, long databaseInstanceId, long accountId) {
        boolean z = true;
        this.zzagp = null;
        zzx.zzZ(sequenceNumber != -1);
        zzx.zzZ(databaseInstanceId != -1);
        if (accountId == -1) {
            z = false;
        }
        zzx.zzZ(z);
        this.mVersionCode = versionCode;
        this.zzagm = sequenceNumber;
        this.zzagn = databaseInstanceId;
        this.zzago = accountId;
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzagp == null) {
            this.zzagp = "ChangeSequenceNumber:" + Base64.encodeToString(zzqe(), 10);
        }
        return this.zzagp;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChangeSequenceNumber)) {
            return false;
        }
        ChangeSequenceNumber changeSequenceNumber = (ChangeSequenceNumber) obj;
        return changeSequenceNumber.zzagn == this.zzagn && changeSequenceNumber.zzago == this.zzago && changeSequenceNumber.zzagm == this.zzagm;
    }

    public int hashCode() {
        return (String.valueOf(this.zzagm) + String.valueOf(this.zzagn) + String.valueOf(this.zzago)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    final byte[] zzqe() {
        zzrx com_google_android_gms_drive_internal_zzar = new zzar();
        com_google_android_gms_drive_internal_zzar.versionCode = this.mVersionCode;
        com_google_android_gms_drive_internal_zzar.zzajy = this.zzagm;
        com_google_android_gms_drive_internal_zzar.zzajz = this.zzagn;
        com_google_android_gms_drive_internal_zzar.zzajA = this.zzago;
        return zzrx.zzf(com_google_android_gms_drive_internal_zzar);
    }
}
