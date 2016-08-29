package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.zzpl;

public final class zzo {
    public static final int zzaeh;
    private static final String zzaei;
    private final String zzaej;
    private final String zzaek;

    static {
        zzaeh = 23 - " PII_LOG".length();
        zzaei = null;
    }

    public zzo(String str) {
        this(str, zzaei);
    }

    public zzo(String str, String str2) {
        zzx.zzb((Object) str, (Object) "log tag cannot be null");
        zzx.zzb(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, Integer.valueOf(23));
        this.zzaej = str;
        if (str2 == null || str2.length() <= 0) {
            this.zzaek = zzaei;
        } else {
            this.zzaek = str2;
        }
    }

    private String zzcq(String str) {
        return this.zzaek == null ? str : this.zzaek.concat(str);
    }

    public void zza(Context context, String str, String str2, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < stackTrace.length && i < 2) {
            stringBuilder.append(stackTrace[i].toString());
            stringBuilder.append("\n");
            i++;
        }
        zzpl com_google_android_gms_internal_zzpl = new zzpl(context, 10);
        com_google_android_gms_internal_zzpl.zza("GMS_WTF", null, "GMS_WTF", stringBuilder.toString());
        com_google_android_gms_internal_zzpl.send();
        if (zzbC(7)) {
            Log.e(str, zzcq(str2), th);
            Log.wtf(str, zzcq(str2), th);
        }
    }

    public void zza(String str, String str2, Throwable th) {
        if (zzbC(4)) {
            Log.i(str, zzcq(str2), th);
        }
    }

    public void zzb(String str, String str2, Throwable th) {
        if (zzbC(5)) {
            Log.w(str, zzcq(str2), th);
        }
    }

    public boolean zzbC(int i) {
        return Log.isLoggable(this.zzaej, i);
    }

    public void zzc(String str, String str2, Throwable th) {
        if (zzbC(6)) {
            Log.e(str, zzcq(str2), th);
        }
    }

    public void zzv(String str, String str2) {
        if (zzbC(3)) {
            Log.d(str, zzcq(str2));
        }
    }

    public void zzw(String str, String str2) {
        if (zzbC(5)) {
            Log.w(str, zzcq(str2));
        }
    }

    public void zzx(String str, String str2) {
        if (zzbC(6)) {
            Log.e(str, zzcq(str2));
        }
    }
}
