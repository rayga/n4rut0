package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public final class ChangesAvailableEvent implements SafeParcelable, DriveEvent {
    public static final Creator<ChangesAvailableEvent> CREATOR;
    final int mVersionCode;
    final String zzQE;
    final ChangesAvailableOptions zzahn;

    static {
        CREATOR = new zzb();
    }

    ChangesAvailableEvent(int versionCode, String accountName, ChangesAvailableOptions changesAvailableOptions) {
        this.mVersionCode = versionCode;
        this.zzQE = accountName;
        this.zzahn = changesAvailableOptions;
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
        ChangesAvailableEvent changesAvailableEvent = (ChangesAvailableEvent) o;
        return zzw.equal(this.zzahn, changesAvailableEvent.zzahn) && zzw.equal(this.zzQE, changesAvailableEvent.zzQE);
    }

    public int getType() {
        return 4;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzahn, this.zzQE);
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", new Object[]{this.zzahn});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
