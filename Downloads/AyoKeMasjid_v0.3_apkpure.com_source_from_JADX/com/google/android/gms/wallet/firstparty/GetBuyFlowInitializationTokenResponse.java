package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GetBuyFlowInitializationTokenResponse implements SafeParcelable {
    public static final Creator<GetBuyFlowInitializationTokenResponse> CREATOR;
    private final int mVersionCode;
    byte[] zzaXI;

    static {
        CREATOR = new zzc();
    }

    GetBuyFlowInitializationTokenResponse() {
        this(1, new byte[0]);
    }

    GetBuyFlowInitializationTokenResponse(int versionCode, byte[] buyFlowInitializationToken) {
        this.mVersionCode = versionCode;
        this.zzaXI = buyFlowInitializationToken;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
