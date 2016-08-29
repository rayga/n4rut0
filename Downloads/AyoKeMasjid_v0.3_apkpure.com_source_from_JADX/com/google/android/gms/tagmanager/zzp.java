package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlo;
import com.google.android.gms.internal.zzqk;
import com.google.android.gms.internal.zzqo;
import org.bpmikc.akm.BuildConfig;

public class zzp extends com.google.android.gms.common.api.zzb<ContainerHolder> {
    private final Context mContext;
    private final Looper zzYV;
    private final String zzaOS;
    private long zzaOX;
    private final TagManager zzaPe;
    private final zzd zzaPh;
    private final zzcd zzaPi;
    private final int zzaPj;
    private zzf zzaPk;
    private zzqk zzaPl;
    private volatile zzo zzaPm;
    private volatile boolean zzaPn;
    private zzj zzaPo;
    private String zzaPp;
    private zze zzaPq;
    private zza zzaPr;
    private final zzlm zzpO;

    interface zza {
        boolean zzb(Container container);
    }

    /* renamed from: com.google.android.gms.tagmanager.zzp.1 */
    class C08421 implements com.google.android.gms.internal.zzqk.zza {
        final /* synthetic */ String zzaPs;
        final /* synthetic */ zzp zzaPt;

        /* renamed from: com.google.android.gms.tagmanager.zzp.1.1 */
        class C08411 implements com.google.android.gms.tagmanager.zzo.zza {
            final /* synthetic */ C08421 zzaPu;

            C08411(C08421 c08421) {
                this.zzaPu = c08421;
            }

            public void zzey(String str) {
                this.zzaPu.zzaPt.zzey(str);
            }

            public String zzzE() {
                return this.zzaPu.zzaPt.zzzE();
            }

            public void zzzG() {
                if (this.zzaPu.zzaPt.zzaPi.zzkp()) {
                    this.zzaPu.zzaPt.load(this.zzaPu.zzaPs);
                }
            }
        }

        C08421(zzp com_google_android_gms_tagmanager_zzp, String str) {
            this.zzaPt = com_google_android_gms_tagmanager_zzp;
            this.zzaPs = str;
        }

