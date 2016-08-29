package com.google.android.gms.cast;

import android.util.SparseArray;
import com.google.android.gms.cast.internal.zzf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int REPEAT_MODE_REPEAT_ALL = 1;
    public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
    public static final int REPEAT_MODE_REPEAT_OFF = 0;
    public static final int REPEAT_MODE_REPEAT_SINGLE = 2;
    private long[] zzUA;
    private int zzUC;
    private long zzUD;
    private double zzUE;
    private int zzUF;
    private int zzUG;
    private long zzUH;
    private long zzUI;
    private double zzUJ;
    private boolean zzUK;
    private int zzUL;
    private int zzUM;
    private final zza zzUN;
    private JSONObject zzUl;
    private MediaInfo zzUm;

    private class zza {
        private int zzUO;
        private List<MediaQueueItem> zzUP;
        private SparseArray<Integer> zzUQ;
        final /* synthetic */ MediaStatus zzUR;

        zza(MediaStatus mediaStatus) {
            this.zzUR = mediaStatus;
            this.zzUO = MediaStatus.REPEAT_MODE_REPEAT_OFF;
            this.zzUP = new ArrayList();
            this.zzUQ = new SparseArray();
        }

        private void clear() {
            this.zzUO = MediaStatus.REPEAT_MODE_REPEAT_OFF;
            this.zzUP.clear();
            this.zzUQ.clear();
        }

        private void zza(MediaQueueItem[] mediaQueueItemArr) {
            this.zzUP.clear();
            this.zzUQ.clear();
            for (int i = MediaStatus.REPEAT_MODE_REPEAT_OFF; i < mediaQueueItemArr.length; i += MediaStatus.REPEAT_MODE_REPEAT_ALL) {
                MediaQueueItem mediaQueueItem = mediaQueueItemArr[i];
                this.zzUP.add(mediaQueueItem);
                this.zzUQ.put(mediaQueueItem.getItemId(), Integer.valueOf(i));
            }
        }

        private Integer zzaN(int i) {
            return (Integer) this.zzUQ.get(i);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean zzg(org.json.JSONObject r11) throws org.json.JSONException {
            /*
            r10 = this;
            r3 = 3;
            r0 = 2;
            r1 = 0;
            r2 = 1;
            r4 = "repeatMode";
            r4 = r11.has(r4);
            if (r4 == 0) goto L_0x00f7;
        L_0x000c:
            r4 = r10.zzUO;
            r5 = "repeatMode";
            r6 = r11.getString(r5);
            r5 = -1;
            r7 = r6.hashCode();
            switch(r7) {
                case -1118317585: goto L_0x0073;
                case -962896020: goto L_0x0069;
                case 1645938909: goto L_0x005f;
                case 1645952171: goto L_0x0055;
                default: goto L_0x001c;
            };
        L_0x001c:
            switch(r5) {
                case 0: goto L_0x007d;
                case 1: goto L_0x007f;
                case 2: goto L_0x0020;
                case 3: goto L_0x0081;
                default: goto L_0x001f;
            };
        L_0x001f:
            r0 = r4;
        L_0x0020:
            r3 = r10.zzUO;
            if (r3 == r0) goto L_0x00f7;
        L_0x0024:
            r10.zzUO = r0;
            r0 = r2;
        L_0x0027:
            r3 = "items";
            r3 = r11.has(r3);
            if (r3 == 0) goto L_0x00f5;
        L_0x002f:
            r3 = "items";
            r4 = r11.getJSONArray(r3);
            r5 = r4.length();
            r6 = new android.util.SparseArray;
            r6.<init>();
            r3 = r1;
        L_0x003f:
            if (r3 >= r5) goto L_0x0083;
        L_0x0041:
            r7 = r4.getJSONObject(r3);
            r8 = "itemId";
            r7 = r7.getInt(r8);
            r7 = java.lang.Integer.valueOf(r7);
            r6.put(r3, r7);
            r3 = r3 + 1;
            goto L_0x003f;
        L_0x0055:
            r7 = "REPEAT_OFF";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x005d:
            r5 = r1;
            goto L_0x001c;
        L_0x005f:
            r7 = "REPEAT_ALL";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x0067:
            r5 = r2;
            goto L_0x001c;
        L_0x0069:
            r7 = "REPEAT_SINGLE";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x0071:
            r5 = r0;
            goto L_0x001c;
        L_0x0073:
            r7 = "REPEAT_ALL_AND_SHUFFLE";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x001c;
        L_0x007b:
            r5 = r3;
            goto L_0x001c;
        L_0x007d:
            r0 = r1;
            goto L_0x0020;
        L_0x007f:
            r0 = r2;
            goto L_0x0020;
        L_0x0081:
            r0 = r3;
            goto L_0x0020;
        L_0x0083:
            r7 = new com.google.android.gms.cast.MediaQueueItem[r5];
            r3 = r1;
            r1 = r0;
        L_0x0087:
            if (r3 >= r5) goto L_0x00e5;
        L_0x0089:
            r0 = r6.get(r3);
            r0 = (java.lang.Integer) r0;
            r8 = r4.getJSONObject(r3);
            r9 = r0.intValue();
            r9 = r10.zzaL(r9);
            if (r9 == 0) goto L_0x00b8;
        L_0x009d:
            r8 = r9.zzg(r8);
            r1 = r1 | r8;
            r7[r3] = r9;
            r0 = r0.intValue();
            r0 = r10.zzaN(r0);
            r0 = r0.intValue();
            if (r3 == r0) goto L_0x00f3;
        L_0x00b2:
            r0 = r2;
        L_0x00b3:
            r1 = r3 + 1;
            r3 = r1;
            r1 = r0;
            goto L_0x0087;
        L_0x00b8:
            r0 = r0.intValue();
            r1 = r10.zzUR;
            r1 = r1.zzUC;
            if (r0 != r1) goto L_0x00dc;
        L_0x00c4:
            r0 = new com.google.android.gms.cast.MediaQueueItem$Builder;
            r1 = r10.zzUR;
            r1 = r1.zzUm;
            r0.<init>(r1);
            r0 = r0.build();
            r7[r3] = r0;
            r0 = r7[r3];
            r0.zzg(r8);
            r0 = r2;
            goto L_0x00b3;
        L_0x00dc:
            r0 = new com.google.android.gms.cast.MediaQueueItem;
            r0.<init>(r8);
            r7[r3] = r0;
            r0 = r2;
            goto L_0x00b3;
        L_0x00e5:
            r0 = r10.zzUP;
            r0 = r0.size();
            if (r0 == r5) goto L_0x00f1;
        L_0x00ed:
            r10.zza(r7);
        L_0x00f0:
            return r2;
        L_0x00f1:
            r2 = r1;
            goto L_0x00ed;
        L_0x00f3:
            r0 = r1;
            goto L_0x00b3;
        L_0x00f5:
            r2 = r0;
            goto L_0x00f0;
        L_0x00f7:
            r0 = r1;
            goto L_0x0027;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.zza.zzg(org.json.JSONObject):boolean");
        }

        public int getItemCount() {
            return this.zzUP.size();
        }

        public int getRepeatMode() {
            return this.zzUO;
        }

        public MediaQueueItem zzaL(int i) {
            Integer num = (Integer) this.zzUQ.get(i);
            return num == null ? null : (MediaQueueItem) this.zzUP.get(num.intValue());
        }

        public MediaQueueItem zzaM(int i) {
            return (i < 0 || i >= this.zzUP.size()) ? null : (MediaQueueItem) this.zzUP.get(i);
        }

        public List<MediaQueueItem> zzmd() {
            return Collections.unmodifiableList(this.zzUP);
        }
    }

    public MediaStatus(JSONObject json) throws JSONException {
        this.zzUC = REPEAT_MODE_REPEAT_OFF;
        this.zzUL = REPEAT_MODE_REPEAT_OFF;
        this.zzUM = REPEAT_MODE_REPEAT_OFF;
        this.zzUN = new zza(this);
        zza(json, REPEAT_MODE_REPEAT_OFF);
    }

    private boolean zzi(int i, int i2) {
        return i == REPEAT_MODE_REPEAT_ALL && i2 == 0;
    }

    public long[] getActiveTrackIds() {
        return this.zzUA;
    }

    public int getCurrentItemId() {
        return this.zzUC;
    }

    public JSONObject getCustomData() {
        return this.zzUl;
    }

    public int getIdleReason() {
        return this.zzUG;
    }

    public int getLoadingItemId() {
        return this.zzUL;
    }

    public MediaInfo getMediaInfo() {
        return this.zzUm;
    }

    public double getPlaybackRate() {
        return this.zzUE;
    }

    public int getPlayerState() {
        return this.zzUF;
    }

    public int getPreloadedItemId() {
        return this.zzUM;
    }

    public MediaQueueItem getQueueItem(int index) {
        return this.zzUN.zzaM(index);
    }

    public MediaQueueItem getQueueItemById(int itemId) {
        return this.zzUN.zzaL(itemId);
    }

    public int getQueueItemCount() {
        return this.zzUN.getItemCount();
    }

    public List<MediaQueueItem> getQueueItems() {
        return this.zzUN.zzmd();
    }

    public int getQueueRepeatMode() {
        return this.zzUN.getRepeatMode();
    }

    public long getStreamPosition() {
        return this.zzUH;
    }

    public double getStreamVolume() {
        return this.zzUJ;
    }

    public boolean isMediaCommandSupported(long mediaCommand) {
        return (this.zzUI & mediaCommand) != 0;
    }

    public boolean isMute() {
        return this.zzUK;
    }

    public int zza(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        int i3;
        double d;
        long zzf;
        long[] jArr;
        int i4 = REPEAT_MODE_REPEAT_SINGLE;
        int i5 = REPEAT_MODE_REPEAT_ALL;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.zzUD) {
            this.zzUD = j;
            i2 = REPEAT_MODE_REPEAT_ALL;
        } else {
            i2 = REPEAT_MODE_REPEAT_OFF;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            i3 = string.equals("IDLE") ? REPEAT_MODE_REPEAT_ALL : string.equals("PLAYING") ? REPEAT_MODE_REPEAT_SINGLE : string.equals("PAUSED") ? REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE : string.equals("BUFFERING") ? PLAYER_STATE_BUFFERING : REPEAT_MODE_REPEAT_OFF;
            if (i3 != this.zzUF) {
                this.zzUF = i3;
                i2 |= REPEAT_MODE_REPEAT_SINGLE;
            }
            if (i3 == REPEAT_MODE_REPEAT_ALL && jSONObject.has("idleReason")) {
                string = jSONObject.getString("idleReason");
                if (!string.equals("CANCELLED")) {
                    i4 = string.equals("INTERRUPTED") ? REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE : string.equals("FINISHED") ? REPEAT_MODE_REPEAT_ALL : string.equals("ERROR") ? PLAYER_STATE_BUFFERING : REPEAT_MODE_REPEAT_OFF;
                }
                if (i4 != this.zzUG) {
                    this.zzUG = i4;
                    i2 |= REPEAT_MODE_REPEAT_SINGLE;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            d = jSONObject.getDouble("playbackRate");
            if (this.zzUE != d) {
                this.zzUE = d;
                i2 |= REPEAT_MODE_REPEAT_SINGLE;
            }
        }
        if (jSONObject.has("currentTime") && (i & REPEAT_MODE_REPEAT_SINGLE) == 0) {
            zzf = zzf.zzf(jSONObject.getDouble("currentTime"));
            if (zzf != this.zzUH) {
                this.zzUH = zzf;
                i2 |= REPEAT_MODE_REPEAT_SINGLE;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            zzf = jSONObject.getLong("supportedMediaCommands");
            if (zzf != this.zzUI) {
                this.zzUI = zzf;
                i2 |= REPEAT_MODE_REPEAT_SINGLE;
            }
        }
        if (jSONObject.has(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME) && (i & REPEAT_MODE_REPEAT_ALL) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME);
            d = jSONObject2.getDouble("level");
            if (d != this.zzUJ) {
                this.zzUJ = d;
                i2 |= REPEAT_MODE_REPEAT_SINGLE;
            }
            boolean z = jSONObject2.getBoolean("muted");
            if (z != this.zzUK) {
                this.zzUK = z;
                i2 |= REPEAT_MODE_REPEAT_SINGLE;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (i4 = REPEAT_MODE_REPEAT_OFF; i4 < length; i4 += REPEAT_MODE_REPEAT_ALL) {
                jArr2[i4] = jSONArray.getLong(i4);
            }
            if (this.zzUA != null && this.zzUA.length == length) {
                for (i4 = REPEAT_MODE_REPEAT_OFF; i4 < length; i4 += REPEAT_MODE_REPEAT_ALL) {
                    if (this.zzUA[i4] != jArr2[i4]) {
                        break;
                    }
                }
                i5 = REPEAT_MODE_REPEAT_OFF;
            }
            if (i5 != 0) {
                this.zzUA = jArr2;
            }
            long[] jArr3 = jArr2;
            i3 = i5;
            jArr = jArr3;
        } else if (this.zzUA != null) {
            i3 = REPEAT_MODE_REPEAT_ALL;
            jArr = null;
        } else {
            jArr = null;
            i3 = REPEAT_MODE_REPEAT_OFF;
        }
        if (i3 != 0) {
            this.zzUA = jArr;
            i2 |= REPEAT_MODE_REPEAT_SINGLE;
        }
        if (jSONObject.has("customData")) {
            this.zzUl = jSONObject.getJSONObject("customData");
            i2 |= REPEAT_MODE_REPEAT_SINGLE;
        }
        if (jSONObject.has("media")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("media");
            this.zzUm = new MediaInfo(jSONObject3);
            i2 |= REPEAT_MODE_REPEAT_SINGLE;
            if (jSONObject3.has("metadata")) {
                i2 |= PLAYER_STATE_BUFFERING;
            }
        }
        if (jSONObject.has("currentItemId")) {
            i5 = jSONObject.getInt("currentItemId");
            if (this.zzUC != i5) {
                this.zzUC = i5;
                i2 |= REPEAT_MODE_REPEAT_SINGLE;
            }
        }
        i5 = jSONObject.optInt("preloadedItemId", REPEAT_MODE_REPEAT_OFF);
        if (this.zzUM != i5) {
            this.zzUM = i5;
            i2 |= 16;
        }
        i5 = jSONObject.optInt("loadingItemId", REPEAT_MODE_REPEAT_OFF);
        if (this.zzUL != i5) {
            this.zzUL = i5;
            i2 |= REPEAT_MODE_REPEAT_SINGLE;
        }
        if (!zzi(this.zzUF, this.zzUL)) {
            return this.zzUN.zzg(jSONObject) ? i2 | 8 : i2;
        } else {
            this.zzUC = REPEAT_MODE_REPEAT_OFF;
            this.zzUL = REPEAT_MODE_REPEAT_OFF;
            this.zzUM = REPEAT_MODE_REPEAT_OFF;
            if (this.zzUN.getItemCount() <= 0) {
                return i2;
            }
            this.zzUN.clear();
            return i2 | 8;
        }
    }

    public long zzmc() {
        return this.zzUD;
    }
}
