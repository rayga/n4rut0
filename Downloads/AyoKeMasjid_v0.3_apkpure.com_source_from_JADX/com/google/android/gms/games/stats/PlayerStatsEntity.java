package com.google.android.gms.games.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class PlayerStatsEntity implements SafeParcelable, PlayerStats {
    public static final Creator<PlayerStatsEntity> CREATOR;
    private final int mVersionCode;
    private final int zzazA;
    private final float zzazB;
    private final float zzazC;
    private final float zzazw;
    private final float zzazx;
    private final int zzazy;
    private final int zzazz;

    static {
        CREATOR = new PlayerStatsEntityCreator();
    }

    PlayerStatsEntity(int versionCode, float averageSessionLength, float churnProbability, int daysSinceLastPlayed, int numberOfPurchases, int numberOfSessions, float sessionPercentile, float spendPercentile) {
        this.mVersionCode = versionCode;
        this.zzazw = averageSessionLength;
        this.zzazx = churnProbability;
        this.zzazy = daysSinceLastPlayed;
        this.zzazz = numberOfPurchases;
        this.zzazA = numberOfSessions;
        this.zzazB = sessionPercentile;
        this.zzazC = spendPercentile;
    }

    public PlayerStatsEntity(PlayerStats playerStats) {
        this.mVersionCode = 1;
        this.zzazw = playerStats.zzvd();
        this.zzazx = playerStats.zzve();
        this.zzazy = playerStats.zzvf();
        this.zzazz = playerStats.zzvg();
        this.zzazA = playerStats.zzvh();
        this.zzazB = playerStats.zzvi();
        this.zzazC = playerStats.zzvj();
    }

    static int zza(PlayerStats playerStats) {
        return zzw.hashCode(Float.valueOf(playerStats.zzvd()), Float.valueOf(playerStats.zzve()), Integer.valueOf(playerStats.zzvf()), Integer.valueOf(playerStats.zzvg()), Integer.valueOf(playerStats.zzvh()), Float.valueOf(playerStats.zzvi()), Float.valueOf(playerStats.zzvj()));
    }

    static boolean zza(PlayerStats playerStats, Object obj) {
        if (!(obj instanceof PlayerStats)) {
            return false;
        }
        if (playerStats == obj) {
            return true;
        }
        PlayerStats playerStats2 = (PlayerStats) obj;
        return zzw.equal(Float.valueOf(playerStats2.zzvd()), Float.valueOf(playerStats.zzvd())) && zzw.equal(Float.valueOf(playerStats2.zzve()), Float.valueOf(playerStats.zzve())) && zzw.equal(Integer.valueOf(playerStats2.zzvf()), Integer.valueOf(playerStats.zzvf())) && zzw.equal(Integer.valueOf(playerStats2.zzvg()), Integer.valueOf(playerStats.zzvg())) && zzw.equal(Integer.valueOf(playerStats2.zzvh()), Integer.valueOf(playerStats.zzvh())) && zzw.equal(Float.valueOf(playerStats2.zzvi()), Float.valueOf(playerStats.zzvi())) && zzw.equal(Float.valueOf(playerStats2.zzvj()), Float.valueOf(playerStats.zzvj()));
    }

    static String zzb(PlayerStats playerStats) {
        return zzw.zzu(playerStats).zzg("AverageSessionLength", Float.valueOf(playerStats.zzvd())).zzg("ChurnProbability", Float.valueOf(playerStats.zzve())).zzg("DaysSinceLastPlayed", Integer.valueOf(playerStats.zzvf())).zzg("NumberOfPurchases", Integer.valueOf(playerStats.zzvg())).zzg("NumberOfSessions", Integer.valueOf(playerStats.zzvh())).zzg("SessionPercentile", Float.valueOf(playerStats.zzvi())).zzg("SpendPercentile", Float.valueOf(playerStats.zzvj())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvk();
    }

    public int getVersionCode() {
        return this.mVersionCode;
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

    public void writeToParcel(Parcel out, int flags) {
        PlayerStatsEntityCreator.zza(this, out, flags);
    }

    public float zzvd() {
        return this.zzazw;
    }

    public float zzve() {
        return this.zzazx;
    }

    public int zzvf() {
        return this.zzazy;
    }

    public int zzvg() {
        return this.zzazz;
    }

    public int zzvh() {
        return this.zzazA;
    }

    public float zzvi() {
        return this.zzazB;
    }

    public float zzvj() {
        return this.zzazC;
    }

    public PlayerStats zzvk() {
        return this;
    }
}
