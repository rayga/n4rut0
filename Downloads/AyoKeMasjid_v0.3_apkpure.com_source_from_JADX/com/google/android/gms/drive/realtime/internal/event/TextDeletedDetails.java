package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextDeletedDetails implements SafeParcelable {
    public static final Creator<TextDeletedDetails> CREATOR;
    final int mIndex;
    final int mVersionCode;
    final int zzamD;

    static {
        CREATOR = new zzf();
    }

    TextDeletedDetails(int versionCode, int index, int stringDataIndex) {
        this.mVersionCode = versionCode;
        this.mIndex = index;
        this.zzamD = stringDataIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }
}
