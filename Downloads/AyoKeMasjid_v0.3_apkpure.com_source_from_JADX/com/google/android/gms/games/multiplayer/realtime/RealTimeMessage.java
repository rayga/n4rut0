package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR;
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzayl;
    private final byte[] zzaym;
    private final int zzayn;

    /* renamed from: com.google.android.gms.games.multiplayer.realtime.RealTimeMessage.1 */
    static class C03031 implements Creator<RealTimeMessage> {
        C03031() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdW(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzge(x0);
        }

        public RealTimeMessage zzdW(Parcel parcel) {
            return new RealTimeMessage(null);
        }

        public RealTimeMessage[] zzge(int i) {
            return new RealTimeMessage[i];
        }
    }

    static {
        CREATOR = new C03031();
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.zzayl = (String) zzx.zzv(senderParticipantId);
        this.zzaym = (byte[]) ((byte[]) zzx.zzv(messageData)).clone();
        this.zzayn = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.zzaym;
    }

    public String getSenderParticipantId() {
        return this.zzayl;
    }

    public boolean isReliable() {
        return this.zzayn == RELIABLE;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.zzayl);
        parcel.writeByteArray(this.zzaym);
        parcel.writeInt(this.zzayn);
    }
}
