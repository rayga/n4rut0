package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.BatchCallback;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

class zznj<T extends Result> implements PendingResult<T> {
    private final T zzaoM;

    zznj(T t) {
        this.zzaoM = t;
    }

    public void addBatchCallback(BatchCallback callback) {
        callback.onComplete(this.zzaoM.getStatus());
    }

    public T await() {
        return this.zzaoM;
    }

    public T await(long time, TimeUnit units) {
        return this.zzaoM;
    }

    public void cancel() {
    }

    public boolean isCanceled() {
        return false;
    }

    public void setResultCallback(ResultCallback<T> callback) {
        callback.onResult(this.zzaoM);
    }

    public void setResultCallback(ResultCallback<T> callback, long time, TimeUnit units) {
        callback.onResult(this.zzaoM);
    }
}
