package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

public class PlaceLikelihoodEntity implements SafeParcelable, PlaceLikelihood {
    public static final Creator<PlaceLikelihoodEntity> CREATOR;
    final int mVersionCode;
    final PlaceImpl zzaEI;
    final float zzaEJ;

    static {
        CREATOR = new zzl();
    }

    PlaceLikelihoodEntity(int versionCode, PlaceImpl place, float likelihood) {
        this.mVersionCode = versionCode;
        this.zzaEI = place;
        this.zzaEJ = likelihood;
    }

    public static PlaceLikelihoodEntity zza(PlaceImpl placeImpl, float f) {
        return new PlaceLikelihoodEntity(0, (PlaceImpl) zzx.zzv(placeImpl), f);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceLikelihoodEntity)) {
            return false;
        }
        PlaceLikelihoodEntity placeLikelihoodEntity = (PlaceLikelihoodEntity) object;
        return this.zzaEI.equals(placeLikelihoodEntity.zzaEI) && this.zzaEJ == placeLikelihoodEntity.zzaEJ;
    }

    public /* synthetic */ Object freeze() {
        return zzwt();
    }

    public float getLikelihood() {
        return this.zzaEJ;
    }

    public Place getPlace() {
        return this.zzaEI;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaEI, Float.valueOf(this.zzaEJ));
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzw.zzu(this).zzg("place", this.zzaEI).zzg("likelihood", Float.valueOf(this.zzaEJ)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzl.zza(this, parcel, flags);
    }

    public PlaceLikelihood zzwt() {
        return this;
    }
}
