package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef extends zzc implements Leaderboard {
    private final int zzasz;
    private final Game zzaxw;

    LeaderboardRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.zzasz = numChildren;
        this.zzaxw = new GameRef(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzuQ();
    }

    public String getDisplayName() {
        return getString("name");
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zza("name", dataOut);
    }

    public Game getGame() {
        return this.zzaxw;
    }

    public Uri getIconImageUri() {
        return zzce("board_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    public String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public int getScoreOrder() {
        return getInteger("score_order");
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList(this.zzasz);
        for (int i = 0; i < this.zzasz; i++) {
            arrayList.add(new LeaderboardVariantRef(this.zzYX, this.zzabg + i));
        }
        return arrayList;
    }

    public int hashCode() {
        return LeaderboardEntity.zza(this);
    }

    public String toString() {
        return LeaderboardEntity.zzb(this);
    }

    public Leaderboard zzuQ() {
        return new LeaderboardEntity(this);
    }
}
