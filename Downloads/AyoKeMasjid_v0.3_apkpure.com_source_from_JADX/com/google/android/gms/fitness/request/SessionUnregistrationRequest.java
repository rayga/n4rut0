package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznh.zza;

public class SessionUnregistrationRequest implements SafeParcelable {
    public static final Creator<SessionUnregistrationRequest> CREATOR;
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;

    static {
        CREATOR = new zzz();
    }

    SessionUnregistrationRequest(int versionCode, PendingIntent intent, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.mPendingIntent = intent;
        this.zzapE = callback == null ? null : zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public SessionUnregistrationRequest(PendingIntent pendingIntent, zznh callback, String packageName) {
        this.mVersionCode = 4;
        this.mPendingIntent = pendingIntent;
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    private boolean zzb(SessionUnregistrationRequest sessionUnregistrationRequest) {
        return zzw.equal(this.mPendingIntent, sessionUnregistrationRequest.mPendingIntent);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionUnregistrationRequest) && zzb((SessionUnregistrationRequest) that));
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mPendingIntent);
    }

    public String toString() {
        return zzw.zzu(this).zzg("pendingIntent", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzz.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        return this.zzapE == null ? null : this.zzapE.asBinder();
    }

    public PendingIntent zzso() {
        return this.mPendingIntent;
    }
}
