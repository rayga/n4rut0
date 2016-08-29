package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class SessionDataSet implements SafeParcelable {
    public static final Creator<SessionDataSet> CREATOR;
    final int mVersionCode;
    private final Session zzanp;
    private final DataSet zzaoD;

    static {
        CREATOR = new zzq();
    }

    SessionDataSet(int versionCode, Session session, DataSet dataSet) {
        this.mVersionCode = versionCode;
        this.zzanp = session;
        this.zzaoD = dataSet;
    }

    private boolean zza(SessionDataSet sessionDataSet) {
        return zzw.equal(this.zzanp, sessionDataSet.zzanp) && zzw.equal(this.zzaoD, sessionDataSet.zzaoD);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionDataSet) && zza((SessionDataSet) o));
    }

    public Session getSession() {
        return this.zzanp;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanp, this.zzaoD);
    }

    public String toString() {
        return zzw.zzu(this).zzg("session", this.zzanp).zzg("dataSet", this.zzaoD).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }

    public DataSet zzrO() {
        return this.zzaoD;
    }
}
