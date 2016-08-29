package com.google.android.gms.vision.barcode.internal.client;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzd {
    private final Context mContext;
    private final BarcodeDetectorOptions zzaVs;
    private zzb zzaVu;
    private final Object zzpc;

    static class zza extends zzg<zzc> {
        private static zza zzaVv;

        zza() {
            super("com.google.android.gms.vision.client.DynamiteNativeBarcodeDetectorCreator");
        }

        static zzb zza(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
            if (zzaVv == null) {
                zzaVv = new zza();
            }
            return zzaVv.zzb(context, barcodeDetectorOptions);
        }

        private zzb zzb(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
            try {
                return ((zzc) zzar(context)).zza(zze.zzx(context), barcodeDetectorOptions);
            } catch (Throwable e) {
                Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", e);
                return null;
            } catch (Throwable e2) {
                Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", e2);
                return null;
            }
        }

        protected /* synthetic */ Object zzd(IBinder iBinder) {
            return zzdL(iBinder);
        }

        protected zzc zzdL(IBinder iBinder) {
            return com.google.android.gms.vision.barcode.internal.client.zzc.zza.zzdK(iBinder);
        }
    }

    public zzd(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
        this.zzpc = new Object();
        this.zzaVu = null;
        this.mContext = context;
        this.zzaVs = barcodeDetectorOptions;
        zzCe();
    }

    private zzb zzCe() {
        zzb com_google_android_gms_vision_barcode_internal_client_zzb;
        synchronized (this.zzpc) {
            if (this.zzaVu == null) {
                this.zzaVu = zza.zza(this.mContext, this.zzaVs);
            }
            com_google_android_gms_vision_barcode_internal_client_zzb = this.zzaVu;
        }
        return com_google_android_gms_vision_barcode_internal_client_zzb;
    }

    public boolean isOperational() {
        return zzCe() != null;
    }

    public Barcode[] zza(Bitmap bitmap, FrameMetadataParcel frameMetadataParcel) {
        zzb zzCe = zzCe();
        if (zzCe == null) {
            return new Barcode[0];
        }
        try {
            return zzCe.zzb(zze.zzx(bitmap), frameMetadataParcel);
        } catch (Throwable e) {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    public Barcode[] zza(ByteBuffer byteBuffer, FrameMetadataParcel frameMetadataParcel) {
        zzb zzCe = zzCe();
        if (zzCe == null) {
            return new Barcode[0];
        }
        try {
            return zzCe.zza(zze.zzx(byteBuffer), frameMetadataParcel);
        } catch (Throwable e) {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }
}
