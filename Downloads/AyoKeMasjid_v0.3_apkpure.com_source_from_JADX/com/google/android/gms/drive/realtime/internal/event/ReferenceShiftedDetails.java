package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Creator<ReferenceShiftedDetails> CREATOR;
    final int mVersionCode;
    final String zzamA;
    final int zzamB;
    final int zzamC;
    final String zzamz;

    static {
        CREATOR = new zze();
    }

    ReferenceShiftedDetails(int versionCode, String oldObjectId, String newObjectId, int oldIndex, int newIndex) {
        this.mVersionCode = versionCode;
        this.zzamz = oldObjectId;
        this.zzamA = newObjectId;
        this.zzamB = oldIndex;
        this.zzamC = newIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
