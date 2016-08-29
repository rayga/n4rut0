package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class GameRequestBuffer extends zzf<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzk(int i, int i2) {
        return zzt(i, i2);
    }

    protected String zznW() {
        return "external_request_id";
    }

    protected GameRequest zzt(int i, int i2) {
        return new GameRequestRef(this.zzYX, i, i2);
    }
}
