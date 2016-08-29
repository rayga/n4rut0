package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import org.bpmikc.akm.BuildConfig;

public class DataSource implements SafeParcelable {
    public static final Creator<DataSource> CREATOR;
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private final String mName;
    private final int mVersionCode;
    private final int zzUS;
    private final Device zzanJ;
    private final Application zzanK;
    private final String zzanL;
    private final String zzanM;
    private final DataType zzanl;

    public static final class Builder {
        private String mName;
        private int zzUS;
        private Device zzanJ;
        private Application zzanK;
        private String zzanL;
        private DataType zzanl;

        public Builder() {
            this.zzUS = -1;
            this.zzanL = BuildConfig.FLAVOR;
        }

        public DataSource build() {
            boolean z = true;
            zzx.zza(this.zzanl != null, (Object) "Must set data type");
            if (this.zzUS < 0) {
                z = false;
            }
            zzx.zza(z, (Object) "Must set data source type");
            return new DataSource();
        }

        public Builder setAppPackageName(Context appContext) {
            return setAppPackageName(appContext.getPackageName());
        }

        public Builder setAppPackageName(String packageName) {
            this.zzanK = Application.zzcQ(packageName);
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzanl = dataType;
            return this;
        }

        public Builder setDevice(Device device) {
            this.zzanJ = device;
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }

        public Builder setStreamName(String streamName) {
            zzx.zzb(streamName != null, (Object) "Must specify a valid stream name");
            this.zzanL = streamName;
            return this;
        }

        public Builder setType(int type) {
            this.zzUS = type;
            return this;
        }
    }

    static {
        CREATOR = new zzf();
    }

    DataSource(int versionCode, DataType dataType, String name, int type, Device device, Application application, String streamName) {
        this.mVersionCode = versionCode;
        this.zzanl = dataType;
        this.zzUS = type;
        this.mName = name;
        this.zzanJ = device;
        this.zzanK = application;
        this.zzanL = streamName;
        this.zzanM = zzrG();
    }

    private DataSource(Builder builder) {
        this.mVersionCode = 3;
        this.zzanl = builder.zzanl;
        this.zzUS = builder.zzUS;
        this.mName = builder.mName;
        this.zzanJ = builder.zzanJ;
        this.zzanK = builder.zzanK;
        this.zzanL = builder.zzanL;
        this.zzanM = zzrG();
    }

    public static DataSource extract(Intent intent) {
        return intent == null ? null : (DataSource) zzc.zza(intent, EXTRA_DATA_SOURCE, CREATOR);
    }

    private String getTypeString() {
        switch (this.zzUS) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return "raw";
            case TYPE_DERIVED /*1*/:
                return "derived";
            default:
                throw new IllegalArgumentException("invalid type value");
        }
    }

    private boolean zza(DataSource dataSource) {
        return this.zzanM.equals(dataSource.zzanM);
    }

    private String zzrG() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTypeString());
        stringBuilder.append(":").append(this.zzanl.getName());
        if (this.zzanK != null) {
            stringBuilder.append(":").append(this.zzanK.getPackageName());
        }
        if (this.zzanJ != null) {
            stringBuilder.append(":").append(this.zzanJ.getStreamIdentifier());
        }
        if (this.zzanL != null) {
            stringBuilder.append(":").append(this.zzanL);
        }
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSource) && zza((DataSource) that));
    }

    public String getAppPackageName() {
        return this.zzanK == null ? null : this.zzanK.getPackageName();
    }

    public DataType getDataType() {
        return this.zzanl;
    }

    public Device getDevice() {
        return this.zzanJ;
    }

    public String getName() {
        return this.mName;
    }

    public String getStreamIdentifier() {
        return this.zzanM;
    }

    public String getStreamName() {
        return this.zzanL;
    }

    public int getType() {
        return this.zzUS;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.zzanM.hashCode();
    }

    public String toDebugString() {
        StringBuilder append = new StringBuilder().append(this.zzUS == 0 ? "r" : "d").append(":").append(this.zzanl.zzrH());
        String str = this.zzanK == null ? BuildConfig.FLAVOR : this.zzanK.equals(Application.zzans) ? ":gms" : ":" + this.zzanK.getPackageName();
        return append.append(str).append(this.zzanJ != null ? ":" + this.zzanJ.getModel() + ":" + this.zzanJ.getUid() : BuildConfig.FLAVOR).append(this.zzanL != null ? ":" + this.zzanL : BuildConfig.FLAVOR).toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("DataSource{");
        stringBuilder.append(getTypeString());
        if (this.mName != null) {
            stringBuilder.append(":").append(this.mName);
        }
        if (this.zzanK != null) {
            stringBuilder.append(":").append(this.zzanK);
        }
        if (this.zzanJ != null) {
            stringBuilder.append(":").append(this.zzanJ);
        }
        if (this.zzanL != null) {
            stringBuilder.append(":").append(this.zzanL);
        }
        stringBuilder.append(":").append(this.zzanl);
        return stringBuilder.append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzf.zza(this, parcel, flags);
    }

    public Application zzrF() {
        return this.zzanK;
    }
}
