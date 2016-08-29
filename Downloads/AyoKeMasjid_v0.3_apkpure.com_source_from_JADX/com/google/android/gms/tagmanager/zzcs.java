package com.google.android.gms.tagmanager;

import net.sourceforge.jitl.astro.Utils;

class zzcs implements zzcd {
    private final long zzOe;
    private final int zzOf;
    private double zzOg;
    private final Object zzOi;
    private long zzaRW;

    public zzcs() {
        this(60, 2000);
    }

    public zzcs(int i, long j) {
        this.zzOi = new Object();
        this.zzOf = i;
        this.zzOg = (double) this.zzOf;
        this.zzOe = j;
    }

    public boolean zzkp() {
        boolean z;
        synchronized (this.zzOi) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zzOg < ((double) this.zzOf)) {
                double d = ((double) (currentTimeMillis - this.zzaRW)) / ((double) this.zzOe);
                if (d > 0.0d) {
                    this.zzOg = Math.min((double) this.zzOf, d + this.zzOg);
                }
            }
            this.zzaRW = currentTimeMillis;
            if (this.zzOg >= Utils.AGGRESSIVE_ROUND_SEC) {
                this.zzOg -= Utils.AGGRESSIVE_ROUND_SEC;
                z = true;
            } else {
                zzbg.zzaE("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
