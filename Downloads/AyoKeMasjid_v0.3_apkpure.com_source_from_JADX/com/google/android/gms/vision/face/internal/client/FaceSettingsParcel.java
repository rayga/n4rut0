package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FaceSettingsParcel implements SafeParcelable {
    public static final zzb CREATOR;
    public int mode;
    public final int versionCode;
    public int zzaVQ;
    public int zzaVR;
    public boolean zzaVS;
    public boolean zzaVT;

    static {
        CREATOR = new zzb();
    }

    public FaceSettingsParcel() {
        this.versionCode = 1;
    }

    public FaceSettingsParcel(int versionCode, int mode, int landmarkType, int classificationType, boolean prominentFaceOnly, boolean trackingEnabled) {
        this.versionCode = versionCode;
        this.mode = mode;
        this.zzaVQ = landmarkType;
        this.zzaVR = classificationType;
        this.zzaVS = prominentFaceOnly;
        this.zzaVT = trackingEnabled;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
