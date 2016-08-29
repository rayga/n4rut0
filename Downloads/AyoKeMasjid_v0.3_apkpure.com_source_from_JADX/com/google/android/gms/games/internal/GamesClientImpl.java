package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.api.zzd;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.api.zzl.zzb;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.signin.internal.zzi;
import com.google.android.gms.wearable.WearableStatusCodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

public final class GamesClientImpl extends zzj<IGamesService> {
    EventIncrementManager zzasJ;
    private final String zzasK;
    private PlayerEntity zzasL;
    private GameEntity zzasM;
    private final PopupManager zzasN;
    private boolean zzasO;
    private final Binder zzasP;
    private final long zzasQ;
    private final GamesOptions zzasR;

    /* renamed from: com.google.android.gms.games.internal.GamesClientImpl.1 */
    class C07411 extends EventIncrementManager {
        final /* synthetic */ GamesClientImpl zzasS;

        C07411(GamesClientImpl gamesClientImpl) {
            this.zzasS = gamesClientImpl;
        }

        public EventIncrementCache zzue() {
            return new GameClientEventIncrementCache(this.zzasS);
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl zzasS;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.zzasS = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE);
        }

        protected void zzt(String str, int i) {
            try {
                if (this.zzasS.isConnected()) {
                    ((IGamesService) this.zzasS.zzoA()).zzq(str, i);
                } else {
                    GamesLog.zzx("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                this.zzasS.zzb(e);
            }
        }
    }

    private static final class InvitationReceivedNotifier implements zzb<OnInvitationReceivedListener> {
        private final Invitation zzatd;

        InvitationReceivedNotifier(Invitation invitation) {
            this.zzatd = invitation;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.zzatd);
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }
    }

    private static final class InvitationRemovedNotifier implements zzb<OnInvitationReceivedListener> {
        private final String zzate;

