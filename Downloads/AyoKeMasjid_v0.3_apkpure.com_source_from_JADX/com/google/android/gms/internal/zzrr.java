package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzrr<M extends zzrr<M>> extends zzrx {
    protected zzrt zzbca;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzDl();
    }

    protected int zzB() {
        int i = 0;
        if (this.zzbca == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.zzbca.size()) {
            i2 += this.zzbca.zzlB(i).zzB();
            i++;
        }
        return i2;
    }

    protected final int zzDk() {
        return (this.zzbca == null || this.zzbca.isEmpty()) ? 0 : this.zzbca.hashCode();
    }

    public M zzDl() throws CloneNotSupportedException {
        zzrr com_google_android_gms_internal_zzrr = (zzrr) super.zzDm();
        zzrv.zza(this, com_google_android_gms_internal_zzrr);
        return com_google_android_gms_internal_zzrr;
    }

    public /* synthetic */ zzrx zzDm() throws CloneNotSupportedException {
        return zzDl();
    }

    public final <T> T zza(zzrs<M, T> com_google_android_gms_internal_zzrs_M__T) {
        if (this.zzbca == null) {
            return null;
        }
        zzru zzlA = this.zzbca.zzlA(zzsa.zzlE(com_google_android_gms_internal_zzrs_M__T.tag));
        return zzlA != null ? zzlA.zzb(com_google_android_gms_internal_zzrs_M__T) : null;
    }

    public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
        if (this.zzbca != null) {
            for (int i = 0; i < this.zzbca.size(); i++) {
                this.zzbca.zzlB(i).zza(com_google_android_gms_internal_zzrq);
            }
        }
    }

    protected final boolean zza(zzrp com_google_android_gms_internal_zzrp, int i) throws IOException {
        int position = com_google_android_gms_internal_zzrp.getPosition();
        if (!com_google_android_gms_internal_zzrp.zzlj(i)) {
            return false;
        }
        int zzlE = zzsa.zzlE(i);
        zzrz com_google_android_gms_internal_zzrz = new zzrz(i, com_google_android_gms_internal_zzrp.zzy(position, com_google_android_gms_internal_zzrp.getPosition() - position));
        zzru com_google_android_gms_internal_zzru = null;
        if (this.zzbca == null) {
            this.zzbca = new zzrt();
        } else {
            com_google_android_gms_internal_zzru = this.zzbca.zzlA(zzlE);
        }
        if (com_google_android_gms_internal_zzru == null) {
            com_google_android_gms_internal_zzru = new zzru();
            this.zzbca.zza(zzlE, com_google_android_gms_internal_zzru);
        }
        com_google_android_gms_internal_zzru.zza(com_google_android_gms_internal_zzrz);
        return true;
    }

    protected final boolean zza(M m) {
        return (this.zzbca == null || this.zzbca.isEmpty()) ? m.zzbca == null || m.zzbca.isEmpty() : this.zzbca.equals(m.zzbca);
    }
}
