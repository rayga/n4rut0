package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class MostRecentGameInfoRef extends zzc implements MostRecentGameInfo {
    private final PlayerColumnNames zzarQ;

    public MostRecentGameInfoRef(DataHolder holder, int dataRow, PlayerColumnNames columnNames) {
        super(holder, dataRow);
        this.zzarQ = columnNames;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzuM();
    }

    public int hashCode() {
        return MostRecentGameInfoEntity.zza(this);
    }

    public String toString() {
        return MostRecentGameInfoEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((MostRecentGameInfoEntity) zzuM()).writeToParcel(dest, flags);
    }

    public String zzuG() {
        return getString(this.zzarQ.zzaxj);
    }

    public String zzuH() {
        return getString(this.zzarQ.zzaxk);
    }

    public long zzuI() {
        return getLong(this.zzarQ.zzaxl);
    }

    public Uri zzuJ() {
        return zzce(this.zzarQ.zzaxm);
    }

    public Uri zzuK() {
        return zzce(this.zzarQ.zzaxn);
    }

    public Uri zzuL() {
        return zzce(this.zzarQ.zzaxo);
    }

    public MostRecentGameInfo zzuM() {
        return new MostRecentGameInfoEntity(this);
    }
}
