package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;
import org.bpmikc.akm.BuildConfig;

public class InstanceIDListenerService extends Service {
    static String ACTION;
    private static String zzaAX;
    private static String zzaAY;
    private static String zzazM;
    MessengerCompat zzaAV;
    BroadcastReceiver zzaAW;
    int zzaAZ;
    int zzaBa;

    /* renamed from: com.google.android.gms.iid.InstanceIDListenerService.1 */
    class C03161 extends Handler {
        final /* synthetic */ InstanceIDListenerService zzaBb;

        C03161(InstanceIDListenerService instanceIDListenerService, Looper looper) {
            this.zzaBb = instanceIDListenerService;
            super(looper);
        }

        public void handleMessage(Message msg) {
            this.zzaBb.zza(msg, MessengerCompat.zzc(msg));
        }
    }

    /* renamed from: com.google.android.gms.iid.InstanceIDListenerService.2 */
    class C03172 extends BroadcastReceiver {
        final /* synthetic */ InstanceIDListenerService zzaBb;

        C03172(InstanceIDListenerService instanceIDListenerService) {
            this.zzaBb = instanceIDListenerService;
        }

        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + intent.getExtras());
            }
            this.zzaBb.zzn(intent);
            this.zzaBb.stop();
        }
    }

    static {
        ACTION = "action";
        zzaAX = "google.com/iid";
        zzaAY = "CMD";
        zzazM = "gcm.googleapis.com/refresh";
    }

    public InstanceIDListenerService() {
        this.zzaAV = new MessengerCompat(new C03161(this, Looper.getMainLooper()));
        this.zzaAW = new C03172(this);
    }

    static void zza(Context context, zzd com_google_android_gms_iid_zzd) {
        com_google_android_gms_iid_zzd.zzvF();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(zzaAY, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    private void zza(Message message, int i) {
        zzc.zzaD(this);
        getPackageManager();
        if (i == zzc.zzaBh || i == zzc.zzaBg) {
            zzn((Intent) message.obj);
        } else {
            Log.w("InstanceID", "Message from unexpected caller " + i + " mine=" + zzc.zzaBg + " appid=" + zzc.zzaBh);
        }
    }

    static void zzaC(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(zzaAY, "SYNC");
        context.startService(intent);
    }

    public IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) ? null : this.zzaAV.getBinder();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.zzaAW, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.zzaAW);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        zzgz(startId);
        if (intent == null) {
            stop();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (VERSION.SDK_INT <= 18) {
                    Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                    if (intent2 != null) {
                        startService(intent2);
                        return 1;
                    }
                }
                zzn(intent);
            }
            stop();
            if (intent.getStringExtra("from") != null) {
                WakefulBroadcastReceiver.completeWakefulIntent(intent);
            }
            return 2;
        } finally {
            stop();
        }
    }

    public void onTokenRefresh() {
    }

    void stop() {
        synchronized (this) {
            this.zzaAZ--;
            if (this.zzaAZ == 0) {
                stopSelf(this.zzaBa);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Stop " + this.zzaAZ + " " + this.zzaBa);
            }
        }
    }

    public void zzaf(boolean z) {
        onTokenRefresh();
    }

    void zzgz(int i) {
        synchronized (this) {
            this.zzaAZ++;
            if (i > this.zzaBa) {
                this.zzaBa = i;
            }
        }
    }

    public void zzn(Intent intent) {
        InstanceID instance;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            instance = InstanceID.getInstance(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            instance = InstanceID.zza(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(zzaAY);
        if (intent.getStringExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR) == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Service command " + stringExtra + " " + stringExtra2 + " " + intent.getExtras());
            }
            if (intent.getStringExtra("unregistered") != null) {
                zzd zzvA = instance.zzvA();
                if (stringExtra == null) {
                    stringExtra = BuildConfig.FLAVOR;
                }
                zzvA.zzdt(stringExtra);
                instance.zzvB().zzr(intent);
                return;
            } else if (zzazM.equals(intent.getStringExtra("from"))) {
                instance.zzvA().zzdt(stringExtra);
                zzaf(false);
                return;
            } else if ("RST".equals(stringExtra2)) {
                instance.zzvz();
                zzaf(true);
                return;
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!instance.zzvA().isEmpty()) {
                    instance.zzvA().zzvF();
                    zzaf(true);
                    return;
                }
                return;
            } else if ("SYNC".equals(stringExtra2)) {
                instance.zzvA().zzdt(stringExtra);
                zzaf(false);
                return;
            } else if ("PING".equals(stringExtra2)) {
                try {
                    GoogleCloudMessaging.getInstance(this).send(zzaAX, zzc.zzvE(), 0, intent.getExtras());
                    return;
                } catch (IOException e) {
                    Log.w("InstanceID", "Failed to send ping response");
                    return;
                }
            } else {
                return;
            }
        }
        if (Log.isLoggable("InstanceID", 3)) {
            Log.d("InstanceID", "Register result in service " + stringExtra);
        }
        instance.zzvB().zzr(intent);
    }
}
