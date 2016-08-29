package com.google.android.gms.common.api;

import com.google.android.gms.common.data.DataHolder;

public abstract class zze implements Releasable, Result {
    protected final Status zzQA;
    protected final DataHolder zzYX;

    protected zze(DataHolder dataHolder) {
        this(dataHolder, new Status(dataHolder.getStatusCode()));
    }

    protected zze(DataHolder dataHolder, Status status) {
        this.zzQA = status;
        this.zzYX = dataHolder;
    }

    public Status getStatus() {
        return this.zzQA;
    }

    public void release() {
        if (this.zzYX != null) {
            this.zzYX.close();
        }
    }
}
