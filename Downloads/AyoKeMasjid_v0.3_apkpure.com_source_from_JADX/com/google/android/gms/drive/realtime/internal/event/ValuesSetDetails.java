package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesSetDetails implements SafeParcelable {
    public static final Creator<ValuesSetDetails> CREATOR;
    final int mIndex;
    final int mVersionCode;
    final int zzamf;
    final int zzamg;

    static {
        CREATOR = new zzk();
    }

    ValuesSetDetails(int versionCode, int index, int valueIndex, int valueCount) {
        this.mVersionCode = versionCode;
        this.mIndex = index;
        this.zzamf = valueIndex;
        this.zzamg = valueCount;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
