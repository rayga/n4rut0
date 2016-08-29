package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GetInstrumentsRequest implements SafeParcelable {
    public static final Creator<GetInstrumentsRequest> CREATOR;
    private final int mVersionCode;
    int[] zzaXJ;

    static {
        CREATOR = new zzd();
    }

    GetInstrumentsRequest() {
        this(1, null);
    }

    GetInstrumentsRequest(int versionCode, int[] familyFilter) {
        this.mVersionCode = versionCode;
        this.zzaXJ = familyFilter;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
