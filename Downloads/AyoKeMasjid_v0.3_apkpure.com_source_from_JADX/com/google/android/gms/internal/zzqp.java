package com.google.android.gms.internal;

import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zzaf.zzh;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bpmikc.akm.BuildConfig;

public class zzqp {

    public static class zza {
        private final com.google.android.gms.internal.zzag.zza zzaRQ;
        private final Map<String, com.google.android.gms.internal.zzag.zza> zzaTS;

        private zza(Map<String, com.google.android.gms.internal.zzag.zza> map, com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) {
            this.zzaTS = map;
            this.zzaRQ = com_google_android_gms_internal_zzag_zza;
        }

        public static zzb zzBC() {
            return new zzb();
        }

        public String toString() {
            return "Properties: " + zzBD() + " pushAfterEvaluate: " + this.zzaRQ;
        }

        public com.google.android.gms.internal.zzag.zza zzAI() {
            return this.zzaRQ;
        }

        public Map<String, com.google.android.gms.internal.zzag.zza> zzBD() {
            return Collections.unmodifiableMap(this.zzaTS);
        }

        public void zza(String str, com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) {
            this.zzaTS.put(str, com_google_android_gms_internal_zzag_zza);
        }
    }

    public static class zzb {
        private com.google.android.gms.internal.zzag.zza zzaRQ;
        private final Map<String, com.google.android.gms.internal.zzag.zza> zzaTS;

        private zzb() {
            this.zzaTS = new HashMap();
        }

        public zza zzBE() {
            return new zza(this.zzaRQ, null);
        }

        public zzb zzb(String str, com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) {
            this.zzaTS.put(str, com_google_android_gms_internal_zzag_zza);
            return this;
        }

        public zzb zzq(com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) {
            this.zzaRQ = com_google_android_gms_internal_zzag_zza;
            return this;
        }
    }

    public static class zzc {
        private final String zzWs;
        private final List<zze> zzaTT;
        private final Map<String, List<zza>> zzaTU;
        private final int zzaTV;

        private zzc(List<zze> list, Map<String, List<zza>> map, String str, int i) {
            this.zzaTT = Collections.unmodifiableList(list);
            this.zzaTU = Collections.unmodifiableMap(map);
            this.zzWs = str;
            this.zzaTV = i;
        }

        public static zzd zzBF() {
            return new zzd();
        }

        public String getVersion() {
            return this.zzWs;
        }

        public String toString() {
            return "Rules: " + zzBG() + "  Macros: " + this.zzaTU;
        }

        public List<zze> zzBG() {
            return this.zzaTT;
        }

        public Map<String, List<zza>> zzBH() {
            return this.zzaTU;
        }
    }

    public static class zzd {
        private String zzWs;
        private final List<zze> zzaTT;
        private final Map<String, List<zza>> zzaTU;
        private int zzaTV;

        private zzd() {
            this.zzaTT = new ArrayList();
            this.zzaTU = new HashMap();
            this.zzWs = BuildConfig.FLAVOR;
            this.zzaTV = 0;
        }

        public zzc zzBI() {
            return new zzc(this.zzaTU, this.zzWs, this.zzaTV, null);
        }

        public zzd zzb(zze com_google_android_gms_internal_zzqp_zze) {
            this.zzaTT.add(com_google_android_gms_internal_zzqp_zze);
            return this;
        }

        public zzd zzc(zza com_google_android_gms_internal_zzqp_zza) {
            String zzg = zzdf.zzg((com.google.android.gms.internal.zzag.zza) com_google_android_gms_internal_zzqp_zza.zzBD().get(zzae.INSTANCE_NAME.toString()));
            List list = (List) this.zzaTU.get(zzg);
            if (list == null) {
                list = new ArrayList();
                this.zzaTU.put(zzg, list);
            }
            list.add(com_google_android_gms_internal_zzqp_zza);
            return this;
        }

