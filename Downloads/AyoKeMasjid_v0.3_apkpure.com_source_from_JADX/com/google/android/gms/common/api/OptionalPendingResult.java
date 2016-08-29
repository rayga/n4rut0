package com.google.android.gms.common.api;

public interface OptionalPendingResult<R extends Result> extends PendingResult<R> {
    R get();

    boolean isDone();
}
