package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzc.zza;

public final class UnpublishRequest implements SafeParcelable {
    public static final Creator<UnpublishRequest> CREATOR;
    final int mVersionCode;
    public final String zzaCr;
    public final zzc zzaJR;
    public final MessageWrapper zzaKc;
    public final String zzaKe;

    static {
        CREATOR = new zzm();
    }

    UnpublishRequest(int versionCode, MessageWrapper messageWrapper, IBinder callbackAsBinder, String zeroPartyPackageName, String realClientPackageName) {
        this.mVersionCode = versionCode;
        this.zzaKc = messageWrapper;
        this.zzaJR = zza.zzdi(callbackAsBinder);
        this.zzaCr = zeroPartyPackageName;
        this.zzaKe = realClientPackageName;
    }

    UnpublishRequest(MessageWrapper messageWrapper, IBinder callbackAsBinder, String zeroPartyPackageName, String realClientPackageName) {
        this(1, messageWrapper, callbackAsBinder, zeroPartyPackageName, realClientPackageName);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }

    IBinder zzyp() {
        return this.zzaJR.asBinder();
    }
}
