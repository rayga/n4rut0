package com.google.android.gms.internal;

import com.bumptech.glide.load.Key;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.tagmanager.zzbg;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.bpmikc.akm.BuildConfig;

public class zzqs {
    private String zzaPw;

    public zzqs() {
        this.zzaPw = "https://www.google-analytics.com";
    }

    private String zzff(String str) {
        try {
            return URLEncoder.encode(str, Key.STRING_CHARSET_NAME).replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            zzbg.m16e("Cannot encode the string: " + str);
            return BuildConfig.FLAVOR;
        }
    }

    public void zzfj(String str) {
        this.zzaPw = str;
        zzbg.zzaD("The Ctfe server endpoint was changed to: " + str);
    }

    public String zzt(List<zzqi> list) {
        return this.zzaPw + "/gtm/android?" + zzu(list);
    }

    String zzu(List<zzqi> list) {
        boolean z = true;
        if (list.size() > 1) {
            z = false;
        }
        zzx.zzZ(z);
        if (list.isEmpty()) {
            return BuildConfig.FLAVOR;
        }
        zzqi com_google_android_gms_internal_zzqi = (zzqi) list.get(0);
        String trim = !com_google_android_gms_internal_zzqi.zzBt().trim().equals(BuildConfig.FLAVOR) ? com_google_android_gms_internal_zzqi.zzBt().trim() : "-1";
        StringBuilder stringBuilder = new StringBuilder();
        if (com_google_android_gms_internal_zzqi.zzBq() != null) {
            stringBuilder.append(com_google_android_gms_internal_zzqi.zzBq());
        } else {
            stringBuilder.append("id");
        }
        stringBuilder.append("=").append(zzff(com_google_android_gms_internal_zzqi.getContainerId())).append("&").append("pv").append("=").append(zzff(trim));
        if (com_google_android_gms_internal_zzqi.zzBs()) {
            stringBuilder.append("&gtm_debug=x");
        }
        return stringBuilder.toString();
    }
}
