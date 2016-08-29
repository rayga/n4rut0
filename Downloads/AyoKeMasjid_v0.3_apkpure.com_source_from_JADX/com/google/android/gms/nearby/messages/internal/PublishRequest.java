package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zzc.zza;

public final class PublishRequest implements SafeParcelable {
    public static final Creator<PublishRequest> CREATOR;
    final int mVersionCode;
    public final String zzaCr;
    public final boolean zzaJJ;
    public final zzc zzaJR;
    public final MessageWrapper zzaKc;
    public final Strategy zzaKd;
    public final String zzaKe;

    static {
        CREATOR = new zzk();
    }

    PublishRequest(int versionCode, MessageWrapper messageWrapper, Strategy strategy, IBinder callbackAsBinder, String zeroPartyPackageName, String realClientPackageName, boolean isIgnoreNearbyPermission) {
        this.mVersionCode = versionCode;
        this.zzaKc = messageWrapper;
        this.zzaKd = strategy;
        this.zzaJR = zza.zzdi(callbackAsBinder);
        this.zzaCr = zeroPartyPackageName;
        this.zzaKe = realClientPackageName;
        this.zzaJJ = isIgnoreNearbyPermission;
    }

    PublishRequest(MessageWrapper messageWrapper, Strategy strategy, IBinder callbackAsBinder, String zeroPartyPackageName, String realClientPackageName, boolean isIgnoreNearbyPermission) {
        this(1, messageWrapper, strategy, callbackAsBinder, zeroPartyPackageName, realClientPackageName, isIgnoreNearbyPermission);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    IBinder zzyp() {
        return this.zzaJR.asBinder();
    }
}
