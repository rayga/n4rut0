package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextInsertedDetails implements SafeParcelable {
    public static final Creator<TextInsertedDetails> CREATOR;
    final int mIndex;
    final int mVersionCode;
    final int zzamD;

    static {
        CREATOR = new zzg();
    }

    TextInsertedDetails(int versionCode, int index, int stringDataIndex) {
        this.mVersionCode = versionCode;
        this.mIndex = index;
        this.zzamD = stringDataIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
