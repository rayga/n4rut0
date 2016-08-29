package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public class zznq implements RecordingApi {

    private static class zza extends com.google.android.gms.internal.zznc.zza {
        private final zzb<ListSubscriptionsResult> zzQz;

        private zza(zzb<ListSubscriptionsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult;
        }

        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzQz.zzn(listSubscriptionsResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznq.1 */
    class C12041 extends zza<ListSubscriptionsResult> {
        final /* synthetic */ zznq zzapf;

        C12041(zznq com_google_android_gms_internal_zznq, GoogleApiClient googleApiClient) {
            this.zzapf = com_google_android_gms_internal_zznq;
            super(googleApiClient);
        }

        protected ListSubscriptionsResult zzL(Status status) {
            return ListSubscriptionsResult.zzT(status);
        }

        protected void zza(zzmo com_google_android_gms_internal_zzmo) throws RemoteException {
            ((zzmz) com_google_android_gms_internal_zzmo.zzoA()).zza(new ListSubscriptionsRequest(null, new zza(null), com_google_android_gms_internal_zzmo.getContext().getPackageName()));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzL(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznq.2 */
    class C12052 extends zza<ListSubscriptionsResult> {
        final /* synthetic */ DataType zzapb;
        final /* synthetic */ zznq zzapf;

        C12052(zznq com_google_android_gms_internal_zznq, GoogleApiClient googleApiClient, DataType dataType) {
            this.zzapf = com_google_android_gms_internal_zznq;
            this.zzapb = dataType;
            super(googleApiClient);
        }

        protected ListSubscriptionsResult zzL(Status status) {
            return ListSubscriptionsResult.zzT(status);
        }

        protected void zza(zzmo com_google_android_gms_internal_zzmo) throws RemoteException {
            ((zzmz) com_google_android_gms_internal_zzmo.zzoA()).zza(new ListSubscriptionsRequest(this.zzapb, new zza(null), com_google_android_gms_internal_zzmo.getContext().getPackageName()));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzL(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznq.3 */
    class C13703 extends zzc {
        final /* synthetic */ zznq zzapf;
        final /* synthetic */ Subscription zzapg;

        C13703(zznq com_google_android_gms_internal_zznq, GoogleApiClient googleApiClient, Subscription subscription) {
            this.zzapf = com_google_android_gms_internal_zznq;
            this.zzapg = subscription;
            super(googleApiClient);
        }

        protected void zza(zzmo com_google_android_gms_internal_zzmo) throws RemoteException {
            ((zzmz) com_google_android_gms_internal_zzmo.zzoA()).zza(new SubscribeRequest(this.zzapg, false, new zznt(this), com_google_android_gms_internal_zzmo.getContext().getPackageName()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zznq.4 */
    class C13714 extends zzc {
        final /* synthetic */ DataType zzapb;
        final /* synthetic */ zznq zzapf;

        C13714(zznq com_google_android_gms_internal_zznq, GoogleApiClient googleApiClient, DataType dataType) {
            this.zzapf = com_google_android_gms_internal_zznq;
            this.zzapb = dataType;
            super(googleApiClient);
        }

        protected void zza(zzmo com_google_android_gms_internal_zzmo) throws RemoteException {
            ((zzmz) com_google_android_gms_internal_zzmo.zzoA()).zza(new UnsubscribeRequest(this.zzapb, null, new zznt(this), com_google_android_gms_internal_zzmo.getContext().getPackageName()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zznq.5 */
    class C13725 extends zzc {
        final /* synthetic */ zznq zzapf;
        final /* synthetic */ DataSource zzaph;

        C13725(zznq com_google_android_gms_internal_zznq, GoogleApiClient googleApiClient, DataSource dataSource) {
            this.zzapf = com_google_android_gms_internal_zznq;
            this.zzaph = dataSource;
            super(googleApiClient);
        }

        protected void zza(zzmo com_google_android_gms_internal_zzmo) throws RemoteException {
            ((zzmz) com_google_android_gms_internal_zzmo.zzoA()).zza(new UnsubscribeRequest(null, this.zzaph, new zznt(this), com_google_android_gms_internal_zzmo.getContext().getPackageName()));
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Subscription subscription) {
        return googleApiClient.zza(new C13703(this, googleApiClient, subscription));
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client) {
        return client.zza(new C12041(this, client));
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client, DataType dataType) {
        return client.zza(new C12052(this, client, dataType));
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataSource dataSource) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataSource).zzrR());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataType dataType) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataType).zzrR());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, DataSource dataSource) {
        return client.zzb(new C13725(this, client, dataSource));
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, DataType dataType) {
        return client.zzb(new C13714(this, client, dataType));
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(client, subscription.getDataSource()) : unsubscribe(client, subscription.getDataType());
    }
}
