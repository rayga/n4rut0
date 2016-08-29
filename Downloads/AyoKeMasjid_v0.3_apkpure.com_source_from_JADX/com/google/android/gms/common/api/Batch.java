package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.PendingResult.BatchCallback;
import com.google.android.gms.common.api.zzb.zza;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzb<BatchResult> {
    private int zzYP;
    private boolean zzYQ;
    private boolean zzYR;
    private final PendingResult<?>[] zzYS;
    private final Object zzpc;

    public static final class Builder {
        private List<PendingResult<?>> zzYU;
        private Looper zzYV;

        public Builder(GoogleApiClient googleApiClient) {
            this.zzYU = new ArrayList();
            this.zzYV = googleApiClient.getLooper();
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken(this.zzYU.size());
            this.zzYU.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zzYV, null);
        }
    }

    /* renamed from: com.google.android.gms.common.api.Batch.1 */
    class C07061 implements BatchCallback {
        final /* synthetic */ Batch zzYT;

        C07061(Batch batch) {
            this.zzYT = batch;
        }

        public void onComplete(Status status) {
            synchronized (this.zzYT.zzpc) {
                if (this.zzYT.isCanceled()) {
                    return;
                }
                if (status.isCanceled()) {
                    this.zzYT.zzYR = true;
                } else if (!status.isSuccess()) {
                    this.zzYT.zzYQ = true;
                }
                this.zzYT.zzYP = this.zzYT.zzYP - 1;
                if (this.zzYT.zzYP == 0) {
                    if (this.zzYT.zzYR) {
                        super.cancel();
                    } else {
                        this.zzYT.zza(new BatchResult(this.zzYT.zzYQ ? new Status(13) : Status.zzaaD, this.zzYT.zzYS));
                    }
                }
            }
        }
    }

    private Batch(List<PendingResult<?>> pendingResultList, Looper looper) {
        super(new zza(looper));
        this.zzpc = new Object();
        this.zzYP = pendingResultList.size();
        this.zzYS = new PendingResult[this.zzYP];
        for (int i = 0; i < pendingResultList.size(); i++) {
            PendingResult pendingResult = (PendingResult) pendingResultList.get(i);
            this.zzYS[i] = pendingResult;
            pendingResult.addBatchCallback(new C07061(this));
        }
    }

    public void cancel() {
        super.cancel();
        for (PendingResult cancel : this.zzYS) {
            cancel.cancel();
        }
    }

    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zzYS);
    }

    public /* synthetic */ Result zzb(Status status) {
        return createFailedResult(status);
    }
}
