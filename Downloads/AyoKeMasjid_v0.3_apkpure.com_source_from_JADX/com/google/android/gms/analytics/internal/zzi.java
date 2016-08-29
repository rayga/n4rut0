package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import java.util.Collections;

public class zzi extends zzd {
    private final zza zzLW;
    private zzac zzLX;
    private final zzt zzLY;
    private zzaj zzLZ;

    protected class zza implements ServiceConnection {
        final /* synthetic */ zzi zzMa;
        private volatile zzac zzMb;
        private volatile boolean zzMc;

        /* renamed from: com.google.android.gms.analytics.internal.zzi.zza.1 */
        class C02461 implements Runnable {
            final /* synthetic */ zzac zzMd;
            final /* synthetic */ zza zzMe;

            C02461(zza com_google_android_gms_analytics_internal_zzi_zza, zzac com_google_android_gms_analytics_internal_zzac) {
                this.zzMe = com_google_android_gms_analytics_internal_zzi_zza;
                this.zzMd = com_google_android_gms_analytics_internal_zzac;
            }

            public void run() {
                if (!this.zzMe.zzMa.isConnected()) {
                    this.zzMe.zzMa.zzaZ("Connected to service after a timeout");
                    this.zzMe.zzMa.zza(this.zzMd);
                }
            }
        }

        /* renamed from: com.google.android.gms.analytics.internal.zzi.zza.2 */
        class C02472 implements Runnable {
            final /* synthetic */ zza zzMe;
            final /* synthetic */ ComponentName zzMf;

            C02472(zza com_google_android_gms_analytics_internal_zzi_zza, ComponentName componentName) {
                this.zzMe = com_google_android_gms_analytics_internal_zzi_zza;
                this.zzMf = componentName;
            }

            public void run() {
                this.zzMe.zzMa.onServiceDisconnected(this.zzMf);
            }
        }

        protected zza(zzi com_google_android_gms_analytics_internal_zzi) {
            this.zzMa = com_google_android_gms_analytics_internal_zzi;
        }

        public void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.google.android.gms.analytics.internal.zzi.zza.onServiceConnected(android.content.ComponentName, android.os.IBinder):void. bs: [B:3:0x0008, B:9:0x0015]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:57)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
            /*
            r4 = this;
            r0 = "AnalyticsServiceConnection.onServiceConnected";
            com.google.android.gms.common.internal.zzx.zzch(r0);
            monitor-enter(r4);
            if (r6 != 0) goto L_0x0014;
        L_0x0008:
            r0 = r4.zzMa;	 Catch:{ all -> 0x005a }
            r1 = "Service connected with null binder";	 Catch:{ all -> 0x005a }
            r0.zzbc(r1);	 Catch:{ all -> 0x005a }
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
        L_0x0013:
            return;
        L_0x0014:
            r0 = 0;
            r1 = r6.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x0051 }
            r2 = "com.google.android.gms.analytics.internal.IAnalyticsService";	 Catch:{ RemoteException -> 0x0051 }
            r2 = r2.equals(r1);	 Catch:{ RemoteException -> 0x0051 }
            if (r2 == 0) goto L_0x0049;	 Catch:{ RemoteException -> 0x0051 }
        L_0x0021:
            r0 = com.google.android.gms.analytics.internal.zzac.zza.zzae(r6);	 Catch:{ RemoteException -> 0x0051 }
            r1 = r4.zzMa;	 Catch:{ RemoteException -> 0x0051 }
            r2 = "Bound to IAnalyticsService interface";	 Catch:{ RemoteException -> 0x0051 }
            r1.zzaY(r2);	 Catch:{ RemoteException -> 0x0051 }
        L_0x002c:
            if (r0 != 0) goto L_0x005f;
        L_0x002e:
            r0 = com.google.android.gms.common.stats.zzb.zzpD();	 Catch:{ IllegalArgumentException -> 0x007c }
            r1 = r4.zzMa;	 Catch:{ IllegalArgumentException -> 0x007c }
            r1 = r1.getContext();	 Catch:{ IllegalArgumentException -> 0x007c }
            r2 = r4.zzMa;	 Catch:{ IllegalArgumentException -> 0x007c }
            r2 = r2.zzLW;	 Catch:{ IllegalArgumentException -> 0x007c }
            r0.zza(r1, r2);	 Catch:{ IllegalArgumentException -> 0x007c }
        L_0x0041:
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
            goto L_0x0013;	 Catch:{ all -> 0x0046 }
        L_0x0046:
            r0 = move-exception;	 Catch:{ all -> 0x0046 }
            monitor-exit(r4);	 Catch:{ all -> 0x0046 }
            throw r0;
        L_0x0049:
            r2 = r4.zzMa;	 Catch:{ RemoteException -> 0x0051 }
            r3 = "Got binder with a wrong descriptor";	 Catch:{ RemoteException -> 0x0051 }
            r2.zze(r3, r1);	 Catch:{ RemoteException -> 0x0051 }
            goto L_0x002c;
        L_0x0051:
            r1 = move-exception;
            r1 = r4.zzMa;	 Catch:{ all -> 0x005a }
            r2 = "Service connect failed to get IAnalyticsService";	 Catch:{ all -> 0x005a }
            r1.zzbc(r2);	 Catch:{ all -> 0x005a }
            goto L_0x002c;
        L_0x005a:
            r0 = move-exception;
            r4.notifyAll();	 Catch:{ all -> 0x0046 }
            throw r0;	 Catch:{ all -> 0x0046 }
        L_0x005f:
            r1 = r4.zzMc;	 Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x0079;	 Catch:{ all -> 0x005a }
        L_0x0063:
            r1 = r4.zzMa;	 Catch:{ all -> 0x005a }
            r2 = "onServiceConnected received after the timeout limit";	 Catch:{ all -> 0x005a }
            r1.zzbb(r2);	 Catch:{ all -> 0x005a }
            r1 = r4.zzMa;	 Catch:{ all -> 0x005a }
            r1 = r1.zzig();	 Catch:{ all -> 0x005a }
            r2 = new com.google.android.gms.analytics.internal.zzi$zza$1;	 Catch:{ all -> 0x005a }
            r2.<init>(r4, r0);	 Catch:{ all -> 0x005a }
            r1.zzf(r2);	 Catch:{ all -> 0x005a }
            goto L_0x0041;	 Catch:{ all -> 0x005a }
        L_0x0079:
            r4.zzMb = r0;	 Catch:{ all -> 0x005a }
            goto L_0x0041;
        L_0x007c:
            r0 = move-exception;
            goto L_0x0041;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzi.zza.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public void onServiceDisconnected(ComponentName name) {
            zzx.zzch("AnalyticsServiceConnection.onServiceDisconnected");
            this.zzMa.zzig().zzf(new C02472(this, name));
        }

        public zzac zziD() {
            zzac com_google_android_gms_analytics_internal_zzac = null;
            this.zzMa.zzic();
            Intent intent = new Intent("com.google.android.gms.analytics.service.START");
            intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
            Context context = this.zzMa.getContext();
            intent.putExtra("app_package_name", context.getPackageName());
            zzb zzpD = zzb.zzpD();
            synchronized (this) {
                this.zzMb = null;
                this.zzMc = true;
                boolean zza = zzpD.zza(context, intent, this.zzMa.zzLW, 129);
                this.zzMa.zza("Bind to service requested", Boolean.valueOf(zza));
                if (zza) {
                    try {
                        wait(this.zzMa.zzif().zzjG());
                    } catch (InterruptedException e) {
                        this.zzMa.zzbb("Wait for service connect was interrupted");
                    }
                    this.zzMc = false;
                    com_google_android_gms_analytics_internal_zzac = this.zzMb;
                    this.zzMb = null;
                    if (com_google_android_gms_analytics_internal_zzac == null) {
                        this.zzMa.zzbc("Successfully bound to service but never got onServiceConnected callback");
                    }
                } else {
                    this.zzMc = false;
                }
            }
            return com_google_android_gms_analytics_internal_zzac;
        }
    }

    /* renamed from: com.google.android.gms.analytics.internal.zzi.1 */
    class C06861 extends zzt {
        final /* synthetic */ zzi zzMa;

