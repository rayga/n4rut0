package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.vision.barcode.Barcode;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class zzi implements GoogleApiClient {
    private final Context mContext;
    private final Looper zzYV;
    final zzf zzZH;
    final Map<Api<?>, Integer> zzZI;
    private final Condition zzZX;
    final zzk zzZY;
    final Queue<zze<?>> zzZZ;
    private final int zzZf;
    private final int zzZg;
    private final GoogleApiAvailability zzZi;
    final com.google.android.gms.common.api.Api.zza<? extends com.google.android.gms.signin.zzd, com.google.android.gms.signin.zze> zzZj;
    private final Lock zzZs;
    private volatile boolean zzaaa;
    private long zzaab;
    private long zzaac;
    private final zza zzaad;
    BroadcastReceiver zzaae;
    final Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> zzaaf;
    final Map<com.google.android.gms.common.api.Api.zzc<?>, ConnectionResult> zzaag;
    Set<Scope> zzaah;
    private volatile zzj zzaai;
    private ConnectionResult zzaaj;
    private final Set<zzl<?>> zzaak;
    final Set<zze<?>> zzaal;
    private final zzd zzaam;
    private final ConnectionCallbacks zzaan;
    private final com.google.android.gms.common.internal.zzk.zza zzaao;

    /* renamed from: com.google.android.gms.common.api.zzi.8 */
    class C02718 implements Runnable {
        final /* synthetic */ zzi zzaap;
        final /* synthetic */ FragmentActivity zzaav;

        C02718(zzi com_google_android_gms_common_api_zzi, FragmentActivity fragmentActivity) {
            this.zzaap = com_google_android_gms_common_api_zzi;
            this.zzaav = fragmentActivity;
        }

        public void run() {
            if (!this.zzaav.isFinishing() && !this.zzaav.getSupportFragmentManager().isDestroyed()) {
                zzp.zzb(this.zzaav).zzbi(this.zzaap.zzZf);
            }
        }
    }

    final class zza extends Handler {
        final /* synthetic */ zzi zzaap;

        zza(zzi com_google_android_gms_common_api_zzi, Looper looper) {
            this.zzaap = com_google_android_gms_common_api_zzi;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    this.zzaap.zznC();
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    this.zzaap.resume();
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    ((zzb) msg.obj).zzf(this.zzaap);
                case Barcode.PHONE /*4*/:
                    throw ((RuntimeException) msg.obj);
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + msg.what);
            }
        }
    }

    static abstract class zzb {
        private final zzj zzaaw;

        protected zzb(zzj com_google_android_gms_common_api_zzj) {
            this.zzaaw = com_google_android_gms_common_api_zzj;
        }

        public final void zzf(zzi com_google_android_gms_common_api_zzi) {
            com_google_android_gms_common_api_zzi.zzZs.lock();
            try {
                if (com_google_android_gms_common_api_zzi.zzaai == this.zzaaw) {
                    zznn();
                    com_google_android_gms_common_api_zzi.zzZs.unlock();
                }
            } finally {
                com_google_android_gms_common_api_zzi.zzZs.unlock();
            }
        }

        protected abstract void zznn();
    }

    private static class zzc extends BroadcastReceiver {
        private WeakReference<zzi> zzaax;

        zzc(zzi com_google_android_gms_common_api_zzi) {
            this.zzaax = new WeakReference(com_google_android_gms_common_api_zzi);
        }

        public void onReceive(Context context, Intent intent) {
            Uri data = intent.getData();
            String str = null;
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (str != null && str.equals(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE)) {
                zzi com_google_android_gms_common_api_zzi = (zzi) this.zzaax.get();
                if (com_google_android_gms_common_api_zzi != null) {
                    com_google_android_gms_common_api_zzi.resume();
                }
            }
        }
    }

    interface zzd {
        void zzc(zze<?> com_google_android_gms_common_api_zzi_zze_);
    }

    interface zze<A extends com.google.android.gms.common.api.Api.zzb> {
        void cancel();

        void zza(zzd com_google_android_gms_common_api_zzi_zzd);

        void zzb(A a) throws DeadObjectException;

        com.google.android.gms.common.api.Api.zzc<A> zznd();

        int zzng();

        void zzw(Status status);

        void zzx(Status status);
    }

    /* renamed from: com.google.android.gms.common.api.zzi.1 */
    class C07111 implements zzd {
        final /* synthetic */ zzi zzaap;

        C07111(zzi com_google_android_gms_common_api_zzi) {
            this.zzaap = com_google_android_gms_common_api_zzi;
        }

        public void zzc(zze<?> com_google_android_gms_common_api_zzi_zze_) {
            this.zzaap.zzaal.remove(com_google_android_gms_common_api_zzi_zze_);
        }
    }

    /* renamed from: com.google.android.gms.common.api.zzi.2 */
    class C07122 implements ConnectionCallbacks {
        final /* synthetic */ zzi zzaap;

        C07122(zzi com_google_android_gms_common_api_zzi) {
            this.zzaap = com_google_android_gms_common_api_zzi;
        }

        public void onConnected(Bundle connectionHint) {
            this.zzaap.zzZs.lock();
            try {
                this.zzaap.zzaai.onConnected(connectionHint);
            } finally {
                this.zzaap.zzZs.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            this.zzaap.zzZs.lock();
            try {
                this.zzaap.zzaai.onConnectionSuspended(cause);
            } finally {
                this.zzaap.zzZs.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.zzi.3 */
    class C07133 implements com.google.android.gms.common.internal.zzk.zza {
        final /* synthetic */ zzi zzaap;

        C07133(zzi com_google_android_gms_common_api_zzi) {
            this.zzaap = com_google_android_gms_common_api_zzi;
        }

        public boolean isConnected() {
            return this.zzaap.isConnected();
        }

        public Bundle zzmw() {
            return null;
        }
    }

    /* renamed from: com.google.android.gms.common.api.zzi.4 */
    class C07144 implements OnConnectionFailedListener {
        final /* synthetic */ zzi zzaap;
        final /* synthetic */ Api zzaaq;
        final /* synthetic */ int zzaar;

        C07144(zzi com_google_android_gms_common_api_zzi, Api api, int i) {
            this.zzaap = com_google_android_gms_common_api_zzi;
            this.zzaaq = api;
            this.zzaar = i;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.zzaap.zzZs.lock();
            try {
                this.zzaap.zzaai.zza(result, this.zzaaq, this.zzaar);
            } finally {
                this.zzaap.zzZs.unlock();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.zzi.5 */
    class C07155 implements ConnectionCallbacks {
        final /* synthetic */ zzi zzaap;
        final /* synthetic */ AtomicReference zzaas;
        final /* synthetic */ zzo zzaat;

        C07155(zzi com_google_android_gms_common_api_zzi, AtomicReference atomicReference, zzo com_google_android_gms_common_api_zzo) {
            this.zzaap = com_google_android_gms_common_api_zzi;
            this.zzaas = atomicReference;
            this.zzaat = com_google_android_gms_common_api_zzo;
        }

        public void onConnected(Bundle connectionHint) {
            this.zzaap.zza((GoogleApiClient) this.zzaas.get(), this.zzaat, true);
        }

        public void onConnectionSuspended(int cause) {
        }
    }

    /* renamed from: com.google.android.gms.common.api.zzi.6 */
    class C07166 implements OnConnectionFailedListener {
        final /* synthetic */ zzi zzaap;
        final /* synthetic */ zzo zzaat;

        C07166(zzi com_google_android_gms_common_api_zzi, zzo com_google_android_gms_common_api_zzo) {
            this.zzaap = com_google_android_gms_common_api_zzi;
            this.zzaat = com_google_android_gms_common_api_zzo;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.zzaat.zza(new Status(8));
        }
    }

    /* renamed from: com.google.android.gms.common.api.zzi.7 */
    class C07177 implements ResultCallback<Status> {
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ zzi zzaap;
        final /* synthetic */ zzo zzaat;
        final /* synthetic */ boolean zzaau;

        C07177(zzi com_google_android_gms_common_api_zzi, zzo com_google_android_gms_common_api_zzo, boolean z, GoogleApiClient googleApiClient) {
            this.zzaap = com_google_android_gms_common_api_zzi;
            this.zzaat = com_google_android_gms_common_api_zzo;
            this.zzaau = z;
            this.zzVc = googleApiClient;
        }

        public /* synthetic */ void onResult(Result x0) {
            zzr((Status) x0);
        }

        public void zzr(Status status) {
            if (status.isSuccess() && this.zzaap.isConnected()) {
                this.zzaap.reconnect();
            }
            this.zzaat.zza((Result) status);
            if (this.zzaau) {
                this.zzVc.disconnect();
            }
        }
    }

    public zzi(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, GoogleApiAvailability googleApiAvailability, com.google.android.gms.common.api.Api.zza<? extends com.google.android.gms.signin.zzd, com.google.android.gms.signin.zze> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_signin_zzd__com_google_android_gms_signin_zze, Map<Api<?>, ApiOptions> map, ArrayList<ConnectionCallbacks> arrayList, ArrayList<OnConnectionFailedListener> arrayList2, int i, int i2) {
        this.zzZs = new ReentrantLock();
        this.zzZZ = new LinkedList();
        this.zzaab = 120000;
        this.zzaac = 5000;
        this.zzaaf = new HashMap();
        this.zzaag = new HashMap();
        this.zzaah = new HashSet();
        this.zzaaj = null;
        this.zzaak = Collections.newSetFromMap(new WeakHashMap());
        this.zzaal = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
        this.zzaam = new C07111(this);
        this.zzaan = new C07122(this);
        this.zzaao = new C07133(this);
        this.mContext = context;
        this.zzZY = new zzk(looper, this.zzaao);
        this.zzYV = looper;
        this.zzaad = new zza(this, looper);
        this.zzZi = googleApiAvailability;
        this.zzZf = i;
        this.zzZg = i2;
        this.zzZI = new HashMap();
        this.zzZX = this.zzZs.newCondition();
        this.zzaai = new zzh(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.zzZY.registerConnectionCallbacks((ConnectionCallbacks) it.next());
        }
        it = arrayList2.iterator();
        while (it.hasNext()) {
            this.zzZY.registerConnectionFailedListener((OnConnectionFailedListener) it.next());
        }
        Map zzok = com_google_android_gms_common_internal_zzf.zzok();
        for (Api api : map.keySet()) {
            int i3;
            Object obj = map.get(api);
            if (zzok.get(api) != null) {
                i3 = ((com.google.android.gms.common.internal.zzf.zza) zzok.get(api)).zzadg ? 1 : 2;
            } else {
                i3 = 0;
            }
            this.zzZI.put(api, Integer.valueOf(i3));
            this.zzaaf.put(api.zznd(), api.zzne() ? zza(api.zznc(), obj, context, looper, com_google_android_gms_common_internal_zzf, this.zzaan, zza(api, i3)) : zza(api.zznb(), obj, context, looper, com_google_android_gms_common_internal_zzf, this.zzaan, zza(api, i3)));
        }
        this.zzZH = com_google_android_gms_common_internal_zzf;
        this.zzZj = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_signin_zzd__com_google_android_gms_signin_zze;
    }

    private void resume() {
        this.zzZs.lock();
        try {
            if (zznB()) {
                connect();
            }
            this.zzZs.unlock();
        } catch (Throwable th) {
            this.zzZs.unlock();
        }
    }

    private static <C extends com.google.android.gms.common.api.Api.zzb, O> C zza(com.google.android.gms.common.api.Api.zza<C, O> com_google_android_gms_common_api_Api_zza_C__O, Object obj, Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return com_google_android_gms_common_api_Api_zza_C__O.zza(context, looper, com_google_android_gms_common_internal_zzf, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private final OnConnectionFailedListener zza(Api<?> api, int i) {
        return new C07144(this, api, i);
    }

    private static <C extends com.google.android.gms.common.api.Api.zzd, O> zzac zza(com.google.android.gms.common.api.Api.zze<C, O> com_google_android_gms_common_api_Api_zze_C__O, Object obj, Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zzac(context, looper, com_google_android_gms_common_api_Api_zze_C__O.zznf(), connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf, com_google_android_gms_common_api_Api_zze_C__O.zzm(obj));
    }

    private void zza(GoogleApiClient googleApiClient, zzo com_google_android_gms_common_api_zzo, boolean z) {
        zzkw.zzaet.zzc(googleApiClient).setResultCallback(new C07177(this, com_google_android_gms_common_api_zzo, z, googleApiClient));
    }

    private void zznC() {
        this.zzZs.lock();
        try {
            if (zznE()) {
                connect();
            }
            this.zzZs.unlock();
        } catch (Throwable th) {
            this.zzZs.unlock();
        }
    }

    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzZs.lock();
        try {
            connect();
            while (isConnecting()) {
                this.zzZX.await();
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.zzYi;
            } else if (this.zzaaj != null) {
                connectionResult = this.zzaaj;
                this.zzZs.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zzZs.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zzZs.unlock();
        }
        return connectionResult;
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        ConnectionResult connectionResult;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzZs.lock();
        try {
            connect();
            long toNanos = unit.toNanos(timeout);
            while (isConnecting()) {
                toNanos = this.zzZX.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.zzYi;
                this.zzZs.unlock();
            } else if (this.zzaaj != null) {
                connectionResult = this.zzaaj;
                this.zzZs.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zzZs.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zzZs.unlock();
        }
        return connectionResult;
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzx.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzo com_google_android_gms_common_api_zzo = new zzo(this.zzYV);
        if (this.zzaaf.containsKey(zzkw.zzQf)) {
            zza(this, com_google_android_gms_common_api_zzo, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            ConnectionCallbacks c07155 = new C07155(this, atomicReference, com_google_android_gms_common_api_zzo);
            GoogleApiClient build = new Builder(this.mContext).addApi(zzkw.API).addConnectionCallbacks(c07155).addOnConnectionFailedListener(new C07166(this, com_google_android_gms_common_api_zzo)).setHandler(this.zzaad).build();
            atomicReference.set(build);
            build.connect();
        }
        return com_google_android_gms_common_api_zzo;
    }

    public void connect() {
        this.zzZs.lock();
        try {
            this.zzaai.connect();
        } finally {
            this.zzZs.unlock();
        }
    }

    public void disconnect() {
        this.zzZs.lock();
        try {
            zznE();
            this.zzaai.disconnect();
        } finally {
            this.zzZs.unlock();
        }
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append(prefix).append("mState=").append(this.zzaai.getName());
        writer.append(" mResuming=").print(this.zzaaa);
        writer.append(" mWorkQueue.size()=").print(this.zzZZ.size());
        writer.append(" mUnconsumedRunners.size()=").println(this.zzaal.size());
        String str = prefix + "  ";
        for (Api api : this.zzZI.keySet()) {
            writer.append(prefix).append(api.getName()).println(":");
            ((com.google.android.gms.common.api.Api.zzb) this.zzaaf.get(api.zznd())).dump(str, fd, writer, args);
        }
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        com.google.android.gms.common.api.Api.zzc zznd = api.zznd();
        this.zzZs.lock();
        try {
            if (!isConnected() && !zznB()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.zzaaf.containsKey(zznd)) {
                ConnectionResult connectionResult;
                if (((com.google.android.gms.common.api.Api.zzb) this.zzaaf.get(zznd)).isConnected()) {
                    connectionResult = ConnectionResult.zzYi;
                } else if (this.zzaag.containsKey(zznd)) {
                    connectionResult = (ConnectionResult) this.zzaag.get(zznd);
                    this.zzZs.unlock();
                } else {
                    Log.wtf("GoogleApiClientImpl", api.getName() + " requested in getConnectionResult" + " is not connected but is not present in the failed connections map");
                    connectionResult = new ConnectionResult(8, null);
                    this.zzZs.unlock();
                }
                return connectionResult;
            } else {
                this.zzZs.unlock();
                throw new IllegalArgumentException(api.getName() + " was never registered with GoogleApiClient");
            }
        } finally {
            this.zzZs.unlock();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Looper getLooper() {
        return this.zzYV;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(Api<?> api) {
        com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb = (com.google.android.gms.common.api.Api.zzb) this.zzaaf.get(api.zznd());
        return com_google_android_gms_common_api_Api_zzb == null ? false : com_google_android_gms_common_api_Api_zzb.isConnected();
    }

    public boolean isConnected() {
        return this.zzaai instanceof zzf;
    }

    public boolean isConnecting() {
        return this.zzaai instanceof zzg;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.zzZY.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.zzZY.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.zzZY.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zzZY.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage(FragmentActivity lifecycleActivity) {
        if (this.zzZf >= 0) {
            zzp zza = zzp.zza(lifecycleActivity);
            if (zza == null) {
                new Handler(this.mContext.getMainLooper()).post(new C02718(this, lifecycleActivity));
            } else {
                zza.zzbi(this.zzZf);
            }
        } else if (this.zzZg >= 0) {
            zzq.zzc(lifecycleActivity).zzbi(this.zzZg);
        } else {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.zzZY.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zzZY.unregisterConnectionFailedListener(listener);
    }

    public <C extends com.google.android.gms.common.api.Api.zzb> C zza(com.google.android.gms.common.api.Api.zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        Object obj = (com.google.android.gms.common.api.Api.zzb) this.zzaaf.get(com_google_android_gms_common_api_Api_zzc_C);
        zzx.zzb(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.common.api.zzc.zza<R, A>> T zza(T t) {
        zzx.zzb(t.zznd() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        zzx.zzb(this.zzaaf.containsKey(t.zznd()), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        this.zzZs.lock();
        try {
            T zza = this.zzaai.zza(t);
            return zza;
        } finally {
            this.zzZs.unlock();
        }
    }

    void zza(zzb com_google_android_gms_common_api_zzi_zzb) {
        this.zzaad.sendMessage(this.zzaad.obtainMessage(3, com_google_android_gms_common_api_zzi_zzb));
    }

    void zza(RuntimeException runtimeException) {
        this.zzaad.sendMessage(this.zzaad.obtainMessage(4, runtimeException));
    }

    public boolean zza(Api<?> api) {
        return this.zzaaf.containsKey(api.zznd());
    }

    public boolean zza(Scope scope) {
        this.zzZs.lock();
        try {
            boolean z = isConnected() && this.zzaah.contains(scope);
            this.zzZs.unlock();
            return z;
        } catch (Throwable th) {
            this.zzZs.unlock();
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.common.api.zzc.zza<? extends Result, A>> T zzb(T t) {
        zzx.zzb(t.zznd() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        this.zzZs.lock();
        try {
            if (zznB()) {
                this.zzZZ.add(t);
                while (!this.zzZZ.isEmpty()) {
                    zze com_google_android_gms_common_api_zzi_zze = (zze) this.zzZZ.remove();
                    zzb(com_google_android_gms_common_api_zzi_zze);
                    com_google_android_gms_common_api_zzi_zze.zzx(Status.zzaaF);
                }
            } else {
                t = this.zzaai.zzb(t);
                this.zzZs.unlock();
            }
            return t;
        } finally {
            this.zzZs.unlock();
        }
    }

    <A extends com.google.android.gms.common.api.Api.zzb> void zzb(zze<A> com_google_android_gms_common_api_zzi_zze_A) {
        this.zzaal.add(com_google_android_gms_common_api_zzi_zze_A);
        com_google_android_gms_common_api_zzi_zze_A.zza(this.zzaam);
    }

    void zzg(ConnectionResult connectionResult) {
        this.zzZs.lock();
        try {
            this.zzaaj = connectionResult;
            this.zzaai = new zzh(this);
            this.zzaai.begin();
            this.zzZX.signalAll();
        } finally {
            this.zzZs.unlock();
        }
    }

    void zznA() {
        this.zzZs.lock();
        try {
            zznE();
            this.zzaai = new zzf(this);
            this.zzaai.begin();
            this.zzZX.signalAll();
        } finally {
            this.zzZs.unlock();
        }
    }

    boolean zznB() {
        return this.zzaaa;
    }

    void zznD() {
        if (!zznB()) {
            this.zzaaa = true;
            if (this.zzaae == null) {
                this.zzaae = new zzc(this);
                IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                this.mContext.getApplicationContext().registerReceiver(this.zzaae, intentFilter);
            }
            this.zzaad.sendMessageDelayed(this.zzaad.obtainMessage(1), this.zzaab);
            this.zzaad.sendMessageDelayed(this.zzaad.obtainMessage(2), this.zzaac);
        }
    }

    boolean zznE() {
        if (!zznB()) {
            return false;
        }
        this.zzaaa = false;
        this.zzaad.removeMessages(2);
        this.zzaad.removeMessages(1);
        if (this.zzaae != null) {
            this.mContext.getApplicationContext().unregisterReceiver(this.zzaae);
            this.zzaae = null;
        }
        return true;
    }

    void zznx() {
        for (zze com_google_android_gms_common_api_zzi_zze : this.zzaal) {
            com_google_android_gms_common_api_zzi_zze.zza(null);
            com_google_android_gms_common_api_zzi_zze.cancel();
        }
        this.zzaal.clear();
        for (zzl clear : this.zzaak) {
            clear.clear();
        }
        this.zzaak.clear();
    }

    void zzny() {
        for (com.google.android.gms.common.api.Api.zzb disconnect : this.zzaaf.values()) {
            disconnect.disconnect();
        }
    }

    void zznz() {
        this.zzZs.lock();
        try {
            this.zzaai = new zzg(this, this.zzZH, this.zzZI, this.zzZi, this.zzZj, this.zzZs, this.mContext);
            this.zzaai.begin();
            this.zzZX.signalAll();
        } finally {
            this.zzZs.unlock();
        }
    }

    public <L> zzl<L> zzp(L l) {
        zzx.zzb((Object) l, (Object) "Listener must not be null");
        this.zzZs.lock();
        try {
            zzl<L> com_google_android_gms_common_api_zzl = new zzl(this.zzYV, l);
            this.zzaak.add(com_google_android_gms_common_api_zzl);
            return com_google_android_gms_common_api_zzl;
        } finally {
            this.zzZs.unlock();
        }
    }
}
