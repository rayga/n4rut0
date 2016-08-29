package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.zzo;

public final class GamesLog {
    private static final zzo zzaul;

    static {
        zzaul = new zzo("Games");
    }

    private GamesLog() {
    }

    public static void zza(String str, String str2, Throwable th) {
        zzaul.zza(str, str2, th);
    }

    public static void zzb(String str, String str2, Throwable th) {
        zzaul.zzb(str, str2, th);
    }

    public static void zzw(String str, String str2) {
        zzaul.zzw(str, str2);
    }

    public static void zzx(String str, String str2) {
        zzaul.zzx(str, str2);
    }
}
