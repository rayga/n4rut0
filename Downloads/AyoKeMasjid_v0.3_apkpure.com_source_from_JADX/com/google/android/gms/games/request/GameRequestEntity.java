package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final Creator<GameRequestEntity> CREATOR;
    private final int mVersionCode;
    private final String zzBm;
    private final int zzUS;
    private final GameEntity zzaxY;
    private final long zzaxZ;
    private final byte[] zzayG;
    private final PlayerEntity zzaza;
    private final ArrayList<PlayerEntity> zzazb;
    private final long zzazc;
    private final Bundle zzazd;
    private final int zzxJ;

    static {
        CREATOR = new GameRequestEntityCreator();
    }

    GameRequestEntity(int versionCode, GameEntity game, PlayerEntity sender, byte[] data, String requestId, ArrayList<PlayerEntity> recipients, int type, long creationTimestamp, long expirationTimestamp, Bundle recipientStatuses, int status) {
        this.mVersionCode = versionCode;
        this.zzaxY = game;
        this.zzaza = sender;
        this.zzayG = data;
        this.zzBm = requestId;
        this.zzazb = recipients;
        this.zzUS = type;
        this.zzaxZ = creationTimestamp;
        this.zzazc = expirationTimestamp;
        this.zzazd = recipientStatuses;
        this.zzxJ = status;
    }

    public GameRequestEntity(GameRequest request) {
        this.mVersionCode = 2;
        this.zzaxY = new GameEntity(request.getGame());
        this.zzaza = new PlayerEntity(request.getSender());
        this.zzBm = request.getRequestId();
        this.zzUS = request.getType();
        this.zzaxZ = request.getCreationTimestamp();
        this.zzazc = request.getExpirationTimestamp();
        this.zzxJ = request.getStatus();
        Object data = request.getData();
        if (data == null) {
            this.zzayG = null;
        } else {
            this.zzayG = new byte[data.length];
            System.arraycopy(data, 0, this.zzayG, 0, data.length);
        }
        List recipients = request.getRecipients();
        int size = recipients.size();
        this.zzazb = new ArrayList(size);
        this.zzazd = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) recipients.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.zzazb.add((PlayerEntity) player);
            this.zzazd.putInt(playerId, request.getRecipientStatus(playerId));
        }
    }

    static int zza(GameRequest gameRequest) {
        return zzw.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), zzb(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean zza(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return zzw.equal(gameRequest2.getGame(), gameRequest.getGame()) && zzw.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && zzw.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && zzw.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(zzb(gameRequest2), zzb(gameRequest)) && zzw.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && zzw.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && zzw.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] zzb(GameRequest gameRequest) {
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) recipients.get(i)).getPlayerId());
        }
        return iArr;
    }

    static String zzc(GameRequest gameRequest) {
        return zzw.zzu(gameRequest).zzg("Game", gameRequest.getGame()).zzg("Sender", gameRequest.getSender()).zzg("Recipients", gameRequest.getRecipients()).zzg("Data", gameRequest.getData()).zzg("RequestId", gameRequest.getRequestId()).zzg("Type", Integer.valueOf(gameRequest.getType())).zzg("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.zzaxZ;
    }

    public byte[] getData() {
        return this.zzayG;
    }

    public long getExpirationTimestamp() {
        return this.zzazc;
    }

    public Game getGame() {
        return this.zzaxY;
    }

    public int getRecipientStatus(String playerId) {
        return this.zzazd.getInt(playerId, 0);
    }

    public List<Player> getRecipients() {
        return new ArrayList(this.zzazb);
    }

    public String getRequestId() {
        return this.zzBm;
    }

    public Player getSender() {
        return this.zzaza;
    }

    public int getStatus() {
        return this.zzxJ;
    }

    public int getType() {
        return this.zzUS;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestEntityCreator.zza(this, dest, flags);
    }

    public Bundle zzvb() {
        return this.zzazd;
    }
}
