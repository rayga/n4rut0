package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef extends zzc implements GameRequest {
    private final int zzasz;

    public GameRequestRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.zzasz = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameRequestEntity.zza(this, obj);
    }

    public GameRequest freeze() {
        return new GameRequestEntity(this);
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public long getExpirationTimestamp() {
        return getLong("expiration_timestamp");
    }

    public Game getGame() {
        return new GameRef(this.zzYX, this.zzabg);
    }

    public int getRecipientStatus(String playerId) {
        for (int i = this.zzabg; i < this.zzabg + this.zzasz; i++) {
            int zzbo = this.zzYX.zzbo(i);
            if (this.zzYX.zzd("recipient_external_player_id", i, zzbo).equals(playerId)) {
                return this.zzYX.zzc("recipient_status", i, zzbo);
            }
        }
        return -1;
    }

    public List<Player> getRecipients() {
        List arrayList = new ArrayList(this.zzasz);
        for (int i = 0; i < this.zzasz; i++) {
            arrayList.add(new PlayerRef(this.zzYX, this.zzabg + i, "recipient_"));
        }
        return arrayList;
    }

    public String getRequestId() {
        return getString("external_request_id");
    }

    public Player getSender() {
        return new PlayerRef(this.zzYX, zznS(), "sender_");
    }

    public int getStatus() {
        return getInteger(Games.EXTRA_STATUS);
    }

    public int getType() {
        return getInteger("type");
    }

    public int hashCode() {
        return GameRequestEntity.zza(this);
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public String toString() {
        return GameRequestEntity.zzc(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((GameRequestEntity) freeze()).writeToParcel(dest, flags);
    }
}
