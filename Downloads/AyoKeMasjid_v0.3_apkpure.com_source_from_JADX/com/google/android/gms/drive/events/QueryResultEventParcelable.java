package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;

public class QueryResultEventParcelable extends WriteAwareParcelable implements DriveEvent {
    public static final zzk CREATOR;
    final int mVersionCode;
    final DataHolder zzYX;
    final boolean zzahH;
    final int zzahI;

    static {
        CREATOR = new zzk();
    }

    QueryResultEventParcelable(int versionCode, DataHolder dataHolder, boolean isStatusChanged, int queryStatus) {
        this.mVersionCode = versionCode;
        this.zzYX = dataHolder;
        this.zzahH = isStatusChanged;
        this.zzahI = queryStatus;
    }

    public int describeContents() {
        return 0;
    }

    public int getType() {
        return 3;
    }

    public void zzI(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public DataHolder zzqA() {
        return this.zzYX;
    }

    public boolean zzqB() {
        return this.zzahH;
    }

    public int zzqC() {
        return this.zzahI;
    }
}
