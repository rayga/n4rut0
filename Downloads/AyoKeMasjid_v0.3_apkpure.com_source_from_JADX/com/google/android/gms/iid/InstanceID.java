package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.MotionEventCompat;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.bpmikc.akm.BuildConfig;

public class InstanceID {
    public static final String ERROR_BACKOFF = "RETRY_LATER";
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    static Map<String, InstanceID> zzaAO;
    private static zzd zzaAP;
    private static zzc zzaAQ;
    static String zzaAU;
    Context mContext;
    KeyPair zzaAR;
    String zzaAS;
    long zzaAT;

    static {
        zzaAO = new HashMap();
    }

    protected InstanceID(Context context, String subtype, Bundle options) {
        this.zzaAS = BuildConfig.FLAVOR;
        this.mContext = context.getApplicationContext();
        this.zzaAS = subtype;
    }

    public static InstanceID getInstance(Context context) {
        return zza(context, null);
    }

    public static synchronized InstanceID zza(Context context, Bundle bundle) {
        InstanceID instanceID;
        synchronized (InstanceID.class) {
            String string = bundle == null ? BuildConfig.FLAVOR : bundle.getString("subtype");
            String str = string == null ? BuildConfig.FLAVOR : string;
            Context applicationContext = context.getApplicationContext();
            if (zzaAP == null) {
                zzaAP = new zzd(applicationContext);
                zzaAQ = new zzc(applicationContext);
            }
            zzaAU = Integer.toString(zzaB(applicationContext));
            instanceID = (InstanceID) zzaAO.get(str);
            if (instanceID == null) {
                instanceID = new InstanceID(applicationContext, str, bundle);
                zzaAO.put(str, instanceID);
            }
        }
        return instanceID;
    }

    static String zza(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & MotionEventCompat.ACTION_MASK);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static int zzaB(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("InstanceID", "Never happens: can't find own package " + e);
            return i;
        }
    }

    static String zzm(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public void deleteInstanceID() throws IOException {
        zzb("*", "*", null);
        zzvz();
    }

    public void deleteToken(String authorizedEntity, String scope) throws IOException {
        zzb(authorizedEntity, scope, null);
    }

    public long getCreationTime() {
        if (this.zzaAT == 0) {
            String str = zzaAP.get(this.zzaAS, "cre");
            if (str != null) {
                this.zzaAT = Long.parseLong(str);
            }
        }
        return this.zzaAT;
    }

    public String getId() {
        return zza(zzvy());
    }

    public String getToken(String authorizedEntity, String scope) throws IOException {
        return getToken(authorizedEntity, scope, null);
    }

    public String getToken(String authorizedEntity, String scope, Bundle extras) throws IOException {
        Object obj = null;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        Object obj2 = 1;
        String zzg = zzvC() ? null : zzaAP.zzg(this.zzaAS, authorizedEntity, scope);
        if (zzg == null) {
            if (extras == null) {
                extras = new Bundle();
            }
            if (extras.getString("ttl") != null) {
                obj2 = null;
            }
            if (!"jwt".equals(extras.getString("type"))) {
                obj = obj2;
            }
            zzg = zzc(authorizedEntity, scope, extras);
            Log.w("InstanceID", "token: " + zzg);
            if (!(zzg == null || r1 == null)) {
                zzaAP.zza(this.zzaAS, authorizedEntity, scope, zzg, zzaAU);
            }
        }
        return zzg;
    }

    public void zzb(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException(ERROR_MAIN_THREAD);
        }
        zzaAP.zzh(this.zzaAS, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", BuildConfig.FLAVOR.equals(this.zzaAS) ? str : this.zzaAS);
        String str3 = "X-subtype";
        if (!BuildConfig.FLAVOR.equals(this.zzaAS)) {
            str = this.zzaAS;
        }
        bundle.putString(str3, str);
        zzaAQ.zzp(zzaAQ.zza(bundle, zzvy()));
    }

    public String zzc(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = BuildConfig.FLAVOR.equals(this.zzaAS) ? str : this.zzaAS;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return zzaAQ.zzp(zzaAQ.zza(bundle, zzvy()));
    }

    zzd zzvA() {
        return zzaAP;
    }

    zzc zzvB() {
        return zzaAQ;
    }

    boolean zzvC() {
        String str = zzaAP.get("appVersion");
        if (str == null || !str.equals(zzaAU)) {
            return true;
        }
        str = zzaAP.get("lastToken");
        if (str == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str)).longValue() > 604800;
    }

    KeyPair zzvy() {
        if (this.zzaAR == null) {
            this.zzaAR = zzaAP.zzdr(this.zzaAS);
        }
        if (this.zzaAR == null) {
            this.zzaAT = System.currentTimeMillis();
            this.zzaAR = zzaAP.zze(this.zzaAS, this.zzaAT);
        }
        return this.zzaAR;
    }

    void zzvz() {
        this.zzaAT = 0;
        zzaAP.zzds(this.zzaAS);
        this.zzaAR = null;
    }
}
