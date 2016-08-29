package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;

public final class zzrn extends zzrr<zzrn> {
    public String[] zzbbK;
    public int[] zzbbL;
    public byte[][] zzbbM;

    public zzrn() {
        zzCS();
    }

    public static zzrn zzx(byte[] bArr) throws zzrw {
        return (zzrn) zzrx.zza(new zzrn(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzrn)) {
            return false;
        }
        zzrn com_google_android_gms_internal_zzrn = (zzrn) o;
        return (zzrv.equals(this.zzbbK, com_google_android_gms_internal_zzrn.zzbbK) && zzrv.equals(this.zzbbL, com_google_android_gms_internal_zzrn.zzbbL) && zzrv.zza(this.zzbbM, com_google_android_gms_internal_zzrn.zzbbM)) ? zza((zzrr) com_google_android_gms_internal_zzrn) : false;
    }

    public int hashCode() {
        return ((((((zzrv.hashCode(this.zzbbK) + 527) * 31) + zzrv.hashCode(this.zzbbL)) * 31) + zzrv.zza(this.zzbbM)) * 31) + zzDk();
    }

    protected int zzB() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int zzB = super.zzB();
        if (this.zzbbK == null || this.zzbbK.length <= 0) {
            i = zzB;
        } else {
            i2 = 0;
            i3 = 0;
            for (String str : this.zzbbK) {
                if (str != null) {
                    i3++;
                    i2 += zzrq.zzfy(str);
                }
            }
            i = (zzB + i2) + (i3 * 1);
        }
        if (this.zzbbL != null && this.zzbbL.length > 0) {
            i3 = 0;
            for (int zzB2 : this.zzbbL) {
                i3 += zzrq.zzls(zzB2);
            }
            i = (i + i3) + (this.zzbbL.length * 1);
        }
        if (this.zzbbM == null || this.zzbbM.length <= 0) {
            return i;
        }
        i2 = 0;
        i3 = 0;
        while (i4 < this.zzbbM.length) {
            byte[] bArr = this.zzbbM[i4];
            if (bArr != null) {
                i3++;
                i2 += zzrq.zzC(bArr);
            }
            i4++;
        }
        return (i + i2) + (i3 * 1);
    }

    public zzrn zzCS() {
        this.zzbbK = zzsa.zzbcs;
        this.zzbbL = zzsa.zzbcn;
        this.zzbbM = zzsa.zzbct;
        this.zzbca = null;
        this.zzbcl = -1;
        return this;
    }

    public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
        int i = 0;
        if (this.zzbbK != null && this.zzbbK.length > 0) {
            for (String str : this.zzbbK) {
                if (str != null) {
                    com_google_android_gms_internal_zzrq.zzb(1, str);
                }
            }
        }
        if (this.zzbbL != null && this.zzbbL.length > 0) {
            for (int zzz : this.zzbbL) {
                com_google_android_gms_internal_zzrq.zzz(2, zzz);
            }
        }
        if (this.zzbbM != null && this.zzbbM.length > 0) {
            while (i < this.zzbbM.length) {
                byte[] bArr = this.zzbbM[i];
                if (bArr != null) {
                    com_google_android_gms_internal_zzrq.zza(3, bArr);
                }
                i++;
            }
        }
        super.zza(com_google_android_gms_internal_zzrq);
    }

    public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
        return zzz(com_google_android_gms_internal_zzrp);
    }

    public zzrn zzz(zzrp com_google_android_gms_internal_zzrp) throws IOException {
        while (true) {
            int zzCT = com_google_android_gms_internal_zzrp.zzCT();
            int zzb;
            Object obj;
            switch (zzCT) {
                case SpinnerCompat.MODE_DIALOG /*0*/:
                    break;
                case Barcode.GEO /*10*/:
                    zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 10);
                    zzCT = this.zzbbK == null ? 0 : this.zzbbK.length;
                    obj = new String[(zzb + zzCT)];
                    if (zzCT != 0) {
                        System.arraycopy(this.zzbbK, 0, obj, 0, zzCT);
                    }
                    while (zzCT < obj.length - 1) {
                        obj[zzCT] = com_google_android_gms_internal_zzrp.readString();
                        com_google_android_gms_internal_zzrp.zzCT();
                        zzCT++;
                    }
                    obj[zzCT] = com_google_android_gms_internal_zzrp.readString();
                    this.zzbbK = obj;
                    continue;
                case Barcode.DATA_MATRIX /*16*/:
                    zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 16);
                    zzCT = this.zzbbL == null ? 0 : this.zzbbL.length;
                    obj = new int[(zzb + zzCT)];
                    if (zzCT != 0) {
                        System.arraycopy(this.zzbbL, 0, obj, 0, zzCT);
                    }
                    while (zzCT < obj.length - 1) {
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        com_google_android_gms_internal_zzrp.zzCT();
                        zzCT++;
                    }
                    obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                    this.zzbbL = obj;
                    continue;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    int zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                    zzb = com_google_android_gms_internal_zzrp.getPosition();
                    zzCT = 0;
                    while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                        com_google_android_gms_internal_zzrp.zzCW();
                        zzCT++;
                    }
                    com_google_android_gms_internal_zzrp.zzln(zzb);
                    zzb = this.zzbbL == null ? 0 : this.zzbbL.length;
                    Object obj2 = new int[(zzCT + zzb)];
                    if (zzb != 0) {
                        System.arraycopy(this.zzbbL, 0, obj2, 0, zzb);
                    }
                    while (zzb < obj2.length) {
                        obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                        zzb++;
                    }
                    this.zzbbL = obj2;
                    com_google_android_gms_internal_zzrp.zzlm(zzll);
                    continue;
                case Place.TYPE_CONVENIENCE_STORE /*26*/:
                    zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 26);
                    zzCT = this.zzbbM == null ? 0 : this.zzbbM.length;
                    obj = new byte[(zzb + zzCT)][];
                    if (zzCT != 0) {
                        System.arraycopy(this.zzbbM, 0, obj, 0, zzCT);
                    }
                    while (zzCT < obj.length - 1) {
                        obj[zzCT] = com_google_android_gms_internal_zzrp.readBytes();
                        com_google_android_gms_internal_zzrp.zzCT();
                        zzCT++;
                    }
                    obj[zzCT] = com_google_android_gms_internal_zzrp.readBytes();
                    this.zzbbM = obj;
                    continue;
                default:
                    if (!zza(com_google_android_gms_internal_zzrp, zzCT)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }
}
