package com.google.android.gms.internal;

import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzrs<M extends zzrr<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzbcb;
    protected final boolean zzbcc;

    private zzrs(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.zzbcb = cls;
        this.tag = i2;
        this.zzbcc = z;
    }

    @Deprecated
    public static <M extends zzrr<M>, T extends zzrx> zzrs<M, T> zza(int i, Class<T> cls, int i2) {
        return new zzrs(i, cls, i2, false);
    }

    private T zzy(List<zzrz> list) {
        int i;
        int i2 = 0;
        List arrayList = new ArrayList();
        for (i = 0; i < list.size(); i++) {
            zzrz com_google_android_gms_internal_zzrz = (zzrz) list.get(i);
            if (com_google_android_gms_internal_zzrz.zzbcm.length != 0) {
                zza(com_google_android_gms_internal_zzrz, arrayList);
            }
        }
        i = arrayList.size();
        if (i == 0) {
            return null;
        }
        T cast = this.zzbcb.cast(Array.newInstance(this.zzbcb.getComponentType(), i));
        while (i2 < i) {
            Array.set(cast, i2, arrayList.get(i2));
            i2++;
        }
        return cast;
    }

    private T zzz(List<zzrz> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.zzbcb.cast(zzA(zzrp.zzz(((zzrz) list.get(list.size() - 1)).zzbcm)));
    }

    protected Object zzA(zzrp com_google_android_gms_internal_zzrp) {
        Class componentType = this.zzbcc ? this.zzbcb.getComponentType() : this.zzbcb;
        try {
            zzrx com_google_android_gms_internal_zzrx;
            switch (this.type) {
                case Barcode.GEO /*10*/:
                    com_google_android_gms_internal_zzrx = (zzrx) componentType.newInstance();
                    com_google_android_gms_internal_zzrp.zza(com_google_android_gms_internal_zzrx, zzsa.zzlE(this.tag));
                    return com_google_android_gms_internal_zzrx;
                case Barcode.CALENDAR_EVENT /*11*/:
                    com_google_android_gms_internal_zzrx = (zzrx) componentType.newInstance();
                    com_google_android_gms_internal_zzrp.zza(com_google_android_gms_internal_zzrx);
                    return com_google_android_gms_internal_zzrx;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }

    int zzS(Object obj) {
        return this.zzbcc ? zzT(obj) : zzU(obj);
    }

    protected int zzT(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzU(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected int zzU(Object obj) {
        int zzlE = zzsa.zzlE(this.tag);
        switch (this.type) {
            case Barcode.GEO /*10*/:
                return zzrq.zzb(zzlE, (zzrx) obj);
            case Barcode.CALENDAR_EVENT /*11*/:
                return zzrq.zzc(zzlE, (zzrx) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    protected void zza(zzrz com_google_android_gms_internal_zzrz, List<Object> list) {
        list.add(zzA(zzrp.zzz(com_google_android_gms_internal_zzrz.zzbcm)));
    }

    void zza(Object obj, zzrq com_google_android_gms_internal_zzrq) throws IOException {
        if (this.zzbcc) {
            zzc(obj, com_google_android_gms_internal_zzrq);
        } else {
            zzb(obj, com_google_android_gms_internal_zzrq);
        }
    }

    protected void zzb(Object obj, zzrq com_google_android_gms_internal_zzrq) {
        try {
            com_google_android_gms_internal_zzrq.zzlw(this.tag);
            switch (this.type) {
                case Barcode.GEO /*10*/:
                    zzrx com_google_android_gms_internal_zzrx = (zzrx) obj;
                    int zzlE = zzsa.zzlE(this.tag);
                    com_google_android_gms_internal_zzrq.zzb(com_google_android_gms_internal_zzrx);
                    com_google_android_gms_internal_zzrq.zzD(zzlE, 4);
                    return;
                case Barcode.CALENDAR_EVENT /*11*/:
                    com_google_android_gms_internal_zzrq.zzc((zzrx) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected void zzc(Object obj, zzrq com_google_android_gms_internal_zzrq) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, com_google_android_gms_internal_zzrq);
            }
        }
    }

    final T zzx(List<zzrz> list) {
        return list == null ? null : this.zzbcc ? zzy(list) : zzz(list);
    }
}
