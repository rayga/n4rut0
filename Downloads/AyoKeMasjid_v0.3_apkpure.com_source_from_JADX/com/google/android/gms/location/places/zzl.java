package com.google.android.gms.location.places;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx;

public class zzl extends com.google.android.gms.location.places.internal.zzh.zza {
    private static final String TAG;
    private final Context mContext;
    private final zzd zzaDP;
    private final zza zzaDQ;
    private final zze zzaDR;
    private final zzf zzaDS;
    private final zzc zzaDT;

    public static abstract class zzb<R extends Result, A extends com.google.android.gms.common.api.Api.zzb> extends com.google.android.gms.common.api.zzc.zza<R, A> {
        public zzb(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }
    }

    public static abstract class zza<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<AutocompletePredictionBuffer, A> {
        public zza(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }

        protected AutocompletePredictionBuffer zzaP(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.zzbp(status.getStatusCode()));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzaP(status);
        }
    }

    public static abstract class zzc<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<PlaceBuffer, A> {
        public zzc(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }

        protected PlaceBuffer zzaQ(Status status) {
            return new PlaceBuffer(DataHolder.zzbp(status.getStatusCode()), null);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzaQ(status);
        }
    }

    public static abstract class zzd<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<PlaceLikelihoodBuffer, A> {
        public zzd(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }

        protected PlaceLikelihoodBuffer zzaR(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.zzbp(status.getStatusCode()), 100, null);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzaR(status);
        }
    }

    public static abstract class zze<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<com.google.android.gms.location.places.personalized.zzd, A> {
        protected com.google.android.gms.location.places.personalized.zzd zzaS(Status status) {
            return com.google.android.gms.location.places.personalized.zzd.zzaT(status);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzaS(status);
        }
    }

    public static abstract class zzf<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<Status, A> {
        public zzf(com.google.android.gms.common.api.Api.zzc<A> com_google_android_gms_common_api_Api_zzc_A, GoogleApiClient googleApiClient) {
            super(com_google_android_gms_common_api_Api_zzc_A, googleApiClient);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    static {
        TAG = zzl.class.getSimpleName();
    }

    public zzl(zza com_google_android_gms_location_places_zzl_zza) {
        this.zzaDP = null;
        this.zzaDQ = com_google_android_gms_location_places_zzl_zza;
        this.zzaDR = null;
        this.zzaDS = null;
        this.zzaDT = null;
        this.mContext = null;
    }

    public zzl(zzc com_google_android_gms_location_places_zzl_zzc, Context context) {
        this.zzaDP = null;
        this.zzaDQ = null;
        this.zzaDR = null;
        this.zzaDS = null;
        this.zzaDT = com_google_android_gms_location_places_zzl_zzc;
        this.mContext = context;
    }

    public zzl(zzd com_google_android_gms_location_places_zzl_zzd, Context context) {
        this.zzaDP = com_google_android_gms_location_places_zzl_zzd;
        this.zzaDQ = null;
        this.zzaDR = null;
        this.zzaDS = null;
        this.zzaDT = null;
        this.mContext = context;
    }

    public zzl(zzf com_google_android_gms_location_places_zzl_zzf) {
        this.zzaDP = null;
        this.zzaDQ = null;
        this.zzaDR = null;
        this.zzaDS = com_google_android_gms_location_places_zzl_zzf;
        this.zzaDT = null;
        this.mContext = null;
    }

    public void zzZ(DataHolder dataHolder) throws RemoteException {
        zzx.zza(this.zzaDP != null, (Object) "placeEstimator cannot be null");
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceEstimated received null DataHolder: " + zzlx.zzpY());
            }
            this.zzaDP.zzx(Status.zzaaF);
            return;
        }
        this.zzaDP.zza(new PlaceLikelihoodBuffer(dataHolder, 100, this.mContext));
    }

    public void zzaO(Status status) throws RemoteException {
        this.zzaDS.zza((Result) status);
    }

    public void zzaa(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onAutocompletePrediction received null DataHolder: " + zzlx.zzpY());
            }
            this.zzaDQ.zzx(Status.zzaaF);
            return;
        }
        this.zzaDQ.zza(new AutocompletePredictionBuffer(dataHolder));
    }

    public void zzab(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceUserDataFetched received null DataHolder: " + zzlx.zzpY());
            }
            this.zzaDR.zzx(Status.zzaaF);
            return;
        }
        this.zzaDR.zza(new com.google.android.gms.location.places.personalized.zzd(dataHolder));
    }

    public void zzac(DataHolder dataHolder) throws RemoteException {
        this.zzaDT.zza(new PlaceBuffer(dataHolder, this.mContext));
    }
}
