package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpa;
import com.google.android.gms.internal.zzpa.zza;

public class StartScanRequest implements SafeParcelable {
    public static final zzg CREATOR;
    final int versionCode;
    private final zzoy zzaJe;
    private final zzpa zzaJh;

    static {
        CREATOR = new zzg();
    }

    StartScanRequest(int versionCode, IBinder scanListener, IBinder callback) {
        this.versionCode = versionCode;
        zzx.zzv(scanListener);
        this.zzaJh = zza.zzdd(scanListener);
        zzx.zzv(callback);
        this.zzaJe = zzoy.zza.zzdb(callback);
    }

    public int describeContents() {
        zzg com_google_android_gms_nearby_bootstrap_request_zzg = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg com_google_android_gms_nearby_bootstrap_request_zzg = CREATOR;
        zzg.zza(this, out, flags);
    }

    public IBinder zzsc() {
        return this.zzaJe == null ? null : this.zzaJe.asBinder();
    }

    public IBinder zzyj() {
        return this.zzaJh == null ? null : this.zzaJh.asBinder();
    }
}
