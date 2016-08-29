package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;
import org.bpmikc.akm.BuildConfig;
import org.bpmikc.akm.C0615R;

public interface zzaf {

    public static final class zza extends zzrr<zza> {
        public int level;
        public int zzhN;
        public int zzhO;

        public zza() {
            zzA();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzaf_zza = (zza) o;
            return (this.level == com_google_android_gms_internal_zzaf_zza.level && this.zzhN == com_google_android_gms_internal_zzaf_zza.zzhN && this.zzhO == com_google_android_gms_internal_zzaf_zza.zzhO) ? zza((zzrr) com_google_android_gms_internal_zzaf_zza) : false;
        }

        public int hashCode() {
            return ((((((this.level + 527) * 31) + this.zzhN) * 31) + this.zzhO) * 31) + zzDk();
        }

        public zza zzA() {
            this.level = 1;
            this.zzhN = 0;
            this.zzhO = 0;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (this.level != 1) {
                zzB += zzrq.zzB(1, this.level);
            }
            if (this.zzhN != 0) {
                zzB += zzrq.zzB(2, this.zzhN);
            }
            return this.zzhO != 0 ? zzB + zzrq.zzB(3, this.zzhO) : zzB;
        }

        public zza zza(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.URL /*8*/:
                        zzCT = com_google_android_gms_internal_zzrp.zzCW();
                        switch (zzCT) {
                            case CompletionEvent.STATUS_FAILURE /*1*/:
                            case CompletionEvent.STATUS_CONFLICT /*2*/:
                            case CompletionEvent.STATUS_CANCELED /*3*/:
                                this.level = zzCT;
                                break;
                            default:
                                continue;
                        }
                    case Barcode.DATA_MATRIX /*16*/:
                        this.zzhN = com_google_android_gms_internal_zzrp.zzCW();
                        continue;
                    case Place.TYPE_CITY_HALL /*24*/:
                        this.zzhO = com_google_android_gms_internal_zzrp.zzCW();
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

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            if (this.level != 1) {
                com_google_android_gms_internal_zzrq.zzz(1, this.level);
            }
            if (this.zzhN != 0) {
                com_google_android_gms_internal_zzrq.zzz(2, this.zzhN);
            }
            if (this.zzhO != 0) {
                com_google_android_gms_internal_zzrq.zzz(3, this.zzhO);
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zza(com_google_android_gms_internal_zzrp);
        }
    }

    public static final class zzb extends zzrr<zzb> {
        private static volatile zzb[] zzhP;
        public int name;
        public int[] zzhQ;
        public int zzhR;
        public boolean zzhS;
        public boolean zzhT;

        public zzb() {
            zzD();
        }

