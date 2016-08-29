package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

public class zzx extends zzaa implements DriveFolder {

    private static class zzc implements DriveFileResult {
        private final Status zzQA;
        private final DriveFile zzaiU;

        public zzc(Status status, DriveFile driveFile) {
            this.zzQA = status;
            this.zzaiU = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.zzaiU;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static class zze implements DriveFolderResult {
        private final Status zzQA;
        private final DriveFolder zzaiV;

        public zze(Status status, DriveFolder driveFolder) {
            this.zzQA = status;
            this.zzaiV = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.zzaiV;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static class zza extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<DriveFileResult> zzQz;

        public zza(com.google.android.gms.common.api.zzc.zzb<DriveFileResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveFolder_DriveFileResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveFolder_DriveFileResult;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzQz.zzn(new zzc(Status.zzaaD, new zzv(onDriveIdResponse.getDriveId())));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zzc(status, null));
        }
    }

    private static class zzb extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<DriveFolderResult> zzQz;

        public zzb(com.google.android.gms.common.api.zzc.zzb<DriveFolderResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveFolder_DriveFolderResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DriveFolder_DriveFolderResult;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzQz.zzn(new zze(Status.zzaaD, new zzx(onDriveIdResponse.getDriveId())));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zze(status, null));
        }
    }

    static abstract class zzd extends zzs<DriveFileResult> {
        zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveFileResult zzD(Status status) {
            return new zzc(status, null);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzD(status);
        }
    }

    static abstract class zzf extends zzs<DriveFolderResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveFolderResult zzE(Status status) {
            return new zze(status, null);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzE(status);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzx.1 */
    class C12831 extends zzd {
        final /* synthetic */ MetadataChangeSet zzaiP;
        final /* synthetic */ int zzaiQ;
        final /* synthetic */ int zzaiR;
        final /* synthetic */ ExecutionOptions zzaiS;
        final /* synthetic */ zzx zzaiT;

        C12831(zzx com_google_android_gms_drive_internal_zzx, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
            this.zzaiT = com_google_android_gms_drive_internal_zzx;
            this.zzaiP = metadataChangeSet;
            this.zzaiQ = i;
            this.zzaiR = i2;
            this.zzaiS = executionOptions;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            this.zzaiP.zzqp().setContext(com_google_android_gms_drive_internal_zzt.getContext());
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new CreateFileRequest(this.zzaiT.getDriveId(), this.zzaiP.zzqp(), this.zzaiQ, this.zzaiR, this.zzaiS), new zza(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzx.2 */
    class C12842 extends zzf {
        final /* synthetic */ MetadataChangeSet zzaiP;
        final /* synthetic */ zzx zzaiT;

        C12842(zzx com_google_android_gms_drive_internal_zzx, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
            this.zzaiT = com_google_android_gms_drive_internal_zzx;
            this.zzaiP = metadataChangeSet;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            this.zzaiP.zzqp().setContext(com_google_android_gms_drive_internal_zzt.getContext());
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new CreateFolderRequest(this.zzaiT.getDriveId(), this.zzaiP.zzqp()), new zzb(this));
        }
    }

    public zzx(DriveId driveId) {
        super(driveId);
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        ExecutionOptions.zza(googleApiClient, executionOptions);
        return googleApiClient.zzb(new C12831(this, googleApiClient, metadataChangeSet, i, i2, executionOptions));
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        int i;
        if (driveContents == null) {
            i = 1;
        } else if (!(driveContents instanceof zzu)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.zzqj()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            i = driveContents.zzqh().getRequestId();
            driveContents.zzqi();
        }
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            return zza(googleApiClient, metadataChangeSet, i, 0, executionOptions);
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    private Query zza(Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return addFilter.build();
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents) {
        return createFile(apiClient, changeSet, driveContents, null);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new ExecutionOptions.Builder().build();
        }
        if (executionOptions.zzqn() == 0) {
            return zza(apiClient, changeSet, driveContents, executionOptions);
        }
        throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.zzb(new C12842(this, apiClient, changeSet));
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        return new zzr().query(apiClient, zza(query));
    }
}
