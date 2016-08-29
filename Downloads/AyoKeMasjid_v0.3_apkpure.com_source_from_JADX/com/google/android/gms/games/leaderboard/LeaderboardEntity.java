package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzln;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
    private final String zzahh;
    private final Uri zzaqW;
    private final String zzarh;
    private final String zzaxt;
    private final int zzaxu;
    private final ArrayList<LeaderboardVariantEntity> zzaxv;
    private final Game zzaxw;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.zzaxt = leaderboard.getLeaderboardId();
        this.zzahh = leaderboard.getDisplayName();
        this.zzaqW = leaderboard.getIconImageUri();
        this.zzarh = leaderboard.getIconImageUrl();
        this.zzaxu = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.zzaxw = game == null ? null : new GameEntity(game);
        ArrayList variants = leaderboard.getVariants();
        int size = variants.size();
        this.zzaxv = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaxv.add((LeaderboardVariantEntity) ((LeaderboardVariant) variants.get(i)).freeze());
        }
    }

    static int zza(Leaderboard leaderboard) {
        return zzw.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    static boolean zza(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return zzw.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && zzw.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && zzw.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && zzw.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && zzw.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    static String zzb(Leaderboard leaderboard) {
        return zzw.zzu(leaderboard).zzg("LeaderboardId", leaderboard.getLeaderboardId()).zzg("DisplayName", leaderboard.getDisplayName()).zzg("IconImageUri", leaderboard.getIconImageUri()).zzg("IconImageUrl", leaderboard.getIconImageUrl()).zzg("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).zzg("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzuQ();
    }

    public String getDisplayName() {
        return this.zzahh;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zzln.zzb(this.zzahh, dataOut);
    }

    public Game getGame() {
        return this.zzaxw;
    }

    public Uri getIconImageUri() {
        return this.zzaqW;
    }

    public String getIconImageUrl() {
        return this.zzarh;
    }

    public String getLeaderboardId() {
        return this.zzaxt;
    }

    public int getScoreOrder() {
        return this.zzaxu;
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList(this.zzaxv);
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

    public Leaderboard zzuQ() {
        return this;
    }
}
