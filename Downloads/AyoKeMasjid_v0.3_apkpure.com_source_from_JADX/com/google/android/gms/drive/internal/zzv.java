package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.api.zzl.zzb;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;

public class zzv extends zzaa implements DriveFile {

    private static class zza implements DownloadProgressListener {
        private final zzl<DownloadProgressListener> zzaiL;

        /* renamed from: com.google.android.gms.drive.internal.zzv.zza.1 */
        class C07301 implements zzb<DownloadProgressListener> {
            final /* synthetic */ long zzaiM;
            final /* synthetic */ long zzaiN;
            final /* synthetic */ zza zzaiO;

            C07301(zza com_google_android_gms_drive_internal_zzv_zza, long j, long j2) {
                this.zzaiO = com_google_android_gms_drive_internal_zzv_zza;
                this.zzaiM = j;
                this.zzaiN = j2;
            }

            public void zza(DownloadProgressListener downloadProgressListener) {
                downloadProgressListener.onProgress(this.zzaiM, this.zzaiN);
            }

            public void zznh() {
            }

            public /* synthetic */ void zzo(Object obj) {
                zza((DownloadProgressListener) obj);
            }
        }

        public zza(zzl<DownloadProgressListener> com_google_android_gms_common_api_zzl_com_google_android_gms_drive_DriveFile_DownloadProgressListener) {
            this.zzaiL = com_google_android_gms_common_api_zzl_com_google_android_gms_drive_DriveFile_DownloadProgressListener;
        }

        public void onProgress(long bytesDownloaded, long bytesExpected) {
            this.zzaiL.zza(new C07301(this, bytesDownloaded, bytesExpected));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzv.1 */
    class C12821 extends zzb {
        final /* synthetic */ DownloadProgressListener zzaiJ;
        final /* synthetic */ zzv zzaiK;
        final /* synthetic */ int zzaij;

        C12821(zzv com_google_android_gms_drive_internal_zzv, GoogleApiClient googleApiClient, int i, DownloadProgressListener downloadProgressListener) {
            this.zzaiK = com_google_android_gms_drive_internal_zzv;
            this.zzaij = i;
            this.zzaiJ = downloadProgressListener;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            zza(com_google_android_gms_drive_internal_zzt.zzqF().zza(new OpenContentsRequest(this.zzaiK.getDriveId(), this.zzaij, 0), new zzbj(this, this.zzaiJ)).zzqJ());
        }
    }

    public zzv(DriveId driveId) {
        super(driveId);
    }

    private static DownloadProgressListener zza(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        return downloadProgressListener == null ? null : new zza(googleApiClient.zzp(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient apiClient, int mode, DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            return apiClient.zza(new C12821(this, apiClient, mode, zza(apiClient, listener)));
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
