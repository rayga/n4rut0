package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class zzl extends zzi<DriveId> implements SearchableCollectionMetadataField<DriveId> {
    public zzl(int i) {
        super("parents", Collections.emptySet(), Arrays.asList(new String[]{"parentsExtra", "dbInstanceId", "parentsExtraHolder"}), i);
    }

    private void zzc(DataHolder dataHolder) {
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) dataHolder.zznP().getParcelable("parentsExtraHolder");
            if (dataHolder2 == null) {
                return;
            }
            try {
                int i;
                int count = dataHolder.getCount();
                ArrayList arrayList = new ArrayList(count);
                Map hashMap = new HashMap(count);
                for (i = 0; i < count; i++) {
                    int zzbo = dataHolder.zzbo(i);
                    ParentDriveIdSet parentDriveIdSet = new ParentDriveIdSet();
                    arrayList.add(parentDriveIdSet);
                    hashMap.put(Long.valueOf(dataHolder.zzb("sqlId", i, zzbo)), parentDriveIdSet);
                }
                Bundle zznP = dataHolder2.zznP();
                String string = zznP.getString("childSqlIdColumn");
                String string2 = zznP.getString("parentSqlIdColumn");
                String string3 = zznP.getString("parentResIdColumn");
                int count2 = dataHolder2.getCount();
                for (i = 0; i < count2; i++) {
                    int zzbo2 = dataHolder2.zzbo(i);
                    ((ParentDriveIdSet) hashMap.get(Long.valueOf(dataHolder2.zzb(string, i, zzbo2)))).zza(new PartialDriveId(dataHolder2.zzd(string3, i, zzbo2), dataHolder2.zzb(string2, i, zzbo2), 1));
                }
                dataHolder.zznP().putParcelableArrayList("parentsExtra", arrayList);
            } finally {
                dataHolder2.close();
                dataHolder.zznP().remove("parentsExtraHolder");
            }
        }
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzd(dataHolder, i, i2);
    }

    protected Collection<DriveId> zzd(DataHolder dataHolder, int i, int i2) {
        Bundle zznP = dataHolder.zznP();
        List parcelableArrayList = zznP.getParcelableArrayList("parentsExtra");
        if (parcelableArrayList == null) {
            if (zznP.getParcelable("parentsExtraHolder") != null) {
                zzc(dataHolder);
                parcelableArrayList = zznP.getParcelableArrayList("parentsExtra");
            }
            if (parcelableArrayList == null) {
                return null;
            }
        }
        return ((ParentDriveIdSet) parcelableArrayList.get(i)).zzC(zznP.getLong("dbInstanceId"));
    }

    public void zzd(DataHolder dataHolder) {
        Bundle zznP = dataHolder.zznP();
        if (zznP != null) {
            synchronized (dataHolder) {
                DataHolder dataHolder2 = (DataHolder) zznP.getParcelable("parentsExtraHolder");
                if (dataHolder2 != null) {
                    dataHolder2.close();
                    zznP.remove("parentsExtraHolder");
                }
            }
        }
    }

    protected /* synthetic */ Object zzk(Bundle bundle) {
        return zzp(bundle);
    }

    protected Collection<DriveId> zzp(Bundle bundle) {
        Collection zzp = super.zzp(bundle);
        return zzp == null ? null : new HashSet(zzp);
    }
}
