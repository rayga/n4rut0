package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceImpl.zza;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.bpmikc.akm.BuildConfig;

public class zzr extends zzt implements Place {
    private final String zzaDH;
    private boolean zzaEC;
    private final zzo zzaEF;

    public zzr(DataHolder dataHolder, int i, Context context) {
        super(dataHolder, i);
        this.zzaEF = context != null ? zzo.zzaE(context) : null;
        this.zzaEC = zzh("place_is_logging_enabled", false);
        this.zzaDH = zzD("place_id", BuildConfig.FLAVOR);
    }

    private void zzdA(String str) {
        if (this.zzaEC && this.zzaEF != null) {
            this.zzaEF.zzC(this.zzaDH, str);
        }
    }

    public /* synthetic */ Object freeze() {
        return zzwr();
    }

    public CharSequence getAddress() {
        zzdA("getAddress");
        return zzD("place_address", BuildConfig.FLAVOR);
    }

    public String getId() {
        zzdA("getId");
        return this.zzaDH;
    }

    public LatLng getLatLng() {
        zzdA("getLatLng");
        return (LatLng) zza("place_lat_lng", LatLng.CREATOR);
    }

    public Locale getLocale() {
        zzdA("getLocale");
        Object zzD = zzD("place_locale", BuildConfig.FLAVOR);
        return !TextUtils.isEmpty(zzD) ? new Locale(zzD) : Locale.getDefault();
    }

    public CharSequence getName() {
        zzdA("getName");
        return zzD("place_name", BuildConfig.FLAVOR);
    }

    public CharSequence getPhoneNumber() {
        zzdA("getPhoneNumber");
        return zzD("place_phone_number", BuildConfig.FLAVOR);
    }

    public List<Integer> getPlaceTypes() {
        zzdA("getPlaceTypes");
        return zza("place_types", Collections.emptyList());
    }

    public int getPriceLevel() {
        zzdA("getPriceLevel");
        return zzA("place_price_level", -1);
    }

    public float getRating() {
        zzdA("getRating");
        return zzb("place_rating", (float) GroundOverlayOptions.NO_DIMENSION);
    }

    public LatLngBounds getViewport() {
        zzdA("getViewport");
        return (LatLngBounds) zza("place_viewport", LatLngBounds.CREATOR);
    }

    public Uri getWebsiteUri() {
        zzdA("getWebsiteUri");
        String zzD = zzD("place_website_uri", null);
        return zzD == null ? null : Uri.parse(zzD);
    }

    public float zzwj() {
        zzdA("getLevelNumber");
        return zzb("place_level_number", 0.0f);
    }

    public boolean zzwm() {
        zzdA("isPermanentlyClosed");
        return zzh("place_is_permanently_closed", false);
    }

    public Place zzwr() {
        zza zzai = new zza().zzai(this.zzaEC);
        this.zzaEC = false;
        Place zzws = zzai.zzdD(getAddress().toString()).zzn(zzb("place_attributions", Collections.emptyList())).zzdB(getId()).zzah(zzwm()).zza(getLatLng()).zzf(zzwj()).zzdC(getName().toString()).zzdE(getPhoneNumber().toString()).zzhj(getPriceLevel()).zzg(getRating()).zzm(getPlaceTypes()).zza(getViewport()).zzl(getWebsiteUri()).zzws();
        zzws.setLocale(getLocale());
        zzws.zza(this.zzaEF);
        return zzws;
    }
}
