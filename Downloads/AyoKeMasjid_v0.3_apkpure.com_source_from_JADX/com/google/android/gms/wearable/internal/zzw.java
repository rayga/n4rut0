package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class zzw implements DataApi {

    public static class zzb implements DataItemResult {
        private final Status zzQA;
        private final DataItem zzbam;

        public zzb(Status status, DataItem dataItem) {
            this.zzQA = status;
            this.zzbam = dataItem;
        }

        public DataItem getDataItem() {
            return this.zzbam;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public static class zzc implements DeleteDataItemsResult {
        private final Status zzQA;
        private final int zzban;

        public zzc(Status status, int i) {
            this.zzQA = status;
            this.zzban = i;
        }

        public int getNumDeleted() {
            return this.zzban;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public static class zzd implements GetFdForAssetResult {
        private volatile boolean mClosed;
        private final Status zzQA;
        private volatile InputStream zzaZW;
        private volatile ParcelFileDescriptor zzbao;

        public zzd(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.mClosed = false;
            this.zzQA = status;
            this.zzbao = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.zzbao;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.zzbao == null) {
                return null;
            } else {
                if (this.zzaZW == null) {
                    this.zzaZW = new AutoCloseInputStream(this.zzbao);
                }
                return this.zzaZW;
            }
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzbao != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.zzaZW != null) {
                        this.zzaZW.close();
                    } else {
                        this.zzbao.close();
                    }
                    this.mClosed = true;
                    this.zzbao = null;
                    this.zzaZW = null;
                } catch (IOException e) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzw.1 */
    class C12311 extends zzh<DataItemResult> {
        final /* synthetic */ PutDataRequest zzbae;
        final /* synthetic */ zzw zzbaf;

        C12311(zzw com_google_android_gms_wearable_internal_zzw, GoogleApiClient googleApiClient, PutDataRequest putDataRequest) {
            this.zzbaf = com_google_android_gms_wearable_internal_zzw;
            this.zzbae = putDataRequest;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzbae);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzbp(status);
        }

        public DataItemResult zzbp(Status status) {
            return new zzb(status, null);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzw.2 */
    class C12322 extends zzh<DataItemResult> {
        final /* synthetic */ Uri zzaKy;
        final /* synthetic */ zzw zzbaf;

        C12322(zzw com_google_android_gms_wearable_internal_zzw, GoogleApiClient googleApiClient, Uri uri) {
            this.zzbaf = com_google_android_gms_wearable_internal_zzw;
            this.zzaKy = uri;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzaKy);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbp(status);
        }

        protected DataItemResult zzbp(Status status) {
            return new zzb(status, null);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzw.3 */
    class C12333 extends zzh<DataItemBuffer> {
        final /* synthetic */ zzw zzbaf;

        C12333(zzw com_google_android_gms_wearable_internal_zzw, GoogleApiClient googleApiClient) {
            this.zzbaf = com_google_android_gms_wearable_internal_zzw;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzn(this);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbq(status);
        }

        protected DataItemBuffer zzbq(Status status) {
            return new DataItemBuffer(DataHolder.zzbp(status.getStatusCode()));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzw.4 */
    class C12344 extends zzh<DataItemBuffer> {
        final /* synthetic */ Uri zzaKy;
        final /* synthetic */ zzw zzbaf;
        final /* synthetic */ int zzbag;

        C12344(zzw com_google_android_gms_wearable_internal_zzw, GoogleApiClient googleApiClient, Uri uri, int i) {
            this.zzbaf = com_google_android_gms_wearable_internal_zzw;
            this.zzaKy = uri;
            this.zzbag = i;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzaKy, this.zzbag);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbq(status);
        }

        protected DataItemBuffer zzbq(Status status) {
            return new DataItemBuffer(DataHolder.zzbp(status.getStatusCode()));
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzw.5 */
    class C12355 extends zzh<DeleteDataItemsResult> {
        final /* synthetic */ Uri zzaKy;
        final /* synthetic */ zzw zzbaf;
        final /* synthetic */ int zzbag;

        C12355(zzw com_google_android_gms_wearable_internal_zzw, GoogleApiClient googleApiClient, Uri uri, int i) {
            this.zzbaf = com_google_android_gms_wearable_internal_zzw;
            this.zzaKy = uri;
            this.zzbag = i;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzb((com.google.android.gms.common.api.zzc.zzb) this, this.zzaKy, this.zzbag);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbr(status);
        }

        protected DeleteDataItemsResult zzbr(Status status) {
            return new zzc(status, 0);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzw.6 */
    class C12366 extends zzh<GetFdForAssetResult> {
        final /* synthetic */ zzw zzbaf;
        final /* synthetic */ Asset zzbah;

        C12366(zzw com_google_android_gms_wearable_internal_zzw, GoogleApiClient googleApiClient, Asset asset) {
            this.zzbaf = com_google_android_gms_wearable_internal_zzw;
            this.zzbah = asset;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzbah);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbs(status);
        }

        protected GetFdForAssetResult zzbs(Status status) {
            return new zzd(status, null);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzw.7 */
    class C12377 extends zzh<GetFdForAssetResult> {
        final /* synthetic */ zzw zzbaf;
        final /* synthetic */ DataItemAsset zzbai;

        C12377(zzw com_google_android_gms_wearable_internal_zzw, GoogleApiClient googleApiClient, DataItemAsset dataItemAsset) {
            this.zzbaf = com_google_android_gms_wearable_internal_zzw;
            this.zzbai = dataItemAsset;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzbai);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbs(status);
        }

        protected GetFdForAssetResult zzbs(Status status) {
            return new zzd(status, null);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzw.8 */
    class C12388 extends zzh<Status> {
        final /* synthetic */ zzw zzbaf;
        final /* synthetic */ DataListener zzbaj;

        C12388(zzw com_google_android_gms_wearable_internal_zzw, GoogleApiClient googleApiClient, DataListener dataListener) {
            this.zzbaf = com_google_android_gms_wearable_internal_zzw;
            this.zzbaj = dataListener;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzbaj);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    private static final class zza extends zzh<Status> {
        private DataListener zzbak;
        private IntentFilter[] zzbal;

        private zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzbak = dataListener;
            this.zzbal = intentFilterArr;
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzbak, this.zzbal);
            this.zzbak = null;
            this.zzbal = null;
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            this.zzbak = null;
            this.zzbal = null;
            return status;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(dataListener, intentFilterArr, null));
    }

    private void zza(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener) {
        return zza(client, listener, null);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, Uri uri) {
        return deleteDataItems(client, uri, 0);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, Uri uri, int filterType) {
        return client.zza(new C12355(this, client, uri, filterType));
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient client, Uri uri) {
        return client.zza(new C12322(this, client, uri));
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.zza(new C12333(this, client));
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, Uri uri) {
        return getDataItems(client, uri, 0);
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, Uri uri, int filterType) {
        return client.zza(new C12344(this, client, uri, filterType));
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, Asset asset) {
        zza(asset);
        return client.zza(new C12366(this, client, asset));
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, DataItemAsset asset) {
        return client.zza(new C12377(this, client, asset));
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient client, PutDataRequest request) {
        return client.zza(new C12311(this, client, request));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, DataListener listener) {
        return client.zza(new C12388(this, client, listener));
    }
}
