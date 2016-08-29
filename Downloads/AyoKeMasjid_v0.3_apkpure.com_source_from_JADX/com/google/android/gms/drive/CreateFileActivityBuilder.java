package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzk;
import com.google.android.gms.drive.internal.zzu;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final zzk zzagu;
    private DriveContents zzagv;
    private boolean zzagw;

    public CreateFileActivityBuilder() {
        this.zzagu = new zzk(0);
    }

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zzb(Boolean.valueOf(this.zzagw), (Object) "Must call setInitialDriveContents to CreateFileActivityBuilder.");
        zzx.zza(apiClient.isConnected(), (Object) "Client must be connected");
        boolean z = apiClient.zza(Drive.SCOPE_FILE) || apiClient.zza(Drive.zzagx);
        zzx.zzb(z, (Object) "The apiClient must have suitable scope to create files");
        if (this.zzagv != null) {
            this.zzagv.zzqi();
        }
        return this.zzagu.build(apiClient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.zzagu.zza(folder);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String title) {
        this.zzagu.zzcF(title);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents driveContents) {
        if (driveContents == null) {
            this.zzagu.zzcC(1);
        } else if (!(driveContents instanceof zzu)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.zzqj()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            this.zzagu.zzcC(driveContents.zzqh().getRequestId());
            this.zzagv = driveContents;
        }
        this.zzagw = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.zzagu.zza(metadataChangeSet);
        return this;
    }
}
