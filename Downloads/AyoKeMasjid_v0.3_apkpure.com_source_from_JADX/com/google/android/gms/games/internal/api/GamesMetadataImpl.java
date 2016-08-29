package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameInstancesImpl.1 */
        class C11031 implements LoadGameInstancesResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadGameInstancesImpl zzauN;

            C11031(LoadGameInstancesImpl loadGameInstancesImpl, Status status) {
                this.zzauN = loadGameInstancesImpl;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        public LoadGameInstancesResult zzad(Status status) {
            return new C11031(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzad(status);
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGameSearchSuggestionsImpl.1 */
        class C11041 implements LoadGameSearchSuggestionsResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadGameSearchSuggestionsImpl zzauO;

            C11041(LoadGameSearchSuggestionsImpl loadGameSearchSuggestionsImpl, Status status) {
                this.zzauO = loadGameSearchSuggestionsImpl;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        public LoadGameSearchSuggestionsResult zzae(Status status) {
            return new C11041(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzae(status);
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.LoadGamesImpl.1 */
        class C11051 implements LoadGamesResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadGamesImpl zzauP;

            C11051(LoadGamesImpl loadGamesImpl, Status status) {
                this.zzauP = loadGamesImpl;
                this.zzQs = status;
            }

            public GameBuffer getGames() {
                return new GameBuffer(DataHolder.zzbp(14));
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadGamesResult zzaf(Status status) {
            return new C11051(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaf(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.1 */
    class C13031 extends LoadGamesImpl {
        final /* synthetic */ GamesMetadataImpl zzauL;

        C13031(GamesMetadataImpl gamesMetadataImpl, GoogleApiClient x0) {
            this.zzauL = gamesMetadataImpl;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.2 */
    class C13042 extends LoadGameInstancesImpl {
        final /* synthetic */ String zzauv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj(this, this.zzauv);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl.3 */
    class C13053 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String zzauM;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk(this, this.zzauM);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztK();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.zza(new C13031(this, apiClient));
    }
}
