package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzmf;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zze {
    private static final Map<String, MetadataField<?>> zzakl;

    static {
        zzakl = new HashMap();
        zzb(zzmb.zzako);
        zzb(zzmb.zzakU);
        zzb(zzmb.zzakL);
        zzb(zzmb.zzakS);
        zzb(zzmb.zzakV);
        zzb(zzmb.zzakB);
        zzb(zzmb.zzakA);
        zzb(zzmb.zzakC);
        zzb(zzmb.zzakD);
        zzb(zzmb.zzakE);
        zzb(zzmb.zzaky);
        zzb(zzmb.zzakG);
        zzb(zzmb.zzakH);
        zzb(zzmb.zzakI);
        zzb(zzmb.zzakQ);
        zzb(zzmb.zzakp);
        zzb(zzmb.zzakN);
        zzb(zzmb.zzakr);
        zzb(zzmb.zzakz);
        zzb(zzmb.zzaks);
        zzb(zzmb.zzakt);
        zzb(zzmb.zzaku);
        zzb(zzmb.zzakv);
        zzb(zzmb.zzakK);
        zzb(zzmb.zzakF);
        zzb(zzmb.zzakM);
        zzb(zzmb.zzakO);
        zzb(zzmb.zzakP);
        zzb(zzmb.zzakR);
        zzb(zzmb.zzakW);
        zzb(zzmb.zzakX);
        zzb(zzmb.zzakx);
        zzb(zzmb.zzakw);
        zzb(zzmb.zzakT);
        zzb(zzmb.zzakJ);
        zzb(zzmb.zzakq);
        zzb(zzmb.zzakY);
        zzb(zzmb.zzakZ);
        zzb(zzmb.zzala);
        zzb(zzmb.zzalb);
        zzb(zzmb.zzalc);
        zzb(zzmd.zzald);
        zzb(zzmd.zzalf);
        zzb(zzmd.zzalg);
        zzb(zzmd.zzalh);
        zzb(zzmd.zzale);
        zzb(zzmf.zzalj);
        zzb(zzmf.zzalk);
    }

    public static void zzb(DataHolder dataHolder) {
        zzmb.zzakQ.zzd(dataHolder);
    }

    private static void zzb(MetadataField<?> metadataField) {
        if (zzakl.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        zzakl.put(metadataField.getName(), metadataField);
    }

    public static MetadataField<?> zzcG(String str) {
        return (MetadataField) zzakl.get(str);
    }

    public static Collection<MetadataField<?>> zzra() {
        return Collections.unmodifiableCollection(zzakl.values());
    }
}
