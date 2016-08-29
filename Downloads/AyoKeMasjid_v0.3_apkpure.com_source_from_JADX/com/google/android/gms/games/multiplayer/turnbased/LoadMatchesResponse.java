package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final TurnBasedMatchBuffer zzayA;
    private final TurnBasedMatchBuffer zzayB;
    private final InvitationBuffer zzayy;
    private final TurnBasedMatchBuffer zzayz;

    public LoadMatchesResponse(Bundle matchData) {
        DataHolder zza = zza(matchData, 0);
        if (zza != null) {
            this.zzayy = new InvitationBuffer(zza);
        } else {
            this.zzayy = null;
        }
        zza = zza(matchData, 1);
        if (zza != null) {
            this.zzayz = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzayz = null;
        }
        zza = zza(matchData, 2);
        if (zza != null) {
            this.zzayA = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzayA = null;
        }
        zza = zza(matchData, 3);
        if (zza != null) {
            this.zzayB = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzayB = null;
        }
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String zzfQ = TurnBasedMatchTurnStatus.zzfQ(i);
        return !bundle.containsKey(zzfQ) ? null : (DataHolder) bundle.getParcelable(zzfQ);
    }

    @Deprecated
    public void close() {
        release();
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzayB;
    }

    public InvitationBuffer getInvitations() {
        return this.zzayy;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzayz;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzayA;
    }

    public boolean hasData() {
        return (this.zzayy == null || this.zzayy.getCount() <= 0) ? (this.zzayz == null || this.zzayz.getCount() <= 0) ? (this.zzayA == null || this.zzayA.getCount() <= 0) ? this.zzayB != null && this.zzayB.getCount() > 0 : true : true : true;
    }

    public void release() {
        if (this.zzayy != null) {
            this.zzayy.release();
        }
        if (this.zzayz != null) {
            this.zzayz.release();
        }
        if (this.zzayA != null) {
            this.zzayA.release();
        }
        if (this.zzayB != null) {
            this.zzayB.release();
        }
    }
}
