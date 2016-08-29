package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzf.zza;

public class zzp implements PlacePhotoMetadata {
    private int mIndex;
    private final String zzaET;
    private final CharSequence zzaEU;
    private final int zzzT;
    private final int zzzU;

    /* renamed from: com.google.android.gms.location.places.internal.zzp.1 */
    class C14241 extends zza<zzd> {
        final /* synthetic */ int zzaEV;
        final /* synthetic */ int zzaEW;
        final /* synthetic */ zzp zzaEX;

        C14241(zzp com_google_android_gms_location_places_internal_zzp, zzc com_google_android_gms_common_api_Api_zzc, GoogleApiClient googleApiClient, int i, int i2) {
            this.zzaEX = com_google_android_gms_location_places_internal_zzp;
            this.zzaEV = i;
            this.zzaEW = i2;
            super(com_google_android_gms_common_api_Api_zzc, googleApiClient);
        }

        protected void zza(zzd com_google_android_gms_location_places_internal_zzd) throws RemoteException {
            com_google_android_gms_location_places_internal_zzd.zza(new zzf((zza) this), this.zzaEX.zzaET, this.zzaEV, this.zzaEW, this.zzaEX.mIndex);
        }
    }

    public zzp(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.zzaET = str;
        this.zzzT = i;
        this.zzzU = i2;
        this.zzaEU = charSequence;
        this.mIndex = i3;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof zzp)) {
            return false;
        }
        zzp com_google_android_gms_location_places_internal_zzp = (zzp) other;
        return com_google_android_gms_location_places_internal_zzp.zzzT == this.zzzT && com_google_android_gms_location_places_internal_zzp.zzzU == this.zzzU && zzw.equal(com_google_android_gms_location_places_internal_zzp.zzaET, this.zzaET) && zzw.equal(com_google_android_gms_location_places_internal_zzp.zzaEU, this.zzaEU);
    }

    public /* synthetic */ Object freeze() {
        return zzwu();
    }

    public CharSequence getAttributions() {
        return this.zzaEU;
    }

    public int getMaxHeight() {
        return this.zzzU;
    }

    public int getMaxWidth() {
        return this.zzzT;
    }

    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient client) {
        return getScaledPhoto(client, getMaxWidth(), getMaxHeight());
    }

    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient client, int width, int height) {
        return client.zza(new C14241(this, Places.zzaDN, client, width, height));
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzzT), Integer.valueOf(this.zzzU), this.zzaET, this.zzaEU);
    }

    public boolean isDataValid() {
        return true;
    }

    public PlacePhotoMetadata zzwu() {
        return this;
    }
}
