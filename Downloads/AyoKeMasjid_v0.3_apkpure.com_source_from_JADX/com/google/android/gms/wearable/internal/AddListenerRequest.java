package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzav.zza;

public class AddListenerRequest implements SafeParcelable {
    public static final Creator<AddListenerRequest> CREATOR;
    final int mVersionCode;
    public final zzav zzaZq;
    public final IntentFilter[] zzaZr;
    public final String zzaZs;
    public final String zzaZt;

    static {
        CREATOR = new zzb();
    }

    AddListenerRequest(int versionCode, IBinder listener, IntentFilter[] filters, String channelToken, String capability) {
        this.mVersionCode = versionCode;
        if (listener != null) {
            this.zzaZq = zza.zzdZ(listener);
        } else {
            this.zzaZq = null;
        }
        this.zzaZr = filters;
        this.zzaZs = channelToken;
        this.zzaZt = capability;
    }

    public AddListenerRequest(zzbo stub) {
        this.mVersionCode = 1;
        this.zzaZq = stub;
        this.zzaZr = stub.zzCJ();
        this.zzaZs = stub.zzCK();
        this.zzaZt = stub.zzCL();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    IBinder zzCt() {
        return this.zzaZq == null ? null : this.zzaZq.asBinder();
    }
}
