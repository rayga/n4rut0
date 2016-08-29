package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class zzd implements FusedLocationProviderApi {

    private static abstract class zza extends com.google.android.gms.location.LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.1 */
    class C14061 extends zza {
        final /* synthetic */ LocationRequest zzaCA;
        final /* synthetic */ LocationListener zzaCB;
        final /* synthetic */ zzd zzaCC;

        C14061(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCA = locationRequest;
            this.zzaCB = locationListener;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzaCA, this.zzaCB, null);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.2 */
    class C14072 extends zza {
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ boolean zzaCD;

        C14072(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, boolean z) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCD = z;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zzag(this.zzaCD);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.3 */
    class C14083 extends zza {
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ Location zzaCE;

        C14083(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, Location location) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCE = location;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zzb(this.zzaCE);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.4 */
    class C14094 extends zza {
        final /* synthetic */ LocationRequest zzaCA;
        final /* synthetic */ LocationListener zzaCB;
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ Looper zzaCF;

        C14094(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCA = locationRequest;
            this.zzaCB = locationListener;
            this.zzaCF = looper;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzaCA, this.zzaCB, this.zzaCF);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.5 */
    class C14105 extends zza {
        final /* synthetic */ LocationRequest zzaCA;
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ Looper zzaCF;
        final /* synthetic */ LocationCallback zzaCG;

        C14105(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCA = locationRequest;
            this.zzaCG = locationCallback;
            this.zzaCF = looper;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(LocationRequestInternal.zzb(this.zzaCA), this.zzaCG, this.zzaCF);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.6 */
    class C14116 extends zza {
        final /* synthetic */ LocationRequest zzaCA;
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ PendingIntent zzaCw;

        C14116(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCA = locationRequest;
            this.zzaCw = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zzb(this.zzaCA, this.zzaCw);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.7 */
    class C14127 extends zza {
        final /* synthetic */ LocationListener zzaCB;
        final /* synthetic */ zzd zzaCC;

        C14127(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationListener locationListener) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCB = locationListener;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzaCB);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.8 */
    class C14138 extends zza {
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ PendingIntent zzaCw;

        C14138(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCw = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zzf(this.zzaCw);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zzd.9 */
    class C14149 extends zza {
        final /* synthetic */ zzd zzaCC;
        final /* synthetic */ LocationCallback zzaCG;

        C14149(zzd com_google_android_gms_location_internal_zzd, GoogleApiClient googleApiClient, LocationCallback locationCallback) {
            this.zzaCC = com_google_android_gms_location_internal_zzd;
            this.zzaCG = locationCallback;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzaCG);
            zza(Status.zzaaD);
        }
    }

    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.zze(client).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public LocationAvailability getLocationAvailability(GoogleApiClient client) {
        try {
            return LocationServices.zze(client).zzvQ();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, PendingIntent callbackIntent) {
        return client.zzb(new C14138(this, client, callbackIntent));
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, LocationCallback callback) {
        return client.zzb(new C14149(this, client, callback));
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, LocationListener listener) {
        return client.zzb(new C14127(this, client, listener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, PendingIntent callbackIntent) {
        return client.zzb(new C14116(this, client, request, callbackIntent));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationCallback callback, Looper looper) {
        return client.zzb(new C14105(this, client, request, callback, looper));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationListener listener) {
        return client.zzb(new C14061(this, client, request, listener));
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationListener listener, Looper looper) {
        return client.zzb(new C14094(this, client, request, listener, looper));
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient client, Location mockLocation) {
        return client.zzb(new C14083(this, client, mockLocation));
    }

    public PendingResult<Status> setMockMode(GoogleApiClient client, boolean isMockMode) {
        return client.zzb(new C14072(this, client, isMockMode));
    }
}
