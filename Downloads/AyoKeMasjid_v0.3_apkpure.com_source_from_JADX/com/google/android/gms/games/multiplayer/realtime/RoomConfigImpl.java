package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig.Builder;

public final class RoomConfigImpl extends RoomConfig {
    private final String zzate;
    private final int zzayd;
    private final RoomUpdateListener zzayo;
    private final RoomStatusUpdateListener zzayp;
    private final RealTimeMessageReceivedListener zzayq;
    private final Bundle zzayt;
    private final String[] zzayu;

    RoomConfigImpl(Builder builder) {
        this.zzayo = builder.zzayo;
        this.zzayp = builder.zzayp;
        this.zzayq = builder.zzayq;
        this.zzate = builder.zzayr;
        this.zzayd = builder.zzayd;
        this.zzayt = builder.zzayt;
        this.zzayu = (String[]) builder.zzays.toArray(new String[builder.zzays.size()]);
        zzx.zzb(this.zzayq, (Object) "Must specify a message listener");
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzayt;
    }

    public String getInvitationId() {
        return this.zzate;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzayu;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.zzayq;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.zzayp;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.zzayo;
    }

    public int getVariant() {
        return this.zzayd;
    }
}
