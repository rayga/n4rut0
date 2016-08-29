package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.1 */
    class C11921 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String zzavh;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.1.1 */
        class C11111 implements GameMuteStatusChangeResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ C11921 zzavi;

            C11111(C11921 c11921, Status status) {
                this.zzavi = c11921;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzavh, true);
        }

        public GameMuteStatusChangeResult zzal(Status status) {
            return new C11111(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzal(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.2 */
    class C11932 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String zzavh;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.2.1 */
        class C11121 implements GameMuteStatusChangeResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ C11932 zzavj;

            C11121(C11932 c11932, Status status) {
                this.zzavj = c11932;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzavh, false);
        }

        public GameMuteStatusChangeResult zzal(Status status) {
            return new C11121(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzal(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.3 */
    class C11943 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String zzavh;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.3.1 */
        class C11131 implements GameMuteStatusLoadResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ C11943 zzavk;

            C11131(C11943 c11943, Status status) {
                this.zzavk = c11943;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo(this, this.zzavh);
        }

        public GameMuteStatusLoadResult zzam(Status status) {
            return new C11131(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzam(status);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.ContactSettingLoadImpl.1 */
        class C11141 implements ContactSettingLoadResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ ContactSettingLoadImpl zzavn;

            C11141(ContactSettingLoadImpl contactSettingLoadImpl, Status status) {
                this.zzavn = contactSettingLoadImpl;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        public ContactSettingLoadResult zzan(Status status) {
            return new C11141(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzan(status);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.InboxCountImpl.1 */
        class C11151 implements InboxCountResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ InboxCountImpl zzavo;

            C11151(InboxCountImpl inboxCountImpl, Status status) {
                this.zzavo = inboxCountImpl;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        public InboxCountResult zzao(Status status) {
            return new C11151(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzao(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.4 */
    class C13184 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean zzaut;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi((zzb) this, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.5 */
    class C13195 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean zzavl;
        final /* synthetic */ Bundle zzavm;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzavl, this.zzavm);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.6 */
    class C13206 extends InboxCountImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh(this);
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzfN(notificationTypes);
        }
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
