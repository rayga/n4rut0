package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<OpenFileIntentSenderRequest> CREATOR;
    final int mVersionCode;
    final String zzagU;
    final String[] zzagV;
    final DriveId zzagX;
    final FilterHolder zzajX;

    static {
        CREATOR = new zzbk();
    }

    OpenFileIntentSenderRequest(int versionCode, String title, String[] mimeTypes, DriveId startFolder, FilterHolder filterHolder) {
        this.mVersionCode = versionCode;
        this.zzagU = title;
        this.zzagV = mimeTypes;
        this.zzagX = startFolder;
        this.zzajX = filterHolder;
    }

    public OpenFileIntentSenderRequest(String title, String[] mimeTypes, DriveId startFolder, FilterHolder filterHolder) {
        this(1, title, mimeTypes, startFolder, filterHolder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbk.zza(this, dest, flags);
    }
}
