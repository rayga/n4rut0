package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class InvitationBuffer extends zzf<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzk(int i, int i2) {
        return zzp(i, i2);
    }

    protected String zznW() {
        return "external_invitation_id";
    }

    protected Invitation zzp(int i, int i2) {
        return new InvitationRef(this.zzYX, i, i2);
    }
}