        public void zza(zzqo com_google_android_gms_internal_zzqo) {
            if (com_google_android_gms_internal_zzqo.getStatus() != Status.zzaaD) {
                zzbg.m16e("Load request failed for the container " + this.zzaPt.zzaOS);
                this.zzaPt.zza(this.zzaPt.zzbg(Status.zzaaF));
                return;
            }
            com.google.android.gms.internal.zzqp.zzc zzBA = com_google_android_gms_internal_zzqo.zzBw().zzBA();
            if (zzBA == null) {
                String str = "Response doesn't have the requested container";
                zzbg.m16e(str);
                this.zzaPt.zza(this.zzaPt.zzbg(new Status(8, str, null)));
                return;
            }
            this.zzaPt.zzaPm = new zzo(this.zzaPt.zzaPe, this.zzaPt.zzYV, new Container(this.zzaPt.mContext, this.zzaPt.zzaPe.getDataLayer(), this.zzaPt.zzaOS, com_google_android_gms_internal_zzqo.zzBw().zzBB(), zzBA), new C08411(this));
            this.zzaPt.zza(this.zzaPt.zzaPm);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzp.2 */
    class C08432 implements com.google.android.gms.tagmanager.zzo.zza {
        final /* synthetic */ zzp zzaPt;

        C08432(zzp com_google_android_gms_tagmanager_zzp) {
            this.zzaPt = com_google_android_gms_tagmanager_zzp;
        }

        public void zzey(String str) {
            this.zzaPt.zzey(str);
        }

        public String zzzE() {
            return this.zzaPt.zzzE();
        }

        public void zzzG() {
            zzbg.zzaE("Refresh ignored: container loaded as default only.");
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.zzp.3 */
    class C08443 implements zza {
        final /* synthetic */ zzp zzaPt;
        final /* synthetic */ boolean zzaPv;

        C08443(zzp com_google_android_gms_tagmanager_zzp, boolean z) {
            this.zzaPt = com_google_android_gms_tagmanager_zzp;
            this.zzaPv = z;
        }

        public boolean zzb(Container container) {
            return this.zzaPv ? container.getLastRefreshTime() + 43200000 >= this.zzaPt.zzpO.currentTimeMillis() : !container.isDefault();
        }
    }

    private class zzb implements zzbf<com.google.android.gms.internal.zzqh.zza> {
        final /* synthetic */ zzp zzaPt;

        private zzb(zzp com_google_android_gms_tagmanager_zzp) {
            this.zzaPt = com_google_android_gms_tagmanager_zzp;
        }

        public /* synthetic */ void zzB(Object obj) {
            zza((com.google.android.gms.internal.zzqh.zza) obj);
        }

        public void zza(com.google.android.gms.internal.zzqh.zza com_google_android_gms_internal_zzqh_zza) {
            zzj com_google_android_gms_internal_zzaf_zzj;
            if (com_google_android_gms_internal_zzqh_zza.zzaTu != null) {
                com_google_android_gms_internal_zzaf_zzj = com_google_android_gms_internal_zzqh_zza.zzaTu;
            } else {
                com.google.android.gms.internal.zzaf.zzf com_google_android_gms_internal_zzaf_zzf = com_google_android_gms_internal_zzqh_zza.zziR;
                com_google_android_gms_internal_zzaf_zzj = new zzj();
                com_google_android_gms_internal_zzaf_zzj.zziR = com_google_android_gms_internal_zzaf_zzf;
                com_google_android_gms_internal_zzaf_zzj.zziQ = null;
                com_google_android_gms_internal_zzaf_zzj.zziS = com_google_android_gms_internal_zzaf_zzf.version;
            }
            this.zzaPt.zza(com_google_android_gms_internal_zzaf_zzj, com_google_android_gms_internal_zzqh_zza.zzaTt, true);
        }

        public void zza(com.google.android.gms.tagmanager.zzbf.zza com_google_android_gms_tagmanager_zzbf_zza) {
            if (!this.zzaPt.zzaPn) {
                this.zzaPt.zzR(0);
            }
        }

        public void zzzL() {
        }
    }

    private class zzc implements zzbf<zzj> {
        final /* synthetic */ zzp zzaPt;

        private zzc(zzp com_google_android_gms_tagmanager_zzp) {
            this.zzaPt = com_google_android_gms_tagmanager_zzp;
        }

        public /* synthetic */ void zzB(Object obj) {
            zzb((zzj) obj);
        }

        public void zza(com.google.android.gms.tagmanager.zzbf.zza com_google_android_gms_tagmanager_zzbf_zza) {
            synchronized (this.zzaPt) {
                if (!this.zzaPt.isReady()) {
                    if (this.zzaPt.zzaPm != null) {
                        this.zzaPt.zza(this.zzaPt.zzaPm);
                    } else {
                        this.zzaPt.zza(this.zzaPt.zzbg(Status.zzaaG));
                    }
                }
            }
            this.zzaPt.zzR(3600000);
        }

        public void zzb(zzj com_google_android_gms_internal_zzaf_zzj) {
            synchronized (this.zzaPt) {
                if (com_google_android_gms_internal_zzaf_zzj.zziR == null) {
                    if (this.zzaPt.zzaPo.zziR == null) {
                        zzbg.m16e("Current resource is null; network resource is also null");
                        this.zzaPt.zzR(3600000);
                        return;
                    }
                    com_google_android_gms_internal_zzaf_zzj.zziR = this.zzaPt.zzaPo.zziR;
                }
                this.zzaPt.zza(com_google_android_gms_internal_zzaf_zzj, this.zzaPt.zzpO.currentTimeMillis(), false);
                zzbg.m17v("setting refresh time to current time: " + this.zzaPt.zzaOX);
                if (!this.zzaPt.zzzK()) {
                    this.zzaPt.zza(com_google_android_gms_internal_zzaf_zzj);
                }
            }
        }

        public void zzzL() {
        }
    }

    private class zzd implements com.google.android.gms.tagmanager.zzo.zza {
        final /* synthetic */ zzp zzaPt;

        private zzd(zzp com_google_android_gms_tagmanager_zzp) {
            this.zzaPt = com_google_android_gms_tagmanager_zzp;
        }

        public void zzey(String str) {
            this.zzaPt.zzey(str);
        }

        public String zzzE() {
            return this.zzaPt.zzzE();
        }

        public void zzzG() {
            if (this.zzaPt.zzaPi.zzkp()) {
                this.zzaPt.zzR(0);
            }
        }
    }

    interface zze extends Releasable {
        void zza(zzbf<zzj> com_google_android_gms_tagmanager_zzbf_com_google_android_gms_internal_zzaf_zzj);

        void zzeB(String str);

        void zzf(long j, String str);
    }

    interface zzf extends Releasable {
        void zza(zzbf<com.google.android.gms.internal.zzqh.zza> com_google_android_gms_tagmanager_zzbf_com_google_android_gms_internal_zzqh_zza);

        void zzb(com.google.android.gms.internal.zzqh.zza com_google_android_gms_internal_zzqh_zza);

        com.google.android.gms.internal.zzqp.zzc zzjc(int i);

        void zzzM();
    }

    zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzf com_google_android_gms_tagmanager_zzp_zzf, zze com_google_android_gms_tagmanager_zzp_zze, zzqk com_google_android_gms_internal_zzqk, zzlm com_google_android_gms_internal_zzlm, zzcd com_google_android_gms_tagmanager_zzcd) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.zzaPe = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zzYV = looper;
        this.zzaOS = str;
        this.zzaPj = i;
        this.zzaPk = com_google_android_gms_tagmanager_zzp_zzf;
        this.zzaPq = com_google_android_gms_tagmanager_zzp_zze;
        this.zzaPl = com_google_android_gms_internal_zzqk;
        this.zzaPh = new zzd();
        this.zzaPo = new zzj();
        this.zzpO = com_google_android_gms_internal_zzlm;
        this.zzaPi = com_google_android_gms_tagmanager_zzcd;
        if (zzzK()) {
            zzey(zzcb.zzAv().zzAx());
        }
    }

    public zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzs com_google_android_gms_tagmanager_zzs) {
        this(context, tagManager, looper, str, i, new zzcn(context, str), new zzcm(context, str, com_google_android_gms_tagmanager_zzs), new zzqk(context), zzlo.zzpN(), new zzbe(30, 900000, 5000, "refreshing", zzlo.zzpN()));
        this.zzaPl.zzfj(com_google_android_gms_tagmanager_zzs.zzzN());
    }

