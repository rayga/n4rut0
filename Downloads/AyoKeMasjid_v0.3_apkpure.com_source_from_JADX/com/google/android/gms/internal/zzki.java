package com.google.android.gms.internal;

import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import org.json.JSONObject;

public final class zzki implements PlayerInfo {
    private final int zzUF;
    private final JSONObject zzWD;
    private final boolean zzWE;
    private final String zzWn;

    public zzki(String str, int i, JSONObject jSONObject, boolean z) {
        this.zzWn = str;
        this.zzUF = i;
        this.zzWD = jSONObject;
        this.zzWE = z;
    }

    public boolean equals(Object otherObj) {
        if (otherObj == null || !(otherObj instanceof PlayerInfo)) {
            return false;
        }
        PlayerInfo playerInfo = (PlayerInfo) otherObj;
        return this.zzWE == playerInfo.isControllable() && this.zzUF == playerInfo.getPlayerState() && zzf.zza(this.zzWn, playerInfo.getPlayerId()) && zzls.zzd(this.zzWD, playerInfo.getPlayerData());
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

    public int hashCode() {
        return zzw.hashCode(this.zzWn, Integer.valueOf(this.zzUF), this.zzWD, Boolean.valueOf(this.zzWE));
    }

    public boolean isConnected() {
        switch (this.zzUF) {
            case CompletionEvent.STATUS_CANCELED /*3*/:
            case Barcode.PHONE /*4*/:
            case Barcode.PRODUCT /*5*/:
            case Barcode.SMS /*6*/:
                return true;
            default:
                return false;
        }
    }

    public boolean isControllable() {
        return this.zzWE;
    }
}
