package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends zzc implements Player {
    private final PlayerLevelInfo zzarG;
    private final PlayerColumnNames zzarQ;
    private final MostRecentGameInfoRef zzarR;

    public PlayerRef(DataHolder holder, int dataRow) {
        this(holder, dataRow, null);
    }

    public PlayerRef(DataHolder holder, int dataRow, String prefix) {
        super(holder, dataRow);
        this.zzarQ = new PlayerColumnNames(prefix);
        this.zzarR = new MostRecentGameInfoRef(holder, dataRow, this.zzarQ);
        if (zzsU()) {
            PlayerLevel playerLevel;
            int integer = getInteger(this.zzarQ.zzaxb);
            int integer2 = getInteger(this.zzarQ.zzaxe);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(this.zzarQ.zzaxc), getLong(this.zzarQ.zzaxd));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(this.zzarQ.zzaxd), getLong(this.zzarQ.zzaxf));
            } else {
                playerLevel = playerLevel2;
            }
            this.zzarG = new PlayerLevelInfo(getLong(this.zzarQ.zzaxa), getLong(this.zzarQ.zzaxg), playerLevel2, playerLevel);
            return;
        }
        this.zzarG = null;
    }

    private boolean zzsU() {
        return (zzcf(this.zzarQ.zzaxa) || getLong(this.zzarQ.zzaxa) == -1) ? false : true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.zza(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public String getDisplayName() {
        return getString(this.zzarQ.zzawS);
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zza(this.zzarQ.zzawS, dataOut);
    }

    public Uri getHiResImageUri() {
        return zzce(this.zzarQ.zzawV);
    }

    public String getHiResImageUrl() {
        return getString(this.zzarQ.zzawW);
    }

    public Uri getIconImageUri() {
        return zzce(this.zzarQ.zzawT);
    }

    public String getIconImageUrl() {
        return getString(this.zzarQ.zzawU);
    }

    public long getLastPlayedWithTimestamp() {
        return (!zzcd(this.zzarQ.zzawZ) || zzcf(this.zzarQ.zzawZ)) ? -1 : getLong(this.zzarQ.zzawZ);
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzarG;
    }

    public String getPlayerId() {
        return getString(this.zzarQ.zzawR);
    }

    public long getRetrievedTimestamp() {
        return getLong(this.zzarQ.zzawX);
    }

    public String getTitle() {
        return getString(this.zzarQ.title);
    }

    public void getTitle(CharArrayBuffer dataOut) {
        zza(this.zzarQ.title, dataOut);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.zzb(this);
    }

    public boolean isProfileVisible() {
        return getBoolean(this.zzarQ.zzaxi);
    }

    public String toString() {
        return PlayerEntity.zzc((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }

    public boolean zzsR() {
        return getBoolean(this.zzarQ.zzaxp);
    }

    public int zzsS() {
        return getInteger(this.zzarQ.zzawY);
    }

    public MostRecentGameInfo zzsT() {
        return zzcf(this.zzarQ.zzaxj) ? null : this.zzarR;
    }
}
