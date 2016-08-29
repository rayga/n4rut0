package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

public class zzd extends zzj<zzf> {
    private final PlacesParams zzaEj;
    private final Locale zzaEk;

    public static class zza extends com.google.android.gms.common.api.Api.zza<zzd, PlacesOptions> {
        private final String zzaEl;
        private final String zzaEm;

        public zza(String str, String str2) {
            this.zzaEl = str;
            this.zzaEm = str2;
        }

        public zzd zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, PlacesOptions placesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzd(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener, this.zzaEl != null ? this.zzaEl : context.getPackageName(), this.zzaEm != null ? this.zzaEm : context.getPackageName(), placesOptions == null ? new Builder().build() : placesOptions);
        }
    }

    public zzd(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String str2, PlacesOptions placesOptions) {
        super(context, looper, 65, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzaEk = Locale.getDefault();
        String str3 = null;
        if (com_google_android_gms_common_internal_zzf.getAccount() != null) {
            str3 = com_google_android_gms_common_internal_zzf.getAccount().name;
        }
        this.zzaEj = new PlacesParams(str, this.zzaEk, str3, placesOptions.zzaDU, str2);
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzcc(iBinder);
    }

    public void zza(com.google.android.gms.location.places.zzf com_google_android_gms_location_places_zzf, String str) throws RemoteException {
        zzx.zzb((Object) str, (Object) "placeId cannot be null");
        ((zzf) zzoA()).zza(str, this.zzaEj, (zzg) com_google_android_gms_location_places_zzf);
    }

    public void zza(com.google.android.gms.location.places.zzf com_google_android_gms_location_places_zzf, String str, int i, int i2, int i3) throws RemoteException {
        boolean z = true;
        zzx.zzb((Object) str, (Object) "fifeUrl cannot be null");
        zzx.zzb(i > 0, (Object) "width should be > 0");
        if (i <= 0) {
            z = false;
        }
        zzx.zzb(z, (Object) "height should be > 0");
        ((zzf) zzoA()).zza(str, i, i2, i3, this.zzaEj, (zzg) com_google_android_gms_location_places_zzf);
    }

    public void zza(zzl com_google_android_gms_location_places_zzl, AddPlaceRequest addPlaceRequest) throws RemoteException {
        zzx.zzb((Object) addPlaceRequest, (Object) "userAddedPlace == null");
        ((zzf) zzoA()).zza(addPlaceRequest, this.zzaEj, (zzh) com_google_android_gms_location_places_zzl);
    }

    public void zza(zzl com_google_android_gms_location_places_zzl, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) throws RemoteException {
        zzx.zzb((Object) str, (Object) "query == null");
        zzx.zzb((Object) latLngBounds, (Object) "bounds == null");
        zzx.zzb((Object) com_google_android_gms_location_places_zzl, (Object) "callback == null");
        ((zzf) zzoA()).zza(str, latLngBounds, autocompleteFilter == null ? AutocompleteFilter.create(null) : autocompleteFilter, this.zzaEj, (zzh) com_google_android_gms_location_places_zzl);
    }

    public void zza(zzl com_google_android_gms_location_places_zzl, List<String> list) throws RemoteException {
        ((zzf) zzoA()).zzb((List) list, this.zzaEj, (zzh) com_google_android_gms_location_places_zzl);
    }

    protected zzf zzcc(IBinder iBinder) {
        return com.google.android.gms.location.places.internal.zzf.zza.zzce(iBinder);
    }

    protected String zzfA() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    protected String zzfB() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }
}
