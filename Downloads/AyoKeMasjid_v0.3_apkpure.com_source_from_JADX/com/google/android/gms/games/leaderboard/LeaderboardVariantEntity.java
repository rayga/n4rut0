package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int zzaxL;
    private final int zzaxM;
    private final boolean zzaxN;
    private final long zzaxO;
    private final String zzaxP;
    private final long zzaxQ;
    private final String zzaxR;
    private final String zzaxS;
    private final long zzaxT;
    private final String zzaxU;
    private final String zzaxV;
    private final String zzaxW;

    public LeaderboardVariantEntity(LeaderboardVariant variant) {
        this.zzaxL = variant.getTimeSpan();
        this.zzaxM = variant.getCollection();
        this.zzaxN = variant.hasPlayerInfo();
        this.zzaxO = variant.getRawPlayerScore();
        this.zzaxP = variant.getDisplayPlayerScore();
        this.zzaxQ = variant.getPlayerRank();
        this.zzaxR = variant.getDisplayPlayerRank();
        this.zzaxS = variant.getPlayerScoreTag();
        this.zzaxT = variant.getNumScores();
        this.zzaxU = variant.zzuT();
        this.zzaxV = variant.zzuU();
        this.zzaxW = variant.zzuV();
    }

    static int zza(LeaderboardVariant leaderboardVariant) {
        return zzw.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zzuT(), leaderboardVariant.zzuV(), leaderboardVariant.zzuU());
    }

    static boolean zza(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return zzw.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && zzw.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && zzw.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && zzw.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && zzw.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && zzw.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && zzw.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && zzw.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && zzw.equal(leaderboardVariant2.zzuT(), leaderboardVariant.zzuT()) && zzw.equal(leaderboardVariant2.zzuV(), leaderboardVariant.zzuV()) && zzw.equal(leaderboardVariant2.zzuU(), leaderboardVariant.zzuU());
    }

    static String zzb(LeaderboardVariant leaderboardVariant) {
        return zzw.zzu(leaderboardVariant).zzg("TimeSpan", TimeSpan.zzfQ(leaderboardVariant.getTimeSpan())).zzg("Collection", LeaderboardCollection.zzfQ(leaderboardVariant.getCollection())).zzg("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").zzg("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").zzg("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").zzg("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").zzg("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).zzg("TopPageNextToken", leaderboardVariant.zzuT()).zzg("WindowPageNextToken", leaderboardVariant.zzuV()).zzg("WindowPagePrevToken", leaderboardVariant.zzuU()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzuW();
    }

    public int getCollection() {
        return this.zzaxM;
    }

    public String getDisplayPlayerRank() {
        return this.zzaxR;
    }

    public String getDisplayPlayerScore() {
        return this.zzaxP;
    }

    public long getNumScores() {
        return this.zzaxT;
    }

    public long getPlayerRank() {
        return this.zzaxQ;
    }

    public String getPlayerScoreTag() {
        return this.zzaxS;
    }

    public long getRawPlayerScore() {
        return this.zzaxO;
    }

    public int getTimeSpan() {
        return this.zzaxL;
    }

    public boolean hasPlayerInfo() {
        return this.zzaxN;
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

    public String zzuT() {
        return this.zzaxU;
    }

    public String zzuU() {
        return this.zzaxV;
    }

    public String zzuV() {
        return this.zzaxW;
    }

    public LeaderboardVariant zzuW() {
        return this;
    }
}
