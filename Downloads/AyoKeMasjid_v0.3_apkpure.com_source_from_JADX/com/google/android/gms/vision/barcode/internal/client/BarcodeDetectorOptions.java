package com.google.android.gms.vision.barcode.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BarcodeDetectorOptions implements SafeParcelable {
    public static final zza CREATOR;
    final int versionCode;
    public int zzaVt;

    static {
        CREATOR = new zza();
    }

    public BarcodeDetectorOptions() {
        this.versionCode = 1;
    }

    public BarcodeDetectorOptions(int versionCode, int barcodeFormats) {
        this.versionCode = versionCode;
        this.zzaVt = barcodeFormats;
    }

    public int describeContents() {
        zza com_google_android_gms_vision_barcode_internal_client_zza = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza com_google_android_gms_vision_barcode_internal_client_zza = CREATOR;
        zza.zza(this, parcel, flags);
    }
}
