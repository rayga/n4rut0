package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class LoadRealtimeRequest implements SafeParcelable {
    public static final Creator<LoadRealtimeRequest> CREATOR;
    final int mVersionCode;
    final DriveId zzags;
    final boolean zzajt;
    final List<String> zzaju;
    final boolean zzajv;
    final DataHolder zzajw;
    final String zzajx;

    static {
        CREATOR = new zzaq();
    }

    LoadRealtimeRequest(int versionCode, DriveId driveId, boolean useTestMode, List<String> customTypeWhitelist, boolean isInMemory, DataHolder json, String localId) {
        this.mVersionCode = versionCode;
        this.zzags = driveId;
        this.zzajt = useTestMode;
        this.zzaju = customTypeWhitelist;
        this.zzajv = isInMemory;
        this.zzajw = json;
        this.zzajx = localId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaq.zza(this, dest, flags);
    }
}
