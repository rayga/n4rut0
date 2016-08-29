package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznv.zza;

public class ListClaimedBleDevicesRequest implements SafeParcelable {
    public static final Creator<ListClaimedBleDevicesRequest> CREATOR;
    private final int mVersionCode;
    private final String zzOZ;
    private final zznv zzaqd;

    static {
        CREATOR = new zzo();
    }

    ListClaimedBleDevicesRequest(int versionCode, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzaqd = zza.zzbL(callback);
        this.zzOZ = packageName;
    }

    public ListClaimedBleDevicesRequest(zznv callback, String packageName) {
        this.mVersionCode = 1;
        this.zzaqd = callback;
        this.zzOZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("ListClaimedBleDevicesRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzo.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        return this.zzaqd.asBinder();
    }
}
