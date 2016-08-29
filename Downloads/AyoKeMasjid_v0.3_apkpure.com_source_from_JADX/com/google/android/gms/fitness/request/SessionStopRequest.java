package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzng;
import com.google.android.gms.internal.zzng.zza;

public class SessionStopRequest implements SafeParcelable {
    public static final Creator<SessionStopRequest> CREATOR;
    private final String mName;
    private final int mVersionCode;
    private final String zzOZ;
    private final String zzaoA;
    private final zzng zzaqA;

    static {
        CREATOR = new zzy();
    }

    SessionStopRequest(int versionCode, String name, String identifier, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzaoA = identifier;
        this.zzaqA = callback == null ? null : zza.zzbI(callback);
        this.zzOZ = packageName;
    }

    public SessionStopRequest(String name, String identifier, zzng callback, String packageName) {
        this.mVersionCode = 2;
        this.mName = name;
        this.zzaoA = identifier;
        this.zzaqA = callback;
        this.zzOZ = packageName;
    }

    private boolean zzb(SessionStopRequest sessionStopRequest) {
        return zzw.equal(this.mName, sessionStopRequest.mName) && zzw.equal(this.zzaoA, sessionStopRequest.zzaoA);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionStopRequest) && zzb((SessionStopRequest) o));
    }

    public String getIdentifier() {
        return this.zzaoA;
    }

    public String getName() {
        return this.mName;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzaoA);
    }

    public String toString() {
        return zzw.zzu(this).zzg("name", this.mName).zzg("identifier", this.zzaoA).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzy.zza(this, dest, flags);
    }

    public IBinder zzsc() {
        return this.zzaqA == null ? null : this.zzaqA.asBinder();
    }
}
