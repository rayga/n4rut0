package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CircleOptions implements SafeParcelable {
    public static final zzb CREATOR;
    private final int mVersionCode;
    private LatLng zzaGU;
    private double zzaGV;
    private float zzaGW;
    private int zzaGX;
    private int zzaGY;
    private float zzaGZ;
    private boolean zzaHa;

    static {
        CREATOR = new zzb();
    }

    public CircleOptions() {
        this.zzaGU = null;
        this.zzaGV = 0.0d;
        this.zzaGW = 10.0f;
        this.zzaGX = ViewCompat.MEASURED_STATE_MASK;
        this.zzaGY = 0;
        this.zzaGZ = 0.0f;
        this.zzaHa = true;
        this.mVersionCode = 1;
    }

    CircleOptions(int versionCode, LatLng center, double radius, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible) {
        this.zzaGU = null;
        this.zzaGV = 0.0d;
        this.zzaGW = 10.0f;
        this.zzaGX = ViewCompat.MEASURED_STATE_MASK;
        this.zzaGY = 0;
        this.zzaGZ = 0.0f;
        this.zzaHa = true;
        this.mVersionCode = versionCode;
        this.zzaGU = center;
        this.zzaGV = radius;
        this.zzaGW = strokeWidth;
        this.zzaGX = strokeColor;
        this.zzaGY = fillColor;
        this.zzaGZ = zIndex;
        this.zzaHa = visible;
    }

    public CircleOptions center(LatLng center) {
        this.zzaGU = center;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int color) {
        this.zzaGY = color;
        return this;
    }

    public LatLng getCenter() {
        return this.zzaGU;
    }

    public int getFillColor() {
        return this.zzaGY;
    }

    public double getRadius() {
        return this.zzaGV;
    }

    public int getStrokeColor() {
        return this.zzaGX;
    }

    public float getStrokeWidth() {
        return this.zzaGW;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public float getZIndex() {
        return this.zzaGZ;
    }

    public boolean isVisible() {
        return this.zzaHa;
    }

    public CircleOptions radius(double radius) {
        this.zzaGV = radius;
        return this;
    }

    public CircleOptions strokeColor(int color) {
        this.zzaGX = color;
        return this;
    }

    public CircleOptions strokeWidth(float width) {
        this.zzaGW = width;
        return this;
    }

    public CircleOptions visible(boolean visible) {
        this.zzaHa = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public CircleOptions zIndex(float zIndex) {
        this.zzaGZ = zIndex;
        return this;
    }
}
