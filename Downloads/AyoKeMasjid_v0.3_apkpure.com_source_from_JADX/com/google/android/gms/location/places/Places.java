package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.location.places.internal.zzd;
import com.google.android.gms.location.places.internal.zzd.zza;
import com.google.android.gms.location.places.internal.zzi;
import com.google.android.gms.location.places.internal.zzj;

public class Places {
    public static final Api<PlacesOptions> GEO_DATA_API;
    public static final GeoDataApi GeoDataApi;
    public static final Api<PlacesOptions> PLACE_DETECTION_API;
    public static final PlaceDetectionApi PlaceDetectionApi;
    public static final zzc<zzd> zzaDN;
    public static final zzc<zzj> zzaDO;

    static {
        zzaDN = new zzc();
        zzaDO = new zzc();
        GEO_DATA_API = new Api("Places.GEO_DATA_API", new zza(null, null), zzaDN);
        PLACE_DETECTION_API = new Api("Places.PLACE_DETECTION_API", new zzj.zza(null, null), zzaDO);
        GeoDataApi = new com.google.android.gms.location.places.internal.zzc();
        PlaceDetectionApi = new zzi();
    }

    private Places() {
    }
}
