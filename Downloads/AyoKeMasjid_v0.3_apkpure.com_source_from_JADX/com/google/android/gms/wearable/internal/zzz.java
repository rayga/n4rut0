package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class zzz implements DataItemAsset {
    private final String zztP;
    private final String zzwj;

    public zzz(DataItemAsset dataItemAsset) {
        this.zzwj = dataItemAsset.getId();
        this.zztP = dataItemAsset.getDataItemKey();
    }

    public /* synthetic */ Object freeze() {
        return zzCF();
    }

    public String getDataItemKey() {
        return this.zztP;
    }

    public String getId() {
        return this.zzwj;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzwj == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.zzwj);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.zztP);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public DataItemAsset zzCF() {
        return this;
    }
}
