package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener, zzc {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private final String mName;
    int zzacB;
    private CountDownLatch zzahA;
    zza zzahB;
    boolean zzahC;

    /* renamed from: com.google.android.gms.drive.events.DriveEventService.1 */
    class C02761 extends Thread {
        final /* synthetic */ CountDownLatch zzahD;
        final /* synthetic */ DriveEventService zzahE;

        C02761(DriveEventService driveEventService, CountDownLatch countDownLatch) {
            this.zzahE = driveEventService;
            this.zzahD = countDownLatch;
        }

        public void run() {
            try {
                Looper.prepare();
                this.zzahE.zzahB = new zza(this.zzahE);
                this.zzahE.zzahC = false;
                this.zzahD.countDown();
                zzy.zzv("DriveEventService", "Bound and starting loop");
                Looper.loop();
                zzy.zzv("DriveEventService", "Finished loop");
                if (this.zzahE.zzahA != null) {
                    this.zzahE.zzahA.countDown();
                }
            } catch (Throwable th) {
                if (this.zzahE.zzahA != null) {
                    this.zzahE.zzahA.countDown();
                }
            }
        }
    }

    final class zza extends Handler {
        final /* synthetic */ DriveEventService zzahE;

        zza(DriveEventService driveEventService) {
            this.zzahE = driveEventService;
        }

        private Message zzb(OnEventResponse onEventResponse) {
            return obtainMessage(1, onEventResponse);
        }

        private Message zzqz() {
            return obtainMessage(2);
        }

        public void handleMessage(Message msg) {
            zzy.zzv("DriveEventService", "handleMessage message type:" + msg.what);
            switch (msg.what) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    this.zzahE.zza((OnEventResponse) msg.obj);
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    getLooper().quit();
                default:
                    zzy.zzw("DriveEventService", "Unexpected message type:" + msg.what);
            }
        }
    }

    final class zzb extends com.google.android.gms.drive.internal.zzan.zza {
        final /* synthetic */ DriveEventService zzahE;

        zzb(DriveEventService driveEventService) {
            this.zzahE = driveEventService;
        }

        public void zzc(OnEventResponse onEventResponse) throws RemoteException {
            synchronized (this.zzahE) {
                zzy.zzv("DriveEventService", "onEvent: " + onEventResponse);
                this.zzahE.zzqy();
                if (this.zzahE.zzahB != null) {
                    this.zzahE.zzahB.sendMessage(this.zzahE.zzahB.zzb(onEventResponse));
                } else {
                    zzy.zzx("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String name) {
        this.zzahC = false;
        this.zzacB = -1;
        this.mName = name;
    }

    private void zza(OnEventResponse onEventResponse) {
        DriveEvent zzqS = onEventResponse.zzqS();
        zzy.zzv("DriveEventService", "handleEventMessage: " + zzqS);
        try {
            switch (zzqS.getType()) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    onChange((ChangeEvent) zzqS);
                    return;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    onCompletion((CompletionEvent) zzqS);
                    return;
                case Barcode.PHONE /*4*/:
                    zza((ChangesAvailableEvent) zzqS);
                    return;
                default:
                    zzy.zzw(this.mName, "Unhandled event: " + zzqS);
                    return;
            }
        } catch (Throwable e) {
            zzy.zza(this.mName, e, "Error handling event: " + zzqS);
        }
        zzy.zza(this.mName, e, "Error handling event: " + zzqS);
    }

    private void zzqy() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.zzacB) {
            if (GooglePlayServicesUtil.zze(this, callingUid)) {
                this.zzacB = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final synchronized IBinder onBind(Intent intent) {
        IBinder asBinder;
        if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            if (this.zzahB == null && !this.zzahC) {
                this.zzahC = true;
                CountDownLatch countDownLatch = new CountDownLatch(1);
                this.zzahA = new CountDownLatch(1);
                new C02761(this, countDownLatch).start();
                try {
                    if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                        zzy.zzx("DriveEventService", "Failed to synchronously initialize event handler.");
                    }
                } catch (Throwable e) {
                    throw new RuntimeException("Unable to start event handler", e);
                }
            }
            asBinder = new zzb(this).asBinder();
        } else {
            asBinder = null;
        }
        return asBinder;
    }

    public void onChange(ChangeEvent event) {
        zzy.zzw(this.mName, "Unhandled change event: " + event);
    }

    public void onCompletion(CompletionEvent event) {
        zzy.zzw(this.mName, "Unhandled completion event: " + event);
    }

    public synchronized void onDestroy() {
        zzy.zzv("DriveEventService", "onDestroy");
        if (this.zzahB != null) {
            this.zzahB.sendMessage(this.zzahB.zzqz());
            this.zzahB = null;
            try {
                if (!this.zzahA.await(5000, TimeUnit.MILLISECONDS)) {
                    zzy.zzw("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException e) {
            }
            this.zzahA = null;
        }
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }

    public void zza(ChangesAvailableEvent changesAvailableEvent) {
        zzy.zzw(this.mName, "Unhandled changes available event: " + changesAvailableEvent);
    }
}
