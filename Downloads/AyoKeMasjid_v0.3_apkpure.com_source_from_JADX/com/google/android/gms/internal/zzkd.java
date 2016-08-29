package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.CastApi;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.cast.games.GameManagerClient.GameManagerInstanceResult;
import com.google.android.gms.cast.games.GameManagerClient.GameManagerResult;
import com.google.android.gms.cast.games.GameManagerClient.Listener;
import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.cast.internal.zzp;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.bpmikc.akm.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

public class zzkd extends com.google.android.gms.cast.internal.zzc {
    static final String NAMESPACE;
    private static final zzl zzTy;
    private final Map<String, String> zzVP;
    private final List<zzp> zzVQ;
    private final String zzVR;
    private final CastApi zzVS;
    private final GoogleApiClient zzVT;
    private zzke zzVU;
    private boolean zzVV;
    private GameManagerState zzVW;
    private GameManagerState zzVX;
    private String zzVY;
    private JSONObject zzVZ;
    private long zzWa;
    private Listener zzWb;
    private String zzWc;
    private final SharedPreferences zztU;

    /* renamed from: com.google.android.gms.internal.zzkd.4 */
    class C07924 implements ResultCallback<Status> {
        final /* synthetic */ zzkd zzWd;
        final /* synthetic */ long zzWi;

        C07924(zzkd com_google_android_gms_internal_zzkd, long j) {
            this.zzWd = com_google_android_gms_internal_zzkd;
            this.zzWi = j;
        }

        public /* synthetic */ void onResult(Result x0) {
            zzr((Status) x0);
        }

        public void zzr(Status status) {
            if (!status.isSuccess()) {
                this.zzWd.zzb(this.zzWi, status.getStatusCode());
            }
        }
    }

    private static final class zzd implements GameManagerInstanceResult {
        private final Status zzQA;
        private final GameManagerClient zzWl;

        zzd(Status status, GameManagerClient gameManagerClient) {
            this.zzQA = status;
            this.zzWl = gameManagerClient;
        }

