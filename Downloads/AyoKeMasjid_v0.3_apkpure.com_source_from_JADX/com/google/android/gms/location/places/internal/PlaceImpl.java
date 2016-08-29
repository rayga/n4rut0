package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceImpl implements SafeParcelable, Place {
    public static final zzk CREATOR;
    private final String mName;
    final int mVersionCode;
    private final LatLng zzaDh;
    private final List<Integer> zzaDi;
    private final String zzaDj;
    private final Uri zzaDk;
    private final String zzaEA;
    private final List<String> zzaEB;
    final boolean zzaEC;
    private final Map<Integer, String> zzaED;
    private final TimeZone zzaEE;
    private zzo zzaEF;
    private Locale zzaEk;
    private final Bundle zzaEq;
    @Deprecated
    private final PlaceLocalization zzaEr;
    private final float zzaEs;
    private final LatLngBounds zzaEt;
    private final String zzaEu;
    private final boolean zzaEv;
    private final float zzaEw;
    private final int zzaEx;
    private final long zzaEy;
    private final List<Integer> zzaEz;
    private final String zzanu;
    private final String zzwj;

    public static class zza {
        private String mName;
        private int mVersionCode;
        private LatLng zzaDh;
        private String zzaDj;
        private Uri zzaDk;
        private String zzaEA;
        private List<String> zzaEB;
        private boolean zzaEC;
        private Bundle zzaEG;
        private List<Integer> zzaEH;
        private float zzaEs;
        private LatLngBounds zzaEt;
        private String zzaEu;
        private boolean zzaEv;
        private float zzaEw;
        private int zzaEx;
        private long zzaEy;
        private String zzanu;
        private String zzwj;

        public zza() {
            this.mVersionCode = 0;
        }

        public zza zza(LatLng latLng) {
            this.zzaDh = latLng;
            return this;
        }

        public zza zza(LatLngBounds latLngBounds) {
            this.zzaEt = latLngBounds;
            return this;
        }

        public zza zzah(boolean z) {
            this.zzaEv = z;
            return this;
        }

        public zza zzai(boolean z) {
            this.zzaEC = z;
            return this;
        }

        public zza zzdB(String str) {
            this.zzwj = str;
            return this;
        }

        public zza zzdC(String str) {
            this.mName = str;
            return this;
        }

        public zza zzdD(String str) {
            this.zzanu = str;
            return this;
        }

        public zza zzdE(String str) {
            this.zzaDj = str;
            return this;
        }

        public zza zzf(float f) {
            this.zzaEs = f;
            return this;
        }

        public zza zzg(float f) {
            this.zzaEw = f;
            return this;
        }

        public zza zzhj(int i) {
            this.zzaEx = i;
            return this;
        }

        public zza zzl(Uri uri) {
            this.zzaDk = uri;
            return this;
        }

        public zza zzm(List<Integer> list) {
            this.zzaEH = list;
            return this;
        }

        public zza zzn(List<String> list) {
            this.zzaEB = list;
            return this;
        }

        public PlaceImpl zzws() {
            return new PlaceImpl(this.mVersionCode, this.zzwj, this.zzaEH, Collections.emptyList(), this.zzaEG, this.mName, this.zzanu, this.zzaDj, this.zzaEA, this.zzaEB, this.zzaDh, this.zzaEs, this.zzaEt, this.zzaEu, this.zzaDk, this.zzaEv, this.zzaEw, this.zzaEx, this.zzaEy, this.zzaEC, PlaceLocalization.zza(this.mName, this.zzanu, this.zzaDj, this.zzaEA, this.zzaEB));
        }
    }

    static {
        CREATOR = new zzk();
    }

    PlaceImpl(int versionCode, String id, List<Integer> placeTypes, List<Integer> typesDeprecated, Bundle addressComponents, String name, String address, String phoneNumber, String regularOpenHours, List<String> attributions, LatLng latlng, float levelNumber, LatLngBounds viewport, String timeZoneId, Uri websiteUri, boolean isPermanentlyClosed, float rating, int priceLevel, long timestampSecs, boolean isLoggingEnabled, PlaceLocalization localization) {
        this.mVersionCode = versionCode;
        this.zzwj = id;
        this.zzaDi = Collections.unmodifiableList(placeTypes);
        this.zzaEz = typesDeprecated;
        if (addressComponents == null) {
            addressComponents = new Bundle();
        }
        this.zzaEq = addressComponents;
        this.mName = name;
        this.zzanu = address;
        this.zzaDj = phoneNumber;
        this.zzaEA = regularOpenHours;
        if (attributions == null) {
            attributions = Collections.emptyList();
        }
        this.zzaEB = attributions;
        this.zzaDh = latlng;
        this.zzaEs = levelNumber;
        this.zzaEt = viewport;
        if (timeZoneId == null) {
            timeZoneId = "UTC";
        }
        this.zzaEu = timeZoneId;
        this.zzaDk = websiteUri;
        this.zzaEv = isPermanentlyClosed;
        this.zzaEw = rating;
        this.zzaEx = priceLevel;
        this.zzaEy = timestampSecs;
        this.zzaED = Collections.unmodifiableMap(new HashMap());
        this.zzaEE = null;
        this.zzaEk = null;
        this.zzaEC = isLoggingEnabled;
        this.zzaEr = localization;
    }

    private void zzdA(String str) {
        if (this.zzaEC && this.zzaEF != null) {
            this.zzaEF.zzC(this.zzwj, str);
        }
    }

    public int describeContents() {
        zzk com_google_android_gms_location_places_internal_zzk = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceImpl)) {
            return false;
        }
        PlaceImpl placeImpl = (PlaceImpl) object;
        return this.zzwj.equals(placeImpl.zzwj) && zzw.equal(this.zzaEk, placeImpl.zzaEk) && this.zzaEy == placeImpl.zzaEy;
    }

    public /* synthetic */ Object freeze() {
        return zzwr();
    }

    public String getAddress() {
        zzdA("getAddress");
        return this.zzanu;
    }

    public String getId() {
        zzdA("getId");
        return this.zzwj;
    }

    public LatLng getLatLng() {
        zzdA("getLatLng");
        return this.zzaDh;
    }

    public Locale getLocale() {
        zzdA("getLocale");
        return this.zzaEk;
    }

    public String getName() {
        zzdA("getName");
        return this.mName;
    }

    public String getPhoneNumber() {
        zzdA("getPhoneNumber");
        return this.zzaDj;
    }

    public List<Integer> getPlaceTypes() {
        zzdA("getPlaceTypes");
        return this.zzaDi;
    }

    public int getPriceLevel() {
        zzdA("getPriceLevel");
        return this.zzaEx;
    }

    public float getRating() {
        zzdA("getRating");
        return this.zzaEw;
    }

    public LatLngBounds getViewport() {
        zzdA("getViewport");
        return this.zzaEt;
    }

    public Uri getWebsiteUri() {
        zzdA("getWebsiteUri");
        return this.zzaDk;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzwj, this.zzaEk, Long.valueOf(this.zzaEy));
    }

    public boolean isDataValid() {
        return true;
    }

    public void setLocale(Locale locale) {
        this.zzaEk = locale;
    }

    public String toString() {
        return zzw.zzu(this).zzg("id", this.zzwj).zzg("placeTypes", this.zzaDi).zzg("locale", this.zzaEk).zzg("name", this.mName).zzg("address", this.zzanu).zzg("phoneNumber", this.zzaDj).zzg("latlng", this.zzaDh).zzg("viewport", this.zzaEt).zzg("websiteUri", this.zzaDk).zzg("isPermanentlyClosed", Boolean.valueOf(this.zzaEv)).zzg("priceLevel", Integer.valueOf(this.zzaEx)).zzg("timestampSecs", Long.valueOf(this.zzaEy)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzk com_google_android_gms_location_places_internal_zzk = CREATOR;
        zzk.zza(this, parcel, flags);
    }

    public void zza(zzo com_google_android_gms_location_places_internal_zzo) {
        this.zzaEF = com_google_android_gms_location_places_internal_zzo;
    }

    public List<Integer> zzwi() {
        zzdA("getTypesDeprecated");
        return this.zzaEz;
    }

    public float zzwj() {
        zzdA("getLevelNumber");
        return this.zzaEs;
    }

    public String zzwk() {
        zzdA("getRegularOpenHours");
        return this.zzaEA;
    }

    public List<String> zzwl() {
        zzdA("getAttributions");
        return this.zzaEB;
    }

    public boolean zzwm() {
        zzdA("isPermanentlyClosed");
        return this.zzaEv;
    }

    public long zzwn() {
        return this.zzaEy;
    }

    public Bundle zzwo() {
        return this.zzaEq;
    }

    public String zzwp() {
        return this.zzaEu;
    }

    @Deprecated
    public PlaceLocalization zzwq() {
        zzdA("getLocalization");
        return this.zzaEr;
    }

    public Place zzwr() {
        return this;
    }
}
