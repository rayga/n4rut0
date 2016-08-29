package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator implements SafeParcelable {
    public static final Creator<Operator> CREATOR;
    public static final Operator zzalM;
    public static final Operator zzalN;
    public static final Operator zzalO;
    public static final Operator zzalP;
    public static final Operator zzalQ;
    public static final Operator zzalR;
    public static final Operator zzalS;
    public static final Operator zzalT;
    public static final Operator zzalU;
    final String mTag;
    final int mVersionCode;

    static {
        CREATOR = new zzn();
        zzalM = new Operator("=");
        zzalN = new Operator("<");
        zzalO = new Operator("<=");
        zzalP = new Operator(">");
        zzalQ = new Operator(">=");
        zzalR = new Operator("and");
        zzalS = new Operator("or");
        zzalT = new Operator("not");
        zzalU = new Operator("contains");
    }

    Operator(int versionCode, String tag) {
        this.mVersionCode = versionCode;
        this.mTag = tag;
    }

    private Operator(String tag) {
        this(1, tag);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Operator operator = (Operator) obj;
        return this.mTag == null ? operator.mTag == null : this.mTag.equals(operator.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzn.zza(this, out, flags);
    }
}
