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
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {

    private static abstract class LoadInvitationsImpl extends BaseGamesApiMethodImpl<LoadInvitationsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.LoadInvitationsImpl.1 */
        class C11061 implements LoadInvitationsResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadInvitationsImpl zzauT;

            C11061(LoadInvitationsImpl loadInvitationsImpl, Status status) {
                this.zzauT = loadInvitationsImpl;
                this.zzQs = status;
            }

            public InvitationBuffer getInvitations() {
                return new InvitationBuffer(DataHolder.zzbp(14));
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        private LoadInvitationsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadInvitationsResult zzag(Status status) {
            return new C11061(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzag(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.1 */
    class C13061 extends LoadInvitationsImpl {
        final /* synthetic */ int zzauQ;
        final /* synthetic */ InvitationsImpl zzauR;

        C13061(InvitationsImpl invitationsImpl, GoogleApiClient x0, int i) {
            this.zzauR = invitationsImpl;
            this.zzauQ = i;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzauQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.2 */
    class C13072 extends LoadInvitationsImpl {
        final /* synthetic */ int zzauQ;
        final /* synthetic */ String zzauv;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this, this.zzauv, this.zzauQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.InvitationsImpl.3 */
    class C13083 extends LoadInvitationsImpl {
        final /* synthetic */ String zzauS;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzm(this, this.zzauS);
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztO();
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, int sortOrder) {
        return apiClient.zza(new C13061(this, apiClient, sortOrder));
    }

    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zza(apiClient.zzp(listener));
        }
    }

    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zztP();
        }
    }
}
