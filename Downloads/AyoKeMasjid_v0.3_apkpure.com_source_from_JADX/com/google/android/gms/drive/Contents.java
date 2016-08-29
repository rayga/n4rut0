package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents implements SafeParcelable {
    public static final Creator<Contents> CREATOR;
    final int mVersionCode;
    final ParcelFileDescriptor zzabN;
    final int zzagq;
    final int zzagr;
    final DriveId zzags;
    final boolean zzagt;
    final String zzrL;

    static {
        CREATOR = new zzb();
    }

    Contents(int versionCode, ParcelFileDescriptor parcelFileDescriptor, int requestId, int mode, DriveId driveId, boolean validForConflictDetection, String signature) {
        this.mVersionCode = versionCode;
        this.zzabN = parcelFileDescriptor;
        this.zzagq = requestId;
        this.zzagr = mode;
        this.zzags = driveId;
        this.zzagt = validForConflictDetection;
        this.zzrL = signature;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzags;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.zzabN.getFileDescriptor());
    }

    public int getMode() {
        return this.zzagr;
    }

    public OutputStream getOutputStream() {
        return new FileOutputStream(this.zzabN.getFileDescriptor());
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.zzabN;
    }

    public int getRequestId() {
        return this.zzagq;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public boolean zzqf() {
        return this.zzagt;
    }
}
