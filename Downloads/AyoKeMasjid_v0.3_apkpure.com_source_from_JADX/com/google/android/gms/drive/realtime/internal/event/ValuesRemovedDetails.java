package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails implements SafeParcelable {
    public static final Creator<ValuesRemovedDetails> CREATOR;
    final int mIndex;
    final int mVersionCode;
    final String zzamG;
    final int zzamH;
    final int zzamf;
    final int zzamg;

    static {
        CREATOR = new zzj();
    }

    ValuesRemovedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedToId, int movedToIndex) {
        this.mVersionCode = versionCode;
        this.mIndex = index;
        this.zzamf = valueIndex;
        this.zzamg = valueCount;
        this.zzamG = movedToId;
        this.zzamH = movedToIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
