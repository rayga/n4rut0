package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzl;
import java.util.Locale;

public class zzj extends com.google.android.gms.common.internal.zzj<zze> {
    private final PlacesParams zzaEj;
    private final Locale zzaEk;

    public static class zza extends com.google.android.gms.common.api.Api.zza<zzj, PlacesOptions> {
        private final String zzaEl;
        private final String zzaEm;

        public zza(String str, String str2) {
            this.zzaEl = str;
            this.zzaEm = str2;
        }

        public /* synthetic */ zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzb(context, looper, com_google_android_gms_common_internal_zzf, (PlacesOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzj zzb(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, PlacesOptions placesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzj(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener, this.zzaEl != null ? this.zzaEl : context.getPackageName(), this.zzaEm != null ? this.zzaEm : context.getPackageName(), placesOptions == null ? new Builder().build() : placesOptions);
        }
    }

    public zzj(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String str2, PlacesOptions placesOptions) {
        super(context, looper, 67, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzaEk = Locale.getDefault();
        String str3 = null;
        if (com_google_android_gms_common_internal_zzf.getAccount() != null) {
            str3 = com_google_android_gms_common_internal_zzf.getAccount().name;
        }
        this.zzaEj = new PlacesParams(str, this.zzaEk, str3, placesOptions.zzaDU, str2);
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzch(iBinder);
    }

    public void zza(zzl com_google_android_gms_location_places_zzl, PlaceFilter placeFilter) throws RemoteException {
        if (placeFilter == null) {
            placeFilter = PlaceFilter.zzwe();
        }
        ((zze) zzoA()).zza(placeFilter, this.zzaEj, (zzh) com_google_android_gms_location_places_zzl);
    }

    public void zza(zzl com_google_android_gms_location_places_zzl, PlaceReport placeReport) throws RemoteException {
        zzx.zzv(placeReport);
        ((zze) zzoA()).zza(placeReport, this.zzaEj, (zzh) com_google_android_gms_location_places_zzl);
    }

    protected zze zzch(IBinder iBinder) {
        return com.google.android.gms.location.places.internal.zze.zza.zzcd(iBinder);
    }

    protected String zzfA() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    protected String zzfB() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }
}
