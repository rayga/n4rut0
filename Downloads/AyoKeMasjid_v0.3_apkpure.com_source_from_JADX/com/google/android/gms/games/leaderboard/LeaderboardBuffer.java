package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class LeaderboardBuffer extends zzf<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzk(int i, int i2) {
        return zzo(i, i2);
    }

    protected String zznW() {
        return "external_leaderboard_id";
    }

    protected Leaderboard zzo(int i, int i2) {
        return new LeaderboardRef(this.zzYX, i, i2);
    }
}
