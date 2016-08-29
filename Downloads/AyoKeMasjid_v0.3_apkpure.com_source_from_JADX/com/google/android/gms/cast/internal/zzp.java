package com.google.android.gms.cast.internal;

import android.os.SystemClock;

public final class zzp {
    private static final zzl zzTy;
    public static final Object zzXT;
    private long zzWo;
    private long zzXQ;
    private long zzXR;
    private zzo zzXS;

    static {
        zzTy = new zzl("RequestTracker");
        zzXT = new Object();
    }

    public zzp(long j) {
        this.zzXQ = j;
        this.zzWo = -1;
        this.zzXR = 0;
    }

    private void zzmN() {
        this.zzWo = -1;
        this.zzXS = null;
        this.zzXR = 0;
    }

    public void clear() {
        synchronized (zzXT) {
            if (this.zzWo != -1) {
                zzmN();
            }
        }
    }

    public boolean zzB(long j) {
        boolean z;
        synchronized (zzXT) {
            z = this.zzWo != -1 && this.zzWo == j;
        }
        return z;
    }

    public void zza(long j, zzo com_google_android_gms_cast_internal_zzo) {
        synchronized (zzXT) {
            zzo com_google_android_gms_cast_internal_zzo2 = this.zzXS;
            long j2 = this.zzWo;
            this.zzWo = j;
            this.zzXS = com_google_android_gms_cast_internal_zzo;
            this.zzXR = SystemClock.elapsedRealtime();
        }
        if (com_google_android_gms_cast_internal_zzo2 != null) {
            com_google_android_gms_cast_internal_zzo2.zzy(j2);
        }
    }

    public boolean zzc(long j, int i) {
        return zzc(j, i, null);
    }

    public boolean zzc(long j, int i, Object obj) {
        boolean z = true;
        zzo com_google_android_gms_cast_internal_zzo = null;
        synchronized (zzXT) {
            if (this.zzWo == -1 || this.zzWo != j) {
                z = false;
            } else {
                zzTy.zzb("request %d completed", Long.valueOf(this.zzWo));
                com_google_android_gms_cast_internal_zzo = this.zzXS;
                zzmN();
            }
        }
        if (com_google_android_gms_cast_internal_zzo != null) {
            com_google_android_gms_cast_internal_zzo.zza(j, i, obj);
        }
        return z;
    }

    public boolean zzd(long j, int i) {
        zzo com_google_android_gms_cast_internal_zzo;
        boolean z = true;
        long j2 = 0;
        synchronized (zzXT) {
            if (this.zzWo == -1 || j - this.zzXR < this.zzXQ) {
                z = false;
                com_google_android_gms_cast_internal_zzo = null;
            } else {
                zzTy.zzb("request %d timed out", Long.valueOf(this.zzWo));
                j2 = this.zzWo;
                com_google_android_gms_cast_internal_zzo = this.zzXS;
                zzmN();
            }
        }
        if (com_google_android_gms_cast_internal_zzo != null) {
            com_google_android_gms_cast_internal_zzo.zza(j2, i, null);
        }
        return z;
    }

    public boolean zzmO() {
        boolean z;
        synchronized (zzXT) {
            z = this.zzWo != -1;
        }
        return z;
    }
}
