package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.android.volley.DefaultRetryPolicy;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd.zza;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final zzc CREATOR;
    public static final float NO_DIMENSION = -1.0f;
    private final int mVersionCode;
    private float zzaGS;
    private float zzaGZ;
    private boolean zzaHa;
    private BitmapDescriptor zzaHc;
    private LatLng zzaHd;
    private float zzaHe;
    private float zzaHf;
    private LatLngBounds zzaHg;
    private float zzaHh;
    private float zzaHi;
    private float zzaHj;

    static {
        CREATOR = new zzc();
    }

    public GroundOverlayOptions() {
        this.zzaHa = true;
        this.zzaHh = 0.0f;
        this.zzaHi = 0.5f;
        this.zzaHj = 0.5f;
        this.mVersionCode = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.zzaHa = true;
        this.zzaHh = 0.0f;
        this.zzaHi = 0.5f;
        this.zzaHj = 0.5f;
        this.mVersionCode = versionCode;
        this.zzaHc = new BitmapDescriptor(zza.zzbk(wrappedImage));
        this.zzaHd = location;
        this.zzaHe = width;
        this.zzaHf = height;
        this.zzaHg = bounds;
        this.zzaGS = bearing;
        this.zzaGZ = zIndex;
        this.zzaHa = visible;
        this.zzaHh = transparency;
        this.zzaHi = anchorU;
        this.zzaHj = anchorV;
    }

    private GroundOverlayOptions zza(LatLng latLng, float f, float f2) {
        this.zzaHd = latLng;
        this.zzaHe = f;
        this.zzaHf = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.zzaHi = u;
        this.zzaHj = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.zzaGS = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.zzaHi;
    }

    public float getAnchorV() {
        return this.zzaHj;
    }

    public float getBearing() {
        return this.zzaGS;
    }

    public LatLngBounds getBounds() {
        return this.zzaHg;
    }

    public float getHeight() {
        return this.zzaHf;
    }

    public BitmapDescriptor getImage() {
        return this.zzaHc;
    }

    public LatLng getLocation() {
        return this.zzaHd;
    }

    public float getTransparency() {
        return this.zzaHh;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public float getWidth() {
        return this.zzaHe;
    }

    public float getZIndex() {
        return this.zzaGZ;
    }

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.zzaHc = image;
        return this;
    }

    public boolean isVisible() {
        return this.zzaHa;
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        zzx.zza(this.zzaHg == null, (Object) "Position has already been set using positionFromBounds");
        zzx.zzb(location != null, (Object) "Location must be specified");
        if (width < 0.0f) {
            z = false;
        }
        zzx.zzb(z, (Object) "Width must be non-negative");
        return zza(location, width, NO_DIMENSION);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        zzx.zza(this.zzaHg == null, (Object) "Position has already been set using positionFromBounds");
        zzx.zzb(location != null, (Object) "Location must be specified");
        zzx.zzb(width >= 0.0f, (Object) "Width must be non-negative");
        if (height < 0.0f) {
            z = false;
        }
        zzx.zzb(z, (Object) "Height must be non-negative");
        return zza(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        zzx.zza(this.zzaHd == null, "Position has already been set using position: " + this.zzaHd);
        this.zzaHg = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        boolean z = transparency >= 0.0f && transparency <= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        zzx.zzb(z, (Object) "Transparency must be in the range [0..1]");
        this.zzaHh = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.zzaHa = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.zzaGZ = zIndex;
        return this;
    }

    IBinder zzxc() {
        return this.zzaHc.zzwB().asBinder();
    }
}
