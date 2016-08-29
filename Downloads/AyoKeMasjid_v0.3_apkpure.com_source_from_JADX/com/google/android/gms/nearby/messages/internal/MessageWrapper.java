package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;

public class MessageWrapper implements SafeParcelable {
    public static final zzf CREATOR;
    final int versionCode;
    public final Message zzaJS;

    static {
        CREATOR = new zzf();
    }

    MessageWrapper(int versionCode, Message message) {
        this.versionCode = versionCode;
        this.zzaJS = (Message) zzx.zzv(message);
    }

    public static final MessageWrapper zza(Message message) {
        return new MessageWrapper(1, message);
    }

    public int describeContents() {
        zzf com_google_android_gms_nearby_messages_internal_zzf = CREATOR;
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageWrapper)) {
            return false;
        }
        return zzw.equal(this.zzaJS, ((MessageWrapper) o).zzaJS);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaJS);
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf com_google_android_gms_nearby_messages_internal_zzf = CREATOR;
        zzf.zza(this, out, flags);
    }
}
