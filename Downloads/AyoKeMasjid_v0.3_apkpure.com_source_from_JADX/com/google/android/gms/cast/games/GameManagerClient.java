package com.google.android.gms.cast.games;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzkd;
import org.json.JSONObject;

public final class GameManagerClient {
    public static final int GAMEPLAY_STATE_LOADING = 1;
    public static final int GAMEPLAY_STATE_PAUSED = 3;
    public static final int GAMEPLAY_STATE_RUNNING = 2;
    public static final int GAMEPLAY_STATE_SHOWING_INFO_SCREEN = 4;
    public static final int GAMEPLAY_STATE_UNKNOWN = 0;
    public static final int LOBBY_STATE_CLOSED = 2;
    public static final int LOBBY_STATE_OPEN = 1;
    public static final int LOBBY_STATE_UNKNOWN = 0;
    public static final int PLAYER_STATE_AVAILABLE = 3;
    public static final int PLAYER_STATE_DROPPED = 1;
    public static final int PLAYER_STATE_IDLE = 5;
    public static final int PLAYER_STATE_PLAYING = 6;
    public static final int PLAYER_STATE_QUIT = 2;
    public static final int PLAYER_STATE_READY = 4;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int STATUS_INCORRECT_VERSION = 2150;
    public static final int STATUS_TOO_MANY_PLAYERS = 2151;
    private final zzkd zzVO;

    public interface Listener {
        void onGameMessageReceived(String str, JSONObject jSONObject);

        void onStateChanged(GameManagerState gameManagerState, GameManagerState gameManagerState2);
    }

    public interface GameManagerInstanceResult extends Result {
        GameManagerClient getGameManagerClient();
    }

    public interface GameManagerResult extends Result {
        JSONObject getExtraMessageData();

        String getPlayerId();

        long getRequestId();
    }

    public GameManagerClient(zzkd channel) {
        this.zzVO = channel;
    }

    public static PendingResult<GameManagerInstanceResult> getInstanceFor(GoogleApiClient googleApiClient, String castSessionId) throws IllegalArgumentException {
        return zza(new zzkd(googleApiClient, castSessionId, Cast.CastApi));
    }

    static PendingResult<GameManagerInstanceResult> zza(zzkd com_google_android_gms_internal_zzkd) throws IllegalArgumentException {
        return com_google_android_gms_internal_zzkd.zza(new GameManagerClient(com_google_android_gms_internal_zzkd));
    }

    private PendingResult<GameManagerResult> zza(String str, int i, JSONObject jSONObject) throws IllegalStateException {
        return this.zzVO.zza(str, i, jSONObject);
    }

    public void dispose() {
        this.zzVO.dispose();
    }

    public synchronized GameManagerState getCurrentState() throws IllegalStateException {
        return this.zzVO.getCurrentState();
    }

    public String getLastUsedPlayerId() throws IllegalStateException {
        return this.zzVO.getLastUsedPlayerId();
    }

    public boolean isDisposed() {
        return this.zzVO.isDisposed();
    }

    public void sendGameMessage(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        this.zzVO.sendGameMessage(playerId, extraMessageData);
    }

    public void sendGameMessage(JSONObject extraMessageData) throws IllegalStateException {
        sendGameMessage(getLastUsedPlayerId(), extraMessageData);
    }

    public PendingResult<GameManagerResult> sendGameRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        return this.zzVO.sendGameRequest(playerId, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendGameRequest(JSONObject extraMessageData) throws IllegalStateException {
        return sendGameRequest(getLastUsedPlayerId(), extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerAvailableRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        return zza(playerId, PLAYER_STATE_AVAILABLE, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerAvailableRequest(JSONObject extraMessageData) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), PLAYER_STATE_AVAILABLE, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerIdleRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        return zza(playerId, PLAYER_STATE_IDLE, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerIdleRequest(JSONObject extraMessageData) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), PLAYER_STATE_IDLE, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerPlayingRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        return zza(playerId, PLAYER_STATE_PLAYING, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerPlayingRequest(JSONObject extraMessageData) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), PLAYER_STATE_PLAYING, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerQuitRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        return zza(playerId, PLAYER_STATE_QUIT, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerQuitRequest(JSONObject extraMessageData) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), PLAYER_STATE_QUIT, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerReadyRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        return zza(playerId, PLAYER_STATE_READY, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerReadyRequest(JSONObject extraMessageData) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), PLAYER_STATE_READY, extraMessageData);
    }

    public void setListener(Listener listener) {
        this.zzVO.setListener(listener);
    }

    public void setSessionLabel(String sessionLabel) {
        this.zzVO.setSessionLabel(sessionLabel);
    }
}
