package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails implements SafeParcelable {
    public static final Creator<ValuesAddedDetails> CREATOR;
    final int mIndex;
    final int mVersionCode;
    final String zzamE;
    final int zzamF;
    final int zzamf;
    final int zzamg;

    static {
        CREATOR = new zzi();
    }

    ValuesAddedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedFromId, int movedFromIndex) {
        this.mVersionCode = versionCode;
        this.mIndex = index;
        this.zzamf = valueIndex;
        this.zzamg = valueCount;
        this.zzamE = movedFromId;
        this.zzamF = movedFromIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
