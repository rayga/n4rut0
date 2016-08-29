package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public final class ChannelEventParcelable implements SafeParcelable {
    public static final Creator<ChannelEventParcelable> CREATOR;
    final int mVersionCode;
    final int type;
    final int zzaZP;
    final int zzaZQ;
    final ChannelImpl zzaZR;

    static {
        CREATOR = new zzm();
    }

    ChannelEventParcelable(int versionCode, ChannelImpl channel, int type, int closeReason, int appErrorCode) {
        this.mVersionCode = versionCode;
        this.zzaZR = channel;
        this.type = type;
        this.zzaZP = closeReason;
        this.zzaZQ = appErrorCode;
    }

    private static String zzkB(int i) {
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return "CHANNEL_OPENED";
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return "CHANNEL_CLOSED";
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return "INPUT_CLOSED";
            case Barcode.PHONE /*4*/:
                return "OUTPUT_CLOSED";
            default:
                return Integer.toString(i);
        }
    }

    private static String zzkC(int i) {
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return "CLOSE_REASON_NORMAL";
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return "CLOSE_REASON_DISCONNECTED";
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return "CLOSE_REASON_REMOTE_CLOSE";
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return "CLOSE_REASON_LOCAL_CLOSE";
            default:
                return Integer.toString(i);
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ChannelEventParcelable[versionCode=" + this.mVersionCode + ", channel=" + this.zzaZR + ", type=" + zzkB(this.type) + ", closeReason=" + zzkC(this.zzaZP) + ", appErrorCode=" + this.zzaZQ + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }

    public void zza(ChannelListener channelListener) {
        switch (this.type) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                channelListener.onChannelOpened(this.zzaZR);
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                channelListener.onChannelClosed(this.zzaZR, this.zzaZP, this.zzaZQ);
            case CompletionEvent.STATUS_CANCELED /*3*/:
                channelListener.onInputClosed(this.zzaZR, this.zzaZP, this.zzaZQ);
            case Barcode.PHONE /*4*/:
                channelListener.onOutputClosed(this.zzaZR, this.zzaZP, this.zzaZQ);
            default:
                Log.w("ChannelEventParcelable", "Unknown type: " + this.type);
        }
    }
}
