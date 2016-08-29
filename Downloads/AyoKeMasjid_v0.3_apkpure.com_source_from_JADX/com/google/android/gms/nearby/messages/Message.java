package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import org.bpmikc.akm.BuildConfig;

public class Message implements SafeParcelable {
    public static final Creator<Message> CREATOR;
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    private final byte[] content;
    private final String type;
    final int versionCode;
    private final String zzaeI;

    static {
        CREATOR = new zza();
    }

    Message(int versionCode, byte[] content, String namespace, String type) {
        this.versionCode = versionCode;
        this.content = (byte[]) zzx.zzv(content);
        this.type = (String) zzx.zzv(type);
        if (namespace == null) {
            namespace = BuildConfig.FLAVOR;
        }
        this.zzaeI = namespace;
        zzx.zzb(content.length <= MAX_CONTENT_SIZE_BYTES, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(content.length), Integer.valueOf(MAX_CONTENT_SIZE_BYTES));
        zzx.zzb(type.length() <= MAX_TYPE_LENGTH, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(type.length()), Integer.valueOf(MAX_TYPE_LENGTH));
    }

    public Message(byte[] content) {
        this(content, BuildConfig.FLAVOR, BuildConfig.FLAVOR);
    }

    public Message(byte[] content, String type) {
        this(1, content, BuildConfig.FLAVOR, type);
    }

    Message(byte[] content, String namespace, String type) {
        this(1, content, namespace, type);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Message)) {
            return false;
        }
        Message message = (Message) object;
        return TextUtils.equals(this.zzaeI, message.zzaeI) && TextUtils.equals(this.type, message.type) && Arrays.equals(this.content, message.content);
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getNamespace() {
        return this.zzaeI;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaeI, this.type, Integer.valueOf(Arrays.hashCode(this.content)));
    }

    public String toString() {
        return "Message{namespace='" + this.zzaeI + "'" + ", type='" + this.type + "'" + ", content=[" + this.content.length + " bytes]" + "}";
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
