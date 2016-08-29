package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.Games;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzm extends zzc {
    private static final String NAMESPACE;
    private final List<zzp> zzVQ;
    private long zzXA;
    private MediaStatus zzXB;
    private final zzp zzXC;
    private final zzp zzXD;
    private final zzp zzXE;
    private final zzp zzXF;
    private final zzp zzXG;
    private final zzp zzXH;
    private final zzp zzXI;
    private final zzp zzXJ;
    private final zzp zzXK;
    private final zzp zzXL;
    private final zzp zzXM;
    private final zzp zzXN;
    private final zzp zzXO;
    private final zzp zzXP;

    static {
        NAMESPACE = zzf.zzbM("com.google.cast.media");
    }

    public zzm(String str) {
        super(NAMESPACE, "MediaControlChannel", str, 1000);
        this.zzXC = new zzp(86400000);
        this.zzXD = new zzp(86400000);
        this.zzXE = new zzp(86400000);
        this.zzXF = new zzp(86400000);
        this.zzXG = new zzp(86400000);
        this.zzXH = new zzp(86400000);
        this.zzXI = new zzp(86400000);
        this.zzXJ = new zzp(86400000);
        this.zzXK = new zzp(86400000);
        this.zzXL = new zzp(86400000);
        this.zzXM = new zzp(86400000);
        this.zzXN = new zzp(86400000);
        this.zzXO = new zzp(86400000);
        this.zzXP = new zzp(86400000);
        this.zzVQ = new ArrayList();
        this.zzVQ.add(this.zzXC);
        this.zzVQ.add(this.zzXD);
        this.zzVQ.add(this.zzXE);
        this.zzVQ.add(this.zzXF);
        this.zzVQ.add(this.zzXG);
        this.zzVQ.add(this.zzXH);
        this.zzVQ.add(this.zzXI);
        this.zzVQ.add(this.zzXJ);
        this.zzVQ.add(this.zzXK);
        this.zzVQ.add(this.zzXL);
        this.zzVQ.add(this.zzXM);
        this.zzVQ.add(this.zzXN);
        this.zzVQ.add(this.zzXO);
        this.zzVQ.add(this.zzXP);
        zzmM();
    }

    private void zza(long j, JSONObject jSONObject) throws JSONException {
        int i = 1;
        boolean zzB = this.zzXC.zzB(j);
        int i2 = (!this.zzXG.zzmO() || this.zzXG.zzB(j)) ? 0 : 1;
        if ((!this.zzXH.zzmO() || this.zzXH.zzB(j)) && (!this.zzXI.zzmO() || this.zzXI.zzB(j))) {
            i = 0;
        }
        i2 = i2 != 0 ? 2 : 0;
        if (i != 0) {
            i2 |= 1;
        }
        if (zzB || this.zzXB == null) {
            this.zzXB = new MediaStatus(jSONObject);
            this.zzXA = SystemClock.elapsedRealtime();
            i2 = 31;
        } else {
            i2 = this.zzXB.zza(jSONObject, i2);
        }
        if ((i2 & 1) != 0) {
            this.zzXA = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 2) != 0) {
            this.zzXA = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 4) != 0) {
            onMetadataUpdated();
        }
        if ((i2 & 8) != 0) {
            onQueueStatusUpdated();
        }
        if ((i2 & 16) != 0) {
            onPreloadStatusUpdated();
        }
        for (zzp zzc : this.zzVQ) {
            zzc.zzc(j, 0);
        }
    }

    private void zzmM() {
        this.zzXA = 0;
        this.zzXB = null;
        for (zzp clear : this.zzVQ) {
            clear.clear();
        }
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.zzXA == 0) {
            return 0;
        }
        double playbackRate = this.zzXB.getPlaybackRate();
        long streamPosition = this.zzXB.getStreamPosition();
        int playerState = this.zzXB.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzXA;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        elapsedRealtime = mediaInfo.getStreamDuration();
        streamPosition += (long) (((double) j) * playbackRate);
        if (elapsedRealtime <= 0 || streamPosition <= elapsedRealtime) {
            elapsedRealtime = streamPosition < 0 ? 0 : streamPosition;
        }
        return elapsedRealtime;
    }

    public MediaInfo getMediaInfo() {
        return this.zzXB == null ? null : this.zzXB.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.zzXB;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null ? mediaInfo.getStreamDuration() : 0;
    }

    protected void onMetadataUpdated() {
    }

    protected void onPreloadStatusUpdated() {
    }

    protected void onQueueStatusUpdated() {
    }

    protected void onStatusUpdated() {
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zzmu = zzmu();
        this.zzXJ.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject.put("requestId", zzmu);
            jSONObject.put("type", "GET_STATUS");
            if (this.zzXB != null) {
                jSONObject.put("mediaSessionId", this.zzXB.zzmc());
            }
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, double d, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXH.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzmc());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, int i, MediaQueueItem[] mediaQueueItemArr, int i2, Integer num, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXN.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "QUEUE_UPDATE");
            jSONObject2.put("mediaSessionId", zzmc());
            if (i != 0) {
                jSONObject2.put("currentItemId", i);
            }
            if (i2 != 0) {
                jSONObject2.put("jump", i2);
            }
            if (mediaQueueItemArr != null && mediaQueueItemArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                    jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
                }
                jSONObject2.put("items", jSONArray);
            }
            if (num != null) {
                switch (num.intValue()) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        jSONObject2.put("repeatMode", "REPEAT_OFF");
                        break;
                    case CompletionEvent.STATUS_FAILURE /*1*/:
                        jSONObject2.put("repeatMode", "REPEAT_ALL");
                        break;
                    case CompletionEvent.STATUS_CONFLICT /*2*/:
                        jSONObject2.put("repeatMode", "REPEAT_SINGLE");
                        break;
                    case CompletionEvent.STATUS_CANCELED /*3*/:
                        jSONObject2.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
                        break;
                }
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, long j, int i, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXG.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", zzmc());
            jSONObject2.put("currentTime", zzf.zzA(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXC.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.toJson());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", zzf.zzA(j));
            if (jArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < jArr.length; i++) {
                    jSONArray.put(i, jArr[i]);
                }
                jSONObject2.put("activeTrackIds", jSONArray);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, TextTrackStyle textTrackStyle) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zzmu = zzmu();
        this.zzXL.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject.put("requestId", zzmu);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.toJson());
            }
            jSONObject.put("mediaSessionId", zzmc());
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXD.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", zzmc());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, boolean z, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXI.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzmc());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, int[] iArr, int i, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXP.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "QUEUE_REORDER");
            jSONObject2.put("mediaSessionId", zzmc());
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jSONArray.put(i2, iArr[i2]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (i != 0) {
                jSONObject2.put("insertBefore", i);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, int[] iArr, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXO.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "QUEUE_REMOVE");
            jSONObject2.put("mediaSessionId", zzmc());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < iArr.length; i++) {
                jSONArray.put(i, iArr[i]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, long[] jArr) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zzmu = zzmu();
        this.zzXK.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject.put("requestId", zzmu);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", zzmc());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < jArr.length; i++) {
                jSONArray.put(i, jArr[i]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, MediaQueueItem[] mediaQueueItemArr, int i, int i2, JSONObject jSONObject) throws IOException, IllegalArgumentException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("items must not be null or empty.");
        } else if (i < 0 || i >= mediaQueueItemArr.length) {
            throw new IllegalArgumentException("Invalid startIndex: " + i);
        } else {
            JSONObject jSONObject2 = new JSONObject();
            long zzmu = zzmu();
            this.zzXC.zza(zzmu, com_google_android_gms_cast_internal_zzo);
            zzU(true);
            try {
                jSONObject2.put("requestId", zzmu);
                jSONObject2.put("type", "QUEUE_LOAD");
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                    jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
                }
                jSONObject2.put("items", jSONArray);
                switch (i2) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        jSONObject2.put("repeatMode", "REPEAT_OFF");
                        break;
                    case CompletionEvent.STATUS_FAILURE /*1*/:
                        jSONObject2.put("repeatMode", "REPEAT_ALL");
                        break;
                    case CompletionEvent.STATUS_CONFLICT /*2*/:
                        jSONObject2.put("repeatMode", "REPEAT_SINGLE");
                        break;
                    case CompletionEvent.STATUS_CANCELED /*3*/:
                        jSONObject2.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid repeat mode: " + i2);
                }
                jSONObject2.put("startIndex", i);
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException e) {
            }
            zza(jSONObject2.toString(), zzmu, null);
            return zzmu;
        }
    }

    public long zza(zzo com_google_android_gms_cast_internal_zzo, MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalStateException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXM.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "QUEUE_INSERT");
            jSONObject2.put("mediaSessionId", zzmc());
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < mediaQueueItemArr.length; i2++) {
                jSONArray.put(i2, mediaQueueItemArr[i2].toJson());
            }
            jSONObject2.put("items", jSONArray);
            if (i != 0) {
                jSONObject2.put("insertBefore", i);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zzb(zzo com_google_android_gms_cast_internal_zzo, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXF.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", zzmc());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public void zzb(long j, int i) {
        for (zzp zzc : this.zzVQ) {
            zzc.zzc(j, i);
        }
    }

    public final void zzbJ(String str) {
        this.zzWK.zzb("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray(Games.EXTRA_STATUS);
                if (jSONArray.length() > 0) {
                    zza(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.zzXB = null;
                onStatusUpdated();
                onMetadataUpdated();
                onQueueStatusUpdated();
                onPreloadStatusUpdated();
                this.zzXJ.zzc(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.zzWK.zzf("received unexpected error: Invalid Player State.", new Object[0]);
                r1 = jSONObject.optJSONObject("customData");
                for (zzp zzc : this.zzVQ) {
                    zzc.zzc(optLong, RemoteMediaPlayer.STATUS_FAILED, r1);
                }
            } else if (string.equals("LOAD_FAILED")) {
                this.zzXC.zzc(optLong, RemoteMediaPlayer.STATUS_FAILED, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.zzXC.zzc(optLong, RemoteMediaPlayer.STATUS_CANCELED, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.zzWK.zzf("received unexpected error: Invalid Request.", new Object[0]);
                r1 = jSONObject.optJSONObject("customData");
                for (zzp zzc2 : this.zzVQ) {
                    zzc2.zzc(optLong, RemoteMediaPlayer.STATUS_FAILED, r1);
                }
            }
        } catch (JSONException e) {
            this.zzWK.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    public long zzc(zzo com_google_android_gms_cast_internal_zzo, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXE.zza(zzmu, com_google_android_gms_cast_internal_zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", zzmc());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zzmc() throws IllegalStateException {
        if (this.zzXB != null) {
            return this.zzXB.zzmc();
        }
        throw new IllegalStateException("No current media session");
    }

    public void zzmt() {
        super.zzmt();
        zzmM();
    }

    protected boolean zzz(long j) {
        boolean z;
        for (zzp zzd : this.zzVQ) {
            zzd.zzd(j, RemoteMediaPlayer.STATUS_TIMED_OUT);
        }
        synchronized (zzp.zzXT) {
            for (zzp zzd2 : this.zzVQ) {
                if (zzd2.zzmO()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }
}
