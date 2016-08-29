package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FaceParcel implements SafeParcelable {
    public static final zza CREATOR;
    public final float centerX;
    public final float centerY;
    public final float height;
    public final int id;
    public final int versionCode;
    public final float width;
    public final float zzaVK;
    public final float zzaVL;
    public final LandmarkParcel[] zzaVM;
    public final float zzaVN;
    public final float zzaVO;
    public final float zzaVP;

    static {
        CREATOR = new zza();
    }

    public FaceParcel(int versionCode, int id, float centerX, float centerY, float width, float height, float eulerY, float eulerZ, LandmarkParcel[] landmarkParcels, float isLeftEyeOpenScore, float isRightEyeOpenScore, float isSmilingScore) {
        this.versionCode = versionCode;
        this.id = id;
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
        this.zzaVK = eulerY;
        this.zzaVL = eulerZ;
        this.zzaVM = landmarkParcels;
        this.zzaVN = isLeftEyeOpenScore;
        this.zzaVO = isRightEyeOpenScore;
        this.zzaVP = isSmilingScore;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }
}
