package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable implements SafeParcelable, CapabilityInfo {
    public static final Creator<CapabilityInfoParcelable> CREATOR;
    private final String mName;
    final int mVersionCode;
    private Set<Node> zzaZG;
    private final List<NodeParcelable> zzaZJ;
    private final Object zzpc;

    static {
        CREATOR = new zzj();
    }

    CapabilityInfoParcelable(int versionCode, String name, List<NodeParcelable> nodeList) {
        this.zzpc = new Object();
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzaZJ = nodeList;
        this.zzaZG = null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CapabilityInfoParcelable capabilityInfoParcelable = (CapabilityInfoParcelable) o;
        if (this.mVersionCode != capabilityInfoParcelable.mVersionCode) {
            return false;
        }
        if (this.mName == null ? capabilityInfoParcelable.mName != null : !this.mName.equals(capabilityInfoParcelable.mName)) {
            return false;
        }
        if (this.zzaZJ != null) {
            if (this.zzaZJ.equals(capabilityInfoParcelable.zzaZJ)) {
                return true;
            }
        } else if (capabilityInfoParcelable.zzaZJ == null) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.mName;
    }

    public Set<Node> getNodes() {
        Set<Node> set;
        synchronized (this.zzpc) {
            if (this.zzaZG == null) {
                this.zzaZG = new HashSet(this.zzaZJ);
            }
            set = this.zzaZG;
        }
        return set;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.mName != null ? this.mName.hashCode() : 0) + (this.mVersionCode * 31)) * 31;
        if (this.zzaZJ != null) {
            i = this.zzaZJ.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CapabilityInfo{" + this.mName + ", " + this.zzaZJ + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    public List<NodeParcelable> zzCC() {
        return this.zzaZJ;
    }
}
