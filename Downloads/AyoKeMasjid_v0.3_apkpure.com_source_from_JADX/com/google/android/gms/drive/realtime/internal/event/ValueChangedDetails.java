package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValueChangedDetails implements SafeParcelable {
    public static final Creator<ValueChangedDetails> CREATOR;
    final int mVersionCode;
    final int zzame;

    static {
        CREATOR = new zzh();
    }

    ValueChangedDetails(int versionCode, int keyIndex) {
        this.mVersionCode = versionCode;
        this.zzame = keyIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
