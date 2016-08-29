package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR;
    private final int mVersionCode;
    private final String zzasH;
    private final int zzasI;

    static {
        CREATOR = new ConnectionInfoCreator();
    }

    public ConnectionInfo(int versionCode, String clientAddress, int registrationLatency) {
        this.mVersionCode = versionCode;
        this.zzasH = clientAddress;
        this.zzasI = registrationLatency;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        ConnectionInfoCreator.zza(this, out, flags);
    }

    public String zztD() {
        return this.zzasH;
    }

    public int zztE() {
        return this.zzasI;
    }
}
