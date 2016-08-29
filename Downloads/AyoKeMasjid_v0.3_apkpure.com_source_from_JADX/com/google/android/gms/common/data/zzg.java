package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T> extends zzb<T> {
    private T zzabA;

    public zzg(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (hasNext()) {
            this.zzabe++;
            if (this.zzabe == 0) {
                this.zzabA = this.zzabd.get(0);
                if (!(this.zzabA instanceof zzc)) {
                    throw new IllegalStateException("DataBuffer reference of type " + this.zzabA.getClass() + " is not movable");
                }
            }
            ((zzc) this.zzabA).zzbm(this.zzabe);
            return this.zzabA;
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzabe);
    }
}
