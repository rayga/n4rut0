package com.google.android.gms.games.stats;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public class PlayerStatsRef extends zzc implements PlayerStats {
    PlayerStatsRef(DataHolder holder, int rowIndex) {
        super(holder, rowIndex);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerStatsEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzvk();
    }

    public int hashCode() {
        return PlayerStatsEntity.zza(this);
    }

    public String toString() {
        return PlayerStatsEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerStatsEntity) zzvk()).writeToParcel(dest, flags);
    }

    public float zzvd() {
        return getFloat("ave_session_length_minutes");
    }

    public float zzve() {
        return getFloat("churn_probability");
    }

    public int zzvf() {
        return getInteger("days_since_last_played");
    }

    public int zzvg() {
        return getInteger("num_purchases");
    }

    public int zzvh() {
        return getInteger("num_sessions");
    }

    public float zzvi() {
        return getFloat("num_sessions_percentile");
    }

    public float zzvj() {
        return getFloat("spend_percentile");
    }

    public PlayerStats zzvk() {
        return new PlayerStatsEntity(this);
    }
}
