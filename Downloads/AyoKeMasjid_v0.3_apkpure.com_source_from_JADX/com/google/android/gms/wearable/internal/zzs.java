package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.internal.zzat.zza;

public final class zzs extends zza {
    private zzl zzaZZ;
    private zzt zzbad;
    private final Object zzpc;

    public zzs() {
        this.zzpc = new Object();
    }

    public void zza(zzt com_google_android_gms_wearable_internal_zzt) {
        synchronized (this.zzpc) {
            this.zzbad = (zzt) zzx.zzv(com_google_android_gms_wearable_internal_zzt);
            zzl com_google_android_gms_wearable_internal_zzl = this.zzaZZ;
        }
        if (com_google_android_gms_wearable_internal_zzl != null) {
            com_google_android_gms_wearable_internal_zzt.zzb(com_google_android_gms_wearable_internal_zzl);
        }
    }

    public void zzx(int i, int i2) {
        synchronized (this.zzpc) {
            zzt com_google_android_gms_wearable_internal_zzt = this.zzbad;
            zzl com_google_android_gms_wearable_internal_zzl = new zzl(i, i2);
            this.zzaZZ = com_google_android_gms_wearable_internal_zzl;
        }
        if (com_google_android_gms_wearable_internal_zzt != null) {
            com_google_android_gms_wearable_internal_zzt.zzb(com_google_android_gms_wearable_internal_zzl);
        }
    }
}
