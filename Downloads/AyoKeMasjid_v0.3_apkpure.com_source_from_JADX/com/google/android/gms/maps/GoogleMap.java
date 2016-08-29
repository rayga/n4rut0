package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzh;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.zzc;
import com.google.android.gms.maps.model.internal.zzf;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate zzaFp;
    private UiSettings zzaFq;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.10 */
    class AnonymousClass10 extends com.google.android.gms.maps.internal.zzm.zza {
        final /* synthetic */ OnMarkerClickListener zzaFD;
        final /* synthetic */ GoogleMap zzaFs;

        AnonymousClass10(GoogleMap googleMap, OnMarkerClickListener onMarkerClickListener) {
            this.zzaFs = googleMap;
            this.zzaFD = onMarkerClickListener;
        }

        public boolean zza(zzf com_google_android_gms_maps_model_internal_zzf) {
            return this.zzaFD.onMarkerClick(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.11 */
    class AnonymousClass11 extends com.google.android.gms.maps.internal.zzn.zza {
        final /* synthetic */ OnMarkerDragListener zzaFE;
        final /* synthetic */ GoogleMap zzaFs;

        AnonymousClass11(GoogleMap googleMap, OnMarkerDragListener onMarkerDragListener) {
            this.zzaFs = googleMap;
            this.zzaFE = onMarkerDragListener;
        }

        public void zzb(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.zzaFE.onMarkerDragStart(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }

        public void zzc(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.zzaFE.onMarkerDragEnd(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }

        public void zzd(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.zzaFE.onMarkerDrag(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.12 */
    class AnonymousClass12 extends com.google.android.gms.maps.internal.zzg.zza {
        final /* synthetic */ OnInfoWindowClickListener zzaFF;
        final /* synthetic */ GoogleMap zzaFs;

        AnonymousClass12(GoogleMap googleMap, OnInfoWindowClickListener onInfoWindowClickListener) {
            this.zzaFs = googleMap;
            this.zzaFF = onInfoWindowClickListener;
        }

        public void zze(zzf com_google_android_gms_maps_model_internal_zzf) {
            this.zzaFF.onInfoWindowClick(new Marker(com_google_android_gms_maps_model_internal_zzf));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.13 */
    class AnonymousClass13 extends com.google.android.gms.maps.internal.zzd.zza {
        final /* synthetic */ InfoWindowAdapter zzaFG;
        final /* synthetic */ GoogleMap zzaFs;

        AnonymousClass13(GoogleMap googleMap, InfoWindowAdapter infoWindowAdapter) {
            this.zzaFs = googleMap;
            this.zzaFG = infoWindowAdapter;
        }

        public zzd zzf(zzf com_google_android_gms_maps_model_internal_zzf) {
            return zze.zzx(this.zzaFG.getInfoWindow(new Marker(com_google_android_gms_maps_model_internal_zzf)));
        }

        public zzd zzg(zzf com_google_android_gms_maps_model_internal_zzf) {
            return zze.zzx(this.zzaFG.getInfoContents(new Marker(com_google_android_gms_maps_model_internal_zzf)));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.1 */
    class C11521 extends com.google.android.gms.maps.internal.zzf.zza {
        final /* synthetic */ OnIndoorStateChangeListener zzaFr;
        final /* synthetic */ GoogleMap zzaFs;

        C11521(GoogleMap googleMap, OnIndoorStateChangeListener onIndoorStateChangeListener) {
            this.zzaFs = googleMap;
            this.zzaFr = onIndoorStateChangeListener;
        }

        public void onIndoorBuildingFocused() {
            this.zzaFr.onIndoorBuildingFocused();
        }

        public void zza(com.google.android.gms.maps.model.internal.zzd com_google_android_gms_maps_model_internal_zzd) {
            this.zzaFr.onIndoorLevelActivated(new IndoorBuilding(com_google_android_gms_maps_model_internal_zzd));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.2 */
    class C11532 extends com.google.android.gms.maps.internal.zzp.zza {
        final /* synthetic */ GoogleMap zzaFs;
        final /* synthetic */ OnMyLocationChangeListener zzaFt;

        C11532(GoogleMap googleMap, OnMyLocationChangeListener onMyLocationChangeListener) {
            this.zzaFs = googleMap;
            this.zzaFt = onMyLocationChangeListener;
        }

        public void zzq(zzd com_google_android_gms_dynamic_zzd) {
            this.zzaFt.onMyLocationChange((Location) zze.zzp(com_google_android_gms_dynamic_zzd));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.3 */
    class C11543 extends com.google.android.gms.maps.internal.zzo.zza {
        final /* synthetic */ GoogleMap zzaFs;
        final /* synthetic */ OnMyLocationButtonClickListener zzaFu;

        C11543(GoogleMap googleMap, OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
            this.zzaFs = googleMap;
            this.zzaFu = onMyLocationButtonClickListener;
        }

        public boolean onMyLocationButtonClick() throws RemoteException {
            return this.zzaFu.onMyLocationButtonClick();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.4 */
    class C11554 extends com.google.android.gms.maps.internal.zzj.zza {
        final /* synthetic */ GoogleMap zzaFs;
        final /* synthetic */ OnMapLoadedCallback zzaFv;

        C11554(GoogleMap googleMap, OnMapLoadedCallback onMapLoadedCallback) {
            this.zzaFs = googleMap;
            this.zzaFv = onMapLoadedCallback;
        }

        public void onMapLoaded() throws RemoteException {
            this.zzaFv.onMapLoaded();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.5 */
    class C11565 extends com.google.android.gms.maps.internal.zzw.zza {
        final /* synthetic */ GoogleMap zzaFs;
        final /* synthetic */ SnapshotReadyCallback zzaFw;

        C11565(GoogleMap googleMap, SnapshotReadyCallback snapshotReadyCallback) {
            this.zzaFs = googleMap;
            this.zzaFw = snapshotReadyCallback;
        }

        public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
            this.zzaFw.onSnapshotReady(snapshot);
        }

        public void zzr(zzd com_google_android_gms_dynamic_zzd) throws RemoteException {
            this.zzaFw.onSnapshotReady((Bitmap) zze.zzp(com_google_android_gms_dynamic_zzd));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.6 */
    class C11576 extends com.google.android.gms.maps.internal.ILocationSourceDelegate.zza {
        final /* synthetic */ GoogleMap zzaFs;
        final /* synthetic */ LocationSource zzaFx;

        /* renamed from: com.google.android.gms.maps.GoogleMap.6.1 */
        class C08171 implements OnLocationChangedListener {
            final /* synthetic */ zzh zzaFy;
            final /* synthetic */ C11576 zzaFz;

            C08171(C11576 c11576, zzh com_google_android_gms_maps_internal_zzh) {
                this.zzaFz = c11576;
                this.zzaFy = com_google_android_gms_maps_internal_zzh;
            }

            public void onLocationChanged(Location location) {
                try {
                    this.zzaFy.zzc(location);
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }

        C11576(GoogleMap googleMap, LocationSource locationSource) {
            this.zzaFs = googleMap;
            this.zzaFx = locationSource;
        }

        public void activate(zzh listener) {
            this.zzaFx.activate(new C08171(this, listener));
        }

        public void deactivate() {
            this.zzaFx.deactivate();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.7 */
    class C11587 extends com.google.android.gms.maps.internal.zze.zza {
        final /* synthetic */ OnCameraChangeListener zzaFA;
        final /* synthetic */ GoogleMap zzaFs;

        C11587(GoogleMap googleMap, OnCameraChangeListener onCameraChangeListener) {
            this.zzaFs = googleMap;
            this.zzaFA = onCameraChangeListener;
        }

        public void onCameraChange(CameraPosition position) {
            this.zzaFA.onCameraChange(position);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.8 */
    class C11598 extends com.google.android.gms.maps.internal.zzi.zza {
        final /* synthetic */ OnMapClickListener zzaFB;
        final /* synthetic */ GoogleMap zzaFs;

        C11598(GoogleMap googleMap, OnMapClickListener onMapClickListener) {
            this.zzaFs = googleMap;
            this.zzaFB = onMapClickListener;
        }

        public void onMapClick(LatLng point) {
            this.zzaFB.onMapClick(point);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.9 */
    class C11609 extends com.google.android.gms.maps.internal.zzk.zza {
        final /* synthetic */ OnMapLongClickListener zzaFC;
        final /* synthetic */ GoogleMap zzaFs;

        C11609(GoogleMap googleMap, OnMapLongClickListener onMapLongClickListener) {
            this.zzaFs = googleMap;
            this.zzaFC = onMapLongClickListener;
        }

        public void onMapLongClick(LatLng point) {
            this.zzaFC.onMapLongClick(point);
        }
    }

    private static final class zza extends com.google.android.gms.maps.internal.zzb.zza {
        private final CancelableCallback zzaFH;

        zza(CancelableCallback cancelableCallback) {
            this.zzaFH = cancelableCallback;
        }

        public void onCancel() {
            this.zzaFH.onCancel();
        }

        public void onFinish() {
            this.zzaFH.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.zzaFp = (IGoogleMapDelegate) zzx.zzv(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.zzaFp.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            zzc addGroundOverlay = this.zzaFp.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            zzf addMarker = this.zzaFp.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.zzaFp.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.zzaFp.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            com.google.android.gms.maps.model.internal.zzh addTileOverlay = this.zzaFp.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.zzaFp.animateCamera(update.zzwB());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.zzaFp.animateCameraWithDurationAndCallback(update.zzwB(), durationMs, callback == null ? null : new zza(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.zzaFp.animateCameraWithCallback(update.zzwB(), callback == null ? null : new zza(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.zzaFp.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.zzaFp.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            com.google.android.gms.maps.model.internal.zzd focusedBuilding = this.zzaFp.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.zzaFp.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.zzaFp.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.zzaFp.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.zzaFp.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.zzaFp.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.zzaFq == null) {
                this.zzaFq = new UiSettings(this.zzaFp.getUiSettings());
            }
            return this.zzaFq;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.zzaFp.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.zzaFp.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.zzaFp.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.zzaFp.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.zzaFp.moveCamera(update.zzwB());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.zzaFp.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String description) {
        try {
            this.zzaFp.setContentDescription(description);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.zzaFp.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.zzaFp.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setInfoWindowAdapter(new AnonymousClass13(this, adapter));
    }

    public final void setLocationSource(LocationSource source) {
        if (source == null) {
            try {
                this.zzaFp.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setLocationSource(new C11576(this, source));
    }

    public final void setMapType(int type) {
        try {
            this.zzaFp.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.zzaFp.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnCameraChangeListener(new C11587(this, listener));
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnIndoorStateChangeListener(new C11521(this, listener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnInfoWindowClickListener(new AnonymousClass12(this, listener));
    }

    public final void setOnMapClickListener(OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMapClickListener(new C11598(this, listener));
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.zzaFp.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMapLoadedCallback(new C11554(this, callback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMapLongClickListener(new C11609(this, listener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMarkerClickListener(new AnonymousClass10(this, listener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMarkerDragListener(new AnonymousClass11(this, listener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMyLocationButtonClickListener(new C11543(this, listener));
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zzaFp.setOnMyLocationChangeListener(new C11532(this, listener));
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.zzaFp.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.zzaFp.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.zzaFp.snapshot(new C11565(this, callback), (zze) (bitmap != null ? zze.zzx(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.zzaFp.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate zzwD() {
        return this.zzaFp;
    }
}
