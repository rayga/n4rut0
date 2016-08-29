package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.PendingResult.BatchCallback;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.events.CompletionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzb<R extends Result> implements PendingResult<R> {
    private boolean zzL;
    private final Object zzYD;
    protected final zza<R> zzYE;
    private final ArrayList<BatchCallback> zzYF;
    private ResultCallback<R> zzYG;
    private volatile R zzYH;
    private volatile boolean zzYI;
    private boolean zzYJ;
    private zzq zzYK;
    private final CountDownLatch zzoR;

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    Pair pair = (Pair) msg.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    ((zzb) msg.obj).zzw(Status.zzaaG);
                default:
                    Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
            }
        }

        public void zza(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzb<R> com_google_android_gms_common_api_zzb_R, long j) {
            sendMessageDelayed(obtainMessage(2, com_google_android_gms_common_api_zzb_R), j);
        }

        protected void zzb(ResultCallback<R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzb.zzc(r);
                throw e;
            }
        }

        public void zzna() {
            removeMessages(2);
        }
    }

    protected zzb(Looper looper) {
        this.zzYD = new Object();
        this.zzoR = new CountDownLatch(1);
        this.zzYF = new ArrayList();
        this.zzYE = new zza(looper);
    }

    protected zzb(zza<R> com_google_android_gms_common_api_zzb_zza_R) {
        this.zzYD = new Object();
        this.zzoR = new CountDownLatch(1);
        this.zzYF = new ArrayList();
        this.zzYE = (zza) zzx.zzb((Object) com_google_android_gms_common_api_zzb_zza_R, (Object) "CallbackHandler must not be null");
    }

    private R get() {
        R r;
        boolean z = true;
        synchronized (this.zzYD) {
            if (this.zzYI) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed.");
            zzx.zza(isReady(), (Object) "Result is not ready.");
            r = this.zzYH;
            this.zzYH = null;
            this.zzYG = null;
            this.zzYI = true;
        }
        zzmZ();
        return r;
    }

    private void zzb(R r) {
        this.zzYH = r;
        this.zzYK = null;
        this.zzoR.countDown();
        Status status = this.zzYH.getStatus();
        if (this.zzYG != null) {
            this.zzYE.zzna();
            if (!this.zzL) {
                this.zzYE.zza(this.zzYG, get());
            }
        }
        Iterator it = this.zzYF.iterator();
        while (it.hasNext()) {
            ((BatchCallback) it.next()).onComplete(status);
        }
        this.zzYF.clear();
    }

    static void zzc(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                Log.w("AbstractPendingResult", "Unable to release " + result, e);
            }
        }
    }

    public final void addBatchCallback(BatchCallback callback) {
        zzx.zza(!this.zzYI, (Object) "Result has already been consumed.");
        synchronized (this.zzYD) {
            if (isReady()) {
                callback.onComplete(this.zzYH.getStatus());
            } else {
                this.zzYF.add(callback);
            }
        }
    }

    public final R await() {
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        if (this.zzYI) {
            z = false;
        }
        zzx.zza(z, (Object) "Result has already been consumed");
        try {
            this.zzoR.await();
        } catch (InterruptedException e) {
            zzw(Status.zzaaE);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public final R await(long time, TimeUnit units) {
        boolean z = true;
        boolean z2 = time <= 0 || Looper.myLooper() != Looper.getMainLooper();
        zzx.zza(z2, (Object) "await must not be called on the UI thread when time is greater than zero.");
        if (this.zzYI) {
            z = false;
        }
        zzx.zza(z, (Object) "Result has already been consumed.");
        try {
            if (!this.zzoR.await(time, units)) {
                zzw(Status.zzaaG);
            }
        } catch (InterruptedException e) {
            zzw(Status.zzaaE);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public void cancel() {
        synchronized (this.zzYD) {
            if (this.zzL || this.zzYI) {
                return;
            }
            if (this.zzYK != null) {
                try {
                    this.zzYK.cancel();
                } catch (RemoteException e) {
                }
            }
            zzc(this.zzYH);
            this.zzYG = null;
            this.zzL = true;
            zzb(zzb(Status.zzaaH));
        }
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzYD) {
            z = this.zzL;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzoR.getCount() == 0;
    }

    public final void setResultCallback(ResultCallback<R> callback) {
        zzx.zza(!this.zzYI, (Object) "Result has already been consumed.");
        synchronized (this.zzYD) {
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.zzYE.zza((ResultCallback) callback, get());
            } else {
                this.zzYG = callback;
            }
        }
    }

    public final void setResultCallback(ResultCallback<R> callback, long time, TimeUnit units) {
        zzx.zza(!this.zzYI, (Object) "Result has already been consumed.");
        synchronized (this.zzYD) {
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.zzYE.zza((ResultCallback) callback, get());
            } else {
                this.zzYG = callback;
                this.zzYE.zza(this, units.toMillis(time));
            }
        }
    }

    public final void zza(R r) {
        boolean z = true;
        synchronized (this.zzYD) {
            if (this.zzYJ || this.zzL) {
                zzc(r);
                return;
            }
            zzx.zza(!isReady(), (Object) "Results have already been set");
            if (this.zzYI) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed");
            zzb((Result) r);
        }
    }

    protected final void zza(zzq com_google_android_gms_common_internal_zzq) {
        synchronized (this.zzYD) {
            this.zzYK = com_google_android_gms_common_internal_zzq;
        }
    }

    protected abstract R zzb(Status status);

    protected void zzmZ() {
    }

    public final void zzw(Status status) {
        synchronized (this.zzYD) {
            if (!isReady()) {
                zza(zzb(status));
                this.zzYJ = true;
            }
        }
    }
}
