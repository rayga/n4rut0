package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public abstract class zzc extends zzd {
    protected final Handler mHandler;
    protected final long zzWG;
    protected final Runnable zzWH;
    protected boolean zzWI;

    private class zza implements Runnable {
        final /* synthetic */ zzc zzWJ;

        private zza(zzc com_google_android_gms_cast_internal_zzc) {
            this.zzWJ = com_google_android_gms_cast_internal_zzc;
        }

        public void run() {
            this.zzWJ.zzWI = false;
            this.zzWJ.zzU(this.zzWJ.zzz(SystemClock.elapsedRealtime()));
        }
    }

    public zzc(String str, String str2, String str3) {
        this(str, str2, str3, 1000);
    }

    public zzc(String str, String str2, String str3, long j) {
        super(str, str2, str3);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.zzWH = new zza();
        this.zzWG = j;
        zzU(false);
    }

    protected final void zzU(boolean z) {
        if (this.zzWI != z) {
            this.zzWI = z;
            if (z) {
                this.mHandler.postDelayed(this.zzWH, this.zzWG);
            } else {
                this.mHandler.removeCallbacks(this.zzWH);
            }
        }
    }

    public void zzmt() {
        zzU(false);
    }

    protected abstract boolean zzz(long j);
}
