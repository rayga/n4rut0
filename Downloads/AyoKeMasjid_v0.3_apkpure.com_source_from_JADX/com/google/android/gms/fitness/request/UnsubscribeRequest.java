package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznh.zza;

public class UnsubscribeRequest implements SafeParcelable {
    public static final Creator<UnsubscribeRequest> CREATOR;
    private final int mVersionCode;
    private final String zzOZ;
    private final DataType zzanl;
    private final DataSource zzanm;
    private final zznh zzapE;

    static {
        CREATOR = new zzae();
    }

    UnsubscribeRequest(int versionCode, DataType dataType, DataSource dataSource, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzanl = dataType;
        this.zzanm = dataSource;
        this.zzapE = callback == null ? null : zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public UnsubscribeRequest(DataType dataType, DataSource dataSource, zznh callback, String packageName) {
        this.mVersionCode = 2;
        this.zzanl = dataType;
        this.zzanm = dataSource;
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    private boolean zzb(UnsubscribeRequest unsubscribeRequest) {
        return zzw.equal(this.zzanm, unsubscribeRequest.zzanm) && zzw.equal(this.zzanl, unsubscribeRequest.zzanl);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof UnsubscribeRequest) && zzb((UnsubscribeRequest) o));
    }

    public DataSource getDataSource() {
        return this.zzanm;
    }

    public DataType getDataType() {
        return this.zzanl;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanm, this.zzanl);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzae.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        return this.zzapE == null ? null : this.zzapE.asBinder();
    }
}
