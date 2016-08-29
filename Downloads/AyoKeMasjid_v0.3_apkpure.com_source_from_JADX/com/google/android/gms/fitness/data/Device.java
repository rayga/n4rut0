package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmi;
import com.google.android.gms.internal.zznl;
import org.bpmikc.akm.BuildConfig;

public final class Device implements SafeParcelable {
    public static final Creator<Device> CREATOR;
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int mVersionCode;
    private final int zzUS;
    private final String zzWs;
    private final String zzanY;
    private final String zzanZ;
    private final String zzaoa;
    private final int zzaob;

    static {
        CREATOR = new zzh();
    }

    Device(int versionCode, String manufacturer, String model, String version, String uid, int type, int platformType) {
        this.mVersionCode = versionCode;
        this.zzanY = (String) zzx.zzv(manufacturer);
        this.zzanZ = (String) zzx.zzv(model);
        this.zzWs = BuildConfig.FLAVOR;
        this.zzaoa = (String) zzx.zzv(uid);
        this.zzUS = type;
        this.zzaob = platformType;
    }

    public Device(String manufacturer, String model, String uid, int type) {
        this(manufacturer, model, BuildConfig.FLAVOR, uid, type, TYPE_UNKNOWN);
    }

    public Device(String manufacturer, String model, String version, String uid, int type, int platformType) {
        this(TYPE_PHONE, manufacturer, model, BuildConfig.FLAVOR, uid, type, platformType);
    }

    public static Device getLocalDevice(Context context) {
        int zzaw = zzmi.zzaw(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, zzas(context), zzaw, TYPE_TABLET);
    }

    private boolean zza(Device device) {
        return zzw.equal(this.zzanY, device.zzanY) && zzw.equal(this.zzanZ, device.zzanZ) && zzw.equal(this.zzWs, device.zzWs) && zzw.equal(this.zzaoa, device.zzaoa) && this.zzUS == device.zzUS && this.zzaob == device.zzaob;
    }

    private static String zzas(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    private boolean zzrJ() {
        return zzrI() == TYPE_PHONE;
    }

    public int describeContents() {
        return TYPE_UNKNOWN;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Device) && zza((Device) that));
    }

    public String getManufacturer() {
        return this.zzanY;
    }

    public String getModel() {
        return this.zzanZ;
    }

    String getStreamIdentifier() {
        Object[] objArr = new Object[TYPE_WATCH];
        objArr[TYPE_UNKNOWN] = this.zzanY;
        objArr[TYPE_PHONE] = this.zzanZ;
        objArr[TYPE_TABLET] = this.zzaoa;
        return String.format("%s:%s:%s", objArr);
    }

    public int getType() {
        return this.zzUS;
    }

    public String getUid() {
        return this.zzaoa;
    }

    public String getVersion() {
        return this.zzWs;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        Object[] objArr = new Object[TYPE_SCALE];
        objArr[TYPE_UNKNOWN] = this.zzanY;
        objArr[TYPE_PHONE] = this.zzanZ;
        objArr[TYPE_TABLET] = this.zzWs;
        objArr[TYPE_WATCH] = this.zzaoa;
        objArr[TYPE_CHEST_STRAP] = Integer.valueOf(this.zzUS);
        return zzw.hashCode(objArr);
    }

    public String toString() {
        Object[] objArr = new Object[TYPE_CHEST_STRAP];
        objArr[TYPE_UNKNOWN] = getStreamIdentifier();
        objArr[TYPE_PHONE] = this.zzWs;
        objArr[TYPE_TABLET] = Integer.valueOf(this.zzUS);
        objArr[TYPE_WATCH] = Integer.valueOf(this.zzaob);
        return String.format("Device{%s:%s:%s:%s}", objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzh.zza(this, parcel, flags);
    }

    public int zzrI() {
        return this.zzaob;
    }

    public String zzrK() {
        return zzrJ() ? this.zzaoa : zznl.zzcV(this.zzaoa);
    }
}
