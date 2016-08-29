package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.HashMap;
import java.util.Map;

@zzgk
public class zzdm implements zzdg {
    static final Map<String, Integer> zzxl;
    private final zze zzxj;
    private final zzew zzxk;

    static {
        zzxl = new HashMap();
        zzxl.put("resize", Integer.valueOf(1));
        zzxl.put("playVideo", Integer.valueOf(2));
        zzxl.put("storePicture", Integer.valueOf(3));
        zzxl.put("createCalendarEvent", Integer.valueOf(4));
        zzxl.put("setOrientationProperties", Integer.valueOf(5));
        zzxl.put("closeResizedAd", Integer.valueOf(6));
    }

    public zzdm(zze com_google_android_gms_ads_internal_zze, zzew com_google_android_gms_internal_zzew) {
        this.zzxj = com_google_android_gms_ads_internal_zze;
        this.zzxk = com_google_android_gms_internal_zzew;
    }

    public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
        int intValue = ((Integer) zzxl.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.zzxj == null || this.zzxj.zzbe()) {
            switch (intValue) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    this.zzxk.zzg(map);
                    return;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    new zzey(com_google_android_gms_internal_zzip, map).execute();
                    return;
                case Barcode.PHONE /*4*/:
                    new zzev(com_google_android_gms_internal_zzip, map).execute();
                    return;
                case Barcode.PRODUCT /*5*/:
                    new zzex(com_google_android_gms_internal_zzip, map).execute();
                    return;
                case Barcode.SMS /*6*/:
                    this.zzxk.zzn(true);
                    return;
                default:
                    zzb.zzaD("Unknown MRAID command called.");
                    return;
            }
        }
        this.zzxj.zzp(null);
    }
}
