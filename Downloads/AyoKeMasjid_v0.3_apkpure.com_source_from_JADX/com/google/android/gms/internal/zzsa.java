package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsa {
    public static final int[] zzbcn;
    public static final long[] zzbco;
    public static final float[] zzbcp;
    public static final double[] zzbcq;
    public static final boolean[] zzbcr;
    public static final String[] zzbcs;
    public static final byte[][] zzbct;
    public static final byte[] zzbcu;

    static {
        zzbcn = new int[0];
        zzbco = new long[0];
        zzbcp = new float[0];
        zzbcq = new double[0];
        zzbcr = new boolean[0];
        zzbcs = new String[0];
        zzbct = new byte[0][];
        zzbcu = new byte[0];
    }

    static int zzE(int i, int i2) {
        return (i << 3) | i2;
    }

    public static final int zzb(zzrp com_google_android_gms_internal_zzrp, int i) throws IOException {
        int i2 = 1;
        int position = com_google_android_gms_internal_zzrp.getPosition();
        com_google_android_gms_internal_zzrp.zzlj(i);
        while (com_google_android_gms_internal_zzrp.zzCT() == i) {
            com_google_android_gms_internal_zzrp.zzlj(i);
            i2++;
        }
        com_google_android_gms_internal_zzrp.zzln(position);
        return i2;
    }

    static int zzlD(int i) {
        return i & 7;
    }

    public static int zzlE(int i) {
        return i >>> 3;
    }
}
