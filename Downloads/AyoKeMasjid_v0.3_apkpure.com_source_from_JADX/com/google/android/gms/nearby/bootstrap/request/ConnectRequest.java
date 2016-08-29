package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.nearby.bootstrap.Device;

public class ConnectRequest implements SafeParcelable {
    public static final zza CREATOR;
    private final String description;
    private final String name;
    private final long timeoutMillis;
    final int versionCode;
    private final byte zzaJa;
    private final Device zzaJb;
    private final zzow zzaJc;
    private final zzox zzaJd;
    private final zzoy zzaJe;
    private final String zzaJf;
    private final byte zzaJg;

    static {
        CREATOR = new zza();
    }

    ConnectRequest(int versionCode, Device device, String name, String description, byte deviceType, long timeoutMillis, String token, byte connectType, IBinder connectionListener, IBinder dataListener, IBinder callback) {
        this.versionCode = versionCode;
        this.zzaJb = (Device) zzx.zzv(device);
        this.name = zzx.zzcs(name);
        this.description = (String) zzx.zzv(description);
        this.zzaJa = deviceType;
        this.timeoutMillis = timeoutMillis;
        this.zzaJg = connectType;
        this.zzaJf = token;
        zzx.zzv(connectionListener);
        this.zzaJc = zza.zzcZ(connectionListener);
        zzx.zzv(dataListener);
        this.zzaJd = zzox.zza.zzda(dataListener);
        zzx.zzv(callback);
        this.zzaJe = zzoy.zza.zzdb(callback);
    }

    public int describeContents() {
        zza com_google_android_gms_nearby_bootstrap_request_zza = CREATOR;
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getToken() {
        return this.zzaJf;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_nearby_bootstrap_request_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    public IBinder zzsc() {
        return this.zzaJe == null ? null : this.zzaJe.asBinder();
    }

    public byte zzyc() {
        return this.zzaJa;
    }

    public Device zzye() {
        return this.zzaJb;
    }

    public long zzyf() {
        return this.timeoutMillis;
    }

    public byte zzyg() {
        return this.zzaJg;
    }

    public IBinder zzyh() {
        return this.zzaJc == null ? null : this.zzaJc.asBinder();
    }

    public IBinder zzyi() {
        return this.zzaJd == null ? null : this.zzaJd.asBinder();
    }
}
