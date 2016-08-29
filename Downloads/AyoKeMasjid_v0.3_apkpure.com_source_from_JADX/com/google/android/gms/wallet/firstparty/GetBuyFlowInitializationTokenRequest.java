package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GetBuyFlowInitializationTokenRequest implements SafeParcelable {
    public static final Creator<GetBuyFlowInitializationTokenRequest> CREATOR;
    private final int mVersionCode;
    byte[] zzaXG;
    byte[] zzaXH;

    static {
        CREATOR = new zzb();
    }

    GetBuyFlowInitializationTokenRequest() {
        this(1, null, null);
    }

    GetBuyFlowInitializationTokenRequest(int versionCode, byte[] encryptedBuyFlowParameters, byte[] unencryptedBuyFlowParameters) {
        this.mVersionCode = versionCode;
        this.zzaXG = encryptedBuyFlowParameters;
        this.zzaXH = unencryptedBuyFlowParameters;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
