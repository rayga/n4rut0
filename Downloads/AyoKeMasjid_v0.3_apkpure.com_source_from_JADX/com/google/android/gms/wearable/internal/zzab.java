package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItemAsset;

public class zzab extends zzc implements DataItemAsset {
    public zzab(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public /* synthetic */ Object freeze() {
        return zzCF();
    }

    public String getDataItemKey() {
        return getString("asset_key");
    }

    public String getId() {
        return getString("asset_id");
    }

    public DataItemAsset zzCF() {
        return new zzz(this);
    }
}
