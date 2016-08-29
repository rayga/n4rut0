package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object zzawC;
    private Handler zzawD;
    private boolean zzawE;
    private HashMap<String, AtomicInteger> zzawF;
    private int zzawG;

    /* renamed from: com.google.android.gms.games.internal.events.EventIncrementCache.1 */
    class C03001 implements Runnable {
        final /* synthetic */ EventIncrementCache zzawH;

        C03001(EventIncrementCache eventIncrementCache) {
            this.zzawH = eventIncrementCache;
        }

        public void run() {
            this.zzawH.zzut();
        }
    }

    public EventIncrementCache(Looper looper, int flushIntervalMillis) {
        this.zzawC = new Object();
        this.zzawD = new Handler(looper);
        this.zzawF = new HashMap();
        this.zzawG = flushIntervalMillis;
    }

    private void zzut() {
        synchronized (this.zzawC) {
            this.zzawE = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.zzawC) {
            for (Entry entry : this.zzawF.entrySet()) {
                zzt((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.zzawF.clear();
        }
    }

    protected abstract void zzt(String str, int i);

    public void zzx(String str, int i) {
        synchronized (this.zzawC) {
            if (!this.zzawE) {
                this.zzawE = true;
                this.zzawD.postDelayed(new C03001(this), (long) this.zzawG);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.zzawF.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzawF.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