        public zzd zzfk(String str) {
            this.zzWs = str;
            return this;
        }

        public zzd zzjm(int i) {
            this.zzaTV = i;
            return this;
        }
    }

    public static class zze {
        private final List<zza> zzaTW;
        private final List<zza> zzaTX;
        private final List<zza> zzaTY;
        private final List<zza> zzaTZ;
        private final List<zza> zzaUa;
        private final List<zza> zzaUb;
        private final List<String> zzaUc;
        private final List<String> zzaUd;
        private final List<String> zzaUe;
        private final List<String> zzaUf;

        private zze(List<zza> list, List<zza> list2, List<zza> list3, List<zza> list4, List<zza> list5, List<zza> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.zzaTW = Collections.unmodifiableList(list);
            this.zzaTX = Collections.unmodifiableList(list2);
            this.zzaTY = Collections.unmodifiableList(list3);
            this.zzaTZ = Collections.unmodifiableList(list4);
            this.zzaUa = Collections.unmodifiableList(list5);
            this.zzaUb = Collections.unmodifiableList(list6);
            this.zzaUc = Collections.unmodifiableList(list7);
            this.zzaUd = Collections.unmodifiableList(list8);
            this.zzaUe = Collections.unmodifiableList(list9);
            this.zzaUf = Collections.unmodifiableList(list10);
        }

        public static zzf zzBJ() {
            return new zzf();
        }

        public String toString() {
            return "Positive predicates: " + zzBK() + "  Negative predicates: " + zzBL() + "  Add tags: " + zzBM() + "  Remove tags: " + zzBN() + "  Add macros: " + zzBO() + "  Remove macros: " + zzBT();
        }

        public List<zza> zzBK() {
            return this.zzaTW;
        }

        public List<zza> zzBL() {
            return this.zzaTX;
        }

        public List<zza> zzBM() {
            return this.zzaTY;
        }

        public List<zza> zzBN() {
            return this.zzaTZ;
        }

        public List<zza> zzBO() {
            return this.zzaUa;
        }

        public List<String> zzBP() {
            return this.zzaUc;
        }

        public List<String> zzBQ() {
            return this.zzaUd;
        }

        public List<String> zzBR() {
            return this.zzaUe;
        }

        public List<String> zzBS() {
            return this.zzaUf;
        }

        public List<zza> zzBT() {
            return this.zzaUb;
        }
    }

    public static class zzf {
        private final List<zza> zzaTW;
        private final List<zza> zzaTX;
        private final List<zza> zzaTY;
        private final List<zza> zzaTZ;
        private final List<zza> zzaUa;
        private final List<zza> zzaUb;
        private final List<String> zzaUc;
        private final List<String> zzaUd;
        private final List<String> zzaUe;
        private final List<String> zzaUf;

        private zzf() {
            this.zzaTW = new ArrayList();
            this.zzaTX = new ArrayList();
            this.zzaTY = new ArrayList();
            this.zzaTZ = new ArrayList();
            this.zzaUa = new ArrayList();
            this.zzaUb = new ArrayList();
            this.zzaUc = new ArrayList();
            this.zzaUd = new ArrayList();
            this.zzaUe = new ArrayList();
            this.zzaUf = new ArrayList();
        }

        public zze zzBU() {
            return new zze(this.zzaTX, this.zzaTY, this.zzaTZ, this.zzaUa, this.zzaUb, this.zzaUc, this.zzaUd, this.zzaUe, this.zzaUf, null);
        }

        public zzf zzd(zza com_google_android_gms_internal_zzqp_zza) {
            this.zzaTW.add(com_google_android_gms_internal_zzqp_zza);
            return this;
        }

        public zzf zze(zza com_google_android_gms_internal_zzqp_zza) {
            this.zzaTX.add(com_google_android_gms_internal_zzqp_zza);
            return this;
        }

        public zzf zzf(zza com_google_android_gms_internal_zzqp_zza) {
            this.zzaTY.add(com_google_android_gms_internal_zzqp_zza);
            return this;
        }