    private synchronized void zzR(long j) {
        if (this.zzaPq == null) {
            zzbg.zzaE("Refresh requested, but no network load scheduler.");
        } else {
            this.zzaPq.zzf(j, this.zzaPo.zziS);
        }
    }

    private synchronized void zza(zzj com_google_android_gms_internal_zzaf_zzj) {
        if (this.zzaPk != null) {
            com.google.android.gms.internal.zzqh.zza com_google_android_gms_internal_zzqh_zza = new com.google.android.gms.internal.zzqh.zza();
            com_google_android_gms_internal_zzqh_zza.zzaTt = this.zzaOX;
            com_google_android_gms_internal_zzqh_zza.zziR = new com.google.android.gms.internal.zzaf.zzf();
            com_google_android_gms_internal_zzqh_zza.zzaTu = com_google_android_gms_internal_zzaf_zzj;
            this.zzaPk.zzb(com_google_android_gms_internal_zzqh_zza);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void zza(com.google.android.gms.internal.zzaf.zzj r9, long r10, boolean r12) {
        /*
        r8 = this;
        r6 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        monitor-enter(r8);
        if (r12 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.zzaPn;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);
        return;
    L_0x000c:
        r0 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r8.zzaPm;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0016;
    L_0x0016:
        r8.zzaPo = r9;	 Catch:{ all -> 0x006a }
        r8.zzaOX = r10;	 Catch:{ all -> 0x006a }
        r0 = 0;
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r4 = r8.zzaOX;	 Catch:{ all -> 0x006a }
        r4 = r4 + r6;
        r6 = r8.zzpO;	 Catch:{ all -> 0x006a }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x006a }
        r4 = r4 - r6;
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x006a }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ all -> 0x006a }
        r8.zzR(r0);	 Catch:{ all -> 0x006a }
        r0 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x006a }
        r1 = r8.mContext;	 Catch:{ all -> 0x006a }
        r2 = r8.zzaPe;	 Catch:{ all -> 0x006a }
        r2 = r2.getDataLayer();	 Catch:{ all -> 0x006a }
        r3 = r8.zzaOS;	 Catch:{ all -> 0x006a }
        r4 = r10;
        r6 = r9;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x006a }
        r1 = r8.zzaPm;	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x006d;
    L_0x0049:
        r1 = new com.google.android.gms.tagmanager.zzo;	 Catch:{ all -> 0x006a }
        r2 = r8.zzaPe;	 Catch:{ all -> 0x006a }
        r3 = r8.zzYV;	 Catch:{ all -> 0x006a }
        r4 = r8.zzaPh;	 Catch:{ all -> 0x006a }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ all -> 0x006a }
        r8.zzaPm = r1;	 Catch:{ all -> 0x006a }
    L_0x0056:
        r1 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x000a;
    L_0x005c:
        r1 = r8.zzaPr;	 Catch:{ all -> 0x006a }
        r0 = r1.zzb(r0);	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000a;
    L_0x0064:
        r0 = r8.zzaPm;	 Catch:{ all -> 0x006a }
        r8.zza(r0);	 Catch:{ all -> 0x006a }
        goto L_0x000a;
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006d:
        r1 = r8.zzaPm;	 Catch:{ all -> 0x006a }
        r1.zza(r0);	 Catch:{ all -> 0x006a }
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzp.zza(com.google.android.gms.internal.zzaf$zzj, long, boolean):void");
    }

    private void zzar(boolean z) {
        this.zzaPk.zza(new zzb());
        this.zzaPq.zza(new zzc());
        com.google.android.gms.internal.zzqp.zzc zzjc = this.zzaPk.zzjc(this.zzaPj);
        if (zzjc != null) {
            this.zzaPm = new zzo(this.zzaPe, this.zzYV, new Container(this.mContext, this.zzaPe.getDataLayer(), this.zzaOS, 0, zzjc), this.zzaPh);
        }
        this.zzaPr = new C08443(this, z);
        if (zzzK()) {
            this.zzaPq.zzf(0, BuildConfig.FLAVOR);
        } else {
            this.zzaPk.zzzM();
        }
    }

    private boolean zzzK() {
        zzcb zzAv = zzcb.zzAv();
        return (zzAv.zzAw() == zza.CONTAINER || zzAv.zzAw() == zza.CONTAINER_DEBUG) && this.zzaOS.equals(zzAv.getContainerId());
    }

    public void load(String resourceIdParameterName) {
        this.zzaPl.zza(this.zzaOS, this.zzaPj != -1 ? Integer.valueOf(this.zzaPj) : null, resourceIdParameterName, new C08421(this, resourceIdParameterName));
    }

    protected /* synthetic */ Result zzb(Status status) {
        return zzbg(status);
    }

    protected ContainerHolder zzbg(Status status) {
        if (this.zzaPm != null) {
            return this.zzaPm;
        }
        if (status == Status.zzaaG) {
            zzbg.m16e("timer expired: setting result to failure");
        }
        return new zzo(status);
    }

    synchronized void zzey(String str) {
        this.zzaPp = str;
        if (this.zzaPq != null) {
            this.zzaPq.zzeB(str);
        }
    }

    synchronized String zzzE() {
        return this.zzaPp;
    }

    public void zzzH() {
        com.google.android.gms.internal.zzqp.zzc zzjc = this.zzaPk.zzjc(this.zzaPj);
        if (zzjc != null) {
            zza(new zzo(this.zzaPe, this.zzYV, new Container(this.mContext, this.zzaPe.getDataLayer(), this.zzaOS, 0, zzjc), new C08432(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            zzbg.m16e(str);
            zza(zzbg(new Status(10, str, null)));
        }
        this.zzaPq = null;
        this.zzaPk = null;
    }

    public void zzzI() {
        zzar(false);
    }

    public void zzzJ() {
        zzar(true);
    }
}
