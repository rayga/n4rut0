package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class NodeParcelable implements SafeParcelable, Node {
    public static final Creator<NodeParcelable> CREATOR;
    final int mVersionCode;
    private final String zzahh;
    private final int zzbaO;
    private final boolean zzbaP;
    private final String zzwj;

    static {
        CREATOR = new zzbb();
    }

    NodeParcelable(int versionCode, String id, String displayName, int hopCount, boolean isNearby) {
        this.mVersionCode = versionCode;
        this.zzwj = id;
        this.zzahh = displayName;
        this.zzbaO = hopCount;
        this.zzbaP = isNearby;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return !(o instanceof NodeParcelable) ? false : ((NodeParcelable) o).zzwj.equals(this.zzwj);
    }

    public String getDisplayName() {
        return this.zzahh;
    }

    public int getHopCount() {
        return this.zzbaO;
    }

    public String getId() {
        return this.zzwj;
    }

    public int hashCode() {
        return this.zzwj.hashCode();
    }

    public boolean isNearby() {
        return this.zzbaP;
    }

    public String toString() {
        return "Node{" + this.zzahh + ", id=" + this.zzwj + ", hops=" + this.zzbaO + ", isNearby=" + this.zzbaP + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbb.zza(this, dest, flags);
    }
}
