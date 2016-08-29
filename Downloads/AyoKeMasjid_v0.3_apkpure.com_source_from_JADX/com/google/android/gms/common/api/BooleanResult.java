package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;

public class BooleanResult implements Result {
    private final Status zzQA;
    private final boolean zzYW;

    public BooleanResult(Status status, boolean value) {
        this.zzQA = (Status) zzx.zzb((Object) status, (Object) "Status must not be null");
        this.zzYW = value;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.zzQA.equals(booleanResult.zzQA) && this.zzYW == booleanResult.zzYW;
    }

    public Status getStatus() {
        return this.zzQA;
    }

    public boolean getValue() {
        return this.zzYW;
    }

    public final int hashCode() {
        return (this.zzYW ? 1 : 0) + ((this.zzQA.hashCode() + 527) * 31);
    }
}
