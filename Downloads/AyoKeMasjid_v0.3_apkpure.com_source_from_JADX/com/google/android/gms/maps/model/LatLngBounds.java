package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class LatLngBounds implements SafeParcelable {
    public static final zzd CREATOR;
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double zzaHm;
        private double zzaHn;
        private double zzaHo;
        private double zzaHp;

        public Builder() {
            this.zzaHm = MediaQueueItem.DEFAULT_PLAYBACK_DURATION;
            this.zzaHn = Double.NEGATIVE_INFINITY;
            this.zzaHo = Double.NaN;
            this.zzaHp = Double.NaN;
        }

        private boolean zzh(double d) {
            boolean z = false;
            if (this.zzaHo <= this.zzaHp) {
                return this.zzaHo <= d && d <= this.zzaHp;
            } else {
                if (this.zzaHo <= d || d <= this.zzaHp) {
                    z = true;
                }
                return z;
            }
        }

        public LatLngBounds build() {
            zzx.zza(!Double.isNaN(this.zzaHo), (Object) "no included points");
            return new LatLngBounds(new LatLng(this.zzaHm, this.zzaHo), new LatLng(this.zzaHn, this.zzaHp));
        }

        public Builder include(LatLng point) {
            this.zzaHm = Math.min(this.zzaHm, point.latitude);
            this.zzaHn = Math.max(this.zzaHn, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.zzaHo)) {
                this.zzaHo = d;
                this.zzaHp = d;
            } else if (!zzh(d)) {
                if (LatLngBounds.zzb(this.zzaHo, d) < LatLngBounds.zzc(this.zzaHp, d)) {
                    this.zzaHo = d;
                } else {
                    this.zzaHp = d;
                }
            }
            return this;
        }
    }

    static {
        CREATOR = new zzd();
    }

    LatLngBounds(int versionCode, LatLng southwest, LatLng northeast) {
        zzx.zzb((Object) southwest, (Object) "null southwest");
        zzx.zzb((Object) northeast, (Object) "null northeast");
        zzx.zzb(northeast.latitude >= southwest.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(southwest.latitude), Double.valueOf(northeast.latitude));
        this.mVersionCode = versionCode;
        this.southwest = southwest;
        this.northeast = northeast;
    }

    public LatLngBounds(LatLng southwest, LatLng northeast) {
        this(1, southwest, northeast);
    }

    public static Builder builder() {
        return new Builder();
    }

    private static double zzb(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    private static double zzc(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private boolean zzg(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean zzh(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        } else {
            if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
                z = true;
            }
            return z;
        }
    }

    public boolean contains(LatLng point) {
        return zzg(point.latitude) && zzh(point.longitude);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) o;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng point) {
        double min = Math.min(this.southwest.latitude, point.latitude);
        double max = Math.max(this.northeast.latitude, point.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = point.longitude;
        if (zzh(d3)) {
            d3 = d2;
            d2 = d;
        } else if (zzb(d2, d3) < zzc(d, d3)) {
            d2 = d;
        } else {
            double d4 = d2;
            d2 = d3;
            d3 = d4;
        }
        return new LatLngBounds(new LatLng(min, d3), new LatLng(max, d2));
    }

    public String toString() {
        return zzw.zzu(this).zzg("southwest", this.southwest).zzg("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
