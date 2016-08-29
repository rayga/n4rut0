package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zznh.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest implements SafeParcelable {
    public static final Creator<DataDeleteRequest> CREATOR;
    private final int mVersionCode;
    private final long zzMS;
    private final String zzOZ;
    private final long zzann;
    private final List<DataType> zzanw;
    private final zznh zzapE;
    private final List<DataSource> zzapG;
    private final List<Session> zzapH;
    private final boolean zzapI;
    private final boolean zzapJ;

    public static class Builder {
        private long zzMS;
        private long zzann;
        private List<DataType> zzanw;
        private List<DataSource> zzapG;
        private List<Session> zzapH;
        private boolean zzapI;
        private boolean zzapJ;

        public Builder() {
            this.zzapG = new ArrayList();
            this.zzanw = new ArrayList();
            this.zzapH = new ArrayList();
            this.zzapI = false;
            this.zzapJ = false;
        }

        private void zzsf() {
            if (!this.zzapH.isEmpty()) {
                for (Session session : this.zzapH) {
                    boolean z = session.getStartTime(TimeUnit.MILLISECONDS) >= this.zzMS && session.getEndTime(TimeUnit.MILLISECONDS) <= this.zzann;
                    zzx.zza(z, "Session %s is outside the time interval [%d, %d]", session, Long.valueOf(this.zzMS), Long.valueOf(this.zzann));
                }
            }
        }

        public Builder addDataSource(DataSource dataSource) {
            boolean z = true;
            zzx.zzb(!this.zzapI, (Object) "All data is already marked for deletion.  addDataSource() cannot be combined with deleteAllData()");
            if (dataSource == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Must specify a valid data source");
            if (!this.zzapG.contains(dataSource)) {
                this.zzapG.add(dataSource);
            }
            return this;
        }

        public Builder addDataType(DataType dataType) {
            boolean z = true;
            zzx.zzb(!this.zzapI, (Object) "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
            if (dataType == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Must specify a valid data type");
            if (!this.zzanw.contains(dataType)) {
                this.zzanw.add(dataType);
            }
            return this;
        }

        public Builder addSession(Session session) {
            boolean z = true;
            zzx.zzb(!this.zzapJ, (Object) "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
            zzx.zzb(session != null, (Object) "Must specify a valid session");
            if (session.getEndTime(TimeUnit.MILLISECONDS) <= 0) {
                z = false;
            }
            zzx.zzb(z, (Object) "Cannot delete an ongoing session. Please stop the session prior to deleting it");
            this.zzapH.add(session);
            return this;
        }

        public DataDeleteRequest build() {
            boolean z = false;
            boolean z2 = this.zzMS > 0 && this.zzann > this.zzMS;
            zzx.zza(z2, (Object) "Must specify a valid time interval");
            z2 = (!this.zzapI && this.zzapG.isEmpty() && this.zzanw.isEmpty()) ? false : true;
            boolean z3 = this.zzapJ || !this.zzapH.isEmpty();
            if (z2 || z3) {
                z = true;
            }
            zzx.zza(z, (Object) "No data or session marked for deletion");
            zzsf();
            return new DataDeleteRequest();
        }

        public Builder deleteAllData() {
            zzx.zzb(this.zzanw.isEmpty(), (Object) "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
            zzx.zzb(this.zzapG.isEmpty(), (Object) "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
            this.zzapI = true;
            return this;
        }

        public Builder deleteAllSessions() {
            zzx.zzb(this.zzapH.isEmpty(), (Object) "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
            this.zzapJ = true;
            return this;
        }

        public Builder setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
            zzx.zzb(startTime > 0, "Invalid start time :%d", Long.valueOf(startTime));
            zzx.zzb(endTime > startTime, "Invalid end time :%d", Long.valueOf(endTime));
            this.zzMS = timeUnit.toMillis(startTime);
            this.zzann = timeUnit.toMillis(endTime);
            return this;
        }
    }

    static {
        CREATOR = new zzd();
    }

    DataDeleteRequest(int versionCode, long startTimeMillis, long endTimeMillis, List<DataSource> dataSources, List<DataType> dataTypes, List<Session> sessions, boolean deleteAllData, boolean deleteAllSessions, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzMS = startTimeMillis;
        this.zzann = endTimeMillis;
        this.zzapG = Collections.unmodifiableList(dataSources);
        this.zzanw = Collections.unmodifiableList(dataTypes);
        this.zzapH = sessions;
        this.zzapI = deleteAllData;
        this.zzapJ = deleteAllSessions;
        this.zzapE = callback == null ? null : zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public DataDeleteRequest(long startTimeMillis, long endTimeMillis, List<DataSource> dataSources, List<DataType> dataTypes, List<Session> sessions, boolean deleteAllData, boolean deleteAllSessions, zznh callback, String packageName) {
        this.mVersionCode = 2;
        this.zzMS = startTimeMillis;
        this.zzann = endTimeMillis;
        this.zzapG = Collections.unmodifiableList(dataSources);
        this.zzanw = Collections.unmodifiableList(dataTypes);
        this.zzapH = sessions;
        this.zzapI = deleteAllData;
        this.zzapJ = deleteAllSessions;
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    private DataDeleteRequest(Builder builder) {
        this(builder.zzMS, builder.zzann, builder.zzapG, builder.zzanw, builder.zzapH, builder.zzapI, builder.zzapJ, null, null);
    }

    public DataDeleteRequest(DataDeleteRequest request, zznh callback, String packageName) {
        this(request.zzMS, request.zzann, request.zzapG, request.zzanw, request.zzapH, request.zzapI, request.zzapJ, callback, packageName);
    }

    private boolean zzb(DataDeleteRequest dataDeleteRequest) {
        return this.zzMS == dataDeleteRequest.zzMS && this.zzann == dataDeleteRequest.zzann && zzw.equal(this.zzapG, dataDeleteRequest.zzapG) && zzw.equal(this.zzanw, dataDeleteRequest.zzanw) && zzw.equal(this.zzapH, dataDeleteRequest.zzapH) && this.zzapI == dataDeleteRequest.zzapI && this.zzapJ == dataDeleteRequest.zzapJ;
    }

    public boolean deleteAllData() {
        return this.zzapI;
    }

    public boolean deleteAllSessions() {
        return this.zzapJ;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataDeleteRequest) && zzb((DataDeleteRequest) o));
    }

    public List<DataSource> getDataSources() {
        return this.zzapG;
    }

    public List<DataType> getDataTypes() {
        return this.zzanw;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzann, TimeUnit.MILLISECONDS);
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    public List<Session> getSessions() {
        return this.zzapH;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzMS, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzMS), Long.valueOf(this.zzann));
    }

    public String toString() {
        return zzw.zzu(this).zzg("startTimeMillis", Long.valueOf(this.zzMS)).zzg("endTimeMillis", Long.valueOf(this.zzann)).zzg("dataSources", this.zzapG).zzg("dateTypes", this.zzanw).zzg("sessions", this.zzapH).zzg("deleteAllData", Boolean.valueOf(this.zzapI)).zzg("deleteAllSessions", Boolean.valueOf(this.zzapJ)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }

    public long zzkH() {
        return this.zzMS;
    }

    public long zzrw() {
        return this.zzann;
    }

    public IBinder zzsc() {
        return this.zzapE == null ? null : this.zzapE.asBinder();
    }

    public boolean zzsd() {
        return this.zzapI;
    }

    public boolean zzse() {
        return this.zzapJ;
    }
}
