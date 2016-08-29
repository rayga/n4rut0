package com.google.android.gms.common.api;

import com.google.android.gms.common.api.zzl.zzb;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzd<L> implements zzb<L> {
    private final DataHolder zzYX;

    protected zzd(DataHolder dataHolder) {
        this.zzYX = dataHolder;
    }

    protected abstract void zza(L l, DataHolder dataHolder);

    public void zznh() {
        if (this.zzYX != null) {
            this.zzYX.close();
        }
    }

    public final void zzo(L l) {
        zza(l, this.zzYX);
    }
}
