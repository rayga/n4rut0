package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef extends zzc implements ExperienceEvent {
    private final GameRef zzawJ;

    public ExperienceEventRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        if (zzcf("external_game_id")) {
            this.zzawJ = null;
        } else {
            this.zzawJ = new GameRef(this.zzYX, this.zzabg);
        }
    }

    public String getIconImageUrl() {
        return getString("icon_url");
    }
}
