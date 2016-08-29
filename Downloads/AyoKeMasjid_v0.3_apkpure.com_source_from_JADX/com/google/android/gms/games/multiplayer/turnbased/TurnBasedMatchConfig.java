package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;

public abstract class TurnBasedMatchConfig {

    public static final class Builder {
        int zzayC;
        int zzayd;
        ArrayList<String> zzays;
        Bundle zzayt;

        private Builder() {
            this.zzayd = -1;
            this.zzays = new ArrayList();
            this.zzayt = null;
            this.zzayC = 2;
        }

        public Builder addInvitedPlayer(String playerId) {
            zzx.zzv(playerId);
            this.zzays.add(playerId);
            return this;
        }

        public Builder addInvitedPlayers(ArrayList<String> playerIds) {
            zzx.zzv(playerIds);
            this.zzays.addAll(playerIds);
            return this;
        }

        public TurnBasedMatchConfig build() {
            return new TurnBasedMatchConfigImpl(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.zzayt = autoMatchCriteria;
            return this;
        }

        public Builder setVariant(int variant) {
            boolean z = variant == -1 || variant > 0;
            zzx.zzb(z, (Object) "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.zzayd = variant;
            return this;
        }
    }

    protected TurnBasedMatchConfig() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Bundle createAutoMatchCriteria(int minAutoMatchPlayers, int maxAutoMatchPlayers, long exclusiveBitMask) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, minAutoMatchPlayers);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, maxAutoMatchPlayers);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, exclusiveBitMask);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String[] getInvitedPlayerIds();

    public abstract int getVariant();

    public abstract int zzuX();
}
