package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class LeaderboardVariantRef extends zzc implements LeaderboardVariant {
    LeaderboardVariantRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardVariantEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzuW();
    }

    public int getCollection() {
        return getInteger("collection");
    }

    public String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    public String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    public long getNumScores() {
        return zzcf("total_scores") ? -1 : getLong("total_scores");
    }

    public long getPlayerRank() {
        return zzcf("player_rank") ? -1 : getLong("player_rank");
    }

    public String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public long getRawPlayerScore() {
        return zzcf("player_raw_score") ? -1 : getLong("player_raw_score");
    }

    public int getTimeSpan() {
        return getInteger("timespan");
    }

    public boolean hasPlayerInfo() {
        return !zzcf("player_raw_score");
    }

    public int hashCode() {
        return LeaderboardVariantEntity.zza(this);
    }

    public String toString() {
        return LeaderboardVariantEntity.zzb(this);
    }

    public String zzuT() {
        return getString("top_page_token_next");
    }

    public String zzuU() {
        return getString("window_page_token_prev");
    }

    public String zzuV() {
        return getString("window_page_token_next");
    }

    public LeaderboardVariant zzuW() {
        return new LeaderboardVariantEntity(this);
    }
}
