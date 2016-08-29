package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzc.zza;

public class GetPermissionStatusRequest implements SafeParcelable {
    public static final Creator<GetPermissionStatusRequest> CREATOR;
    final int mVersionCode;
    public final String zzaCr;
    public final zzc zzaJR;

    static {
        CREATOR = new zza();
    }

    GetPermissionStatusRequest(int versionCode, IBinder callbackAsBinder, String zeroPartyPackageName) {
        this.mVersionCode = versionCode;
        this.zzaJR = zza.zzdi(callbackAsBinder);
        this.zzaCr = zeroPartyPackageName;
    }

    GetPermissionStatusRequest(IBinder callbackAsBinder, String zeroPartyPackageName) {
        this(1, callbackAsBinder, zeroPartyPackageName);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    IBinder zzyp() {
        return this.zzaJR.asBinder();
    }
}
