package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl implements AppContents {

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadAppContentResult> {

        /* renamed from: com.google.android.gms.games.internal.api.AppContentsImpl.LoadsImpl.1 */
        class C11011 implements LoadAppContentResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadsImpl zzauE;

            C11011(LoadsImpl loadsImpl, Status status) {
                this.zzauE = loadsImpl;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        public LoadAppContentResult zzab(Status status) {
            return new C11011(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzab(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AppContentsImpl.1 */
    class C12991 extends LoadsImpl {
        final /* synthetic */ int zzauB;
        final /* synthetic */ String zzauC;
        final /* synthetic */ String[] zzauD;
        final /* synthetic */ boolean zzaut;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzauB, this.zzauC, this.zzauD, this.zzaut);
        }
    }
}
