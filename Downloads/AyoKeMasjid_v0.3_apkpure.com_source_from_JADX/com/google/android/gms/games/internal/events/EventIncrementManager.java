package com.google.android.gms.games.internal.events;

import java.util.concurrent.atomic.AtomicReference;

public abstract class EventIncrementManager {
    private final AtomicReference<EventIncrementCache> zzawI;

    public EventIncrementManager() {
        this.zzawI = new AtomicReference();
    }

    public void flush() {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzawI.get();
        if (eventIncrementCache != null) {
            eventIncrementCache.flush();
        }
    }

    public void zzq(String str, int i) {
        EventIncrementCache eventIncrementCache = (EventIncrementCache) this.zzawI.get();
        if (eventIncrementCache == null) {
            eventIncrementCache = zzue();
            if (!this.zzawI.compareAndSet(null, eventIncrementCache)) {
                eventIncrementCache = (EventIncrementCache) this.zzawI.get();
            }
        }
        eventIncrementCache.zzx(str, i);
    }

    protected abstract EventIncrementCache zzue();
}
