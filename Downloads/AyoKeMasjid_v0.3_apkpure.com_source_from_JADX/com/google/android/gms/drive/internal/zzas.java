package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;
import org.bpmikc.akm.BuildConfig;

public final class zzas extends zzrr<zzas> {
    public int versionCode;
    public String zzajB;
    public long zzajC;
    public int zzajD;
    public long zzajz;

    public zzas() {
        zzqL();
    }

    public static zzas zzl(byte[] bArr) throws zzrw {
        return (zzas) zzrx.zza(new zzas(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzas)) {
            return false;
        }
        zzas com_google_android_gms_drive_internal_zzas = (zzas) o;
        if (this.versionCode != com_google_android_gms_drive_internal_zzas.versionCode) {
            return false;
        }
        if (this.zzajB == null) {
            if (com_google_android_gms_drive_internal_zzas.zzajB != null) {
                return false;
            }
        } else if (!this.zzajB.equals(com_google_android_gms_drive_internal_zzas.zzajB)) {
            return false;
        }
        return (this.zzajC == com_google_android_gms_drive_internal_zzas.zzajC && this.zzajz == com_google_android_gms_drive_internal_zzas.zzajz && this.zzajD == com_google_android_gms_drive_internal_zzas.zzajD) ? zza((zzrr) com_google_android_gms_drive_internal_zzas) : false;
    }

    public int hashCode() {
        return (((((((((this.zzajB == null ? 0 : this.zzajB.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.zzajC ^ (this.zzajC >>> 32)))) * 31) + ((int) (this.zzajz ^ (this.zzajz >>> 32)))) * 31) + this.zzajD) * 31) + zzDk();
    }

    protected int zzB() {
        int zzB = (((super.zzB() + zzrq.zzB(1, this.versionCode)) + zzrq.zzl(2, this.zzajB)) + zzrq.zze(3, this.zzajC)) + zzrq.zze(4, this.zzajz);
        return this.zzajD != -1 ? zzB + zzrq.zzB(5, this.zzajD) : zzB;
    }

    public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
        com_google_android_gms_internal_zzrq.zzz(1, this.versionCode);
        com_google_android_gms_internal_zzrq.zzb(2, this.zzajB);
        com_google_android_gms_internal_zzrq.zzc(3, this.zzajC);
        com_google_android_gms_internal_zzrq.zzc(4, this.zzajz);
        if (this.zzajD != -1) {
            com_google_android_gms_internal_zzrq.zzz(5, this.zzajD);
        }
        super.zza(com_google_android_gms_internal_zzrq);
    }

    public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
        return zzn(com_google_android_gms_internal_zzrp);
    }

    public zzas zzn(zzrp com_google_android_gms_internal_zzrp) throws IOException {
        while (true) {
            int zzCT = com_google_android_gms_internal_zzrp.zzCT();
            switch (zzCT) {
                case SpinnerCompat.MODE_DIALOG /*0*/:
                    break;
                case Barcode.URL /*8*/:
                    this.versionCode = com_google_android_gms_internal_zzrp.zzCW();
                    continue;
                case Place.TYPE_CAR_RENTAL /*18*/:
                    this.zzajB = com_google_android_gms_internal_zzrp.readString();
                    continue;
                case Place.TYPE_CITY_HALL /*24*/:
                    this.zzajC = com_google_android_gms_internal_zzrp.zzCZ();
                    continue;
                case Barcode.EAN_13 /*32*/:
                    this.zzajz = com_google_android_gms_internal_zzrp.zzCZ();
                    continue;
                case Place.TYPE_FURNITURE_STORE /*40*/:
                    this.zzajD = com_google_android_gms_internal_zzrp.zzCW();
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

    public zzas zzqL() {
        this.versionCode = 1;
        this.zzajB = BuildConfig.FLAVOR;
        this.zzajC = -1;
        this.zzajz = -1;
        this.zzajD = -1;
        this.zzbca = null;
        this.zzbcl = -1;
        return this;
    }
}
