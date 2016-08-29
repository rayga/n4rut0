package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveId;

public final class ProgressEvent implements DriveEvent {
    public static final Creator<ProgressEvent> CREATOR;
    final int mVersionCode;
    final int zzUS;
    final DriveId zzags;
    final long zzahF;
    final long zzahG;
    final int zzxJ;

    static {
        CREATOR = new zzh();
    }

    ProgressEvent(int versionCode, DriveId driveId, int status, long bytesTransferred, long totalBytes, int type) {
        this.mVersionCode = versionCode;
        this.zzags = driveId;
        this.zzxJ = status;
        this.zzahF = bytesTransferred;
        this.zzahG = totalBytes;
        this.zzUS = type;
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
        ProgressEvent progressEvent = (ProgressEvent) o;
        return zzw.equal(this.zzags, progressEvent.zzags) && this.zzxJ == progressEvent.zzxJ && this.zzahF == progressEvent.zzahF && this.zzahG == progressEvent.zzahG;
    }

    public int getType() {
        return this.zzUS;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzags, Integer.valueOf(this.zzxJ), Long.valueOf(this.zzahF), Long.valueOf(this.zzahG));
    }

    public String toString() {
        return String.format("ProgressEvent[DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", new Object[]{this.zzags, Integer.valueOf(this.zzxJ), Long.valueOf(this.zzahF), Long.valueOf(this.zzahG)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
