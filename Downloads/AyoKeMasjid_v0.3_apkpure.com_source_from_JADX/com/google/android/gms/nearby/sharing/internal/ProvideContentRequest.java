package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.SharedContent;
import com.google.android.gms.nearby.sharing.internal.zzb.zza;
import java.util.List;

public final class ProvideContentRequest implements SafeParcelable {
    public static final Creator<ProvideContentRequest> CREATOR;
    final int versionCode;
    public IBinder zzaKq;
    public zzb zzaKr;
    @Deprecated
    public List<SharedContent> zzaKs;
    public long zzaKt;
    public zzc zzaKu;

    static {
        CREATOR = new zzf();
    }

    ProvideContentRequest() {
        this.versionCode = 1;
    }

    ProvideContentRequest(int versionCode, IBinder clientBinder, IBinder contentProviderAsBinder, List<SharedContent> content, long activityId, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzaKq = clientBinder;
        this.zzaKr = zza.zzdm(contentProviderAsBinder);
        this.zzaKs = content;
        this.zzaKt = activityId;
        this.zzaKu = zzc.zza.zzdn(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    IBinder zzyp() {
        return this.zzaKu.asBinder();
    }

    IBinder zzyx() {
        return this.zzaKr == null ? null : this.zzaKr.asBinder();
    }
}
