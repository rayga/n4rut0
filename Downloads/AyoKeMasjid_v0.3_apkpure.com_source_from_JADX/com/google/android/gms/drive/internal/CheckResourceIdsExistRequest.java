package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckResourceIdsExistRequest implements SafeParcelable {
    public static final Creator<CheckResourceIdsExistRequest> CREATOR;
    private final int mVersionCode;
    private final List<String> zzahO;

    static {
        CREATOR = new zzf();
    }

    CheckResourceIdsExistRequest(int versionCode, List<String> resourceIds) {
        this.mVersionCode = versionCode;
        this.zzahO = resourceIds;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public List<String> zzqD() {
        return this.zzahO;
    }
}
