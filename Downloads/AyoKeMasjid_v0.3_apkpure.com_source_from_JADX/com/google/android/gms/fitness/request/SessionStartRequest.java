package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznh.zza;

public class SessionStartRequest implements SafeParcelable {
    public static final Creator<SessionStartRequest> CREATOR;
    private final int mVersionCode;
    private final String zzOZ;
    private final Session zzanp;
    private final zznh zzapE;

    static {
        CREATOR = new zzx();
    }

    SessionStartRequest(int versionCode, Session session, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzanp = session;
        this.zzapE = callback == null ? null : zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public SessionStartRequest(Session session, zznh callback, String packageName) {
        zzx.zzb(session.isOngoing(), (Object) "Cannot start a session which has already ended");
        this.mVersionCode = 2;
        this.zzanp = session;
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    private boolean zzb(SessionStartRequest sessionStartRequest) {
        return zzw.equal(this.zzanp, sessionStartRequest.zzanp);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionStartRequest) && zzb((SessionStartRequest) o));
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    public Session getSession() {
        return this.zzanp;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanp);
    }

    public String toString() {
        return zzw.zzu(this).zzg("session", this.zzanp).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzx.zza(this, dest, flags);
    }

    public IBinder zzsc() {
        return this.zzapE == null ? null : this.zzapE.asBinder();
    }
}
