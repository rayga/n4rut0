package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection {
    private final IProjectionDelegate zzaGi;

    Projection(IProjectionDelegate delegate) {
        this.zzaGi = delegate;
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.zzaGi.fromScreenLocation(zze.zzx(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.zzaGi.getVisibleRegion();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point toScreenLocation(LatLng location) {
        try {
            return (Point) zze.zzp(this.zzaGi.toScreenLocation(location));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
