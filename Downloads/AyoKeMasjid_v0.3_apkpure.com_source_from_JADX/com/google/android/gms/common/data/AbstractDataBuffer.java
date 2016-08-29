package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
    protected final DataHolder zzYX;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.zzYX = dataHolder;
        if (this.zzYX != null) {
            this.zzYX.zzq(this);
        }
    }

    @Deprecated
    public final void close() {
        release();
    }

    public abstract T get(int i);

    public int getCount() {
        return this.zzYX == null ? 0 : this.zzYX.getCount();
    }

    @Deprecated
    public boolean isClosed() {
        return this.zzYX == null || this.zzYX.isClosed();
    }

    public Iterator<T> iterator() {
        return new zzb(this);
    }

    public void release() {
        if (this.zzYX != null) {
            this.zzYX.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new zzg(this);
    }

    public Bundle zznP() {
        return this.zzYX.zznP();
    }
}
