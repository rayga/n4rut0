package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzmf;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    public String getAlternateLink() {
        return (String) zza(zzmb.zzakp);
    }

    public int getContentAvailability() {
        Integer num = (Integer) zza(zzmf.zzalj);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) zza(zzmd.zzald);
    }

    public Map<CustomPropertyKey, String> getCustomProperties() {
        AppVisibleCustomProperties appVisibleCustomProperties = (AppVisibleCustomProperties) zza(zzmb.zzakq);
        return appVisibleCustomProperties == null ? Collections.emptyMap() : appVisibleCustomProperties.zzqX();
    }

    public String getDescription() {
        return (String) zza(zzmb.zzakr);
    }

    public DriveId getDriveId() {
        return (DriveId) zza(zzmb.zzako);
    }

    public String getEmbedLink() {
        return (String) zza(zzmb.zzaks);
    }

    public String getFileExtension() {
        return (String) zza(zzmb.zzakt);
    }

    public long getFileSize() {
        return ((Long) zza(zzmb.zzaku)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) zza(zzmd.zzale);
    }

    public String getMimeType() {
        return (String) zza(zzmb.zzakL);
    }

    public Date getModifiedByMeDate() {
        return (Date) zza(zzmd.zzalg);
    }

    public Date getModifiedDate() {
        return (Date) zza(zzmd.zzalf);
    }

    public String getOriginalFilename() {
        return (String) zza(zzmb.zzakM);
    }

    public long getQuotaBytesUsed() {
        return ((Long) zza(zzmb.zzakR)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) zza(zzmd.zzalh);
    }

    public String getTitle() {
        return (String) zza(zzmb.zzakU);
    }

    public String getWebContentLink() {
        return (String) zza(zzmb.zzakW);
    }

    public String getWebViewLink() {
        return (String) zza(zzmb.zzakX);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) zza(zzmb.zzakA);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isExplicitlyTrashed() {
        Boolean bool = (Boolean) zza(zzmb.zzakB);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) zza(zzmb.zzaky);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) zza(zzmf.zzalk);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) zza(zzmb.zzakD);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) zza(zzmb.zzakF);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) zza(zzmb.zzakG);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) zza(zzmb.zzakS);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashable() {
        Boolean bool = (Boolean) zza(zzmb.zzakJ);
        return bool == null ? true : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) zza(zzmb.zzakV);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) zza(zzmb.zzakK);
        return bool == null ? false : bool.booleanValue();
    }

    public abstract <T> T zza(MetadataField<T> metadataField);
}
