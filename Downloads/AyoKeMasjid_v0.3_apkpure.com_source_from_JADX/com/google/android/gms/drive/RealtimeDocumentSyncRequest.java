package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class RealtimeDocumentSyncRequest implements SafeParcelable {
    public static final Creator<RealtimeDocumentSyncRequest> CREATOR;
    final int mVersionCode;
    final List<String> zzahe;
    final List<String> zzahf;

    static {
        CREATOR = new zzi();
    }

    RealtimeDocumentSyncRequest(int versionCode, List<String> documentsToSync, List<String> documentsToDeleteCache) {
        this.mVersionCode = versionCode;
        this.zzahe = (List) zzx.zzv(documentsToSync);
        this.zzahf = (List) zzx.zzv(documentsToDeleteCache);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
