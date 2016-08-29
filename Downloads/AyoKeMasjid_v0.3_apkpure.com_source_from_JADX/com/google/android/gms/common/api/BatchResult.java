package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status zzQA;
    private final PendingResult<?>[] zzYS;

    BatchResult(Status status, PendingResult<?>[] pendingResults) {
        this.zzQA = status;
        this.zzYS = pendingResults;
    }

    public Status getStatus() {
        return this.zzQA;
    }

    public <R extends Result> R take(BatchResultToken<R> resultToken) {
        zzx.zzb(resultToken.mId < this.zzYS.length, (Object) "The result token does not belong to this batch");
        return this.zzYS[resultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
