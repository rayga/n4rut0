package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
    public static final zzb CREATOR;
    private final int mVersionCode;
    private Boolean zzaFJ;
    private Boolean zzaFP;
    private Boolean zzaGA;
    private Boolean zzaGB;
    private StreetViewPanoramaCamera zzaGv;
    private String zzaGw;
    private LatLng zzaGx;
    private Integer zzaGy;
    private Boolean zzaGz;

    static {
        CREATOR = new zzb();
    }

    public StreetViewPanoramaOptions() {
        this.zzaGz = Boolean.valueOf(true);
        this.zzaFP = Boolean.valueOf(true);
        this.zzaGA = Boolean.valueOf(true);
        this.zzaGB = Boolean.valueOf(true);
        this.mVersionCode = 1;
    }

    StreetViewPanoramaOptions(int versionCode, StreetViewPanoramaCamera camera, String panoId, LatLng position, Integer radius, byte userNavigationEnabled, byte zoomGesturesEnabled, byte panningGesturesEnabled, byte streetNamesEnabled, byte useViewLifecycleInFragment) {
        this.zzaGz = Boolean.valueOf(true);
        this.zzaFP = Boolean.valueOf(true);
        this.zzaGA = Boolean.valueOf(true);
        this.zzaGB = Boolean.valueOf(true);
        this.mVersionCode = versionCode;
        this.zzaGv = camera;
        this.zzaGx = position;
        this.zzaGy = radius;
        this.zzaGw = panoId;
        this.zzaGz = zza.zza(userNavigationEnabled);
        this.zzaFP = zza.zza(zoomGesturesEnabled);
        this.zzaGA = zza.zza(panningGesturesEnabled);
        this.zzaGB = zza.zza(streetNamesEnabled);
        this.zzaFJ = zza.zza(useViewLifecycleInFragment);
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.zzaGA;
    }

    public String getPanoramaId() {
        return this.zzaGw;
    }

    public LatLng getPosition() {
        return this.zzaGx;
    }

    public Integer getRadius() {
        return this.zzaGy;
    }

    public Boolean getStreetNamesEnabled() {
        return this.zzaGB;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.zzaGv;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.zzaFJ;
    }

    public Boolean getUserNavigationEnabled() {
        return this.zzaGz;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.zzaFP;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean enabled) {
        this.zzaGA = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera camera) {
        this.zzaGv = camera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String panoId) {
        this.zzaGw = panoId;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position) {
        this.zzaGx = position;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng position, Integer radius) {
        this.zzaGx = position;
        this.zzaGy = radius;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean enabled) {
        this.zzaGB = Boolean.valueOf(enabled);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean useViewLifecycleInFragment) {
        this.zzaFJ = Boolean.valueOf(useViewLifecycleInFragment);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean enabled) {
        this.zzaGz = Boolean.valueOf(enabled);
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean enabled) {
        this.zzaFP = Boolean.valueOf(enabled);
        return this;
    }

    byte zzwF() {
        return zza.zze(this.zzaFJ);
    }

    byte zzwJ() {
        return zza.zze(this.zzaFP);
    }

    byte zzwT() {
        return zza.zze(this.zzaGz);
    }

    byte zzwU() {
        return zza.zze(this.zzaGA);
    }

    byte zzwV() {
        return zza.zze(this.zzaGB);
    }
}
