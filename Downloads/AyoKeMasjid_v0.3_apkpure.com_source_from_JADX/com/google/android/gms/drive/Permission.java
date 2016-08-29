package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class Permission implements SafeParcelable {
    public static final Creator<Permission> CREATOR;
    final int mVersionCode;
    private String zzagY;
    private int zzagZ;
    private String zzaha;
    private String zzahb;
    private int zzahc;
    private boolean zzahd;

    static {
        CREATOR = new zzh();
    }

    Permission(int versionCode, String accountIdentifier, int accountType, String accountDisplayName, String photoLink, int role, boolean isLinkRequired) {
        this.mVersionCode = versionCode;
        this.zzagY = accountIdentifier;
        this.zzagZ = accountType;
        this.zzaha = accountDisplayName;
        this.zzahb = photoLink;
        this.zzahc = role;
        this.zzahd = isLinkRequired;
    }

    public static boolean zzch(int i) {
        switch (i) {
            case Barcode.QR_CODE /*256*/:
            case FileUploadPreferences.BATTERY_USAGE_CHARGING_ONLY /*257*/:
            case CallbackHandler.MSG_ROUTE_REMOVED /*258*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzci(int i) {
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
            case CompletionEvent.STATUS_FAILURE /*1*/:
            case CompletionEvent.STATUS_CONFLICT /*2*/:
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        Permission permission = (Permission) o;
        return zzw.equal(this.zzagY, permission.zzagY) && this.zzagZ == permission.zzagZ && this.zzahc == permission.zzahc && this.zzahd == permission.zzahd;
    }

    public int getRole() {
        return !zzci(this.zzahc) ? -1 : this.zzahc;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzagY, Integer.valueOf(this.zzagZ), Integer.valueOf(this.zzahc), Boolean.valueOf(this.zzahd));
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public String zzqr() {
        return !zzch(this.zzagZ) ? null : this.zzagY;
    }

    public int zzqs() {
        return !zzch(this.zzagZ) ? -1 : this.zzagZ;
    }

    public String zzqt() {
        return this.zzaha;
    }

    public String zzqu() {
        return this.zzahb;
    }

    public boolean zzqv() {
        return this.zzahd;
    }
}
