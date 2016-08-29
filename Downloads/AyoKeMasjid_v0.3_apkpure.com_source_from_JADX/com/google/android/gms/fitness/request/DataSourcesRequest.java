package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzmt.zza;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
    public static final Creator<DataSourcesRequest> CREATOR;
    private final int mVersionCode;
    private final String zzOZ;
    private final List<DataType> zzanw;
    private final List<Integer> zzapW;
    private final boolean zzapX;
    private final zzmt zzapY;

    public static class Builder {
        private boolean zzapX;
        private DataType[] zzapZ;
        private int[] zzaqa;

        public Builder() {
            this.zzapZ = new DataType[0];
            this.zzaqa = new int[]{0, 1};
            this.zzapX = false;
        }

        public DataSourcesRequest build() {
            boolean z = true;
            zzx.zza(this.zzapZ.length > 0, (Object) "Must add at least one data type");
            if (this.zzaqa.length <= 0) {
                z = false;
            }
            zzx.zza(z, (Object) "Must add at least one data source type");
            return new DataSourcesRequest();
        }

        public Builder setDataSourceTypes(int... dataSourceTypes) {
            this.zzaqa = dataSourceTypes;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypes) {
            this.zzapZ = dataTypes;
            return this;
        }
    }

    static {
        CREATOR = new zzh();
    }

    DataSourcesRequest(int versionCode, List<DataType> dataTypes, List<Integer> dataSourceTypes, boolean includeDbOnlySources, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzanw = dataTypes;
        this.zzapW = dataSourceTypes;
        this.zzapX = includeDbOnlySources;
        this.zzapY = callback == null ? null : zza.zzbv(callback);
        this.zzOZ = packageName;
    }

    private DataSourcesRequest(Builder builder) {
        this(zzli.zzb(builder.zzapZ), Arrays.asList(zzli.zza(builder.zzaqa)), builder.zzapX, null, null);
    }

    public DataSourcesRequest(DataSourcesRequest request, zzmt callback, String packageName) {
        this(request.zzanw, request.zzapW, request.zzapX, callback, packageName);
    }

    public DataSourcesRequest(List<DataType> dataTypes, List<Integer> dataSourceTypes, boolean includeDbOnlySources, zzmt callback, String packageName) {
        this.mVersionCode = 3;
        this.zzanw = dataTypes;
        this.zzapW = dataSourceTypes;
        this.zzapX = includeDbOnlySources;
        this.zzapY = callback;
        this.zzOZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzanw);
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzw.zza zzg = zzw.zzu(this).zzg("dataTypes", this.zzanw).zzg("sourceTypes", this.zzapW);
        if (this.zzapX) {
            zzg.zzg("includeDbOnlySources", "true");
        }
        return zzg.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzh.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        return this.zzapY == null ? null : this.zzapY.asBinder();
    }

    public List<Integer> zzsl() {
        return this.zzapW;
    }

    public boolean zzsm() {
        return this.zzapX;
    }
}
