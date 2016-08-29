package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.nearby.connection.Connections;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
import org.bpmikc.akm.BuildConfig;

public class zzbm {
    private final int zzse;
    private final int zzsf;
    private final int zzsg;
    private final zzbl zzsh;

    /* renamed from: com.google.android.gms.internal.zzbm.1 */
    class C03311 implements Comparator<String> {
        final /* synthetic */ zzbm zzsi;

        C03311(zzbm com_google_android_gms_internal_zzbm) {
            this.zzsi = com_google_android_gms_internal_zzbm;
        }

        public int compare(String s1, String s2) {
            return s2.length() - s1.length();
        }
    }

    /* renamed from: com.google.android.gms.internal.zzbm.2 */
    class C03322 implements Comparator<com.google.android.gms.internal.zzbp.zza> {
        final /* synthetic */ zzbm zzsi;

        C03322(zzbm com_google_android_gms_internal_zzbm) {
            this.zzsi = com_google_android_gms_internal_zzbm;
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return zza((com.google.android.gms.internal.zzbp.zza) x0, (com.google.android.gms.internal.zzbp.zza) x1);
        }

        public int zza(com.google.android.gms.internal.zzbp.zza com_google_android_gms_internal_zzbp_zza, com.google.android.gms.internal.zzbp.zza com_google_android_gms_internal_zzbp_zza2) {
            return (int) (com_google_android_gms_internal_zzbp_zza.value - com_google_android_gms_internal_zzbp_zza2.value);
        }
    }

    static class zza {
        ByteArrayOutputStream zzsj;
        Base64OutputStream zzsk;

        public zza() {
            this.zzsj = new ByteArrayOutputStream(Connections.MAX_RELIABLE_MESSAGE_LEN);
            this.zzsk = new Base64OutputStream(this.zzsj, 10);
        }

        public String toString() {
            String byteArrayOutputStream;
            try {
                this.zzsk.close();
            } catch (Throwable e) {
                zzb.zzb("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.zzsj.close();
                byteArrayOutputStream = this.zzsj.toString();
            } catch (Throwable e2) {
                zzb.zzb("HashManager: Unable to convert to Base64.", e2);
                byteArrayOutputStream = BuildConfig.FLAVOR;
            } finally {
                this.zzsj = null;
                this.zzsk = null;
            }
            return byteArrayOutputStream;
        }

        public void write(byte[] data) throws IOException {
            this.zzsk.write(data);
        }
    }

    public zzbm(int i) {
        this.zzsh = new zzbo();
        this.zzsf = i;
        this.zzse = 6;
        this.zzsg = 0;
    }

    private String zzA(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return BuildConfig.FLAVOR;
        }
        zza zzcz = zzcz();
        Arrays.sort(split, new C03311(this));
        int i = 0;
        while (i < split.length && i < this.zzsf) {
            if (split[i].trim().length() != 0) {
                try {
                    zzcz.write(this.zzsh.zzz(split[i]));
                } catch (Throwable e) {
                    zzb.zzb("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        return zzcz.toString();
    }

    String zzB(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return BuildConfig.FLAVOR;
        }
        zza zzcz = zzcz();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzsf, new C03322(this));
        for (String zzD : split) {
            String[] zzD2 = zzbn.zzD(zzD);
            if (zzD2.length >= this.zzse) {
                zzbp.zza(zzD2, this.zzsf, this.zzse, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzcz.write(this.zzsh.zzz(((com.google.android.gms.internal.zzbp.zza) it.next()).zzsm));
            } catch (Throwable e) {
                zzb.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzcz.toString();
    }

    public String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.zzsg) {
            case SpinnerCompat.MODE_DIALOG /*0*/:
                return zzB(stringBuffer.toString());
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return zzA(stringBuffer.toString());
            default:
                return BuildConfig.FLAVOR;
        }
    }

    zza zzcz() {
        return new zza();
    }
}
