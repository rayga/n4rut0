package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class zzaa implements DriveResource {
    protected final DriveId zzags;

    private static class zzc implements MetadataResult {
        private final Status zzQA;
        private final Metadata zzajd;

        public zzc(Status status, Metadata metadata) {
            this.zzQA = status;
            this.zzajd = metadata;
        }

        public Metadata getMetadata() {
            return this.zzajd;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static class zza extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<MetadataBufferResult> zzQz;

        public zza(com.google.android.gms.common.api.zzc.zzb<MetadataBufferResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.zzQz.zzn(new zzf(Status.zzaaD, new MetadataBuffer(onListParentsResponse.zzqV()), false));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zzf(status, null, false));
        }
    }

    private static class zzb extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<MetadataResult> zzQz;

        public zzb(com.google.android.gms.common.api.zzc.zzb<MetadataResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveResource_MetadataResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveResource_MetadataResult;
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzQz.zzn(new zzc(Status.zzaaD, new zzo(onMetadataResponse.zzqW())));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zzc(status, null));
        }
    }

    private abstract class zzd extends zzs<MetadataResult> {
        final /* synthetic */ zzaa zzajb;

        private zzd(zzaa com_google_android_gms_drive_internal_zzaa, GoogleApiClient googleApiClient) {
            this.zzajb = com_google_android_gms_drive_internal_zzaa;
            super(googleApiClient);
        }

        public MetadataResult zzG(Status status) {
            return new zzc(status, null);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzG(status);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzaa.1 */
    class C12631 extends zzd {
        final /* synthetic */ boolean zzaja;
        final /* synthetic */ zzaa zzajb;

        C12631(zzaa com_google_android_gms_drive_internal_zzaa, GoogleApiClient googleApiClient, boolean z) {
            this.zzajb = com_google_android_gms_drive_internal_zzaa;
            this.zzaja = z;
            super(googleApiClient, null);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new GetMetadataRequest(this.zzajb.zzags, this.zzaja), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzaa.2 */
    class C12642 extends zzg {
        final /* synthetic */ zzaa zzajb;

        C12642(zzaa com_google_android_gms_drive_internal_zzaa, GoogleApiClient googleApiClient) {
            this.zzajb = com_google_android_gms_drive_internal_zzaa;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new ListParentsRequest(this.zzajb.zzags), new zza(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzaa.3 */
    class C12653 extends com.google.android.gms.drive.internal.zzs.zza {
        final /* synthetic */ zzaa zzajb;
        final /* synthetic */ List zzajc;

        C12653(zzaa com_google_android_gms_drive_internal_zzaa, GoogleApiClient googleApiClient, List list) {
            this.zzajb = com_google_android_gms_drive_internal_zzaa;
            this.zzajc = list;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new SetResourceParentsRequest(this.zzajb.zzags, this.zzajc), new zzbr(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzaa.4 */
    class C12664 extends zzd {
        final /* synthetic */ MetadataChangeSet zzaiP;
        final /* synthetic */ zzaa zzajb;

        C12664(zzaa com_google_android_gms_drive_internal_zzaa, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
            this.zzajb = com_google_android_gms_drive_internal_zzaa;
            this.zzaiP = metadataChangeSet;
            super(googleApiClient, null);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            this.zzaiP.zzqp().setContext(com_google_android_gms_drive_internal_zzt.getContext());
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new UpdateMetadataRequest(this.zzajb.zzags, this.zzaiP.zzqp()), new zzb(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzaa.5 */
    class C12675 extends com.google.android.gms.drive.internal.zzs.zza {
        final /* synthetic */ zzaa zzajb;

        C12675(zzaa com_google_android_gms_drive_internal_zzaa, GoogleApiClient googleApiClient) {
            this.zzajb = com_google_android_gms_drive_internal_zzaa;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new DeleteResourceRequest(this.zzajb.zzags), new zzbr(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzaa.6 */
    class C12686 extends com.google.android.gms.drive.internal.zzs.zza {
        final /* synthetic */ zzaa zzajb;

        C12686(zzaa com_google_android_gms_drive_internal_zzaa, GoogleApiClient googleApiClient) {
            this.zzajb = com_google_android_gms_drive_internal_zzaa;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new TrashResourceRequest(this.zzajb.zzags), new zzbr(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzaa.7 */
    class C12697 extends com.google.android.gms.drive.internal.zzs.zza {
        final /* synthetic */ zzaa zzajb;

        C12697(zzaa com_google_android_gms_drive_internal_zzaa, GoogleApiClient googleApiClient) {
            this.zzajb = com_google_android_gms_drive_internal_zzaa;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new UntrashResourceRequest(this.zzajb.zzags), new zzbr(this));
        }
    }

    protected zzaa(DriveId driveId) {
        this.zzags = driveId;
    }

    private PendingResult<MetadataResult> zza(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zza(new C12631(this, googleApiClient, z));
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzt) apiClient.zza(Drive.zzQf)).zza(apiClient, this.zzags, listener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient apiClient) {
        return ((zzt) apiClient.zza(Drive.zzQf)).zza(apiClient, this.zzags);
    }

    public PendingResult<Status> delete(GoogleApiClient apiClient) {
        return apiClient.zzb(new C12675(this, apiClient));
    }

    public DriveId getDriveId() {
        return this.zzags;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return zza(apiClient, false);
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.zza(new C12642(this, apiClient));
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzt) apiClient.zza(Drive.zzQf)).zzb(apiClient, this.zzags, listener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient apiClient) {
        return ((zzt) apiClient.zza(Drive.zzQf)).zzb(apiClient, this.zzags);
    }

    public PendingResult<Status> setParents(GoogleApiClient apiClient, Set<DriveId> parentIds) {
        if (parentIds != null) {
            return apiClient.zzb(new C12653(this, apiClient, new ArrayList(parentIds)));
        }
        throw new IllegalArgumentException("ParentIds must be provided.");
    }

    public PendingResult<Status> trash(GoogleApiClient apiClient) {
        return apiClient.zzb(new C12686(this, apiClient));
    }

    public PendingResult<Status> untrash(GoogleApiClient apiClient) {
        return apiClient.zzb(new C12697(this, apiClient));
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.zzb(new C12664(this, apiClient, changeSet));
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
