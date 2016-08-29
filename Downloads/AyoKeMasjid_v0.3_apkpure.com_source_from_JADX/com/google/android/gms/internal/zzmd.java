package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import java.util.Date;

public class zzmd {
    public static final zza zzald;
    public static final zzb zzale;
    public static final zzd zzalf;
    public static final zzc zzalg;
    public static final zze zzalh;

    public static class zza extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
        public zza(String str, int i) {
            super(str, i);
        }
    }

    public static class zzb extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    public static class zzc extends com.google.android.gms.drive.metadata.internal.zzd implements SortableMetadataField<Date> {
        public zzc(String str, int i) {
            super(str, i);
        }
    }

    public static class zzd extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    public static class zze extends com.google.android.gms.drive.metadata.internal.zzd implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date> {
        public zze(String str, int i) {
            super(str, i);
        }
    }

    static {
        zzald = new zza("created", 4100000);
        zzale = new zzb("lastOpenedTime", 4300000);
        zzalf = new zzd("modified", 4100000);
        zzalg = new zzc("modifiedByMe", 4100000);
        zzalh = new zze("sharedWithMe", 4100000);
    }
}
