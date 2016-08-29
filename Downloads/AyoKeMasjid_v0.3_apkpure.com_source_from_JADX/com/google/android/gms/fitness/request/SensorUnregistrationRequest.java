package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import com.google.android.gms.internal.zznh;

public class SensorUnregistrationRequest implements SafeParcelable {
    public static final Creator<SensorUnregistrationRequest> CREATOR;
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;
    private final zzj zzaqi;

    static {
        CREATOR = new zzt();
    }

    SensorUnregistrationRequest(int versionCode, IBinder listenerBinder, PendingIntent pendingIntent, IBinder callback, String packageName) {
        this.mVersionCode = versionCode;
        this.zzaqi = listenerBinder == null ? null : zza.zzbl(listenerBinder);
        this.mPendingIntent = pendingIntent;
        this.zzapE = zznh.zza.zzbJ(callback);
        this.zzOZ = packageName;
    }

    public SensorUnregistrationRequest(zzj listener, PendingIntent pendingIntent, zznh callback, String packageName) {
        this.mVersionCode = 3;
        this.zzaqi = listener;
        this.mPendingIntent = pendingIntent;
        this.zzapE = callback;
        this.zzOZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.zzOZ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.zzaqi});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzt.zza(this, parcel, flags);
    }

    public IBinder zzsc() {
        return this.zzapE == null ? null : this.zzapE.asBinder();
    }

    public PendingIntent zzso() {
        return this.mPendingIntent;
    }

    IBinder zzst() {
        return this.zzaqi == null ? null : this.zzaqi.asBinder();
    }
}
