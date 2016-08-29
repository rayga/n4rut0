package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public final class AppMetadata implements SafeParcelable {
    public static final Creator<AppMetadata> CREATOR;
    private final int mVersionCode;
    private final List<AppIdentifier> zzaJi;

    static {
        CREATOR = new zzb();
    }

    AppMetadata(int versionCode, List<AppIdentifier> appIdentifiers) {
        this.mVersionCode = versionCode;
        this.zzaJi = (List) zzx.zzb((Object) appIdentifiers, (Object) "Must specify application identifiers");
        zzx.zza(appIdentifiers.size(), (Object) "Application identifiers cannot be empty");
    }

    public AppMetadata(List<AppIdentifier> appIdentifiers) {
        this(1, appIdentifiers);
    }

    public int describeContents() {
        return 0;
    }

    public List<AppIdentifier> getAppIdentifiers() {
        return this.zzaJi;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
