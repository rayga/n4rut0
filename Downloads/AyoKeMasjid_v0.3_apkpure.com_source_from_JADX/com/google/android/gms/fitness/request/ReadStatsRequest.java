package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zzne.zza;

public class ReadStatsRequest implements SafeParcelable {
    public static final Creator<ReadStatsRequest> CREATOR;
    private final int mVersionCode;
    private final String zzOZ;
    private final zzne zzaqh;

    static {
        CREATOR = new zzr();
    }

    ReadStatsRequest(int versionCode, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzaqh = zza.zzbG(callback);
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
        return String.format("ReadStatsRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzr.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        return this.zzaqh.asBinder();
    }
}
