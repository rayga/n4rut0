package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzof;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class zzb extends zzd {
    private final zzl zzLq;

    /* renamed from: com.google.android.gms.analytics.internal.zzb.1 */
    class C02381 implements Runnable {
        final /* synthetic */ int zzLr;
        final /* synthetic */ zzb zzLs;

        C02381(zzb com_google_android_gms_analytics_internal_zzb, int i) {
            this.zzLs = com_google_android_gms_analytics_internal_zzb;
            this.zzLr = i;
        }

        public void run() {
            this.zzLs.zzLq.zzs(((long) this.zzLr) * 1000);
        }
    }

    /* renamed from: com.google.android.gms.analytics.internal.zzb.2 */
    class C02392 implements Runnable {
        final /* synthetic */ zzb zzLs;
        final /* synthetic */ boolean zzLt;

        C02392(zzb com_google_android_gms_analytics_internal_zzb, boolean z) {
            this.zzLs = com_google_android_gms_analytics_internal_zzb;
            this.zzLt = z;
        }

        public void run() {
            this.zzLs.zzLq.zzI(this.zzLt);
        }
    }

    /* renamed from: com.google.android.gms.analytics.internal.zzb.3 */
    class C02403 implements Runnable {
        final /* synthetic */ zzb zzLs;
        final /* synthetic */ String zzLu;
        final /* synthetic */ Runnable zzLv;

        C02403(zzb com_google_android_gms_analytics_internal_zzb, String str, Runnable runnable) {
            this.zzLs = com_google_android_gms_analytics_internal_zzb;
            this.zzLu = str;
            this.zzLv = runnable;
        }

        public void run() {
            this.zzLs.zzLq.zzbg(this.zzLu);
            if (this.zzLv != null) {
                this.zzLv.run();
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.internal.zzb.4 */
    class C02414 implements Runnable {
        final /* synthetic */ zzb zzLs;
        final /* synthetic */ zzab zzLw;

        C02414(zzb com_google_android_gms_analytics_internal_zzb, zzab com_google_android_gms_analytics_internal_zzab) {
            this.zzLs = com_google_android_gms_analytics_internal_zzb;
            this.zzLw = com_google_android_gms_analytics_internal_zzab;
        }

        public void run() {
            this.zzLs.zzLq.zza(this.zzLw);
        }
    }

    /* renamed from: com.google.android.gms.analytics.internal.zzb.5 */
    class C02425 implements Runnable {
        final /* synthetic */ zzb zzLs;

        C02425(zzb com_google_android_gms_analytics_internal_zzb) {
            this.zzLs = com_google_android_gms_analytics_internal_zzb;
        }

        public void run() {
            this.zzLs.zzLq.zzhU();
        }
    }

    /* renamed from: com.google.android.gms.analytics.internal.zzb.6 */
    class C02436 implements Runnable {
        final /* synthetic */ zzb zzLs;
        final /* synthetic */ zzw zzLx;

        C02436(zzb com_google_android_gms_analytics_internal_zzb, zzw com_google_android_gms_analytics_internal_zzw) {
            this.zzLs = com_google_android_gms_analytics_internal_zzb;
            this.zzLx = com_google_android_gms_analytics_internal_zzw;
        }

        public void run() {
            this.zzLs.zzLq.zzb(this.zzLx);
        }
    }

    /* renamed from: com.google.android.gms.analytics.internal.zzb.7 */
    class C02447 implements Callable<Void> {
        final /* synthetic */ zzb zzLs;

        C02447(zzb com_google_android_gms_analytics_internal_zzb) {
            this.zzLs = com_google_android_gms_analytics_internal_zzb;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzgp();
        }

        public Void zzgp() throws Exception {
            this.zzLs.zzLq.zziT();
            return null;
        }
    }

    public zzb(zzf com_google_android_gms_analytics_internal_zzf, zzg com_google_android_gms_analytics_internal_zzg) {
        super(com_google_android_gms_analytics_internal_zzf);
        zzx.zzv(com_google_android_gms_analytics_internal_zzg);
        this.zzLq = com_google_android_gms_analytics_internal_zzg.zzj(com_google_android_gms_analytics_internal_zzf);
    }

    void onServiceConnected() {
        zzic();
        this.zzLq.onServiceConnected();
    }

    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        zzio();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(dispatchPeriodInSeconds));
        zzig().zzf(new C02381(this, dispatchPeriodInSeconds));
    }

    public void start() {
        this.zzLq.start();
    }

    public void zzI(boolean z) {
        zza("Network connectivity status changed", Boolean.valueOf(z));
        zzig().zzf(new C02392(this, z));
    }

    public long zza(zzh com_google_android_gms_analytics_internal_zzh) {
        zzio();
        zzx.zzv(com_google_android_gms_analytics_internal_zzh);
        zzic();
        long zza = this.zzLq.zza(com_google_android_gms_analytics_internal_zzh, true);
        if (zza == 0) {
            this.zzLq.zzc(com_google_android_gms_analytics_internal_zzh);
        }
        return zza;
    }

    public void zza(zzab com_google_android_gms_analytics_internal_zzab) {
        zzx.zzv(com_google_android_gms_analytics_internal_zzab);
        zzio();
        zzb("Hit delivery requested", com_google_android_gms_analytics_internal_zzab);
        zzig().zzf(new C02414(this, com_google_android_gms_analytics_internal_zzab));
    }

    public void zza(zzw com_google_android_gms_analytics_internal_zzw) {
        zzio();
        zzig().zzf(new C02436(this, com_google_android_gms_analytics_internal_zzw));
    }

    public void zza(String str, Runnable runnable) {
        zzx.zzh(str, "campaign param can't be empty");
        zzig().zzf(new C02403(this, str, runnable));
    }

    protected void zzhB() {
        this.zzLq.zza();
    }

    public void zzhU() {
        zzio();
        zzib();
        zzig().zzf(new C02425(this));
    }

    public void zzhV() {
        zzio();
        Context context = getContext();
        if (AnalyticsReceiver.zzV(context) && AnalyticsService.zzW(context)) {
            Intent intent = new Intent(context, AnalyticsService.class);
            intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            context.startService(intent);
            return;
        }
        zza(null);
    }

    public boolean zzhW() {
        zzio();
        try {
            zzig().zzb(new C02447(this)).get();
            return true;
        } catch (InterruptedException e) {
            zzd("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zze("syncDispatchLocalHits failed", e2);
            return false;
        }
    }

    public void zzhX() {
        zzio();
        zzof.zzic();
        this.zzLq.zzhX();
    }

    public void zzhY() {
        zzaY("Radio powered up");
        zzhV();
    }

    void zzhZ() {
        zzic();
        this.zzLq.zzhZ();
    }
}
