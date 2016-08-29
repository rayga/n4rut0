package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzhj.zza;

@zzgk
public class zzgz extends zzhq implements zzha, zzhd {
    private final Context mContext;
    private final zza zzCF;
    private int zzCI;
    private final String zzGh;
    private final zzgy zzGp;
    private final zzhd zzGq;
    private final String zzGr;
    private int zzGs;
    private final Object zzpc;
    private final String zzyH;

    /* renamed from: com.google.android.gms.internal.zzgz.1 */
    class C03791 implements Runnable {
        final /* synthetic */ zzei zzGt;
        final /* synthetic */ zzgz zzGu;
        final /* synthetic */ AdRequestParcel zzpd;

        C03791(zzgz com_google_android_gms_internal_zzgz, zzei com_google_android_gms_internal_zzei, AdRequestParcel adRequestParcel) {
            this.zzGu = com_google_android_gms_internal_zzgz;
            this.zzGt = com_google_android_gms_internal_zzei;
            this.zzpd = adRequestParcel;
        }

        public void run() {
            try {
                this.zzGt.zza(this.zzpd, this.zzGu.zzGr);
            } catch (Throwable e) {
                zzb.zzd("Fail to load ad from adapter.", e);
                this.zzGu.zzb(this.zzGu.zzyH, 0);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgz.2 */
    class C03802 implements Runnable {
        final /* synthetic */ zzei zzGt;
        final /* synthetic */ zzgz zzGu;
        final /* synthetic */ zzhc zzGv;
        final /* synthetic */ AdRequestParcel zzpd;

        C03802(zzgz com_google_android_gms_internal_zzgz, zzei com_google_android_gms_internal_zzei, AdRequestParcel adRequestParcel, zzhc com_google_android_gms_internal_zzhc) {
            this.zzGu = com_google_android_gms_internal_zzgz;
            this.zzGt = com_google_android_gms_internal_zzei;
            this.zzpd = adRequestParcel;
            this.zzGv = com_google_android_gms_internal_zzhc;
        }

        public void run() {
            try {
                this.zzGt.zza(zze.zzx(this.zzGu.mContext), this.zzpd, this.zzGu.zzGh, this.zzGv, this.zzGu.zzGr);
            } catch (Throwable e) {
                zzb.zzd("Fail to initialize adapter " + this.zzGu.zzyH, e);
                this.zzGu.zzb(this.zzGu.zzyH, 0);
            }
        }
    }

    public zzgz(Context context, String str, String str2, String str3, zza com_google_android_gms_internal_zzhj_zza, zzgy com_google_android_gms_internal_zzgy, zzhd com_google_android_gms_internal_zzhd) {
        this.zzGs = 0;
        this.zzCI = 3;
        this.mContext = context;
        this.zzyH = str;
        this.zzGh = str2;
        this.zzGr = str3;
        this.zzCF = com_google_android_gms_internal_zzhj_zza;
        this.zzGp = com_google_android_gms_internal_zzgy;
        this.zzpc = new Object();
        this.zzGq = com_google_android_gms_internal_zzhd;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzk(long r4) {
        /*
        r3 = this;
    L_0x0000:
        r1 = r3.zzpc;
        monitor-enter(r1);
        r0 = r3.zzGs;	 Catch:{ all -> 0x0011 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x0011 }
    L_0x0008:
        return;
    L_0x0009:
        r0 = r3.zze(r4);	 Catch:{ all -> 0x0011 }
        if (r0 != 0) goto L_0x0014;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x0011 }
        goto L_0x0008;
    L_0x0011:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0011 }
        throw r0;
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x0011 }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgz.zzk(long):void");
    }

    public void onStop() {
    }

    public void zzJ(int i) {
        zzb(this.zzyH, 0);
    }

    public void zzas(String str) {
        synchronized (this.zzpc) {
            this.zzGs = 1;
            this.zzpc.notify();
        }
    }

    public void zzb(String str, int i) {
        synchronized (this.zzpc) {
            this.zzGs = 2;
            this.zzCI = i;
            this.zzpc.notify();
        }
    }

    public void zzdG() {
        if (this.zzGp != null && this.zzGp.zzfR() != null && this.zzGp.zzfQ() != null) {
            zzhc zzfR = this.zzGp.zzfR();
            zzfR.zza((zzhd) this);
            zzfR.zza((zzha) this);
            AdRequestParcel adRequestParcel = this.zzCF.zzGL.zzDy;
            zzei zzfQ = this.zzGp.zzfQ();
            try {
                if (zzfQ.isInitialized()) {
                    com.google.android.gms.ads.internal.util.client.zza.zzIy.post(new C03791(this, zzfQ, adRequestParcel));
                } else {
                    com.google.android.gms.ads.internal.util.client.zza.zzIy.post(new C03802(this, zzfQ, adRequestParcel, zzfR));
                }
            } catch (Throwable e) {
                zzb.zzd("Fail to check if adapter is initialized.", e);
                zzb(this.zzyH, 0);
            }
            zzk(zzp.zzbB().elapsedRealtime());
            zzfR.zza(null);
            zzfR.zza(null);
            if (this.zzGs == 1) {
                this.zzGq.zzas(this.zzyH);
            } else {
                this.zzGq.zzb(this.zzyH, this.zzCI);
            }
        }
    }

    protected boolean zze(long j) {
        long elapsedRealtime = 20000 - (zzp.zzbB().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzpc.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public void zzfS() {
        this.zzGp.zzfR();
        AdRequestParcel adRequestParcel = this.zzCF.zzGL.zzDy;
        try {
            this.zzGp.zzfQ().zza(adRequestParcel, this.zzGr);
        } catch (Throwable e) {
            zzb.zzd("Fail to load ad from adapter.", e);
            zzb(this.zzyH, 0);
        }
    }
}
