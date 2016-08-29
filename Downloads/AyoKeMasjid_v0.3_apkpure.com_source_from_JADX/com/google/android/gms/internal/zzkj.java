package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzf;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzkj {
    private final int zzUF;
    private final JSONObject zzWD;
    private final String zzWn;

    public zzkj(String str, int i, JSONObject jSONObject) {
        this.zzWn = str;
        this.zzUF = i;
        this.zzWD = jSONObject;
    }

    public zzkj(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("playerId"), jSONObject.optInt("playerState"), jSONObject.optJSONObject("playerData"));
    }

    public boolean equals(Object otherObj) {
        if (otherObj == null || !(otherObj instanceof zzkj)) {
            return false;
        }
        zzkj com_google_android_gms_internal_zzkj = (zzkj) otherObj;
        return this.zzUF == com_google_android_gms_internal_zzkj.getPlayerState() && zzf.zza(this.zzWn, com_google_android_gms_internal_zzkj.getPlayerId()) && zzls.zzd(this.zzWD, com_google_android_gms_internal_zzkj.getPlayerData());
    }

    public JSONObject getPlayerData() {
        return this.zzWD;
    }

    public String getPlayerId() {
        return this.zzWn;
    }

    public int getPlayerState() {
        return this.zzUF;
    }
}
