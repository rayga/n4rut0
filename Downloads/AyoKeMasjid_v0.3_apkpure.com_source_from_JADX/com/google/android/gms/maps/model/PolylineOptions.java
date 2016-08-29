package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final zzi CREATOR;
    private int mColor;
    private final int mVersionCode;
    private float zzaGZ;
    private final List<LatLng> zzaHB;
    private boolean zzaHD;
    private boolean zzaHa;
    private float zzaHe;

    static {
        CREATOR = new zzi();
    }

    public PolylineOptions() {
        this.zzaHe = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.zzaGZ = 0.0f;
        this.zzaHa = true;
        this.zzaHD = false;
        this.mVersionCode = 1;
        this.zzaHB = new ArrayList();
    }

    PolylineOptions(int versionCode, List points, float width, int color, float zIndex, boolean visible, boolean geodesic) {
        this.zzaHe = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.zzaGZ = 0.0f;
        this.zzaHa = true;
        this.zzaHD = false;
        this.mVersionCode = versionCode;
        this.zzaHB = points;
        this.zzaHe = width;
        this.mColor = color;
        this.zzaGZ = zIndex;
        this.zzaHa = visible;
        this.zzaHD = geodesic;
    }

    public PolylineOptions add(LatLng point) {
        this.zzaHB.add(point);
        return this;
    }

    public PolylineOptions add(LatLng... points) {
        this.zzaHB.addAll(Arrays.asList(points));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.zzaHB.add(add);
        }
        return this;
    }

    public PolylineOptions color(int color) {
        this.mColor = color;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean geodesic) {
        this.zzaHD = geodesic;
        return this;
    }

    public int getColor() {
        return this.mColor;
    }

    public List<LatLng> getPoints() {
        return this.zzaHB;
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

    public boolean isGeodesic() {
        return this.zzaHD;
    }

    public boolean isVisible() {
        return this.zzaHa;
    }

    public PolylineOptions visible(boolean visible) {
        this.zzaHa = visible;
        return this;
    }

    public PolylineOptions width(float width) {
        this.zzaHe = width;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi.zza(this, out, flags);
    }

    public PolylineOptions zIndex(float zIndex) {
        this.zzaGZ = zIndex;
        return this;
    }
}
