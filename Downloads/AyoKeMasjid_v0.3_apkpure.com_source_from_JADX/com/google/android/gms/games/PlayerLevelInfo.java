package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class PlayerLevelInfo implements SafeParcelable {
    public static final Creator<PlayerLevelInfo> CREATOR;
    private final int mVersionCode;
    private final long zzarM;
    private final long zzarN;
    private final PlayerLevel zzarO;
    private final PlayerLevel zzarP;

    static {
        CREATOR = new PlayerLevelInfoCreator();
    }

    PlayerLevelInfo(int versionCode, long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        zzx.zzY(currentXpTotal != -1);
        zzx.zzv(currentLevel);
        zzx.zzv(nextLevel);
        this.mVersionCode = versionCode;
        this.zzarM = currentXpTotal;
        this.zzarN = lastLevelUpTimestamp;
        this.zzarO = currentLevel;
        this.zzarP = nextLevel;
    }

    public PlayerLevelInfo(long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        this(1, currentXpTotal, lastLevelUpTimestamp, currentLevel, nextLevel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return zzw.equal(Long.valueOf(this.zzarM), Long.valueOf(playerLevelInfo.zzarM)) && zzw.equal(Long.valueOf(this.zzarN), Long.valueOf(playerLevelInfo.zzarN)) && zzw.equal(this.zzarO, playerLevelInfo.zzarO) && zzw.equal(this.zzarP, playerLevelInfo.zzarP);
    }

    public PlayerLevel getCurrentLevel() {
        return this.zzarO;
    }

    public long getCurrentXpTotal() {
        return this.zzarM;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzarN;
    }

    public PlayerLevel getNextLevel() {
        return this.zzarP;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzarM), Long.valueOf(this.zzarN), this.zzarO, this.zzarP);
    }

    public boolean isMaxLevel() {
        return this.zzarO.equals(this.zzarP);
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelInfoCreator.zza(this, out, flags);
    }
}
