package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf.zzj;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzcm implements zze {
    private boolean mClosed;
    private final Context mContext;
    private final String zzaOS;
    private String zzaPp;
    private zzbf<zzj> zzaRo;
    private zzs zzaRp;
    private final ScheduledExecutorService zzaRr;
    private final zza zzaRs;
    private ScheduledFuture<?> zzaRt;

    interface zza {
        zzcl zza(zzs com_google_android_gms_tagmanager_zzs);
    }

    interface zzb {
        ScheduledExecutorService zzAC();
    }

    /* renamed from: com.google.android.gms.tagmanager.zzcm.1 */
    class C08321 implements zzb {
        final /* synthetic */ zzcm zzaRu;

        C08321(zzcm com_google_android_gms_tagmanager_zzcm) {
            this.zzaRu = com_google_android_gms_tagmanager_zzcm;
        }

        public ScheduledExecutorService zzAC() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzcm.2 */
    class C08332 implements zza {
        final /* synthetic */ zzcm zzaRu;

        C08332(zzcm com_google_android_gms_tagmanager_zzcm) {
            this.zzaRu = com_google_android_gms_tagmanager_zzcm;
        }

        public zzcl zza(zzs com_google_android_gms_tagmanager_zzs) {
            return new zzcl(this.zzaRu.mContext, this.zzaRu.zzaOS, com_google_android_gms_tagmanager_zzs);
        }
    }

    public zzcm(Context context, String str, zzs com_google_android_gms_tagmanager_zzs) {
        this(context, str, com_google_android_gms_tagmanager_zzs, null, null);
    }

    zzcm(Context context, String str, zzs com_google_android_gms_tagmanager_zzs, zzb com_google_android_gms_tagmanager_zzcm_zzb, zza com_google_android_gms_tagmanager_zzcm_zza) {
        this.zzaRp = com_google_android_gms_tagmanager_zzs;
        this.mContext = context;
        this.zzaOS = str;
        if (com_google_android_gms_tagmanager_zzcm_zzb == null) {
            com_google_android_gms_tagmanager_zzcm_zzb = new C08321(this);
        }
        this.zzaRr = com_google_android_gms_tagmanager_zzcm_zzb.zzAC();
        if (com_google_android_gms_tagmanager_zzcm_zza == null) {
            this.zzaRs = new C08332(this);
        } else {
            this.zzaRs = com_google_android_gms_tagmanager_zzcm_zza;
        }
    }

    private synchronized void zzAB() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    private zzcl zzeR(String str) {
        zzcl zza = this.zzaRs.zza(this.zzaRp);
        zza.zza(this.zzaRo);
        zza.zzeB(this.zzaPp);
        zza.zzeQ(str);
        return zza;
    }

    public synchronized void release() {
        zzAB();
        if (this.zzaRt != null) {
            this.zzaRt.cancel(false);
        }
        this.zzaRr.shutdown();
        this.mClosed = true;
    }

    public synchronized void zza(zzbf<zzj> com_google_android_gms_tagmanager_zzbf_com_google_android_gms_internal_zzaf_zzj) {
        zzAB();
        this.zzaRo = com_google_android_gms_tagmanager_zzbf_com_google_android_gms_internal_zzaf_zzj;
    }

    public synchronized void zzeB(String str) {
        zzAB();
        this.zzaPp = str;
    }

    public synchronized void zzf(long j, String str) {
        zzbg.m17v("loadAfterDelay: containerId=" + this.zzaOS + " delay=" + j);
        zzAB();
        if (this.zzaRo == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.zzaRt != null) {
            this.zzaRt.cancel(false);
        }
        this.zzaRt = this.zzaRr.schedule(zzeR(str), j, TimeUnit.MILLISECONDS);
    }
}
