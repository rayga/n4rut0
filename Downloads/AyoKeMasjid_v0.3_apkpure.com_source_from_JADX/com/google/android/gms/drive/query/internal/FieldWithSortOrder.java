package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class FieldWithSortOrder implements SafeParcelable {
    public static final zzc CREATOR;
    final int mVersionCode;
    final String zzakc;
    final boolean zzaly;

    static {
        CREATOR = new zzc();
    }

    FieldWithSortOrder(int versionCode, String fieldName, boolean isSortAscending) {
        this.mVersionCode = versionCode;
        this.zzakc = fieldName;
        this.zzaly = isSortAscending;
    }

    public FieldWithSortOrder(String fieldName, boolean isSortAscending) {
        this(1, fieldName, isSortAscending);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        Locale locale = Locale.US;
        String str = "FieldWithSortOrder[%s %s]";
        Object[] objArr = new Object[2];
        objArr[0] = this.zzakc;
        objArr[1] = this.zzaly ? "ASC" : "DESC";
        return String.format(locale, str, objArr);
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
