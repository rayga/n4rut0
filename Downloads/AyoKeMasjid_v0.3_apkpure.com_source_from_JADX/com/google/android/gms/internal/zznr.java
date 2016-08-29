package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class zznr implements SensorsApi {

    private interface zza {
        void zzrZ();
    }

    /* renamed from: com.google.android.gms.internal.zznr.3 */
    class C08023 implements zza {
        final /* synthetic */ zznr zzapj;
        final /* synthetic */ OnDataPointListener zzapn;

        C08023(zznr com_google_android_gms_internal_zznr, OnDataPointListener onDataPointListener) {
            this.zzapj = com_google_android_gms_internal_zznr;
            this.zzapn = onDataPointListener;
        }

        public void zzrZ() {
            com.google.android.gms.fitness.data.zzk.zza.zzrL().zzc(this.zzapn);
        }
    }

    private static class zzb extends com.google.android.gms.internal.zzmt.zza {
        private final com.google.android.gms.common.api.zzc.zzb<DataSourcesResult> zzQz;

        private zzb(com.google.android.gms.common.api.zzc.zzb<DataSourcesResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_DataSourcesResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_DataSourcesResult;
        }

        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzQz.zzn(dataSourcesResult);
        }
    }

    private static class zzc extends com.google.android.gms.internal.zznh.zza {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzQz;
        private final zza zzapr;

        private zzc(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, zza com_google_android_gms_internal_zznr_zza) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status;
            this.zzapr = com_google_android_gms_internal_zznr_zza;
        }

        public void zzr(Status status) {
            if (this.zzapr != null && status.isSuccess()) {
                this.zzapr.zzrZ();
            }
            this.zzQz.zzn(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznr.1 */
    class C12061 extends zza<DataSourcesResult> {
        final /* synthetic */ DataSourcesRequest zzapi;
        final /* synthetic */ zznr zzapj;

        C12061(zznr com_google_android_gms_internal_zznr, GoogleApiClient googleApiClient, DataSourcesRequest dataSourcesRequest) {
            this.zzapj = com_google_android_gms_internal_zznr;
            this.zzapi = dataSourcesRequest;
            super(googleApiClient);
        }

        protected DataSourcesResult zzM(Status status) {
            return DataSourcesResult.zzR(status);
        }

        protected void zza(zzmp com_google_android_gms_internal_zzmp) throws RemoteException {
            ((zzna) com_google_android_gms_internal_zzmp.zzoA()).zza(new DataSourcesRequest(this.zzapi, new zzb(null), com_google_android_gms_internal_zzmp.getContext().getPackageName()));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzM(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznr.2 */
    class C13732 extends zzc {
        final /* synthetic */ zznr zzapj;
        final /* synthetic */ SensorRequest zzapk;
        final /* synthetic */ zzj zzapl;
        final /* synthetic */ PendingIntent zzapm;

        C13732(zznr com_google_android_gms_internal_zznr, GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzj com_google_android_gms_fitness_data_zzj, PendingIntent pendingIntent) {
            this.zzapj = com_google_android_gms_internal_zznr;
            this.zzapk = sensorRequest;
            this.zzapl = com_google_android_gms_fitness_data_zzj;
            this.zzapm = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzmp com_google_android_gms_internal_zzmp) throws RemoteException {
            zznh com_google_android_gms_internal_zznt = new zznt(this);
            String packageName = com_google_android_gms_internal_zzmp.getContext().getPackageName();
            ((zzna) com_google_android_gms_internal_zzmp.zzoA()).zza(new SensorRegistrationRequest(this.zzapk, this.zzapl, this.zzapm, com_google_android_gms_internal_zznt, packageName));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.zznr.4 */
    class C13744 extends zzc {
        final /* synthetic */ zznr zzapj;
        final /* synthetic */ zza zzapo;
        final /* synthetic */ zzj zzapp;
        final /* synthetic */ PendingIntent zzapq;

        C13744(zznr com_google_android_gms_internal_zznr, GoogleApiClient googleApiClient, zza com_google_android_gms_internal_zznr_zza, zzj com_google_android_gms_fitness_data_zzj, PendingIntent pendingIntent) {
            this.zzapj = com_google_android_gms_internal_zznr;
            this.zzapo = com_google_android_gms_internal_zznr_zza;
            this.zzapp = com_google_android_gms_fitness_data_zzj;
            this.zzapq = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzmp com_google_android_gms_internal_zzmp) throws RemoteException {
            ((zzna) com_google_android_gms_internal_zzmp.zzoA()).zza(new SensorUnregistrationRequest(this.zzapp, this.zzapq, new zzc(this.zzapo, null), com_google_android_gms_internal_zzmp.getContext().getPackageName()));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, zzj com_google_android_gms_fitness_data_zzj, PendingIntent pendingIntent, zza com_google_android_gms_internal_zznr_zza) {
        return googleApiClient.zzb(new C13744(this, googleApiClient, com_google_android_gms_internal_zznr_zza, com_google_android_gms_fitness_data_zzj, pendingIntent));
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzj com_google_android_gms_fitness_data_zzj, PendingIntent pendingIntent) {
        return googleApiClient.zza(new C13732(this, googleApiClient, sensorRequest, com_google_android_gms_fitness_data_zzj, pendingIntent));
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, PendingIntent intent) {
        return zza(client, request, null, intent);
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, OnDataPointListener listener) {
        return zza(client, request, com.google.android.gms.fitness.data.zzk.zza.zzrL().zza(listener), null);
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient client, DataSourcesRequest request) {
        return client.zza(new C12061(this, client, request));
    }

    public PendingResult<Status> remove(GoogleApiClient client, PendingIntent pendingIntent) {
        return zza(client, null, pendingIntent, null);
    }

    public PendingResult<Status> remove(GoogleApiClient client, OnDataPointListener listener) {
        zzj zzb = com.google.android.gms.fitness.data.zzk.zza.zzrL().zzb(listener);
        return zzb == null ? new zznj(Status.zzaaD) : zza(client, zzb, null, new C08023(this, listener));
    }
}
