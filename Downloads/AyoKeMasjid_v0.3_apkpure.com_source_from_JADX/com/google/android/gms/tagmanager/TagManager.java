package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager zzaSv;
    private final Context mContext;
    private final DataLayer zzaOT;
    private final zzs zzaRp;
    private final zza zzaSs;
    private final zzct zzaSt;
    private final ConcurrentMap<zzo, Boolean> zzaSu;

    /* renamed from: com.google.android.gms.tagmanager.TagManager.3 */
    class C04383 implements ComponentCallbacks2 {
        final /* synthetic */ TagManager zzaSw;

        C04383(TagManager tagManager) {
            this.zzaSw = tagManager;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
        }

        public void onTrimMemory(int i) {
            if (i == 20) {
                this.zzaSw.dispatch();
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.4 */
    static /* synthetic */ class C04394 {
        static final /* synthetic */ int[] zzaSx;

        static {
            zzaSx = new int[zza.values().length];
            try {
                zzaSx[zza.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                zzaSx[zza.CONTAINER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                zzaSx[zza.CONTAINER_DEBUG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public interface zza {
        zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs com_google_android_gms_tagmanager_zzs);
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.1 */
    class C08291 implements zzb {
        final /* synthetic */ TagManager zzaSw;

        C08291(TagManager tagManager) {
            this.zzaSw = tagManager;
        }

        public void zzH(Map<String, Object> map) {
            Object obj = map.get(DataLayer.EVENT_KEY);
            if (obj != null) {
                this.zzaSw.zzeU(obj.toString());
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.TagManager.2 */
    static class C08302 implements zza {
        C08302() {
        }

        public zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs com_google_android_gms_tagmanager_zzs) {
            return new zzp(context, tagManager, looper, str, i, com_google_android_gms_tagmanager_zzs);
        }
    }

    TagManager(Context context, zza containerHolderLoaderProvider, DataLayer dataLayer, zzct serviceManager) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.zzaSt = serviceManager;
        this.zzaSs = containerHolderLoaderProvider;
        this.zzaSu = new ConcurrentHashMap();
        this.zzaOT = dataLayer;
        this.zzaOT.zza(new C08291(this));
        this.zzaOT.zza(new zzd(this.mContext));
        this.zzaRp = new zzs();
        zzAU();
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zzaSv == null) {
                if (context == null) {
                    zzbg.m16e("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                zzaSv = new TagManager(context, new C08302(), new DataLayer(new zzw(context)), zzcu.zzAP());
            }
            tagManager = zzaSv;
        }
        return tagManager;
    }

    private void zzAU() {
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new C04383(this));
        }
    }

    private void zzeU(String str) {
        for (zzo zzew : this.zzaSu.keySet()) {
            zzew.zzew(str);
        }
    }

    public void dispatch() {
        this.zzaSt.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.zzaOT;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        PendingResult zza = this.zzaSs.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzaRp);
        zza.zzzH();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult zza = this.zzaSs.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzaRp);
        zza.zzzH();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        PendingResult zza = this.zzaSs.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzaRp);
        zza.zzzJ();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult zza = this.zzaSs.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzaRp);
        zza.zzzJ();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        PendingResult zza = this.zzaSs.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzaRp);
        zza.zzzI();
        return zza;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        PendingResult zza = this.zzaSs.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzaRp);
        zza.zzzI();
        return zza;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        zzbg.setLogLevel(enableVerboseLogging ? 2 : 5);
    }

    void zza(zzo com_google_android_gms_tagmanager_zzo) {
        this.zzaSu.put(com_google_android_gms_tagmanager_zzo, Boolean.valueOf(true));
    }

    boolean zzb(zzo com_google_android_gms_tagmanager_zzo) {
        return this.zzaSu.remove(com_google_android_gms_tagmanager_zzo) != null;
    }

    public PendingResult<ContainerHolder> zzc(String str, int i, String str2) {
        PendingResult zza = this.zzaSs.zza(this.mContext, this, null, str, i, this.zzaRp);
        zza.load(str2);
        return zza;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized boolean zzm(android.net.Uri r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r1 = com.google.android.gms.tagmanager.zzcb.zzAv();	 Catch:{ all -> 0x0049 }
        r0 = r1.zzm(r6);	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x0085;
    L_0x000b:
        r2 = r1.getContainerId();	 Catch:{ all -> 0x0049 }
        r0 = com.google.android.gms.tagmanager.TagManager.C04394.zzaSx;	 Catch:{ all -> 0x0049 }
        r3 = r1.zzAw();	 Catch:{ all -> 0x0049 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0049 }
        r0 = r0[r3];	 Catch:{ all -> 0x0049 }
        switch(r0) {
            case 1: goto L_0x0021;
            case 2: goto L_0x004c;
            case 3: goto L_0x004c;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = 1;
    L_0x001f:
        monitor-exit(r5);
        return r0;
    L_0x0021:
        r0 = r5.zzaSu;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r1 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x002b:
        r0 = r1.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x0031:
        r0 = r1.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.zzo) r0;	 Catch:{ all -> 0x0049 }
        r3 = r0.getContainerId();	 Catch:{ all -> 0x0049 }
        r3 = r3.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r3 == 0) goto L_0x002b;
    L_0x0041:
        r3 = 0;
        r0.zzey(r3);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x002b;
    L_0x0049:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x004c:
        r0 = r5.zzaSu;	 Catch:{ all -> 0x0049 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0049 }
        r3 = r0.iterator();	 Catch:{ all -> 0x0049 }
    L_0x0056:
        r0 = r3.hasNext();	 Catch:{ all -> 0x0049 }
        if (r0 == 0) goto L_0x001e;
    L_0x005c:
        r0 = r3.next();	 Catch:{ all -> 0x0049 }
        r0 = (com.google.android.gms.tagmanager.zzo) r0;	 Catch:{ all -> 0x0049 }
        r4 = r0.getContainerId();	 Catch:{ all -> 0x0049 }
        r4 = r4.equals(r2);	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0077;
    L_0x006c:
        r4 = r1.zzAx();	 Catch:{ all -> 0x0049 }
        r0.zzey(r4);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0077:
        r4 = r0.zzzE();	 Catch:{ all -> 0x0049 }
        if (r4 == 0) goto L_0x0056;
    L_0x007d:
        r4 = 0;
        r0.zzey(r4);	 Catch:{ all -> 0x0049 }
        r0.refresh();	 Catch:{ all -> 0x0049 }
        goto L_0x0056;
    L_0x0085:
        r0 = 0;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.TagManager.zzm(android.net.Uri):boolean");
    }
}
