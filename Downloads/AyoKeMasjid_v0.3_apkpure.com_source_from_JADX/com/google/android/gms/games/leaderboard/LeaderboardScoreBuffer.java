package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader zzaxx;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzaxx = new LeaderboardScoreBufferHeader(dataHolder.zznP());
    }

    public LeaderboardScore get(int position) {
        return new LeaderboardScoreRef(this.zzYX, position);
    }

    public LeaderboardScoreBufferHeader zzuR() {
        return this.zzaxx;
    }
}
