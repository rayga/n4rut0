package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class MessageType implements SafeParcelable {
    public static final Creator<MessageType> CREATOR;
    public final String type;
    final int versionCode;
    public final String zzaeI;

    static {
        CREATOR = new zze();
    }

    MessageType(int versionCode, String namespace, String type) {
        this.versionCode = versionCode;
        this.zzaeI = namespace;
        this.type = type;
    }

    public MessageType(String namespace, String type) {
        this(1, namespace, type);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageType)) {
            return false;
        }
        MessageType messageType = (MessageType) o;
        return zzw.equal(this.zzaeI, messageType.zzaeI) && zzw.equal(this.type, messageType.type);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaeI, this.type);
    }

    public String toString() {
        return "namespace=" + this.zzaeI + ", type=" + this.type;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
