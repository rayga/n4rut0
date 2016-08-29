package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class ConnectionConfiguration implements SafeParcelable {
    public static final Creator<ConnectionConfiguration> CREATOR;
    private final String mName;
    final int mVersionCode;
    private boolean zzOq;
    private final int zzUS;
    private final boolean zzaYO;
    private String zzaYP;
    private boolean zzaYQ;
    private String zzaYR;
    private final int zzahc;
    private final String zzanu;

    static {
        CREATOR = new zzg();
    }

    ConnectionConfiguration(int versionCode, String name, String address, int type, int role, boolean connectionEnabled, boolean isConnected, String peerNodeId, boolean btlePriority, String nodeId) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzanu = address;
        this.zzUS = type;
        this.zzahc = role;
        this.zzaYO = connectionEnabled;
        this.zzOq = isConnected;
        this.zzaYP = peerNodeId;
        this.zzaYQ = btlePriority;
        this.zzaYR = nodeId;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) o;
        return zzw.equal(Integer.valueOf(this.mVersionCode), Integer.valueOf(connectionConfiguration.mVersionCode)) && zzw.equal(this.mName, connectionConfiguration.mName) && zzw.equal(this.zzanu, connectionConfiguration.zzanu) && zzw.equal(Integer.valueOf(this.zzUS), Integer.valueOf(connectionConfiguration.zzUS)) && zzw.equal(Integer.valueOf(this.zzahc), Integer.valueOf(connectionConfiguration.zzahc)) && zzw.equal(Boolean.valueOf(this.zzaYO), Boolean.valueOf(connectionConfiguration.zzaYO)) && zzw.equal(Boolean.valueOf(this.zzaYQ), Boolean.valueOf(connectionConfiguration.zzaYQ));
    }

    public String getAddress() {
        return this.zzanu;
    }

    public String getName() {
        return this.mName;
    }

    public String getNodeId() {
        return this.zzaYR;
    }

    public int getRole() {
        return this.zzahc;
    }

    public int getType() {
        return this.zzUS;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.mName, this.zzanu, Integer.valueOf(this.zzUS), Integer.valueOf(this.zzahc), Boolean.valueOf(this.zzaYO), Boolean.valueOf(this.zzaYQ));
    }

    public boolean isConnected() {
        return this.zzOq;
    }

    public boolean isEnabled() {
        return this.zzaYO;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        stringBuilder.append("mName=" + this.mName);
        stringBuilder.append(", mAddress=" + this.zzanu);
        stringBuilder.append(", mType=" + this.zzUS);
        stringBuilder.append(", mRole=" + this.zzahc);
        stringBuilder.append(", mEnabled=" + this.zzaYO);
        stringBuilder.append(", mIsConnected=" + this.zzOq);
        stringBuilder.append(", mPeerNodeId=" + this.zzaYP);
        stringBuilder.append(", mBtlePriority=" + this.zzaYQ);
        stringBuilder.append(", mNodeId=" + this.zzaYR);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    public String zzCp() {
        return this.zzaYP;
    }

    public boolean zzCq() {
        return this.zzaYQ;
    }
}
