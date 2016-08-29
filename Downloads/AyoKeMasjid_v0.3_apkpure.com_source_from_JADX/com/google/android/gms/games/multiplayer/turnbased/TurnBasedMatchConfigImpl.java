package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig.Builder;

public final class TurnBasedMatchConfigImpl extends TurnBasedMatchConfig {
    private final int zzayC;
    private final int zzayd;
    private final Bundle zzayt;
    private final String[] zzayu;

    TurnBasedMatchConfigImpl(Builder builder) {
        this.zzayd = builder.zzayd;
        this.zzayC = builder.zzayC;
        this.zzayt = builder.zzayt;
        this.zzayu = (String[]) builder.zzays.toArray(new String[builder.zzays.size()]);
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzayt;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzayu;
    }

    public int getVariant() {
        return this.zzayd;
    }

    public int zzuX() {
        return this.zzayC;
    }
}
