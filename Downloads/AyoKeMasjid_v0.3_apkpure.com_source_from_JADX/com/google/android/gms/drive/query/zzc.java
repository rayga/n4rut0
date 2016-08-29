package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.zzf;
import java.util.List;
import org.bpmikc.akm.BuildConfig;

public class zzc implements zzf<String> {
    public <T> String zza(zzb<T> com_google_android_gms_drive_metadata_zzb_T, T t) {
        return String.format("contains(%s,%s)", new Object[]{com_google_android_gms_drive_metadata_zzb_T.getName(), t});
    }

    public <T> String zza(Operator operator, MetadataField<T> metadataField, T t) {
        return String.format("cmp(%s,%s,%s)", new Object[]{operator.getTag(), metadataField.getName(), t});
    }

    public String zza(Operator operator, List<String> list) {
        StringBuilder stringBuilder = new StringBuilder(operator.getTag() + "(");
        String str = BuildConfig.FLAVOR;
        String str2 = str;
        for (String str3 : list) {
            stringBuilder.append(str2);
            stringBuilder.append(str3);
            str2 = ",";
        }
        return stringBuilder.append(")").toString();
    }

    public /* synthetic */ Object zzb(zzb com_google_android_gms_drive_metadata_zzb, Object obj) {
        return zza(com_google_android_gms_drive_metadata_zzb, obj);
    }

    public /* synthetic */ Object zzb(Operator operator, MetadataField metadataField, Object obj) {
        return zza(operator, metadataField, obj);
    }

    public /* synthetic */ Object zzb(Operator operator, List list) {
        return zza(operator, list);
    }

    public <T> String zzc(MetadataField<T> metadataField, T t) {
        return String.format("has(%s,%s)", new Object[]{metadataField.getName(), t});
    }

    public String zzcK(String str) {
        return String.format("not(%s)", new Object[]{str});
    }

    public String zzcL(String str) {
        return String.format("fullTextSearch(%s)", new Object[]{str});
    }

    public /* synthetic */ Object zzcM(String str) {
        return zzcL(str);
    }

    public /* synthetic */ Object zzd(MetadataField metadataField, Object obj) {
        return zzc(metadataField, obj);
    }

    public String zzd(MetadataField<?> metadataField) {
        return String.format("fieldOnly(%s)", new Object[]{metadataField.getName()});
    }

    public /* synthetic */ Object zze(MetadataField metadataField) {
        return zzd(metadataField);
    }

    public String zzrg() {
        return "all()";
    }

    public String zzrh() {
        return "ownedByMe()";
    }

    public /* synthetic */ Object zzri() {
        return zzrh();
    }

    public /* synthetic */ Object zzrj() {
        return zzrg();
    }

    public /* synthetic */ Object zzw(Object obj) {
        return zzcK((String) obj);
    }
}
