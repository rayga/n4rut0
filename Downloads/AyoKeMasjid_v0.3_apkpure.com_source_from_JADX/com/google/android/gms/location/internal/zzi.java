package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import java.util.HashMap;
import java.util.Map;

public class zzi {
    private final Context mContext;
    private ContentProviderClient zzaCK;
    private boolean zzaCL;
    private Map<LocationCallback, zza> zzaCM;
    private final zzn<zzg> zzaCs;
    private Map<LocationListener, zzc> zzaot;

    private static class zzb extends Handler {
        private final LocationListener zzaCP;

        public zzb(LocationListener locationListener) {
            this.zzaCP = locationListener;
        }

        public zzb(LocationListener locationListener, Looper looper) {
            super(looper);
            this.zzaCP = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    this.zzaCP.onLocationChanged(new Location((Location) msg.obj));
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
            }
        }
    }

    private static class zza extends com.google.android.gms.location.zzc.zza {
        private Handler zzaCN;

        /* renamed from: com.google.android.gms.location.internal.zzi.zza.1 */
        class C04191 extends Handler {
            final /* synthetic */ LocationCallback zzaCG;
            final /* synthetic */ zza zzaCO;

            C04191(zza com_google_android_gms_location_internal_zzi_zza, Looper looper, LocationCallback locationCallback) {
                this.zzaCO = com_google_android_gms_location_internal_zzi_zza;
                this.zzaCG = locationCallback;
                super(looper);
            }

            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case SpinnerCompat.MODE_DIALOG /*0*/:
                        this.zzaCG.onLocationResult((LocationResult) msg.obj);
                    case CompletionEvent.STATUS_FAILURE /*1*/:
                        this.zzaCG.onLocationAvailability((LocationAvailability) msg.obj);
                    default:
                }
            }
        }

        zza(LocationCallback locationCallback, Looper looper) {
            if (looper == null) {
                looper = Looper.myLooper();
                zzx.zza(looper != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.zzaCN = new C04191(this, looper, locationCallback);
        }

        private void zzb(int i, Object obj) {
            if (this.zzaCN == null) {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            this.zzaCN.sendMessage(obtain);
        }

        public void onLocationAvailability(LocationAvailability state) {
            zzb(1, state);
        }

        public void onLocationResult(LocationResult locationResult) {
            zzb(0, locationResult);
        }

        public void release() {
            this.zzaCN = null;
        }
    }

    private static class zzc extends com.google.android.gms.location.zzd.zza {
        private Handler zzaCN;

        zzc(LocationListener locationListener, Looper looper) {
            if (looper == null) {
                zzx.zza(Looper.myLooper() != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.zzaCN = looper == null ? new zzb(locationListener) : new zzb(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.zzaCN == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.zzaCN.sendMessage(obtain);
        }

        public void release() {
            this.zzaCN = null;
        }
    }

    public zzi(Context context, zzn<zzg> com_google_android_gms_location_internal_zzn_com_google_android_gms_location_internal_zzg) {
        this.zzaCK = null;
        this.zzaCL = false;
        this.zzaot = new HashMap();
        this.zzaCM = new HashMap();
        this.mContext = context;
        this.zzaCs = com_google_android_gms_location_internal_zzn_com_google_android_gms_location_internal_zzg;
    }

    private zza zza(LocationCallback locationCallback, Looper looper) {
        zza com_google_android_gms_location_internal_zzi_zza;
        synchronized (this.zzaot) {
            com_google_android_gms_location_internal_zzi_zza = (zza) this.zzaCM.get(locationCallback);
            if (com_google_android_gms_location_internal_zzi_zza == null) {
                com_google_android_gms_location_internal_zzi_zza = new zza(locationCallback, looper);
            }
            this.zzaCM.put(locationCallback, com_google_android_gms_location_internal_zzi_zza);
        }
        return com_google_android_gms_location_internal_zzi_zza;
    }

    private zzc zza(LocationListener locationListener, Looper looper) {
        zzc com_google_android_gms_location_internal_zzi_zzc;
        synchronized (this.zzaot) {
            com_google_android_gms_location_internal_zzi_zzc = (zzc) this.zzaot.get(locationListener);
            if (com_google_android_gms_location_internal_zzi_zzc == null) {
                com_google_android_gms_location_internal_zzi_zzc = new zzc(locationListener, looper);
            }
            this.zzaot.put(locationListener, com_google_android_gms_location_internal_zzi_zzc);
        }
        return com_google_android_gms_location_internal_zzi_zzc;
    }

    public Location getLastLocation() {
        this.zzaCs.zzoz();
        try {
            return ((zzg) this.zzaCs.zzoA()).zzdw(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.zzaot) {
                for (zzc com_google_android_gms_location_internal_zzi_zzc : this.zzaot.values()) {
                    if (com_google_android_gms_location_internal_zzi_zzc != null) {
                        ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zzb(com_google_android_gms_location_internal_zzi_zzc));
                    }
                }
                this.zzaot.clear();
                for (zza com_google_android_gms_location_internal_zzi_zza : this.zzaCM.values()) {
                    if (com_google_android_gms_location_internal_zzi_zza != null) {
                        ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zza(com_google_android_gms_location_internal_zzi_zza));
                    }
                }
                this.zzaCM.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void zza(LocationCallback locationCallback) throws RemoteException {
        this.zzaCs.zzoz();
        zzx.zzb((Object) locationCallback, (Object) "Invalid null callback");
        synchronized (this.zzaCM) {
            zza com_google_android_gms_location_internal_zzi_zza = (zza) this.zzaCM.remove(locationCallback);
            if (com_google_android_gms_location_internal_zzi_zza != null) {
                com_google_android_gms_location_internal_zzi_zza.release();
                ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zza(com_google_android_gms_location_internal_zzi_zza));
            }
        }
    }

    public void zza(LocationListener locationListener) throws RemoteException {
        this.zzaCs.zzoz();
        zzx.zzb((Object) locationListener, (Object) "Invalid null listener");
        synchronized (this.zzaot) {
            zzc com_google_android_gms_location_internal_zzi_zzc = (zzc) this.zzaot.remove(locationListener);
            if (this.zzaCK != null && this.zzaot.isEmpty()) {
                this.zzaCK.release();
                this.zzaCK = null;
            }
            if (com_google_android_gms_location_internal_zzi_zzc != null) {
                com_google_android_gms_location_internal_zzi_zzc.release();
                ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zzb(com_google_android_gms_location_internal_zzi_zzc));
            }
        }
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper) throws RemoteException {
        this.zzaCs.zzoz();
        ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zzb(LocationRequestInternal.zzb(locationRequest), zza(locationListener, looper)));
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper) throws RemoteException {
        this.zzaCs.zzoz();
        ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zza(locationRequestInternal, zza(locationCallback, looper)));
    }

    public void zzag(boolean z) throws RemoteException {
        this.zzaCs.zzoz();
        ((zzg) this.zzaCs.zzoA()).zzag(z);
        this.zzaCL = z;
    }

    public void zzb(Location location) throws RemoteException {
        this.zzaCs.zzoz();
        ((zzg) this.zzaCs.zzoA()).zzb(location);
    }

    public void zzb(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
        this.zzaCs.zzoz();
        ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zzb(LocationRequestInternal.zzb(locationRequest), pendingIntent));
    }

    public void zzf(PendingIntent pendingIntent) throws RemoteException {
        this.zzaCs.zzoz();
        ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zzg(pendingIntent));
    }

    public LocationAvailability zzvQ() {
        this.zzaCs.zzoz();
        try {
            return ((zzg) this.zzaCs.zzoA()).zzdx(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void zzvR() {
        if (this.zzaCL) {
            try {
                zzag(false);
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
