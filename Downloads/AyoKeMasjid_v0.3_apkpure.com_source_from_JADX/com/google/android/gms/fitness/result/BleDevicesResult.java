package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BleDevicesResult implements Result, SafeParcelable {
    public static final Creator<BleDevicesResult> CREATOR;
    private final int mVersionCode;
    private final Status zzQA;
    private final List<BleDevice> zzaqF;

    static {
        CREATOR = new zza();
    }

    BleDevicesResult(int versionCode, List<BleDevice> bleDevices, Status status) {
        this.mVersionCode = versionCode;
        this.zzaqF = Collections.unmodifiableList(bleDevices);
        this.zzQA = status;
    }

    public BleDevicesResult(List<BleDevice> bleDevices, Status status) {
        this.mVersionCode = 3;
        this.zzaqF = Collections.unmodifiableList(bleDevices);
        this.zzQA = status;
    }

    public static BleDevicesResult zzP(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    private boolean zzb(BleDevicesResult bleDevicesResult) {
        return this.zzQA.equals(bleDevicesResult.zzQA) && zzw.equal(this.zzaqF, bleDevicesResult.zzaqF);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof BleDevicesResult) && zzb((BleDevicesResult) that));
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.zzaqF;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        List arrayList = new ArrayList();
        for (BleDevice bleDevice : this.zzaqF) {
            if (bleDevice.getDataTypes().contains(dataType)) {
                arrayList.add(bleDevice);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzQA;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzQA, this.zzaqF);
    }

    public String toString() {
        return zzw.zzu(this).zzg(Games.EXTRA_STATUS, this.zzQA).zzg("bleDevices", this.zzaqF).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
