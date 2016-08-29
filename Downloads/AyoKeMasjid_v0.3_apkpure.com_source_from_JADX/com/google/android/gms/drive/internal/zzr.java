package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public class zzr implements DriveApi {

    static class zza implements Releasable, DriveContentsResult {
        private final Status zzQA;
        private final DriveContents zzagv;

        public zza(Status status, DriveContents driveContents) {
            this.zzQA = status;
            this.zzagv = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.zzagv;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzagv != null) {
                this.zzagv.zzqi();
            }
        }
    }

    private static class zzd implements DriveIdResult {
        private final Status zzQA;
        private final DriveId zzags;

        public zzd(Status status, DriveId driveId) {
            this.zzQA = status;
            this.zzags = driveId;
        }

        public DriveId getDriveId() {
            return this.zzags;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    static class zzf implements MetadataBufferResult {
        private final Status zzQA;
        private final MetadataBuffer zzain;
        private final boolean zzaio;

        public zzf(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.zzQA = status;
            this.zzain = metadataBuffer;
            this.zzaio = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.zzain;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzain != null) {
                this.zzain.release();
            }
        }
    }

    static class zzc extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<DriveIdResult> zzQz;

        public zzc(com.google.android.gms.common.api.zzc.zzb<DriveIdResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveApi_DriveIdResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveApi_DriveIdResult;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzQz.zzn(new zzd(Status.zzaaD, onDriveIdResponse.getDriveId()));
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzQz.zzn(new zzd(Status.zzaaD, new zzo(onMetadataResponse.zzqW()).getDriveId()));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zzd(status, null));
        }
    }

    private static class zzh extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<DriveContentsResult> zzQz;

        public zzh(com.google.android.gms.common.api.zzc.zzb<DriveContentsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult;
        }

        public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
            this.zzQz.zzn(new zza(Status.zzaaD, new zzu(onContentsResponse.zzqN())));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zza(status, null));
        }
    }

    private static class zzi extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<MetadataBufferResult> zzQz;

        public zzi(com.google.android.gms.common.api.zzc.zzb<MetadataBufferResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.zzQz.zzn(new zzf(Status.zzaaD, new MetadataBuffer(onListEntriesResponse.zzqT()), onListEntriesResponse.zzqU()));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zzf(status, null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzr.5 */
    class C11915 extends zzs<BooleanResult> {
        final /* synthetic */ zzr zzaii;

        /* renamed from: com.google.android.gms.drive.internal.zzr.5.1 */
        class C11781 extends zzd {
            final /* synthetic */ zzs zzail;
            final /* synthetic */ C11915 zzaim;

            C11781(C11915 c11915, zzs com_google_android_gms_drive_internal_zzs) {
                this.zzaim = c11915;
                this.zzail = com_google_android_gms_drive_internal_zzs;
            }

            public void zzaa(boolean z) {
                this.zzail.zza(new BooleanResult(Status.zzaaD, z));
            }
        }

        C11915(zzr com_google_android_gms_drive_internal_zzr, GoogleApiClient googleApiClient) {
            this.zzaii = com_google_android_gms_drive_internal_zzr;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zze(new C11781(this, this));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzz(status);
        }

        protected BooleanResult zzz(Status status) {
            return new BooleanResult(status, false);
        }
    }

    static abstract class zzb extends zzs<DriveContentsResult> {
        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveContentsResult zzA(Status status) {
            return new zza(status, null);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzA(status);
        }
    }

    static abstract class zze extends zzs<DriveIdResult> {
        zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveIdResult zzB(Status status) {
            return new zzd(status, null);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzB(status);
        }
    }

    static abstract class zzg extends zzs<MetadataBufferResult> {
        zzg(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public MetadataBufferResult zzC(Status status) {
            return new zzf(status, null, false);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzC(status);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzr.1 */
    class C12701 extends zzg {
        final /* synthetic */ Query zzaih;
        final /* synthetic */ zzr zzaii;

        C12701(zzr com_google_android_gms_drive_internal_zzr, GoogleApiClient googleApiClient, Query query) {
            this.zzaii = com_google_android_gms_drive_internal_zzr;
            this.zzaih = query;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new QueryRequest(this.zzaih), new zzi(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzr.2 */
    class C12712 extends zzb {
        final /* synthetic */ zzr zzaii;
        final /* synthetic */ int zzaij;

        C12712(zzr com_google_android_gms_drive_internal_zzr, GoogleApiClient googleApiClient, int i) {
            this.zzaii = com_google_android_gms_drive_internal_zzr;
            this.zzaij = i;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new CreateContentsRequest(this.zzaij), new zzh(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzr.3 */
    class C12723 extends zze {
        final /* synthetic */ zzr zzaii;
        final /* synthetic */ String zzaik;

        C12723(zzr com_google_android_gms_drive_internal_zzr, GoogleApiClient googleApiClient, String str) {
            this.zzaii = com_google_android_gms_drive_internal_zzr;
            this.zzaik = str;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new GetMetadataRequest(DriveId.zzcC(this.zzaik), false), new zzc(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzr.4 */
    class C12734 extends com.google.android.gms.drive.internal.zzs.zza {
        final /* synthetic */ zzr zzaii;

        C12734(zzr com_google_android_gms_drive_internal_zzr, GoogleApiClient googleApiClient) {
            this.zzaii = com_google_android_gms_drive_internal_zzr;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new zzbr(this));
        }
    }

    static class zzj extends com.google.android.gms.drive.internal.zzs.zza {
        zzj(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            zza((Result) status);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) {
        }
    }

    public PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, List<String> trackingTags) {
        return ((zzt) apiClient.zza(Drive.zzQf)).cancelPendingActions(apiClient, trackingTags);
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, String resourceId) {
        return apiClient.zza(new C12723(this, apiClient, resourceId));
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            DriveId zzqH = ((zzt) apiClient.zza(Drive.zzQf)).zzqH();
            return zzqH != null ? new zzx(zzqH) : null;
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new zzv(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new zzx(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new zzx(((zzt) apiClient.zza(Drive.zzQf)).zzqG());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public PendingResult<BooleanResult> isAutobackupEnabled(GoogleApiClient apiClient) {
        return apiClient.zza(new C11915(this, apiClient));
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveContentsResult> newDriveContents(GoogleApiClient apiClient) {
        return zza(apiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, Query query) {
        if (query != null) {
            return apiClient.zza(new C12701(this, apiClient, query));
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient apiClient) {
        return apiClient.zzb(new C12734(this, apiClient));
    }

    public PendingResult<DriveContentsResult> zza(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.zza(new C12712(this, googleApiClient, i));
    }
}
