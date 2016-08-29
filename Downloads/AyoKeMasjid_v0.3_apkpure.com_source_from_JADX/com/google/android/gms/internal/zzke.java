package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

public final class zzke {
    private final String zzWq;
    private final int zzWr;
    private final String zzWs;

    public zzke(String str, int i, String str2) {
        this.zzWq = str;
        this.zzWr = i;
        this.zzWs = str2;
    }

    public zzke(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("applicationName"), jSONObject.optInt("maxPlayers"), jSONObject.optString("version"));
    }

    public final int getMaxPlayers() {
        return this.zzWr;
    }

    public final String getVersion() {
        return this.zzWs;
    }

    public final String zzml() {
        return this.zzWq;
    }
}
