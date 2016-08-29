package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import java.util.Date;

public class SortableField {
    public static final SortableMetadataField<Date> CREATED_DATE;
    public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME;
    public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE;
    public static final SortableMetadataField<Date> MODIFIED_DATE;
    public static final SortableMetadataField<Long> QUOTA_USED;
    public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE;
    public static final SortableMetadataField<String> TITLE;

    static {
        TITLE = zzmb.zzakU;
        CREATED_DATE = zzmd.zzald;
        MODIFIED_DATE = zzmd.zzalf;
        MODIFIED_BY_ME_DATE = zzmd.zzalg;
        LAST_VIEWED_BY_ME = zzmd.zzale;
        SHARED_WITH_ME_DATE = zzmd.zzalh;
        QUOTA_USED = zzmb.zzakR;
    }
}
