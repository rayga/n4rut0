package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzr;
import com.google.android.gms.maps.internal.zzs.zza;
import com.google.android.gms.maps.internal.zzt;
import com.google.android.gms.maps.internal.zzu;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama {
    private final IStreetViewPanoramaDelegate zzaGj;

    public interface OnStreetViewPanoramaCameraChangeListener {
        void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    public interface OnStreetViewPanoramaChangeListener {
        void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    public interface OnStreetViewPanoramaClickListener {
        void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public interface OnStreetViewPanoramaLongClickListener {
        void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanorama.1 */
    class C11631 extends zza {
        final /* synthetic */ OnStreetViewPanoramaChangeListener zzaGk;
        final /* synthetic */ StreetViewPanorama zzaGl;

        C11631(StreetViewPanorama streetViewPanorama, OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
            this.zzaGl = streetViewPanorama;
            this.zzaGk = onStreetViewPanoramaChangeListener;
        }

        public void onStreetViewPanoramaChange(StreetViewPanoramaLocation location) {
            this.zzaGk.onStreetViewPanoramaChange(location);
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanorama.2 */
    class C11642 extends zzr.zza {
        final /* synthetic */ StreetViewPanorama zzaGl;
        final /* synthetic */ OnStreetViewPanoramaCameraChangeListener zzaGm;

        C11642(StreetViewPanorama streetViewPanorama, OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
            this.zzaGl = streetViewPanorama;
            this.zzaGm = onStreetViewPanoramaCameraChangeListener;
        }

        public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera camera) {
            this.zzaGm.onStreetViewPanoramaCameraChange(camera);
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanorama.3 */
    class C11653 extends zzt.zza {
        final /* synthetic */ StreetViewPanorama zzaGl;
        final /* synthetic */ OnStreetViewPanoramaClickListener zzaGn;

        C11653(StreetViewPanorama streetViewPanorama, OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
            this.zzaGl = streetViewPanorama;
            this.zzaGn = onStreetViewPanoramaClickListener;
        }

        public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation orientation) {
            this.zzaGn.onStreetViewPanoramaClick(orientation);
        }
    }

    /* renamed from: com.google.android.gms.maps.StreetViewPanorama.4 */
    class C11664 extends zzu.zza {
        final /* synthetic */ StreetViewPanorama zzaGl;
        final /* synthetic */ OnStreetViewPanoramaLongClickListener zzaGo;

        C11664(StreetViewPanorama streetViewPanorama, OnStreetViewPanoramaLongClickListener onStreetViewPanoramaLongClickListener) {
            this.zzaGl = streetViewPanorama;
            this.zzaGo = onStreetViewPanoramaLongClickListener;
        }

        public void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation orientation) {
            this.zzaGo.onStreetViewPanoramaLongClick(orientation);
        }
    }

    protected StreetViewPanorama(IStreetViewPanoramaDelegate sv) {
        this.zzaGj = (IStreetViewPanoramaDelegate) zzx.zzv(sv);
    }

    public void animateTo(StreetViewPanoramaCamera camera, long duration) {
        try {
            this.zzaGj.animateTo(camera, duration);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaLocation getLocation() {
        try {
            return this.zzaGj.getStreetViewPanoramaLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaCamera getPanoramaCamera() {
        try {
            return this.zzaGj.getPanoramaCamera();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isPanningGesturesEnabled() {
        try {
            return this.zzaGj.isPanningGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isStreetNamesEnabled() {
        try {
            return this.zzaGj.isStreetNamesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUserNavigationEnabled() {
        try {
            return this.zzaGj.isUserNavigationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.zzaGj.isZoomGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation orientation) {
        try {
            zzd orientationToPoint = this.zzaGj.orientationToPoint(orientation);
            return orientationToPoint == null ? null : (Point) zze.zzp(orientationToPoint);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point) {
        try {
            return this.zzaGj.pointToOrientation(zze.zzx(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(OnStreetViewPanoramaCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaGj.setOnStreetViewPanoramaCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaGj.setOnStreetViewPanoramaCameraChangeListener(new C11642(this, listener));
    }

    public final void setOnStreetViewPanoramaChangeListener(OnStreetViewPanoramaChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaGj.setOnStreetViewPanoramaChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaGj.setOnStreetViewPanoramaChangeListener(new C11631(this, listener));
    }

    public final void setOnStreetViewPanoramaClickListener(OnStreetViewPanoramaClickListener listener) {
        if (listener == null) {
            try {
                this.zzaGj.setOnStreetViewPanoramaClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaGj.setOnStreetViewPanoramaClickListener(new C11653(this, listener));
    }

    public final void setOnStreetViewPanoramaLongClickListener(OnStreetViewPanoramaLongClickListener listener) {
        if (listener == null) {
            try {
                this.zzaGj.setOnStreetViewPanoramaLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaGj.setOnStreetViewPanoramaLongClickListener(new C11664(this, listener));
    }

    public void setPanningGesturesEnabled(boolean enablePanning) {
        try {
            this.zzaGj.enablePanning(enablePanning);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng position) {
        try {
            this.zzaGj.setPosition(position);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng position, int radius) {
        try {
            this.zzaGj.setPositionWithRadius(position, radius);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(String panoId) {
        try {
            this.zzaGj.setPositionWithID(panoId);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStreetNamesEnabled(boolean enableStreetNames) {
        try {
            this.zzaGj.enableStreetNames(enableStreetNames);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setUserNavigationEnabled(boolean enableUserNavigation) {
        try {
            this.zzaGj.enableUserNavigation(enableUserNavigation);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomGesturesEnabled(boolean enableZoom) {
        try {
            this.zzaGj.enableZoom(enableZoom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IStreetViewPanoramaDelegate zzwR() {
        return this.zzaGj;
    }
}
