package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class RoomConfig {

    public static final class Builder {
        int zzayd;
        final RoomUpdateListener zzayo;
        RoomStatusUpdateListener zzayp;
        RealTimeMessageReceivedListener zzayq;
        String zzayr;
        ArrayList<String> zzays;
        Bundle zzayt;

        private Builder(RoomUpdateListener updateListener) {
            this.zzayr = null;
            this.zzayd = -1;
            this.zzays = new ArrayList();
            this.zzayo = (RoomUpdateListener) zzx.zzb((Object) updateListener, (Object) "Must provide a RoomUpdateListener");
        }

        public Builder addPlayersToInvite(ArrayList<String> playerIds) {
            zzx.zzv(playerIds);
            this.zzays.addAll(playerIds);
            return this;
        }

        public Builder addPlayersToInvite(String... playerIds) {
            zzx.zzv(playerIds);
            this.zzays.addAll(Arrays.asList(playerIds));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfigImpl(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.zzayt = autoMatchCriteria;
            return this;
        }

        public Builder setInvitationIdToAccept(String invitationId) {
            zzx.zzv(invitationId);
            this.zzayr = invitationId;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener listener) {
            this.zzayq = listener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener listener) {
            this.zzayp = listener;
            return this;
        }

        public Builder setVariant(int variant) {
            boolean z = variant == -1 || variant > 0;
            zzx.zzb(z, (Object) "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.zzayd = variant;
            return this;
        }
    }

    protected RoomConfig() {
    }

    public static Builder builder(RoomUpdateListener listener) {
        return new Builder(null);
    }

    public static Bundle createAutoMatchCriteria(int minAutoMatchPlayers, int maxAutoMatchPlayers, long exclusiveBitMask) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, minAutoMatchPlayers);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, maxAutoMatchPlayers);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, exclusiveBitMask);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String getInvitationId();

    public abstract String[] getInvitedPlayerIds();

    public abstract RealTimeMessageReceivedListener getMessageReceivedListener();

    public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();

    public abstract RoomUpdateListener getRoomUpdateListener();

    public abstract int getVariant();
}
