package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;
import net.sourceforge.jitl.astro.Utils;

public final class LogTime {
    private static final double MILLIS_MULTIPLIER;

    static {
        double d = Utils.AGGRESSIVE_ROUND_SEC;
        if (17 <= VERSION.SDK_INT) {
            d = Utils.AGGRESSIVE_ROUND_SEC / Math.pow(Utils.DEF_IMSAAK_INTERVAL, 6.0d);
        }
        MILLIS_MULTIPLIER = d;
    }

    private LogTime() {
    }

    @TargetApi(17)
    public static long getLogTime() {
        if (17 <= VERSION.SDK_INT) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return System.currentTimeMillis();
    }

    public static double getElapsedMillis(long logTime) {
        return ((double) (getLogTime() - logTime)) * MILLIS_MULTIPLIER;
    }
}
