package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzkq;
import org.bpmikc.akm.BuildConfig;

public final class zzc {
    public static zzkq<Integer> zzafC;

    public static final class zza {
        public static zzkq<Integer> zzafD;
        public static zzkq<String> zzafE;
        public static zzkq<String> zzafF;
        public static zzkq<String> zzafG;
        public static zzkq<String> zzafH;
        public static zzkq<Long> zzafI;

        static {
            zzafD = zzkq.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
            zzafE = zzkq.zzu("gms:common:stats:connections:ignored_calling_processes", BuildConfig.FLAVOR);
            zzafF = zzkq.zzu("gms:common:stats:connections:ignored_calling_services", BuildConfig.FLAVOR);
            zzafG = zzkq.zzu("gms:common:stats:connections:ignored_target_processes", BuildConfig.FLAVOR);
            zzafH = zzkq.zzu("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
            zzafI = zzkq.zza("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
        }
    }

    public static final class zzb {
        public static zzkq<Integer> zzafD;
        public static zzkq<Long> zzafI;

        static {
            zzafD = zzkq.zza("gms:common:stats:wakeLocks:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));
            zzafI = zzkq.zza("gms:common:stats:wakelocks:time_out_duration", Long.valueOf(600000));
        }
    }

    static {
        zzafC = zzkq.zza("gms:common:stats:max_num_of_events", Integer.valueOf(100));
    }
}
