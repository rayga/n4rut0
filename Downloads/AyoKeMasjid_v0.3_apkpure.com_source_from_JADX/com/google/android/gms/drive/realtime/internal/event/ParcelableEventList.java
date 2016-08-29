package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
    public static final Creator<ParcelableEventList> CREATOR;
    final int mVersionCode;
    final DataHolder zzamv;
    final boolean zzamw;
    final List<String> zzamx;
    final ParcelableChangeInfo zzamy;
    final List<ParcelableEvent> zzoP;

    static {
        CREATOR = new zzd();
    }

    ParcelableEventList(int versionCode, List<ParcelableEvent> events, DataHolder eventData, boolean undoRedoStateChanged, List<String> affectedObjectIds, ParcelableChangeInfo previousChangeInfo) {
        this.mVersionCode = versionCode;
        this.zzoP = events;
        this.zzamv = eventData;
        this.zzamw = undoRedoStateChanged;
        this.zzamx = affectedObjectIds;
        this.zzamy = previousChangeInfo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
