package org.bpmikc.akm.Fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class Utils {
    private static final String DEFAULT_ALARM_ACTIVITY = "com.android.deskclock.AlarmClock";
    private static final String[] DESK_CLOCK_PACKAGES;
    private static final String[] OTHER_CLOCK_PACKAGES;
    private static final String SELECT_TAB_INTENT_EXTRA = "deskclock.select.tab";
    public static boolean isRestartNeeded;
    private static boolean mIsForeground;

    static {
        DESK_CLOCK_PACKAGES = new String[]{"com.google.android.deskclock", "com.android.deskclock"};
        OTHER_CLOCK_PACKAGES = new String[]{"com.sec.android.app.clockpackage"};
        mIsForeground = false;
        isRestartNeeded = false;
    }

    public static Intent getDefaultAlarmsIntent(Context context) {
        int i = 0;
        PackageManager pm = context.getPackageManager();
        String[] strArr = DESK_CLOCK_PACKAGES;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String packageName = strArr[i2];
            try {
                Intent intent;
                if (302 >= pm.getPackageInfo(packageName, 0).versionCode) {
                    intent = pm.getLaunchIntentForPackage(packageName);
                    intent.putExtra(SELECT_TAB_INTENT_EXTRA, 0);
                    return intent;
                }
                ComponentName cn = new ComponentName(packageName, DEFAULT_ALARM_ACTIVITY);
                pm.getActivityInfo(cn, 0);
                intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(cn);
                return intent;
            } catch (NameNotFoundException e) {
                i2++;
            }
        }
        String[] strArr2 = OTHER_CLOCK_PACKAGES;
        int length2 = strArr2.length;
        while (i < length2) {
            packageName = strArr2[i];
            try {
                pm.getPackageInfo(packageName, 0);
                return pm.getLaunchIntentForPackage(packageName);
            } catch (NameNotFoundException e2) {
                i++;
            }
        }
        return null;
    }

    public static boolean getIsForeground() {
        return mIsForeground;
    }

    public static void setIsForeground(boolean isForeground) {
        mIsForeground = isForeground;
    }
}
