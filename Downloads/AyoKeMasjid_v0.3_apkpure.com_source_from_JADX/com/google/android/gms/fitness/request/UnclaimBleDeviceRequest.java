package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznh.zza;

public class UnclaimBleDeviceRequest implements SafeParcelable {
    public static final Creator<UnclaimBleDeviceRequest> CREATOR;
    private final int mVersionCode;
    private final String zzOZ;
    private final String zzapC;
    private final zznh zzapE;

    static {
        CREATOR = new zzad();
    }

    UnclaimBleDeviceRequest(int versionCode, String deviceAddress, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzapC = deviceAddress;
        this.zzapE = callback == null ? null : zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public UnclaimBleDeviceRequest(String deviceAddress, zznh callback, String packageName) {
        this.mVersionCode = 4;
        this.zzapC = deviceAddress;
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceAddress() {
        return this.zzapC;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[]{this.zzapC});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzad.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        return this.zzapE == null ? null : this.zzapE.asBinder();
    }
}
