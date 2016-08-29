package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class ChangesAvailableOptions implements SafeParcelable {
    public static final Creator<ChangesAvailableOptions> CREATOR;
    final int mVersionCode;
    final int zzaho;
    final boolean zzahp;
    final List<DriveSpace> zzahq;
    private final Set<DriveSpace> zzahr;

    static {
        CREATOR = new zzd();
    }

    ChangesAvailableOptions(int versionCode, int changesSizeLimit, boolean repeats, List<DriveSpace> spacesList) {
        this(versionCode, changesSizeLimit, repeats, spacesList, spacesList == null ? null : new HashSet(spacesList));
    }

    private ChangesAvailableOptions(int versionCode, int changesSizeLimit, boolean repeats, List<DriveSpace> spacesList, Set<DriveSpace> spaces) {
        this.mVersionCode = versionCode;
        this.zzaho = changesSizeLimit;
        this.zzahp = repeats;
        this.zzahq = spacesList;
        this.zzahr = spaces;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        ChangesAvailableOptions changesAvailableOptions = (ChangesAvailableOptions) o;
        return zzw.equal(this.zzahr, changesAvailableOptions.zzahr) && this.zzaho == changesAvailableOptions.zzaho && this.zzahp == changesAvailableOptions.zzahp;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzahr, Integer.valueOf(this.zzaho), Boolean.valueOf(this.zzahp));
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", new Object[]{Integer.valueOf(this.zzaho), Boolean.valueOf(this.zzahp), this.zzahq});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
