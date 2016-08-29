package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

class zze {
    static MetadataField<?> zzb(MetadataBundle metadataBundle) {
        Set zzrc = metadataBundle.zzrc();
        if (zzrc.size() == 1) {
            return (MetadataField) zzrc.iterator().next();
        }
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}