        public static zzb[] zzC() {
            if (zzhP == null) {
                synchronized (zzrv.zzbck) {
                    if (zzhP == null) {
                        zzhP = new zzb[0];
                    }
                }
            }
            return zzhP;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzaf_zzb = (zzb) o;
            return (zzrv.equals(this.zzhQ, com_google_android_gms_internal_zzaf_zzb.zzhQ) && this.zzhR == com_google_android_gms_internal_zzaf_zzb.zzhR && this.name == com_google_android_gms_internal_zzaf_zzb.name && this.zzhS == com_google_android_gms_internal_zzaf_zzb.zzhS && this.zzhT == com_google_android_gms_internal_zzaf_zzb.zzhT) ? zza((zzrr) com_google_android_gms_internal_zzaf_zzb) : false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zzhS ? 1231 : 1237) + ((((((zzrv.hashCode(this.zzhQ) + 527) * 31) + this.zzhR) * 31) + this.name) * 31)) * 31;
            if (!this.zzhT) {
                i = 1237;
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        protected int zzB() {
            int i = 0;
            int zzB = super.zzB();
            if (this.zzhT) {
                zzB += zzrq.zzc(1, this.zzhT);
            }
            int zzB2 = zzrq.zzB(2, this.zzhR) + zzB;
            if (this.zzhQ == null || this.zzhQ.length <= 0) {
                zzB = zzB2;
            } else {
                for (int zzls : this.zzhQ) {
                    i += zzrq.zzls(zzls);
                }
                zzB = (zzB2 + i) + (this.zzhQ.length * 1);
            }
            if (this.name != 0) {
                zzB += zzrq.zzB(4, this.name);
            }
            return this.zzhS ? zzB + zzrq.zzc(6, this.zzhS) : zzB;
        }

        public zzb zzD() {
            this.zzhQ = zzsa.zzbcn;
            this.zzhR = 0;
            this.name = 0;
            this.zzhS = false;
            this.zzhT = false;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            if (this.zzhT) {
                com_google_android_gms_internal_zzrq.zzb(1, this.zzhT);
            }
            com_google_android_gms_internal_zzrq.zzz(2, this.zzhR);
            if (this.zzhQ != null && this.zzhQ.length > 0) {
                for (int zzz : this.zzhQ) {
                    com_google_android_gms_internal_zzrq.zzz(3, zzz);
                }
            }
            if (this.name != 0) {
                com_google_android_gms_internal_zzrq.zzz(4, this.name);
            }
            if (this.zzhS) {
                com_google_android_gms_internal_zzrq.zzb(6, this.zzhS);
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzc(com_google_android_gms_internal_zzrp);
        }

        public zzb zzc(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                int zzb;
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.URL /*8*/:
                        this.zzhT = com_google_android_gms_internal_zzrp.zzCX();
                        continue;
                    case Barcode.DATA_MATRIX /*16*/:
                        this.zzhR = com_google_android_gms_internal_zzrp.zzCW();
                        continue;
                    case Place.TYPE_CITY_HALL /*24*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 24);
                        zzCT = this.zzhQ == null ? 0 : this.zzhQ.length;
                        Object obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzhQ, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zzhQ = obj;
                        continue;
                    case Place.TYPE_CONVENIENCE_STORE /*26*/:
                        int zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zzhQ == null ? 0 : this.zzhQ.length;
                        Object obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzhQ, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zzhQ = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Barcode.EAN_13 /*32*/:
                        this.name = com_google_android_gms_internal_zzrp.zzCW();
                        continue;
                    case Place.TYPE_HINDU_TEMPLE /*48*/:
                        this.zzhS = com_google_android_gms_internal_zzrp.zzCX();
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

    public static final class zzc extends zzrr<zzc> {
        private static volatile zzc[] zzhU;
        public String key;
        public long zzhV;
        public long zzhW;
        public boolean zzhX;
        public long zzhY;

        public zzc() {
            zzF();
        }

        public static zzc[] zzE() {
            if (zzhU == null) {
                synchronized (zzrv.zzbck) {
                    if (zzhU == null) {
                        zzhU = new zzc[0];
                    }
                }
            }
            return zzhU;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzaf_zzc = (zzc) o;
            if (this.key == null) {
                if (com_google_android_gms_internal_zzaf_zzc.key != null) {
                    return false;
                }
            } else if (!this.key.equals(com_google_android_gms_internal_zzaf_zzc.key)) {
                return false;
            }
            return (this.zzhV == com_google_android_gms_internal_zzaf_zzc.zzhV && this.zzhW == com_google_android_gms_internal_zzaf_zzc.zzhW && this.zzhX == com_google_android_gms_internal_zzaf_zzc.zzhX && this.zzhY == com_google_android_gms_internal_zzaf_zzc.zzhY) ? zza((zzrr) com_google_android_gms_internal_zzaf_zzc) : false;
        }

        public int hashCode() {
            return (((((this.zzhX ? 1231 : 1237) + (((((((this.key == null ? 0 : this.key.hashCode()) + 527) * 31) + ((int) (this.zzhV ^ (this.zzhV >>> 32)))) * 31) + ((int) (this.zzhW ^ (this.zzhW >>> 32)))) * 31)) * 31) + ((int) (this.zzhY ^ (this.zzhY >>> 32)))) * 31) + zzDk();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (!this.key.equals(BuildConfig.FLAVOR)) {
                zzB += zzrq.zzl(1, this.key);
            }
            if (this.zzhV != 0) {
                zzB += zzrq.zzd(2, this.zzhV);
            }
            if (this.zzhW != 2147483647L) {
                zzB += zzrq.zzd(3, this.zzhW);
            }
            if (this.zzhX) {
                zzB += zzrq.zzc(4, this.zzhX);
            }
            return this.zzhY != 0 ? zzB + zzrq.zzd(5, this.zzhY) : zzB;
        }

        public zzc zzF() {
            this.key = BuildConfig.FLAVOR;
            this.zzhV = 0;
            this.zzhW = 2147483647L;
            this.zzhX = false;
            this.zzhY = 0;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            if (!this.key.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(1, this.key);
            }
            if (this.zzhV != 0) {
                com_google_android_gms_internal_zzrq.zzb(2, this.zzhV);
            }
            if (this.zzhW != 2147483647L) {
                com_google_android_gms_internal_zzrq.zzb(3, this.zzhW);
            }
            if (this.zzhX) {
                com_google_android_gms_internal_zzrq.zzb(4, this.zzhX);
            }
            if (this.zzhY != 0) {
                com_google_android_gms_internal_zzrq.zzb(5, this.zzhY);
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzd(com_google_android_gms_internal_zzrp);
        }

        public zzc zzd(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.GEO /*10*/:
                        this.key = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case Barcode.DATA_MATRIX /*16*/:
                        this.zzhV = com_google_android_gms_internal_zzrp.zzCV();
                        continue;
                    case Place.TYPE_CITY_HALL /*24*/:
                        this.zzhW = com_google_android_gms_internal_zzrp.zzCV();
                        continue;
                    case Barcode.EAN_13 /*32*/:
                        this.zzhX = com_google_android_gms_internal_zzrp.zzCX();
                        continue;
                    case Place.TYPE_FURNITURE_STORE /*40*/:
                        this.zzhY = com_google_android_gms_internal_zzrp.zzCV();
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

    public static final class zzd extends zzrr<zzd> {
        public com.google.android.gms.internal.zzag.zza[] zzhZ;
        public com.google.android.gms.internal.zzag.zza[] zzia;
        public zzc[] zzib;

        public zzd() {
            zzG();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzaf_zzd = (zzd) o;
            return (zzrv.equals(this.zzhZ, com_google_android_gms_internal_zzaf_zzd.zzhZ) && zzrv.equals(this.zzia, com_google_android_gms_internal_zzaf_zzd.zzia) && zzrv.equals(this.zzib, com_google_android_gms_internal_zzaf_zzd.zzib)) ? zza((zzrr) com_google_android_gms_internal_zzaf_zzd) : false;
        }

        public int hashCode() {
            return ((((((zzrv.hashCode(this.zzhZ) + 527) * 31) + zzrv.hashCode(this.zzia)) * 31) + zzrv.hashCode(this.zzib)) * 31) + zzDk();
        }

        protected int zzB() {
            int i;
            int i2 = 0;
            int zzB = super.zzB();
            if (this.zzhZ != null && this.zzhZ.length > 0) {
                i = zzB;
                for (zzrx com_google_android_gms_internal_zzrx : this.zzhZ) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        i += zzrq.zzc(1, com_google_android_gms_internal_zzrx);
                    }
                }
                zzB = i;
            }
            if (this.zzia != null && this.zzia.length > 0) {
                i = zzB;
                for (zzrx com_google_android_gms_internal_zzrx2 : this.zzia) {
                    if (com_google_android_gms_internal_zzrx2 != null) {
                        i += zzrq.zzc(2, com_google_android_gms_internal_zzrx2);
                    }
                }
                zzB = i;
            }
            if (this.zzib != null && this.zzib.length > 0) {
                while (i2 < this.zzib.length) {
                    zzrx com_google_android_gms_internal_zzrx3 = this.zzib[i2];
                    if (com_google_android_gms_internal_zzrx3 != null) {
                        zzB += zzrq.zzc(3, com_google_android_gms_internal_zzrx3);
                    }
                    i2++;
                }
            }
            return zzB;
        }

        public zzd zzG() {
            this.zzhZ = com.google.android.gms.internal.zzag.zza.zzQ();
            this.zzia = com.google.android.gms.internal.zzag.zza.zzQ();
            this.zzib = zzc.zzE();
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            int i = 0;
            if (this.zzhZ != null && this.zzhZ.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx : this.zzhZ) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        com_google_android_gms_internal_zzrq.zza(1, com_google_android_gms_internal_zzrx);
                    }
                }
            }
            if (this.zzia != null && this.zzia.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx2 : this.zzia) {
                    if (com_google_android_gms_internal_zzrx2 != null) {
                        com_google_android_gms_internal_zzrq.zza(2, com_google_android_gms_internal_zzrx2);
                    }
                }
            }
            if (this.zzib != null && this.zzib.length > 0) {
                while (i < this.zzib.length) {
                    zzrx com_google_android_gms_internal_zzrx3 = this.zzib[i];
                    if (com_google_android_gms_internal_zzrx3 != null) {
                        com_google_android_gms_internal_zzrq.zza(3, com_google_android_gms_internal_zzrx3);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zze(com_google_android_gms_internal_zzrp);
        }

        public zzd zze(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                int zzb;
                Object obj;
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.GEO /*10*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 10);
                        zzCT = this.zzhZ == null ? 0 : this.zzhZ.length;
                        obj = new com.google.android.gms.internal.zzag.zza[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzhZ, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new com.google.android.gms.internal.zzag.zza();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new com.google.android.gms.internal.zzag.zza();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzhZ = obj;
                        continue;
                    case Place.TYPE_CAR_RENTAL /*18*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 18);
                        zzCT = this.zzia == null ? 0 : this.zzia.length;
                        obj = new com.google.android.gms.internal.zzag.zza[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzia, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new com.google.android.gms.internal.zzag.zza();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new com.google.android.gms.internal.zzag.zza();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzia = obj;
                        continue;
                    case Place.TYPE_CONVENIENCE_STORE /*26*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 26);
                        zzCT = this.zzib == null ? 0 : this.zzib.length;
                        obj = new zzc[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzib, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zzc();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zzc();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzib = obj;
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

    public static final class zze extends zzrr<zze> {
        private static volatile zze[] zzic;
        public int key;
        public int value;

        public zze() {
            zzI();
        }

        public static zze[] zzH() {
            if (zzic == null) {
                synchronized (zzrv.zzbck) {
                    if (zzic == null) {
                        zzic = new zze[0];
                    }
                }
            }
            return zzic;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzaf_zze = (zze) o;
            return (this.key == com_google_android_gms_internal_zzaf_zze.key && this.value == com_google_android_gms_internal_zzaf_zze.value) ? zza((zzrr) com_google_android_gms_internal_zzaf_zze) : false;
        }

        public int hashCode() {
            return ((((this.key + 527) * 31) + this.value) * 31) + zzDk();
        }

        protected int zzB() {
            return (super.zzB() + zzrq.zzB(1, this.key)) + zzrq.zzB(2, this.value);
        }

        public zze zzI() {
            this.key = 0;
            this.value = 0;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            com_google_android_gms_internal_zzrq.zzz(1, this.key);
            com_google_android_gms_internal_zzrq.zzz(2, this.value);
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzf(com_google_android_gms_internal_zzrp);
        }

        public zze zzf(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.URL /*8*/:
                        this.key = com_google_android_gms_internal_zzrp.zzCW();
                        continue;
                    case Barcode.DATA_MATRIX /*16*/:
                        this.value = com_google_android_gms_internal_zzrp.zzCW();
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

    public static final class zzf extends zzrr<zzf> {
        public String version;
        public String[] zzid;
        public String[] zzie;
        public com.google.android.gms.internal.zzag.zza[] zzif;
        public zze[] zzig;
        public zzb[] zzih;
        public zzb[] zzii;
        public zzb[] zzij;
        public zzg[] zzik;
        public String zzil;
        public String zzim;
        public String zzin;
        public zza zzio;
        public float zzip;
        public boolean zziq;
        public String[] zzir;
        public int zzis;

        public zzf() {
            zzJ();
        }

        public static zzf zzc(byte[] bArr) throws zzrw {
            return (zzf) zzrx.zza(new zzf(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzf)) {
                return false;
            }
            zzf com_google_android_gms_internal_zzaf_zzf = (zzf) o;
            if (!zzrv.equals(this.zzid, com_google_android_gms_internal_zzaf_zzf.zzid) || !zzrv.equals(this.zzie, com_google_android_gms_internal_zzaf_zzf.zzie) || !zzrv.equals(this.zzif, com_google_android_gms_internal_zzaf_zzf.zzif) || !zzrv.equals(this.zzig, com_google_android_gms_internal_zzaf_zzf.zzig) || !zzrv.equals(this.zzih, com_google_android_gms_internal_zzaf_zzf.zzih) || !zzrv.equals(this.zzii, com_google_android_gms_internal_zzaf_zzf.zzii) || !zzrv.equals(this.zzij, com_google_android_gms_internal_zzaf_zzf.zzij) || !zzrv.equals(this.zzik, com_google_android_gms_internal_zzaf_zzf.zzik)) {
                return false;
            }
            if (this.zzil == null) {
                if (com_google_android_gms_internal_zzaf_zzf.zzil != null) {
                    return false;
                }
            } else if (!this.zzil.equals(com_google_android_gms_internal_zzaf_zzf.zzil)) {
                return false;
            }
            if (this.zzim == null) {
                if (com_google_android_gms_internal_zzaf_zzf.zzim != null) {
                    return false;
                }
            } else if (!this.zzim.equals(com_google_android_gms_internal_zzaf_zzf.zzim)) {
                return false;
            }
            if (this.zzin == null) {
                if (com_google_android_gms_internal_zzaf_zzf.zzin != null) {
                    return false;
                }
            } else if (!this.zzin.equals(com_google_android_gms_internal_zzaf_zzf.zzin)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zzaf_zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zzaf_zzf.version)) {
                return false;
            }
            if (this.zzio == null) {
                if (com_google_android_gms_internal_zzaf_zzf.zzio != null) {
                    return false;
                }
            } else if (!this.zzio.equals(com_google_android_gms_internal_zzaf_zzf.zzio)) {
                return false;
            }
            return (Float.floatToIntBits(this.zzip) == Float.floatToIntBits(com_google_android_gms_internal_zzaf_zzf.zzip) && this.zziq == com_google_android_gms_internal_zzaf_zzf.zziq && zzrv.equals(this.zzir, com_google_android_gms_internal_zzaf_zzf.zzir) && this.zzis == com_google_android_gms_internal_zzaf_zzf.zzis) ? zza((zzrr) com_google_android_gms_internal_zzaf_zzf) : false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.zzin == null ? 0 : this.zzin.hashCode()) + (((this.zzim == null ? 0 : this.zzim.hashCode()) + (((this.zzil == null ? 0 : this.zzil.hashCode()) + ((((((((((((((((zzrv.hashCode(this.zzid) + 527) * 31) + zzrv.hashCode(this.zzie)) * 31) + zzrv.hashCode(this.zzif)) * 31) + zzrv.hashCode(this.zzig)) * 31) + zzrv.hashCode(this.zzih)) * 31) + zzrv.hashCode(this.zzii)) * 31) + zzrv.hashCode(this.zzij)) * 31) + zzrv.hashCode(this.zzik)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzio != null) {
                i = this.zzio.hashCode();
            }
            return (((((((this.zziq ? 1231 : 1237) + ((((hashCode + i) * 31) + Float.floatToIntBits(this.zzip)) * 31)) * 31) + zzrv.hashCode(this.zzir)) * 31) + this.zzis) * 31) + zzDk();
        }

        protected int zzB() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int zzB = super.zzB();
            if (this.zzie == null || this.zzie.length <= 0) {
                i = zzB;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zzie) {
                    if (str != null) {
                        i3++;
                        i2 += zzrq.zzfy(str);
                    }
                }
                i = (zzB + i2) + (i3 * 1);
            }
            if (this.zzif != null && this.zzif.length > 0) {
                i2 = i;
                for (zzrx com_google_android_gms_internal_zzrx : this.zzif) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        i2 += zzrq.zzc(2, com_google_android_gms_internal_zzrx);
                    }
                }
                i = i2;
            }
            if (this.zzig != null && this.zzig.length > 0) {
                i2 = i;
                for (zzrx com_google_android_gms_internal_zzrx2 : this.zzig) {
                    if (com_google_android_gms_internal_zzrx2 != null) {
                        i2 += zzrq.zzc(3, com_google_android_gms_internal_zzrx2);
                    }
                }
                i = i2;
            }
            if (this.zzih != null && this.zzih.length > 0) {
                i2 = i;
                for (zzrx com_google_android_gms_internal_zzrx22 : this.zzih) {
                    if (com_google_android_gms_internal_zzrx22 != null) {
                        i2 += zzrq.zzc(4, com_google_android_gms_internal_zzrx22);
                    }
                }
                i = i2;
            }
            if (this.zzii != null && this.zzii.length > 0) {
                i2 = i;
                for (zzrx com_google_android_gms_internal_zzrx222 : this.zzii) {
                    if (com_google_android_gms_internal_zzrx222 != null) {
                        i2 += zzrq.zzc(5, com_google_android_gms_internal_zzrx222);
                    }
                }
                i = i2;
            }
            if (this.zzij != null && this.zzij.length > 0) {
                i2 = i;
                for (zzrx com_google_android_gms_internal_zzrx2222 : this.zzij) {
                    if (com_google_android_gms_internal_zzrx2222 != null) {
                        i2 += zzrq.zzc(6, com_google_android_gms_internal_zzrx2222);
                    }
                }
                i = i2;
            }
            if (this.zzik != null && this.zzik.length > 0) {
                i2 = i;
                for (zzrx com_google_android_gms_internal_zzrx22222 : this.zzik) {
                    if (com_google_android_gms_internal_zzrx22222 != null) {
                        i2 += zzrq.zzc(7, com_google_android_gms_internal_zzrx22222);
                    }
                }
                i = i2;
            }
            if (!this.zzil.equals(BuildConfig.FLAVOR)) {
                i += zzrq.zzl(9, this.zzil);
            }
            if (!this.zzim.equals(BuildConfig.FLAVOR)) {
                i += zzrq.zzl(10, this.zzim);
            }
            if (!this.zzin.equals("0")) {
                i += zzrq.zzl(12, this.zzin);
            }
            if (!this.version.equals(BuildConfig.FLAVOR)) {
                i += zzrq.zzl(13, this.version);
            }
            if (this.zzio != null) {
                i += zzrq.zzc(14, this.zzio);
            }
            if (Float.floatToIntBits(this.zzip) != Float.floatToIntBits(0.0f)) {
                i += zzrq.zzc(15, this.zzip);
            }
            if (this.zzir != null && this.zzir.length > 0) {
                i3 = 0;
                zzB = 0;
                for (String str2 : this.zzir) {
                    if (str2 != null) {
                        zzB++;
                        i3 += zzrq.zzfy(str2);
                    }
                }
                i = (i + i3) + (zzB * 2);
            }
            if (this.zzis != 0) {
                i += zzrq.zzB(17, this.zzis);
            }
            if (this.zziq) {
                i += zzrq.zzc(18, this.zziq);
            }
            if (this.zzid == null || this.zzid.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.zzid.length) {
                String str3 = this.zzid[i4];
                if (str3 != null) {
                    i3++;
                    i2 += zzrq.zzfy(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }

        public zzf zzJ() {
            this.zzid = zzsa.zzbcs;
            this.zzie = zzsa.zzbcs;
            this.zzif = com.google.android.gms.internal.zzag.zza.zzQ();
            this.zzig = zze.zzH();
            this.zzih = zzb.zzC();
            this.zzii = zzb.zzC();
            this.zzij = zzb.zzC();
            this.zzik = zzg.zzK();
            this.zzil = BuildConfig.FLAVOR;
            this.zzim = BuildConfig.FLAVOR;
            this.zzin = "0";
            this.version = BuildConfig.FLAVOR;
            this.zzio = null;
            this.zzip = 0.0f;
            this.zziq = false;
            this.zzir = zzsa.zzbcs;
            this.zzis = 0;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            int i = 0;
            if (this.zzie != null && this.zzie.length > 0) {
                for (String str : this.zzie) {
                    if (str != null) {
                        com_google_android_gms_internal_zzrq.zzb(1, str);
                    }
                }
            }
            if (this.zzif != null && this.zzif.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx : this.zzif) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        com_google_android_gms_internal_zzrq.zza(2, com_google_android_gms_internal_zzrx);
                    }
                }
            }
            if (this.zzig != null && this.zzig.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx2 : this.zzig) {
                    if (com_google_android_gms_internal_zzrx2 != null) {
                        com_google_android_gms_internal_zzrq.zza(3, com_google_android_gms_internal_zzrx2);
                    }
                }
            }
            if (this.zzih != null && this.zzih.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx22 : this.zzih) {
                    if (com_google_android_gms_internal_zzrx22 != null) {
                        com_google_android_gms_internal_zzrq.zza(4, com_google_android_gms_internal_zzrx22);
                    }
                }
            }
            if (this.zzii != null && this.zzii.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx222 : this.zzii) {
                    if (com_google_android_gms_internal_zzrx222 != null) {
                        com_google_android_gms_internal_zzrq.zza(5, com_google_android_gms_internal_zzrx222);
                    }
                }
            }
            if (this.zzij != null && this.zzij.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx2222 : this.zzij) {
                    if (com_google_android_gms_internal_zzrx2222 != null) {
                        com_google_android_gms_internal_zzrq.zza(6, com_google_android_gms_internal_zzrx2222);
                    }
                }
            }
            if (this.zzik != null && this.zzik.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx22222 : this.zzik) {
                    if (com_google_android_gms_internal_zzrx22222 != null) {
                        com_google_android_gms_internal_zzrq.zza(7, com_google_android_gms_internal_zzrx22222);
                    }
                }
            }
            if (!this.zzil.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(9, this.zzil);
            }
            if (!this.zzim.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(10, this.zzim);
            }
            if (!this.zzin.equals("0")) {
                com_google_android_gms_internal_zzrq.zzb(12, this.zzin);
            }
            if (!this.version.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(13, this.version);
            }
            if (this.zzio != null) {
                com_google_android_gms_internal_zzrq.zza(14, this.zzio);
            }
            if (Float.floatToIntBits(this.zzip) != Float.floatToIntBits(0.0f)) {
                com_google_android_gms_internal_zzrq.zzb(15, this.zzip);
            }
            if (this.zzir != null && this.zzir.length > 0) {
                for (String str2 : this.zzir) {
                    if (str2 != null) {
                        com_google_android_gms_internal_zzrq.zzb(16, str2);
                    }
                }
            }
            if (this.zzis != 0) {
                com_google_android_gms_internal_zzrq.zzz(17, this.zzis);
            }
            if (this.zziq) {
                com_google_android_gms_internal_zzrq.zzb(18, this.zziq);
            }
            if (this.zzid != null && this.zzid.length > 0) {
                while (i < this.zzid.length) {
                    String str3 = this.zzid[i];
                    if (str3 != null) {
                        com_google_android_gms_internal_zzrq.zzb(19, str3);
                    }
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzg(com_google_android_gms_internal_zzrp);
        }

        public zzf zzg(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                int zzb;
                Object obj;
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.GEO /*10*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 10);
                        zzCT = this.zzie == null ? 0 : this.zzie.length;
                        obj = new String[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzie, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.readString();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.readString();
                        this.zzie = obj;
                        continue;
                    case Place.TYPE_CAR_RENTAL /*18*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 18);
                        zzCT = this.zzif == null ? 0 : this.zzif.length;
                        obj = new com.google.android.gms.internal.zzag.zza[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzif, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new com.google.android.gms.internal.zzag.zza();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new com.google.android.gms.internal.zzag.zza();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzif = obj;
                        continue;
                    case Place.TYPE_CONVENIENCE_STORE /*26*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 26);
                        zzCT = this.zzig == null ? 0 : this.zzig.length;
                        obj = new zze[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzig, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zze();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zze();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzig = obj;
                        continue;
                    case Place.TYPE_ESTABLISHMENT /*34*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 34);
                        zzCT = this.zzih == null ? 0 : this.zzih.length;
                        obj = new zzb[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzih, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zzb();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zzb();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzih = obj;
                        continue;
                    case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 42);
                        zzCT = this.zzii == null ? 0 : this.zzii.length;
                        obj = new zzb[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzii, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zzb();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zzb();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzii = obj;
                        continue;
                    case Place.TYPE_HOSPITAL /*50*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 50);
                        zzCT = this.zzij == null ? 0 : this.zzij.length;
                        obj = new zzb[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzij, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zzb();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zzb();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzij = obj;
                        continue;
                    case Place.TYPE_LOCKSMITH /*58*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 58);
                        zzCT = this.zzik == null ? 0 : this.zzik.length;
                        obj = new zzg[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzik, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zzg();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zzg();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzik = obj;
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        this.zzil = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case Place.TYPE_SCHOOL /*82*/:
                        this.zzim = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case C0615R.styleable.Theme_buttonStyle /*98*/:
                        this.zzin = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case C0615R.styleable.Theme_switchStyle /*106*/:
                        this.version = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case 114:
                        if (this.zzio == null) {
                            this.zzio = new zza();
                        }
                        com_google_android_gms_internal_zzrp.zza(this.zzio);
                        continue;
                    case 125:
                        this.zzip = com_google_android_gms_internal_zzrp.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, TransportMediator.KEYCODE_MEDIA_RECORD);
                        zzCT = this.zzir == null ? 0 : this.zzir.length;
                        obj = new String[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzir, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.readString();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.readString();
                        this.zzir = obj;
                        continue;
                    case 136:
                        this.zzis = com_google_android_gms_internal_zzrp.zzCW();
                        continue;
                    case 144:
                        this.zziq = com_google_android_gms_internal_zzrp.zzCX();
                        continue;
                    case 154:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 154);
                        zzCT = this.zzid == null ? 0 : this.zzid.length;
                        obj = new String[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzid, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.readString();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.readString();
                        this.zzid = obj;
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

    public static final class zzg extends zzrr<zzg> {
        private static volatile zzg[] zzit;
        public int[] zziA;
        public int[] zziB;
        public int[] zziC;
        public int[] zziD;
        public int[] zziu;
        public int[] zziv;
        public int[] zziw;
        public int[] zzix;
        public int[] zziy;
        public int[] zziz;

        public zzg() {
            zzL();
        }

        public static zzg[] zzK() {
            if (zzit == null) {
                synchronized (zzrv.zzbck) {
                    if (zzit == null) {
                        zzit = new zzg[0];
                    }
                }
            }
            return zzit;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzg)) {
                return false;
            }
            zzg com_google_android_gms_internal_zzaf_zzg = (zzg) o;
            return (zzrv.equals(this.zziu, com_google_android_gms_internal_zzaf_zzg.zziu) && zzrv.equals(this.zziv, com_google_android_gms_internal_zzaf_zzg.zziv) && zzrv.equals(this.zziw, com_google_android_gms_internal_zzaf_zzg.zziw) && zzrv.equals(this.zzix, com_google_android_gms_internal_zzaf_zzg.zzix) && zzrv.equals(this.zziy, com_google_android_gms_internal_zzaf_zzg.zziy) && zzrv.equals(this.zziz, com_google_android_gms_internal_zzaf_zzg.zziz) && zzrv.equals(this.zziA, com_google_android_gms_internal_zzaf_zzg.zziA) && zzrv.equals(this.zziB, com_google_android_gms_internal_zzaf_zzg.zziB) && zzrv.equals(this.zziC, com_google_android_gms_internal_zzaf_zzg.zziC) && zzrv.equals(this.zziD, com_google_android_gms_internal_zzaf_zzg.zziD)) ? zza((zzrr) com_google_android_gms_internal_zzaf_zzg) : false;
        }

        public int hashCode() {
            return ((((((((((((((((((((zzrv.hashCode(this.zziu) + 527) * 31) + zzrv.hashCode(this.zziv)) * 31) + zzrv.hashCode(this.zziw)) * 31) + zzrv.hashCode(this.zzix)) * 31) + zzrv.hashCode(this.zziy)) * 31) + zzrv.hashCode(this.zziz)) * 31) + zzrv.hashCode(this.zziA)) * 31) + zzrv.hashCode(this.zziB)) * 31) + zzrv.hashCode(this.zziC)) * 31) + zzrv.hashCode(this.zziD)) * 31) + zzDk();
        }

        protected int zzB() {
            int i;
            int i2;
            int i3 = 0;
            int zzB = super.zzB();
            if (this.zziu == null || this.zziu.length <= 0) {
                i = zzB;
            } else {
                i2 = 0;
                for (int zzls : this.zziu) {
                    i2 += zzrq.zzls(zzls);
                }
                i = (zzB + i2) + (this.zziu.length * 1);
            }
            if (this.zziv != null && this.zziv.length > 0) {
                zzB = 0;
                for (int zzls2 : this.zziv) {
                    zzB += zzrq.zzls(zzls2);
                }
                i = (i + zzB) + (this.zziv.length * 1);
            }
            if (this.zziw != null && this.zziw.length > 0) {
                zzB = 0;
                for (int zzls22 : this.zziw) {
                    zzB += zzrq.zzls(zzls22);
                }
                i = (i + zzB) + (this.zziw.length * 1);
            }
            if (this.zzix != null && this.zzix.length > 0) {
                zzB = 0;
                for (int zzls222 : this.zzix) {
                    zzB += zzrq.zzls(zzls222);
                }
                i = (i + zzB) + (this.zzix.length * 1);
            }
            if (this.zziy != null && this.zziy.length > 0) {
                zzB = 0;
                for (int zzls2222 : this.zziy) {
                    zzB += zzrq.zzls(zzls2222);
                }
                i = (i + zzB) + (this.zziy.length * 1);
            }
            if (this.zziz != null && this.zziz.length > 0) {
                zzB = 0;
                for (int zzls22222 : this.zziz) {
                    zzB += zzrq.zzls(zzls22222);
                }
                i = (i + zzB) + (this.zziz.length * 1);
            }
            if (this.zziA != null && this.zziA.length > 0) {
                zzB = 0;
                for (int zzls222222 : this.zziA) {
                    zzB += zzrq.zzls(zzls222222);
                }
                i = (i + zzB) + (this.zziA.length * 1);
            }
            if (this.zziB != null && this.zziB.length > 0) {
                zzB = 0;
                for (int zzls2222222 : this.zziB) {
                    zzB += zzrq.zzls(zzls2222222);
                }
                i = (i + zzB) + (this.zziB.length * 1);
            }
            if (this.zziC != null && this.zziC.length > 0) {
                zzB = 0;
                for (int zzls22222222 : this.zziC) {
                    zzB += zzrq.zzls(zzls22222222);
                }
                i = (i + zzB) + (this.zziC.length * 1);
            }
            if (this.zziD == null || this.zziD.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.zziD.length) {
                i2 += zzrq.zzls(this.zziD[i3]);
                i3++;
            }
            return (i + i2) + (this.zziD.length * 1);
        }

        public zzg zzL() {
            this.zziu = zzsa.zzbcn;
            this.zziv = zzsa.zzbcn;
            this.zziw = zzsa.zzbcn;
            this.zzix = zzsa.zzbcn;
            this.zziy = zzsa.zzbcn;
            this.zziz = zzsa.zzbcn;
            this.zziA = zzsa.zzbcn;
            this.zziB = zzsa.zzbcn;
            this.zziC = zzsa.zzbcn;
            this.zziD = zzsa.zzbcn;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            int i = 0;
            if (this.zziu != null && this.zziu.length > 0) {
                for (int zzz : this.zziu) {
                    com_google_android_gms_internal_zzrq.zzz(1, zzz);
                }
            }
            if (this.zziv != null && this.zziv.length > 0) {
                for (int zzz2 : this.zziv) {
                    com_google_android_gms_internal_zzrq.zzz(2, zzz2);
                }
            }
            if (this.zziw != null && this.zziw.length > 0) {
                for (int zzz22 : this.zziw) {
                    com_google_android_gms_internal_zzrq.zzz(3, zzz22);
                }
            }
            if (this.zzix != null && this.zzix.length > 0) {
                for (int zzz222 : this.zzix) {
                    com_google_android_gms_internal_zzrq.zzz(4, zzz222);
                }
            }
            if (this.zziy != null && this.zziy.length > 0) {
                for (int zzz2222 : this.zziy) {
                    com_google_android_gms_internal_zzrq.zzz(5, zzz2222);
                }
            }
            if (this.zziz != null && this.zziz.length > 0) {
                for (int zzz22222 : this.zziz) {
                    com_google_android_gms_internal_zzrq.zzz(6, zzz22222);
                }
            }
            if (this.zziA != null && this.zziA.length > 0) {
                for (int zzz222222 : this.zziA) {
                    com_google_android_gms_internal_zzrq.zzz(7, zzz222222);
                }
            }
            if (this.zziB != null && this.zziB.length > 0) {
                for (int zzz2222222 : this.zziB) {
                    com_google_android_gms_internal_zzrq.zzz(8, zzz2222222);
                }
            }
            if (this.zziC != null && this.zziC.length > 0) {
                for (int zzz22222222 : this.zziC) {
                    com_google_android_gms_internal_zzrq.zzz(9, zzz22222222);
                }
            }
            if (this.zziD != null && this.zziD.length > 0) {
                while (i < this.zziD.length) {
                    com_google_android_gms_internal_zzrq.zzz(10, this.zziD[i]);
                    i++;
                }
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzh(com_google_android_gms_internal_zzrp);
        }

        public zzg zzh(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                int zzb;
                Object obj;
                int zzll;
                Object obj2;
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.URL /*8*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 8);
                        zzCT = this.zziu == null ? 0 : this.zziu.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziu, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziu = obj;
                        continue;
                    case Barcode.GEO /*10*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziu == null ? 0 : this.zziu.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziu, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziu = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Barcode.DATA_MATRIX /*16*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 16);
                        zzCT = this.zziv == null ? 0 : this.zziv.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziv, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziv = obj;
                        continue;
                    case Place.TYPE_CAR_RENTAL /*18*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziv == null ? 0 : this.zziv.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziv, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziv = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Place.TYPE_CITY_HALL /*24*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 24);
                        zzCT = this.zziw == null ? 0 : this.zziw.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziw, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziw = obj;
                        continue;
                    case Place.TYPE_CONVENIENCE_STORE /*26*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziw == null ? 0 : this.zziw.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziw, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziw = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Barcode.EAN_13 /*32*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 32);
                        zzCT = this.zzix == null ? 0 : this.zzix.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzix, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zzix = obj;
                        continue;
                    case Place.TYPE_ESTABLISHMENT /*34*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zzix == null ? 0 : this.zzix.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zzix, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zzix = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Place.TYPE_FURNITURE_STORE /*40*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 40);
                        zzCT = this.zziy == null ? 0 : this.zziy.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziy, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziy = obj;
                        continue;
                    case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziy == null ? 0 : this.zziy.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziy, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziy = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Place.TYPE_HINDU_TEMPLE /*48*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 48);
                        zzCT = this.zziz == null ? 0 : this.zziz.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziz, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziz = obj;
                        continue;
                    case Place.TYPE_HOSPITAL /*50*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziz == null ? 0 : this.zziz.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziz, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziz = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Place.TYPE_LIQUOR_STORE /*56*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 56);
                        zzCT = this.zziA == null ? 0 : this.zziA.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziA, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziA = obj;
                        continue;
                    case Place.TYPE_LOCKSMITH /*58*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziA == null ? 0 : this.zziA.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziA, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziA = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Barcode.EAN_8 /*64*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 64);
                        zzCT = this.zziB == null ? 0 : this.zziB.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziB, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziB = obj;
                        continue;
                    case Place.TYPE_MUSEUM /*66*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziB == null ? 0 : this.zziB.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziB, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziB = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Place.TYPE_PHARMACY /*72*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 72);
                        zzCT = this.zziC == null ? 0 : this.zziC.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziC, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziC = obj;
                        continue;
                    case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziC == null ? 0 : this.zziC.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziC, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziC = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Place.TYPE_ROOFING_CONTRACTOR /*80*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 80);
                        zzCT = this.zziD == null ? 0 : this.zziD.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziD, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziD = obj;
                        continue;
                    case Place.TYPE_SCHOOL /*82*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziD == null ? 0 : this.zziD.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziD, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziD = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
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

    public static final class zzh extends zzrr<zzh> {
        public static final zzrs<com.google.android.gms.internal.zzag.zza, zzh> zziE;
        private static final zzh[] zziF;
        public int[] zziG;
        public int[] zziH;
        public int[] zziI;
        public int zziJ;
        public int[] zziK;
        public int zziL;
        public int zziM;

        static {
            zziE = zzrs.zza(11, zzh.class, 810);
            zziF = new zzh[0];
        }

        public zzh() {
            zzM();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzh)) {
                return false;
            }
            zzh com_google_android_gms_internal_zzaf_zzh = (zzh) o;
            return (zzrv.equals(this.zziG, com_google_android_gms_internal_zzaf_zzh.zziG) && zzrv.equals(this.zziH, com_google_android_gms_internal_zzaf_zzh.zziH) && zzrv.equals(this.zziI, com_google_android_gms_internal_zzaf_zzh.zziI) && this.zziJ == com_google_android_gms_internal_zzaf_zzh.zziJ && zzrv.equals(this.zziK, com_google_android_gms_internal_zzaf_zzh.zziK) && this.zziL == com_google_android_gms_internal_zzaf_zzh.zziL && this.zziM == com_google_android_gms_internal_zzaf_zzh.zziM) ? zza((zzrr) com_google_android_gms_internal_zzaf_zzh) : false;
        }

        public int hashCode() {
            return ((((((((((((((zzrv.hashCode(this.zziG) + 527) * 31) + zzrv.hashCode(this.zziH)) * 31) + zzrv.hashCode(this.zziI)) * 31) + this.zziJ) * 31) + zzrv.hashCode(this.zziK)) * 31) + this.zziL) * 31) + this.zziM) * 31) + zzDk();
        }

        protected int zzB() {
            int i;
            int i2;
            int i3 = 0;
            int zzB = super.zzB();
            if (this.zziG == null || this.zziG.length <= 0) {
                i = zzB;
            } else {
                i2 = 0;
                for (int zzls : this.zziG) {
                    i2 += zzrq.zzls(zzls);
                }
                i = (zzB + i2) + (this.zziG.length * 1);
            }
            if (this.zziH != null && this.zziH.length > 0) {
                zzB = 0;
                for (int zzls2 : this.zziH) {
                    zzB += zzrq.zzls(zzls2);
                }
                i = (i + zzB) + (this.zziH.length * 1);
            }
            if (this.zziI != null && this.zziI.length > 0) {
                zzB = 0;
                for (int zzls22 : this.zziI) {
                    zzB += zzrq.zzls(zzls22);
                }
                i = (i + zzB) + (this.zziI.length * 1);
            }
            if (this.zziJ != 0) {
                i += zzrq.zzB(4, this.zziJ);
            }
            if (this.zziK != null && this.zziK.length > 0) {
                i2 = 0;
                while (i3 < this.zziK.length) {
                    i2 += zzrq.zzls(this.zziK[i3]);
                    i3++;
                }
                i = (i + i2) + (this.zziK.length * 1);
            }
            if (this.zziL != 0) {
                i += zzrq.zzB(6, this.zziL);
            }
            return this.zziM != 0 ? i + zzrq.zzB(7, this.zziM) : i;
        }

        public zzh zzM() {
            this.zziG = zzsa.zzbcn;
            this.zziH = zzsa.zzbcn;
            this.zziI = zzsa.zzbcn;
            this.zziJ = 0;
            this.zziK = zzsa.zzbcn;
            this.zziL = 0;
            this.zziM = 0;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            int i = 0;
            if (this.zziG != null && this.zziG.length > 0) {
                for (int zzz : this.zziG) {
                    com_google_android_gms_internal_zzrq.zzz(1, zzz);
                }
            }
            if (this.zziH != null && this.zziH.length > 0) {
                for (int zzz2 : this.zziH) {
                    com_google_android_gms_internal_zzrq.zzz(2, zzz2);
                }
            }
            if (this.zziI != null && this.zziI.length > 0) {
                for (int zzz22 : this.zziI) {
                    com_google_android_gms_internal_zzrq.zzz(3, zzz22);
                }
            }
            if (this.zziJ != 0) {
                com_google_android_gms_internal_zzrq.zzz(4, this.zziJ);
            }
            if (this.zziK != null && this.zziK.length > 0) {
                while (i < this.zziK.length) {
                    com_google_android_gms_internal_zzrq.zzz(5, this.zziK[i]);
                    i++;
                }
            }
            if (this.zziL != 0) {
                com_google_android_gms_internal_zzrq.zzz(6, this.zziL);
            }
            if (this.zziM != 0) {
                com_google_android_gms_internal_zzrq.zzz(7, this.zziM);
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzi(com_google_android_gms_internal_zzrp);
        }

        public zzh zzi(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                int zzb;
                Object obj;
                int zzll;
                Object obj2;
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.URL /*8*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 8);
                        zzCT = this.zziG == null ? 0 : this.zziG.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziG, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziG = obj;
                        continue;
                    case Barcode.GEO /*10*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziG == null ? 0 : this.zziG.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziG, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziG = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Barcode.DATA_MATRIX /*16*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 16);
                        zzCT = this.zziH == null ? 0 : this.zziH.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziH, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziH = obj;
                        continue;
                    case Place.TYPE_CAR_RENTAL /*18*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziH == null ? 0 : this.zziH.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziH, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziH = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Place.TYPE_CITY_HALL /*24*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 24);
                        zzCT = this.zziI == null ? 0 : this.zziI.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziI, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziI = obj;
                        continue;
                    case Place.TYPE_CONVENIENCE_STORE /*26*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziI == null ? 0 : this.zziI.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziI, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziI = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Barcode.EAN_13 /*32*/:
                        this.zziJ = com_google_android_gms_internal_zzrp.zzCW();
                        continue;
                    case Place.TYPE_FURNITURE_STORE /*40*/:
                        zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 40);
                        zzCT = this.zziK == null ? 0 : this.zziK.length;
                        obj = new int[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziK, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = com_google_android_gms_internal_zzrp.zzCW();
                        this.zziK = obj;
                        continue;
                    case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                        zzll = com_google_android_gms_internal_zzrp.zzll(com_google_android_gms_internal_zzrp.zzDa());
                        zzb = com_google_android_gms_internal_zzrp.getPosition();
                        zzCT = 0;
                        while (com_google_android_gms_internal_zzrp.zzDf() > 0) {
                            com_google_android_gms_internal_zzrp.zzCW();
                            zzCT++;
                        }
                        com_google_android_gms_internal_zzrp.zzln(zzb);
                        zzb = this.zziK == null ? 0 : this.zziK.length;
                        obj2 = new int[(zzCT + zzb)];
                        if (zzb != 0) {
                            System.arraycopy(this.zziK, 0, obj2, 0, zzb);
                        }
                        while (zzb < obj2.length) {
                            obj2[zzb] = com_google_android_gms_internal_zzrp.zzCW();
                            zzb++;
                        }
                        this.zziK = obj2;
                        com_google_android_gms_internal_zzrp.zzlm(zzll);
                        continue;
                    case Place.TYPE_HINDU_TEMPLE /*48*/:
                        this.zziL = com_google_android_gms_internal_zzrp.zzCW();
                        continue;
                    case Place.TYPE_LIQUOR_STORE /*56*/:
                        this.zziM = com_google_android_gms_internal_zzrp.zzCW();
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

    public static final class zzi extends zzrr<zzi> {
        private static volatile zzi[] zziN;
        public String name;
        public com.google.android.gms.internal.zzag.zza zziO;
        public zzd zziP;

        public zzi() {
            zzO();
        }

        public static zzi[] zzN() {
            if (zziN == null) {
                synchronized (zzrv.zzbck) {
                    if (zziN == null) {
                        zziN = new zzi[0];
                    }
                }
            }
            return zziN;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzi)) {
                return false;
            }
            zzi com_google_android_gms_internal_zzaf_zzi = (zzi) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzaf_zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzaf_zzi.name)) {
                return false;
            }
            if (this.zziO == null) {
                if (com_google_android_gms_internal_zzaf_zzi.zziO != null) {
                    return false;
                }
            } else if (!this.zziO.equals(com_google_android_gms_internal_zzaf_zzi.zziO)) {
                return false;
            }
            if (this.zziP == null) {
                if (com_google_android_gms_internal_zzaf_zzi.zziP != null) {
                    return false;
                }
            } else if (!this.zziP.equals(com_google_android_gms_internal_zzaf_zzi.zziP)) {
                return false;
            }
            return zza((zzrr) com_google_android_gms_internal_zzaf_zzi);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zziO == null ? 0 : this.zziO.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31;
            if (this.zziP != null) {
                i = this.zziP.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (!this.name.equals(BuildConfig.FLAVOR)) {
                zzB += zzrq.zzl(1, this.name);
            }
            if (this.zziO != null) {
                zzB += zzrq.zzc(2, this.zziO);
            }
            return this.zziP != null ? zzB + zzrq.zzc(3, this.zziP) : zzB;
        }

        public zzi zzO() {
            this.name = BuildConfig.FLAVOR;
            this.zziO = null;
            this.zziP = null;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            if (!this.name.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(1, this.name);
            }
            if (this.zziO != null) {
                com_google_android_gms_internal_zzrq.zza(2, this.zziO);
            }
            if (this.zziP != null) {
                com_google_android_gms_internal_zzrq.zza(3, this.zziP);
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzj(com_google_android_gms_internal_zzrp);
        }

        public zzi zzj(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.GEO /*10*/:
                        this.name = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case Place.TYPE_CAR_RENTAL /*18*/:
                        if (this.zziO == null) {
                            this.zziO = new com.google.android.gms.internal.zzag.zza();
                        }
                        com_google_android_gms_internal_zzrp.zza(this.zziO);
                        continue;
                    case Place.TYPE_CONVENIENCE_STORE /*26*/:
                        if (this.zziP == null) {
                            this.zziP = new zzd();
                        }
                        com_google_android_gms_internal_zzrp.zza(this.zziP);
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

    public static final class zzj extends zzrr<zzj> {
        public zzi[] zziQ;
        public zzf zziR;
        public String zziS;

        public zzj() {
            zzP();
        }

        public static zzj zzd(byte[] bArr) throws zzrw {
            return (zzj) zzrx.zza(new zzj(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzj)) {
                return false;
            }
            zzj com_google_android_gms_internal_zzaf_zzj = (zzj) o;
            if (!zzrv.equals(this.zziQ, com_google_android_gms_internal_zzaf_zzj.zziQ)) {
                return false;
            }
            if (this.zziR == null) {
                if (com_google_android_gms_internal_zzaf_zzj.zziR != null) {
                    return false;
                }
            } else if (!this.zziR.equals(com_google_android_gms_internal_zzaf_zzj.zziR)) {
                return false;
            }
            if (this.zziS == null) {
                if (com_google_android_gms_internal_zzaf_zzj.zziS != null) {
                    return false;
                }
            } else if (!this.zziS.equals(com_google_android_gms_internal_zzaf_zzj.zziS)) {
                return false;
            }
            return zza((zzrr) com_google_android_gms_internal_zzaf_zzj);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zziR == null ? 0 : this.zziR.hashCode()) + ((zzrv.hashCode(this.zziQ) + 527) * 31)) * 31;
            if (this.zziS != null) {
                i = this.zziS.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (this.zziQ != null && this.zziQ.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx : this.zziQ) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        zzB += zzrq.zzc(1, com_google_android_gms_internal_zzrx);
                    }
                }
            }
            if (this.zziR != null) {
                zzB += zzrq.zzc(2, this.zziR);
            }
            return !this.zziS.equals(BuildConfig.FLAVOR) ? zzB + zzrq.zzl(3, this.zziS) : zzB;
        }

        public zzj zzP() {
            this.zziQ = zzi.zzN();
            this.zziR = null;
            this.zziS = BuildConfig.FLAVOR;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            if (this.zziQ != null && this.zziQ.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx : this.zziQ) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        com_google_android_gms_internal_zzrq.zza(1, com_google_android_gms_internal_zzrx);
                    }
                }
            }
            if (this.zziR != null) {
                com_google_android_gms_internal_zzrq.zza(2, this.zziR);
            }
            if (!this.zziS.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(3, this.zziS);
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzk(com_google_android_gms_internal_zzrp);
        }

        public zzj zzk(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.GEO /*10*/:
                        int zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 10);
                        zzCT = this.zziQ == null ? 0 : this.zziQ.length;
                        Object obj = new zzi[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zziQ, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zzi();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zzi();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zziQ = obj;
                        continue;
                    case Place.TYPE_CAR_RENTAL /*18*/:
                        if (this.zziR == null) {
                            this.zziR = new zzf();
                        }
                        com_google_android_gms_internal_zzrp.zza(this.zziR);
                        continue;
                    case Place.TYPE_CONVENIENCE_STORE /*26*/:
                        this.zziS = com_google_android_gms_internal_zzrp.readString();
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
}
