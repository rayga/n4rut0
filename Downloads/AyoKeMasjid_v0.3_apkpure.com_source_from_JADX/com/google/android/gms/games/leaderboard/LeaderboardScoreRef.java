package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends zzc implements LeaderboardScore {
    private final PlayerRef zzaxK;

    LeaderboardScoreRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.zzaxK = new PlayerRef(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardScoreEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzuS();
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        zza("display_rank", dataOut);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        zza("display_score", dataOut);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        return zzcf("external_player_id") ? null : this.zzaxK;
    }

    public String getScoreHolderDisplayName() {
        return zzcf("external_player_id") ? getString("default_display_name") : this.zzaxK.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (zzcf("external_player_id")) {
            zza("default_display_name", dataOut);
        } else {
            this.zzaxK.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return zzcf("external_player_id") ? null : this.zzaxK.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return zzcf("external_player_id") ? null : this.zzaxK.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return zzcf("external_player_id") ? zzce("default_display_image_uri") : this.zzaxK.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return zzcf("external_player_id") ? getString("default_display_image_url") : this.zzaxK.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }

    public LeaderboardScore zzuS() {
        return new LeaderboardScoreEntity(this);
    }
}