        C06861(zzi com_google_android_gms_analytics_internal_zzi, zzf com_google_android_gms_analytics_internal_zzf) {
            this.zzMa = com_google_android_gms_analytics_internal_zzi;
            super(com_google_android_gms_analytics_internal_zzf);
        }

        public void run() {
            this.zzMa.zziC();
        }
    }

    protected zzi(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
        this.zzLZ = new zzaj(com_google_android_gms_analytics_internal_zzf.zzid());
        this.zzLW = new zza(this);
        this.zzLY = new C06861(this, com_google_android_gms_analytics_internal_zzf);
    }

    private void onDisconnect() {
        zzhz().zzhX();
    }

    private void onServiceDisconnected(ComponentName name) {
        zzic();
        if (this.zzLX != null) {
            this.zzLX = null;
            zza("Disconnected from device AnalyticsService", name);
            onDisconnect();
        }
    }

    private void zza(zzac com_google_android_gms_analytics_internal_zzac) {
        zzic();
        this.zzLX = com_google_android_gms_analytics_internal_zzac;
        zziB();
        zzhz().onServiceConnected();
    }

    private void zziB() {
        this.zzLZ.start();
        this.zzLY.zzt(zzif().zzjF());
    }

    private void zziC() {
        zzic();
        if (isConnected()) {
            zzaY("Inactivity, disconnecting from device AnalyticsService");
            disconnect();
        }
    }

    public boolean connect() {
        zzic();
        zzio();
        if (this.zzLX != null) {
            return true;
        }
        zzac zziD = this.zzLW.zziD();
        if (zziD == null) {
            return false;
        }
        this.zzLX = zziD;
        zziB();
        return true;
    }

    public void disconnect() {
        zzic();
        zzio();
        try {
            zzb.zzpD().zza(getContext(), this.zzLW);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        if (this.zzLX != null) {
            this.zzLX = null;
            onDisconnect();
        }
    }

    public boolean isConnected() {
        zzic();
        zzio();
        return this.zzLX != null;
    }

    public boolean zzb(zzab com_google_android_gms_analytics_internal_zzab) {
        zzx.zzv(com_google_android_gms_analytics_internal_zzab);
        zzic();
        zzio();
        zzac com_google_android_gms_analytics_internal_zzac = this.zzLX;
        if (com_google_android_gms_analytics_internal_zzac == null) {
            return false;
        }
        try {
            com_google_android_gms_analytics_internal_zzac.zza(com_google_android_gms_analytics_internal_zzab.zzn(), com_google_android_gms_analytics_internal_zzab.zzkk(), com_google_android_gms_analytics_internal_zzab.zzkm() ? zzif().zzjy() : zzif().zzjz(), Collections.emptyList());
            zziB();
            return true;
        } catch (RemoteException e) {
            zzaY("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    protected void zzhB() {
    }

    public boolean zziA() {
        zzic();
        zzio();
        zzac com_google_android_gms_analytics_internal_zzac = this.zzLX;
        if (com_google_android_gms_analytics_internal_zzac == null) {
            return false;
        }
        try {
            com_google_android_gms_analytics_internal_zzac.zzhU();
            zziB();
            return true;
        } catch (RemoteException e) {
            zzaY("Failed to clear hits from AnalyticsService");
            return false;
        }
    }
}
