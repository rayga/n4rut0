package com.google.android.gms.wearable.internal;

import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class zzx implements DataEvent {
    private int zzUS;
    private DataItem zzbam;

    public zzx(DataEvent dataEvent) {
        this.zzUS = dataEvent.getType();
        this.zzbam = (DataItem) dataEvent.getDataItem().freeze();
    }

    public /* synthetic */ Object freeze() {
        return zzCE();
    }

    public DataItem getDataItem() {
        return this.zzbam;
    }

    public int getType() {
        return this.zzUS;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        String str = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : FitnessActivities.UNKNOWN;
        return "DataEventEntity{ type=" + str + ", dataitem=" + getDataItem() + " }";
    }

    public DataEvent zzCE() {
        return this;
    }
}
