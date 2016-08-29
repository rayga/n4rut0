package com.google.android.gms.common.api;

import android.os.Looper;
import java.util.concurrent.TimeUnit;

public abstract class zza<R extends Result> extends zzb<R> implements OptionalPendingResult<R> {
    protected zza(Looper looper) {
        super(looper);
    }

    public R get() {
        if (isReady()) {
            return await(0, TimeUnit.MILLISECONDS);
        }
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    public boolean isDone() {
        return isReady();
    }
}
