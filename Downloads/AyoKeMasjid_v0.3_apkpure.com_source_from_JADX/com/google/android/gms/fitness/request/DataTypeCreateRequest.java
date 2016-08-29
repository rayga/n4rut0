package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmu.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest implements SafeParcelable {
    public static final Creator<DataTypeCreateRequest> CREATOR;
    private final String mName;
    private final int mVersionCode;
    private final String zzOZ;
    private final List<Field> zzanX;
    private final zzmu zzaqb;

    public static class Builder {
        private String mName;
        private List<Field> zzanX;

        public Builder() {
            this.zzanX = new ArrayList();
        }

        public Builder addField(Field field) {
            if (!this.zzanX.contains(field)) {
                this.zzanX.add(field);
            }
            return this;
        }

        public Builder addField(String name, int format) {
            boolean z = (name == null || name.isEmpty()) ? false : true;
            zzx.zzb(z, (Object) "Invalid name specified");
            return addField(Field.zzo(name, format));
        }

        public DataTypeCreateRequest build() {
            boolean z = true;
            zzx.zza(this.mName != null, (Object) "Must set the name");
            if (this.zzanX.isEmpty()) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify the data fields");
            return new DataTypeCreateRequest();
        }

        public Builder setName(String name) {
            this.mName = name;
            return this;
        }
    }

    static {
        CREATOR = new zzi();
    }

    DataTypeCreateRequest(int versionCode, String name, List<Field> fields, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzanX = Collections.unmodifiableList(fields);
        this.zzaqb = callback == null ? null : zza.zzbw(callback);
        this.zzOZ = packageName;
    }

    private DataTypeCreateRequest(Builder builder) {
        this(builder.mName, builder.zzanX, null, null);
    }

    public DataTypeCreateRequest(DataTypeCreateRequest request, zzmu callback, String packageName) {
        this(request.mName, request.zzanX, callback, packageName);
    }

    public DataTypeCreateRequest(String name, List<Field> fields, zzmu callback, String packageName) {
        this.mVersionCode = 2;
        this.mName = name;
        this.zzanX = Collections.unmodifiableList(fields);
        this.zzaqb = callback;
        this.zzOZ = packageName;
    }

    private boolean zzb(DataTypeCreateRequest dataTypeCreateRequest) {
        return zzw.equal(this.mName, dataTypeCreateRequest.mName) && zzw.equal(this.zzanX, dataTypeCreateRequest.zzanX);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataTypeCreateRequest) && zzb((DataTypeCreateRequest) o));
    }

    public List<Field> getFields() {
        return this.zzanX;
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
        return zzw.hashCode(this.mName, this.zzanX);
    }

    public String toString() {
        return zzw.zzu(this).zzg("name", this.mName).zzg("fields", this.zzanX).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    public IBinder zzsc() {
        return this.zzaqb == null ? null : this.zzaqb.asBinder();
    }
}
