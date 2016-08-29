package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class MessageEventParcelable implements SafeParcelable, MessageEvent {
    public static final Creator<MessageEventParcelable> CREATOR;
    private final String mPath;
    final int mVersionCode;
    private final String zzaDI;
    private final int zzagq;
    private final byte[] zzayG;

    static {
        CREATOR = new zzaz();
    }

    MessageEventParcelable(int versionCode, int requestId, String path, byte[] data, String source) {
        this.mVersionCode = versionCode;
        this.zzagq = requestId;
        this.mPath = path;
        this.zzayG = data;
        this.zzaDI = source;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.zzayG;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getRequestId() {
        return this.zzagq;
    }

    public String getSourceNodeId() {
        return this.zzaDI;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.zzagq + "," + this.mPath + ", size=" + (this.zzayG == null ? "null" : Integer.valueOf(this.zzayG.length)) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaz.zza(this, dest, flags);
    }
}
