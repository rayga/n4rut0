package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzoy.zza;

public class DisableTargetRequest implements SafeParcelable {
    public static final zzc CREATOR;
    final int versionCode;
    private final zzoy zzaJe;

    static {
        CREATOR = new zzc();
    }

    DisableTargetRequest(int versionCode, IBinder callback) {
        this.versionCode = versionCode;
        zzx.zzv(callback);
        this.zzaJe = zza.zzdb(callback);
    }

    public int describeContents() {
        zzc com_google_android_gms_nearby_bootstrap_request_zzc = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc com_google_android_gms_nearby_bootstrap_request_zzc = CREATOR;
        zzc.zza(this, out, flags);
    }

    public IBinder zzsc() {
        return this.zzaJe == null ? null : this.zzaJe.asBinder();
    }
}
