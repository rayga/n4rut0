package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import java.util.Date;

public class SearchableField {
    public static final SearchableMetadataField<Boolean> IS_PINNED;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME;
    public static final SearchableMetadataField<String> MIME_TYPE;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS;
    public static final SearchableMetadataField<Boolean> STARRED;
    public static final SearchableMetadataField<String> TITLE;
    public static final SearchableMetadataField<Boolean> TRASHED;
    public static final SearchableOrderedMetadataField<Date> zzalr;
    public static final SearchableMetadataField<AppVisibleCustomProperties> zzals;

    static {
        TITLE = zzmb.zzakU;
        MIME_TYPE = zzmb.zzakL;
        TRASHED = zzmb.zzakV;
        PARENTS = zzmb.zzakQ;
        zzalr = zzmd.zzalh;
        STARRED = zzmb.zzakS;
        MODIFIED_DATE = zzmd.zzalf;
        LAST_VIEWED_BY_ME = zzmd.zzale;
        IS_PINNED = zzmb.zzakD;
        zzals = zzmb.zzakq;
    }
}
