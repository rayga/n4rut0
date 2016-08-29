package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;
import org.bpmikc.akm.BuildConfig;

public interface zznw {

    public static final class zza extends zzrr<zza> {
        public zza[] zzaAm;

        public static final class zza extends zzrr<zza> {
            private static volatile zza[] zzaAn;
            public int viewId;
            public String zzaAo;
            public String zzaAp;

            public zza() {
                zzvq();
            }

            public static zza[] zzvp() {
                if (zzaAn == null) {
                    synchronized (zzrv.zzbck) {
                        if (zzaAn == null) {
                            zzaAn = new zza[0];
                        }
                    }
                }
                return zzaAn;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof zza)) {
                    return false;
                }
                zza com_google_android_gms_internal_zznw_zza_zza = (zza) o;
                if (this.zzaAo == null) {
                    if (com_google_android_gms_internal_zznw_zza_zza.zzaAo != null) {
                        return false;
                    }
                } else if (!this.zzaAo.equals(com_google_android_gms_internal_zznw_zza_zza.zzaAo)) {
                    return false;
                }
                if (this.zzaAp == null) {
                    if (com_google_android_gms_internal_zznw_zza_zza.zzaAp != null) {
                        return false;
                    }
                } else if (!this.zzaAp.equals(com_google_android_gms_internal_zznw_zza_zza.zzaAp)) {
                    return false;
                }
                return this.viewId == com_google_android_gms_internal_zznw_zza_zza.viewId ? zza((zzrr) com_google_android_gms_internal_zznw_zza_zza) : false;
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((this.zzaAo == null ? 0 : this.zzaAo.hashCode()) + 527) * 31;
                if (this.zzaAp != null) {
                    i = this.zzaAp.hashCode();
                }
                return ((((hashCode + i) * 31) + this.viewId) * 31) + zzDk();
            }

            protected int zzB() {
                int zzB = super.zzB();
                if (!this.zzaAo.equals(BuildConfig.FLAVOR)) {
                    zzB += zzrq.zzl(1, this.zzaAo);
                }
                if (!this.zzaAp.equals(BuildConfig.FLAVOR)) {
                    zzB += zzrq.zzl(2, this.zzaAp);
                }
                return this.viewId != 0 ? zzB + zzrq.zzB(3, this.viewId) : zzB;
            }

