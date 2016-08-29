package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.WriteAwareParcelable;
import java.util.List;

public class OnChangesResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Creator<OnChangesResponse> CREATOR;
    final int mVersionCode;
    final DataHolder zzajE;
    final List<DriveId> zzajF;
    final ChangeSequenceNumber zzajG;
    final boolean zzajH;

    static {
        CREATOR = new zzau();
    }

    OnChangesResponse(int versionCode, DataHolder newOrModifiedResourcesData, List<DriveId> deleted, ChangeSequenceNumber lastChangeSequenceNumber, boolean moreChangesExist) {
        this.mVersionCode = versionCode;
        this.zzajE = newOrModifiedResourcesData;
        this.zzajF = deleted;
        this.zzajG = lastChangeSequenceNumber;
        this.zzajH = moreChangesExist;
    }

    public int describeContents() {
        return 0;
    }

    protected void zzI(Parcel parcel, int i) {
        zzau.zza(this, parcel, i | 1);
    }
}
