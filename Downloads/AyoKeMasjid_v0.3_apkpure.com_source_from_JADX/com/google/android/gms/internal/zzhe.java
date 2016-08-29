package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzhj.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Future;

@zzgk
public class zzhe extends zzhq implements zzhd {
    private final Context mContext;
    private final zza zzCF;
    private final HashSet<String> zzGA;
    private final zzgx zzGB;
    private final String zzGh;
    private final ArrayList<Future> zzGy;
    private final ArrayList<String> zzGz;
    private final Object zzpc;

    /* renamed from: com.google.android.gms.internal.zzhe.1 */
    class C03811 implements Runnable {
        final /* synthetic */ zzhe zzGC;
        final /* synthetic */ zzhj zzpx;

        C03811(zzhe com_google_android_gms_internal_zzhe, zzhj com_google_android_gms_internal_zzhj) {
            this.zzGC = com_google_android_gms_internal_zzhe;
            this.zzpx = com_google_android_gms_internal_zzhj;
        }

        public void run() {
            this.zzGC.zzGB.zzb(this.zzpx);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhe.2 */
    class C03822 implements Runnable {
        final /* synthetic */ zzhe zzGC;
        final /* synthetic */ zzhj zzpx;

        C03822(zzhe com_google_android_gms_internal_zzhe, zzhj com_google_android_gms_internal_zzhj) {
            this.zzGC = com_google_android_gms_internal_zzhe;
            this.zzpx = com_google_android_gms_internal_zzhj;
        }

        public void run() {
            this.zzGC.zzGB.zzb(this.zzpx);
        }
    }

    public zzhe(Context context, String str, zza com_google_android_gms_internal_zzhj_zza, zzgx com_google_android_gms_internal_zzgx) {
        this.zzGy = new ArrayList();
        this.zzGz = new ArrayList();
        this.zzGA = new HashSet();
        this.zzpc = new Object();
        this.mContext = context;
        this.zzGh = str;
        this.zzCF = com_google_android_gms_internal_zzhj_zza;
        this.zzGB = com_google_android_gms_internal_zzgx;
    }

    private void zzk(String str, String str2) {
        synchronized (this.zzpc) {
            zzgy zzar = this.zzGB.zzar(str);
            if (zzar == null || zzar.zzfR() == null || zzar.zzfQ() == null) {
                return;
            }
            this.zzGy.add(new zzgz(this.mContext, str, this.zzGh, str2, this.zzCF, zzar, this).zzgn());
            this.zzGz.add(str);
        }
    }

    public void onStop() {
    }

    public void zzas(String str) {
        synchronized (this.zzpc) {
            this.zzGA.add(str);
        }
    }

    public void zzb(String str, int i) {
    }

    public void zzdG() {
        for (zzdz com_google_android_gms_internal_zzdz : this.zzCF.zzGG.zzyu) {
            String str = com_google_android_gms_internal_zzdz.zzyr;
            for (String zzk : com_google_android_gms_internal_zzdz.zzym) {
                zzk(zzk, str);
            }
        }
        int i = 0;
        while (i < this.zzGy.size()) {
            try {
                ((Future) this.zzGy.get(i)).get();
                synchronized (this.zzpc) {
                    if (this.zzGA.contains(this.zzGz.get(i))) {
                        com.google.android.gms.ads.internal.util.client.zza.zzIy.post(new C03811(this, new zzhj(this.zzCF.zzGL.zzDy, null, this.zzCF.zzGM.zzyw, -2, this.zzCF.zzGM.zzyx, this.zzCF.zzGM.zzDZ, this.zzCF.zzGM.orientation, this.zzCF.zzGM.zzyA, this.zzCF.zzGL.zzDB, this.zzCF.zzGM.zzDX, (zzdz) this.zzCF.zzGG.zzyu.get(i), null, (String) this.zzGz.get(i), this.zzCF.zzGG, null, this.zzCF.zzGM.zzDY, this.zzCF.zzqf, this.zzCF.zzGM.zzDW, this.zzCF.zzGI, this.zzCF.zzGM.zzEb, this.zzCF.zzGM.zzEc, this.zzCF.zzGF, null, this.zzCF.zzGL.zzDO)));
                        return;
                    }
                    i++;
                }
            } catch (InterruptedException e) {
            } catch (Exception e2) {
            }
        }
        com.google.android.gms.ads.internal.util.client.zza.zzIy.post(new C03822(this, new zzhj(this.zzCF.zzGL.zzDy, null, this.zzCF.zzGM.zzyw, 3, this.zzCF.zzGM.zzyx, this.zzCF.zzGM.zzDZ, this.zzCF.zzGM.orientation, this.zzCF.zzGM.zzyA, this.zzCF.zzGL.zzDB, this.zzCF.zzGM.zzDX, null, null, null, this.zzCF.zzGG, null, this.zzCF.zzGM.zzDY, this.zzCF.zzqf, this.zzCF.zzGM.zzDW, this.zzCF.zzGI, this.zzCF.zzGM.zzEb, this.zzCF.zzGM.zzEc, this.zzCF.zzGF, null, this.zzCF.zzGL.zzDO)));
    }
}
