package com.google.android.gms.fitness;

import android.content.Intent;
import android.os.Build.VERSION;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzmk;
import com.google.android.gms.internal.zzml;
import com.google.android.gms.internal.zzmm;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmn.zza;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.internal.zzmp.zzb;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zznk;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zznp;
import com.google.android.gms.internal.zznq;
import com.google.android.gms.internal.zznr;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zznu;
import java.util.concurrent.TimeUnit;

public class Fitness {
    public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
    public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
    public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
    @Deprecated
    public static final Void API;
    public static final Api<NoOptions> BLE_API;
    public static final BleApi BleApi;
    public static final Api<NoOptions> CONFIG_API;
    public static final ConfigApi ConfigApi;
    public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
    public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
    public static final Api<NoOptions> HISTORY_API;
    public static final HistoryApi HistoryApi;
    public static final Api<NoOptions> RECORDING_API;
    public static final RecordingApi RecordingApi;
    public static final Scope SCOPE_ACTIVITY_READ;
    public static final Scope SCOPE_ACTIVITY_READ_WRITE;
    public static final Scope SCOPE_BODY_READ;
    public static final Scope SCOPE_BODY_READ_WRITE;
    public static final Scope SCOPE_LOCATION_READ;
    public static final Scope SCOPE_LOCATION_READ_WRITE;
    public static final Scope SCOPE_NUTRITION_READ;
    public static final Scope SCOPE_NUTRITION_READ_WRITE;
    public static final Api<NoOptions> SENSORS_API;
    public static final Api<NoOptions> SESSIONS_API;
    public static final SensorsApi SensorsApi;
    public static final SessionsApi SessionsApi;
    public static final Api<NoOptions> zzagz;
    public static final zzc<zzmk> zzanc;
    public static final zzc<zzml> zzand;
    public static final zzc<zzmm> zzane;
    public static final zzc<zzmn> zzanf;
    public static final zzc<zzmo> zzang;
    public static final zzc<zzmp> zzanh;
    public static final zzc<zzmq> zzani;
    public static final zznk zzanj;

    static {
        zzanc = new zzc();
        zzand = new zzc();
        zzane = new zzc();
        zzanf = new zzc();
        zzang = new zzc();
        zzanh = new zzc();
        zzani = new zzc();
        API = null;
        SENSORS_API = new Api("Fitness.SENSORS_API", new zzb(), zzanh);
        SensorsApi = new zznr();
        RECORDING_API = new Api("Fitness.RECORDING_API", new zzmo.zzb(), zzang);
        RecordingApi = new zznq();
        SESSIONS_API = new Api("Fitness.SESSIONS_API", new zzmq.zzb(), zzani);
        SessionsApi = new zzns();
        HISTORY_API = new Api("Fitness.HISTORY_API", new zzmm.zzb(), zzane);
        HistoryApi = new zzno();
        CONFIG_API = new Api("Fitness.CONFIG_API", new zzml.zzb(), zzand);
        ConfigApi = new zznn();
        BLE_API = new Api("Fitness.BLE_API", new zzmk.zzb(), zzanc);
        BleApi = zzrs();
        zzagz = new Api("Fitness.INTERNAL_API", new zza(), zzanf);
        zzanj = new zznp();
        SCOPE_ACTIVITY_READ = new Scope(Scopes.FITNESS_ACTIVITY_READ);
        SCOPE_ACTIVITY_READ_WRITE = new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE);
        SCOPE_LOCATION_READ = new Scope(Scopes.FITNESS_LOCATION_READ);
        SCOPE_LOCATION_READ_WRITE = new Scope(Scopes.FITNESS_LOCATION_READ_WRITE);
        SCOPE_BODY_READ = new Scope(Scopes.FITNESS_BODY_READ);
        SCOPE_BODY_READ_WRITE = new Scope(Scopes.FITNESS_BODY_READ_WRITE);
        SCOPE_NUTRITION_READ = new Scope(Scopes.FITNESS_NUTRITION_READ);
        SCOPE_NUTRITION_READ_WRITE = new Scope(Scopes.FITNESS_NUTRITION_READ_WRITE);
    }

    private Fitness() {
    }

    public static long getEndTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_END_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    public static long getStartTime(Intent intent, TimeUnit timeUnit) {
        long longExtra = intent.getLongExtra(EXTRA_START_TIME, -1);
        return longExtra == -1 ? -1 : timeUnit.convert(longExtra, TimeUnit.MILLISECONDS);
    }

    private static BleApi zzrs() {
        return VERSION.SDK_INT >= 18 ? new zznm() : new zznu();
    }
}
