package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet {
    public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
    public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
    public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
    public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
    public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
    public static final MetadataChangeSet zzagR;
    private final MetadataBundle zzagS;

    public static class Builder {
        private final MetadataBundle zzagS;
        private zza zzagT;

        public Builder() {
            this.zzagS = MetadataBundle.zzrb();
        }

        private int zzcE(String str) {
            return str == null ? 0 : str.getBytes().length;
        }

        private String zzj(String str, int i, int i2) {
            return String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        }

        private void zzk(String str, int i, int i2) {
            zzx.zzb(i2 <= i, zzj(str, i, i2));
        }

        private zza zzqq() {
            if (this.zzagT == null) {
                this.zzagT = new zza();
            }
            return this.zzagT;
        }

        public MetadataChangeSet build() {
            if (this.zzagT != null) {
                this.zzagS.zzb(zzmb.zzakq, this.zzagT.zzqY());
            }
            return new MetadataChangeSet(this.zzagS);
        }

        public Builder deleteCustomProperty(CustomPropertyKey key) {
            zzx.zzb((Object) key, (Object) "key");
            zzqq().zza(key, null);
            return this;
        }

        public Builder setCustomProperty(CustomPropertyKey key, String value) {
            zzx.zzb((Object) key, (Object) "key");
            zzx.zzb((Object) value, (Object) "value");
            zzk("The total size of key string and value string of a custom property", MetadataChangeSet.CUSTOM_PROPERTY_SIZE_LIMIT_BYTES, zzcE(key.getKey()) + zzcE(value));
            zzqq().zza(key, value);
            return this;
        }

        public Builder setDescription(String description) {
            this.zzagS.zzb(zzmb.zzakr, description);
            return this;
        }

        public Builder setIndexableText(String text) {
            zzk("Indexable text size", MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES, zzcE(text));
            this.zzagS.zzb(zzmb.zzakx, text);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.zzagS.zzb(zzmd.zzale, date);
            return this;
        }

        public Builder setMimeType(String mimeType) {
            this.zzagS.zzb(zzmb.zzakL, mimeType);
            return this;
        }

        public Builder setPinned(boolean pinned) {
            this.zzagS.zzb(zzmb.zzakD, Boolean.valueOf(pinned));
            return this;
        }

        public Builder setStarred(boolean starred) {
            this.zzagS.zzb(zzmb.zzakS, Boolean.valueOf(starred));
            return this;
        }

        public Builder setTitle(String title) {
            this.zzagS.zzb(zzmb.zzakU, title);
            return this;
        }

        public Builder setViewed(boolean viewed) {
            this.zzagS.zzb(zzmb.zzakK, Boolean.valueOf(viewed));
            return this;
        }
    }

    static {
        zzagR = new MetadataChangeSet(MetadataBundle.zzrb());
    }

    public MetadataChangeSet(MetadataBundle bag) {
        this.zzagS = MetadataBundle.zza(bag);
    }

    public Map<CustomPropertyKey, String> getCustomPropertyChangeMap() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) this.zzagS.zza(zzmb.zzakq);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zzqX();
    }

    public String getDescription() {
        return (String) this.zzagS.zza(zzmb.zzakr);
    }

    public String getIndexableText() {
        return (String) this.zzagS.zza(zzmb.zzakx);
    }

    public Date getLastViewedByMeDate() {
        return (Date) this.zzagS.zza(zzmd.zzale);
    }

    public String getMimeType() {
        return (String) this.zzagS.zza(zzmb.zzakL);
    }

    public String getTitle() {
        return (String) this.zzagS.zza(zzmb.zzakU);
    }

    public Boolean isPinned() {
        return (Boolean) this.zzagS.zza(zzmb.zzakD);
    }

    public Boolean isStarred() {
        return (Boolean) this.zzagS.zza(zzmb.zzakS);
    }

    public Boolean isViewed() {
        return (Boolean) this.zzagS.zza(zzmb.zzakK);
    }

    public MetadataBundle zzqp() {
        return this.zzagS;
    }
}
