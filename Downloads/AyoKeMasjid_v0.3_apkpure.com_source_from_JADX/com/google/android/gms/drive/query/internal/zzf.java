package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import java.util.List;

public interface zzf<F> {
    <T> F zzb(zzb<T> com_google_android_gms_drive_metadata_zzb_T, T t);

    <T> F zzb(Operator operator, MetadataField<T> metadataField, T t);

    F zzb(Operator operator, List<F> list);

    F zzcM(String str);

    <T> F zzd(MetadataField<T> metadataField, T t);

    F zze(MetadataField<?> metadataField);

    F zzri();

    F zzrj();

    F zzw(F f);
}
