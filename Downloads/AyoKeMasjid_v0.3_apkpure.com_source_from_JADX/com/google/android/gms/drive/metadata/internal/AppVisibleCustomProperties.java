package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Creator<AppVisibleCustomProperties> CREATOR;
    public static final AppVisibleCustomProperties zzakh;
    final int mVersionCode;
    final List<CustomProperty> zzaki;

    public static class zza {
        private final Map<CustomPropertyKey, CustomProperty> zzakj;

        public zza() {
            this.zzakj = new HashMap();
        }

        public zza zza(CustomPropertyKey customPropertyKey, String str) {
            zzx.zzb((Object) customPropertyKey, (Object) "key");
            this.zzakj.put(customPropertyKey, new CustomProperty(customPropertyKey, str));
            return this;
        }

        public AppVisibleCustomProperties zzqY() {
            return new AppVisibleCustomProperties(null);
        }
    }

    static {
        CREATOR = new zza();
        zzakh = new zza().zzqY();
    }

    AppVisibleCustomProperties(int versionCode, Collection<CustomProperty> properties) {
        this.mVersionCode = versionCode;
        zzx.zzv(properties);
        this.zzaki = new ArrayList(properties);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> properties) {
        this(1, (Collection) properties);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator<CustomProperty> iterator() {
        return this.zzaki.iterator();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public Map<CustomPropertyKey, String> zzqX() {
        Map hashMap = new HashMap(this.zzaki.size());
        for (CustomProperty customProperty : this.zzaki) {
            hashMap.put(customProperty.zzqZ(), customProperty.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
