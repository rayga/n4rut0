package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.StatsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Games {
    public static final Api<GamesOptions> API;
    public static final Achievements Achievements;
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    public static final Events Events;
    public static final GamesMetadata GamesMetadata;
    public static final Invitations Invitations;
    public static final Leaderboards Leaderboards;
    public static final Notifications Notifications;
    public static final Players Players;
    public static final Quests Quests;
    public static final RealTimeMultiplayer RealTimeMultiplayer;
    public static final Requests Requests;
    public static final Scope SCOPE_GAMES;
    public static final Snapshots Snapshots;
    public static final TurnBasedMultiplayer TurnBasedMultiplayer;
    static final zzc<GamesClientImpl> zzQf;
    private static final zza<GamesClientImpl, GamesOptions> zzQg;
    private static final zza<GamesClientImpl, GamesOptions> zzaro;
    public static final Scope zzarp;
    public static final Api<GamesOptions> zzarq;
    public static final AppContents zzarr;
    public static final Multiplayer zzars;
    public static final Stats zzart;
    public static final Acls zzaru;

    private static abstract class GamesClientBuilder extends zza<GamesClientImpl, GamesOptions> {
        private GamesClientBuilder() {
        }

        public int getPriority() {
            return 1;
        }

        public GamesClientImpl zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, com_google_android_gms_common_internal_zzf, gamesOptions == null ? new GamesOptions() : gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    /* renamed from: com.google.android.gms.games.Games.1 */
    static class C10961 extends GamesClientBuilder {
        C10961() {
            super();
        }

        public List<Scope> zza(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.SCOPE_GAMES);
        }

        public /* synthetic */ List zzl(Object obj) {
            return zza((GamesOptions) obj);
        }
    }

    /* renamed from: com.google.android.gms.games.Games.2 */
    static class C10972 extends GamesClientBuilder {
        C10972() {
            super();
        }

        public List<Scope> zza(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.zzarp);
        }

        public /* synthetic */ List zzl(Object obj) {
            return zza((GamesOptions) obj);
        }
    }

    public static final class GamesOptions implements Optional {
        public final String zzarA;
        public final ArrayList<String> zzarB;
        public final boolean zzarv;
        public final boolean zzarw;
        public final int zzarx;
        public final boolean zzary;
        public final int zzarz;

        public static final class Builder {
            String zzarA;
            ArrayList<String> zzarB;
            boolean zzarv;
            boolean zzarw;
            int zzarx;
            boolean zzary;
            int zzarz;

            private Builder() {
                this.zzarv = false;
                this.zzarw = true;
                this.zzarx = 17;
                this.zzary = false;
                this.zzarz = 4368;
                this.zzarA = null;
                this.zzarB = new ArrayList();
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            public Builder setSdkVariant(int variant) {
                this.zzarz = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.zzarw = showConnectingPopup;
                this.zzarx = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.zzarw = showConnectingPopup;
                this.zzarx = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.zzarv = false;
            this.zzarw = true;
            this.zzarx = 17;
            this.zzary = false;
            this.zzarz = 4368;
            this.zzarA = null;
            this.zzarB = new ArrayList();
        }

        private GamesOptions(Builder builder) {
            this.zzarv = builder.zzarv;
            this.zzarw = builder.zzarw;
            this.zzarx = builder.zzarx;
            this.zzary = builder.zzary;
            this.zzarz = builder.zzarz;
            this.zzarA = builder.zzarA;
            this.zzarB = builder.zzarB;
        }

        public static Builder builder() {
            return new Builder();
        }

        public Bundle zzsQ() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzarv);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzarw);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzarx);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzary);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzarz);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzarA);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzarB);
            return bundle;
        }
    }

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl(GoogleApiClient googleApiClient) {
            super(Games.zzQf, googleApiClient);
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.Games.3 */
    static class C12873 extends SignOutImpl {
        C12873(GoogleApiClient x0) {
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this);
        }
    }

    static {
        zzQf = new zzc();
        zzQg = new C10961();
        zzaro = new C10972();
        SCOPE_GAMES = new Scope(Scopes.GAMES);
        API = new Api("Games.API", zzQg, zzQf);
        zzarp = new Scope("https://www.googleapis.com/auth/games.firstparty");
        zzarq = new Api("Games.API_1P", zzaro, zzQf);
        GamesMetadata = new GamesMetadataImpl();
        Achievements = new AchievementsImpl();
        zzarr = new AppContentsImpl();
        Events = new EventsImpl();
        Leaderboards = new LeaderboardsImpl();
        Invitations = new InvitationsImpl();
        TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
        RealTimeMultiplayer = new RealTimeMultiplayerImpl();
        zzars = new MultiplayerImpl();
        Players = new PlayersImpl();
        Notifications = new NotificationsImpl();
        Quests = new QuestsImpl();
        Requests = new RequestsImpl();
        Snapshots = new SnapshotsImpl();
        zzart = new StatsImpl();
        zzaru = new AclsImpl();
    }

    private Games() {
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return zzd(apiClient).zztW();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return zzd(apiClient).zztH();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return zzd(apiClient).zztV();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return zzd(apiClient).zztU();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        GamesClientImpl zzb = zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzfM(gravity);
        }
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        zzx.zzv(gamesContentView);
        GamesClientImpl zzb = zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzm(gamesContentView);
        }
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.zzb(new C12873(apiClient));
    }

    public static GamesClientImpl zzb(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zzc(googleApiClient, z);
    }

    public static GamesClientImpl zzc(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (GamesClientImpl) googleApiClient.zza(zzQf) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        }
    }

    public static GamesClientImpl zzd(GoogleApiClient googleApiClient) {
        return zzb(googleApiClient, true);
    }
}
