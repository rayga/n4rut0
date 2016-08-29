package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LogEvent implements SafeParcelable {
    public static final zzc CREATOR;
    public final String tag;
    public final int versionCode;
    public final long zzaKG;
    public final long zzaKH;
    public final byte[] zzaKI;
    public final Bundle zzaKJ;

    static {
        CREATOR = new zzc();
    }

    LogEvent(int versionCode, long eventTime, long eventUptime, String tag, byte[] sourceExtensionBytes, Bundle keyValuePairs) {
        this.versionCode = versionCode;
        this.zzaKG = eventTime;
        this.zzaKH = eventUptime;
        this.tag = tag;
        this.zzaKI = sourceExtensionBytes;
        this.zzaKJ = keyValuePairs;
    }

    public LogEvent(long eventTime, long eventUptime, String tag, byte[] sourceExtensionBytes, String... extras) {
        this.versionCode = 1;
        this.zzaKG = eventTime;
        this.zzaKH = eventUptime;
        this.tag = tag;
        this.zzaKI = sourceExtensionBytes;
        this.zzaKJ = zzd(extras);
    }

    private static Bundle zzd(String... strArr) {
        Bundle bundle = null;
        if (strArr != null) {
            if (strArr.length % 2 != 0) {
                throw new IllegalArgumentException("extras must have an even number of elements");
            }
            int length = strArr.length / 2;
            if (length != 0) {
                bundle = new Bundle(length);
                for (int i = 0; i < length; i++) {
                    bundle.putString(strArr[i * 2], strArr[(i * 2) + 1]);
                }
            }
        }
        return bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=").append(this.tag).append(",");
        stringBuilder.append("eventTime=").append(this.zzaKG).append(",");
        stringBuilder.append("eventUptime=").append(this.zzaKH).append(",");
        if (!(this.zzaKJ == null || this.zzaKJ.isEmpty())) {
            stringBuilder.append("keyValues=");
            for (String str : this.zzaKJ.keySet()) {
                stringBuilder.append("(").append(str).append(",");
                stringBuilder.append(this.zzaKJ.getString(str)).append(")");
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
