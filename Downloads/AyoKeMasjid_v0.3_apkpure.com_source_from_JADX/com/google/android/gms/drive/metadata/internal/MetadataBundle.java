package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzmb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR;
    final int mVersionCode;
    final Bundle zzakm;

    static {
        CREATOR = new zzh();
    }

    MetadataBundle(int versionCode, Bundle valueBundle) {
        this.mVersionCode = versionCode;
        this.zzakm = (Bundle) zzx.zzv(valueBundle);
        this.zzakm.setClassLoader(getClass().getClassLoader());
        List<String> arrayList = new ArrayList();
        for (String str : this.zzakm.keySet()) {
            if (zze.zzcG(str) == null) {
                arrayList.add(str);
                zzy.zzw("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String str2 : arrayList) {
            this.zzakm.remove(str2);
        }
    }

    private MetadataBundle(Bundle valueBundle) {
        this(1, valueBundle);
    }

    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t) {
        MetadataBundle zzrb = zzrb();
        zzrb.zzb(metadataField, t);
        return zzrb;
    }

    public static MetadataBundle zza(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.zzakm));
    }

    public static MetadataBundle zzrb() {
        return new MetadataBundle(new Bundle());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.zzakm.keySet();
        if (!keySet.equals(metadataBundle.zzakm.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!zzw.equal(this.zzakm.get(str), metadataBundle.zzakm.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (String str : this.zzakm.keySet()) {
            i *= 31;
            i = this.zzakm.get(str).hashCode() + i;
        }
        return i;
    }

    public void setContext(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zzmb.zzakT);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.zzc(context.getCacheDir());
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.zzakm + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zzj(this.zzakm);
    }

    public <T> void zzb(MetadataField<T> metadataField, T t) {
        if (zze.zzcG(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.zza(t, this.zzakm);
    }

    public boolean zzc(MetadataField<?> metadataField) {
        return this.zzakm.containsKey(metadataField.getName());
    }

    public Set<MetadataField<?>> zzrc() {
        Set<MetadataField<?>> hashSet = new HashSet();
        for (String zzcG : this.zzakm.keySet()) {
            hashSet.add(zze.zzcG(zzcG));
        }
        return hashSet;
    }
}
