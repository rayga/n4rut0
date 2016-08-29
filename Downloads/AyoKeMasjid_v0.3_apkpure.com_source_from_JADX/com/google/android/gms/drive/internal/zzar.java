package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;

public final class zzar extends zzrr<zzar> {
    public int versionCode;
    public long zzajA;
    public long zzajy;
    public long zzajz;

    public zzar() {
        zzqK();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzar)) {
            return false;
        }
        zzar com_google_android_gms_drive_internal_zzar = (zzar) o;
        return (this.versionCode == com_google_android_gms_drive_internal_zzar.versionCode && this.zzajy == com_google_android_gms_drive_internal_zzar.zzajy && this.zzajz == com_google_android_gms_drive_internal_zzar.zzajz && this.zzajA == com_google_android_gms_drive_internal_zzar.zzajA) ? zza((zzrr) com_google_android_gms_drive_internal_zzar) : false;
    }

    public int hashCode() {
        return ((((((((this.versionCode + 527) * 31) + ((int) (this.zzajy ^ (this.zzajy >>> 32)))) * 31) + ((int) (this.zzajz ^ (this.zzajz >>> 32)))) * 31) + ((int) (this.zzajA ^ (this.zzajA >>> 32)))) * 31) + zzDk();
    }

    protected int zzB() {
        return (((super.zzB() + zzrq.zzB(1, this.versionCode)) + zzrq.zze(2, this.zzajy)) + zzrq.zze(3, this.zzajz)) + zzrq.zze(4, this.zzajA);
    }

    public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
        com_google_android_gms_internal_zzrq.zzz(1, this.versionCode);
        com_google_android_gms_internal_zzrq.zzc(2, this.zzajy);
        com_google_android_gms_internal_zzrq.zzc(3, this.zzajz);
        com_google_android_gms_internal_zzrq.zzc(4, this.zzajA);
        super.zza(com_google_android_gms_internal_zzrq);
    }

    public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
        return zzm(com_google_android_gms_internal_zzrp);
    }

    public zzar zzm(zzrp com_google_android_gms_internal_zzrp) throws IOException {
        while (true) {
            int zzCT = com_google_android_gms_internal_zzrp.zzCT();
            switch (zzCT) {
                case SpinnerCompat.MODE_DIALOG /*0*/:
                    break;
                case Barcode.URL /*8*/:
                    this.versionCode = com_google_android_gms_internal_zzrp.zzCW();
                    continue;
                case Barcode.DATA_MATRIX /*16*/:
                    this.zzajy = com_google_android_gms_internal_zzrp.zzCZ();
                    continue;
                case Place.TYPE_CITY_HALL /*24*/:
                    this.zzajz = com_google_android_gms_internal_zzrp.zzCZ();
                    continue;
                case Barcode.EAN_13 /*32*/:
                    this.zzajA = com_google_android_gms_internal_zzrp.zzCZ();
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

    public zzar zzqK() {
        this.versionCode = 1;
        this.zzajy = -1;
        this.zzajz = -1;
        this.zzajA = -1;
        this.zzbca = null;
        this.zzbcl = -1;
        return this;
    }
}
