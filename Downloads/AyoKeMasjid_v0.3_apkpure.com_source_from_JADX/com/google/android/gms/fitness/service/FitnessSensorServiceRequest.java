package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest implements SafeParcelable {
    public static final Creator<FitnessSensorServiceRequest> CREATOR;
    public static final int UNSPECIFIED = -1;
    private final int mVersionCode;
    private final DataSource zzanm;
    private final long zzaqR;
    private final long zzaqS;
    private final zzj zzaqi;

    static {
        CREATOR = new zza();
    }

    FitnessSensorServiceRequest(int versionCode, DataSource dataSource, IBinder listenerBinder, long samplingRateMicros, long batchIntervalMicros) {
        this.mVersionCode = versionCode;
        this.zzanm = dataSource;
        this.zzaqi = zza.zzbl(listenerBinder);
        this.zzaqR = samplingRateMicros;
        this.zzaqS = batchIntervalMicros;
    }

    private boolean zza(FitnessSensorServiceRequest fitnessSensorServiceRequest) {
        return zzw.equal(this.zzanm, fitnessSensorServiceRequest.zzanm) && this.zzaqR == fitnessSensorServiceRequest.zzaqR && this.zzaqS == fitnessSensorServiceRequest.zzaqS;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof FitnessSensorServiceRequest) && zza((FitnessSensorServiceRequest) that));
    }

    public long getBatchInterval(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaqS, TimeUnit.MICROSECONDS);
    }

    public DataSource getDataSource() {
        return this.zzanm;
    }

    public SensorEventDispatcher getDispatcher() {
        return new zzb(this.zzaqi);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return this.zzaqR == -1 ? -1 : timeUnit.convert(this.zzaqR, TimeUnit.MICROSECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanm, Long.valueOf(this.zzaqR), Long.valueOf(this.zzaqS));
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", new Object[]{this.zzanm});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }

    public long zzrP() {
        return this.zzaqR;
    }

    public long zzsJ() {
        return this.zzaqS;
    }

    IBinder zzst() {
        return this.zzaqi.asBinder();
    }
}
