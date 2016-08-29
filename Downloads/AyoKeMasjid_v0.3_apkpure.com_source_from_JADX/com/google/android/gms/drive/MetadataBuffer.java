package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzo;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zzmb;

public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzagP;

    private static class zza extends Metadata {
        private final DataHolder zzYX;
        private final int zzabh;
        private final int zzagQ;

        public zza(DataHolder dataHolder, int i) {
            this.zzYX = dataHolder;
            this.zzagQ = i;
            this.zzabh = dataHolder.zzbo(i);
        }

        public /* synthetic */ Object freeze() {
            return zzqo();
        }

        public boolean isDataValid() {
            return !this.zzYX.isClosed();
        }

        public <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzYX, this.zzagQ, this.zzabh);
        }

        public Metadata zzqo() {
            MetadataBundle zzrb = MetadataBundle.zzrb();
            for (MetadataField metadataField : zze.zzra()) {
                if (metadataField != zzmb.zzakT) {
                    metadataField.zza(this.zzYX, zzrb, this.zzagQ, this.zzabh);
                }
            }
            return new zzo(zzrb);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.zznP().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        zza com_google_android_gms_drive_MetadataBuffer_zza = this.zzagP;
        if (com_google_android_gms_drive_MetadataBuffer_zza != null && com_google_android_gms_drive_MetadataBuffer_zza.zzagQ == row) {
            return com_google_android_gms_drive_MetadataBuffer_zza;
        }
        Metadata com_google_android_gms_drive_MetadataBuffer_zza2 = new zza(this.zzYX, row);
        this.zzagP = com_google_android_gms_drive_MetadataBuffer_zza2;
        return com_google_android_gms_drive_MetadataBuffer_zza2;
    }

    @Deprecated
    public String getNextPageToken() {
        return null;
    }

    public void release() {
        if (this.zzYX != null) {
            zze.zzb(this.zzYX);
        }
        super.release();
    }
}
