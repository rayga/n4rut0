package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf.zzc;
import com.google.android.gms.internal.zzaf.zzd;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzaj {
    private static void zza(DataLayer dataLayer, zzd com_google_android_gms_internal_zzaf_zzd) {
        for (zza zzg : com_google_android_gms_internal_zzaf_zzd.zzia) {
            dataLayer.zzeC(zzdf.zzg(zzg));
        }
    }

    public static void zza(DataLayer dataLayer, zzi com_google_android_gms_internal_zzaf_zzi) {
        if (com_google_android_gms_internal_zzaf_zzi.zziP == null) {
            zzbg.zzaE("supplemental missing experimentSupplemental");
            return;
        }
        zza(dataLayer, com_google_android_gms_internal_zzaf_zzi.zziP);
        zzb(dataLayer, com_google_android_gms_internal_zzaf_zzi.zziP);
        zzc(dataLayer, com_google_android_gms_internal_zzaf_zzi.zziP);
    }

    private static void zzb(DataLayer dataLayer, zzd com_google_android_gms_internal_zzaf_zzd) {
        for (zza zzc : com_google_android_gms_internal_zzaf_zzd.zzhZ) {
            Map zzc2 = zzc(zzc);
            if (zzc2 != null) {
                dataLayer.push(zzc2);
            }
        }
    }

    private static Map<String, Object> zzc(zza com_google_android_gms_internal_zzag_zza) {
        Object zzl = zzdf.zzl(com_google_android_gms_internal_zzag_zza);
        if (zzl instanceof Map) {
            return (Map) zzl;
        }
        zzbg.zzaE("value: " + zzl + " is not a map value, ignored.");
        return null;
    }

    private static void zzc(DataLayer dataLayer, zzd com_google_android_gms_internal_zzaf_zzd) {
        for (zzc com_google_android_gms_internal_zzaf_zzc : com_google_android_gms_internal_zzaf_zzd.zzib) {
            if (com_google_android_gms_internal_zzaf_zzc.key == null) {
                zzbg.zzaE("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(com_google_android_gms_internal_zzaf_zzc.key);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = com_google_android_gms_internal_zzaf_zzc.zzhV;
                long j2 = com_google_android_gms_internal_zzaf_zzc.zzhW;
                if (!com_google_android_gms_internal_zzaf_zzc.zzhX || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        zzbg.zzaE("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.zzeC(com_google_android_gms_internal_zzaf_zzc.key);
                Map zzj = dataLayer.zzj(com_google_android_gms_internal_zzaf_zzc.key, obj);
                if (com_google_android_gms_internal_zzaf_zzc.zzhY > 0) {
                    if (zzj.containsKey("gtm")) {
                        Object obj2 = zzj.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(com_google_android_gms_internal_zzaf_zzc.zzhY));
                        } else {
                            zzbg.zzaE("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        zzj.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(com_google_android_gms_internal_zzaf_zzc.zzhY)));
                    }
                }
                dataLayer.push(zzj);
            }
        }
    }
}
