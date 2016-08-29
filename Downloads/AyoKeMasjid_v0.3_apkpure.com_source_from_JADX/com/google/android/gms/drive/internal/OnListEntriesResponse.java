package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

public class OnListEntriesResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Creator<OnListEntriesResponse> CREATOR;
    final int mVersionCode;
    final boolean zzaio;
    final DataHolder zzajT;

    static {
        CREATOR = new zzbc();
    }

    OnListEntriesResponse(int versionCode, DataHolder entries, boolean moreEntriesMayExist) {
        this.mVersionCode = versionCode;
        this.zzajT = entries;
        this.zzaio = moreEntriesMayExist;
    }

    public int describeContents() {
        return 0;
    }

    protected void zzI(Parcel parcel, int i) {
        zzbc.zza(this, parcel, i);
    }

    public DataHolder zzqT() {
        return this.zzajT;
    }

    public boolean zzqU() {
        return this.zzaio;
    }
}
