package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzoy.zza;

public class StopScanRequest implements SafeParcelable {
    public static final zzh CREATOR;
    final int versionCode;
    private final zzoy zzaJe;

    static {
        CREATOR = new zzh();
    }

    StopScanRequest(int versionCode, IBinder callback) {
        this.versionCode = versionCode;
        zzx.zzv(callback);
        this.zzaJe = zza.zzdb(callback);
    }

    public int describeContents() {
        zzh com_google_android_gms_nearby_bootstrap_request_zzh = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh com_google_android_gms_nearby_bootstrap_request_zzh = CREATOR;
        zzh.zza(this, out, flags);
    }

    public IBinder zzsc() {
        return this.zzaJe == null ? null : this.zzaJe.asBinder();
    }
}
