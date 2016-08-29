package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zza;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static zza zzaGO;

    private BitmapDescriptorFactory() {
    }

    public static BitmapDescriptor defaultMarker() {
        try {
            return new BitmapDescriptor(zzxb().zzxg());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor defaultMarker(float hue) {
        try {
            return new BitmapDescriptor(zzxb().zzh(hue));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromAsset(String assetName) {
        try {
            return new BitmapDescriptor(zzxb().zzdF(assetName));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap image) {
        try {
            return new BitmapDescriptor(zzxb().zzb(image));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromFile(String fileName) {
        try {
            return new BitmapDescriptor(zzxb().zzdG(fileName));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromPath(String absolutePath) {
        try {
            return new BitmapDescriptor(zzxb().zzdH(absolutePath));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromResource(int resourceId) {
        try {
            return new BitmapDescriptor(zzxb().zzhM(resourceId));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static void zza(zza com_google_android_gms_maps_model_internal_zza) {
        if (zzaGO == null) {
            zzaGO = (zza) zzx.zzv(com_google_android_gms_maps_model_internal_zza);
        }
    }

    private static zza zzxb() {
        return (zza) zzx.zzb(zzaGO, (Object) "IBitmapDescriptorFactory is not initialized");
    }
}
