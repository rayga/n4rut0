package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadPlayersImpl.1 */
        class C11161 implements LoadPlayersResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadPlayersImpl zzavw;

            C11161(LoadPlayersImpl loadPlayersImpl, Status status) {
                this.zzavw = loadPlayersImpl;
                this.zzQs = status;
            }

            public PlayerBuffer getPlayers() {
                return new PlayerBuffer(DataHolder.zzbp(14));
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayersResult zzap(Status status) {
            return new C11161(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzap(status);
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadProfileSettingsResultImpl.1 */
        class C11171 implements LoadProfileSettingsResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadProfileSettingsResultImpl zzavx;

            C11171(LoadProfileSettingsResultImpl loadProfileSettingsResultImpl, Status status) {
                this.zzavx = loadProfileSettingsResultImpl;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public boolean isProfileVisible() {
                return true;
            }

            public boolean isVisibilityExplicitlySet() {
                return false;
            }
        }

        protected LoadProfileSettingsResult zzaq(Status status) {
            return new C11171(this, status);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzaq(status);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpForGameCategoriesResultImpl.1 */
        class C11181 implements LoadXpForGameCategoriesResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadXpForGameCategoriesResultImpl zzavy;

            C11181(LoadXpForGameCategoriesResultImpl loadXpForGameCategoriesResultImpl, Status status) {
                this.zzavy = loadXpForGameCategoriesResultImpl;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        public LoadXpForGameCategoriesResult zzar(Status status) {
            return new C11181(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzar(status);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpStreamResultImpl.1 */
        class C11191 implements LoadXpStreamResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadXpStreamResultImpl zzavz;

            C11191(LoadXpStreamResultImpl loadXpStreamResultImpl, Status status) {
                this.zzavz = loadXpStreamResultImpl;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        public LoadXpStreamResult zzas(Status status) {
            return new C11191(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzas(status);
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.10 */
    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ int zzavq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", this.zzauv, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.11 */
    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;
        final /* synthetic */ int zzavq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzauv, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.12 */
    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ int zzavq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzauv, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.13 */
    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ int zzavq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.14 */
    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ int zzavq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.15 */
    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ int zzavq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.16 */
    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ int zzavq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.17 */
    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ int zzavq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.18 */
    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ int zzavq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.19 */
    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ String zzauM;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ int zzavq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzauM, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.1 */
    class C13211 extends LoadPlayersImpl {
        final /* synthetic */ String zzWg;
        final /* synthetic */ PlayersImpl zzavp;

        C13211(PlayersImpl playersImpl, GoogleApiClient x0, String str) {
            this.zzavp = playersImpl;
            this.zzWg = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzWg, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.20 */
    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ String zzauM;
        final /* synthetic */ int zzavq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzauM, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.21 */
    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzavh;
        final /* synthetic */ int zzavq;
        final /* synthetic */ String zzavr;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzavr, this.zzavh, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.22 */
    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ String zzavh;
        final /* synthetic */ int zzavq;
        final /* synthetic */ String zzavr;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzavr, this.zzavh, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.23 */
    class AnonymousClass23 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String zzavs;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this, this.zzavs);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.24 */
    class AnonymousClass24 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzavs;
        final /* synthetic */ int zzavt;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzavs, this.zzavt);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.25 */
    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzavs;
        final /* synthetic */ int zzavt;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzavs, this.zzavt);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.26 */
    class AnonymousClass26 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaut;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg((zzb) this, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.27 */
    class AnonymousClass27 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean zzavu;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb) this, this.zzavu);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.2 */
    class C13222 extends LoadPlayersImpl {
        final /* synthetic */ String zzWg;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ PlayersImpl zzavp;

        C13222(PlayersImpl playersImpl, GoogleApiClient x0, String str, boolean z) {
            this.zzavp = playersImpl;
            this.zzWg = str;
            this.zzaut = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzWg, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.3 */
    class C13233 extends LoadPlayersImpl {
        final /* synthetic */ String[] zzavv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzavv);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.4 */
    class C13244 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ PlayersImpl zzavp;
        final /* synthetic */ int zzavq;

        C13244(PlayersImpl playersImpl, GoogleApiClient x0, int i, boolean z) {
            this.zzavp = playersImpl;
            this.zzavq = i;
            this.zzaut = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.5 */
    class C13255 extends LoadPlayersImpl {
        final /* synthetic */ PlayersImpl zzavp;
        final /* synthetic */ int zzavq;

        C13255(PlayersImpl playersImpl, GoogleApiClient x0, int i) {
            this.zzavp = playersImpl;
            this.zzavq = i;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.6 */
    class C13266 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ PlayersImpl zzavp;
        final /* synthetic */ int zzavq;

        C13266(PlayersImpl playersImpl, GoogleApiClient x0, int i, boolean z) {
            this.zzavp = playersImpl;
            this.zzavq = i;
            this.zzaut = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.7 */
    class C13277 extends LoadPlayersImpl {
        final /* synthetic */ PlayersImpl zzavp;
        final /* synthetic */ int zzavq;

        C13277(PlayersImpl playersImpl, GoogleApiClient x0, int i) {
            this.zzavp = playersImpl;
            this.zzavq = i;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.8 */
    class C13288 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ PlayersImpl zzavp;

        C13288(PlayersImpl playersImpl, GoogleApiClient x0, boolean z) {
            this.zzavp = playersImpl;
            this.zzaut = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.9 */
    class C13299 extends LoadPlayersImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ int zzavq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", this.zzauv, this.zzavq, false, false);
        }
    }

    public Intent getCompareProfileIntent(GoogleApiClient apiClient, Player player) {
        return Games.zzd(apiClient).zza(new PlayerEntity(player));
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztJ();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztI();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztT();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.zza(new C13288(this, apiClient, forceReload));
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, int pageSize, boolean forceReload) {
        return apiClient.zza(new C13244(this, apiClient, pageSize, forceReload));
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, int pageSize) {
        return apiClient.zza(new C13255(this, apiClient, pageSize));
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, int pageSize) {
        return apiClient.zza(new C13277(this, apiClient, pageSize));
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, String playerId) {
        return apiClient.zza(new C13211(this, apiClient, playerId));
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, String playerId, boolean forceReload) {
        return apiClient.zza(new C13222(this, apiClient, playerId, forceReload));
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, int pageSize, boolean forceReload) {
        return apiClient.zza(new C13266(this, apiClient, pageSize, forceReload));
    }
}
