package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl implements Acls {

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.1 */
    static class C11001 implements LoadAclResult {
        final /* synthetic */ Status zzQs;

        C11001(Status status) {
            this.zzQs = status;
        }

        public Status getStatus() {
            return this.zzQs;
        }

        public void release() {
        }
    }

    private static abstract class LoadNotifyAclImpl extends BaseGamesApiMethodImpl<LoadAclResult> {
        public LoadAclResult zzaa(Status status) {
            return AclsImpl.zzY(status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaa(status);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends BaseGamesApiMethodImpl<Status> {
        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.2 */
    class C12972 extends LoadNotifyAclImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.3 */
    class C12983 extends UpdateNotifyAclImpl {
        final /* synthetic */ String zzauA;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzn(this, this.zzauA);
        }
    }

    private static LoadAclResult zzY(Status status) {
        return new C11001(status);
    }
}
