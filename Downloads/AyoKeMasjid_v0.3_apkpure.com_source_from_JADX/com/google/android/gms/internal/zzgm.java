package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzj.zza;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzdv.zzd;
import com.google.android.gms.internal.zzij.zzc;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@zzgk
public final class zzgm extends zza {
    private static zzgm zzEL;
    private static final Object zzpm;
    private final Context mContext;
    private final zzgl zzEM;
    private final zzbr zzEN;
    private final zzdv zzqU;

    /* renamed from: com.google.android.gms.internal.zzgm.1 */
    static class C03741 implements Runnable {
        final /* synthetic */ zzdv zzEO;
        final /* synthetic */ zzgo zzEP;
        final /* synthetic */ zzcc zzEQ;
        final /* synthetic */ String zzER;
        final /* synthetic */ zzcd zzoC;

        /* renamed from: com.google.android.gms.internal.zzgm.1.1 */
        class C07821 implements zzc<zzbe> {
            final /* synthetic */ zzcc zzES;
            final /* synthetic */ C03741 zzET;

            C07821(C03741 c03741, zzcc com_google_android_gms_internal_zzcc) {
                this.zzET = c03741;
                this.zzES = com_google_android_gms_internal_zzcc;
            }

            public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                this.zzET.zzoC.zza(this.zzES, "jsf");
                this.zzET.zzoC.zzdm();
                com_google_android_gms_internal_zzbe.zza("/invalidRequest", this.zzET.zzEP.zzFc);
                com_google_android_gms_internal_zzbe.zza("/loadAdURL", this.zzET.zzEP.zzFd);
                try {
                    com_google_android_gms_internal_zzbe.zza("AFMA_buildAdURL", this.zzET.zzER);
                } catch (Throwable e) {
                    zzb.zzb("Error requesting an ad url", e);
                }
            }

