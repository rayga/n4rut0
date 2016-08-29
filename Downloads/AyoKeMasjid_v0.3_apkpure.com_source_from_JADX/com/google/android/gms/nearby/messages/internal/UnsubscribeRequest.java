package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzb.zza;

public final class UnsubscribeRequest implements SafeParcelable {
    public static final Creator<UnsubscribeRequest> CREATOR;
    final int mVersionCode;
    public final String zzaCr;
    public final zzc zzaJR;
    public final String zzaKe;
    public final zzb zzaKf;
    public final PendingIntent zzaKh;
    public final int zzaKi;

    static {
        CREATOR = new zzn();
    }

    UnsubscribeRequest(int versionCode, IBinder messageListener, IBinder callbackAsBinder, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName) {
        this.mVersionCode = versionCode;
        this.zzaKf = zza.zzdh(messageListener);
        this.zzaJR = zzc.zza.zzdi(callbackAsBinder);
        this.zzaKh = pendingIntent;
        this.zzaKi = messageListenerKey;
        this.zzaCr = zeroPartyPackageName;
        this.zzaKe = realClientPackageName;
    }

    UnsubscribeRequest(IBinder messageListener, IBinder callbackAsBinder, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName) {
        this(1, messageListener, callbackAsBinder, pendingIntent, messageListenerKey, zeroPartyPackageName, realClientPackageName);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }

    IBinder zzyp() {
        return this.zzaJR.asBinder();
    }

    IBinder zzyq() {
        return this.zzaKf == null ? null : this.zzaKf.asBinder();
    }
}
