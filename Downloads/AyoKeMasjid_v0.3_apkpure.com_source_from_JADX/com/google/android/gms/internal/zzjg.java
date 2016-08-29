package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.internal.zznw.zzb;
import com.google.android.gms.internal.zznw.zzc;
import com.google.android.gms.internal.zznw.zzd;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.List;

public class zzjg {
    private static DocumentSection zza(String str, zzc com_google_android_gms_internal_zznw_zzc) {
        return new DocumentSection(zzrx.zzf(com_google_android_gms_internal_zznw_zzc), new zza(str).zzM(true).zzbz(str).zzby("blob").zzld());
    }

    public static UsageInfo zza(Action action, long j, String str, int i) {
        int i2;
        boolean z = false;
        Bundle bundle = new Bundle();
        bundle.putAll(action.zzlh());
        Bundle bundle2 = bundle.getBundle("object");
        Uri parse = bundle2.containsKey("id") ? Uri.parse(bundle2.getString("id")) : null;
        String string = bundle2.getString("name");
        String string2 = bundle2.getString("type");
        Intent zza = zzjh.zza(str, Uri.parse(bundle2.getString(PlusShare.KEY_CALL_TO_ACTION_URL)));
        DocumentContents.zza zza2 = UsageInfo.zza(zza, string, parse, string2, null);
        if (bundle.containsKey(".private:ssbContext")) {
            zza2.zza(DocumentSection.zzh(bundle.getByteArray(".private:ssbContext")));
            bundle.remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName")) {
            zza2.zza(new Account(bundle.getString(".private:accountName"), GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            bundle.remove(".private:accountName");
        }
        if (bundle.containsKey(".private:isContextOnly") && bundle.getBoolean(".private:isContextOnly")) {
            i2 = 4;
            bundle.remove(".private:isContextOnly");
        } else {
            i2 = 0;
        }
        if (bundle.containsKey(".private:isDeviceOnly")) {
            z = bundle.getBoolean(".private:isDeviceOnly", false);
            bundle.remove(".private:isDeviceOnly");
        }
        zza2.zza(zza(".private:action", zzf(bundle)));
        return new UsageInfo.zza().zza(UsageInfo.zza(str, zza)).zzw(j).zzam(i2).zza(zza2.zzkY()).zzO(z).zzan(i).zzlf();
    }

    static zzc zzf(Bundle bundle) {
        zzc com_google_android_gms_internal_zznw_zzc = new zzc();
        List arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            zzb com_google_android_gms_internal_zznw_zzb = new zzb();
            com_google_android_gms_internal_zznw_zzb.name = str;
            com_google_android_gms_internal_zznw_zzb.zzaAr = new zzd();
            if (obj instanceof String) {
                com_google_android_gms_internal_zznw_zzb.zzaAr.zzaeO = (String) obj;
            } else if (obj instanceof Bundle) {
                com_google_android_gms_internal_zznw_zzb.zzaAr.zzaAw = zzf((Bundle) obj);
            } else {
                Log.e("SearchIndex", "Unsupported value: " + obj);
            }
            arrayList.add(com_google_android_gms_internal_zznw_zzb);
        }
        if (bundle.containsKey("type")) {
            com_google_android_gms_internal_zznw_zzc.type = bundle.getString("type");
        }
        com_google_android_gms_internal_zznw_zzc.zzaAs = (zzb[]) arrayList.toArray(new zzb[arrayList.size()]);
        return com_google_android_gms_internal_zznw_zzc;
    }
}
