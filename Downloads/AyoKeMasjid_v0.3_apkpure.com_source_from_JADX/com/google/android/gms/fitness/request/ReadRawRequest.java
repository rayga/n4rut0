package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznd.zza;
import java.util.List;

public class ReadRawRequest implements SafeParcelable {
    public static final Creator<ReadRawRequest> CREATOR;
    private final int mVersionCode;
    private final String zzOZ;
    private final boolean zzapQ;
    private final boolean zzapR;
    private final zznd zzaqf;
    private final List<DataSourceQueryParams> zzaqg;

    static {
        CREATOR = new zzq();
    }

    ReadRawRequest(int versionCode, IBinder callback, String packageName, List<DataSourceQueryParams> queryParams, boolean flushBufferBeforeRead, boolean serverQueriesEnabled) {
        this.mVersionCode = versionCode;
        this.zzaqf = zza.zzbF(callback);
        this.zzaqg = queryParams;
        this.zzOZ = packageName;
        this.zzapQ = flushBufferBeforeRead;
        this.zzapR = serverQueriesEnabled;
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
        zzq.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        return this.zzaqf != null ? this.zzaqf.asBinder() : null;
    }

    public boolean zzsh() {
        return this.zzapR;
    }

    public boolean zzsi() {
        return this.zzapQ;
    }

    public List<DataSourceQueryParams> zzsn() {
        return this.zzaqg;
    }
}
