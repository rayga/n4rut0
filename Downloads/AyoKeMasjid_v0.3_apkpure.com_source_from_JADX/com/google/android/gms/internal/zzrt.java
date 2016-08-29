package com.google.android.gms.internal;

class zzrt implements Cloneable {
    private static final zzru zzbcd;
    private int mSize;
    private boolean zzbce;
    private int[] zzbcf;
    private zzru[] zzbcg;

    static {
        zzbcd = new zzru();
    }

    public zzrt() {
        this(10);
    }

    public zzrt(int i) {
        this.zzbce = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzbcf = new int[idealIntArraySize];
        this.zzbcg = new zzru[idealIntArraySize];
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.zzbcf;
        zzru[] com_google_android_gms_internal_zzruArr = this.zzbcg;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzru com_google_android_gms_internal_zzru = com_google_android_gms_internal_zzruArr[i3];
            if (com_google_android_gms_internal_zzru != zzbcd) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    com_google_android_gms_internal_zzruArr[i2] = com_google_android_gms_internal_zzru;
                    com_google_android_gms_internal_zzruArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzbce = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    private int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzru[] com_google_android_gms_internal_zzruArr, zzru[] com_google_android_gms_internal_zzruArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!com_google_android_gms_internal_zzruArr[i2].equals(com_google_android_gms_internal_zzruArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzlC(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzbcf[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzDn();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzrt)) {
            return false;
        }
        zzrt com_google_android_gms_internal_zzrt = (zzrt) o;
        if (size() != com_google_android_gms_internal_zzrt.size()) {
            return false;
        }
        return zza(this.zzbcf, com_google_android_gms_internal_zzrt.zzbcf, this.mSize) && zza(this.zzbcg, com_google_android_gms_internal_zzrt.zzbcg, this.mSize);
    }

    public int hashCode() {
        if (this.zzbce) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzbcf[i2]) * 31) + this.zzbcg[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        if (this.zzbce) {
            gc();
        }
        return this.mSize;
    }

    public final zzrt zzDn() {
        int i = 0;
        int size = size();
        zzrt com_google_android_gms_internal_zzrt = new zzrt(size);
        System.arraycopy(this.zzbcf, 0, com_google_android_gms_internal_zzrt.zzbcf, 0, size);
        while (i < size) {
            if (this.zzbcg[i] != null) {
                com_google_android_gms_internal_zzrt.zzbcg[i] = this.zzbcg[i].zzDo();
            }
            i++;
        }
        com_google_android_gms_internal_zzrt.mSize = size;
        return com_google_android_gms_internal_zzrt;
    }

    public void zza(int i, zzru com_google_android_gms_internal_zzru) {
        int zzlC = zzlC(i);
        if (zzlC >= 0) {
            this.zzbcg[zzlC] = com_google_android_gms_internal_zzru;
            return;
        }
        zzlC ^= -1;
        if (zzlC >= this.mSize || this.zzbcg[zzlC] != zzbcd) {
            if (this.zzbce && this.mSize >= this.zzbcf.length) {
                gc();
                zzlC = zzlC(i) ^ -1;
            }
            if (this.mSize >= this.zzbcf.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                Object obj = new int[idealIntArraySize];
                Object obj2 = new zzru[idealIntArraySize];
                System.arraycopy(this.zzbcf, 0, obj, 0, this.zzbcf.length);
                System.arraycopy(this.zzbcg, 0, obj2, 0, this.zzbcg.length);
                this.zzbcf = obj;
                this.zzbcg = obj2;
            }
            if (this.mSize - zzlC != 0) {
                System.arraycopy(this.zzbcf, zzlC, this.zzbcf, zzlC + 1, this.mSize - zzlC);
                System.arraycopy(this.zzbcg, zzlC, this.zzbcg, zzlC + 1, this.mSize - zzlC);
            }
            this.zzbcf[zzlC] = i;
            this.zzbcg[zzlC] = com_google_android_gms_internal_zzru;
            this.mSize++;
            return;
        }
        this.zzbcf[zzlC] = i;
        this.zzbcg[zzlC] = com_google_android_gms_internal_zzru;
    }

    public zzru zzlA(int i) {
        int zzlC = zzlC(i);
        return (zzlC < 0 || this.zzbcg[zzlC] == zzbcd) ? null : this.zzbcg[zzlC];
    }

    public zzru zzlB(int i) {
        if (this.zzbce) {
            gc();
        }
        return this.zzbcg[i];
    }
}
