package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.bpmikc.akm.BuildConfig;

public class zzac implements DataItem {
    private Uri mUri;
    private byte[] zzayG;
    private Map<String, DataItemAsset> zzbap;

    public zzac(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.zzayG = dataItem.getData();
        Map hashMap = new HashMap();
        for (Entry entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((DataItemAsset) entry.getValue()).freeze());
            }
        }
        this.zzbap = Collections.unmodifiableMap(hashMap);
    }

    public /* synthetic */ Object freeze() {
        return zzCG();
    }

    public Map<String, DataItemAsset> getAssets() {
        return this.zzbap;
    }

    public byte[] getData() {
        return this.zzayG;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity{ ");
        stringBuilder.append("uri=" + this.mUri);
        stringBuilder.append(", dataSz=" + (this.zzayG == null ? "null" : Integer.valueOf(this.zzayG.length)));
        stringBuilder.append(", numAssets=" + this.zzbap.size());
        if (verbose && !this.zzbap.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = BuildConfig.FLAVOR;
            String str2 = str;
            for (Entry entry : this.zzbap.entrySet()) {
                stringBuilder.append(str2 + ((String) entry.getKey()) + ": " + ((DataItemAsset) entry.getValue()).getId());
                str2 = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public DataItem zzCG() {
        return this;
    }
}
