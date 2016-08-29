package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.copresence.internal.CopresenceApiOptions;
import java.util.List;

public class zzj extends zzb {
    private final zzi zzaCQ;
    private final com.google.android.gms.location.copresence.internal.zzb zzaCR;

    private static final class zza extends com.google.android.gms.location.internal.zzf.zza {
        private com.google.android.gms.common.api.zzc.zzb<Status> zzaCS;

        public zza(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            this.zzaCS = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status;
        }

        public void zza(int i, PendingIntent pendingIntent) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
        }

        public void zza(int i, String[] strArr) {
            if (this.zzaCS == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            this.zzaCS.zzn(LocationStatusCodes.zzgN(LocationStatusCodes.zzgM(i)));
            this.zzaCS = null;
        }

        public void zzb(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
        }
    }

    private static final class zzb extends com.google.android.gms.location.internal.zzf.zza {
        private com.google.android.gms.common.api.zzc.zzb<Status> zzaCS;

        public zzb(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            this.zzaCS = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status;
        }

        private void zzgQ(int i) {
            if (this.zzaCS == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesResult called multiple times");
                return;
            }
            this.zzaCS.zzn(LocationStatusCodes.zzgN(LocationStatusCodes.zzgM(i)));
            this.zzaCS = null;
        }

        public void zza(int i, PendingIntent pendingIntent) {
            zzgQ(i);
        }

        public void zza(int i, String[] strArr) {
            Log.wtf("LocationClientImpl", "Unexpected call to onAddGeofencesResult");
        }

        public void zzb(int i, String[] strArr) {
            zzgQ(i);
        }
    }

    private static final class zzc extends com.google.android.gms.location.internal.zzh.zza {
        private com.google.android.gms.common.api.zzc.zzb<LocationSettingsResult> zzaCS;

        public zzc(com.google.android.gms.common.api.zzc.zzb<LocationSettingsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_location_LocationSettingsResult) {
            zzx.zzb(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_location_LocationSettingsResult != null, (Object) "listener can't be null.");
            this.zzaCS = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_location_LocationSettingsResult;
        }

        public void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
            this.zzaCS.zzn(locationSettingsResult);
            this.zzaCS = null;
        }
    }

    public zzj(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, zzf.zzaj(context));
    }

    public zzj(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zzf com_google_android_gms_common_internal_zzf) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, com_google_android_gms_common_internal_zzf, CopresenceApiOptions.zzaCp);
    }

    public zzj(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zzf com_google_android_gms_common_internal_zzf, CopresenceApiOptions copresenceApiOptions) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, com_google_android_gms_common_internal_zzf);
        this.zzaCQ = new zzi(context, this.zzaCs);
        this.zzaCR = com.google.android.gms.location.copresence.internal.zzb.zza(context, com_google_android_gms_common_internal_zzf.getAccountName(), com_google_android_gms_common_internal_zzf.zzol(), this.zzaCs, copresenceApiOptions);
    }

    public void disconnect() {
        synchronized (this.zzaCQ) {
            if (isConnected()) {
                try {
                    this.zzaCQ.removeAllListeners();
                    this.zzaCQ.zzvR();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.zzaCQ.getLastLocation();
    }

    public void zza(long j, PendingIntent pendingIntent) throws RemoteException {
        zzoz();
        zzx.zzv(pendingIntent);
        zzx.zzb(j >= 0, (Object) "detectionIntervalMillis must be >= 0");
        ((zzg) zzoA()).zza(j, true, pendingIntent);
    }

    public void zza(PendingIntent pendingIntent) throws RemoteException {
        zzoz();
        zzx.zzv(pendingIntent);
        ((zzg) zzoA()).zza(pendingIntent);
    }

    public void zza(PendingIntent pendingIntent, com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        zzoz();
        zzx.zzb((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        zzx.zzb((Object) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, (Object) "ResultHolder not provided.");
        ((zzg) zzoA()).zza(pendingIntent, new zzb(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status), getContext().getPackageName());
    }

    public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        zzoz();
        zzx.zzb((Object) geofencingRequest, (Object) "geofencingRequest can't be null.");
        zzx.zzb((Object) pendingIntent, (Object) "PendingIntent must be specified.");
        zzx.zzb((Object) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, (Object) "ResultHolder not provided.");
        ((zzg) zzoA()).zza(geofencingRequest, pendingIntent, new zza(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status));
    }

    public void zza(LocationCallback locationCallback) throws RemoteException {
        this.zzaCQ.zza(locationCallback);
    }

    public void zza(LocationListener locationListener) throws RemoteException {
        this.zzaCQ.zza(locationListener);
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper) throws RemoteException {
        synchronized (this.zzaCQ) {
            this.zzaCQ.zza(locationRequest, locationListener, looper);
        }
    }

    public void zza(LocationSettingsRequest locationSettingsRequest, com.google.android.gms.common.api.zzc.zzb<LocationSettingsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_location_LocationSettingsResult, String str) throws RemoteException {
        boolean z = true;
        zzoz();
        zzx.zzb(locationSettingsRequest != null, (Object) "locationSettingsRequest can't be null nor empty.");
        if (com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_location_LocationSettingsResult == null) {
            z = false;
        }
        zzx.zzb(z, (Object) "listener can't be null.");
        ((zzg) zzoA()).zza(locationSettingsRequest, new zzc(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_location_LocationSettingsResult), str);
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper) throws RemoteException {
        synchronized (this.zzaCQ) {
            this.zzaCQ.zza(locationRequestInternal, locationCallback, looper);
        }
    }

    public void zza(List<String> list, com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        zzoz();
        boolean z = list != null && list.size() > 0;
        zzx.zzb(z, (Object) "geofenceRequestIds can't be null nor empty.");
        zzx.zzb((Object) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, (Object) "ResultHolder not provided.");
        ((zzg) zzoA()).zza((String[]) list.toArray(new String[0]), new zzb(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status), getContext().getPackageName());
    }

    public void zzag(boolean z) throws RemoteException {
        this.zzaCQ.zzag(z);
    }

    public void zzb(Location location) throws RemoteException {
        this.zzaCQ.zzb(location);
    }

    public void zzb(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
        this.zzaCQ.zzb(locationRequest, pendingIntent);
    }

    public void zzf(PendingIntent pendingIntent) throws RemoteException {
        this.zzaCQ.zzf(pendingIntent);
    }

    public boolean zzoC() {
        return true;
    }

    public LocationAvailability zzvQ() {
        return this.zzaCQ.zzvQ();
    }
}
