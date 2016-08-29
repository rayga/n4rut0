package com.google.android.gms.vision.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.vision.Frame;

public class FrameMetadataParcel implements SafeParcelable {
    public static final zza CREATOR;
    public int height;
    public int id;
    public int rotation;
    final int versionCode;
    public int width;
    public long zzaVY;

    static {
        CREATOR = new zza();
    }

    public FrameMetadataParcel() {
        this.versionCode = 1;
    }

    public FrameMetadataParcel(int versionCode, int width, int height, int id, long timestampMillis, int rotation) {
        this.versionCode = versionCode;
        this.width = width;
        this.height = height;
        this.id = id;
        this.zzaVY = timestampMillis;
        this.rotation = rotation;
    }

    public static FrameMetadataParcel zzc(Frame frame) {
        FrameMetadataParcel frameMetadataParcel = new FrameMetadataParcel();
        frameMetadataParcel.width = frame.getMetadata().getWidth();
        frameMetadataParcel.height = frame.getMetadata().getHeight();
        frameMetadataParcel.rotation = frame.getMetadata().getRotation();
        frameMetadataParcel.id = frame.getMetadata().getId();
        frameMetadataParcel.zzaVY = frame.getMetadata().getTimestampMillis();
        return frameMetadataParcel;
    }

    public int describeContents() {
        zza com_google_android_gms_vision_internal_client_zza = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza com_google_android_gms_vision_internal_client_zza = CREATOR;
        zza.zza(this, parcel, flags);
    }
}
