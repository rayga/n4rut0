package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest implements SafeParcelable {
    public static final Creator<BeginCompoundOperationRequest> CREATOR;
    final String mName;
    final int mVersionCode;
    final boolean zzalV;
    final boolean zzalW;

    static {
        CREATOR = new zza();
    }

    BeginCompoundOperationRequest(int versionCode, boolean isCreation, String name, boolean isUndoable) {
        this.mVersionCode = versionCode;
        this.zzalV = isCreation;
        this.mName = name;
        this.zzalW = isUndoable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
