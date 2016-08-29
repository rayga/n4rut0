package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzls;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaQueueItem {
    public static final double DEFAULT_PLAYBACK_DURATION = Double.POSITIVE_INFINITY;
    public static final int INVALID_ITEM_ID = 0;
    private long[] zzUA;
    private JSONObject zzUl;
    private MediaInfo zzUu;
    private int zzUv;
    private boolean zzUw;
    private double zzUx;
    private double zzUy;
    private double zzUz;

    public static class Builder {
        private final MediaQueueItem zzUB;

        public Builder(MediaInfo media) throws IllegalArgumentException {
            this.zzUB = new MediaQueueItem(null);
        }

        public Builder(MediaQueueItem item) throws IllegalArgumentException {
            this.zzUB = new MediaQueueItem(null);
        }

        public Builder(JSONObject json) throws JSONException {
            this.zzUB = new MediaQueueItem(json);
        }

        public MediaQueueItem build() {
            this.zzUB.zzma();
            return this.zzUB;
        }

        public Builder clearItemId() {
            this.zzUB.zzaK(0);
            return this;
        }

        public Builder setActiveTrackIds(long[] activeTrackIds) {
            this.zzUB.zza(activeTrackIds);
            return this;
        }

        public Builder setAutoplay(boolean autoplay) {
            this.zzUB.zzT(autoplay);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzUB.setCustomData(customData);
            return this;
        }

        public Builder setPreloadTime(double preloadTime) throws IllegalArgumentException {
            this.zzUB.zzd(preloadTime);
            return this;
        }

        public Builder setStartTime(double startTime) throws IllegalArgumentException {
            this.zzUB.zzc(startTime);
            return this;
        }
    }

    private MediaQueueItem(MediaInfo media) throws IllegalArgumentException {
        this.zzUv = 0;
        this.zzUw = true;
        this.zzUy = DEFAULT_PLAYBACK_DURATION;
        if (media == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzUu = media;
    }

    private MediaQueueItem(MediaQueueItem item) throws IllegalArgumentException {
        this.zzUv = 0;
        this.zzUw = true;
        this.zzUy = DEFAULT_PLAYBACK_DURATION;
        this.zzUu = item.getMedia();
        if (this.zzUu == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzUv = item.getItemId();
        this.zzUw = item.getAutoplay();
        this.zzUx = item.getStartTime();
        this.zzUy = item.zzmb();
        this.zzUz = item.getPreloadTime();
        this.zzUA = item.getActiveTrackIds();
        this.zzUl = item.getCustomData();
    }

    MediaQueueItem(JSONObject json) throws JSONException {
        this.zzUv = 0;
        this.zzUw = true;
        this.zzUy = DEFAULT_PLAYBACK_DURATION;
        zzg(json);
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) other;
        if ((this.zzUl == null) != (mediaQueueItem.zzUl == null)) {
            return false;
        }
        if (this.zzUl != null && mediaQueueItem.zzUl != null && !zzls.zzd(this.zzUl, mediaQueueItem.zzUl)) {
            return false;
        }
        if (!(zzf.zza(this.zzUu, mediaQueueItem.zzUu) && this.zzUv == mediaQueueItem.zzUv && this.zzUw == mediaQueueItem.zzUw && this.zzUx == mediaQueueItem.zzUx && this.zzUy == mediaQueueItem.zzUy && this.zzUz == mediaQueueItem.zzUz && zzf.zza(this.zzUA, mediaQueueItem.zzUA))) {
            z = false;
        }
        return z;
    }

    public long[] getActiveTrackIds() {
        return this.zzUA;
    }

    public boolean getAutoplay() {
        return this.zzUw;
    }

    public JSONObject getCustomData() {
        return this.zzUl;
    }

    public int getItemId() {
        return this.zzUv;
    }

    public MediaInfo getMedia() {
        return this.zzUu;
    }

    public double getPreloadTime() {
        return this.zzUz;
    }

    public double getStartTime() {
        return this.zzUx;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUu, Integer.valueOf(this.zzUv), Boolean.valueOf(this.zzUw), Double.valueOf(this.zzUx), Double.valueOf(this.zzUy), Double.valueOf(this.zzUz), this.zzUA, String.valueOf(this.zzUl));
    }

    void setCustomData(JSONObject customData) {
        this.zzUl = customData;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("media", this.zzUu.toJson());
            if (this.zzUv != 0) {
                jSONObject.put("itemId", this.zzUv);
            }
            jSONObject.put("autoplay", this.zzUw);
            jSONObject.put("startTime", this.zzUx);
            if (this.zzUy != DEFAULT_PLAYBACK_DURATION) {
                jSONObject.put("playbackDuration", this.zzUy);
            }
            jSONObject.put("preloadTime", this.zzUz);
            if (this.zzUA != null && this.zzUA.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (long put : this.zzUA) {
                    jSONArray.put(put);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            if (this.zzUl != null) {
                jSONObject.put("customData", this.zzUl);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zzT(boolean z) {
        this.zzUw = z;
    }

    void zza(long[] jArr) {
        this.zzUA = jArr;
    }

    void zzaK(int i) {
        this.zzUv = i;
    }

    void zzc(double d) throws IllegalArgumentException {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        this.zzUx = d;
    }

    void zzd(double d) throws IllegalArgumentException {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
        }
        this.zzUz = d;
    }

    public boolean zzg(JSONObject jSONObject) throws JSONException {
        boolean z;
        boolean z2;
        double d;
        long[] jArr;
        if (jSONObject.has("media")) {
            this.zzUu = new MediaInfo(jSONObject.getJSONObject("media"));
            z = true;
        } else {
            z = false;
        }
        if (jSONObject.has("itemId")) {
            int i = jSONObject.getInt("itemId");
            if (this.zzUv != i) {
                this.zzUv = i;
                z = true;
            }
        }
        if (jSONObject.has("autoplay")) {
            z2 = jSONObject.getBoolean("autoplay");
            if (this.zzUw != z2) {
                this.zzUw = z2;
                z = true;
            }
        }
        if (jSONObject.has("startTime")) {
            d = jSONObject.getDouble("startTime");
            if (Math.abs(d - this.zzUx) > 1.0E-7d) {
                this.zzUx = d;
                z = true;
            }
        }
        if (jSONObject.has("playbackDuration")) {
            d = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d - this.zzUy) > 1.0E-7d) {
                this.zzUy = d;
                z = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            d = jSONObject.getDouble("preloadTime");
            if (Math.abs(d - this.zzUz) > 1.0E-7d) {
                this.zzUz = d;
                z = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            int i2;
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (i2 = 0; i2 < length; i2++) {
                jArr2[i2] = jSONArray.getLong(i2);
            }
            if (this.zzUA == null) {
                jArr = jArr2;
                z2 = true;
            } else if (this.zzUA.length != length) {
                jArr = jArr2;
                z2 = true;
            } else {
                for (i2 = 0; i2 < length; i2++) {
                    if (this.zzUA[i2] != jArr2[i2]) {
                        jArr = jArr2;
                        z2 = true;
                        break;
                    }
                }
                long[] jArr3 = jArr2;
                z2 = false;
                jArr = jArr3;
            }
        } else {
            z2 = false;
            jArr = null;
        }
        if (z2) {
            this.zzUA = jArr;
            z = true;
        }
        if (!jSONObject.has("customData")) {
            return z;
        }
        this.zzUl = jSONObject.getJSONObject("customData");
        return true;
    }

    void zzma() throws IllegalArgumentException {
        if (this.zzUu == null) {
            throw new IllegalArgumentException("media cannot be null.");
        } else if (Double.isNaN(this.zzUx) || this.zzUx < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        } else if (Double.isNaN(this.zzUy)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        } else if (Double.isNaN(this.zzUz) || this.zzUz < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }

    public double zzmb() {
        return this.zzUy;
    }
}
