package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestSummariesImpl.1 */
        class C11231 implements LoadRequestSummariesResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadRequestSummariesImpl zzavR;

            C11231(LoadRequestSummariesImpl loadRequestSummariesImpl, Status status) {
                this.zzavR = loadRequestSummariesImpl;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        public LoadRequestSummariesResult zzaw(Status status) {
            return new C11231(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaw(status);
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestsImpl.1 */
        class C11241 implements LoadRequestsResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadRequestsImpl zzavS;

            C11241(LoadRequestsImpl loadRequestsImpl, Status status) {
                this.zzavS = loadRequestsImpl;
                this.zzQs = status;
            }

            public GameRequestBuffer getRequests(int type) {
                return new GameRequestBuffer(DataHolder.zzbp(this.zzQs.getStatusCode()));
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadRequestsResult zzax(Status status) {
            return new C11241(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzax(status);
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.SendRequestImpl.1 */
        class C11251 implements SendRequestResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ SendRequestImpl zzavT;

            C11251(SendRequestImpl sendRequestImpl, Status status) {
                this.zzavT = sendRequestImpl;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        public SendRequestResult zzay(Status status) {
            return new C11251(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzay(status);
        }
    }

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.UpdateRequestsImpl.1 */
        class C11261 implements UpdateRequestsResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ UpdateRequestsImpl zzavU;

            C11261(UpdateRequestsImpl updateRequestsImpl, Status status) {
                this.zzavU = updateRequestsImpl;
                this.zzQs = status;
            }

            public Set<String> getRequestIds() {
                return null;
            }

            public int getRequestOutcome(String requestId) {
                throw new IllegalArgumentException("Unknown request ID " + requestId);
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateRequestsResult zzaz(Status status) {
            return new C11261(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaz(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.1 */
    class C13361 extends UpdateRequestsImpl {
        final /* synthetic */ String[] zzavJ;
        final /* synthetic */ RequestsImpl zzavK;

        C13361(RequestsImpl requestsImpl, GoogleApiClient x0, String[] strArr) {
            this.zzavK = requestsImpl;
            this.zzavJ = strArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzavJ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.2 */
    class C13372 extends UpdateRequestsImpl {
        final /* synthetic */ String[] zzavJ;
        final /* synthetic */ RequestsImpl zzavK;

        C13372(RequestsImpl requestsImpl, GoogleApiClient x0, String[] strArr) {
            this.zzavK = requestsImpl;
            this.zzavJ = strArr;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzavJ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.3 */
    class C13383 extends LoadRequestsImpl {
        final /* synthetic */ int zzauQ;
        final /* synthetic */ RequestsImpl zzavK;
        final /* synthetic */ int zzavL;
        final /* synthetic */ int zzavM;

        C13383(RequestsImpl requestsImpl, GoogleApiClient x0, int i, int i2, int i3) {
            this.zzavK = requestsImpl;
            this.zzavL = i;
            this.zzavM = i2;
            this.zzauQ = i3;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzavL, this.zzavM, this.zzauQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.4 */
    class C13394 extends SendRequestImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ String[] zzavN;
        final /* synthetic */ int zzavO;
        final /* synthetic */ byte[] zzavP;
        final /* synthetic */ int zzavQ;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauv, this.zzavN, this.zzavO, this.zzavP, this.zzavQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.5 */
    class C13405 extends SendRequestImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ String[] zzavN;
        final /* synthetic */ int zzavO;
        final /* synthetic */ byte[] zzavP;
        final /* synthetic */ int zzavQ;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauv, this.zzavN, this.zzavO, this.zzavP, this.zzavQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.6 */
    class C13416 extends UpdateRequestsImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ String zzavF;
        final /* synthetic */ String[] zzavJ;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauv, this.zzavF, this.zzavJ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.7 */
    class C13427 extends LoadRequestsImpl {
        final /* synthetic */ int zzauQ;
        final /* synthetic */ String zzauv;
        final /* synthetic */ String zzavF;
        final /* synthetic */ int zzavL;
        final /* synthetic */ int zzavM;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauv, this.zzavF, this.zzavL, this.zzavM, this.zzauQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl.8 */
    class C13438 extends LoadRequestSummariesImpl {
        final /* synthetic */ String zzavF;
        final /* synthetic */ int zzavM;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf(this, this.zzavF, this.zzavM);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        return apiClient.zzb(new C13361(this, apiClient, requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()])));
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        return apiClient.zzb(new C13372(this, apiClient, requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()])));
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztY();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzua();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztZ();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.zzd(apiClient).zza(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, int requestDirection, int types, int sortOrder) {
        return apiClient.zza(new C13383(this, apiClient, requestDirection, types, sortOrder));
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzd(apiClient.zzp(listener));
        }
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zztS();
        }
    }
}
