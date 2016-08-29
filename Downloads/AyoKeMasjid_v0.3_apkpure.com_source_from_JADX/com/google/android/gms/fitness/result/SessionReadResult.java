package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
    public static final Creator<SessionReadResult> CREATOR;
    private final int mVersionCode;
    private final Status zzQA;
    private final List<Session> zzapH;
    private final List<SessionDataSet> zzaqO;

    static {
        CREATOR = new zzj();
    }

    SessionReadResult(int versionCode, List<Session> sessions, List<SessionDataSet> sessionDataSets, Status status) {
        this.mVersionCode = versionCode;
        this.zzapH = sessions;
        this.zzaqO = Collections.unmodifiableList(sessionDataSets);
        this.zzQA = status;
    }

    public SessionReadResult(List<Session> sessions, List<SessionDataSet> sessionDataSets, Status status) {
        this.mVersionCode = 3;
        this.zzapH = sessions;
        this.zzaqO = Collections.unmodifiableList(sessionDataSets);
        this.zzQA = status;
    }

    public static SessionReadResult zzU(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean zzb(SessionReadResult sessionReadResult) {
        return this.zzQA.equals(sessionReadResult.zzQA) && zzw.equal(this.zzapH, sessionReadResult.zzapH) && zzw.equal(this.zzaqO, sessionReadResult.zzaqO);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionReadResult) && zzb((SessionReadResult) that));
    }

    public List<DataSet> getDataSet(Session session) {
        zzx.zzb(this.zzapH.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (SessionDataSet sessionDataSet : this.zzaqO) {
            if (zzw.equal(session, sessionDataSet.getSession())) {
                arrayList.add(sessionDataSet.zzrO());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        zzx.zzb(this.zzapH.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (SessionDataSet sessionDataSet : this.zzaqO) {
            if (zzw.equal(session, sessionDataSet.getSession()) && dataType.equals(sessionDataSet.zzrO().getDataType())) {
                arrayList.add(sessionDataSet.zzrO());
            }
        }
        return arrayList;
    }

    public List<Session> getSessions() {
        return this.zzapH;
    }

    public Status getStatus() {
        return this.zzQA;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzQA, this.zzapH, this.zzaqO);
    }

    public String toString() {
        return zzw.zzu(this).zzg(Games.EXTRA_STATUS, this.zzQA).zzg("sessions", this.zzapH).zzg("sessionDataSets", this.zzaqO).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    public List<SessionDataSet> zzsG() {
        return this.zzaqO;
    }
}
