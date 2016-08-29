package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zznf.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest implements SafeParcelable {
    public static final Creator<SessionReadRequest> CREATOR;
    private final int mVersionCode;
    private final String zzGY;
    private final long zzMS;
    private final String zzOZ;
    private final long zzann;
    private final List<DataType> zzanw;
    private final List<DataSource> zzapG;
    private final boolean zzapR;
    private final String zzaqv;
    private boolean zzaqw;
    private final List<String> zzaqx;
    private final zznf zzaqy;

    public static class Builder {
        private String zzGY;
        private long zzMS;
        private long zzann;
        private List<DataType> zzanw;
        private List<DataSource> zzapG;
        private boolean zzapR;
        private String zzaqv;
        private boolean zzaqw;
        private List<String> zzaqx;

        public Builder() {
            this.zzMS = 0;
            this.zzann = 0;
            this.zzanw = new ArrayList();
            this.zzapG = new ArrayList();
            this.zzaqw = false;
            this.zzapR = false;
            this.zzaqx = new ArrayList();
        }

        public SessionReadRequest build() {
            zzx.zzb(this.zzMS > 0, "Invalid start time: %s", Long.valueOf(this.zzMS));
            boolean z = this.zzann > 0 && this.zzann > this.zzMS;
            zzx.zzb(z, "Invalid end time: %s", Long.valueOf(this.zzann));
            return new SessionReadRequest();
        }

        public Builder enableServerQueries() {
            this.zzapR = true;
            return this;
        }

        public Builder excludePackage(String appPackageName) {
            zzx.zzb((Object) appPackageName, (Object) "Attempting to use a null package name");
            if (!this.zzaqx.contains(appPackageName)) {
                this.zzaqx.add(appPackageName);
            }
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzx.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            if (!this.zzapG.contains(dataSource)) {
                this.zzapG.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzx.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            if (!this.zzanw.contains(dataType)) {
                this.zzanw.add(dataType);
            }
            return this;
        }

        public Builder readSessionsFromAllApps() {
            this.zzaqw = true;
            return this;
        }

        public Builder setSessionId(String sessionId) {
            this.zzGY = sessionId;
            return this;
        }

        public Builder setSessionName(String sessionName) {
            this.zzaqv = sessionName;
            return this;
        }

        public Builder setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
            this.zzMS = timeUnit.toMillis(startTime);
            this.zzann = timeUnit.toMillis(endTime);
            return this;
        }
    }

    static {
        CREATOR = new zzv();
    }

    SessionReadRequest(int versionCode, String sessionName, String sessionId, long startTimeMillis, long endTimeMillis, List<DataType> dataTypes, List<DataSource> dataSources, boolean getSessionsFromAllApps, boolean serverQueriesEnabled, List<String> excludedPackages, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzaqv = sessionName;
        this.zzGY = sessionId;
        this.zzMS = startTimeMillis;
        this.zzann = endTimeMillis;
        this.zzanw = Collections.unmodifiableList(dataTypes);
        this.zzapG = Collections.unmodifiableList(dataSources);
        this.zzaqw = getSessionsFromAllApps;
        this.zzapR = serverQueriesEnabled;
        this.zzaqx = excludedPackages;
        this.zzaqy = callback == null ? null : zza.zzbH(callback);
        this.zzOZ = packageName;
    }

    private SessionReadRequest(Builder builder) {
        this(builder.zzaqv, builder.zzGY, builder.zzMS, builder.zzann, builder.zzanw, builder.zzapG, builder.zzaqw, builder.zzapR, builder.zzaqx, null, null);
    }

    public SessionReadRequest(SessionReadRequest request, zznf callback, String packageName) {
        this(request.zzaqv, request.zzGY, request.zzMS, request.zzann, request.zzanw, request.zzapG, request.zzaqw, request.zzapR, request.zzaqx, callback, packageName);
    }

    public SessionReadRequest(String sessionName, String sessionId, long startTimeMillis, long endTimeMillis, List<DataType> dataTypes, List<DataSource> dataSources, boolean getSessionsFromAllApps, boolean serverQueriesEnabled, List<String> excludedPackages, zznf callback, String packageName) {
        this.mVersionCode = 4;
        this.zzaqv = sessionName;
        this.zzGY = sessionId;
        this.zzMS = startTimeMillis;
        this.zzann = endTimeMillis;
        this.zzanw = Collections.unmodifiableList(dataTypes);
        this.zzapG = Collections.unmodifiableList(dataSources);
        this.zzaqw = getSessionsFromAllApps;
        this.zzapR = serverQueriesEnabled;
        this.zzaqx = excludedPackages;
        this.zzaqy = callback;
        this.zzOZ = packageName;
    }

    private boolean zzb(SessionReadRequest sessionReadRequest) {
        return zzw.equal(this.zzaqv, sessionReadRequest.zzaqv) && this.zzGY.equals(sessionReadRequest.zzGY) && this.zzMS == sessionReadRequest.zzMS && this.zzann == sessionReadRequest.zzann && zzw.equal(this.zzanw, sessionReadRequest.zzanw) && zzw.equal(this.zzapG, sessionReadRequest.zzapG) && this.zzaqw == sessionReadRequest.zzaqw && this.zzaqx.equals(sessionReadRequest.zzaqx) && this.zzapR == sessionReadRequest.zzapR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof SessionReadRequest) && zzb((SessionReadRequest) o));
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

    public List<String> getExcludedPackages() {
        return this.zzaqx;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    public String getSessionId() {
        return this.zzGY;
    }

    public String getSessionName() {
        return this.zzaqv;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzMS, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaqv, this.zzGY, Long.valueOf(this.zzMS), Long.valueOf(this.zzann));
    }

    public boolean includeSessionsFromAllApps() {
        return this.zzaqw;
    }

    public String toString() {
        return zzw.zzu(this).zzg("sessionName", this.zzaqv).zzg("sessionId", this.zzGY).zzg("startTimeMillis", Long.valueOf(this.zzMS)).zzg("endTimeMillis", Long.valueOf(this.zzann)).zzg("dataTypes", this.zzanw).zzg("dataSources", this.zzapG).zzg("sessionsFromAllApps", Boolean.valueOf(this.zzaqw)).zzg("excludedPackages", this.zzaqx).zzg("useServer", Boolean.valueOf(this.zzapR)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzv.zza(this, dest, flags);
    }

    public long zzkH() {
        return this.zzMS;
    }

    public long zzrw() {
        return this.zzann;
    }

    public IBinder zzsc() {
        return this.zzaqy == null ? null : this.zzaqy.asBinder();
    }

    public boolean zzsh() {
        return this.zzapR;
    }

    public boolean zzsw() {
        return this.zzaqw;
    }
}
