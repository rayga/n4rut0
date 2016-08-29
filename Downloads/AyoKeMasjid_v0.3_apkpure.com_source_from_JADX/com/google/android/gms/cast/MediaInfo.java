package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzls;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    private final String zzUe;
    private int zzUf;
    private String zzUg;
    private MediaMetadata zzUh;
    private long zzUi;
    private List<MediaTrack> zzUj;
    private TextTrackStyle zzUk;
    private JSONObject zzUl;

    public static class Builder {
        private final MediaInfo zzUm;

        public Builder(String contentId) throws IllegalArgumentException {
            if (TextUtils.isEmpty(contentId)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.zzUm = new MediaInfo(contentId);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.zzUm.zzma();
            return this.zzUm;
        }

        public Builder setContentType(String contentType) throws IllegalArgumentException {
            this.zzUm.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzUm.setCustomData(customData);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> mediaTracks) {
            this.zzUm.zzj(mediaTracks);
            return this;
        }

        public Builder setMetadata(MediaMetadata metadata) {
            this.zzUm.zza(metadata);
            return this;
        }

        public Builder setStreamDuration(long duration) throws IllegalArgumentException {
            this.zzUm.zzx(duration);
            return this;
        }

        public Builder setStreamType(int streamType) throws IllegalArgumentException {
            this.zzUm.setStreamType(streamType);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zzUm.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String contentId) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentId)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.zzUe = contentId;
        this.zzUf = STREAM_TYPE_INVALID;
        this.zzUi = UNKNOWN_DURATION;
    }

    MediaInfo(JSONObject json) throws JSONException {
        int i = STREAM_TYPE_NONE;
        this.zzUe = json.getString("contentId");
        String string = json.getString("streamType");
        if ("NONE".equals(string)) {
            this.zzUf = STREAM_TYPE_NONE;
        } else if ("BUFFERED".equals(string)) {
            this.zzUf = STREAM_TYPE_BUFFERED;
        } else if ("LIVE".equals(string)) {
            this.zzUf = STREAM_TYPE_LIVE;
        } else {
            this.zzUf = STREAM_TYPE_INVALID;
        }
        this.zzUg = json.getString("contentType");
        if (json.has("metadata")) {
            JSONObject jSONObject = json.getJSONObject("metadata");
            this.zzUh = new MediaMetadata(jSONObject.getInt("metadataType"));
            this.zzUh.zzf(jSONObject);
        }
        this.zzUi = UNKNOWN_DURATION;
        if (json.has("duration") && !json.isNull("duration")) {
            double optDouble = json.optDouble("duration", 0.0d);
            if (!(Double.isNaN(optDouble) || Double.isInfinite(optDouble))) {
                this.zzUi = zzf.zzf(optDouble);
            }
        }
        if (json.has("tracks")) {
            this.zzUj = new ArrayList();
            JSONArray jSONArray = json.getJSONArray("tracks");
            while (i < jSONArray.length()) {
                this.zzUj.add(new MediaTrack(jSONArray.getJSONObject(i)));
                i += STREAM_TYPE_BUFFERED;
            }
        } else {
            this.zzUj = null;
        }
        if (json.has("textTrackStyle")) {
            JSONObject jSONObject2 = json.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.zzf(jSONObject2);
            this.zzUk = textTrackStyle;
        } else {
            this.zzUk = null;
        }
        this.zzUl = json.optJSONObject("customData");
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if ((this.zzUl == null ? STREAM_TYPE_BUFFERED : false) != (mediaInfo.zzUl == null ? STREAM_TYPE_BUFFERED : false)) {
            return false;
        }
        if (this.zzUl != null && mediaInfo.zzUl != null && !zzls.zzd(this.zzUl, mediaInfo.zzUl)) {
            return false;
        }
        if (!(zzf.zza(this.zzUe, mediaInfo.zzUe) && this.zzUf == mediaInfo.zzUf && zzf.zza(this.zzUg, mediaInfo.zzUg) && zzf.zza(this.zzUh, mediaInfo.zzUh) && this.zzUi == mediaInfo.zzUi)) {
            z = false;
        }
        return z;
    }

    public String getContentId() {
        return this.zzUe;
    }

    public String getContentType() {
        return this.zzUg;
    }

    public JSONObject getCustomData() {
        return this.zzUl;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.zzUj;
    }

    public MediaMetadata getMetadata() {
        return this.zzUh;
    }

    public long getStreamDuration() {
        return this.zzUi;
    }

    public int getStreamType() {
        return this.zzUf;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzUk;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUe, Integer.valueOf(this.zzUf), this.zzUg, this.zzUh, Long.valueOf(this.zzUi), String.valueOf(this.zzUl));
    }

    void setContentType(String contentType) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentType)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.zzUg = contentType;
    }

    void setCustomData(JSONObject customData) {
        this.zzUl = customData;
    }

    void setStreamType(int streamType) throws IllegalArgumentException {
        if (streamType < STREAM_TYPE_INVALID || streamType > STREAM_TYPE_LIVE) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.zzUf = streamType;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzUk = textTrackStyle;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj;
            jSONObject.put("contentId", this.zzUe);
            switch (this.zzUf) {
                case STREAM_TYPE_BUFFERED /*1*/:
                    obj = "BUFFERED";
                    break;
                case STREAM_TYPE_LIVE /*2*/:
                    obj = "LIVE";
                    break;
                default:
                    obj = "NONE";
                    break;
            }
            jSONObject.put("streamType", obj);
            if (this.zzUg != null) {
                jSONObject.put("contentType", this.zzUg);
            }
            if (this.zzUh != null) {
                jSONObject.put("metadata", this.zzUh.toJson());
            }
            if (this.zzUi <= UNKNOWN_DURATION) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", zzf.zzA(this.zzUi));
            }
            if (this.zzUj != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack toJson : this.zzUj) {
                    jSONArray.put(toJson.toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.zzUk != null) {
                jSONObject.put("textTrackStyle", this.zzUk.toJson());
            }
            if (this.zzUl != null) {
                jSONObject.put("customData", this.zzUl);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zza(MediaMetadata mediaMetadata) {
        this.zzUh = mediaMetadata;
    }

    void zzj(List<MediaTrack> list) {
        this.zzUj = list;
    }

    void zzma() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.zzUe)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.zzUg)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.zzUf == STREAM_TYPE_INVALID) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    void zzx(long j) throws IllegalArgumentException {
        if (j >= 0 || j == UNKNOWN_DURATION) {
            this.zzUi = j;
            return;
        }
        throw new IllegalArgumentException("Invalid stream duration");
    }
}
