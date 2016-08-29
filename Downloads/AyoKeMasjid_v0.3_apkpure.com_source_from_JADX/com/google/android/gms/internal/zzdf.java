package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.drive.ExecutionOptions;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgk
public final class zzdf {
    public static final zzdg zzwI;
    public static final zzdg zzwJ;
    public static final zzdg zzwK;
    public static final zzdg zzwL;
    public static final zzdg zzwM;
    public static final zzdg zzwN;
    public static final zzdg zzwO;
    public static final zzdg zzwP;
    public static final zzdg zzwQ;
    public static final zzdg zzwR;
    public static final zzdg zzwS;
    public static final zzdg zzwT;

    /* renamed from: com.google.android.gms.internal.zzdf.1 */
    static class C07581 implements zzdg {
        C07581() {
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdf.2 */
    static class C07592 implements zzdg {
        C07592() {
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            if (((Boolean) zzby.zzvd.get()).booleanValue()) {
                com_google_android_gms_internal_zzip.zzE(!Boolean.parseBoolean((String) map.get("disabled")));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdf.3 */
    static class C07603 implements zzdg {
        C07603() {
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzb.zzaE("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = com_google_android_gms_internal_zzip.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) != null));
            }
            com_google_android_gms_internal_zzip.zzc("openableURLs", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdf.4 */
    static class C07614 implements zzdg {
        C07614() {
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            PackageManager packageManager = com_google_android_gms_internal_zzip.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) != null);
                            } catch (Throwable e) {
                                zzb.zzb("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            zzb.zzb("Error parsing the intent data.", e2);
                        }
                    }
                    com_google_android_gms_internal_zzip.zzb("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    com_google_android_gms_internal_zzip.zzb("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                com_google_android_gms_internal_zzip.zzb("openableIntents", new JSONObject());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdf.5 */
    static class C07625 implements zzdg {
        C07625() {
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzb.zzaE("URL missing from click GMSG.");
                return;
            }
            String zzd = zzp.zzbx().zzd(com_google_android_gms_internal_zzip.getContext(), str, com_google_android_gms_internal_zzip.zzha());
            Uri parse = Uri.parse(zzd);
            try {
                zzan zzgU = com_google_android_gms_internal_zzip.zzgU();
                if (zzgU != null && zzgU.zzb(parse)) {
                    parse = zzgU.zza(parse, com_google_android_gms_internal_zzip.getContext());
                }
            } catch (zzao e) {
                zzb.zzaE("Unable to append parameter to URL: " + zzd);
            }
            new zzia(com_google_android_gms_internal_zzip.getContext(), com_google_android_gms_internal_zzip.zzgV().zzIz, parse.toString()).zzgn();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdf.6 */
    static class C07636 implements zzdg {
        C07636() {
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            zzd zzgQ = com_google_android_gms_internal_zzip.zzgQ();
            if (zzgQ != null) {
                zzgQ.close();
                return;
            }
            zzgQ = com_google_android_gms_internal_zzip.zzgR();
            if (zzgQ != null) {
                zzgQ.close();
            } else {
                zzb.zzaE("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdf.7 */
    static class C07647 implements zzdg {
        C07647() {
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            com_google_android_gms_internal_zzip.zzD("1".equals(map.get("custom_close")));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdf.8 */
    static class C07658 implements zzdg {
        C07658() {
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzb.zzaE("URL missing from httpTrack GMSG.");
            } else {
                new zzia(com_google_android_gms_internal_zzip.getContext(), com_google_android_gms_internal_zzip.zzgV().zzIz, str).zzgn();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzdf.9 */
    static class C07669 implements zzdg {
        C07669() {
        }

        public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
            zzb.zzaD("Received log message: " + ((String) map.get("string")));
        }
    }

    static {
        zzwI = new C07581();
        zzwJ = new C07603();
        zzwK = new C07614();
        zzwL = new C07625();
        zzwM = new C07636();
        zzwN = new C07647();
        zzwO = new C07658();
        zzwP = new C07669();
        zzwQ = new zzdg() {
            public void zza(zzip com_google_android_gms_internal_zzip, Map<String, String> map) {
                String str = (String) map.get("ty");
                String str2 = (String) map.get("td");
                try {
                    int parseInt = Integer.parseInt((String) map.get("tx"));
                    int parseInt2 = Integer.parseInt(str);
                    int parseInt3 = Integer.parseInt(str2);
                    zzan zzgU = com_google_android_gms_internal_zzip.zzgU();
                    if (zzgU != null) {
                        zzgU.zzab().zza(parseInt, parseInt2, parseInt3);
                    }
                } catch (NumberFormatException e) {
                    zzb.zzaE("Could not parse touch parameters from gmsg.");
                }
            }
        };
        zzwR = new C07592();
        zzwS = new zzdo();
        zzwT = new zzds();
    }
}
