package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzoy.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class SendDataRequest implements SafeParcelable {
    public static final zzf CREATOR;
    private final byte[] data;
    final int versionCode;
    private final Device zzaJb;
    private final zzoy zzaJe;

    static {
        CREATOR = new zzf();
    }

    SendDataRequest(int versionCode, Device device, byte[] data, IBinder callback) {
        this.versionCode = versionCode;
        this.zzaJb = (Device) zzx.zzv(device);
        this.data = (byte[]) zzx.zzv(data);
        zzx.zzv(callback);
        this.zzaJe = zza.zzdb(callback);
    }

    public int describeContents() {
        zzf com_google_android_gms_nearby_bootstrap_request_zzf = CREATOR;
        return 0;
    }

    public byte[] getData() {
        return this.data;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf com_google_android_gms_nearby_bootstrap_request_zzf = CREATOR;
        zzf.zza(this, out, flags);
    }

    public IBinder zzsc() {
        return this.zzaJe == null ? null : this.zzaJe.asBinder();
    }

    public Device zzye() {
        return this.zzaJb;
    }
}
