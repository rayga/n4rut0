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
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.LoadImpl.1 */
        class C10981 implements LoadAchievementsResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadImpl zzauy;

            C10981(LoadImpl loadImpl, Status status) {
                this.zzauy = loadImpl;
                this.zzQs = status;
            }

            public AchievementBuffer getAchievements() {
                return new AchievementBuffer(DataHolder.zzbp(14));
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadAchievementsResult zzW(Status status) {
            return new C10981(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzW(status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        private final String zzwj;

        /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.UpdateImpl.1 */
        class C10991 implements UpdateAchievementResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ UpdateImpl zzauz;

            C10991(UpdateImpl updateImpl, Status status) {
                this.zzauz = updateImpl;
                this.zzQs = status;
            }

            public String getAchievementId() {
                return this.zzauz.zzwj;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        public UpdateImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzwj = id;
        }

        public UpdateAchievementResult zzX(Status status) {
            return new C10991(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzX(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.10 */
    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ String zzWg;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzWg, this.zzauv, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.1 */
    class C12881 extends LoadImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ AchievementsImpl zzauu;

        C12881(AchievementsImpl achievementsImpl, GoogleApiClient x0, boolean z) {
            this.zzauu = achievementsImpl;
            this.zzaut = z;
            super(null);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.2 */
    class C12892 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzauu;
        final /* synthetic */ String zzauw;

        C12892(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str) {
            this.zzauu = achievementsImpl;
            this.zzauw = str;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(null, this.zzauw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.3 */
    class C12903 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzauu;
        final /* synthetic */ String zzauw;

        C12903(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str) {
            this.zzauu = achievementsImpl;
            this.zzauw = str;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.4 */
    class C12914 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzauu;
        final /* synthetic */ String zzauw;

        C12914(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str) {
            this.zzauu = achievementsImpl;
            this.zzauw = str;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(null, this.zzauw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.5 */
    class C12925 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzauu;
        final /* synthetic */ String zzauw;

        C12925(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str) {
            this.zzauu = achievementsImpl;
            this.zzauw = str;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzauw);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.6 */
    class C12936 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzauu;
        final /* synthetic */ String zzauw;
        final /* synthetic */ int zzaux;

        C12936(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str, int i) {
            this.zzauu = achievementsImpl;
            this.zzauw = str;
            this.zzaux = i;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(null, this.zzauw, this.zzaux);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.7 */
    class C12947 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzauu;
        final /* synthetic */ String zzauw;
        final /* synthetic */ int zzaux;

        C12947(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str, int i) {
            this.zzauu = achievementsImpl;
            this.zzauw = str;
            this.zzaux = i;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauw, this.zzaux);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.8 */
    class C12958 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzauu;
        final /* synthetic */ String zzauw;
        final /* synthetic */ int zzaux;

        C12958(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str, int i) {
            this.zzauu = achievementsImpl;
            this.zzauw = str;
            this.zzaux = i;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(null, this.zzauw, this.zzaux);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl.9 */
    class C12969 extends UpdateImpl {
        final /* synthetic */ AchievementsImpl zzauu;
        final /* synthetic */ String zzauw;
        final /* synthetic */ int zzaux;

        C12969(AchievementsImpl achievementsImpl, String x0, GoogleApiClient x1, String str, int i) {
            this.zzauu = achievementsImpl;
            this.zzauw = str;
            this.zzaux = i;
            super(x0, x1);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzauw, this.zzaux);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztM();
    }

    public void increment(GoogleApiClient apiClient, String id, int numSteps) {
        apiClient.zzb(new C12936(this, id, apiClient, id, numSteps));
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        return apiClient.zzb(new C12947(this, id, apiClient, id, numSteps));
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.zza(new C12881(this, apiClient, forceReload));
    }

    public void reveal(GoogleApiClient apiClient, String id) {
        apiClient.zzb(new C12892(this, id, apiClient, id));
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, String id) {
        return apiClient.zzb(new C12903(this, id, apiClient, id));
    }

    public void setSteps(GoogleApiClient apiClient, String id, int numSteps) {
        apiClient.zzb(new C12958(this, id, apiClient, id, numSteps));
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        return apiClient.zzb(new C12969(this, id, apiClient, id, numSteps));
    }

    public void unlock(GoogleApiClient apiClient, String id) {
        apiClient.zzb(new C12914(this, id, apiClient, id));
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, String id) {
        return apiClient.zzb(new C12925(this, id, apiClient, id));
    }
}
