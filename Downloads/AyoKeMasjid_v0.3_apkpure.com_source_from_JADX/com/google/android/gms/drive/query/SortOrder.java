package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SortOrder implements SafeParcelable {
    public static final Creator<SortOrder> CREATOR;
    final int mVersionCode;
    final List<FieldWithSortOrder> zzalt;
    final boolean zzalu;

    public static class Builder {
        private final List<FieldWithSortOrder> zzalt;
        private boolean zzalu;

        public Builder() {
            this.zzalt = new ArrayList();
            this.zzalu = false;
        }

        public Builder addSortAscending(SortableMetadataField sortField) {
            this.zzalt.add(new FieldWithSortOrder(sortField.getName(), true));
            return this;
        }

        public Builder addSortDescending(SortableMetadataField sortField) {
            this.zzalt.add(new FieldWithSortOrder(sortField.getName(), false));
            return this;
        }

        public SortOrder build() {
            return new SortOrder(this.zzalu, null);
        }
    }

    static {
        CREATOR = new zzb();
    }

    SortOrder(int versionCode, List<FieldWithSortOrder> sortingFields, boolean sortFolderFirst) {
        this.mVersionCode = versionCode;
        this.zzalt = sortingFields;
        this.zzalu = sortFolderFirst;
    }

    private SortOrder(List<FieldWithSortOrder> sortingFields, boolean sortFolderFirst) {
        this(1, (List) sortingFields, sortFolderFirst);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", new Object[]{TextUtils.join(",", this.zzalt), Boolean.valueOf(this.zzalu)});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
