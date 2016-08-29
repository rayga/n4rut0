package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    private static abstract class CancelMatchImpl extends BaseGamesApiMethodImpl<CancelMatchResult> {
        private final String zzwj;

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.CancelMatchImpl.1 */
        class C11321 implements CancelMatchResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ CancelMatchImpl zzaws;

            C11321(CancelMatchImpl cancelMatchImpl, Status status) {
                this.zzaws = cancelMatchImpl;
                this.zzQs = status;
            }

            public String getMatchId() {
                return this.zzaws.zzwj;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        public CancelMatchImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzwj = id;
        }

        public CancelMatchResult zzaF(Status status) {
            return new C11321(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaF(status);
        }
    }

    private static abstract class InitiateMatchImpl extends BaseGamesApiMethodImpl<InitiateMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.InitiateMatchImpl.1 */
        class C11331 implements InitiateMatchResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ InitiateMatchImpl zzawt;

            C11331(InitiateMatchImpl initiateMatchImpl, Status status) {
                this.zzawt = initiateMatchImpl;
                this.zzQs = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        private InitiateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public InitiateMatchResult zzaG(Status status) {
            return new C11331(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaG(status);
        }
    }

    private static abstract class LeaveMatchImpl extends BaseGamesApiMethodImpl<LeaveMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LeaveMatchImpl.1 */
        class C11341 implements LeaveMatchResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LeaveMatchImpl zzawu;

            C11341(LeaveMatchImpl leaveMatchImpl, Status status) {
                this.zzawu = leaveMatchImpl;
                this.zzQs = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        private LeaveMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaveMatchResult zzaH(Status status) {
            return new C11341(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaH(status);
        }
    }

    private static abstract class LoadMatchImpl extends BaseGamesApiMethodImpl<LoadMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchImpl.1 */
        class C11351 implements LoadMatchResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadMatchImpl zzawv;

            C11351(LoadMatchImpl loadMatchImpl, Status status) {
                this.zzawv = loadMatchImpl;
                this.zzQs = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        private LoadMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchResult zzaI(Status status) {
            return new C11351(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaI(status);
        }
    }

    private static abstract class LoadMatchesImpl extends BaseGamesApiMethodImpl<LoadMatchesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.LoadMatchesImpl.1 */
        class C11361 implements LoadMatchesResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadMatchesImpl zzaww;

            C11361(LoadMatchesImpl loadMatchesImpl, Status status) {
                this.zzaww = loadMatchesImpl;
                this.zzQs = status;
            }

            public LoadMatchesResponse getMatches() {
                return new LoadMatchesResponse(new Bundle());
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        private LoadMatchesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchesResult zzaJ(Status status) {
            return new C11361(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaJ(status);
        }
    }

    private static abstract class UpdateMatchImpl extends BaseGamesApiMethodImpl<UpdateMatchResult> {

        /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.UpdateMatchImpl.1 */
        class C11371 implements UpdateMatchResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ UpdateMatchImpl zzawx;

            C11371(UpdateMatchImpl updateMatchImpl, Status status) {
                this.zzawx = updateMatchImpl;
                this.zzQs = status;
            }

            public TurnBasedMatch getMatch() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        private UpdateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateMatchResult zzaK(Status status) {
            return new C11371(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaK(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.10 */
    class AnonymousClass10 extends LoadMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzawl;
        final /* synthetic */ String zzawm;

        AnonymousClass10(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str) {
            this.zzawl = turnBasedMultiplayerImpl;
            this.zzawm = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg((zzb) this, this.zzawm);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.11 */
    class AnonymousClass11 extends InitiateMatchImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ String zzawm;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzauv, this.zzawm);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.12 */
    class AnonymousClass12 extends InitiateMatchImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ String zzawm;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzauv, this.zzawm);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.13 */
    class AnonymousClass13 extends LoadMatchesImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ int zzawn;
        final /* synthetic */ int[] zzawo;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauv, this.zzawn, this.zzawo);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.1 */
    class C13511 extends InitiateMatchImpl {
        final /* synthetic */ TurnBasedMatchConfig zzawk;
        final /* synthetic */ TurnBasedMultiplayerImpl zzawl;

        C13511(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, TurnBasedMatchConfig turnBasedMatchConfig) {
            this.zzawl = turnBasedMultiplayerImpl;
            this.zzawk = turnBasedMatchConfig;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzawk);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.2 */
    class C13522 extends InitiateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzawl;
        final /* synthetic */ String zzawm;

        C13522(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str) {
            this.zzawl = turnBasedMultiplayerImpl;
            this.zzawm = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzawm);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.3 */
    class C13533 extends InitiateMatchImpl {
        final /* synthetic */ String zzauS;
        final /* synthetic */ TurnBasedMultiplayerImpl zzawl;

        C13533(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str) {
            this.zzawl = turnBasedMultiplayerImpl;
            this.zzauS = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzauS);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.4 */
    class C13544 extends UpdateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzawl;
        final /* synthetic */ String zzawm;
        final /* synthetic */ byte[] zzawp;
        final /* synthetic */ String zzawq;
        final /* synthetic */ ParticipantResult[] zzawr;

        C13544(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
            this.zzawl = turnBasedMultiplayerImpl;
            this.zzawm = str;
            this.zzawp = bArr;
            this.zzawq = str2;
            this.zzawr = participantResultArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzawm, this.zzawp, this.zzawq, this.zzawr);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.5 */
    class C13555 extends UpdateMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzawl;
        final /* synthetic */ String zzawm;
        final /* synthetic */ byte[] zzawp;
        final /* synthetic */ ParticipantResult[] zzawr;

        C13555(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
            this.zzawl = turnBasedMultiplayerImpl;
            this.zzawm = str;
            this.zzawp = bArr;
            this.zzawr = participantResultArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzawm, this.zzawp, this.zzawr);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.6 */
    class C13566 extends LeaveMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzawl;
        final /* synthetic */ String zzawm;

        C13566(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str) {
            this.zzawl = turnBasedMultiplayerImpl;
            this.zzawm = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb) this, this.zzawm);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.7 */
    class C13577 extends LeaveMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzawl;
        final /* synthetic */ String zzawm;
        final /* synthetic */ String zzawq;

        C13577(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, String str, String str2) {
            this.zzawl = turnBasedMultiplayerImpl;
            this.zzawm = str;
            this.zzawq = str2;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzawm, this.zzawq);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.8 */
    class C13588 extends CancelMatchImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzawl;
        final /* synthetic */ String zzawm;

        C13588(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, String x0, GoogleApiClient x1, String str) {
            this.zzawl = turnBasedMultiplayerImpl;
            this.zzawm = str;
            super(x0, x1);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this, this.zzawm);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl.9 */
    class C13599 extends LoadMatchesImpl {
        final /* synthetic */ TurnBasedMultiplayerImpl zzawl;
        final /* synthetic */ int zzawn;
        final /* synthetic */ int[] zzawo;

        C13599(TurnBasedMultiplayerImpl turnBasedMultiplayerImpl, GoogleApiClient x0, int i, int[] iArr) {
            this.zzawl = turnBasedMultiplayerImpl;
            this.zzawn = i;
            this.zzawo = iArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzawn, this.zzawo);
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, String invitationId) {
        return apiClient.zzb(new C13533(this, apiClient, invitationId));
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.zzb(new C13588(this, matchId, apiClient, matchId));
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient apiClient, TurnBasedMatchConfig config) {
        return apiClient.zzb(new C13511(this, apiClient, config));
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzs(invitationId, 1);
        }
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzr(invitationId, 1);
        }
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzcX(matchId);
        }
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, null, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, ParticipantResult... results) {
        return apiClient.zzb(new C13555(this, apiClient, matchId, matchData, results));
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztN();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztX();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.zzd(apiClient).zzb(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.zzd(apiClient).zzb(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.zzb(new C13566(this, apiClient, matchId));
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, String matchId, String pendingParticipantId) {
        return apiClient.zzb(new C13577(this, apiClient, matchId, pendingParticipantId));
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient apiClient, String matchId) {
        return apiClient.zza(new AnonymousClass10(this, apiClient, matchId));
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int invitationSortOrder, int[] matchTurnStatuses) {
        return apiClient.zza(new C13599(this, apiClient, invitationSortOrder, matchTurnStatuses));
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzb(apiClient.zzp(listener));
        }
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient apiClient, String matchId) {
        return apiClient.zzb(new C13522(this, apiClient, matchId));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        return apiClient.zzb(new C13544(this, apiClient, matchId, matchData, pendingParticipantId, results));
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zztQ();
        }
    }
}
