package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

public class ViewableItem implements SafeParcelable {
    public static final Creator<ViewableItem> CREATOR;
    private final int versionCode;
    private String[] zzaKp;

    static {
        CREATOR = new zzf();
    }

    private ViewableItem() {
        this.versionCode = 1;
    }

    ViewableItem(int versionCode, String[] uris) {
        this.versionCode = versionCode;
        this.zzaKp = uris;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ViewableItem)) {
            return false;
        }
        return zzw.equal(this.zzaKp, ((ViewableItem) o).zzaKp);
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaKp);
    }

    public String toString() {
        return "ViewableItem[uris=" + Arrays.toString(this.zzaKp) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public String[] zzyv() {
        return this.zzaKp;
    }
}
