package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzmi {
    private static int zzaoL;

    static {
        zzaoL = -1;
    }

    public static boolean zzat(Context context) {
        return zzaw(context) == 3;
    }

    private static int zzau(Context context) {
        return ((zzav(context) % GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE) / 100) + 5;
    }

    private static int zzav(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    public static int zzaw(Context context) {
        if (zzaoL == -1) {
            switch (zzau(context)) {
                case Barcode.URL /*8*/:
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    zzaoL = 0;
                    break;
                case Barcode.GEO /*10*/:
                    zzaoL = 3;
                    break;
                default:
                    zzaoL = zzax(context) ? 1 : 2;
                    break;
            }
        }
        return zzaoL;
    }

    private static boolean zzax(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
    }
}