        InvitationRemovedNotifier(String invitationId) {
            this.zzate = invitationId;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.zzate);
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }
    }

    private static final class LeftRoomNotifier implements zzb<RoomUpdateListener> {
        private final int zzWu;
        private final String zzatg;

        LeftRoomNotifier(int statusCode, String roomId) {
            this.zzWu = statusCode;
            this.zzatg = roomId;
        }

        public void zza(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.zzWu, this.zzatg);
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((RoomUpdateListener) obj);
        }
    }

    private static final class MatchRemovedNotifier implements zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final String zzatz;

        MatchRemovedNotifier(String matchId) {
            this.zzatz = matchId;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzatz);
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }
    }

    private static final class MatchUpdateReceivedNotifier implements zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch zzatA;

        MatchUpdateReceivedNotifier(TurnBasedMatch match) {
            this.zzatA = match;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzatA);
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }
    }

    private static final class MessageReceivedNotifier implements zzb<RealTimeMessageReceivedListener> {
        private final RealTimeMessage zzatB;

        MessageReceivedNotifier(RealTimeMessage message) {
            this.zzatB = message;
        }

        public void zza(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzatB);
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((RealTimeMessageReceivedListener) obj);
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements zzb<OnNearbyPlayerDetectedListener> {
        private final Player zzatC;

        public void zza(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.zza(this.zzatC);
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((OnNearbyPlayerDetectedListener) obj);
        }
    }

    private static final class P2PConnectedNotifier implements zzb<RoomStatusUpdateListener> {
        private final String zzatI;

        P2PConnectedNotifier(String participantId) {
            this.zzatI = participantId;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.zzatI);
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }
    }

    private static final class P2PDisconnectedNotifier implements zzb<RoomStatusUpdateListener> {
        private final String zzatI;

        P2PDisconnectedNotifier(String participantId) {
            this.zzatI = participantId;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.zzatI);
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }
    }

    private static final class QuestCompletedNotifier implements zzb<QuestUpdateListener> {
        private final Quest zzasU;

        QuestCompletedNotifier(Quest quest) {
            this.zzasU = quest;
        }

        public void zza(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.zzasU);
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((QuestUpdateListener) obj);
        }
    }

    private static final class RealTimeMessageSentNotifier implements zzb<ReliableMessageSentCallback> {
        private final int zzWu;
        private final String zzatN;
        private final int zzatO;

        RealTimeMessageSentNotifier(int statusCode, int token, String recipientParticipantId) {
            this.zzWu = statusCode;
            this.zzatO = token;
            this.zzatN = recipientParticipantId;
        }

        public void zza(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.zzWu, this.zzatO, this.zzatN);
            }
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((ReliableMessageSentCallback) obj);
        }
    }

    private static final class RequestReceivedNotifier implements zzb<OnRequestReceivedListener> {
        private final GameRequest zzatQ;

        RequestReceivedNotifier(GameRequest request) {
            this.zzatQ = request;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.zzatQ);
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }
    }

    private static final class RequestRemovedNotifier implements zzb<OnRequestReceivedListener> {
        private final String zzBm;

        RequestRemovedNotifier(String requestId) {
            this.zzBm = requestId;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.zzBm);
        }

        public void zznh() {
        }

        public /* synthetic */ void zzo(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }
    }

    private static abstract class AbstractRoomNotifier extends zzd<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            zza(roomUpdateListener, GamesClientImpl.zzV(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void zza(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static abstract class AbstractRoomStatusNotifier extends zzd<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            zza(roomStatusUpdateListener, GamesClientImpl.zzV(dataHolder));
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static final class CancelMatchResultImpl implements CancelMatchResult {
        private final Status zzQA;
        private final String zzasW;

        CancelMatchResultImpl(Status status, String externalMatchId) {
            this.zzQA = status;
            this.zzasW = externalMatchId;
        }

        public String getMatchId() {
            return this.zzasW;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final Status zzQA;
        private final String zzasZ;

        DeleteSnapshotResultImpl(int statusCode, String snapshotId) {
            this.zzQA = GamesStatusCodes.zzfx(statusCode);
            this.zzasZ = snapshotId;
        }

        public String getSnapshotId() {
            return this.zzasZ;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final Status zzQA;
        private final String zzata;
        private final boolean zzatb;

        public GameMuteStatusChangeResultImpl(int statusCode, String externalGameId, boolean isMuted) {
            this.zzQA = GamesStatusCodes.zzfx(statusCode);
            this.zzata = externalGameId;
            this.zzatb = isMuted;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final Status zzQA;
        private final String zzata;
        private final boolean zzatb;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.zzQA = GamesStatusCodes.zzfx(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.zzata = dataHolder.zzd("external_game_id", 0, 0);
                    this.zzatb = dataHolder.zze("muted", 0, 0);
                } else {
                    this.zzata = null;
                    this.zzatb = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static abstract class GamesDataHolderResult extends zze {
        protected GamesDataHolderResult(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zzfx(dataHolder.getStatusCode()));
        }
    }

    private static final class InboxCountResultImpl implements InboxCountResult {
        private final Status zzQA;
        private final Bundle zzatc;

        InboxCountResultImpl(Status status, Bundle inboxCounts) {
            this.zzQA = status;
            this.zzatc = inboxCounts;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final Status zzQA;
        private final LoadMatchesResponse zzato;

        LoadMatchesResultImpl(Status status, Bundle matchData) {
            this.zzQA = status;
            this.zzato = new LoadMatchesResponse(matchData);
        }

        public LoadMatchesResponse getMatches() {
            return this.zzato;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            this.zzato.release();
        }
    }

    private static final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Status zzQA;
        private final Bundle zzatt;

        LoadRequestsResultImpl(Status status, Bundle requestData) {
            this.zzQA = status;
            this.zzatt = requestData;
        }

        public GameRequestBuffer getRequests(int requestType) {
            String zzfQ = RequestType.zzfQ(requestType);
            return !this.zzatt.containsKey(zzfQ) ? null : new GameRequestBuffer((DataHolder) this.zzatt.get(zzfQ));
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            for (String parcelable : this.zzatt.keySet()) {
                DataHolder dataHolder = (DataHolder) this.zzatt.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final Status zzQA;
        private final List<String> zzatw;
        private final Bundle zzatx;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle xpData) {
            this.zzQA = status;
            this.zzatw = xpData.getStringArrayList("game_category_list");
            this.zzatx = xpData;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final Status zzQA;
        private final String zzarS;

        UpdateAchievementResultImpl(int statusCode, String achievementId) {
            this.zzQA = GamesStatusCodes.zzfx(statusCode);
            this.zzarS = achievementId;
        }

        public String getAchievementId() {
            return this.zzarS;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> zzasT;

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder);
            this.zzasT = new ArrayList();
            for (Object add : participantIds) {
                this.zzasT.add(add);
            }
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            zza(roomStatusUpdateListener, room, this.zzasT);
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static final class AcceptQuestResultImpl extends GamesDataHolderResult implements AcceptQuestResult {
        private final Quest zzasU;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzasU = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.zzasU = null;
                }
                questBuffer.release();
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public Quest getQuest() {
            return this.zzasU;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<UpdateAchievementResult> zzQz;

        AchievementUpdatedBinderCallback(zzc.zzb<UpdateAchievementResult> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzg(int i, String str) {
            this.zzQz.zzn(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadAchievementsResult> zzQz;

        AchievementsLoadedBinderCallback(zzc.zzb<LoadAchievementsResult> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzf(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadAppContentResult> zzasV;

        public AppContentLoadedBinderCallbacks(zzc.zzb<LoadAppContentResult> resultHolder) {
            this.zzasV = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder[] dataHolderArr) {
            this.zzasV.zzn(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class ClaimMilestoneResultImpl extends GamesDataHolderResult implements ClaimMilestoneResult {
        private final Quest zzasU;
        private final Milestone zzasX;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String milestoneId) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzasU = new QuestEntity((Quest) questBuffer.get(0));
                    List zzuZ = this.zzasU.zzuZ();
                    int size = zzuZ.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) zzuZ.get(i)).getMilestoneId().equals(milestoneId)) {
                            this.zzasX = (Milestone) zzuZ.get(i);
                            return;
                        }
                    }
                    this.zzasX = null;
                } else {
                    this.zzasX = null;
                    this.zzasU = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public Milestone getMilestone() {
            return this.zzasX;
        }

        public Quest getQuest() {
            return this.zzasU;
        }
    }

    private static final class CommitSnapshotResultImpl extends GamesDataHolderResult implements CommitSnapshotResult {
        private final SnapshotMetadata zzasY;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzasY = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.zzasY = null;
                }
                snapshotMetadataBuffer.release();
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.zzasY;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends GamesDataHolderResult implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<ContactSettingLoadResult> zzQz;

        ContactSettingsLoadedBinderCallback(zzc.zzb<ContactSettingLoadResult> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzG(DataHolder dataHolder) {
            this.zzQz.zzn(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<Status> zzQz;

        ContactSettingsUpdatedBinderCallback(zzc.zzb<Status> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzfJ(int i) {
            this.zzQz.zzn(GamesStatusCodes.zzfx(i));
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadEventsResult> zzQz;

        EventsLoadedBinderCallback(zzc.zzb<LoadEventsResult> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzg(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadEventResultImpl(dataHolder));
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadGameInstancesResult> zzQz;

        GameInstancesLoadedBinderCallback(zzc.zzb<LoadGameInstancesResult> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzn(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<GameMuteStatusChangeResult> zzQz;

        GameMuteStatusChangedBinderCallback(zzc.zzb<GameMuteStatusChangeResult> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zza(int i, String str, boolean z) {
            this.zzQz.zzn(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<GameMuteStatusLoadResult> zzQz;

        GameMuteStatusLoadedBinderCallback(zzc.zzb<GameMuteStatusLoadResult> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzE(DataHolder dataHolder) {
            this.zzQz.zzn(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadGameSearchSuggestionsResult> zzQz;

        GameSearchSuggestionsLoadedBinderCallback(zzc.zzb<LoadGameSearchSuggestionsResult> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzo(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadGamesResult> zzQz;

        GamesLoadedBinderCallback(zzc.zzb<LoadGamesResult> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzl(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<InboxCountResult> zzQz;

        InboxCountsLoadedBinderCallback(zzc.zzb<InboxCountResult> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzg(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzQz.zzn(new InboxCountResultImpl(GamesStatusCodes.zzfx(i), bundle));
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzl<OnInvitationReceivedListener> zzaiL;

        InvitationReceivedBinderCallback(zzl<OnInvitationReceivedListener> listener) {
            this.zzaiL = listener;
        }

        public void onInvitationRemoved(String invitationId) {
            this.zzaiL.zza(new InvitationRemovedNotifier(invitationId));
        }

        public void zzq(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.release();
                if (invitation != null) {
                    this.zzaiL.zza(new InvitationReceivedNotifier(invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.release();
            }
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadInvitationsResult> zzQz;

        InvitationsLoadedBinderCallback(zzc.zzb<LoadInvitationsResult> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzp(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends GamesDataHolderResult implements LeaderboardMetadataResult {
        private final LeaderboardBuffer zzatf;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzatf = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.zzatf;
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadScoresResult> zzQz;

        LeaderboardScoresLoadedBinderCallback(zzc.zzb<LoadScoresResult> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            this.zzQz.zzn(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LeaderboardMetadataResult> zzQz;

        LeaderboardsLoadedBinderCallback(zzc.zzb<LeaderboardMetadataResult> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzh(DataHolder dataHolder) {
            this.zzQz.zzn(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LoadAchievementsResultImpl extends GamesDataHolderResult implements LoadAchievementsResult {
        private final AchievementBuffer zzath;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzath = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.zzath;
        }
    }

    private static final class LoadAclResultImpl extends GamesDataHolderResult implements LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadAppContentsResultImpl extends GamesDataHolderResult implements LoadAppContentResult {
        private final ArrayList<DataHolder> zzati;

        LoadAppContentsResultImpl(DataHolder[] appContentData) {
            super(appContentData[0]);
            this.zzati = new ArrayList(Arrays.asList(appContentData));
        }
    }

    private static final class LoadEventResultImpl extends GamesDataHolderResult implements LoadEventsResult {
        private final EventBuffer zzatj;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzatj = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.zzatj;
        }
    }

    private static final class LoadGameInstancesResultImpl extends GamesDataHolderResult implements LoadGameInstancesResult {
        private final GameInstanceBuffer zzatk;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzatk = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult implements LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer zzatl;

        LoadGameSearchSuggestionsResultImpl(DataHolder data) {
            super(data);
            this.zzatl = new GameSearchSuggestionBuffer(data);
        }
    }

    private static final class LoadGamesResultImpl extends GamesDataHolderResult implements LoadGamesResult {
        private final GameBuffer zzatm;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzatm = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.zzatm;
        }
    }

    private static final class LoadInvitationsResultImpl extends GamesDataHolderResult implements LoadInvitationsResult {
        private final InvitationBuffer zzatn;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzatn = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.zzatn;
        }
    }

    private static final class LoadPlayerScoreResultImpl extends GamesDataHolderResult implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzatp;

        LoadPlayerScoreResultImpl(DataHolder scoreHolder) {
            super(scoreHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzatp = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.zzatp = null;
                }
                leaderboardScoreBuffer.release();
            } catch (Throwable th) {
                leaderboardScoreBuffer.release();
            }
        }

        public LeaderboardScore getScore() {
            return this.zzatp;
        }
    }

    private static final class LoadPlayerStatsResultImpl extends GamesDataHolderResult implements LoadPlayerStatsResult {
        private final PlayerStats zzatq;

        LoadPlayerStatsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                if (playerStatsBuffer.getCount() > 0) {
                    this.zzatq = new PlayerStatsEntity(playerStatsBuffer.zzgp(0));
                } else {
                    this.zzatq = null;
                }
                playerStatsBuffer.release();
            } catch (Throwable th) {
                playerStatsBuffer.release();
            }
        }
    }

    private static final class LoadPlayersResultImpl extends GamesDataHolderResult implements LoadPlayersResult {
        private final PlayerBuffer zzatr;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzatr = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.zzatr;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends GamesDataHolderResult implements LoadProfileSettingsResult {
        private final boolean zzasG;
        private final boolean zzats;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int zzbo = dataHolder.zzbo(0);
                    this.zzasG = dataHolder.zze("profile_visible", 0, zzbo);
                    this.zzats = dataHolder.zze("profile_visibility_explicitly_set", 0, zzbo);
                } else {
                    this.zzasG = true;
                    this.zzats = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public boolean isProfileVisible() {
            return this.zzasG;
        }

        public boolean isVisibilityExplicitlySet() {
            return this.zzats;
        }
    }

    private static final class LoadQuestsResultImpl extends GamesDataHolderResult implements LoadQuestsResult {
        private final DataHolder zzYX;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzYX = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.zzYX);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends GamesDataHolderResult implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadScoresResultImpl extends GamesDataHolderResult implements LoadScoresResult {
        private final LeaderboardEntity zzatu;
        private final LeaderboardScoreBuffer zzatv;

        LoadScoresResultImpl(DataHolder leaderboard, DataHolder scores) {
            super(scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzatu = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.zzatu = null;
                }
                leaderboardBuffer.release();
                this.zzatv = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.release();
            }
        }

        public Leaderboard getLeaderboard() {
            return this.zzatu;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.zzatv;
        }
    }

    private static final class LoadSnapshotsResultImpl extends GamesDataHolderResult implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.zzYX);
        }
    }

    private static final class LoadXpStreamResultImpl extends GamesDataHolderResult implements LoadXpStreamResult {
        private final ExperienceEventBuffer zzaty;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaty = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzl<OnTurnBasedMatchUpdateReceivedListener> zzaiL;

        MatchUpdateReceivedBinderCallback(zzl<OnTurnBasedMatchUpdateReceivedListener> listener) {
            this.zzaiL = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.zzaiL.zza(new MatchRemovedNotifier(matchId));
        }

        public void zzw(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.release();
                if (turnBasedMatch != null) {
                    this.zzaiL.zza(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadAclResult> zzQz;

        NotifyAclLoadedBinderCallback(zzc.zzb<LoadAclResult> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzF(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadAclResultImpl(dataHolder));
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<Status> zzQz;

        NotifyAclUpdatedBinderCallback(zzc.zzb<Status> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzfI(int i) {
            this.zzQz.zzn(GamesStatusCodes.zzfx(i));
        }
    }

    private static final class OpenSnapshotResultImpl extends GamesDataHolderResult implements OpenSnapshotResult {
        private final Snapshot zzatD;
        private final String zzatE;
        private final Snapshot zzatF;
        private final Contents zzatG;
        private final SnapshotContents zzatH;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents currentContents) {
            this(dataHolder, null, currentContents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder metadataHolder, String conflictId, Contents currentContents, Contents conflictContents, Contents resolutionContents) {
            boolean z = true;
            super(metadataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(metadataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzatD = null;
                    this.zzatF = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (metadataHolder.getStatusCode() == WearableStatusCodes.INVALID_TARGET_NODE) {
                        z = false;
                    }
                    com.google.android.gms.common.internal.zzb.zzY(z);
                    this.zzatD = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzatF = null;
                } else {
                    this.zzatD = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzatF = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(conflictContents));
                }
                snapshotMetadataBuffer.release();
                this.zzatE = conflictId;
                this.zzatG = resolutionContents;
                this.zzatH = new SnapshotContentsEntity(resolutionContents);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public String getConflictId() {
            return this.zzatE;
        }

        public Snapshot getConflictingSnapshot() {
            return this.zzatF;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzatH;
        }

        public Snapshot getSnapshot() {
            return this.zzatD;
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadPlayerScoreResult> zzQz;

        PlayerLeaderboardScoreLoadedBinderCallback(zzc.zzb<LoadPlayerScoreResult> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzH(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerStatsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadPlayerStatsResult> zzQz;

        public PlayerStatsLoadedBinderCallbacks(zzc.zzb<LoadPlayerStatsResult> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzU(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadPlayerStatsResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadXpForGameCategoriesResult> zzQz;

        PlayerXpForGameCategoriesLoadedBinderCallback(zzc.zzb<LoadXpForGameCategoriesResult> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzf(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzQz.zzn(new LoadXpForGameCategoriesResultImpl(GamesStatusCodes.zzfx(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadXpStreamResult> zzQz;

        PlayerXpStreamLoadedBinderCallback(zzc.zzb<LoadXpStreamResult> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzS(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadPlayersResult> zzQz;

        PlayersLoadedBinderCallback(zzc.zzb<LoadPlayersResult> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzj(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadPlayersResultImpl(dataHolder));
        }

        public void zzk(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private static final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient {
        private final PopupManager zzasN;

        public PopupLocationInfoBinderCallbacks(PopupManager popupManager) {
            this.zzasN = popupManager;
        }

        public PopupLocationInfoParcelable zztC() {
            return new PopupLocationInfoParcelable(this.zzasN.zzus());
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadProfileSettingsResult> zzQz;

        ProfileSettingsLoadedBinderCallback(zzc.zzb<LoadProfileSettingsResult> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzT(DataHolder dataHolder) {
            this.zzQz.zzn(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzc.zzb<Status> zzQz;

        ProfileSettingsUpdatedBinderCallback(zzc.zzb<Status> holder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzfK(int i) {
            this.zzQz.zzn(GamesStatusCodes.zzfx(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<AcceptQuestResult> zzatJ;

        public QuestAcceptedBinderCallbacks(zzc.zzb<AcceptQuestResult> resultHolder) {
            this.zzatJ = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzO(DataHolder dataHolder) {
            this.zzatJ.zzn(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<ClaimMilestoneResult> zzatK;
        private final String zzatL;

        public QuestMilestoneClaimBinderCallbacks(zzc.zzb<ClaimMilestoneResult> resultHolder, String milestoneId) {
            this.zzatK = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
            this.zzatL = (String) zzx.zzb((Object) milestoneId, (Object) "MilestoneId must not be null");
        }

        public void zzN(DataHolder dataHolder) {
            this.zzatK.zzn(new ClaimMilestoneResultImpl(dataHolder, this.zzatL));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final zzl<QuestUpdateListener> zzaiL;

        QuestUpdateBinderCallback(zzl<QuestUpdateListener> listener) {
            this.zzaiL = listener;
        }

        private Quest zzX(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.release();
                return quest;
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public void zzP(DataHolder dataHolder) {
            Quest zzX = zzX(dataHolder);
            if (zzX != null) {
                this.zzaiL.zza(new QuestCompletedNotifier(zzX));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadQuestsResult> zzatM;

        public QuestsLoadedBinderCallbacks(zzc.zzb<LoadQuestsResult> resultHolder) {
            this.zzatM = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzR(DataHolder dataHolder) {
            this.zzatM.zzn(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final zzl<ReliableMessageSentCallback> zzatP;

        public RealTimeReliableMessageBinderCallbacks(zzl<ReliableMessageSentCallback> messageSentCallbacks) {
            this.zzatP = messageSentCallbacks;
        }

        public void zzb(int i, int i2, String str) {
            if (this.zzatP != null) {
                this.zzatP.zza(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzl<OnRequestReceivedListener> zzaiL;

        RequestReceivedBinderCallback(zzl<OnRequestReceivedListener> listener) {
            this.zzaiL = listener;
        }

        public void onRequestRemoved(String requestId) {
            this.zzaiL.zza(new RequestRemovedNotifier(requestId));
        }

        public void zzr(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.release();
                if (gameRequest != null) {
                    this.zzaiL.zza(new RequestReceivedNotifier(gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<SendRequestResult> zzatR;

        public RequestSentBinderCallbacks(zzc.zzb<SendRequestResult> resultHolder) {
            this.zzatR = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzJ(DataHolder dataHolder) {
            this.zzatR.zzn(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadRequestSummariesResult> zzatS;

        public RequestSummariesLoadedBinderCallbacks(zzc.zzb<LoadRequestSummariesResult> resultHolder) {
            this.zzatS = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzK(DataHolder dataHolder) {
            this.zzatS.zzn(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadRequestsResult> zzatT;

        public RequestsLoadedBinderCallbacks(zzc.zzb<LoadRequestsResult> resultHolder) {
            this.zzatT = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzd(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzatT.zzn(new LoadRequestsResultImpl(GamesStatusCodes.zzfx(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<UpdateRequestsResult> zzatU;

        public RequestsUpdatedBinderCallbacks(zzc.zzb<UpdateRequestsResult> resultHolder) {
            this.zzatU = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzI(DataHolder dataHolder) {
            this.zzatU.zzn(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final zzl<? extends RoomUpdateListener> zzatV;
        private final zzl<? extends RoomStatusUpdateListener> zzatW;
        private final zzl<RealTimeMessageReceivedListener> zzatX;

        public RoomBinderCallbacks(zzl<RoomUpdateListener> roomCallbacks) {
            this.zzatV = (zzl) zzx.zzb((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.zzatW = null;
            this.zzatX = null;
        }

        public RoomBinderCallbacks(zzl<? extends RoomUpdateListener> roomCallbacks, zzl<? extends RoomStatusUpdateListener> roomStatusCallbacks, zzl<RealTimeMessageReceivedListener> realTimeMessageReceivedCallbacks) {
            this.zzatV = (zzl) zzx.zzb((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.zzatW = roomStatusCallbacks;
            this.zzatX = realTimeMessageReceivedCallbacks;
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.zzatV.zza(new LeftRoomNotifier(statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            if (this.zzatW != null) {
                this.zzatW.zza(new P2PConnectedNotifier(participantId));
            }
        }

        public void onP2PDisconnected(String participantId) {
            if (this.zzatW != null) {
                this.zzatW.zza(new P2PDisconnectedNotifier(participantId));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            if (this.zzatX != null) {
                this.zzatX.zza(new MessageReceivedNotifier(message));
            }
        }

        public void zzA(DataHolder dataHolder) {
            if (this.zzatW != null) {
                this.zzatW.zza(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        public void zzB(DataHolder dataHolder) {
            this.zzatV.zza(new RoomConnectedNotifier(dataHolder));
        }

        public void zzC(DataHolder dataHolder) {
            if (this.zzatW != null) {
                this.zzatW.zza(new ConnectedToRoomNotifier(dataHolder));
            }
        }

        public void zzD(DataHolder dataHolder) {
            if (this.zzatW != null) {
                this.zzatW.zza(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        public void zza(DataHolder dataHolder, String[] strArr) {
            if (this.zzatW != null) {
                this.zzatW.zza(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzb(DataHolder dataHolder, String[] strArr) {
            if (this.zzatW != null) {
                this.zzatW.zza(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzc(DataHolder dataHolder, String[] strArr) {
            if (this.zzatW != null) {
                this.zzatW.zza(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzd(DataHolder dataHolder, String[] strArr) {
            if (this.zzatW != null) {
                this.zzatW.zza(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        public void zze(DataHolder dataHolder, String[] strArr) {
            if (this.zzatW != null) {
                this.zzatW.zza(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzf(DataHolder dataHolder, String[] strArr) {
            if (this.zzatW != null) {
                this.zzatW.zza(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzx(DataHolder dataHolder) {
            this.zzatV.zza(new RoomCreatedNotifier(dataHolder));
        }

        public void zzy(DataHolder dataHolder) {
            this.zzatV.zza(new JoinedRoomNotifier(dataHolder));
        }

        public void zzz(DataHolder dataHolder) {
            if (this.zzatW != null) {
                this.zzatW.zza(new RoomConnectingNotifier(dataHolder));
            }
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendRequestResultImpl extends GamesDataHolderResult implements SendRequestResult {
        private final GameRequest zzatQ;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.zzatQ = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.zzatQ = null;
                }
                gameRequestBuffer.release();
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<Status> zzQz;

        public SignOutCompleteBinderCallbacks(zzc.zzb<Status> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzll() {
            this.zzQz.zzn(GamesStatusCodes.zzfx(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<CommitSnapshotResult> zzatY;

        public SnapshotCommittedBinderCallbacks(zzc.zzb<CommitSnapshotResult> resultHolder) {
            this.zzatY = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzM(DataHolder dataHolder) {
            this.zzatY.zzn(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<DeleteSnapshotResult> zzQz;

        public SnapshotDeletedBinderCallbacks(zzc.zzb<DeleteSnapshotResult> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzi(int i, String str) {
            this.zzQz.zzn(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<OpenSnapshotResult> zzatZ;

        public SnapshotOpenedBinderCallbacks(zzc.zzb<OpenSnapshotResult> resultHolder) {
            this.zzatZ = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, Contents contents) {
            this.zzatZ.zzn(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        public void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.zzatZ.zzn(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadSnapshotsResult> zzaua;

        public SnapshotsLoadedBinderCallbacks(zzc.zzb<LoadSnapshotsResult> resultHolder) {
            this.zzaua = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzL(DataHolder dataHolder) {
            this.zzaua.zzn(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<SubmitScoreResult> zzQz;

        public SubmitScoreBinderCallbacks(zzc.zzb<SubmitScoreResult> resultHolder) {
            this.zzQz = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzi(DataHolder dataHolder) {
            this.zzQz.zzn(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends GamesDataHolderResult implements SubmitScoreResult {
        private final ScoreSubmissionData zzaub;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzaub = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.zzaub;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<CancelMatchResult> zzauc;

        public TurnBasedMatchCanceledBinderCallbacks(zzc.zzb<CancelMatchResult> resultHolder) {
            this.zzauc = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzh(int i, String str) {
            this.zzauc.zzn(new CancelMatchResultImpl(GamesStatusCodes.zzfx(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<InitiateMatchResult> zzaud;

        public TurnBasedMatchInitiatedBinderCallbacks(zzc.zzb<InitiateMatchResult> resultHolder) {
            this.zzaud = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzt(DataHolder dataHolder) {
            this.zzaud.zzn(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<LeaveMatchResult> zzaue;

        public TurnBasedMatchLeftBinderCallbacks(zzc.zzb<LeaveMatchResult> resultHolder) {
            this.zzaue = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzv(DataHolder dataHolder) {
            this.zzaue.zzn(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadMatchResult> zzauf;

        public TurnBasedMatchLoadedBinderCallbacks(zzc.zzb<LoadMatchResult> resultHolder) {
            this.zzauf = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzs(DataHolder dataHolder) {
            this.zzauf.zzn(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static abstract class TurnBasedMatchResult extends GamesDataHolderResult {
        final TurnBasedMatch zzatA;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.zzatA = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.zzatA = null;
                }
                turnBasedMatchBuffer.release();
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.zzatA;
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<UpdateMatchResult> zzaug;

        public TurnBasedMatchUpdatedBinderCallbacks(zzc.zzb<UpdateMatchResult> resultHolder) {
            this.zzaug = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzu(DataHolder dataHolder) {
            this.zzaug.zzn(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzc.zzb<LoadMatchesResult> zzauh;

        public TurnBasedMatchesLoadedBinderCallbacks(zzc.zzb<LoadMatchesResult> resultHolder) {
            this.zzauh = (zzc.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzc(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzauh.zzn(new LoadMatchesResultImpl(GamesStatusCodes.zzfx(i), bundle));
        }
    }

    private static final class UpdateRequestsResultImpl extends GamesDataHolderResult implements UpdateRequestsResult {
        private final RequestUpdateOutcomes zzaui;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaui = RequestUpdateOutcomes.zzY(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.zzaui.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.zzaui.getRequestOutcome(requestId);
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    public GamesClientImpl(Context context, Looper looper, zzf clientSettings, GamesOptions options, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
        super(context, looper, 1, clientSettings, connectedListener, connectionFailedListener);
        this.zzasJ = new C07411(this);
        this.zzasO = false;
        this.zzasK = clientSettings.zzol();
        this.zzasP = new Binder();
        this.zzasN = PopupManager.zza(this, clientSettings.zzoh());
        zzm(clientSettings.zzon());
        this.zzasQ = (long) hashCode();
        this.zzasR = options;
    }

    private static Room zzV(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.release();
            return room;
        } catch (Throwable th) {
            roomBuffer.release();
        }
    }

    private void zzb(RemoteException remoteException) {
        GamesLog.zzb("GamesClientImpl", "service died", remoteException);
    }

    private void zztF() {
        this.zzasL = null;
        this.zzasM = null;
    }

    public void disconnect() {
        this.zzasO = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) zzoA();
                iGamesService.zzud();
                this.zzasJ.flush();
                iGamesService.zzE(this.zzasQ);
            } catch (RemoteException e) {
                GamesLog.zzw("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public void onConnectionFailed(ConnectionResult result) {
        super.onConnectionFailed(result);
        this.zzasO = false;
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzbN(iBinder);
    }

    public int zza(zzl<ReliableMessageSentCallback> com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) zzoA()).zza(new RealTimeReliableMessageBinderCallbacks(com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zza(byte[] bArr, String str, String[] strArr) {
        zzx.zzb((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) zzoA()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent zza = ((IGamesService) zzoA()).zza(i, bArr, i2, str);
            zzx.zzb((Object) bitmap, (Object) "Must provide a non null icon");
            zza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return zza;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(PlayerEntity playerEntity) {
        try {
            return ((IGamesService) zzoA()).zza(playerEntity);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(Room room, int i) {
        try {
            return ((IGamesService) zzoA()).zza((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) zzoA()).zza(str, z, z2, i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    protected Set<Scope> zza(Set<Scope> set) {
        Scope scope = new Scope(Scopes.GAMES);
        Scope scope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        int i = 0;
        boolean z = false;
        for (Scope scope3 : set) {
            int i2;
            boolean z2;
            if (scope3.equals(scope)) {
                i2 = i;
                z2 = true;
            } else if (scope3.equals(scope2)) {
                i2 = 1;
                z2 = z;
            } else {
                i2 = i;
                z2 = z;
            }
            z = z2;
            i = i2;
        }
        if (i != 0) {
            zzx.zza(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzx.zza(z, "Games APIs requires %s to function.", Scopes.GAMES);
        }
        return set;
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.zzasO = bundle.getBoolean("show_welcome_popup");
            this.zzasL = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzasM = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) zzoA()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public void zza(zza com_google_android_gms_common_api_GoogleApiClient_zza) {
        zztF();
        super.zza(com_google_android_gms_common_api_GoogleApiClient_zza);
    }

    public void zza(zzc.zzb<LoadRequestsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzoA()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), i, i2, i3);
    }

    public void zza(zzc.zzb<LoadAppContentResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult, int i, String str, String[] strArr, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zza(new AppContentLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult), i, str, strArr, z);
    }

    public void zza(zzc.zzb<LoadPlayersResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzoA()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zza(zzc.zzb<LoadMatchesResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzoA()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), i, iArr);
    }

    public void zza(zzc.zzb<LoadScoresResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        ((IGamesService) zzoA()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), leaderboardScoreBuffer.zzuR().asBundle(), i, i2);
    }

    public void zza(zzc.zzb<InitiateMatchResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        ((IGamesService) zzoA()).zza(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzuX(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
    }

    public void zza(zzc.zzb<CommitSnapshotResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        BitmapTeleporter zzvc = snapshotMetadataChange.zzvc();
        if (zzvc != null) {
            zzvc.zzc(getContext().getCacheDir());
        }
        Contents zzqh = snapshotContents.zzqh();
        snapshotContents.close();
        ((IGamesService) zzoA()).zza(new SnapshotCommittedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzqh);
    }

    public void zza(zzc.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zzoA()).zza(iGamesCallbacks, str, this.zzasN.zzur(), this.zzasN.zzuq());
    }

    public void zza(zzc.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) throws RemoteException {
        ((IGamesService) zzoA()).zza(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzasN.zzur(), this.zzasN.zzuq());
    }

    public void zza(zzc.zzb<LoadScoresResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zza(zzc.zzb<LoadPlayersResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                ((IGamesService) zzoA()).zzd(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zzc.zzb<LoadMatchesResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, String str, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzoA()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), str, i, iArr);
    }

    public void zza(zzc.zzb<SubmitScoreResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult, String str, long j, String str2) throws RemoteException {
        ((IGamesService) zzoA()).zza(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult == null ? null : new SubmitScoreBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult), str, j, str2);
    }

    public void zza(zzc.zzb<LeaveMatchResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzoA()).zzc(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str, str2);
    }

    public void zza(zzc.zzb<LoadPlayerScoreResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult, String str, String str2, int i, int i2) throws RemoteException {
        ((IGamesService) zzoA()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult), str, str2, i, i2);
    }

    public void zza(zzc.zzb<LoadRequestsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, String str, String str2, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzoA()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), str, str2, i, i2, i3);
    }

    public void zza(zzc.zzb<LoadScoresResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zza(zzc.zzb<LoadPlayersResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    obj = 2;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    obj = 1;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
            case CompletionEvent.STATUS_FAILURE /*1*/:
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                ((IGamesService) zzoA()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zzc.zzb<OpenSnapshotResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        zzx.zza(!snapshotContents.isClosed(), (Object) "SnapshotContents already closed");
        BitmapTeleporter zzvc = snapshotMetadataChange.zzvc();
        if (zzvc != null) {
            zzvc.zzc(getContext().getCacheDir());
        }
        Contents zzqh = snapshotContents.zzqh();
        snapshotContents.close();
        ((IGamesService) zzoA()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzqh);
    }

    public void zza(zzc.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, str2, z);
    }

    public void zza(zzc.zzb<LoadQuestsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, boolean z, String[] strArr) throws RemoteException {
        this.zzasJ.flush();
        ((IGamesService) zzoA()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, strArr, z);
    }

    public void zza(zzc.zzb<LoadQuestsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzasJ.flush();
        ((IGamesService) zzoA()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, iArr, i, z);
    }

    public void zza(zzc.zzb<UpdateRequestsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String str, String str2, String[] strArr) throws RemoteException {
        ((IGamesService) zzoA()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), str, str2, strArr);
    }

    public void zza(zzc.zzb<LoadPlayersResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzf(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, z);
    }

    public void zza(zzc.zzb<OpenSnapshotResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, boolean z, int i) throws RemoteException {
        ((IGamesService) zzoA()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, z, i);
    }

    public void zza(zzc.zzb<UpdateMatchResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzoA()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, str2, participantResultArr);
    }

    public void zza(zzc.zzb<UpdateMatchResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzoA()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, participantResultArr);
    }

    public void zza(zzc.zzb<SendRequestResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_SendRequestResult, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
        ((IGamesService) zzoA()).zza(new RequestSentBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_SendRequestResult), str, strArr, i, bArr, i2);
    }

    public void zza(zzc.zzb<LoadPlayersResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult), z);
    }

    public void zza(zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, boolean z, Bundle bundle) throws RemoteException {
        ((IGamesService) zzoA()).zza(new ContactSettingsUpdatedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status), z, bundle);
    }

    public void zza(zzc.zzb<LoadEventsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z, String... strArr) throws RemoteException {
        this.zzasJ.flush();
        ((IGamesService) zzoA()).zza(new EventsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z, strArr);
    }

    public void zza(zzc.zzb<LoadQuestsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzasJ.flush();
        ((IGamesService) zzoA()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), iArr, i, z);
    }

    public void zza(zzc.zzb<LoadPlayersResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzoA()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult), strArr);
    }

    public void zza(zzl<OnInvitationReceivedListener> com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener) {
        try {
            ((IGamesService) zzoA()).zza(new InvitationReceivedBinderCallback(com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener), this.zzasQ);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzl<RoomUpdateListener> com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zzl<RoomStatusUpdateListener> com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zzl<RealTimeMessageReceivedListener> com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzoA()).zza(new RoomBinderCallbacks(com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzasP, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzasQ);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzl<RoomUpdateListener> com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, String str) {
        try {
            ((IGamesService) zzoA()).zzc(new RoomBinderCallbacks(com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener), str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        Contents zzqh = snapshotContents.zzqh();
        snapshotContents.close();
        try {
            ((IGamesService) zzoA()).zza(zzqh);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzb(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzoA()).zzb(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzb(int[] iArr) {
        try {
            return ((IGamesService) zzoA()).zzb(iArr);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzb(zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        this.zzasJ.flush();
        ((IGamesService) zzoA()).zza(new SignOutCompleteBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status));
    }

    public void zzb(zzc.zzb<LoadPlayersResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzoA()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzb(zzc.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zzoA()).zzb(iGamesCallbacks, str, this.zzasN.zzur(), this.zzasN.zzuq());
    }

    public void zzb(zzc.zzb<UpdateAchievementResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) throws RemoteException {
        ((IGamesService) zzoA()).zzb(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzasN.zzur(), this.zzasN.zzuq());
    }

    public void zzb(zzc.zzb<LoadScoresResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zzb(zzc.zzb<LoadPlayersResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzoA()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
    }

    public void zzb(zzc.zzb<ClaimMilestoneResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, String str, String str2) throws RemoteException {
        this.zzasJ.flush();
        ((IGamesService) zzoA()).zzf(new QuestMilestoneClaimBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, str2), str, str2);
    }

    public void zzb(zzc.zzb<LoadScoresResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zzb(zzc.zzb<LoadPlayersResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzoA()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
    }

    public void zzb(zzc.zzb<LoadAchievementsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), str, str2, z);
    }

    public void zzb(zzc.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzc(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzb(zzc.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), z);
    }

    public void zzb(zzc.zzb<LoadQuestsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, boolean z, String[] strArr) throws RemoteException {
        this.zzasJ.flush();
        ((IGamesService) zzoA()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), strArr, z);
    }

    public void zzb(zzc.zzb<UpdateRequestsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzoA()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzb(zzl<OnTurnBasedMatchUpdateReceivedListener> com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener) {
        try {
            ((IGamesService) zzoA()).zzb(new MatchUpdateReceivedBinderCallback(com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener), this.zzasQ);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(zzl<RoomUpdateListener> com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zzl<RoomStatusUpdateListener> com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zzl<RealTimeMessageReceivedListener> com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzoA()).zza(new RoomBinderCallbacks(com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_common_api_zzl_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzasP, roomConfig.getInvitationId(), false, this.zzasQ);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    protected IGamesService zzbN(IBinder iBinder) {
        return Stub.zzbQ(iBinder);
    }

    public Intent zzc(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzoA()).zzc(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzc(zzc.zzb<LoadInvitationsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, int i) throws RemoteException {
        ((IGamesService) zzoA()).zza(new InvitationsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), i);
    }

    public void zzc(zzc.zzb<LoadPlayersResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzoA()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzc(zzc.zzb<InitiateMatchResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) throws RemoteException {
        ((IGamesService) zzoA()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzc(zzc.zzb<LoadXpStreamResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) throws RemoteException {
        ((IGamesService) zzoA()).zzb(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzc(zzc.zzb<InitiateMatchResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzoA()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzc(zzc.zzb<LoadSnapshotsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzc(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), str, str2, z);
    }

    public void zzc(zzc.zzb<LeaderboardMetadataResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzd(new LeaderboardsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzc(zzc.zzb<LoadAchievementsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), z);
    }

    public void zzc(zzc.zzb<UpdateRequestsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzoA()).zzb(new RequestsUpdatedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzc(zzl<QuestUpdateListener> com_google_android_gms_common_api_zzl_com_google_android_gms_games_quest_QuestUpdateListener) {
        try {
            ((IGamesService) zzoA()).zzd(new QuestUpdateBinderCallback(com_google_android_gms_common_api_zzl_com_google_android_gms_games_quest_QuestUpdateListener), this.zzasQ);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzcX(String str) {
        try {
            ((IGamesService) zzoA()).zzdf(str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzcY(String str) {
        try {
            return ((IGamesService) zzoA()).zzcY(str);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzcZ(String str) {
        try {
            ((IGamesService) zzoA()).zza(str, this.zzasN.zzur(), this.zzasN.zzuq());
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public int zzd(byte[] bArr, String str) {
        try {
            return ((IGamesService) zzoA()).zzb(bArr, str, null);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzd(zzc.zzb<LoadPlayersResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzoA()).zze(new PlayersLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzd(zzc.zzb<InitiateMatchResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) throws RemoteException {
        ((IGamesService) zzoA()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzd(zzc.zzb<LoadXpStreamResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) throws RemoteException {
        ((IGamesService) zzoA()).zzc(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzd(zzc.zzb<InitiateMatchResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzoA()).zze(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzd(zzc.zzb<GameMuteStatusChangeResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zza(new GameMuteStatusChangedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult), str, z);
    }

    public void zzd(zzc.zzb<LoadEventsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z) throws RemoteException {
        this.zzasJ.flush();
        ((IGamesService) zzoA()).zzf(new EventsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z);
    }

    public void zzd(zzl<OnRequestReceivedListener> com_google_android_gms_common_api_zzl_com_google_android_gms_games_request_OnRequestReceivedListener) {
        try {
            ((IGamesService) zzoA()).zzc(new RequestReceivedBinderCallback(com_google_android_gms_common_api_zzl_com_google_android_gms_games_request_OnRequestReceivedListener), this.zzasQ);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zze(zzc.zzb<LeaveMatchResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str) throws RemoteException {
        ((IGamesService) zzoA()).zzo(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str);
    }

    public void zze(zzc.zzb<LoadInvitationsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str, int i) throws RemoteException {
        ((IGamesService) zzoA()).zzb(new InvitationsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str, i, false);
    }

    public void zze(zzc.zzb<LoadPlayerStatsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_stats_Stats_LoadPlayerStatsResult, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzi(new PlayerStatsLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_stats_Stats_LoadPlayerStatsResult), z);
    }

    public void zzf(zzc.zzb<LoadGamesResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult) throws RemoteException {
        ((IGamesService) zzoA()).zzd(new GamesLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult));
    }

    public void zzf(zzc.zzb<CancelMatchResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult, String str) throws RemoteException {
        ((IGamesService) zzoA()).zzn(new TurnBasedMatchCanceledBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult), str);
    }

    public void zzf(zzc.zzb<LoadRequestSummariesResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult, String str, int i) throws RemoteException {
        ((IGamesService) zzoA()).zza(new RequestSummariesLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult), str, i);
    }

    public void zzf(zzc.zzb<LoadSnapshotsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzd(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), z);
    }

    protected String zzfA() {
        return "com.google.android.gms.games.service.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void zzfM(int i) {
        this.zzasN.setGravity(i);
    }

    public void zzfN(int i) {
        try {
            ((IGamesService) zzoA()).zzfN(i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzg(zzc.zzb<LoadAclResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult) throws RemoteException {
        ((IGamesService) zzoA()).zzh(new NotifyAclLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult));
    }

    public void zzg(zzc.zzb<LoadMatchResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult, String str) throws RemoteException {
        ((IGamesService) zzoA()).zzp(new TurnBasedMatchLoadedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult), str);
    }

    public void zzg(zzc.zzb<LoadProfileSettingsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzg(new ProfileSettingsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult), z);
    }

    public void zzh(zzc.zzb<InboxCountResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Notifications_InboxCountResult) throws RemoteException {
        ((IGamesService) zzoA()).zzt(new InboxCountsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Notifications_InboxCountResult), null);
    }

    public void zzh(zzc.zzb<AcceptQuestResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult, String str) throws RemoteException {
        this.zzasJ.flush();
        ((IGamesService) zzoA()).zzu(new QuestAcceptedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult), str);
    }

    public void zzh(zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zzh(new ProfileSettingsUpdatedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status), z);
    }

    public void zzi(zzc.zzb<DeleteSnapshotResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult, String str) throws RemoteException {
        ((IGamesService) zzoA()).zzr(new SnapshotDeletedBinderCallbacks(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult), str);
    }

    public void zzi(zzc.zzb<ContactSettingLoadResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult, boolean z) throws RemoteException {
        ((IGamesService) zzoA()).zze(new ContactSettingsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult), z);
    }

    public void zzj(zzc.zzb<LoadGameInstancesResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult, String str) throws RemoteException {
        ((IGamesService) zzoA()).zzf(new GameInstancesLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult), str);
    }

    public void zzk(zzc.zzb<LoadGameSearchSuggestionsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult, String str) throws RemoteException {
        ((IGamesService) zzoA()).zzq(new GameSearchSuggestionsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult), str);
    }

    public void zzl(zzc.zzb<LoadXpForGameCategoriesResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult, String str) throws RemoteException {
        ((IGamesService) zzoA()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult), str);
    }

    protected Bundle zzli() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zzsQ = this.zzasR.zzsQ();
        zzsQ.putString("com.google.android.gms.games.key.gamePackageName", this.zzasK);
        zzsQ.putString("com.google.android.gms.games.key.desiredLocale", locale);
        zzsQ.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzasN.zzur()));
        zzsQ.putInt("com.google.android.gms.games.key.API_VERSION", 0);
        zzf zzoy = zzoy();
        if (zzoy.zzoo() != null) {
            zzsQ.putBundle("com.google.android.gms.games.key.signInOptions", zzi.zza(zzoy.zzoo(), zzoy.zzop(), Executors.newSingleThreadExecutor()));
        }
        return zzsQ;
    }

    public boolean zzlm() {
        return true;
    }

    public void zzm(View view) {
        this.zzasN.zzn(view);
    }

    public void zzm(zzc.zzb<LoadInvitationsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str) throws RemoteException {
        ((IGamesService) zzoA()).zzk(new InvitationsLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str);
    }

    public Bundle zzmw() {
        try {
            Bundle zzmw = ((IGamesService) zzoA()).zzmw();
            if (zzmw == null) {
                return zzmw;
            }
            zzmw.setClassLoader(GamesClientImpl.class.getClassLoader());
            return zzmw;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzn(zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, String str) throws RemoteException {
        ((IGamesService) zzoA()).zzj(new NotifyAclUpdatedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status), str);
    }

    public void zzo(zzc.zzb<GameMuteStatusLoadResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult, String str) throws RemoteException {
        ((IGamesService) zzoA()).zzi(new GameMuteStatusLoadedBinderCallback(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult), str);
    }

    public void zzou() {
        super.zzou();
        if (this.zzasO) {
            this.zzasN.zzup();
            this.zzasO = false;
        }
        if (!this.zzasR.zzarv) {
            zztG();
        }
    }

    public Intent zzp(String str, int i) {
        try {
            return ((IGamesService) zzoA()).zzw(str, i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzq(String str, int i) {
        this.zzasJ.zzq(str, i);
    }

    public void zzr(String str, int i) {
        try {
            ((IGamesService) zzoA()).zzr(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzs(String str, int i) {
        try {
            ((IGamesService) zzoA()).zzs(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zztG() {
        try {
            ((IGamesService) zzoA()).zza(new PopupLocationInfoBinderCallbacks(this.zzasN), this.zzasQ);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public String zztH() {
        try {
            return ((IGamesService) zzoA()).zztH();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public String zztI() {
        if (this.zzasL != null) {
            return this.zzasL.getPlayerId();
        }
        try {
            return ((IGamesService) zzoA()).zztI();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Player zztJ() {
        zzoz();
        synchronized (this) {
            if (this.zzasL == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) zzoA()).zzuf());
                    if (playerBuffer.getCount() > 0) {
                        this.zzasL = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    zzb(e);
                } catch (Throwable th) {
                    playerBuffer.release();
                }
            }
        }
        return this.zzasL;
    }

    public Game zztK() {
        zzoz();
        synchronized (this) {
            if (this.zzasM == null) {
                GameBuffer gameBuffer;
                try {
                    gameBuffer = new GameBuffer(((IGamesService) zzoA()).zzuh());
                    if (gameBuffer.getCount() > 0) {
                        this.zzasM = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    zzb(e);
                } catch (Throwable th) {
                    gameBuffer.release();
                }
            }
        }
        return this.zzasM;
    }

    public Intent zztL() {
        try {
            return ((IGamesService) zzoA()).zztL();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zztM() {
        try {
            return ((IGamesService) zzoA()).zztM();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zztN() {
        try {
            return ((IGamesService) zzoA()).zztN();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zztO() {
        try {
            return ((IGamesService) zzoA()).zztO();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zztP() {
        try {
            ((IGamesService) zzoA()).zzF(this.zzasQ);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zztQ() {
        try {
            ((IGamesService) zzoA()).zzG(this.zzasQ);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zztR() {
        try {
            ((IGamesService) zzoA()).zzI(this.zzasQ);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zztS() {
        try {
            ((IGamesService) zzoA()).zzH(this.zzasQ);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zztT() {
        try {
            return ((IGamesService) zzoA()).zztT();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zztU() {
        try {
            return ((IGamesService) zzoA()).zztU();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zztV() {
        try {
            return ((IGamesService) zzoA()).zztV();
        } catch (RemoteException e) {
            zzb(e);
            return 4368;
        }
    }

    public String zztW() {
        try {
            return ((IGamesService) zzoA()).zztW();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zztX() {
        try {
            return ((IGamesService) zzoA()).zztX();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zztY() {
        try {
            return ((IGamesService) zzoA()).zztY();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zztZ() {
        try {
            return ((IGamesService) zzoA()).zztZ();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzua() {
        try {
            return ((IGamesService) zzoA()).zzua();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzub() {
        try {
            return ((IGamesService) zzoA()).zzub();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzuc() {
        try {
            return ((IGamesService) zzoA()).zzuc();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzud() {
        if (isConnected()) {
            try {
                ((IGamesService) zzoA()).zzud();
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }
}
