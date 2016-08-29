package com.google.android.gms.playlog.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsb.zzd;
import java.util.ArrayList;

public class zzb {
    private final ArrayList<zza> zzaKK;
    private int zzaKL;

    public static class zza {
        public final PlayLoggerContext zzaKM;
        public final LogEvent zzaKN;
        public final zzd zzaKO;

        private zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
            this.zzaKM = (PlayLoggerContext) zzx.zzv(playLoggerContext);
            this.zzaKN = (LogEvent) zzx.zzv(logEvent);
            this.zzaKO = null;
        }
    }

    public zzb() {
        this(100);
    }

    public zzb(int i) {
        this.zzaKK = new ArrayList();
        this.zzaKL = i;
    }

    private void zzyD() {
        while (getSize() > getCapacity()) {
            this.zzaKK.remove(0);
        }
    }

    public void clear() {
        this.zzaKK.clear();
    }

    public int getCapacity() {
        return this.zzaKL;
    }

    public int getSize() {
        return this.zzaKK.size();
    }

    public boolean isEmpty() {
        return this.zzaKK.isEmpty();
    }

    public void zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzaKK.add(new zza(logEvent, null));
        zzyD();
    }

    public ArrayList<zza> zzyC() {
        return this.zzaKK;
    }
}
