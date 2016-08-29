package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

public class zznn implements ConfigApi {

    private static class zza extends com.google.android.gms.internal.zzmu.zza {
        private final zzb<DataTypeResult> zzQz;

        private zza(zzb<DataTypeResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_DataTypeResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_DataTypeResult;
        }

        public void zza(DataTypeResult dataTypeResult) {
            this.zzQz.zzn(dataTypeResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznn.1 */
    class C12001 extends zza<DataTypeResult> {
        final /* synthetic */ DataTypeCreateRequest zzaoT;
        final /* synthetic */ zznn zzaoU;

        C12001(zznn com_google_android_gms_internal_zznn, GoogleApiClient googleApiClient, DataTypeCreateRequest dataTypeCreateRequest) {
            this.zzaoU = com_google_android_gms_internal_zznn;
            this.zzaoT = dataTypeCreateRequest;
            super(googleApiClient);
        }

        protected DataTypeResult zzI(Status status) {
            return DataTypeResult.zzS(status);
        }

        protected void zza(zzml com_google_android_gms_internal_zzml) throws RemoteException {
            ((zzmw) com_google_android_gms_internal_zzml.zzoA()).zza(new DataTypeCreateRequest(this.zzaoT, new zza(null), com_google_android_gms_internal_zzml.getContext().getPackageName()));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzI(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznn.2 */
    class C12012 extends zza<DataTypeResult> {
        final /* synthetic */ zznn zzaoU;
        final /* synthetic */ String zzaoV;

        C12012(zznn com_google_android_gms_internal_zznn, GoogleApiClient googleApiClient, String str) {
            this.zzaoU = com_google_android_gms_internal_zznn;
            this.zzaoV = str;
            super(googleApiClient);
        }

        protected DataTypeResult zzI(Status status) {
            return DataTypeResult.zzS(status);
        }

        protected void zza(zzml com_google_android_gms_internal_zzml) throws RemoteException {
            ((zzmw) com_google_android_gms_internal_zzml.zzoA()).zza(new DataTypeReadRequest(this.zzaoV, new zza(null), com_google_android_gms_internal_zzml.getContext().getPackageName()));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzI(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznn.3 */
    class C13673 extends zzc {
        final /* synthetic */ zznn zzaoU;

        C13673(zznn com_google_android_gms_internal_zznn, GoogleApiClient googleApiClient) {
            this.zzaoU = com_google_android_gms_internal_zznn;
            super(googleApiClient);
        }

        protected void zza(zzml com_google_android_gms_internal_zzml) throws RemoteException {
            ((zzmw) com_google_android_gms_internal_zzml.zzoA()).zza(new DisableFitRequest(new zznt(this), com_google_android_gms_internal_zzml.getContext().getPackageName()));
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient client, DataTypeCreateRequest request) {
        return client.zzb(new C12001(this, client, request));
    }

    public PendingResult<Status> disableFit(GoogleApiClient client) {
        return client.zzb(new C13673(this, client));
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient client, String dataTypeName) {
        return client.zza(new C12012(this, client, dataTypeName));
    }
}
