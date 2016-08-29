package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zzc.zza;

public final class StopProvidingContentRequest implements SafeParcelable {
    public static final Creator<StopProvidingContentRequest> CREATOR;
    final int versionCode;
    public long zzaKt;
    public zzc zzaKu;

    static {
        CREATOR = new zzj();
    }

    StopProvidingContentRequest() {
        this.versionCode = 1;
    }

    StopProvidingContentRequest(int versionCode, long activityId, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzaKt = activityId;
        this.zzaKu = zza.zzdn(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    IBinder zzyp() {
        return this.zzaKu.asBinder();
    }
}
