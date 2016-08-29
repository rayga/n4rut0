package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameNotificationBuffer extends AbstractDataBuffer<GameNotification> {
    public /* synthetic */ Object get(int x0) {
        return zzfX(x0);
    }

    public GameNotification zzfX(int i) {
        return new GameNotificationRef(this.zzYX, i);
    }
}
