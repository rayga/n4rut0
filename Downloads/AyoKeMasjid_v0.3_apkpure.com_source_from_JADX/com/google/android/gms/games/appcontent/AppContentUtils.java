package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzli;
import java.util.ArrayList;

public final class AppContentUtils {

    private interface AppContentRunner {
        void zzb(ArrayList<DataHolder> arrayList, int i);
    }

    /* renamed from: com.google.android.gms.games.appcontent.AppContentUtils.1 */
    static class C07371 implements AppContentRunner {
        final /* synthetic */ ArrayList zzasA;

        C07371(ArrayList arrayList) {
            this.zzasA = arrayList;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            this.zzasA.add(new AppContentActionRef(arrayList, i));
        }
    }

    /* renamed from: com.google.android.gms.games.appcontent.AppContentUtils.2 */
    static class C07382 implements AppContentRunner {
        final /* synthetic */ ArrayList zzasA;

        C07382(ArrayList arrayList) {
            this.zzasA = arrayList;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            this.zzasA.add(new AppContentAnnotationRef(arrayList, i));
        }
    }

    /* renamed from: com.google.android.gms.games.appcontent.AppContentUtils.3 */
    static class C07393 implements AppContentRunner {
        final /* synthetic */ ArrayList zzasA;

        C07393(ArrayList arrayList) {
            this.zzasA = arrayList;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            this.zzasA.add(new AppContentConditionRef(arrayList, i));
        }
    }

    /* renamed from: com.google.android.gms.games.appcontent.AppContentUtils.4 */
    static class C07404 implements AppContentRunner {
        final /* synthetic */ DataHolder zzasB;
        final /* synthetic */ Bundle zzasC;

        C07404(DataHolder dataHolder, Bundle bundle) {
            this.zzasB = dataHolder;
            this.zzasC = bundle;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            AppContentTuple appContentTupleRef = new AppContentTupleRef(this.zzasB, i);
            this.zzasC.putString(appContentTupleRef.getName(), appContentTupleRef.getValue());
        }
    }

    public static ArrayList<AppContentAction> zza(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentAction> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 1, str2, "action_id", i, new C07371(arrayList2), arrayList);
        return arrayList2;
    }

    private static void zza(DataHolder dataHolder, int i, String str, String str2, int i2, AppContentRunner appContentRunner, ArrayList<DataHolder> arrayList) {
        DataHolder dataHolder2 = (DataHolder) arrayList.get(i);
        Object zzd = dataHolder.zzd(str, i2, dataHolder.zzbo(i2));
        if (!TextUtils.isEmpty(zzd)) {
            int count = dataHolder2.getCount();
            String[] split = zzd.split(",");
            for (int i3 = 0; i3 < count; i3++) {
                CharSequence zzd2 = dataHolder2.zzd(str2, i3, dataHolder2.zzbo(i3));
                if (!TextUtils.isEmpty(zzd2) && zzli.zzb(split, zzd2)) {
                    appContentRunner.zzb(arrayList, i3);
                }
            }
        }
    }

    public static ArrayList<AppContentAnnotation> zzb(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentAnnotation> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 2, str2, "annotation_id", i, new C07382(arrayList2), arrayList);
        return arrayList2;
    }

    public static ArrayList<AppContentCondition> zzc(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentCondition> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 4, str2, "condition_id", i, new C07393(arrayList2), arrayList);
        return arrayList2;
    }

    public static Bundle zzd(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        Bundle bundle = new Bundle();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 3, str2, "tuple_id", i, new C07404((DataHolder) arrayList.get(3), bundle), arrayList);
        return bundle;
    }
}
