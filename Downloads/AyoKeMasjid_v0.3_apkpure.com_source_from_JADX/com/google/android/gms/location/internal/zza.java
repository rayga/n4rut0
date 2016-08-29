package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

public class zza implements ActivityRecognitionApi {

    private static abstract class zza extends com.google.android.gms.location.ActivityRecognition.zza<Status> {
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

    /* renamed from: com.google.android.gms.location.internal.zza.1 */
    class C14041 extends zza {
        final /* synthetic */ long zzaCv;
        final /* synthetic */ PendingIntent zzaCw;
        final /* synthetic */ zza zzaCx;

        C14041(zza com_google_android_gms_location_internal_zza, GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
            this.zzaCx = com_google_android_gms_location_internal_zza;
            this.zzaCv = j;
            this.zzaCw = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzaCv, this.zzaCw);
            zza(Status.zzaaD);
        }
    }

    /* renamed from: com.google.android.gms.location.internal.zza.2 */
    class C14052 extends zza {
        final /* synthetic */ PendingIntent zzaCw;
        final /* synthetic */ zza zzaCx;

        C14052(zza com_google_android_gms_location_internal_zza, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzaCx = com_google_android_gms_location_internal_zza;
            this.zzaCw = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzj com_google_android_gms_location_internal_zzj) throws RemoteException {
            com_google_android_gms_location_internal_zzj.zza(this.zzaCw);
            zza(Status.zzaaD);
        }
    }

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient client, PendingIntent callbackIntent) {
        return client.zzb(new C14052(this, client, callbackIntent));
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient client, long detectionIntervalMillis, PendingIntent callbackIntent) {
        return client.zzb(new C14041(this, client, detectionIntervalMillis, callbackIntent));
    }
}
