package com.google.android.gms.wearable;

import android.net.Uri;

public class DataMapItem {
    private final Uri mUri;
    private final DataMap zzaYT;

    private DataMapItem(DataItem source) {
        this.mUri = source.getUri();
        this.zzaYT = zza((DataItem) source.freeze());
    }

    public static DataMapItem fromDataItem(DataItem dataItem) {
        if (dataItem != null) {
            return new DataMapItem(dataItem);
        }
        throw new IllegalStateException("provided dataItem is null");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.wearable.DataMap zza(com.google.android.gms.wearable.DataItem r7) {
        /*
        r6 = this;
        r2 = 0;
        r0 = r7.getData();
        if (r0 != 0) goto L_0x0019;
    L_0x0007:
        r0 = r7.getAssets();
        r0 = r0.size();
        if (r0 <= 0) goto L_0x0019;
    L_0x0011:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.";
        r0.<init>(r1);
        throw r0;
    L_0x0019:
        r0 = r7.getData();
        if (r0 != 0) goto L_0x0025;
    L_0x001f:
        r0 = new com.google.android.gms.wearable.DataMap;
        r0.<init>();
    L_0x0024:
        return r0;
    L_0x0025:
        r3 = new java.util.ArrayList;	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r3.<init>();	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r0 = r7.getAssets();	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r4 = r0.size();	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r1 = r2;
    L_0x0033:
        if (r1 >= r4) goto L_0x00c4;
    L_0x0035:
        r0 = r7.getAssets();	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r5 = java.lang.Integer.toString(r1);	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r0 = r0.get(r5);	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r0 = (com.google.android.gms.wearable.DataItemAsset) r0;	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        if (r0 != 0) goto L_0x00b4;
    L_0x0045:
        r0 = new java.lang.IllegalStateException;	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r3 = new java.lang.StringBuilder;	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r3.<init>();	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r4 = "Cannot find DataItemAsset referenced in data at ";
        r3 = r3.append(r4);	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r1 = r3.append(r1);	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r3 = " for ";
        r1 = r1.append(r3);	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r1 = r1.append(r7);	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r1 = r1.toString();	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r0.<init>(r1);	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        throw r0;	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
    L_0x0068:
        r0 = move-exception;
    L_0x0069:
        r1 = "DataItem";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Unable to parse datamap from dataItem. uri=";
        r3 = r3.append(r4);
        r4 = r7.getUri();
        r3 = r3.append(r4);
        r4 = ", data=";
        r3 = r3.append(r4);
        r4 = r7.getData();
        r2 = android.util.Base64.encodeToString(r4, r2);
        r2 = r3.append(r2);
        r2 = r2.toString();
        android.util.Log.w(r1, r2);
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unable to parse datamap from dataItem.  uri=";
        r2 = r2.append(r3);
        r3 = r7.getUri();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x00b4:
        r0 = r0.getId();	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r0 = com.google.android.gms.wearable.Asset.createFromRef(r0);	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r3.add(r0);	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0033;
    L_0x00c4:
        r0 = r7.getData();	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r0 = com.google.android.gms.internal.zzrm.zzw(r0);	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r1 = new com.google.android.gms.internal.zzrl$zza;	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r1.<init>(r0, r3);	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        r0 = com.google.android.gms.internal.zzrl.zza(r1);	 Catch:{ zzrw -> 0x0068, NullPointerException -> 0x00d7 }
        goto L_0x0024;
    L_0x00d7:
        r0 = move-exception;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.DataMapItem.zza(com.google.android.gms.wearable.DataItem):com.google.android.gms.wearable.DataMap");
    }

    public DataMap getDataMap() {
        return this.zzaYT;
    }

    public Uri getUri() {
        return this.mUri;
    }
}
