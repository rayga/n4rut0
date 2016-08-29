package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class RoomBuffer extends zzf<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzk(int i, int i2) {
        return zzq(i, i2);
    }

    protected String zznW() {
        return "external_match_id";
    }

    protected Room zzq(int i, int i2) {
        return new RoomRef(this.zzYX, i, i2);
    }
}
