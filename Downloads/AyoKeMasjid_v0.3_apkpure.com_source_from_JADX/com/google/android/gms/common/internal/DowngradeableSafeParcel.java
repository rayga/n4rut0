package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel implements SafeParcelable {
    private static final Object zzadj;
    private static ClassLoader zzadk;
    private static Integer zzadl;
    private boolean zzadm;

    static {
        zzadj = new Object();
        zzadk = null;
        zzadl = null;
    }

    public DowngradeableSafeParcel() {
        this.zzadm = false;
    }

    private static boolean zza(Class<?> cls) {
        boolean z = false;
        try {
            z = SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e2) {
        }
        return z;
    }

    protected static boolean zzcj(String str) {
        ClassLoader zzoq = zzoq();
        if (zzoq == null) {
            return true;
        }
        try {
            return zza(zzoq.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader zzoq() {
        ClassLoader classLoader;
        synchronized (zzadj) {
            classLoader = zzadk;
        }
        return classLoader;
    }

    protected static Integer zzor() {
        Integer num;
        synchronized (zzadj) {
            num = zzadl;
        }
        return num;
    }

    protected boolean zzos() {
        return this.zzadm;
    }
}
