package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

public class zzg implements zzf<Boolean> {
    private Boolean zzalI;

    private zzg() {
        this.zzalI = Boolean.valueOf(false);
    }

    public static boolean zza(Filter filter) {
        return filter == null ? false : ((Boolean) filter.zza(new zzg())).booleanValue();
    }

    public /* synthetic */ Object zzb(zzb com_google_android_gms_drive_metadata_zzb, Object obj) {
        return zzc(com_google_android_gms_drive_metadata_zzb, obj);
    }

    public /* synthetic */ Object zzb(Operator operator, MetadataField metadataField, Object obj) {
        return zzc(operator, metadataField, obj);
    }

    public /* synthetic */ Object zzb(Operator operator, List list) {
        return zzc(operator, list);
    }

    public <T> Boolean zzc(zzb<T> com_google_android_gms_drive_metadata_zzb_T, T t) {
        return this.zzalI;
    }

    public <T> Boolean zzc(Operator operator, MetadataField<T> metadataField, T t) {
        return this.zzalI;
    }

    public Boolean zzc(Operator operator, List<Boolean> list) {
        return this.zzalI;
    }

    public /* synthetic */ Object zzcM(String str) {
        return zzcN(str);
    }

    public Boolean zzcN(String str) {
        if (!str.isEmpty()) {
            this.zzalI = Boolean.valueOf(true);
        }
        return this.zzalI;
    }

    public Boolean zzd(Boolean bool) {
        return this.zzalI;
    }

    public /* synthetic */ Object zzd(MetadataField metadataField, Object obj) {
        return zze(metadataField, obj);
    }

    public <T> Boolean zze(MetadataField<T> metadataField, T t) {
        return this.zzalI;
    }

    public /* synthetic */ Object zze(MetadataField metadataField) {
        return zzf(metadataField);
    }

    public Boolean zzf(MetadataField<?> metadataField) {
        return this.zzalI;
    }

    public /* synthetic */ Object zzri() {
        return zzrl();
    }

    public /* synthetic */ Object zzrj() {
        return zzrk();
    }

    public Boolean zzrk() {
        return this.zzalI;
    }

    public Boolean zzrl() {
        return this.zzalI;
    }

    public /* synthetic */ Object zzw(Object obj) {
        return zzd((Boolean) obj);
    }
}
