package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<ChangeEvent> CREATOR;
    final int mVersionCode;
    final DriveId zzags;
    final int zzahm;

    static {
        CREATOR = new zza();
    }

    ChangeEvent(int versionCode, DriveId driveId, int changeFlags) {
        this.mVersionCode = versionCode;
        this.zzags = driveId;
        this.zzahm = changeFlags;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzags;
    }

    public int getType() {
        return 1;
    }

    public boolean hasBeenDeleted() {
        return (this.zzahm & 4) != 0;
    }

    public boolean hasContentChanged() {
        return (this.zzahm & 2) != 0;
    }

    public boolean hasMetadataChanged() {
        return (this.zzahm & 1) != 0;
    }

    public String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.zzags, Integer.valueOf(this.zzahm)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
