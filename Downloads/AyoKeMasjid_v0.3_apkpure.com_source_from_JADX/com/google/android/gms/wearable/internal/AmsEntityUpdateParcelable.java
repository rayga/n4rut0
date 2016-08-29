package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzb;

public class AmsEntityUpdateParcelable implements SafeParcelable, zzb {
    public static final Creator<AmsEntityUpdateParcelable> CREATOR;
    private final String mValue;
    final int mVersionCode;
    private byte zzaZu;
    private final byte zzaZv;

    static {
        CREATOR = new zze();
    }

    AmsEntityUpdateParcelable(int versionCode, byte entityId, byte attributeId, String value) {
        this.zzaZu = entityId;
        this.mVersionCode = versionCode;
        this.zzaZv = attributeId;
        this.mValue = value;
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
        AmsEntityUpdateParcelable amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) o;
        if (this.zzaZu != amsEntityUpdateParcelable.zzaZu) {
            return false;
        }
        if (this.mVersionCode != amsEntityUpdateParcelable.mVersionCode) {
            return false;
        }
        if (this.zzaZv != amsEntityUpdateParcelable.zzaZv) {
            return false;
        }
        return this.mValue.equals(amsEntityUpdateParcelable.mValue);
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return (((((this.mVersionCode * 31) + this.zzaZu) * 31) + this.zzaZv) * 31) + this.mValue.hashCode();
    }

    public String toString() {
        return "AmsEntityUpdateParcelable{mVersionCode=" + this.mVersionCode + ", mEntityId=" + this.zzaZu + ", mAttributeId=" + this.zzaZv + ", mValue='" + this.mValue + '\'' + '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }

    public byte zzCu() {
        return this.zzaZu;
    }

    public byte zzCv() {
        return this.zzaZv;
    }
}
