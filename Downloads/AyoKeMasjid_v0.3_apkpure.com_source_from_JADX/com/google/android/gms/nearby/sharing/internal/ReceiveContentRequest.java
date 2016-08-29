package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zza.zza;

public final class ReceiveContentRequest implements SafeParcelable {
    public static final Creator<ReceiveContentRequest> CREATOR;
    public String packageName;
    final int versionCode;
    public IBinder zzaKq;
    public zzc zzaKu;
    public zza zzaKv;

    static {
        CREATOR = new zzg();
    }

    ReceiveContentRequest() {
        this.versionCode = 1;
    }

    ReceiveContentRequest(int versionCode, IBinder clientBinder, IBinder contentReceiverAsBinder, String packageName, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzaKq = clientBinder;
        this.zzaKv = zza.zzdl(contentReceiverAsBinder);
        this.packageName = packageName;
        this.zzaKu = zzc.zza.zzdn(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    IBinder zzyp() {
        return this.zzaKu.asBinder();
    }

    IBinder zzyy() {
        return this.zzaKv == null ? null : this.zzaKv.asBinder();
    }
}
