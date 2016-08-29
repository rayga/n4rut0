package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznh.zza;

public class DataInsertRequest implements SafeParcelable {
    public static final Creator<DataInsertRequest> CREATOR;
    private final int mVersionCode;
    private final String zzOZ;
    private final DataSet zzaoD;
    private final zznh zzapE;
    private final boolean zzapK;

    static {
        CREATOR = new zze();
    }

    DataInsertRequest(int versionCode, DataSet dataSet, IBinder callback, String packageName, boolean skipSync) {
        this.mVersionCode = versionCode;
        this.zzaoD = dataSet;
        this.zzapE = callback == null ? null : zza.zzbJ(callback);
        this.zzOZ = packageName;
        this.zzapK = skipSync;
    }

    public DataInsertRequest(DataSet dataSet, zznh callback, String packageName, boolean skipSync) {
        this.mVersionCode = 3;
        this.zzaoD = dataSet;
        this.zzapE = callback;
        this.zzOZ = packageName;
        this.zzapK = skipSync;
    }

    private boolean zzc(DataInsertRequest dataInsertRequest) {
        return zzw.equal(this.zzaoD, dataInsertRequest.zzaoD);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataInsertRequest) && zzc((DataInsertRequest) o));
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaoD);
    }

    public String toString() {
        return zzw.zzu(this).zzg("dataSet", this.zzaoD).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }

    public DataSet zzrO() {
        return this.zzaoD;
    }

    public IBinder zzsc() {
        return this.zzapE == null ? null : this.zzapE.asBinder();
    }

    public boolean zzsg() {
        return this.zzapK;
    }
}
