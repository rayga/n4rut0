package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzn.zza;
import com.google.android.gms.internal.zznh;

public class StopBleScanRequest implements SafeParcelable {
    public static final Creator<StopBleScanRequest> CREATOR;
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;
    private final zzn zzaqB;

    static {
        CREATOR = new zzab();
    }

    StopBleScanRequest(int versionCode, IBinder bleScanCallback, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzaqB = zza.zzbM(bleScanCallback);
        this.zzapE = callback == null ? null : zznh.zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public StopBleScanRequest(BleScanCallback bleScanCallback, zznh callback, String packageName) {
        this(zza.zza.zzsa().zzb(bleScanCallback), callback, packageName);
    }

    public StopBleScanRequest(zzn bleScanCallback, zznh callback, String packageName) {
        this.mVersionCode = 2;
        this.zzaqB = bleScanCallback;
        this.zzapE = callback;
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

    public void writeToParcel(Parcel parcel, int flags) {
        zzab.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        return this.zzapE == null ? null : this.zzapE.asBinder();
    }

    public IBinder zzsy() {
        return this.zzaqB.asBinder();
    }
}
