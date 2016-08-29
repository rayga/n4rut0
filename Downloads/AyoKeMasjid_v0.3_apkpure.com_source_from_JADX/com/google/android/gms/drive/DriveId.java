package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.drive.internal.zzat;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import org.bpmikc.akm.BuildConfig;

public class DriveId implements SafeParcelable {
    public static final Creator<DriveId> CREATOR;
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int mVersionCode;
    final String zzagC;
    final long zzagD;
    final int zzagE;
    private volatile String zzagF;
    final long zzagn;
    private volatile String zzagp;

    static {
        CREATOR = new zzd();
    }

    DriveId(int versionCode, String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        boolean z = false;
        this.zzagp = null;
        this.zzagF = null;
        this.mVersionCode = versionCode;
        this.zzagC = resourceId;
        zzx.zzZ(!BuildConfig.FLAVOR.equals(resourceId));
        if (!(resourceId == null && sqlId == -1)) {
            z = true;
        }
        zzx.zzZ(z);
        this.zzagD = sqlId;
        this.zzagn = databaseInstanceId;
        this.zzagE = resourceType;
    }

    public DriveId(String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        String str = (resourceId == null || !resourceId.startsWith("generated-android-")) ? resourceId : null;
        this(RESOURCE_TYPE_FOLDER, str, sqlId, databaseInstanceId, resourceType);
    }

    public static DriveId decodeFromString(String s) {
        zzx.zzb(s.startsWith("DriveId:"), "Invalid DriveId: " + s);
        return zzk(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    public static DriveId zzcC(String str) {
        zzx.zzv(str);
        return new DriveId(str, -1, -1, RESOURCE_TYPE_UNKNOWN);
    }

    static DriveId zzk(byte[] bArr) {
        try {
            zzas zzl = zzas.zzl(bArr);
            return new DriveId(zzl.versionCode, BuildConfig.FLAVOR.equals(zzl.zzajB) ? null : zzl.zzajB, zzl.zzajC, zzl.zzajz, zzl.zzajD);
        } catch (zzrw e) {
            throw new IllegalArgumentException();
        }
    }

    private byte[] zzqk() {
        zzrx com_google_android_gms_drive_internal_zzat = new zzat();
        com_google_android_gms_drive_internal_zzat.zzajC = this.zzagD;
        com_google_android_gms_drive_internal_zzat.zzajz = this.zzagn;
        return zzrx.zzf(com_google_android_gms_drive_internal_zzat);
    }

    public int describeContents() {
        return RESOURCE_TYPE_FILE;
    }

    public final String encodeToString() {
        if (this.zzagp == null) {
            this.zzagp = "DriveId:" + Base64.encodeToString(zzqe(), 10);
        }
        return this.zzagp;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.zzagn != this.zzagn) {
            zzy.zzw("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        } else if (driveId.zzagD == -1 && this.zzagD == -1) {
            return driveId.zzagC.equals(this.zzagC);
        } else {
            if (this.zzagC == null || driveId.zzagC == null) {
                if (driveId.zzagD != this.zzagD) {
                    z = false;
                }
                return z;
            } else if (driveId.zzagD != this.zzagD) {
                return false;
            } else {
                if (driveId.zzagC.equals(this.zzagC)) {
                    return true;
                }
                zzy.zzw("DriveId", "Unexpected unequal resourceId for same DriveId object.");
                return false;
            }
        }
    }

    public String getResourceId() {
        return this.zzagC;
    }

    public int getResourceType() {
        return this.zzagE;
    }

    public int hashCode() {
        return this.zzagD == -1 ? this.zzagC.hashCode() : (String.valueOf(this.zzagn) + String.valueOf(this.zzagD)).hashCode();
    }

    public final String toInvariantString() {
        if (this.zzagF == null) {
            this.zzagF = Base64.encodeToString(zzqk(), 10);
        }
        return this.zzagF;
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }

    final byte[] zzqe() {
        zzrx com_google_android_gms_drive_internal_zzas = new zzas();
        com_google_android_gms_drive_internal_zzas.versionCode = this.mVersionCode;
        com_google_android_gms_drive_internal_zzas.zzajB = this.zzagC == null ? BuildConfig.FLAVOR : this.zzagC;
        com_google_android_gms_drive_internal_zzas.zzajC = this.zzagD;
        com_google_android_gms_drive_internal_zzas.zzajz = this.zzagn;
        com_google_android_gms_drive_internal_zzas.zzajD = this.zzagE;
        return zzrx.zzf(com_google_android_gms_drive_internal_zzas);
    }
}