        public zzf zzfl(String str) {
            this.zzaUe.add(str);
            return this;
        }

        public zzf zzfm(String str) {
            this.zzaUf.add(str);
            return this;
        }

        public zzf zzfn(String str) {
            this.zzaUc.add(str);
            return this;
        }

        public zzf zzfo(String str) {
            this.zzaUd.add(str);
            return this;
        }

        public zzf zzg(zza com_google_android_gms_internal_zzqp_zza) {
            this.zzaTZ.add(com_google_android_gms_internal_zzqp_zza);
            return this;
        }

        public zzf zzh(zza com_google_android_gms_internal_zzqp_zza) {
            this.zzaUa.add(com_google_android_gms_internal_zzqp_zza);
            return this;
        }

        public zzf zzi(zza com_google_android_gms_internal_zzqp_zza) {
            this.zzaUb.add(com_google_android_gms_internal_zzqp_zza);
            return this;
        }
    }

    public static class zzg extends Exception {
        public zzg(String str) {
            super(str);
        }
    }

    private static com.google.android.gms.internal.zzag.zza zza(int i, com.google.android.gms.internal.zzaf.zzf com_google_android_gms_internal_zzaf_zzf, com.google.android.gms.internal.zzag.zza[] com_google_android_gms_internal_zzag_zzaArr, Set<Integer> set) throws zzg {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            zzfi("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza = (com.google.android.gms.internal.zzag.zza) zza(com_google_android_gms_internal_zzaf_zzf.zzif, i, "values");
        if (com_google_android_gms_internal_zzag_zzaArr[i] != null) {
            return com_google_android_gms_internal_zzag_zzaArr[i];
        }
        com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza2 = null;
        set.add(Integer.valueOf(i));
        zzh zzp;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (com_google_android_gms_internal_zzag_zza.type) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
            case Barcode.PRODUCT /*5*/:
            case Barcode.SMS /*6*/:
            case Barcode.URL /*8*/:
                com_google_android_gms_internal_zzag_zza2 = com_google_android_gms_internal_zzag_zza;
                break;
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                zzp = zzp(com_google_android_gms_internal_zzag_zza);
                com_google_android_gms_internal_zzag_zza2 = zzo(com_google_android_gms_internal_zzag_zza);
                com_google_android_gms_internal_zzag_zza2.zziV = new com.google.android.gms.internal.zzag.zza[zzp.zziG.length];
                iArr = zzp.zziG;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzag_zza2.zziV[i3] = zza(iArr[i2], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case CompletionEvent.STATUS_CANCELED /*3*/:
                com_google_android_gms_internal_zzag_zza2 = zzo(com_google_android_gms_internal_zzag_zza);
                zzh zzp2 = zzp(com_google_android_gms_internal_zzag_zza);
                if (zzp2.zziH.length != zzp2.zziI.length) {
                    zzfi("Uneven map keys (" + zzp2.zziH.length + ") and map values (" + zzp2.zziI.length + ")");
                }
                com_google_android_gms_internal_zzag_zza2.zziW = new com.google.android.gms.internal.zzag.zza[zzp2.zziH.length];
                com_google_android_gms_internal_zzag_zza2.zziX = new com.google.android.gms.internal.zzag.zza[zzp2.zziH.length];
                int[] iArr2 = zzp2.zziH;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    com_google_android_gms_internal_zzag_zza2.zziW[i4] = zza(iArr2[i3], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = zzp2.zziI;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzag_zza2.zziX[i3] = zza(iArr[i2], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case Barcode.PHONE /*4*/:
                com_google_android_gms_internal_zzag_zza2 = zzo(com_google_android_gms_internal_zzag_zza);
                com_google_android_gms_internal_zzag_zza2.zziY = zzdf.zzg(zza(zzp(com_google_android_gms_internal_zzag_zza).zziL, com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, (Set) set));
                break;
            case Barcode.TEXT /*7*/:
                com_google_android_gms_internal_zzag_zza2 = zzo(com_google_android_gms_internal_zzag_zza);
                zzp = zzp(com_google_android_gms_internal_zzag_zza);
                com_google_android_gms_internal_zzag_zza2.zzjc = new com.google.android.gms.internal.zzag.zza[zzp.zziK.length];
                iArr = zzp.zziK;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    com_google_android_gms_internal_zzag_zza2.zzjc[i3] = zza(iArr[i2], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (com_google_android_gms_internal_zzag_zza2 == null) {
            zzfi("Invalid value: " + com_google_android_gms_internal_zzag_zza);
        }
        com_google_android_gms_internal_zzag_zzaArr[i] = com_google_android_gms_internal_zzag_zza2;
        set.remove(Integer.valueOf(i));
        return com_google_android_gms_internal_zzag_zza2;
    }

    private static zza zza(com.google.android.gms.internal.zzaf.zzb com_google_android_gms_internal_zzaf_zzb, com.google.android.gms.internal.zzaf.zzf com_google_android_gms_internal_zzaf_zzf, com.google.android.gms.internal.zzag.zza[] com_google_android_gms_internal_zzag_zzaArr, int i) throws zzg {
        zzb zzBC = zza.zzBC();
        for (int valueOf : com_google_android_gms_internal_zzaf_zzb.zzhQ) {
            com.google.android.gms.internal.zzaf.zze com_google_android_gms_internal_zzaf_zze = (com.google.android.gms.internal.zzaf.zze) zza(com_google_android_gms_internal_zzaf_zzf.zzig, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) zza(com_google_android_gms_internal_zzaf_zzf.zzie, com_google_android_gms_internal_zzaf_zze.key, "keys");
            com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza = (com.google.android.gms.internal.zzag.zza) zza(com_google_android_gms_internal_zzag_zzaArr, com_google_android_gms_internal_zzaf_zze.value, "values");
            if (zzae.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzBC.zzq(com_google_android_gms_internal_zzag_zza);
            } else {
                zzBC.zzb(str, com_google_android_gms_internal_zzag_zza);
            }
        }
        return zzBC.zzBE();
    }

    private static zze zza(com.google.android.gms.internal.zzaf.zzg com_google_android_gms_internal_zzaf_zzg, List<zza> list, List<zza> list2, List<zza> list3, com.google.android.gms.internal.zzaf.zzf com_google_android_gms_internal_zzaf_zzf) {
        zzf zzBJ = zze.zzBJ();
        for (int valueOf : com_google_android_gms_internal_zzaf_zzg.zziu) {
            zzBJ.zzd((zza) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : com_google_android_gms_internal_zzaf_zzg.zziv) {
            zzBJ.zze((zza) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : com_google_android_gms_internal_zzaf_zzg.zziw) {
            zzBJ.zzf((zza) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : com_google_android_gms_internal_zzaf_zzg.zziy) {
            zzBJ.zzfl(com_google_android_gms_internal_zzaf_zzf.zzif[Integer.valueOf(valueOf3).intValue()].zziU);
        }
        for (int valueOf222 : com_google_android_gms_internal_zzaf_zzg.zzix) {
            zzBJ.zzg((zza) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : com_google_android_gms_internal_zzaf_zzg.zziz) {
            zzBJ.zzfm(com_google_android_gms_internal_zzaf_zzf.zzif[Integer.valueOf(valueOf32).intValue()].zziU);
        }
        for (int valueOf2222 : com_google_android_gms_internal_zzaf_zzg.zziA) {
            zzBJ.zzh((zza) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : com_google_android_gms_internal_zzaf_zzg.zziC) {
            zzBJ.zzfn(com_google_android_gms_internal_zzaf_zzf.zzif[Integer.valueOf(valueOf322).intValue()].zziU);
        }
        for (int valueOf22222 : com_google_android_gms_internal_zzaf_zzg.zziB) {
            zzBJ.zzi((zza) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : com_google_android_gms_internal_zzaf_zzg.zziD) {
            zzBJ.zzfo(com_google_android_gms_internal_zzaf_zzf.zzif[Integer.valueOf(valueOf4).intValue()].zziU);
        }
        return zzBJ.zzBU();
    }

    private static <T> T zza(T[] tArr, int i, String str) throws zzg {
        if (i < 0 || i >= tArr.length) {
            zzfi("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static zzc zzb(com.google.android.gms.internal.zzaf.zzf com_google_android_gms_internal_zzaf_zzf) throws zzg {
        int i;
        int i2 = 0;
        com.google.android.gms.internal.zzag.zza[] com_google_android_gms_internal_zzag_zzaArr = new com.google.android.gms.internal.zzag.zza[com_google_android_gms_internal_zzaf_zzf.zzif.length];
        for (i = 0; i < com_google_android_gms_internal_zzaf_zzf.zzif.length; i++) {
            zza(i, com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, new HashSet(0));
        }
        zzd zzBF = zzc.zzBF();
        List arrayList = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzaf_zzf.zzii.length; i++) {
            arrayList.add(zza(com_google_android_gms_internal_zzaf_zzf.zzii[i], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzaf_zzf.zzij.length; i++) {
            arrayList2.add(zza(com_google_android_gms_internal_zzaf_zzf.zzij[i], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < com_google_android_gms_internal_zzaf_zzf.zzih.length; i++) {
            zza zza = zza(com_google_android_gms_internal_zzaf_zzf.zzih[i], com_google_android_gms_internal_zzaf_zzf, com_google_android_gms_internal_zzag_zzaArr, i);
            zzBF.zzc(zza);
            arrayList3.add(zza);
        }
        com.google.android.gms.internal.zzaf.zzg[] com_google_android_gms_internal_zzaf_zzgArr = com_google_android_gms_internal_zzaf_zzf.zzik;
        int length = com_google_android_gms_internal_zzaf_zzgArr.length;
        while (i2 < length) {
            zzBF.zzb(zza(com_google_android_gms_internal_zzaf_zzgArr[i2], arrayList, arrayList3, arrayList2, com_google_android_gms_internal_zzaf_zzf));
            i2++;
        }
        zzBF.zzfk(com_google_android_gms_internal_zzaf_zzf.version);
        zzBF.zzjm(com_google_android_gms_internal_zzaf_zzf.zzis);
        return zzBF.zzBI();
    }

    public static void zzc(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[Barcode.UPC_E];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void zzfi(String str) throws zzg {
        zzbg.m16e(str);
        throw new zzg(str);
    }

    public static com.google.android.gms.internal.zzag.zza zzo(com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) {
        com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza2 = new com.google.android.gms.internal.zzag.zza();
        com_google_android_gms_internal_zzag_zza2.type = com_google_android_gms_internal_zzag_zza.type;
        com_google_android_gms_internal_zzag_zza2.zzjd = (int[]) com_google_android_gms_internal_zzag_zza.zzjd.clone();
        if (com_google_android_gms_internal_zzag_zza.zzje) {
            com_google_android_gms_internal_zzag_zza2.zzje = com_google_android_gms_internal_zzag_zza.zzje;
        }
        return com_google_android_gms_internal_zzag_zza2;
    }

    private static zzh zzp(com.google.android.gms.internal.zzag.zza com_google_android_gms_internal_zzag_zza) throws zzg {
        if (((zzh) com_google_android_gms_internal_zzag_zza.zza(zzh.zziE)) == null) {
            zzfi("Expected a ServingValue and didn't get one. Value is: " + com_google_android_gms_internal_zzag_zza);
        }
        return (zzh) com_google_android_gms_internal_zzag_zza.zza(zzh.zziE);
    }
}
