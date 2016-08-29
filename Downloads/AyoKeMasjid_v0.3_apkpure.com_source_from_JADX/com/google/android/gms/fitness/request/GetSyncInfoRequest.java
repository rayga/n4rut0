package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zzni.zza;

public class GetSyncInfoRequest implements SafeParcelable {
    public static final Creator<GetSyncInfoRequest> CREATOR;
    private final int mVersionCode;
    private final String zzOZ;
    private final zzni zzaqc;

    static {
        CREATOR = new zzm();
    }

    GetSyncInfoRequest(int versionCode, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzaqc = zza.zzbK(callback);
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
        return String.format("GetSyncInfoRequest {%d, %s, %s}", new Object[]{Integer.valueOf(this.mVersionCode), this.zzaqc, this.zzOZ});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzm.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        return this.zzaqc.asBinder();
    }
}
