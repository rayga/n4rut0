package com.google.android.gms.vision;

import android.util.SparseArray;

public class zza {
    private static int zzaVg;
    private static final Object zzpm;
    private SparseArray<Integer> zzaVh;
    private SparseArray<Integer> zzaVi;

    static {
        zzpm = new Object();
        zzaVg = 0;
    }

    public zza() {
        this.zzaVh = new SparseArray();
        this.zzaVi = new SparseArray();
    }

    public int zzjo(int i) {
        int intValue;
        synchronized (zzpm) {
            Integer num = (Integer) this.zzaVh.get(i);
            if (num != null) {
                intValue = num.intValue();
            } else {
                intValue = zzaVg;
                zzaVg++;
                this.zzaVh.append(i, Integer.valueOf(intValue));
                this.zzaVi.append(intValue, Integer.valueOf(i));
            }
        }
        return intValue;
    }

    public int zzjp(int i) {
        int intValue;
        synchronized (zzpm) {
            intValue = ((Integer) this.zzaVi.get(i)).intValue();
        }
        return intValue;
    }
}
