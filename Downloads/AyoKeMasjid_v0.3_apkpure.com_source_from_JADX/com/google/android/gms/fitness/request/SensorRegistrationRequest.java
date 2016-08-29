package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SensorRegistrationRequest implements SafeParcelable {
    public static final Creator<SensorRegistrationRequest> CREATOR;
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final String zzOZ;
    private final DataType zzanl;
    private final DataSource zzanm;
    private final long zzaoE;
    private final int zzaoF;
    private final zznh zzapE;
    private zzj zzaqi;
    int zzaqj;
    int zzaqk;
    private final long zzaql;
    private final long zzaqm;
    private final List<LocationRequest> zzaqn;
    private final long zzaqo;
    private final List<Object> zzaqp;

    static {
        CREATOR = new zzs();
    }

    SensorRegistrationRequest(int versionCode, DataSource dataSource, DataType dataType, IBinder listenerBinder, int samplingIntervalMicrosInt, int maxDeliveryLatencyMicrosInt, long samplingIntervalMicros, long maxDeliveryLatencyMicros, PendingIntent intent, long fastestIntervalMicros, int accuracyMode, List<LocationRequest> locationRequests, long registrationTimeOutMicros, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzanm = dataSource;
        this.zzanl = dataType;
        this.zzaqi = listenerBinder == null ? null : zza.zzbl(listenerBinder);
        if (samplingIntervalMicros == 0) {
            samplingIntervalMicros = (long) samplingIntervalMicrosInt;
        }
        this.zzaoE = samplingIntervalMicros;
        this.zzaqm = fastestIntervalMicros;
        if (maxDeliveryLatencyMicros == 0) {
            maxDeliveryLatencyMicros = (long) maxDeliveryLatencyMicrosInt;
        }
        this.zzaql = maxDeliveryLatencyMicros;
        this.zzaqn = locationRequests;
        this.mPendingIntent = intent;
        this.zzaoF = accuracyMode;
        this.zzaqp = Collections.emptyList();
        this.zzaqo = registrationTimeOutMicros;
        this.zzapE = callback == null ? null : zznh.zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public SensorRegistrationRequest(DataSource dataSource, DataType dataType, zzj listener, PendingIntent pendingIntent, long samplingIntervalMicros, long fastestIntervalMicros, long maxDeliveryLatencyMicros, int accuracyMode, List<LocationRequest> locationRequests, List<Object> clientIdentities, long registrationTimeOutMicros, zznh callback, String packageName) {
        this.mVersionCode = 5;
        this.zzanm = dataSource;
        this.zzanl = dataType;
        this.zzaqi = listener;
        this.mPendingIntent = pendingIntent;
        this.zzaoE = samplingIntervalMicros;
        this.zzaqm = fastestIntervalMicros;
        this.zzaql = maxDeliveryLatencyMicros;
        this.zzaoF = accuracyMode;
        this.zzaqn = locationRequests;
        this.zzaqp = clientIdentities;
        this.zzaqo = registrationTimeOutMicros;
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    public SensorRegistrationRequest(SensorRequest request, zzj listener, PendingIntent intent, zznh callback, String packageName) {
        zzj com_google_android_gms_fitness_data_zzj = listener;
        PendingIntent pendingIntent = intent;
        this(request.getDataSource(), request.getDataType(), com_google_android_gms_fitness_data_zzj, pendingIntent, request.getSamplingRate(TimeUnit.MICROSECONDS), request.getFastestRate(TimeUnit.MICROSECONDS), request.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), request.getAccuracyMode(), null, Collections.emptyList(), request.zzsu(), callback, packageName);
    }

    private boolean zzb(SensorRegistrationRequest sensorRegistrationRequest) {
        return zzw.equal(this.zzanm, sensorRegistrationRequest.zzanm) && zzw.equal(this.zzanl, sensorRegistrationRequest.zzanl) && this.zzaoE == sensorRegistrationRequest.zzaoE && this.zzaqm == sensorRegistrationRequest.zzaqm && this.zzaql == sensorRegistrationRequest.zzaql && this.zzaoF == sensorRegistrationRequest.zzaoF && zzw.equal(this.zzaqn, sensorRegistrationRequest.zzaqn);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SensorRegistrationRequest) && zzb((SensorRegistrationRequest) that));
    }

    public int getAccuracyMode() {
        return this.zzaoF;
    }

    public DataSource getDataSource() {
        return this.zzanm;
    }

    public DataType getDataType() {
        return this.zzanl;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanm, this.zzanl, this.zzaqi, Long.valueOf(this.zzaoE), Long.valueOf(this.zzaqm), Long.valueOf(this.zzaql), Integer.valueOf(this.zzaoF), this.zzaqn);
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.zzanl, this.zzanm, Long.valueOf(this.zzaoE), Long.valueOf(this.zzaqm), Long.valueOf(this.zzaql)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzs.zza(this, parcel, flags);
    }

    public long zzrP() {
        return this.zzaoE;
    }

    public IBinder zzsc() {
        return this.zzapE == null ? null : this.zzapE.asBinder();
    }

    public PendingIntent zzso() {
        return this.mPendingIntent;
    }

    public long zzsp() {
        return this.zzaqm;
    }

    public long zzsq() {
        return this.zzaql;
    }

    public List<LocationRequest> zzsr() {
        return this.zzaqn;
    }

    public long zzss() {
        return this.zzaqo;
    }

    IBinder zzst() {
        return this.zzaqi == null ? null : this.zzaqi.asBinder();
    }
}
