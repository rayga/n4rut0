package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzrx {
    protected volatile int zzbcl;

    public zzrx() {
        this.zzbcl = -1;
    }

    public static final <T extends zzrx> T zza(T t, byte[] bArr) throws zzrw {
        return zzb(t, bArr, 0, bArr.length);
    }

    public static final void zza(zzrx com_google_android_gms_internal_zzrx, byte[] bArr, int i, int i2) {
        try {
            zzrq zzb = zzrq.zzb(bArr, i, i2);
            com_google_android_gms_internal_zzrx.zza(zzb);
            zzb.zzDj();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends zzrx> T zzb(T t, byte[] bArr, int i, int i2) throws zzrw {
        try {
            zzrp zza = zzrp.zza(bArr, i, i2);
            t.zzb(zza);
            zza.zzli(0);
            return t;
        } catch (zzrw e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] zzf(zzrx com_google_android_gms_internal_zzrx) {
        byte[] bArr = new byte[com_google_android_gms_internal_zzrx.zzDx()];
        zza(com_google_android_gms_internal_zzrx, bArr, 0, bArr.length);
        return bArr;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzDm();
    }

    public String toString() {
        return zzry.zzg(this);
    }

    protected int zzB() {
        return 0;
    }

    public zzrx zzDm() throws CloneNotSupportedException {
        return (zzrx) super.clone();
    }

    public int zzDw() {
        if (this.zzbcl < 0) {
            zzDx();
        }
        return this.zzbcl;
    }

    public int zzDx() {
        int zzB = zzB();
        this.zzbcl = zzB;
        return zzB;
    }

    public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
    }

    public abstract zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException;
}
