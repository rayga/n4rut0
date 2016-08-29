package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzg {
    private final Context mContext;
    private final FaceSettingsParcel zzaVV;
    private zzc zzaVW;
    private boolean zzaVX;
    private final Object zzpc;

    public zzg(Context context, FaceSettingsParcel faceSettingsParcel) {
        this.zzpc = new Object();
        this.zzaVW = null;
        this.zzaVX = false;
        this.mContext = context;
        this.zzaVV = faceSettingsParcel;
        zzCg();
    }

    private zzc zzCg() {
        zzc com_google_android_gms_vision_face_internal_client_zzc;
        synchronized (this.zzpc) {
            if (this.zzaVW != null) {
                com_google_android_gms_vision_face_internal_client_zzc = this.zzaVW;
            } else {
                this.zzaVW = zzf.zza(this.mContext, this.zzaVV);
                if (!this.zzaVX && this.zzaVW == null) {
                    Log.w("FaceDetectorHandle", "Native face detector not yet available.  Reverting to no-op detection.");
                    this.zzaVX = true;
                } else if (this.zzaVX && this.zzaVW != null) {
                    Log.w("FaceDetectorHandle", "Native face detector is now available.");
                }
                com_google_android_gms_vision_face_internal_client_zzc = this.zzaVW;
            }
        }
        return com_google_android_gms_vision_face_internal_client_zzc;
    }

    private Face zza(FaceParcel faceParcel) {
        return new Face(faceParcel.id, new PointF(faceParcel.centerX, faceParcel.centerY), faceParcel.width, faceParcel.height, faceParcel.zzaVK, faceParcel.zzaVL, zzb(faceParcel), faceParcel.zzaVN, faceParcel.zzaVO, faceParcel.zzaVP);
    }

    private Landmark zza(LandmarkParcel landmarkParcel) {
        return new Landmark(new PointF(landmarkParcel.f10x, landmarkParcel.f11y), landmarkParcel.type);
    }

    private Landmark[] zzb(FaceParcel faceParcel) {
        int i = 0;
        LandmarkParcel[] landmarkParcelArr = faceParcel.zzaVM;
        if (landmarkParcelArr == null) {
            return new Landmark[0];
        }
        Landmark[] landmarkArr = new Landmark[landmarkParcelArr.length];
        while (i < landmarkParcelArr.length) {
            landmarkArr[i] = zza(landmarkParcelArr[i]);
            i++;
        }
        return landmarkArr;
    }

    public boolean isOperational() {
        return zzCg() != null;
    }

    public void zzCf() {
        synchronized (this.zzpc) {
            if (this.zzaVW == null) {
                return;
            }
            try {
                this.zzaVW.zzCf();
            } catch (Throwable e) {
                Log.e("FaceDetectorHandle", "Could not finalize native face detector", e);
            }
        }
    }

    public Face[] zzb(ByteBuffer byteBuffer, FrameMetadataParcel frameMetadataParcel) {
        int i = 0;
        zzc zzCg = zzCg();
        if (zzCg == null) {
            return new Face[0];
        }
        try {
            FaceParcel[] zzc = zzCg.zzc(zze.zzx(byteBuffer), frameMetadataParcel);
            Face[] faceArr = new Face[zzc.length];
            while (i < zzc.length) {
                faceArr[i] = zza(zzc[i]);
                i++;
            }
            return faceArr;
        } catch (Throwable e) {
            Log.e("FaceDetectorHandle", "Could not call native face detector", e);
            return new Face[0];
        }
    }

    public boolean zzjG(int i) {
        boolean z = false;
        zzc zzCg = zzCg();
        if (zzCg != null) {
            try {
                z = zzCg.zzjG(i);
            } catch (Throwable e) {
                Log.e("FaceDetectorHandle", "Could not call native face detector", e);
            }
        }
        return z;
    }
}
