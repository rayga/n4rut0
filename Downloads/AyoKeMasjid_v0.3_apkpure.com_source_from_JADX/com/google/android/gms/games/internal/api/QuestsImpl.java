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
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

public final class QuestsImpl implements Quests {

    private static abstract class AcceptImpl extends BaseGamesApiMethodImpl<AcceptQuestResult> {

        /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.AcceptImpl.1 */
        class C11201 implements AcceptQuestResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ AcceptImpl zzavG;

            C11201(AcceptImpl acceptImpl, Status status) {
                this.zzavG = acceptImpl;
                this.zzQs = status;
            }

            public Quest getQuest() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        private AcceptImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public AcceptQuestResult zzat(Status status) {
            return new C11201(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzat(status);
        }
    }

    private static abstract class ClaimImpl extends BaseGamesApiMethodImpl<ClaimMilestoneResult> {

        /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.ClaimImpl.1 */
        class C11211 implements ClaimMilestoneResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ ClaimImpl zzavH;

            C11211(ClaimImpl claimImpl, Status status) {
                this.zzavH = claimImpl;
                this.zzQs = status;
            }

            public Milestone getMilestone() {
                return null;
            }

            public Quest getQuest() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        private ClaimImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public ClaimMilestoneResult zzau(Status status) {
            return new C11211(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzau(status);
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadQuestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.LoadsImpl.1 */
        class C11221 implements LoadQuestsResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadsImpl zzavI;

            C11221(LoadsImpl loadsImpl, Status status) {
                this.zzavI = loadsImpl;
                this.zzQs = status;
            }

            public QuestBuffer getQuests() {
                return new QuestBuffer(DataHolder.zzbp(this.zzQs.getStatusCode()));
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadQuestsResult zzav(Status status) {
            return new C11221(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzav(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.1 */
    class C13301 extends AcceptImpl {
        final /* synthetic */ String zzavA;
        final /* synthetic */ QuestsImpl zzavB;

        C13301(QuestsImpl questsImpl, GoogleApiClient x0, String str) {
            this.zzavB = questsImpl;
            this.zzavA = str;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb) this, this.zzavA);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.2 */
    class C13312 extends ClaimImpl {
        final /* synthetic */ String zzavA;
        final /* synthetic */ QuestsImpl zzavB;
        final /* synthetic */ String zzavC;

        C13312(QuestsImpl questsImpl, GoogleApiClient x0, String str, String str2) {
            this.zzavB = questsImpl;
            this.zzavA = str;
            this.zzavC = str2;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzavA, this.zzavC);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.3 */
    class C13323 extends LoadsImpl {
        final /* synthetic */ int zzauQ;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ QuestsImpl zzavB;
        final /* synthetic */ int[] zzavD;

        C13323(QuestsImpl questsImpl, GoogleApiClient x0, int[] iArr, int i, boolean z) {
            this.zzavB = questsImpl;
            this.zzavD = iArr;
            this.zzauQ = i;
            this.zzaut = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzavD, this.zzauQ, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.4 */
    class C13334 extends LoadsImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ QuestsImpl zzavB;
        final /* synthetic */ String[] zzavE;

        C13334(QuestsImpl questsImpl, GoogleApiClient x0, boolean z, String[] strArr) {
            this.zzavB = questsImpl;
            this.zzaut = z;
            this.zzavE = strArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaut, this.zzavE);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.5 */
    class C13345 extends LoadsImpl {
        final /* synthetic */ int zzauQ;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;
        final /* synthetic */ int[] zzavD;
        final /* synthetic */ String zzavF;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauv, this.zzavF, this.zzavD, this.zzauQ, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl.6 */
    class C13356 extends LoadsImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;
        final /* synthetic */ String[] zzavE;
        final /* synthetic */ String zzavF;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauv, this.zzavF, this.zzaut, this.zzavE);
        }
    }

    public PendingResult<AcceptQuestResult> accept(GoogleApiClient apiClient, String questId) {
        return apiClient.zzb(new C13301(this, apiClient, questId));
    }

    public PendingResult<ClaimMilestoneResult> claim(GoogleApiClient apiClient, String questId, String milestoneId) {
        return apiClient.zzb(new C13312(this, apiClient, questId, milestoneId));
    }

    public Intent getQuestIntent(GoogleApiClient apiClient, String questId) {
        return Games.zzd(apiClient).zzcY(questId);
    }

    public Intent getQuestsIntent(GoogleApiClient apiClient, int[] questSelectors) {
        return Games.zzd(apiClient).zzb(questSelectors);
    }

    public PendingResult<LoadQuestsResult> load(GoogleApiClient apiClient, int[] questSelectors, int sortOrder, boolean forceReload) {
        return apiClient.zza(new C13323(this, apiClient, questSelectors, sortOrder, forceReload));
    }

    public PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient apiClient, boolean forceReload, String... questIds) {
        return apiClient.zza(new C13334(this, apiClient, forceReload, questIds));
    }

    public void registerQuestUpdateListener(GoogleApiClient apiClient, QuestUpdateListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzc(apiClient.zzp(listener));
        }
    }

    public void showStateChangedPopup(GoogleApiClient apiClient, String questId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzcZ(questId);
        }
    }

    public void unregisterQuestUpdateListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zztR();
        }
    }
}
