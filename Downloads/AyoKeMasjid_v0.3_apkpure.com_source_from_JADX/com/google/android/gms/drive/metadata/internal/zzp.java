package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzp extends zzj<UserMetadata> {
    public zzp(String str, int i) {
        super(str, zzcJ(str), Collections.emptyList(), i);
    }

    private String zzcI(String str) {
        return zzy(getName(), str);
    }

    private static Collection<String> zzcJ(String str) {
        return Arrays.asList(new String[]{zzy(str, "permissionId"), zzy(str, "displayName"), zzy(str, "picture"), zzy(str, "isAuthenticatedUser"), zzy(str, "emailAddress")});
    }

    private static String zzy(String str, String str2) {
        return str + "." + str2;
    }

    protected boolean zzb(DataHolder dataHolder, int i, int i2) {
        return dataHolder.zzcd(zzcI("permissionId")) && !dataHolder.zzi(zzcI("permissionId"), i, i2);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzj(dataHolder, i, i2);
    }

    protected UserMetadata zzj(DataHolder dataHolder, int i, int i2) {
        String zzd = dataHolder.zzd(zzcI("permissionId"), i, i2);
        if (zzd == null) {
            return null;
        }
        String zzd2 = dataHolder.zzd(zzcI("displayName"), i, i2);
        String zzd3 = dataHolder.zzd(zzcI("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.zze(zzcI("isAuthenticatedUser"), i, i2));
        return new UserMetadata(zzd, zzd2, zzd3, valueOf.booleanValue(), dataHolder.zzd(zzcI("emailAddress"), i, i2));
    }
}
