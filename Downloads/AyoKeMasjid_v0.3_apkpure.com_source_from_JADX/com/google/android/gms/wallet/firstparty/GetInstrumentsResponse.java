package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GetInstrumentsResponse implements SafeParcelable {
    public static final Creator<GetInstrumentsResponse> CREATOR;
    private final int mVersionCode;
    String[] zzaXK;
    byte[][] zzaXL;

    static {
        CREATOR = new zze();
    }

    GetInstrumentsResponse() {
        this(1, new String[0], new byte[0][]);
    }

    GetInstrumentsResponse(int versionCode, String[] instrumentIds, byte[][] paymentInstruments) {
        this.mVersionCode = versionCode;
        this.zzaXK = instrumentIds;
        this.zzaXL = paymentInstruments;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }
}
