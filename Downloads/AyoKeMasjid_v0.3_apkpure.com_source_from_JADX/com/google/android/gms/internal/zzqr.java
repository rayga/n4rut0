package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqp.zzg;
import com.google.android.gms.tagmanager.zzbg;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzqr {
    public static final Integer zzaUg;
    public static final Integer zzaUh;
    private final Context mContext;
    private final ExecutorService zzaRv;

    /* renamed from: com.google.android.gms.internal.zzqr.1 */
    class C04101 implements Runnable {
        final /* synthetic */ String zzaUi;
        final /* synthetic */ Integer zzaUj;
        final /* synthetic */ zzql zzaUk;
        final /* synthetic */ zzqq zzaUl;
        final /* synthetic */ zzqr zzaUm;

        C04101(zzqr com_google_android_gms_internal_zzqr, String str, Integer num, zzql com_google_android_gms_internal_zzql, zzqq com_google_android_gms_internal_zzqq) {
            this.zzaUm = com_google_android_gms_internal_zzqr;
            this.zzaUi = str;
            this.zzaUj = num;
            this.zzaUk = com_google_android_gms_internal_zzql;
            this.zzaUl = com_google_android_gms_internal_zzqq;
        }

        public void run() {
            this.zzaUm.zzb(this.zzaUi, this.zzaUj, this.zzaUk, this.zzaUl);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqr.2 */
    class C04112 implements Runnable {
        final /* synthetic */ byte[] zzQu;
        final /* synthetic */ String zzaUi;
        final /* synthetic */ zzqr zzaUm;

        C04112(zzqr com_google_android_gms_internal_zzqr, String str, byte[] bArr) {
            this.zzaUm = com_google_android_gms_internal_zzqr;
            this.zzaUi = str;
            this.zzQu = bArr;
        }

        public void run() {
            this.zzaUm.zzf(this.zzaUi, this.zzQu);
        }
    }

    static {
        zzaUg = Integer.valueOf(0);
        zzaUh = Integer.valueOf(1);
    }

    public zzqr(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    zzqr(Context context, ExecutorService executorService) {
        this.mContext = context;
        this.zzaRv = executorService;
    }

    private String zzfr(String str) {
        return "resource_" + str;
    }

    private byte[] zzm(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zzlr.zza(inputStream, byteArrayOutputStream);
        } catch (IOException e) {
            zzbg.zzaE("Failed to read the resource from disk");
            return byteArrayOutputStream.toByteArray();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e2) {
                zzbg.zzaE("Error closing stream for reading resource from disk");
                return null;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void zza(String str, Integer num, zzql com_google_android_gms_internal_zzql, zzqq com_google_android_gms_internal_zzqq) {
        this.zzaRv.execute(new C04101(this, str, num, com_google_android_gms_internal_zzql, com_google_android_gms_internal_zzqq));
    }

    void zzb(String str, Integer num, zzql com_google_android_gms_internal_zzql, zzqq com_google_android_gms_internal_zzqq) {
        Object zzt;
        zzbg.m17v("DiskLoader: Starting to load resource from Disk.");
        try {
            zzt = com_google_android_gms_internal_zzql.zzt(zzm(new FileInputStream(zzfq(str))));
            if (zzt != null) {
                zzbg.m17v("Saved resource loaded: " + zzfr(str));
                com_google_android_gms_internal_zzqq.zza(Status.zzaaD, zzt, zzaUh, zzfp(str));
                return;
            }
        } catch (FileNotFoundException e) {
            zzbg.m16e("Saved resource not found: " + zzfr(str));
        } catch (zzg e2) {
            zzbg.m16e("Saved resource is corrupted: " + zzfr(str));
        }
        if (num == null) {
            com_google_android_gms_internal_zzqq.zza(Status.zzaaF, null, null, 0);
            return;
        }
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(num.intValue());
            if (openRawResource != null) {
                zzt = com_google_android_gms_internal_zzql.zzt(zzm(openRawResource));
                if (zzt != null) {
                    zzbg.m17v("Default resource loaded: " + this.mContext.getResources().getResourceEntryName(num.intValue()));
                    com_google_android_gms_internal_zzqq.zza(Status.zzaaD, zzt, zzaUg, 0);
                    return;
                }
            }
        } catch (NotFoundException e3) {
            zzbg.m16e("Default resource not found. ID: " + num);
        } catch (zzg e4) {
            zzbg.m16e("Default resource resource is corrupted: " + num);
        }
        com_google_android_gms_internal_zzqq.zza(Status.zzaaF, null, null, 0);
    }

    public void zze(String str, byte[] bArr) {
        this.zzaRv.execute(new C04112(this, str, bArr));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void zzf(java.lang.String r4, byte[] r5) {
        /*
        r3 = this;
        r0 = r3.zzfq(r4);
        r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x002c }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x002c }
        r1.write(r5);	 Catch:{ IOException -> 0x003a }
        r1.close();	 Catch:{ IOException -> 0x0033 }
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0033 }
        r0.<init>();	 Catch:{ IOException -> 0x0033 }
        r1 = "Resource ";
        r0 = r0.append(r1);	 Catch:{ IOException -> 0x0033 }
        r0 = r0.append(r4);	 Catch:{ IOException -> 0x0033 }
        r1 = " saved on Disk.";
        r0 = r0.append(r1);	 Catch:{ IOException -> 0x0033 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0033 }
        com.google.android.gms.tagmanager.zzbg.m17v(r0);	 Catch:{ IOException -> 0x0033 }
    L_0x002b:
        return;
    L_0x002c:
        r0 = move-exception;
        r0 = "Error opening resource file for writing";
        com.google.android.gms.tagmanager.zzbg.m16e(r0);
        goto L_0x002b;
    L_0x0033:
        r0 = move-exception;
        r0 = "Error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbg.m16e(r0);
        goto L_0x002b;
    L_0x003a:
        r2 = move-exception;
        r2 = "Error writing resource to disk. Removing resource from disk";
        com.google.android.gms.tagmanager.zzbg.m16e(r2);	 Catch:{ all -> 0x006a }
        r0.delete();	 Catch:{ all -> 0x006a }
        r1.close();	 Catch:{ IOException -> 0x0063 }
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0063 }
        r0.<init>();	 Catch:{ IOException -> 0x0063 }
        r1 = "Resource ";
        r0 = r0.append(r1);	 Catch:{ IOException -> 0x0063 }
        r0 = r0.append(r4);	 Catch:{ IOException -> 0x0063 }
        r1 = " saved on Disk.";
        r0 = r0.append(r1);	 Catch:{ IOException -> 0x0063 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0063 }
        com.google.android.gms.tagmanager.zzbg.m17v(r0);	 Catch:{ IOException -> 0x0063 }
        goto L_0x002b;
    L_0x0063:
        r0 = move-exception;
        r0 = "Error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbg.m16e(r0);
        goto L_0x002b;
    L_0x006a:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x008b }
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x008b }
        r1.<init>();	 Catch:{ IOException -> 0x008b }
        r2 = "Resource ";
        r1 = r1.append(r2);	 Catch:{ IOException -> 0x008b }
        r1 = r1.append(r4);	 Catch:{ IOException -> 0x008b }
        r2 = " saved on Disk.";
        r1 = r1.append(r2);	 Catch:{ IOException -> 0x008b }
        r1 = r1.toString();	 Catch:{ IOException -> 0x008b }
        com.google.android.gms.tagmanager.zzbg.m17v(r1);	 Catch:{ IOException -> 0x008b }
    L_0x008a:
        throw r0;
    L_0x008b:
        r1 = move-exception;
        r1 = "Error closing stream for writing resource to disk";
        com.google.android.gms.tagmanager.zzbg.m16e(r1);
        goto L_0x008a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqr.zzf(java.lang.String, byte[]):void");
    }

    public long zzfp(String str) {
        File zzfq = zzfq(str);
        return zzfq.exists() ? zzfq.lastModified() : 0;
    }

    File zzfq(String str) {
        return new File(this.mContext.getDir("google_tagmanager", 0), zzfr(str));
    }
}
