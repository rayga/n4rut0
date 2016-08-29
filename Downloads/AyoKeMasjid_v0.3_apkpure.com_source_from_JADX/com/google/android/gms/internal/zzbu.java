package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;

@zzgk
public abstract class zzbu<T> {
    private final String zztP;
    private final T zztQ;

    /* renamed from: com.google.android.gms.internal.zzbu.1 */
    static class C07541 extends zzbu<Boolean> {
        C07541(String str, Boolean bool) {
            super(bool, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzb(sharedPreferences);
        }

        public Boolean zzb(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzdd()).booleanValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbu.2 */
    static class C07552 extends zzbu<Integer> {
        C07552(String str, Integer num) {
            super(num, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzc(sharedPreferences);
        }

        public Integer zzc(SharedPreferences sharedPreferences) {
            return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzdd()).intValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbu.3 */
    static class C07563 extends zzbu<Long> {
        C07563(String str, Long l) {
            super(l, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zzd(sharedPreferences);
        }

        public Long zzd(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzdd()).longValue()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbu.4 */
    static class C07574 extends zzbu<String> {
        C07574(String str, String str2) {
            super(str2, null);
        }

        public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
            return zze(sharedPreferences);
        }

        public String zze(SharedPreferences sharedPreferences) {
            return sharedPreferences.getString(getKey(), (String) zzdd());
        }
    }

    private zzbu(String str, T t) {
        this.zztP = str;
        this.zztQ = t;
        zzp.zzbF().zza(this);
    }

    public static zzbu<String> zzP(String str) {
        zzbu<String> zzc = zzc(str, (String) null);
        zzp.zzbF().zzb(zzc);
        return zzc;
    }

    public static zzbu<String> zzQ(String str) {
        zzbu<String> zzc = zzc(str, (String) null);
        zzp.zzbF().zzc(zzc);
        return zzc;
    }

    public static zzbu<Integer> zza(String str, int i) {
        return new C07552(str, Integer.valueOf(i));
    }

    public static zzbu<Boolean> zza(String str, Boolean bool) {
        return new C07541(str, bool);
    }

    public static zzbu<Long> zzb(String str, long j) {
        return new C07563(str, Long.valueOf(j));
    }

    public static zzbu<String> zzc(String str, String str2) {
        return new C07574(str, str2);
    }

    public T get() {
        return zzp.zzbG().zzd(this);
    }

    public String getKey() {
        return this.zztP;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public T zzdd() {
        return this.zztQ;
    }
}
