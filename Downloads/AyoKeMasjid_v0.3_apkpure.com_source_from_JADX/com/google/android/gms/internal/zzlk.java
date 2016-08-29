package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.regex.Pattern;

public final class zzlk {
    private static Pattern zzagc;

    static {
        zzagc = null;
    }

    public static boolean zzao(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int zzbV(int i) {
        return i / GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE;
    }

    public static int zzbW(int i) {
        return (i % GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE) / 100;
    }

    public static boolean zzbX(int i) {
        return zzbW(i) == 3;
    }
}
