package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.tagmanager.zzbf.zza;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bpmikc.akm.BuildConfig;

class zzcl implements Runnable {
    private final Context mContext;
    private final String zzaOS;
    private volatile String zzaPp;
    private final zzqw zzaRm;
    private final String zzaRn;
    private zzbf<zzj> zzaRo;
    private volatile zzs zzaRp;
    private volatile String zzaRq;

    zzcl(Context context, String str, zzqw com_google_android_gms_internal_zzqw, zzs com_google_android_gms_tagmanager_zzs) {
        this.mContext = context;
        this.zzaRm = com_google_android_gms_internal_zzqw;
        this.zzaOS = str;
        this.zzaRp = com_google_android_gms_tagmanager_zzs;
        this.zzaRn = "/r?id=" + str;
        this.zzaPp = this.zzaRn;
        this.zzaRq = null;
    }

    public zzcl(Context context, String str, zzs com_google_android_gms_tagmanager_zzs) {
        this(context, str, new zzqw(), com_google_android_gms_tagmanager_zzs);
    }

    private boolean zzAy() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbg.m17v("...no network connectivity");
        return false;
    }

    private void zzAz() {
        if (zzAy()) {
            zzbg.m17v("Start loading resource from network ...");
            String zzAA = zzAA();
            zzqv zzBW = this.zzaRm.zzBW();
            try {
                InputStream zzfs = zzBW.zzfs(zzAA);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    zzqp.zzc(zzfs, byteArrayOutputStream);
                    zzj zzd = zzj.zzd(byteArrayOutputStream.toByteArray());
                    zzbg.m17v("Successfully loaded supplemented resource: " + zzd);
                    if (zzd.zziR == null && zzd.zziQ.length == 0) {
                        zzbg.m17v("No change for container: " + this.zzaOS);
                    }
                    this.zzaRo.zzB(zzd);
                    zzbg.m17v("Load resource from network finished.");
                } catch (Throwable e) {
                    zzbg.zzd("Error when parsing downloaded resources from url: " + zzAA + " " + e.getMessage(), e);
                    this.zzaRo.zza(zza.SERVER_ERROR);
                    zzBW.close();
                }
            } catch (FileNotFoundException e2) {
                zzbg.zzaE("No data is retrieved from the given url: " + zzAA + ". Make sure container_id: " + this.zzaOS + " is correct.");
                this.zzaRo.zza(zza.SERVER_ERROR);
            } catch (Throwable e3) {
                zzbg.zzd("Error when loading resources from url: " + zzAA + " " + e3.getMessage(), e3);
                this.zzaRo.zza(zza.IO_ERROR);
            } finally {
                zzBW.close();
            }
        } else {
            this.zzaRo.zza(zza.NOT_AVAILABLE);
        }
    }

    public void run() {
        if (this.zzaRo == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.zzaRo.zzzL();
        zzAz();
    }

    String zzAA() {
        String str = this.zzaRp.zzzN() + this.zzaPp + "&v=a65833898";
        if (!(this.zzaRq == null || this.zzaRq.trim().equals(BuildConfig.FLAVOR))) {
            str = str + "&pv=" + this.zzaRq;
        }
        return zzcb.zzAv().zzAw().equals(zza.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    void zza(zzbf<zzj> com_google_android_gms_tagmanager_zzbf_com_google_android_gms_internal_zzaf_zzj) {
        this.zzaRo = com_google_android_gms_tagmanager_zzbf_com_google_android_gms_internal_zzaf_zzj;
    }

    void zzeB(String str) {
        if (str == null) {
            this.zzaPp = this.zzaRn;
            return;
        }
        zzbg.zzaC("Setting CTFE URL path: " + str);
        this.zzaPp = str;
    }

    void zzeQ(String str) {
        zzbg.zzaC("Setting previous container version: " + str);
        this.zzaRq = str;
    }
}
