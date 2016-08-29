package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class zza<T> implements MetadataField<T> {
    private final String zzakc;
    private final Set<String> zzakd;
    private final Set<String> zzake;
    private final int zzakf;

    protected zza(String str, int i) {
        this.zzakc = (String) zzx.zzb((Object) str, (Object) "fieldName");
        this.zzakd = Collections.singleton(str);
        this.zzake = Collections.emptySet();
        this.zzakf = i;
    }

    protected zza(String str, Collection<String> collection, Collection<String> collection2, int i) {
        this.zzakc = (String) zzx.zzb((Object) str, (Object) "fieldName");
        this.zzakd = Collections.unmodifiableSet(new HashSet(collection));
        this.zzake = Collections.unmodifiableSet(new HashSet(collection2));
        this.zzakf = i;
    }

    public final String getName() {
        return this.zzakc;
    }

    public String toString() {
        return this.zzakc;
    }

    public final T zza(DataHolder dataHolder, int i, int i2) {
        return zzb(dataHolder, i, i2) ? zzc(dataHolder, i, i2) : null;
    }

    protected abstract void zza(Bundle bundle, T t);

    public final void zza(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        zzx.zzb((Object) dataHolder, (Object) "dataHolder");
        zzx.zzb((Object) metadataBundle, (Object) "bundle");
        if (zzb(dataHolder, i, i2)) {
            metadataBundle.zzb(this, zzc(dataHolder, i, i2));
        }
    }

    public final void zza(T t, Bundle bundle) {
        zzx.zzb((Object) bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            zza(bundle, (Object) t);
        }
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        for (String str : this.zzakd) {
            if (dataHolder.zzcd(str)) {
                if (dataHolder.zzi(str, i, i2)) {
                }
            }
            return false;
        }
        return true;
    }

    protected abstract T zzc(DataHolder dataHolder, int i, int i2);

    public final T zzj(Bundle bundle) {
        zzx.zzb((Object) bundle, (Object) "bundle");
        return bundle.get(getName()) != null ? zzk(bundle) : null;
    }

    protected abstract T zzk(Bundle bundle);
}
