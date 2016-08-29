package com.google.android.gms.location.places;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzf extends com.google.android.gms.location.places.internal.zzg.zza {
    private final zzb zzaDw;
    private final zza zzaDx;

    public static abstract class zza<A extends com.google.android.gms.common.api.Api.zzb> extends com.google.android.gms.location.places.zzl.zzb<PlacePhotoResult, A> {
        public zza(zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }

        protected PlacePhotoResult zzaM(Status status) {
            return new PlacePhotoResult(status, null);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzaM(status);
        }
    }

    public static abstract class zzb<A extends com.google.android.gms.common.api.Api.zzb> extends com.google.android.gms.location.places.zzl.zzb<PlacePhotoMetadataResult, A> {
        public zzb(zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }

        protected PlacePhotoMetadataResult zzaN(Status status) {
            return new PlacePhotoMetadataResult(status, null);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzaN(status);
        }
    }

    public zzf(zza com_google_android_gms_location_places_zzf_zza) {
        this.zzaDw = null;
        this.zzaDx = com_google_android_gms_location_places_zzf_zza;
    }

    public zzf(zzb com_google_android_gms_location_places_zzf_zzb) {
        this.zzaDw = com_google_android_gms_location_places_zzf_zzb;
        this.zzaDx = null;
    }

    public void zza(PlacePhotoMetadataResult placePhotoMetadataResult) throws RemoteException {
        this.zzaDw.zza((Result) placePhotoMetadataResult);
    }

    public void zza(PlacePhotoResult placePhotoResult) throws RemoteException {
        this.zzaDx.zza((Result) placePhotoResult);
    }
}
