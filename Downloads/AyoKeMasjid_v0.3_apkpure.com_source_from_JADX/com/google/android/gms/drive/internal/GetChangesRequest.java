package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetChangesRequest implements SafeParcelable {
    public static final Creator<GetChangesRequest> CREATOR;
    final int mVersionCode;
    final List<DriveSpace> zzahq;
    private final Set<DriveSpace> zzahr;
    final ChangeSequenceNumber zzajm;
    final int zzajn;

    static {
        CREATOR = new zzag();
    }

    GetChangesRequest(int versionCode, ChangeSequenceNumber fromSequenceNumber, int maxResults, List<DriveSpace> spacesList) {
        this(versionCode, fromSequenceNumber, maxResults, spacesList, spacesList == null ? null : new HashSet(spacesList));
    }

    private GetChangesRequest(int versionCode, ChangeSequenceNumber fromSequenceNumber, int maxResults, List<DriveSpace> spacesList, Set<DriveSpace> spaces) {
        this.mVersionCode = versionCode;
        this.zzajm = fromSequenceNumber;
        this.zzajn = maxResults;
        this.zzahq = spacesList;
        this.zzahr = spaces;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzag.zza(this, dest, flags);
    }
}
