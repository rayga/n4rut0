package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.LoadImpl.1 */
        class C11021 implements LoadEventsResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadImpl zzauJ;

            C11021(LoadImpl loadImpl, Status status) {
                this.zzauJ = loadImpl;
                this.zzQs = status;
            }

            public EventBuffer getEvents() {
                return new EventBuffer(DataHolder.zzbp(14));
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

        public LoadEventsResult zzac(Status status) {
            return new C11021(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzac(status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {

        /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.UpdateImpl.1 */
        class C07421 implements Result {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ UpdateImpl zzauK;

            C07421(UpdateImpl updateImpl, Status status) {
                this.zzauK = updateImpl;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Result zzb(Status status) {
            return new C07421(this, status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.1 */
    class C13001 extends LoadImpl {
        final /* synthetic */ String[] zzauF;
        final /* synthetic */ EventsImpl zzauG;
        final /* synthetic */ boolean zzaut;

        C13001(EventsImpl eventsImpl, GoogleApiClient x0, boolean z, String[] strArr) {
            this.zzauG = eventsImpl;
            this.zzaut = z;
            this.zzauF = strArr;
            super(null);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaut, this.zzauF);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.2 */
    class C13012 extends LoadImpl {
        final /* synthetic */ EventsImpl zzauG;
        final /* synthetic */ boolean zzaut;

        C13012(EventsImpl eventsImpl, GoogleApiClient x0, boolean z) {
            this.zzauG = eventsImpl;
            this.zzaut = z;
            super(null);
        }

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.EventsImpl.3 */
    class C13023 extends UpdateImpl {
        final /* synthetic */ EventsImpl zzauG;
        final /* synthetic */ String zzauH;
        final /* synthetic */ int zzauI;

        C13023(EventsImpl eventsImpl, GoogleApiClient x0, String str, int i) {
            this.zzauG = eventsImpl;
            this.zzauH = str;
            this.zzauI = i;
            super(null);
        }

        public void zza(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.zzq(this.zzauH, this.zzauI);
        }
    }

    public void increment(GoogleApiClient apiClient, String eventId, int incrementAmount) {
        GamesClientImpl zzc = Games.zzc(apiClient, false);
        if (zzc != null) {
            if (zzc.isConnected()) {
                zzc.zzq(eventId, incrementAmount);
            } else {
                apiClient.zzb(new C13023(this, apiClient, eventId, incrementAmount));
            }
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient apiClient, boolean forceReload) {
        return apiClient.zza(new C13012(this, apiClient, forceReload));
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient apiClient, boolean forceReload, String... eventIds) {
        return apiClient.zza(new C13001(this, apiClient, forceReload, eventIds));
    }
}
