package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzs.zza;
import com.google.android.gms.internal.zzlr;
import java.io.InputStream;
import java.io.OutputStream;

public class zzu implements DriveContents {
    private boolean mClosed;
    private final Contents zzaiD;
    private boolean zzaiE;
    private boolean zzaiF;

    /* renamed from: com.google.android.gms.drive.internal.zzu.3 */
    class C07293 implements ResultCallback<Status> {
        final /* synthetic */ zzu zzaiG;

        C07293(zzu com_google_android_gms_drive_internal_zzu) {
            this.zzaiG = com_google_android_gms_drive_internal_zzu;
        }

        public /* synthetic */ void onResult(Result x0) {
            zzr((Status) x0);
        }

        public void zzr(Status status) {
            if (status.isSuccess()) {
                zzy.zzv("DriveContentsImpl", "Contents discarded");
            } else {
                zzy.zzx("DriveContentsImpl", "Error discarding contents");
            }
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzu.1 */
    class C12791 extends zzb {
        final /* synthetic */ zzu zzaiG;

        C12791(zzu com_google_android_gms_drive_internal_zzu, GoogleApiClient googleApiClient) {
            this.zzaiG = com_google_android_gms_drive_internal_zzu;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new OpenContentsRequest(this.zzaiG.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.zzaiG.zzaiD.getRequestId()), new zzbj(this, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzu.2 */
    class C12802 extends zza {
        final /* synthetic */ zzu zzaiG;
        final /* synthetic */ MetadataChangeSet zzaiH;
        final /* synthetic */ ExecutionOptions zzaiI;

        C12802(zzu com_google_android_gms_drive_internal_zzu, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions) {
            this.zzaiG = com_google_android_gms_drive_internal_zzu;
            this.zzaiH = metadataChangeSet;
            this.zzaiI = executionOptions;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            this.zzaiH.zzqp().setContext(com_google_android_gms_drive_internal_zzt.getContext());
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new CloseContentsAndUpdateMetadataRequest(this.zzaiG.zzaiD.getDriveId(), this.zzaiH.zzqp(), this.zzaiG.zzaiD.getRequestId(), this.zzaiG.zzaiD.zzqf(), this.zzaiI), new zzbr(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzu.4 */
    class C12814 extends zza {
        final /* synthetic */ zzu zzaiG;

        C12814(zzu com_google_android_gms_drive_internal_zzu, GoogleApiClient googleApiClient) {
            this.zzaiG = com_google_android_gms_drive_internal_zzu;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new CloseContentsRequest(this.zzaiG.zzaiD.getRequestId(), false), new zzbr(this));
        }
    }

    public zzu(Contents contents) {
        this.mClosed = false;
        this.zzaiE = false;
        this.zzaiF = false;
        this.zzaiD = (Contents) zzx.zzv(contents);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        return commit(apiClient, changeSet, null);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new Builder().build();
        }
        if (this.zzaiD.getMode() == DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.zzcf(executionOptions.zzqn()) || this.zzaiD.zzqf()) {
            ExecutionOptions.zza(apiClient, executionOptions);
            if (zzqj()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if (changeSet == null) {
                    changeSet = MetadataChangeSet.zzagR;
                }
                zzqi();
                return apiClient.zzb(new C12802(this, apiClient, changeSet, executionOptions));
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public void discard(GoogleApiClient apiClient) {
        if (zzqj()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        zzqi();
        ((C12814) apiClient.zzb(new C12814(this, apiClient))).setResultCallback(new C07293(this));
    }

    public DriveId getDriveId() {
        return this.zzaiD.getDriveId();
    }

    public InputStream getInputStream() {
        if (zzqj()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.zzaiD.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.zzaiE) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.zzaiE = true;
            return this.zzaiD.getInputStream();
        }
    }

    public int getMode() {
        return this.zzaiD.getMode();
    }

    public OutputStream getOutputStream() {
        if (zzqj()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.zzaiD.getMode() != DriveFile.MODE_WRITE_ONLY) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.zzaiF) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.zzaiF = true;
            return this.zzaiD.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!zzqj()) {
            return this.zzaiD.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public PendingResult<DriveContentsResult> reopenForWrite(GoogleApiClient apiClient) {
        if (zzqj()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.zzaiD.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            zzqi();
            return apiClient.zza(new C12791(this, apiClient));
        }
    }

    public Contents zzqh() {
        return this.zzaiD;
    }

    public void zzqi() {
        zzlr.zza(this.zzaiD.getParcelFileDescriptor());
        this.mClosed = true;
    }

    public boolean zzqj() {
        return this.mClosed;
    }
}
