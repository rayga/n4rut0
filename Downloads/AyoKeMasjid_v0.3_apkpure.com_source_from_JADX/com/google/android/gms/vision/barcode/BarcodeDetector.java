package com.google.android.gms.vision.barcode;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.internal.client.BarcodeDetectorOptions;
import com.google.android.gms.vision.barcode.internal.client.zzd;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

public final class BarcodeDetector extends Detector<Barcode> {
    private final zzd zzaVr;

    public static class Builder {
        private Context mContext;
        private BarcodeDetectorOptions zzaVs;

        public Builder(Context context) {
            this.mContext = context;
            this.zzaVs = new BarcodeDetectorOptions();
        }

        public BarcodeDetector build() {
            return new BarcodeDetector(null);
        }

        public Builder setBarcodeFormats(int format) {
            this.zzaVs.zzaVt = format;
            return this;
        }
    }

    private BarcodeDetector() {
        throw new IllegalStateException("Default constructor called");
    }

    private BarcodeDetector(zzd nativeDetector) {
        this.zzaVr = nativeDetector;
    }

    public SparseArray<Barcode> detect(Frame frame) {
        if (frame == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        Barcode[] zza;
        frame.getMetadata();
        FrameMetadataParcel zzc = FrameMetadataParcel.zzc(frame);
        if (frame.getBitmap() != null) {
            zza = this.zzaVr.zza(frame.getBitmap(), zzc);
        } else {
            zza = this.zzaVr.zza(frame.getGrayscaleImageData(), zzc);
        }
        SparseArray<Barcode> sparseArray = new SparseArray(zza.length);
        for (Barcode barcode : zza) {
            sparseArray.append(barcode.rawValue.hashCode(), barcode);
        }
        return sparseArray;
    }

    public boolean isOperational() {
        return this.zzaVr.isOperational();
    }
}