        public GameManagerClient getGameManagerClient() {
            return this.zzWl;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static final class zze implements GameManagerResult {
        private final Status zzQA;
        private final String zzWn;
        private final long zzWo;
        private final JSONObject zzWp;

        zze(Status status, String str, long j, JSONObject jSONObject) {
            this.zzQA = status;
            this.zzWn = str;
            this.zzWo = j;
            this.zzWp = jSONObject;
        }

        public JSONObject getExtraMessageData() {
            return this.zzWp;
        }

        public String getPlayerId() {
            return this.zzWn;
        }

        public long getRequestId() {
            return this.zzWo;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public abstract class zzb<R extends Result> extends com.google.android.gms.cast.internal.zzb<R> {
        protected zzo zzVC;
        final /* synthetic */ zzkd zzWd;

        public zzb(zzkd com_google_android_gms_internal_zzkd) {
            this.zzWd = com_google_android_gms_internal_zzkd;
            super(com_google_android_gms_internal_zzkd.zzVT);
        }

        public abstract void execute();

        protected void zza(com.google.android.gms.cast.internal.zze com_google_android_gms_cast_internal_zze) {
            execute();
        }

        public zzo zzmk() {
            return this.zzVC;
        }
    }

    public abstract class zza extends zzb<GameManagerResult> {
        final /* synthetic */ zzkd zzWd;

        /* renamed from: com.google.android.gms.internal.zzkd.zza.1 */
        class C07931 implements zzo {
            final /* synthetic */ zzkd zzWj;
            final /* synthetic */ zza zzWk;

            C07931(zza com_google_android_gms_internal_zzkd_zza, zzkd com_google_android_gms_internal_zzkd) {
                this.zzWk = com_google_android_gms_internal_zzkd_zza;
                this.zzWj = com_google_android_gms_internal_zzkd;
            }

            public void zza(long j, int i, Object obj) {
                if (obj == null) {
                    try {
                        this.zzWk.zza(new zze(new Status(i, null, null), null, j, null));
                        return;
                    } catch (ClassCastException e) {
                        this.zzWk.zza(this.zzWk.zzt(new Status(13)));
                        return;
                    }
                }
                zzkf com_google_android_gms_internal_zzkf = (zzkf) obj;
                String playerId = com_google_android_gms_internal_zzkf.getPlayerId();
                if (i == 0 && playerId != null) {
                    this.zzWk.zzWd.zzWc = playerId;
                }
                this.zzWk.zza(new zze(new Status(i, com_google_android_gms_internal_zzkf.zzmn(), null), playerId, com_google_android_gms_internal_zzkf.getRequestId(), com_google_android_gms_internal_zzkf.getExtraMessageData()));
            }

            public void zzy(long j) {
                this.zzWk.zza(this.zzWk.zzt(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        }

        public zza(zzkd com_google_android_gms_internal_zzkd) {
            this.zzWd = com_google_android_gms_internal_zzkd;
            super(com_google_android_gms_internal_zzkd);
            this.zzVC = new C07931(this, com_google_android_gms_internal_zzkd);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzt(status);
        }

        public GameManagerResult zzt(Status status) {
            return new zze(status, null, -1, null);
        }
    }

    public abstract class zzc extends zzb<GameManagerInstanceResult> {
        final /* synthetic */ zzkd zzWd;
        private GameManagerClient zzWl;

        /* renamed from: com.google.android.gms.internal.zzkd.zzc.1 */
        class C07941 implements zzo {
            final /* synthetic */ zzkd zzWj;
            final /* synthetic */ zzc zzWm;

            C07941(zzc com_google_android_gms_internal_zzkd_zzc, zzkd com_google_android_gms_internal_zzkd) {
                this.zzWm = com_google_android_gms_internal_zzkd_zzc;
                this.zzWj = com_google_android_gms_internal_zzkd;
            }

            public void zza(long j, int i, Object obj) {
                if (obj == null) {
                    try {
                        this.zzWm.zza(new zzd(new Status(i, null, null), this.zzWm.zzWl));
                        return;
                    } catch (ClassCastException e) {
                        this.zzWm.zza(this.zzWm.zzu(new Status(13)));
                        return;
                    }
                }
                zzkf com_google_android_gms_internal_zzkf = (zzkf) obj;
                zzke zzmr = com_google_android_gms_internal_zzkf.zzmr();
                if (zzmr == null || zzf.zza("1.0.0", zzmr.getVersion())) {
                    this.zzWm.zza(new zzd(new Status(i, com_google_android_gms_internal_zzkf.zzmn(), null), this.zzWm.zzWl));
                    return;
                }
                this.zzWm.zza(this.zzWm.zzu(new Status(GameManagerClient.STATUS_INCORRECT_VERSION, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", new Object[]{zzmr.getVersion(), "1.0.0"}))));
                this.zzWm.zzWd.zzVU = null;
            }

            public void zzy(long j) {
                this.zzWm.zza(this.zzWm.zzu(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        }

        public zzc(zzkd com_google_android_gms_internal_zzkd, GameManagerClient gameManagerClient) {
            this.zzWd = com_google_android_gms_internal_zzkd;
            super(com_google_android_gms_internal_zzkd);
            this.zzWl = gameManagerClient;
            this.zzVC = new C07941(this, com_google_android_gms_internal_zzkd);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzu(status);
        }

        public GameManagerInstanceResult zzu(Status status) {
            return new zzd(status, null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkd.1 */
    class C14251 extends zzc {
        final /* synthetic */ zzkd zzWd;

        /* renamed from: com.google.android.gms.internal.zzkd.1.1 */
        class C07911 implements MessageReceivedCallback {
            final /* synthetic */ C14251 zzWe;

            C07911(C14251 c14251) {
                this.zzWe = c14251;
            }

            public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
                this.zzWe.zzWd.zzbJ(message);
            }
        }

        C14251(zzkd com_google_android_gms_internal_zzkd, GameManagerClient gameManagerClient) {
            this.zzWd = com_google_android_gms_internal_zzkd;
            super(com_google_android_gms_internal_zzkd, gameManagerClient);
        }

        public void execute() {
            try {
                this.zzWd.zzVS.setMessageReceivedCallbacks(this.zzWd.zzVT, this.zzWd.getNamespace(), new C07911(this));
                this.zzWd.zzmi();
                this.zzWd.zzmh();
                this.zzWd.zza(null, 1100, null, zzmk());
            } catch (IOException e) {
                zzmk().zza(-1, 8, null);
            } catch (IllegalStateException e2) {
                zzmk().zza(-1, 8, null);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkd.2 */
    class C14262 extends zza {
        final /* synthetic */ zzkd zzWd;
        final /* synthetic */ int zzWf;
        final /* synthetic */ String zzWg;
        final /* synthetic */ JSONObject zzWh;

        C14262(zzkd com_google_android_gms_internal_zzkd, int i, String str, JSONObject jSONObject) {
            this.zzWd = com_google_android_gms_internal_zzkd;
            this.zzWf = i;
            this.zzWg = str;
            this.zzWh = jSONObject;
            super(com_google_android_gms_internal_zzkd);
        }

        public void execute() {
            int zzaR = zzkg.zzaR(this.zzWf);
            if (zzaR == 0) {
                zzmk().zza(-1, GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, null);
                zzkd.zzTy.zzf("sendPlayerRequest for unsupported playerState: %d", Integer.valueOf(this.zzWf));
                return;
            }
            this.zzWd.zza(this.zzWg, zzaR, this.zzWh, zzmk());
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkd.3 */
    class C14273 extends zza {
        final /* synthetic */ zzkd zzWd;
        final /* synthetic */ String zzWg;
        final /* synthetic */ JSONObject zzWh;

        C14273(zzkd com_google_android_gms_internal_zzkd, String str, JSONObject jSONObject) {
            this.zzWd = com_google_android_gms_internal_zzkd;
            this.zzWg = str;
            this.zzWh = jSONObject;
            super(com_google_android_gms_internal_zzkd);
        }

        public void execute() {
            this.zzWd.zza(this.zzWg, 6, this.zzWh, zzmk());
        }
    }

    static {
        NAMESPACE = zzf.zzbM("com.google.cast.games");
        zzTy = new zzl("GameManagerChannel");
    }

    public zzkd(GoogleApiClient googleApiClient, String str, CastApi castApi) throws IllegalArgumentException, IllegalStateException {
        super(NAMESPACE, "CastGameManagerChannel", null);
        this.zzVP = new ConcurrentHashMap();
        this.zzVV = false;
        this.zzWa = 0;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("castSessionId cannot be null.");
        } else if (googleApiClient != null && googleApiClient.isConnected() && googleApiClient.hasConnectedApi(Cast.API)) {
            this.zzVQ = new ArrayList();
            this.zzVR = str;
            this.zzVS = castApi;
            this.zzVT = googleApiClient;
            this.zztU = r0.getApplicationContext().getSharedPreferences(String.format(Locale.ROOT, "%s.%s", new Object[]{googleApiClient.getContext().getApplicationContext().getPackageName(), "game_manager_channel_data"}), 0);
            this.zzVX = null;
            this.zzVW = new zzkh(0, 0, BuildConfig.FLAVOR, null, new ArrayList(), BuildConfig.FLAVOR, -1);
        } else {
            throw new IllegalArgumentException("googleApiClient needs to be connected and contain the Cast.API API.");
        }
    }

    private JSONObject zza(long j, String str, int i, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("requestId", j);
            jSONObject2.put("type", i);
            jSONObject2.put("extraMessageData", jSONObject);
            jSONObject2.put("playerId", str);
            jSONObject2.put("playerToken", zzbI(str));
            return jSONObject2;
        } catch (JSONException e) {
            zzTy.zzf("JSONException when trying to create a message: %s", e.getMessage());
            return null;
        }
    }

    private synchronized void zza(zzkf com_google_android_gms_internal_zzkf) {
        Object obj = 1;
        synchronized (this) {
            if (com_google_android_gms_internal_zzkf.zzmm() != 1) {
                obj = null;
            }
            this.zzVX = this.zzVW;
            if (!(obj == null || com_google_android_gms_internal_zzkf.zzmr() == null)) {
                this.zzVU = com_google_android_gms_internal_zzkf.zzmr();
            }
            if (isInitialized()) {
                Collection arrayList = new ArrayList();
                for (zzkj com_google_android_gms_internal_zzkj : com_google_android_gms_internal_zzkf.zzmo()) {
                    String playerId = com_google_android_gms_internal_zzkj.getPlayerId();
                    arrayList.add(new zzki(playerId, com_google_android_gms_internal_zzkj.getPlayerState(), com_google_android_gms_internal_zzkj.getPlayerData(), this.zzVP.containsKey(playerId)));
                }
                this.zzVW = new zzkh(com_google_android_gms_internal_zzkf.getLobbyState(), com_google_android_gms_internal_zzkf.getGameplayState(), com_google_android_gms_internal_zzkf.zzmp(), com_google_android_gms_internal_zzkf.getGameData(), arrayList, this.zzVU.zzml(), this.zzVU.getMaxPlayers());
                PlayerInfo player = this.zzVW.getPlayer(com_google_android_gms_internal_zzkf.getPlayerId());
                if (player != null && player.isControllable() && com_google_android_gms_internal_zzkf.zzmm() == 2) {
                    this.zzVY = com_google_android_gms_internal_zzkf.getPlayerId();
                    this.zzVZ = com_google_android_gms_internal_zzkf.getExtraMessageData();
                }
            }
        }
    }

    private void zza(String str, int i, JSONObject jSONObject, zzo com_google_android_gms_cast_internal_zzo) {
        long j = 1 + this.zzWa;
        this.zzWa = j;
        JSONObject zza = zza(j, str, i, jSONObject);
        if (zza == null) {
            com_google_android_gms_cast_internal_zzo.zza(-1, GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, null);
            zzTy.zzf("Not sending request because it was invalid.", new Object[0]);
            return;
        }
        zzp com_google_android_gms_cast_internal_zzp = new zzp(30000);
        com_google_android_gms_cast_internal_zzp.zza(j, com_google_android_gms_cast_internal_zzo);
        this.zzVQ.add(com_google_android_gms_cast_internal_zzp);
        zzU(true);
        this.zzVS.sendMessage(this.zzVT, getNamespace(), zza.toString()).setResultCallback(new C07924(this, j));
    }

    private int zzaQ(int i) {
        switch (i) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return 0;
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return CastStatusCodes.NOT_ALLOWED;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                return GameManagerClient.STATUS_INCORRECT_VERSION;
            case Barcode.PHONE /*4*/:
                return GameManagerClient.STATUS_TOO_MANY_PLAYERS;
            default:
                zzTy.zzf("Unknown GameManager protocol status code: " + i, new Object[0]);
                return 13;
        }
    }

    private void zzb(long j, int i, Object obj) {
        Iterator it = this.zzVQ.iterator();
        while (it.hasNext()) {
            if (((zzp) it.next()).zzc(j, i, obj)) {
                it.remove();
            }
        }
    }

    private synchronized void zzmf() throws IllegalStateException {
        if (!isInitialized()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel before it is initialized.");
        } else if (isDisposed()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel after it has been disposed.");
        }
    }

    private void zzmg() {
        if (this.zzWb != null) {
            if (!(this.zzVX == null || this.zzVW.equals(this.zzVX))) {
                this.zzWb.onStateChanged(this.zzVW, this.zzVX);
            }
            if (!(this.zzVZ == null || this.zzVY == null)) {
                this.zzWb.onGameMessageReceived(this.zzVY, this.zzVZ);
            }
        }
        this.zzVX = null;
        this.zzVY = null;
        this.zzVZ = null;
    }

    private synchronized void zzmh() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("castSessionId", this.zzVR);
            jSONObject.put("playerTokenMap", new JSONObject(this.zzVP));
            this.zztU.edit().putString("save_data", jSONObject.toString()).commit();
        } catch (JSONException e) {
            zzTy.zzf("Error while saving data: %s", e.getMessage());
        }
    }

    private synchronized void zzmi() {
        String string = this.zztU.getString("save_data", null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (this.zzVR.equals(jSONObject.getString("castSessionId"))) {
                    jSONObject = jSONObject.getJSONObject("playerTokenMap");
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        string = (String) keys.next();
                        this.zzVP.put(string, jSONObject.getString(string));
                    }
                    this.zzWa = 0;
                }
            } catch (JSONException e) {
                zzTy.zzf("Error while loading data: %s", e.getMessage());
            }
        }
    }

    public synchronized void dispose() throws IllegalStateException {
        if (!this.zzVV) {
            this.zzVW = null;
            this.zzVX = null;
            this.zzVY = null;
            this.zzVZ = null;
            this.zzVV = true;
            try {
                this.zzVS.removeMessageReceivedCallbacks(this.zzVT, getNamespace());
            } catch (IOException e) {
                zzTy.zzf("Exception while detaching game manager channel.", e);
            }
        }
    }

    public synchronized GameManagerState getCurrentState() throws IllegalStateException {
        zzmf();
        return this.zzVW;
    }

    public synchronized String getLastUsedPlayerId() throws IllegalStateException {
        zzmf();
        return this.zzWc;
    }

    public synchronized boolean isDisposed() {
        return this.zzVV;
    }

    public synchronized boolean isInitialized() {
        return this.zzVU != null;
    }

    public synchronized void sendGameMessage(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        zzmf();
        long j = 1 + this.zzWa;
        this.zzWa = j;
        JSONObject zza = zza(j, playerId, 7, extraMessageData);
        if (zza != null) {
            this.zzVS.sendMessage(this.zzVT, getNamespace(), zza.toString());
        }
    }

    public synchronized PendingResult<GameManagerResult> sendGameRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        zzmf();
        return this.zzVT.zzb(new C14273(this, playerId, extraMessageData));
    }

    public synchronized void setListener(Listener listener) {
        this.zzWb = listener;
    }

    public synchronized PendingResult<GameManagerInstanceResult> zza(GameManagerClient gameManagerClient) throws IllegalArgumentException {
        if (gameManagerClient == null) {
            throw new IllegalArgumentException("gameManagerClient can't be null.");
        }
        return this.zzVT.zzb(new C14251(this, gameManagerClient));
    }

    public synchronized PendingResult<GameManagerResult> zza(String str, int i, JSONObject jSONObject) throws IllegalStateException {
        zzmf();
        return this.zzVT.zzb(new C14262(this, i, str, jSONObject));
    }

    public void zzb(long j, int i) {
        zzb(j, i, null);
    }

    public synchronized String zzbI(String str) throws IllegalStateException {
        return str == null ? null : (String) this.zzVP.get(str);
    }

    public final void zzbJ(String str) {
        zzTy.zzb("message received: %s", str);
        try {
            zzkf zzh = zzkf.zzh(new JSONObject(str));
            if (zzh == null) {
                zzTy.zzf("Could not parse game manager message from string: %s", str);
            } else if ((isInitialized() || zzh.zzmr() != null) && !isDisposed()) {
                int i = zzh.zzmm() == 1 ? 1 : 0;
                if (!(i == 0 || TextUtils.isEmpty(zzh.zzmq()))) {
                    this.zzVP.put(zzh.getPlayerId(), zzh.zzmq());
                    zzmh();
                }
                if (zzh.getStatusCode() == 0) {
                    zza(zzh);
                } else {
                    zzTy.zzf("Not updating from game message because the message contains error code: %d", Integer.valueOf(zzh.getStatusCode()));
                }
                int zzaQ = zzaQ(zzh.getStatusCode());
                if (i != 0) {
                    zzb(zzh.getRequestId(), zzaQ, zzh);
                }
                if (isInitialized() && zzaQ == 0) {
                    zzmg();
                }
            }
        } catch (JSONException e) {
            zzTy.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    protected boolean zzz(long j) {
        boolean z;
        Iterator it = this.zzVQ.iterator();
        while (it.hasNext()) {
            if (((zzp) it.next()).zzd(j, 15)) {
                it.remove();
            }
        }
        synchronized (zzp.zzXT) {
            for (zzp zzmO : this.zzVQ) {
                if (zzmO.zzmO()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }
}
