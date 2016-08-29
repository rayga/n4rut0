package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class ExperienceEventBuffer extends AbstractDataBuffer<ExperienceEvent> {
    public ExperienceEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public /* synthetic */ Object get(int x0) {
        return zzfR(x0);
    }

    public ExperienceEvent zzfR(int i) {
        return new ExperienceEventRef(this.zzYX, i);
    }
}
