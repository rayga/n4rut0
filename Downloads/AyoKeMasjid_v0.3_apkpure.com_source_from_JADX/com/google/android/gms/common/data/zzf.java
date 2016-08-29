package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean zzaby;
    private ArrayList<Integer> zzabz;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
        this.zzaby = false;
    }

    private void zznX() {
        synchronized (this) {
            if (!this.zzaby) {
                int count = this.zzYX.getCount();
                this.zzabz = new ArrayList();
                if (count > 0) {
                    this.zzabz.add(Integer.valueOf(0));
                    String zznW = zznW();
                    String zzd = this.zzYX.zzd(zznW, 0, this.zzYX.zzbo(0));
                    int i = 1;
                    while (i < count) {
                        int zzbo = this.zzYX.zzbo(i);
                        String zzd2 = this.zzYX.zzd(zznW, i, zzbo);
                        if (zzd2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + zznW + ", at row: " + i + ", for window: " + zzbo);
                        }
                        if (zzd2.equals(zzd)) {
                            zzd2 = zzd;
                        } else {
                            this.zzabz.add(Integer.valueOf(i));
                        }
                        i++;
                        zzd = zzd2;
                    }
                }
                this.zzaby = true;
            }
        }
    }

    public final T get(int position) {
        zznX();
        return zzk(zzbr(position), zzbs(position));
    }

    public int getCount() {
        zznX();
        return this.zzabz.size();
    }

    int zzbr(int i) {
        if (i >= 0 && i < this.zzabz.size()) {
            return ((Integer) this.zzabz.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    protected int zzbs(int i) {
        if (i < 0 || i == this.zzabz.size()) {
            return 0;
        }
        int count = i == this.zzabz.size() + -1 ? this.zzYX.getCount() - ((Integer) this.zzabz.get(i)).intValue() : ((Integer) this.zzabz.get(i + 1)).intValue() - ((Integer) this.zzabz.get(i)).intValue();
        if (count != 1) {
            return count;
        }
        int zzbr = zzbr(i);
        int zzbo = this.zzYX.zzbo(zzbr);
        String zznY = zznY();
        return (zznY == null || this.zzYX.zzd(zznY, zzbr, zzbo) != null) ? count : 0;
    }

    protected abstract T zzk(int i, int i2);

    protected abstract String zznW();

    protected String zznY() {
        return null;
    }
}