            public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
                if (!this.zzaAo.equals(BuildConfig.FLAVOR)) {
                    com_google_android_gms_internal_zzrq.zzb(1, this.zzaAo);
                }
                if (!this.zzaAp.equals(BuildConfig.FLAVOR)) {
                    com_google_android_gms_internal_zzrq.zzb(2, this.zzaAp);
                }
                if (this.viewId != 0) {
                    com_google_android_gms_internal_zzrq.zzz(3, this.viewId);
                }
                super.zza(com_google_android_gms_internal_zzrq);
            }

            public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
                return zzq(com_google_android_gms_internal_zzrp);
            }

            public zza zzq(zzrp com_google_android_gms_internal_zzrp) throws IOException {
                while (true) {
                    int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                    switch (zzCT) {
                        case SpinnerCompat.MODE_DIALOG /*0*/:
                            break;
                        case Barcode.GEO /*10*/:
                            this.zzaAo = com_google_android_gms_internal_zzrp.readString();
                            continue;
                        case Place.TYPE_CAR_RENTAL /*18*/:
                            this.zzaAp = com_google_android_gms_internal_zzrp.readString();
                            continue;
                        case Place.TYPE_CITY_HALL /*24*/:
                            this.viewId = com_google_android_gms_internal_zzrp.zzCW();
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

            public zza zzvq() {
                this.zzaAo = BuildConfig.FLAVOR;
                this.zzaAp = BuildConfig.FLAVOR;
                this.viewId = 0;
                this.zzbca = null;
                this.zzbcl = -1;
                return this;
            }
        }

        public zza() {
            zzvo();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zznw_zza = (zza) o;
            return zzrv.equals(this.zzaAm, com_google_android_gms_internal_zznw_zza.zzaAm) ? zza((zzrr) com_google_android_gms_internal_zznw_zza) : false;
        }

        public int hashCode() {
            return ((zzrv.hashCode(this.zzaAm) + 527) * 31) + zzDk();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzaAm != null && this.zzaAm.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx : this.zzaAm) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        zzB += zzrq.zzc(1, com_google_android_gms_internal_zzrx);
                    }
                }
            }
            return zzB;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            if (this.zzaAm != null && this.zzaAm.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx : this.zzaAm) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        com_google_android_gms_internal_zzrq.zza(1, com_google_android_gms_internal_zzrx);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzp(com_google_android_gms_internal_zzrp);
        }

        public zza zzp(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.GEO /*10*/:
                        int zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 10);
                        zzCT = this.zzaAm == null ? 0 : this.zzaAm.length;
                        Object obj = new zza[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzaAm, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zza();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zza();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzaAm = obj;
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

        public zza zzvo() {
            this.zzaAm = zza.zzvp();
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }
    }

    public static final class zzb extends zzrr<zzb> {
        private static volatile zzb[] zzaAq;
        public String name;
        public zzd zzaAr;

        public zzb() {
            zzvs();
        }

        public static zzb[] zzvr() {
            if (zzaAq == null) {
                synchronized (zzrv.zzbck) {
                    if (zzaAq == null) {
                        zzaAq = new zzb[0];
                    }
                }
            }
            return zzaAq;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zznw_zzb = (zzb) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zznw_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zznw_zzb.name)) {
                return false;
            }
            if (this.zzaAr == null) {
                if (com_google_android_gms_internal_zznw_zzb.zzaAr != null) {
                    return false;
                }
            } else if (!this.zzaAr.equals(com_google_android_gms_internal_zznw_zzb.zzaAr)) {
                return false;
            }
            return zza((zzrr) com_google_android_gms_internal_zznw_zzb);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.zzaAr != null) {
                i = this.zzaAr.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (!this.name.equals(BuildConfig.FLAVOR)) {
                zzB += zzrq.zzl(1, this.name);
            }
            return this.zzaAr != null ? zzB + zzrq.zzc(2, this.zzaAr) : zzB;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            if (!this.name.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(1, this.name);
            }
            if (this.zzaAr != null) {
                com_google_android_gms_internal_zzrq.zza(2, this.zzaAr);
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzr(com_google_android_gms_internal_zzrp);
        }

        public zzb zzr(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.GEO /*10*/:
                        this.name = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case Place.TYPE_CAR_RENTAL /*18*/:
                        if (this.zzaAr == null) {
                            this.zzaAr = new zzd();
                        }
                        com_google_android_gms_internal_zzrp.zza(this.zzaAr);
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

        public zzb zzvs() {
            this.name = BuildConfig.FLAVOR;
            this.zzaAr = null;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }
    }

    public static final class zzc extends zzrr<zzc> {
        public String type;
        public zzb[] zzaAs;

        public zzc() {
            zzvt();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zznw_zzc = (zzc) o;
            if (this.type == null) {
                if (com_google_android_gms_internal_zznw_zzc.type != null) {
                    return false;
                }
            } else if (!this.type.equals(com_google_android_gms_internal_zznw_zzc.type)) {
                return false;
            }
            return zzrv.equals(this.zzaAs, com_google_android_gms_internal_zznw_zzc.zzaAs) ? zza((zzrr) com_google_android_gms_internal_zznw_zzc) : false;
        }

        public int hashCode() {
            return (((((this.type == null ? 0 : this.type.hashCode()) + 527) * 31) + zzrv.hashCode(this.zzaAs)) * 31) + zzDk();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (!this.type.equals(BuildConfig.FLAVOR)) {
                zzB += zzrq.zzl(1, this.type);
            }
            if (this.zzaAs == null || this.zzaAs.length <= 0) {
                return zzB;
            }
            int i = zzB;
            for (zzrx com_google_android_gms_internal_zzrx : this.zzaAs) {
                if (com_google_android_gms_internal_zzrx != null) {
                    i += zzrq.zzc(2, com_google_android_gms_internal_zzrx);
                }
            }
            return i;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            if (!this.type.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(1, this.type);
            }
            if (this.zzaAs != null && this.zzaAs.length > 0) {
                for (zzrx com_google_android_gms_internal_zzrx : this.zzaAs) {
                    if (com_google_android_gms_internal_zzrx != null) {
                        com_google_android_gms_internal_zzrq.zza(2, com_google_android_gms_internal_zzrx);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzs(com_google_android_gms_internal_zzrp);
        }

        public zzc zzs(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.GEO /*10*/:
                        this.type = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case Place.TYPE_CAR_RENTAL /*18*/:
                        int zzb = zzsa.zzb(com_google_android_gms_internal_zzrp, 18);
                        zzCT = this.zzaAs == null ? 0 : this.zzaAs.length;
                        Object obj = new zzb[(zzb + zzCT)];
                        if (zzCT != 0) {
                            System.arraycopy(this.zzaAs, 0, obj, 0, zzCT);
                        }
                        while (zzCT < obj.length - 1) {
                            obj[zzCT] = new zzb();
                            com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                            com_google_android_gms_internal_zzrp.zzCT();
                            zzCT++;
                        }
                        obj[zzCT] = new zzb();
                        com_google_android_gms_internal_zzrp.zza(obj[zzCT]);
                        this.zzaAs = obj;
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

        public zzc zzvt() {
            this.type = BuildConfig.FLAVOR;
            this.zzaAs = zzb.zzvr();
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }
    }

    public static final class zzd extends zzrr<zzd> {
        public boolean zzaAt;
        public long zzaAu;
        public double zzaAv;
        public zzc zzaAw;
        public String zzaeO;

        public zzd() {
            zzvu();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zznw_zzd = (zzd) o;
            if (this.zzaAt != com_google_android_gms_internal_zznw_zzd.zzaAt) {
                return false;
            }
            if (this.zzaeO == null) {
                if (com_google_android_gms_internal_zznw_zzd.zzaeO != null) {
                    return false;
                }
            } else if (!this.zzaeO.equals(com_google_android_gms_internal_zznw_zzd.zzaeO)) {
                return false;
            }
            if (this.zzaAu != com_google_android_gms_internal_zznw_zzd.zzaAu || Double.doubleToLongBits(this.zzaAv) != Double.doubleToLongBits(com_google_android_gms_internal_zznw_zzd.zzaAv)) {
                return false;
            }
            if (this.zzaAw == null) {
                if (com_google_android_gms_internal_zznw_zzd.zzaAw != null) {
                    return false;
                }
            } else if (!this.zzaAw.equals(com_google_android_gms_internal_zznw_zzd.zzaAw)) {
                return false;
            }
            return zza((zzrr) com_google_android_gms_internal_zznw_zzd);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.zzaeO == null ? 0 : this.zzaeO.hashCode()) + (((this.zzaAt ? 1231 : 1237) + 527) * 31)) * 31) + ((int) (this.zzaAu ^ (this.zzaAu >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.zzaAv);
            hashCode = ((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
            if (this.zzaAw != null) {
                i = this.zzaAw.hashCode();
            }
            return ((hashCode + i) * 31) + zzDk();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzaAt) {
                zzB += zzrq.zzc(1, this.zzaAt);
            }
            if (!this.zzaeO.equals(BuildConfig.FLAVOR)) {
                zzB += zzrq.zzl(2, this.zzaeO);
            }
            if (this.zzaAu != 0) {
                zzB += zzrq.zzd(3, this.zzaAu);
            }
            if (Double.doubleToLongBits(this.zzaAv) != Double.doubleToLongBits(0.0d)) {
                zzB += zzrq.zzb(4, this.zzaAv);
            }
            return this.zzaAw != null ? zzB + zzrq.zzc(5, this.zzaAw) : zzB;
        }

        public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
            if (this.zzaAt) {
                com_google_android_gms_internal_zzrq.zzb(1, this.zzaAt);
            }
            if (!this.zzaeO.equals(BuildConfig.FLAVOR)) {
                com_google_android_gms_internal_zzrq.zzb(2, this.zzaeO);
            }
            if (this.zzaAu != 0) {
                com_google_android_gms_internal_zzrq.zzb(3, this.zzaAu);
            }
            if (Double.doubleToLongBits(this.zzaAv) != Double.doubleToLongBits(0.0d)) {
                com_google_android_gms_internal_zzrq.zza(4, this.zzaAv);
            }
            if (this.zzaAw != null) {
                com_google_android_gms_internal_zzrq.zza(5, this.zzaAw);
            }
            super.zza(com_google_android_gms_internal_zzrq);
        }

        public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            return zzt(com_google_android_gms_internal_zzrp);
        }

        public zzd zzt(zzrp com_google_android_gms_internal_zzrp) throws IOException {
            while (true) {
                int zzCT = com_google_android_gms_internal_zzrp.zzCT();
                switch (zzCT) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        break;
                    case Barcode.URL /*8*/:
                        this.zzaAt = com_google_android_gms_internal_zzrp.zzCX();
                        continue;
                    case Place.TYPE_CAR_RENTAL /*18*/:
                        this.zzaeO = com_google_android_gms_internal_zzrp.readString();
                        continue;
                    case Place.TYPE_CITY_HALL /*24*/:
                        this.zzaAu = com_google_android_gms_internal_zzrp.zzCV();
                        continue;
                    case Place.TYPE_EMBASSY /*33*/:
                        this.zzaAv = com_google_android_gms_internal_zzrp.readDouble();
                        continue;
                    case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                        if (this.zzaAw == null) {
                            this.zzaAw = new zzc();
                        }
                        com_google_android_gms_internal_zzrp.zza(this.zzaAw);
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

        public zzd zzvu() {
            this.zzaAt = false;
            this.zzaeO = BuildConfig.FLAVOR;
            this.zzaAu = 0;
            this.zzaAv = 0.0d;
            this.zzaAw = null;
            this.zzbca = null;
            this.zzbcl = -1;
            return this;
        }
    }
}
