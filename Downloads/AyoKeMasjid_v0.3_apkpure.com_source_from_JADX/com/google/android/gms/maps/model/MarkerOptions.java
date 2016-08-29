package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.android.volley.DefaultRetryPolicy;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd.zza;

public final class MarkerOptions implements SafeParcelable {
    public static final zzf CREATOR;
    private float mAlpha;
    private final int mVersionCode;
    private LatLng zzaGx;
    private boolean zzaHa;
    private float zzaHi;
    private float zzaHj;
    private String zzaHr;
    private BitmapDescriptor zzaHs;
    private boolean zzaHt;
    private boolean zzaHu;
    private float zzaHv;
    private float zzaHw;
    private float zzaHx;
    private String zzagU;

    static {
        CREATOR = new zzf();
    }

    public MarkerOptions() {
        this.zzaHi = 0.5f;
        this.zzaHj = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.zzaHa = true;
        this.zzaHu = false;
        this.zzaHv = 0.0f;
        this.zzaHw = 0.5f;
        this.zzaHx = 0.0f;
        this.mAlpha = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.mVersionCode = 1;
    }

    MarkerOptions(int versionCode, LatLng position, String title, String snippet, IBinder wrappedIcon, float anchorU, float anchorV, boolean draggable, boolean visible, boolean flat, float rotation, float infoWindowAnchorU, float infoWindowAnchorV, float alpha) {
        this.zzaHi = 0.5f;
        this.zzaHj = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.zzaHa = true;
        this.zzaHu = false;
        this.zzaHv = 0.0f;
        this.zzaHw = 0.5f;
        this.zzaHx = 0.0f;
        this.mAlpha = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.mVersionCode = versionCode;
        this.zzaGx = position;
        this.zzagU = title;
        this.zzaHr = snippet;
        this.zzaHs = wrappedIcon == null ? null : new BitmapDescriptor(zza.zzbk(wrappedIcon));
        this.zzaHi = anchorU;
        this.zzaHj = anchorV;
        this.zzaHt = draggable;
        this.zzaHa = visible;
        this.zzaHu = flat;
        this.zzaHv = rotation;
        this.zzaHw = infoWindowAnchorU;
        this.zzaHx = infoWindowAnchorV;
        this.mAlpha = alpha;
    }

    public MarkerOptions alpha(float alpha) {
        this.mAlpha = alpha;
        return this;
    }

    public MarkerOptions anchor(float u, float v) {
        this.zzaHi = u;
        this.zzaHj = v;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean draggable) {
        this.zzaHt = draggable;
        return this;
    }

    public MarkerOptions flat(boolean flat) {
        this.zzaHu = flat;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.zzaHi;
    }

    public float getAnchorV() {
        return this.zzaHj;
    }

    public BitmapDescriptor getIcon() {
        return this.zzaHs;
    }

    public float getInfoWindowAnchorU() {
        return this.zzaHw;
    }

    public float getInfoWindowAnchorV() {
        return this.zzaHx;
    }

    public LatLng getPosition() {
        return this.zzaGx;
    }

    public float getRotation() {
        return this.zzaHv;
    }

    public String getSnippet() {
        return this.zzaHr;
    }

    public String getTitle() {
        return this.zzagU;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public MarkerOptions icon(BitmapDescriptor icon) {
        this.zzaHs = icon;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float u, float v) {
        this.zzaHw = u;
        this.zzaHx = v;
        return this;
    }

    public boolean isDraggable() {
        return this.zzaHt;
    }

    public boolean isFlat() {
        return this.zzaHu;
    }

    public boolean isVisible() {
        return this.zzaHa;
    }

    public MarkerOptions position(LatLng position) {
        this.zzaGx = position;
        return this;
    }

    public MarkerOptions rotation(float rotation) {
        this.zzaHv = rotation;
        return this;
    }

    public MarkerOptions snippet(String snippet) {
        this.zzaHr = snippet;
        return this;
    }

    public MarkerOptions title(String title) {
        this.zzagU = title;
        return this;
    }

    public MarkerOptions visible(boolean visible) {
        this.zzaHa = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }

    IBinder zzxd() {
        return this.zzaHs == null ? null : this.zzaHs.zzwB().asBinder();
    }
}
