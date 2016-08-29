package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;

public final class StatsImpl implements Stats {

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadPlayerStatsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.StatsImpl.LoadsImpl.1 */
        class C11311 implements LoadPlayerStatsResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ LoadsImpl zzawj;

            C11311(LoadsImpl loadsImpl, Status status) {
                this.zzawj = loadsImpl;
                this.zzQs = status;
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        public LoadPlayerStatsResult zzaE(Status status) {
            return new C11311(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaE(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.StatsImpl.1 */
    class C13501 extends LoadsImpl {
        final /* synthetic */ boolean zzaut;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb) this, this.zzaut);
        }
    }
}
