package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class AppContentTupleEntity implements SafeParcelable, AppContentTuple {
    public static final AppContentTupleEntityCreator CREATOR;
    private final String mName;
    private final String mValue;
    private final int mVersionCode;

    static {
        CREATOR = new AppContentTupleEntityCreator();
    }

    AppContentTupleEntity(int versionCode, String name, String value) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.mValue = value;
    }

    public AppContentTupleEntity(AppContentTuple tuple) {
        this.mVersionCode = 1;
        this.mName = tuple.getName();
        this.mValue = tuple.getValue();
    }

    static int zza(AppContentTuple appContentTuple) {
        return zzw.hashCode(appContentTuple.getName(), appContentTuple.getValue());
    }

    static boolean zza(AppContentTuple appContentTuple, Object obj) {
        if (!(obj instanceof AppContentTuple)) {
            return false;
        }
        if (appContentTuple == obj) {
            return true;
        }
        AppContentTuple appContentTuple2 = (AppContentTuple) obj;
        return zzw.equal(appContentTuple2.getName(), appContentTuple.getName()) && zzw.equal(appContentTuple2.getValue(), appContentTuple.getValue());
    }

    static String zzb(AppContentTuple appContentTuple) {
        return zzw.zzu(appContentTuple).zzg("Name", appContentTuple.getName()).zzg("Value", appContentTuple.getValue()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztB();
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentTupleEntityCreator.zza(this, out, flags);
    }

    public AppContentTuple zztB() {
        return this;
    }
}
