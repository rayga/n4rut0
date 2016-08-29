package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
    public static final Creator<FileUploadPreferencesImpl> CREATOR;
    final int mVersionCode;
    int zzajj;
    int zzajk;
    boolean zzajl;

    static {
        CREATOR = new zzaf();
    }

    FileUploadPreferencesImpl(int versionCode, int networkTypePreference, int batteryUsagePreference, boolean allowRoaming) {
        this.mVersionCode = versionCode;
        this.zzajj = networkTypePreference;
        this.zzajk = batteryUsagePreference;
        this.zzajl = allowRoaming;
    }

    public static boolean zzcM(int i) {
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzcN(int i) {
        switch (i) {
            case Barcode.QR_CODE /*256*/:
            case FileUploadPreferences.BATTERY_USAGE_CHARGING_ONLY /*257*/:
                return true;
            default:
                return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getBatteryUsagePreference() {
        return !zzcN(this.zzajk) ? 0 : this.zzajk;
    }

    public int getNetworkTypePreference() {
        return !zzcM(this.zzajj) ? 0 : this.zzajj;
    }

    public boolean isRoamingAllowed() {
        return this.zzajl;
    }

    public void setBatteryUsagePreference(int batteryUsagePreference) {
        if (zzcN(batteryUsagePreference)) {
            this.zzajk = batteryUsagePreference;
            return;
        }
        throw new IllegalArgumentException("Invalid battery usage preference value.");
    }

    public void setNetworkTypePreference(int networkTypePreference) {
        if (zzcM(networkTypePreference)) {
            this.zzajj = networkTypePreference;
            return;
        }
        throw new IllegalArgumentException("Invalid data connection preference value.");
    }

    public void setRoamingAllowed(boolean allowRoaming) {
        this.zzajl = allowRoaming;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzaf.zza(this, parcel, flags);
    }
}
