package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;

public final class zzat extends zzrr<zzat> {
    public long zzajC;
    public long zzajz;

    public zzat() {
        zzqM();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzat)) {
            return false;
        }
        zzat com_google_android_gms_drive_internal_zzat = (zzat) o;
        return (this.zzajC == com_google_android_gms_drive_internal_zzat.zzajC && this.zzajz == com_google_android_gms_drive_internal_zzat.zzajz) ? zza((zzrr) com_google_android_gms_drive_internal_zzat) : false;
    }

    public int hashCode() {
        return ((((((int) (this.zzajC ^ (this.zzajC >>> 32))) + 527) * 31) + ((int) (this.zzajz ^ (this.zzajz >>> 32)))) * 31) + zzDk();
    }

    protected int zzB() {
        return (super.zzB() + zzrq.zze(1, this.zzajC)) + zzrq.zze(2, this.zzajz);
    }

    public void zza(zzrq com_google_android_gms_internal_zzrq) throws IOException {
        com_google_android_gms_internal_zzrq.zzc(1, this.zzajC);
        com_google_android_gms_internal_zzrq.zzc(2, this.zzajz);
        super.zza(com_google_android_gms_internal_zzrq);
    }

    public /* synthetic */ zzrx zzb(zzrp com_google_android_gms_internal_zzrp) throws IOException {
        return zzo(com_google_android_gms_internal_zzrp);
    }

    public zzat zzo(zzrp com_google_android_gms_internal_zzrp) throws IOException {
        while (true) {
            int zzCT = com_google_android_gms_internal_zzrp.zzCT();
            switch (zzCT) {
                case SpinnerCompat.MODE_DIALOG /*0*/:
                    break;
                case Barcode.URL /*8*/:
                    this.zzajC = com_google_android_gms_internal_zzrp.zzCZ();
                    continue;
                case Barcode.DATA_MATRIX /*16*/:
                    this.zzajz = com_google_android_gms_internal_zzrp.zzCZ();
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

    public zzat zzqM() {
        this.zzajC = -1;
        this.zzajz = -1;
        this.zzbca = null;
        this.zzbcl = -1;
        return this;
    }
}
