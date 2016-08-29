package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.client.zzx.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final int zzJN;
    private final int zzJO;
    private final int zzJP;
    private final int zzJQ;
    private final int zzJR;
    private final int zzJS;
    private final int zzJT;
    private final String zzJU;
    private final int zzJV;
    private final String zzJW;
    private final int zzJX;
    private final int zzJY;
    private final String zzJZ;
    private final zzx zznN;
    private final int zzvF;

    public static final class Builder {
        private int zzJN;
        private int zzJO;
        private int zzJP;
        private int zzJQ;
        private int zzJR;
        private int zzJS;
        private int zzJT;
        private String zzJU;
        private int zzJV;
        private String zzJW;
        private int zzJX;
        private int zzJY;
        private String zzJZ;
        private final zza zznO;
        private int zzvF;

        public Builder() {
            this.zznO = new zza();
            this.zzJS = SearchAdRequest.ERROR_CODE_INTERNAL_ERROR;
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.zznO.zzb((Class) adapterClass, customEventExtras);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zznO.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.zznO.zza(adapterClass, networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.zznO.zzG(deviceId);
            return this;
        }

        public SearchAdRequest build() {
            return new SearchAdRequest();
        }

        public Builder setAnchorTextColor(int anchorTextColor) {
            this.zzJN = anchorTextColor;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.zzvF = backgroundColor;
            this.zzJO = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            this.zzJP = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            return this;
        }

        public Builder setBackgroundGradient(int top, int bottom) {
            this.zzvF = Color.argb(SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR, SearchAdRequest.ERROR_CODE_INTERNAL_ERROR);
            this.zzJO = bottom;
            this.zzJP = top;
            return this;
        }

        public Builder setBorderColor(int borderColor) {
            this.zzJQ = borderColor;
            return this;
        }

        public Builder setBorderThickness(int borderThickness) {
            this.zzJR = borderThickness;
            return this;
        }

        public Builder setBorderType(int borderType) {
            this.zzJS = borderType;
            return this;
        }

        public Builder setCallButtonColor(int callButtonColor) {
            this.zzJT = callButtonColor;
            return this;
        }

        public Builder setCustomChannels(String channelIds) {
            this.zzJU = channelIds;
            return this;
        }

        public Builder setDescriptionTextColor(int descriptionTextColor) {
            this.zzJV = descriptionTextColor;
            return this;
        }

        public Builder setFontFace(String fontFace) {
            this.zzJW = fontFace;
            return this;
        }

        public Builder setHeaderTextColor(int headerTextColor) {
            this.zzJX = headerTextColor;
            return this;
        }

        public Builder setHeaderTextSize(int headerTextSize) {
            this.zzJY = headerTextSize;
            return this;
        }

        public Builder setLocation(Location location) {
            this.zznO.zza(location);
            return this;
        }

        public Builder setQuery(String query) {
            this.zzJZ = query;
            return this;
        }

        public Builder setRequestAgent(String requestAgent) {
            this.zznO.zzK(requestAgent);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.zznO.zzj(tagForChildDirectedTreatment);
            return this;
        }
    }

    static {
        DEVICE_ID_EMULATOR = zzx.DEVICE_ID_EMULATOR;
    }

    private SearchAdRequest(Builder builder) {
        this.zzJN = builder.zzJN;
        this.zzvF = builder.zzvF;
        this.zzJO = builder.zzJO;
        this.zzJP = builder.zzJP;
        this.zzJQ = builder.zzJQ;
        this.zzJR = builder.zzJR;
        this.zzJS = builder.zzJS;
        this.zzJT = builder.zzJT;
        this.zzJU = builder.zzJU;
        this.zzJV = builder.zzJV;
        this.zzJW = builder.zzJW;
        this.zzJX = builder.zzJX;
        this.zzJY = builder.zzJY;
        this.zzJZ = builder.zzJZ;
        this.zznN = new zzx(builder.zznO, this);
    }

    public int getAnchorTextColor() {
        return this.zzJN;
    }

    public int getBackgroundColor() {
        return this.zzvF;
    }

    public int getBackgroundGradientBottom() {
        return this.zzJO;
    }

    public int getBackgroundGradientTop() {
        return this.zzJP;
    }

    public int getBorderColor() {
        return this.zzJQ;
    }

    public int getBorderThickness() {
        return this.zzJR;
    }

    public int getBorderType() {
        return this.zzJS;
    }

    public int getCallButtonColor() {
        return this.zzJT;
    }

    public String getCustomChannels() {
        return this.zzJU;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.zznN.getCustomEventExtrasBundle(adapterClass);
    }

    public int getDescriptionTextColor() {
        return this.zzJV;
    }

    public String getFontFace() {
        return this.zzJW;
    }

    public int getHeaderTextColor() {
        return this.zzJX;
    }

    public int getHeaderTextSize() {
        return this.zzJY;
    }

    public Location getLocation() {
        return this.zznN.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.zznN.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.zznN.getNetworkExtrasBundle(adapterClass);
    }

    public String getQuery() {
        return this.zzJZ;
    }

    public boolean isTestDevice(Context context) {
        return this.zznN.isTestDevice(context);
    }

    zzx zzaF() {
        return this.zznN;
    }
}
