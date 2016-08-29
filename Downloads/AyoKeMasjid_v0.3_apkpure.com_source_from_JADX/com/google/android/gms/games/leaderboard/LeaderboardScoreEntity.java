package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzln;

public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final String zzaxA;
    private final long zzaxB;
    private final long zzaxC;
    private final String zzaxD;
    private final Uri zzaxE;
    private final Uri zzaxF;
    private final PlayerEntity zzaxG;
    private final String zzaxH;
    private final String zzaxI;
    private final String zzaxJ;
    private final long zzaxy;
    private final String zzaxz;

    public LeaderboardScoreEntity(LeaderboardScore score) {
        this.zzaxy = score.getRank();
        this.zzaxz = (String) zzx.zzv(score.getDisplayRank());
        this.zzaxA = (String) zzx.zzv(score.getDisplayScore());
        this.zzaxB = score.getRawScore();
        this.zzaxC = score.getTimestampMillis();
        this.zzaxD = score.getScoreHolderDisplayName();
        this.zzaxE = score.getScoreHolderIconImageUri();
        this.zzaxF = score.getScoreHolderHiResImageUri();
        Player scoreHolder = score.getScoreHolder();
        this.zzaxG = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.zzaxH = score.getScoreTag();
        this.zzaxI = score.getScoreHolderIconImageUrl();
        this.zzaxJ = score.getScoreHolderHiResImageUrl();
    }

    static int zza(LeaderboardScore leaderboardScore) {
        return zzw.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static boolean zza(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return zzw.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && zzw.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && zzw.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && zzw.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && zzw.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && zzw.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && zzw.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && zzw.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && zzw.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && zzw.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    static String zzb(LeaderboardScore leaderboardScore) {
        return zzw.zzu(leaderboardScore).zzg("Rank", Long.valueOf(leaderboardScore.getRank())).zzg("DisplayRank", leaderboardScore.getDisplayRank()).zzg("Score", Long.valueOf(leaderboardScore.getRawScore())).zzg("DisplayScore", leaderboardScore.getDisplayScore()).zzg("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).zzg("DisplayName", leaderboardScore.getScoreHolderDisplayName()).zzg("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).zzg("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).zzg("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).zzg("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).zzg("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).zzg("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzuS();
    }

    public String getDisplayRank() {
        return this.zzaxz;
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzaxz, dataOut);
    }

    public String getDisplayScore() {
        return this.zzaxA;
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzaxA, dataOut);
    }

    public long getRank() {
        return this.zzaxy;
    }

    public long getRawScore() {
        return this.zzaxB;
    }

    public Player getScoreHolder() {
        return this.zzaxG;
    }

    public String getScoreHolderDisplayName() {
        return this.zzaxG == null ? this.zzaxD : this.zzaxG.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (this.zzaxG == null) {
            zzln.zzb(this.zzaxD, dataOut);
        } else {
            this.zzaxG.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.zzaxG == null ? this.zzaxF : this.zzaxG.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.zzaxG == null ? this.zzaxJ : this.zzaxG.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.zzaxG == null ? this.zzaxE : this.zzaxG.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.zzaxG == null ? this.zzaxI : this.zzaxG.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.zzaxH;
    }

    public long getTimestampMillis() {
        return this.zzaxC;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public LeaderboardScore zzuS() {
        return this;
    }
}
