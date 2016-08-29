package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class Subscription implements SafeParcelable {
    public static final Creator<Subscription> CREATOR;
    private final int mVersionCode;
    private final DataType zzanl;
    private final DataSource zzanm;
    private final long zzaoE;
    private final int zzaoF;

    public static class zza {
        private DataType zzanl;
        private DataSource zzanm;
        private long zzaoE;
        private int zzaoF;

        public zza() {
            this.zzaoE = -1;
            this.zzaoF = 2;
        }

        public zza zzb(DataSource dataSource) {
            this.zzanm = dataSource;
            return this;
        }

        public zza zzb(DataType dataType) {
            this.zzanl = dataType;
            return this;
        }

        public Subscription zzrR() {
            boolean z = false;
            boolean z2 = (this.zzanm == null && this.zzanl == null) ? false : true;
            zzx.zza(z2, (Object) "Must call setDataSource() or setDataType()");
            if (this.zzanl == null || this.zzanm == null || this.zzanl.equals(this.zzanm.getDataType())) {
                z = true;
            }
            zzx.zza(z, (Object) "Specified data type is incompatible with specified data source");
            return new Subscription();
        }
    }

    static {
        CREATOR = new zzr();
    }

    Subscription(int versionCode, DataSource dataSource, DataType dataType, long samplingIntervalMicros, int accuracyMode) {
        this.mVersionCode = versionCode;
        this.zzanm = dataSource;
        this.zzanl = dataType;
        this.zzaoE = samplingIntervalMicros;
        this.zzaoF = accuracyMode;
    }

    private Subscription(zza builder) {
        this.mVersionCode = 1;
        this.zzanl = builder.zzanl;
        this.zzanm = builder.zzanm;
        this.zzaoE = builder.zzaoE;
        this.zzaoF = builder.zzaoF;
    }

    private boolean zza(Subscription subscription) {
        return zzw.equal(this.zzanm, subscription.zzanm) && zzw.equal(this.zzanl, subscription.zzanl) && this.zzaoE == subscription.zzaoE && this.zzaoF == subscription.zzaoF;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Subscription) && zza((Subscription) that));
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

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanm, this.zzanm, Long.valueOf(this.zzaoE), Integer.valueOf(this.zzaoF));
    }

    public String toDebugString() {
        String str = "Subscription{%s}";
        Object[] objArr = new Object[1];
        objArr[0] = this.zzanm == null ? this.zzanl.getName() : this.zzanm.toDebugString();
        return String.format(str, objArr);
    }

    public String toString() {
        return zzw.zzu(this).zzg("dataSource", this.zzanm).zzg("dataType", this.zzanl).zzg("samplingIntervalMicros", Long.valueOf(this.zzaoE)).zzg("accuracyMode", Integer.valueOf(this.zzaoF)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzr.zza(this, dest, flags);
    }

    public long zzrP() {
        return this.zzaoE;
    }

    public DataType zzrQ() {
        return this.zzanl == null ? this.zzanm.getDataType() : this.zzanl;
    }
}
