package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.PopupManager.PopupLocationInfo;

public final class PopupLocationInfoParcelable implements SafeParcelable {
    public static final PopupLocationInfoParcelableCreator CREATOR;
    private final int mVersionCode;
    private final Bundle zzaum;
    private final IBinder zzaun;

    static {
        CREATOR = new PopupLocationInfoParcelableCreator();
    }

    PopupLocationInfoParcelable(int versionCode, Bundle infoBundle, IBinder windowToken) {
        this.mVersionCode = versionCode;
        this.zzaum = infoBundle;
        this.zzaun = windowToken;
    }

    public PopupLocationInfoParcelable(PopupLocationInfo popupLocationInfo) {
        this.mVersionCode = 1;
        this.zzaum = popupLocationInfo.zzuo();
        this.zzaun = popupLocationInfo.zzauq;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public IBinder getWindowToken() {
        return this.zzaun;
    }

    public void writeToParcel(Parcel out, int flags) {
        PopupLocationInfoParcelableCreator.zza(this, out, flags);
    }

    public Bundle zzuo() {
        return this.zzaum;
    }
}
