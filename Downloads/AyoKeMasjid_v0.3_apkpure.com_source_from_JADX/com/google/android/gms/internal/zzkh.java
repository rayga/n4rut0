package com.google.android.gms.internal;

import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class zzkh implements GameManagerState {
    private final String zzWA;
    private final Map<String, PlayerInfo> zzWC;
    private final String zzWq;
    private final int zzWr;
    private final int zzWw;
    private final int zzWx;
    private final JSONObject zzWz;

    public zzkh(int i, int i2, String str, JSONObject jSONObject, Collection<PlayerInfo> collection, String str2, int i3) {
        this.zzWx = i;
        this.zzWw = i2;
        this.zzWA = str;
        this.zzWz = jSONObject;
        this.zzWq = str2;
        this.zzWr = i3;
        this.zzWC = new HashMap(collection.size());
        for (PlayerInfo playerInfo : collection) {
            this.zzWC.put(playerInfo.getPlayerId(), playerInfo);
        }
    }

    public boolean equals(Object otherObj) {
        boolean z = true;
        if (otherObj == null || !(otherObj instanceof GameManagerState)) {
            return false;
        }
        GameManagerState gameManagerState = (GameManagerState) otherObj;
        if (getPlayers().size() != gameManagerState.getPlayers().size()) {
            return false;
        }
        for (PlayerInfo playerInfo : getPlayers()) {
            boolean z2 = false;
            for (PlayerInfo playerInfo2 : gameManagerState.getPlayers()) {
                boolean z3;
                if (!zzf.zza(playerInfo.getPlayerId(), playerInfo2.getPlayerId())) {
                    z3 = z2;
                } else if (!zzf.zza(playerInfo, playerInfo2)) {
                    return false;
                } else {
                    z3 = true;
                }
                z2 = z3;
            }
            if (!z2) {
                return false;
            }
        }
        if (!(this.zzWx == gameManagerState.getLobbyState() && this.zzWw == gameManagerState.getGameplayState() && this.zzWr == gameManagerState.getMaxPlayers() && zzf.zza(this.zzWq, gameManagerState.getApplicationName()) && zzf.zza(this.zzWA, gameManagerState.getGameStatusText()) && zzls.zzd(this.zzWz, gameManagerState.getGameData()))) {
            z = false;
        }
        return z;
    }

    public CharSequence getApplicationName() {
        return this.zzWq;
    }

    public List<PlayerInfo> getConnectedControllablePlayers() {
        List arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected() && playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public List<PlayerInfo> getConnectedPlayers() {
        List arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public List<PlayerInfo> getControllablePlayers() {
        List arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public JSONObject getGameData() {
        return this.zzWz;
    }

    public CharSequence getGameStatusText() {
        return this.zzWA;
    }

    public int getGameplayState() {
        return this.zzWw;
    }

    public Collection<String> getListOfChangedPlayers(GameManagerState other) {
        Collection hashSet = new HashSet();
        for (PlayerInfo playerInfo : getPlayers()) {
            PlayerInfo player = other.getPlayer(playerInfo.getPlayerId());
            if (player == null || !playerInfo.equals(player)) {
                hashSet.add(playerInfo.getPlayerId());
            }
        }
        for (PlayerInfo playerInfo2 : other.getPlayers()) {
            if (getPlayer(playerInfo2.getPlayerId()) == null) {
                hashSet.add(playerInfo2.getPlayerId());
            }
        }
        return hashSet;
    }

    public int getLobbyState() {
        return this.zzWx;
    }

    public int getMaxPlayers() {
        return this.zzWr;
    }

    public PlayerInfo getPlayer(String playerId) {
        return playerId == null ? null : (PlayerInfo) this.zzWC.get(playerId);
    }

    public Collection<PlayerInfo> getPlayers() {
        return Collections.unmodifiableCollection(this.zzWC.values());
    }

    public List<PlayerInfo> getPlayersInState(int playerState) {
        List arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.getPlayerState() == playerState) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public boolean hasGameDataChanged(GameManagerState other) {
        return !zzls.zzd(this.zzWz, other.getGameData());
    }

    public boolean hasGameStatusTextChanged(GameManagerState other) {
        return !zzf.zza(this.zzWA, other.getGameStatusText());
    }

    public boolean hasGameplayStateChanged(GameManagerState other) {
        return this.zzWw != other.getGameplayState();
    }

    public boolean hasLobbyStateChanged(GameManagerState other) {
        return this.zzWx != other.getLobbyState();
    }

    public boolean hasPlayerChanged(String playerId, GameManagerState other) {
        return !zzf.zza(getPlayer(playerId), other.getPlayer(playerId));
    }

    public boolean hasPlayerDataChanged(String playerId, GameManagerState other) {
        PlayerInfo player = getPlayer(playerId);
        PlayerInfo player2 = other.getPlayer(playerId);
        if (player == null && player2 == null) {
            return false;
        }
        return player == null || player2 == null || !zzls.zzd(player.getPlayerData(), player2.getPlayerData());
    }

    public boolean hasPlayerStateChanged(String playerId, GameManagerState other) {
        PlayerInfo player = getPlayer(playerId);
        PlayerInfo player2 = other.getPlayer(playerId);
        if (player == null && player2 == null) {
            return false;
        }
        return player == null || player2 == null || player.getPlayerState() != player2.getPlayerState();
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzWx), Integer.valueOf(this.zzWw), this.zzWC, this.zzWA, this.zzWz, this.zzWq, Integer.valueOf(this.zzWr));
    }
}
