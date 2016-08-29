package com.google.android.gms.common.stats;

import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import org.bpmikc.akm.BuildConfig;

public class zzf {
    public static String zza(WakeLock wakeLock, String str) {
        StringBuilder append = new StringBuilder().append(String.valueOf((Process.myPid() << 32) | System.identityHashCode(wakeLock)));
        if (TextUtils.isEmpty(str)) {
            str = BuildConfig.FLAVOR;
        }
        return append.append(str).toString();
    }
}
