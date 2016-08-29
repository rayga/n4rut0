package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzoy;

public class EnableTargetRequest implements SafeParcelable {
    public static final zze CREATOR;
    private final String description;
    private final String name;
    final int versionCode;
    private final byte zzaJa;
    private final zzow zzaJc;
    private final zzox zzaJd;
    private final zzoy zzaJe;

    static {
        CREATOR = new zze();
    }

    EnableTargetRequest(int versionCode, String name, String description, byte deviceType, IBinder connectionListener, IBinder dataListener, IBinder callback) {
        this.versionCode = versionCode;
        this.name = zzx.zzcs(name);
        this.description = (String) zzx.zzv(description);
        this.zzaJa = deviceType;
        zzx.zzv(connectionListener);
        this.zzaJc = zza.zzcZ(connectionListener);
        zzx.zzv(dataListener);
        this.zzaJd = zzox.zza.zzda(dataListener);
        zzx.zzv(callback);
        this.zzaJe = zzoy.zza.zzdb(callback);
    }

    public int describeContents() {
        zze com_google_android_gms_nearby_bootstrap_request_zze = CREATOR;
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze com_google_android_gms_nearby_bootstrap_request_zze = CREATOR;
        zze.zza(this, out, flags);
    }

    public IBinder zzsc() {
        return this.zzaJe == null ? null : this.zzaJe.asBinder();
    }

    public byte zzyc() {
        return this.zzaJa;
    }

    public IBinder zzyh() {
        return this.zzaJc == null ? null : this.zzaJc.asBinder();
    }

    public IBinder zzyi() {
        return this.zzaJd == null ? null : this.zzaJd.asBinder();
    }
}
