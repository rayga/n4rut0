package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;

public class zzno implements HistoryApi {

    private static class zza extends com.google.android.gms.internal.zzms.zza {
        private final zzb<DataReadResult> zzQz;
        private int zzapd;
        private DataReadResult zzape;

        private zza(zzb<DataReadResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_DataReadResult) {
            this.zzapd = 0;
            this.zzape = null;
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_DataReadResult;
        }

        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                Log.v("Fitness", "Received batch result");
                if (this.zzape == null) {
                    this.zzape = dataReadResult;
                } else {
                    this.zzape.zzb(dataReadResult);
                }
                this.zzapd++;
                if (this.zzapd == this.zzape.zzsB()) {
                    this.zzQz.zzn(this.zzape);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzno.3 */
    class C12023 extends zza<DataReadResult> {
        final /* synthetic */ zzno zzaoY;
        final /* synthetic */ DataReadRequest zzapa;

        C12023(zzno com_google_android_gms_internal_zzno, GoogleApiClient googleApiClient, DataReadRequest dataReadRequest) {
            this.zzaoY = com_google_android_gms_internal_zzno;
            this.zzapa = dataReadRequest;
            super(googleApiClient);
        }

        protected DataReadResult zzJ(Status status) {
            return DataReadResult.zza(status, this.zzapa);
        }

        protected void zza(zzmm com_google_android_gms_internal_zzmm) throws RemoteException {
            ((zzmx) com_google_android_gms_internal_zzmm.zzoA()).zza(new DataReadRequest(this.zzapa, new zza(null), com_google_android_gms_internal_zzmm.getContext().getPackageName()));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzJ(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzno.4 */
    class C12034 extends zza<DailyTotalResult> {
        final /* synthetic */ zzno zzaoY;
        final /* synthetic */ DataType zzapb;

        /* renamed from: com.google.android.gms.internal.zzno.4.1 */
        class C11471 extends com.google.android.gms.internal.zzmr.zza {
            final /* synthetic */ C12034 zzapc;

            C11471(C12034 c12034) {
                this.zzapc = c12034;
            }

            public void zza(DailyTotalResult dailyTotalResult) throws RemoteException {
                this.zzapc.zza((Result) dailyTotalResult);
            }
        }

        C12034(zzno com_google_android_gms_internal_zzno, GoogleApiClient googleApiClient, DataType dataType) {
            this.zzaoY = com_google_android_gms_internal_zzno;
            this.zzapb = dataType;
            super(googleApiClient);
        }

        protected DailyTotalResult zzK(Status status) {
            return DailyTotalResult.zzQ(status);
        }

        protected void zza(zzmm com_google_android_gms_internal_zzmm) throws RemoteException {
            ((zzmx) com_google_android_gms_internal_zzmm.zzoA()).zza(new DailyTotalRequest(new C11471(this), this.zzapb, com_google_android_gms_internal_zzmm.getContext().getPackageName()));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzK(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzno.1 */
    class C13681 extends zzc {
        final /* synthetic */ DataSet zzaoW;
        final /* synthetic */ boolean zzaoX;
        final /* synthetic */ zzno zzaoY;

        C13681(zzno com_google_android_gms_internal_zzno, GoogleApiClient googleApiClient, DataSet dataSet, boolean z) {
            this.zzaoY = com_google_android_gms_internal_zzno;
            this.zzaoW = dataSet;
            this.zzaoX = z;
            super(googleApiClient);
        }

        protected void zza(zzmm com_google_android_gms_internal_zzmm) throws RemoteException {
            ((zzmx) com_google_android_gms_internal_zzmm.zzoA()).zza(new DataInsertRequest(this.zzaoW, new zznt(this), com_google_android_gms_internal_zzmm.getContext().getPackageName(), this.zzaoX));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzno.2 */
    class C13692 extends zzc {
        final /* synthetic */ zzno zzaoY;
        final /* synthetic */ DataDeleteRequest zzaoZ;

        C13692(zzno com_google_android_gms_internal_zzno, GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest) {
            this.zzaoY = com_google_android_gms_internal_zzno;
            this.zzaoZ = dataDeleteRequest;
            super(googleApiClient);
        }

        protected void zza(zzmm com_google_android_gms_internal_zzmm) throws RemoteException {
            ((zzmx) com_google_android_gms_internal_zzmm.zzoA()).zza(new DataDeleteRequest(this.zzaoZ, new zznt(this), com_google_android_gms_internal_zzmm.getContext().getPackageName()));
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataSet dataSet, boolean z) {
        zzx.zzb((Object) dataSet, (Object) "Must set the data set");
        zzx.zza(!dataSet.getDataPoints().isEmpty(), (Object) "Cannot use an empty data set");
        zzx.zzb(dataSet.getDataSource().zzrF(), (Object) "Must set the app package name for the data source");
        return googleApiClient.zza(new C13681(this, googleApiClient, dataSet, z));
    }

    public PendingResult<Status> deleteData(GoogleApiClient client, DataDeleteRequest request) {
        return client.zza(new C13692(this, client, request));
    }

    public PendingResult<Status> insertData(GoogleApiClient client, DataSet dataSet) {
        return zza(client, dataSet, false);
    }

    public PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient client, DataType dataType) {
        return client.zza(new C12034(this, client, dataType));
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient client, DataReadRequest request) {
        return client.zza(new C12023(this, client, request));
    }
}
