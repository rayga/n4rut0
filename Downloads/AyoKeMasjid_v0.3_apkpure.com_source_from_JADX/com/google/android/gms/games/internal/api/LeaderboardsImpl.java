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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl implements Leaderboards {

    private static abstract class LoadMetadataImpl extends BaseGamesApiMethodImpl<LeaderboardMetadataResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadMetadataImpl.1 */
        class C11071 implements LeaderboardMetadataResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadMetadataImpl zzavd;

            C11071(LoadMetadataImpl loadMetadataImpl, Status status) {
                this.zzavd = loadMetadataImpl;
                this.zzQs = status;
            }

            public LeaderboardBuffer getLeaderboards() {
                return new LeaderboardBuffer(DataHolder.zzbp(14));
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        private LoadMetadataImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaderboardMetadataResult zzah(Status status) {
            return new C11071(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzah(status);
        }
    }

    private static abstract class LoadPlayerScoreImpl extends BaseGamesApiMethodImpl<LoadPlayerScoreResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadPlayerScoreImpl.1 */
        class C11081 implements LoadPlayerScoreResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadPlayerScoreImpl zzave;

            C11081(LoadPlayerScoreImpl loadPlayerScoreImpl, Status status) {
                this.zzave = loadPlayerScoreImpl;
                this.zzQs = status;
            }

            public LeaderboardScore getScore() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        private LoadPlayerScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayerScoreResult zzai(Status status) {
            return new C11081(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzai(status);
        }
    }

    private static abstract class LoadScoresImpl extends BaseGamesApiMethodImpl<LoadScoresResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadScoresImpl.1 */
        class C11091 implements LoadScoresResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadScoresImpl zzavf;

            C11091(LoadScoresImpl loadScoresImpl, Status status) {
                this.zzavf = loadScoresImpl;
                this.zzQs = status;
            }

            public Leaderboard getLeaderboard() {
                return null;
            }

            public LeaderboardScoreBuffer getScores() {
                return new LeaderboardScoreBuffer(DataHolder.zzbp(14));
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        private LoadScoresImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadScoresResult zzaj(Status status) {
            return new C11091(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaj(status);
        }
    }

    protected static abstract class SubmitScoreImpl extends BaseGamesApiMethodImpl<SubmitScoreResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.SubmitScoreImpl.1 */
        class C11101 implements SubmitScoreResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ SubmitScoreImpl zzavg;

            C11101(SubmitScoreImpl submitScoreImpl, Status status) {
                this.zzavg = submitScoreImpl;
                this.zzQs = status;
            }

            public ScoreSubmissionData getScoreData() {
                return new ScoreSubmissionData(DataHolder.zzbp(14));
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        protected SubmitScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public SubmitScoreResult zzak(Status status) {
            return new C11101(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzak(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.10 */
    class AnonymousClass10 extends LoadScoresImpl {
        final /* synthetic */ String zzauV;
        final /* synthetic */ int zzauW;
        final /* synthetic */ int zzauX;
        final /* synthetic */ int zzauY;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzauv, this.zzauV, this.zzauW, this.zzauX, this.zzauY, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.11 */
    class AnonymousClass11 extends LoadScoresImpl {
        final /* synthetic */ String zzauV;
        final /* synthetic */ int zzauW;
        final /* synthetic */ int zzauX;
        final /* synthetic */ int zzauY;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzauv, this.zzauV, this.zzauW, this.zzauX, this.zzauY, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.1 */
    class C13091 extends LoadMetadataImpl {
        final /* synthetic */ LeaderboardsImpl zzauU;
        final /* synthetic */ boolean zzaut;

        C13091(LeaderboardsImpl leaderboardsImpl, GoogleApiClient x0, boolean z) {
            this.zzauU = leaderboardsImpl;
            this.zzaut = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.2 */
    class C13102 extends LoadMetadataImpl {
        final /* synthetic */ LeaderboardsImpl zzauU;
        final /* synthetic */ String zzauV;
        final /* synthetic */ boolean zzaut;

        C13102(LeaderboardsImpl leaderboardsImpl, GoogleApiClient x0, String str, boolean z) {
            this.zzauU = leaderboardsImpl;
            this.zzauV = str;
            this.zzaut = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzauV, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.3 */
    class C13113 extends LoadPlayerScoreImpl {
        final /* synthetic */ LeaderboardsImpl zzauU;
        final /* synthetic */ String zzauV;
        final /* synthetic */ int zzauW;
        final /* synthetic */ int zzauX;

        C13113(LeaderboardsImpl leaderboardsImpl, GoogleApiClient x0, String str, int i, int i2) {
            this.zzauU = leaderboardsImpl;
            this.zzauV = str;
            this.zzauW = i;
            this.zzauX = i2;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, this.zzauV, this.zzauW, this.zzauX);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.4 */
    class C13124 extends LoadScoresImpl {
        final /* synthetic */ LeaderboardsImpl zzauU;
        final /* synthetic */ String zzauV;
        final /* synthetic */ int zzauW;
        final /* synthetic */ int zzauX;
        final /* synthetic */ int zzauY;
        final /* synthetic */ boolean zzaut;

        C13124(LeaderboardsImpl leaderboardsImpl, GoogleApiClient x0, String str, int i, int i2, int i3, boolean z) {
            this.zzauU = leaderboardsImpl;
            this.zzauV = str;
            this.zzauW = i;
            this.zzauX = i2;
            this.zzauY = i3;
            this.zzaut = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauV, this.zzauW, this.zzauX, this.zzauY, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.5 */
    class C13135 extends LoadScoresImpl {
        final /* synthetic */ LeaderboardsImpl zzauU;
        final /* synthetic */ String zzauV;
        final /* synthetic */ int zzauW;
        final /* synthetic */ int zzauX;
        final /* synthetic */ int zzauY;
        final /* synthetic */ boolean zzaut;

        C13135(LeaderboardsImpl leaderboardsImpl, GoogleApiClient x0, String str, int i, int i2, int i3, boolean z) {
            this.zzauU = leaderboardsImpl;
            this.zzauV = str;
            this.zzauW = i;
            this.zzauX = i2;
            this.zzauY = i3;
            this.zzaut = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzauV, this.zzauW, this.zzauX, this.zzauY, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.6 */
    class C13146 extends LoadScoresImpl {
        final /* synthetic */ LeaderboardsImpl zzauU;
        final /* synthetic */ int zzauY;
        final /* synthetic */ LeaderboardScoreBuffer zzauZ;
        final /* synthetic */ int zzava;

        C13146(LeaderboardsImpl leaderboardsImpl, GoogleApiClient x0, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
            this.zzauU = leaderboardsImpl;
            this.zzauZ = leaderboardScoreBuffer;
            this.zzauY = i;
            this.zzava = i2;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauZ, this.zzauY, this.zzava);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.7 */
    class C13157 extends SubmitScoreImpl {
        final /* synthetic */ LeaderboardsImpl zzauU;
        final /* synthetic */ String zzauV;
        final /* synthetic */ long zzavb;
        final /* synthetic */ String zzavc;

        C13157(LeaderboardsImpl leaderboardsImpl, GoogleApiClient x0, String str, long j, String str2) {
            this.zzauU = leaderboardsImpl;
            this.zzauV = str;
            this.zzavb = j;
            this.zzavc = str2;
            super(x0);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauV, this.zzavb, this.zzavc);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.8 */
    class C13168 extends LoadMetadataImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzauv, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.9 */
    class C13179 extends LoadMetadataImpl {
        final /* synthetic */ String zzauV;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauv, this.zzauV, this.zzaut);
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztL();
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return getLeaderboardIntent(apiClient, leaderboardId, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId, int timeSpan) {
        return Games.zzd(apiClient).zzp(leaderboardId, timeSpan);
    }

    public PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection) {
        return apiClient.zza(new C13113(this, apiClient, leaderboardId, span, leaderboardCollection));
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, String leaderboardId, boolean forceReload) {
        return apiClient.zza(new C13102(this, apiClient, leaderboardId, forceReload));
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.zza(new C13091(this, apiClient, forceReload));
    }

    public PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient apiClient, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        return apiClient.zza(new C13146(this, apiClient, buffer, maxResults, pageDirection));
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        return apiClient.zza(new C13135(this, apiClient, leaderboardId, span, leaderboardCollection, maxResults, forceReload));
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        return apiClient.zza(new C13124(this, apiClient, leaderboardId, span, leaderboardCollection, maxResults, forceReload));
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, null);
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            try {
                zzb.zza(null, leaderboardId, score, scoreTag);
            } catch (RemoteException e) {
                GamesLog.zzw("LeaderboardsImpl", "service died");
            }
        }
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, null);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        return apiClient.zzb(new C13157(this, apiClient, leaderboardId, score, scoreTag));
    }
}