            public /* synthetic */ void zzc(Object obj) {
                zzb((zzbe) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzgm.1.2 */
        class C07832 implements zzij.zza {
            final /* synthetic */ C03741 zzET;

            C07832(C03741 c03741) {
                this.zzET = c03741;
            }

            public void run() {
            }
        }

        C03741(zzdv com_google_android_gms_internal_zzdv, zzgo com_google_android_gms_internal_zzgo, zzcd com_google_android_gms_internal_zzcd, zzcc com_google_android_gms_internal_zzcc, String str) {
            this.zzEO = com_google_android_gms_internal_zzdv;
            this.zzEP = com_google_android_gms_internal_zzgo;
            this.zzoC = com_google_android_gms_internal_zzcd;
            this.zzEQ = com_google_android_gms_internal_zzcc;
            this.zzER = str;
        }

        public void run() {
            zzd zzdL = this.zzEO.zzdL();
            this.zzEP.zzb(zzdL);
            this.zzoC.zza(this.zzEQ, "rwc");
            zzdL.zza(new C07821(this, this.zzoC.zzdl()), new C07832(this));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgm.2 */
    static class C03752 implements Runnable {
        final /* synthetic */ zzgo zzEP;
        final /* synthetic */ zzcc zzEQ;
        final /* synthetic */ String zzER;
        final /* synthetic */ AdRequestInfoParcel zzEU;
        final /* synthetic */ zzbr zzEV;
        final /* synthetic */ zzcd zzoC;
        final /* synthetic */ Context zzrn;

        C03752(Context context, AdRequestInfoParcel adRequestInfoParcel, zzgo com_google_android_gms_internal_zzgo, zzcd com_google_android_gms_internal_zzcd, zzcc com_google_android_gms_internal_zzcc, String str, zzbr com_google_android_gms_internal_zzbr) {
            this.zzrn = context;
            this.zzEU = adRequestInfoParcel;
            this.zzEP = com_google_android_gms_internal_zzgo;
            this.zzoC = com_google_android_gms_internal_zzcd;
            this.zzEQ = com_google_android_gms_internal_zzcc;
            this.zzER = str;
            this.zzEV = com_google_android_gms_internal_zzbr;
        }

        public void run() {
            zzip zza = zzp.zzby().zza(this.zzrn, new AdSizeParcel(), false, false, null, this.zzEU.zzqb);
            if (zzp.zzbA().zzgi()) {
                zza.getWebView().clearCache(true);
            }
            zza.setWillNotDraw(true);
            this.zzEP.zze(zza);
            this.zzoC.zza(this.zzEQ, "rwc");
            zziq.zza zzb = zzgm.zza(this.zzER, this.zzoC, this.zzoC.zzdl());
            zziq zzgS = zza.zzgS();
            zzgS.zza("/invalidRequest", this.zzEP.zzFc);
            zzgS.zza("/loadAdURL", this.zzEP.zzFd);
            zzgS.zza("/log", zzdf.zzwP);
            zzgS.zza(zzb);
            zzb.zzaC("Loading the JS library.");
            zza.loadUrl(this.zzEV.zzdb());
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgm.3 */
    static class C03763 implements Runnable {
        final /* synthetic */ zzgo zzEP;

        C03763(zzgo com_google_android_gms_internal_zzgo) {
            this.zzEP = com_google_android_gms_internal_zzgo;
        }

        public void run() {
            this.zzEP.zzfJ();
            if (this.zzEP.zzfH() != null) {
                this.zzEP.zzfH().release();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgm.6 */
    class C03776 implements Runnable {
        final /* synthetic */ AdRequestInfoParcel zzEU;
        final /* synthetic */ zzgm zzEW;
        final /* synthetic */ zzk zzEX;

        C03776(zzgm com_google_android_gms_internal_zzgm, AdRequestInfoParcel adRequestInfoParcel, zzk com_google_android_gms_ads_internal_request_zzk) {
            this.zzEW = com_google_android_gms_internal_zzgm;
            this.zzEU = adRequestInfoParcel;
            this.zzEX = com_google_android_gms_ads_internal_request_zzk;
        }

        public void run() {
            AdResponseParcel zze;
            try {
                zze = this.zzEW.zze(this.zzEU);
            } catch (Throwable e) {
                zzp.zzbA().zzc(e, true);
                zzb.zzd("Could not fetch ad response due to an Exception.", e);
                zze = null;
            }
            if (zze == null) {
                zze = new AdResponseParcel(0);
            }
            try {
                this.zzEX.zzb(zze);
            } catch (Throwable e2) {
                zzb.zzd("Fail to forward ad response.", e2);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgm.4 */
    static class C07844 implements zziq.zza {
        final /* synthetic */ String zzER;
        final /* synthetic */ zzcc zzES;
        final /* synthetic */ zzcd zzoC;

        C07844(zzcd com_google_android_gms_internal_zzcd, zzcc com_google_android_gms_internal_zzcc, String str) {
            this.zzoC = com_google_android_gms_internal_zzcd;
            this.zzES = com_google_android_gms_internal_zzcc;
            this.zzER = str;
        }

        public void zza(zzip com_google_android_gms_internal_zzip, boolean z) {
            this.zzoC.zza(this.zzES, "jsf");
            this.zzoC.zzdm();
            com_google_android_gms_internal_zzip.zza("AFMA_buildAdURL", this.zzER);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgm.5 */
    class C07855 implements zzdv.zzb<zzbb> {
        final /* synthetic */ zzgm zzEW;

        C07855(zzgm com_google_android_gms_internal_zzgm) {
            this.zzEW = com_google_android_gms_internal_zzgm;
        }

        public void zza(zzbb com_google_android_gms_internal_zzbb) {
            com_google_android_gms_internal_zzbb.zza("/log", zzdf.zzwP);
        }

        public /* synthetic */ void zzc(Object obj) {
            zza((zzbb) obj);
        }
    }

    static {
        zzpm = new Object();
    }

    zzgm(Context context, zzbr com_google_android_gms_internal_zzbr, zzgl com_google_android_gms_internal_zzgl) {
        this.mContext = context;
        this.zzEM = com_google_android_gms_internal_zzgl;
        this.zzEN = com_google_android_gms_internal_zzbr;
        this.zzqU = new zzdv(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(7895000, 7895000, true), com_google_android_gms_internal_zzbr.zzdb(), new C07855(this), new zzdv.zzc());
    }

    private static AdResponseParcel zza(Context context, zzdv com_google_android_gms_internal_zzdv, zzbr com_google_android_gms_internal_zzbr, zzgl com_google_android_gms_internal_zzgl, AdRequestInfoParcel adRequestInfoParcel) {
        AdResponseParcel adResponseParcel;
        zzb.zzaC("Starting ad request from service.");
        zzby.zzw(context);
        zzcd com_google_android_gms_internal_zzcd = new zzcd(((Boolean) zzby.zzuB.get()).booleanValue(), "load_ad", adRequestInfoParcel.zzqf.zzsG);
        if (adRequestInfoParcel.versionCode > 10 && adRequestInfoParcel.zzDT != -1) {
            com_google_android_gms_internal_zzcd.zza(com_google_android_gms_internal_zzcd.zzb(adRequestInfoParcel.zzDT), "cts");
        }
        zzcc zzdl = com_google_android_gms_internal_zzcd.zzdl();
        com_google_android_gms_internal_zzgl.zzEH.init();
        zzgr zzD = zzp.zzbD().zzD(context);
        if (zzD.zzFN == -1) {
            zzb.zzaC("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzDQ : UUID.randomUUID().toString();
        zzgo com_google_android_gms_internal_zzgo = new zzgo(uuid, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzDy.extras != null) {
            String string = adRequestInfoParcel.zzDy.extras.getString("_ad");
            if (string != null) {
                return zzgn.zza(context, adRequestInfoParcel, string);
            }
        }
        Location zzc = com_google_android_gms_internal_zzgl.zzEH.zzc(250);
        String zzc2 = com_google_android_gms_internal_zzgl.zzEI.zzc(context, adRequestInfoParcel.zzDz.packageName);
        List zza = com_google_android_gms_internal_zzgl.zzEG.zza(adRequestInfoParcel);
        JSONObject zza2 = zzgn.zza(context, adRequestInfoParcel, zzD, com_google_android_gms_internal_zzgl.zzEK.zzE(context), zzc, com_google_android_gms_internal_zzbr, zzc2, com_google_android_gms_internal_zzgl.zzEJ.zzau(adRequestInfoParcel.zzDA), zza);
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                zza2.put("request_id", uuid);
            } catch (JSONException e) {
            }
        }
        if (zza2 == null) {
            return new AdResponseParcel(0);
        }
        String jSONObject = zza2.toString();
        com_google_android_gms_internal_zzcd.zza(zzdl, "arc");
        zzcc zzdl2 = com_google_android_gms_internal_zzcd.zzdl();
        if (((Boolean) zzby.zztX.get()).booleanValue()) {
            zzhu.zzHK.post(new C03741(com_google_android_gms_internal_zzdv, com_google_android_gms_internal_zzgo, com_google_android_gms_internal_zzcd, zzdl2, jSONObject));
        } else {
            zzhu.zzHK.post(new C03752(context, adRequestInfoParcel, com_google_android_gms_internal_zzgo, com_google_android_gms_internal_zzcd, zzdl2, jSONObject, com_google_android_gms_internal_zzbr));
        }
        try {
            zzgq com_google_android_gms_internal_zzgq = (zzgq) com_google_android_gms_internal_zzgo.zzfI().get(10, TimeUnit.SECONDS);
            if (com_google_android_gms_internal_zzgq == null) {
                adResponseParcel = new AdResponseParcel(0);
                return adResponseParcel;
            } else if (com_google_android_gms_internal_zzgq.getErrorCode() != -2) {
                adResponseParcel = new AdResponseParcel(com_google_android_gms_internal_zzgq.getErrorCode());
                zzhu.zzHK.post(new C03763(com_google_android_gms_internal_zzgo));
                return adResponseParcel;
            } else {
                if (com_google_android_gms_internal_zzcd.zzdo() != null) {
                    com_google_android_gms_internal_zzcd.zza(com_google_android_gms_internal_zzcd.zzdo(), "rur");
                }
                jSONObject = null;
                if (com_google_android_gms_internal_zzgq.zzfM()) {
                    jSONObject = com_google_android_gms_internal_zzgl.zzEF.zzat(adRequestInfoParcel.zzDz.packageName);
                }
                adResponseParcel = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzqb.zzIz, com_google_android_gms_internal_zzgq.getUrl(), jSONObject, zzc2, com_google_android_gms_internal_zzgq, com_google_android_gms_internal_zzcd);
                if (adResponseParcel.zzEj == 1) {
                    com_google_android_gms_internal_zzgl.zzEI.clearToken(context, adRequestInfoParcel.zzDz.packageName);
                }
                com_google_android_gms_internal_zzcd.zza(zzdl, "tts");
                adResponseParcel.zzEl = com_google_android_gms_internal_zzcd.zzdn();
                zzhu.zzHK.post(new C03763(com_google_android_gms_internal_zzgo));
                return adResponseParcel;
            }
        } catch (Exception e2) {
            adResponseParcel = new AdResponseParcel(0);
            return adResponseParcel;
        } finally {
            zzhu.zzHK.post(new C03763(com_google_android_gms_internal_zzgo));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.google.android.gms.internal.zzgq r19, com.google.android.gms.internal.zzcd r20) {
        /*
        if (r20 == 0) goto L_0x00df;
    L_0x0002:
        r2 = r20.zzdl();
        r3 = r2;
    L_0x0007:
        r6 = new com.google.android.gms.internal.zzgp;	 Catch:{ IOException -> 0x0152 }
        r6.<init>(r13);	 Catch:{ IOException -> 0x0152 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0152 }
        r2.<init>();	 Catch:{ IOException -> 0x0152 }
        r4 = "AdRequestServiceImpl: Sending request: ";
        r2 = r2.append(r4);	 Catch:{ IOException -> 0x0152 }
        r0 = r16;
        r2 = r2.append(r0);	 Catch:{ IOException -> 0x0152 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0152 }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC(r2);	 Catch:{ IOException -> 0x0152 }
        r4 = new java.net.URL;	 Catch:{ IOException -> 0x0152 }
        r0 = r16;
        r4.<init>(r0);	 Catch:{ IOException -> 0x0152 }
        r2 = 0;
        r5 = com.google.android.gms.ads.internal.zzp.zzbB();	 Catch:{ IOException -> 0x0152 }
        r8 = r5.elapsedRealtime();	 Catch:{ IOException -> 0x0152 }
        r5 = r4;
        r4 = r2;
    L_0x0036:
        r2 = r5.openConnection();	 Catch:{ IOException -> 0x0152 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ IOException -> 0x0152 }
        r7 = com.google.android.gms.ads.internal.zzp.zzbx();	 Catch:{ all -> 0x0175 }
        r10 = 0;
        r7.zza(r14, r15, r10, r2);	 Catch:{ all -> 0x0175 }
        r7 = android.text.TextUtils.isEmpty(r17);	 Catch:{ all -> 0x0175 }
        if (r7 != 0) goto L_0x0051;
    L_0x004a:
        r7 = "x-afma-drt-cookie";
        r0 = r17;
        r2.addRequestProperty(r7, r0);	 Catch:{ all -> 0x0175 }
    L_0x0051:
        r7 = android.text.TextUtils.isEmpty(r18);	 Catch:{ all -> 0x0175 }
        if (r7 != 0) goto L_0x0071;
    L_0x0057:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0175 }
        r7.<init>();	 Catch:{ all -> 0x0175 }
        r10 = "Bearer ";
        r7 = r7.append(r10);	 Catch:{ all -> 0x0175 }
        r0 = r18;
        r7 = r7.append(r0);	 Catch:{ all -> 0x0175 }
        r7 = r7.toString();	 Catch:{ all -> 0x0175 }
        r10 = "Authorization";
        r2.addRequestProperty(r10, r7);	 Catch:{ all -> 0x0175 }
    L_0x0071:
        if (r19 == 0) goto L_0x009c;
    L_0x0073:
        r7 = r19.zzfL();	 Catch:{ all -> 0x0175 }
        r7 = android.text.TextUtils.isEmpty(r7);	 Catch:{ all -> 0x0175 }
        if (r7 != 0) goto L_0x009c;
    L_0x007d:
        r7 = 1;
        r2.setDoOutput(r7);	 Catch:{ all -> 0x0175 }
        r7 = r19.zzfL();	 Catch:{ all -> 0x0175 }
        r7 = r7.getBytes();	 Catch:{ all -> 0x0175 }
        r10 = r7.length;	 Catch:{ all -> 0x0175 }
        r2.setFixedLengthStreamingMode(r10);	 Catch:{ all -> 0x0175 }
        r10 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x0175 }
        r11 = r2.getOutputStream();	 Catch:{ all -> 0x0175 }
        r10.<init>(r11);	 Catch:{ all -> 0x0175 }
        r10.write(r7);	 Catch:{ all -> 0x0175 }
        r10.close();	 Catch:{ all -> 0x0175 }
    L_0x009c:
        r7 = r2.getResponseCode();	 Catch:{ all -> 0x0175 }
        r10 = r2.getHeaderFields();	 Catch:{ all -> 0x0175 }
        r11 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r7 < r11) goto L_0x00e3;
    L_0x00a8:
        r11 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r7 >= r11) goto L_0x00e3;
    L_0x00ac:
        r4 = r5.toString();	 Catch:{ all -> 0x0175 }
        r5 = com.google.android.gms.ads.internal.zzp.zzbx();	 Catch:{ all -> 0x0175 }
        r11 = new java.io.InputStreamReader;	 Catch:{ all -> 0x0175 }
        r12 = r2.getInputStream();	 Catch:{ all -> 0x0175 }
        r11.<init>(r12);	 Catch:{ all -> 0x0175 }
        r5 = r5.zza(r11);	 Catch:{ all -> 0x0175 }
        zza(r4, r10, r5, r7);	 Catch:{ all -> 0x0175 }
        r6.zzb(r4, r10, r5);	 Catch:{ all -> 0x0175 }
        if (r20 == 0) goto L_0x00d6;
    L_0x00c9:
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x0175 }
        r5 = 0;
        r7 = "ufe";
        r4[r5] = r7;	 Catch:{ all -> 0x0175 }
        r0 = r20;
        r0.zza(r3, r4);	 Catch:{ all -> 0x0175 }
    L_0x00d6:
        r3 = r6.zzj(r8);	 Catch:{ all -> 0x0175 }
        r2.disconnect();	 Catch:{ IOException -> 0x0152 }
        r2 = r3;
    L_0x00de:
        return r2;
    L_0x00df:
        r2 = 0;
        r3 = r2;
        goto L_0x0007;
    L_0x00e3:
        r5 = r5.toString();	 Catch:{ all -> 0x0175 }
        r11 = 0;
        zza(r5, r10, r11, r7);	 Catch:{ all -> 0x0175 }
        r5 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r7 < r5) goto L_0x0129;
    L_0x00ef:
        r5 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r7 >= r5) goto L_0x0129;
    L_0x00f3:
        r5 = "Location";
        r7 = r2.getHeaderField(r5);	 Catch:{ all -> 0x0175 }
        r5 = android.text.TextUtils.isEmpty(r7);	 Catch:{ all -> 0x0175 }
        if (r5 == 0) goto L_0x010f;
    L_0x00ff:
        r3 = "No location header to follow redirect.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaE(r3);	 Catch:{ all -> 0x0175 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0175 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0175 }
        r2.disconnect();	 Catch:{ IOException -> 0x0152 }
        r2 = r3;
        goto L_0x00de;
    L_0x010f:
        r5 = new java.net.URL;	 Catch:{ all -> 0x0175 }
        r5.<init>(r7);	 Catch:{ all -> 0x0175 }
        r4 = r4 + 1;
        r7 = 5;
        if (r4 <= r7) goto L_0x014a;
    L_0x0119:
        r3 = "Too many redirects.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaE(r3);	 Catch:{ all -> 0x0175 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0175 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0175 }
        r2.disconnect();	 Catch:{ IOException -> 0x0152 }
        r2 = r3;
        goto L_0x00de;
    L_0x0129:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0175 }
        r3.<init>();	 Catch:{ all -> 0x0175 }
        r4 = "Received error HTTP response code: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0175 }
        r3 = r3.append(r7);	 Catch:{ all -> 0x0175 }
        r3 = r3.toString();	 Catch:{ all -> 0x0175 }
        com.google.android.gms.ads.internal.util.client.zzb.zzaE(r3);	 Catch:{ all -> 0x0175 }
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0175 }
        r4 = 0;
        r3.<init>(r4);	 Catch:{ all -> 0x0175 }
        r2.disconnect();	 Catch:{ IOException -> 0x0152 }
        r2 = r3;
        goto L_0x00de;
    L_0x014a:
        r6.zzh(r10);	 Catch:{ all -> 0x0175 }
        r2.disconnect();	 Catch:{ IOException -> 0x0152 }
        goto L_0x0036;
    L_0x0152:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Error while connecting to ad server: ";
        r3 = r3.append(r4);
        r2 = r2.getMessage();
        r2 = r3.append(r2);
        r2 = r2.toString();
        com.google.android.gms.ads.internal.util.client.zzb.zzaE(r2);
        r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel;
        r3 = 2;
        r2.<init>(r3);
        goto L_0x00de;
    L_0x0175:
        r3 = move-exception;
        r2.disconnect();	 Catch:{ IOException -> 0x0152 }
        throw r3;	 Catch:{ IOException -> 0x0152 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgm.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzgq, com.google.android.gms.internal.zzcd):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static zzgm zza(Context context, zzbr com_google_android_gms_internal_zzbr, zzgl com_google_android_gms_internal_zzgl) {
        zzgm com_google_android_gms_internal_zzgm;
        synchronized (zzpm) {
            if (zzEL == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzEL = new zzgm(context, com_google_android_gms_internal_zzbr, com_google_android_gms_internal_zzgl);
            }
            com_google_android_gms_internal_zzgm = zzEL;
        }
        return com_google_android_gms_internal_zzgm;
    }

    private static zziq.zza zza(String str, zzcd com_google_android_gms_internal_zzcd, zzcc com_google_android_gms_internal_zzcc) {
        return new C07844(com_google_android_gms_internal_zzcd, com_google_android_gms_internal_zzcc, str);
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzb.zzM(2)) {
            zzb.m14v("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    zzb.m14v("    " + str3 + ":");
                    for (String str32 : (List) map.get(str32)) {
                        zzb.m14v("      " + str32);
                    }
                }
            }
            zzb.m14v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE) {
                    zzb.m14v(str2.substring(i2, Math.min(str2.length(), i2 + GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE)));
                }
            } else {
                zzb.m14v("    null");
            }
            zzb.m14v("  Response Code:\n    " + i + "\n}");
        }
    }

    public void zza(AdRequestInfoParcel adRequestInfoParcel, zzk com_google_android_gms_ads_internal_request_zzk) {
        zzp.zzbA().zzb(this.mContext, adRequestInfoParcel.zzqb);
        zzhu.zzb(new C03776(this, adRequestInfoParcel, com_google_android_gms_ads_internal_request_zzk));
    }

    public AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        return zza(this.mContext, this.zzqU, this.zzEN, this.zzEM, adRequestInfoParcel);
    }
}
