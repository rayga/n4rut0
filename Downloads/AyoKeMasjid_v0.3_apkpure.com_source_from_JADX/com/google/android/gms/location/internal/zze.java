package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import java.util.List;

public class zze implements GeofencingApi {

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

    /* renamed from: com.google.android.gms.location.internal.zze.1 */
    class C14151 extends zza {
        final /* synthetic */ GeofencingRequest zzaCH;
        final /* synthetic */ zze zzaCI;
        final /* synthetic */ PendingIntent zzapq;

        C14151(zze com_google_android_gms_location_internal_zze, GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
            this.zzaCI = com_google_android_gms_location_internal_zze;
            this.zzaCH = geofencingRequest;
            this.zzapq = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzaCH, this.zzapq, (zzb) this);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zze.2 */
    class C14162 extends zza {
        final /* synthetic */ zze zzaCI;
        final /* synthetic */ PendingIntent zzapq;

        C14162(zze com_google_android_gms_location_internal_zze, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzaCI = com_google_android_gms_location_internal_zze;
            this.zzapq = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzapq, (zzb) this);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zze.3 */
    class C14173 extends zza {
        final /* synthetic */ zze zzaCI;
        final /* synthetic */ List zzaCJ;

        C14173(zze com_google_android_gms_location_internal_zze, GoogleApiClient googleApiClient, List list) {
            this.zzaCI = com_google_android_gms_location_internal_zze;
            this.zzaCJ = list;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzaCJ, (zzb) this);
        }
    }

    public PendingResult<Status> addGeofences(GoogleApiClient client, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return client.zzb(new C14151(this, client, geofencingRequest, pendingIntent));
    }

    @Deprecated
    public PendingResult<Status> addGeofences(GoogleApiClient client, List<Geofence> geofences, PendingIntent pendingIntent) {
        Builder builder = new Builder();
        builder.addGeofences(geofences);
        builder.setInitialTrigger(5);
        return addGeofences(client, builder.build(), pendingIntent);
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, PendingIntent pendingIntent) {
        return client.zzb(new C14162(this, client, pendingIntent));
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, List<String> geofenceRequestIds) {
        return client.zzb(new C14173(this, client, geofenceRequestIds));
    }
}
