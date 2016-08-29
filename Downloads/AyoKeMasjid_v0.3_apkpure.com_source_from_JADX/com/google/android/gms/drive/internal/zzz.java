package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;

public class zzz implements DrivePreferencesApi {

    private class zzb implements FileUploadPreferencesResult {
        private final Status zzQA;
        final /* synthetic */ zzz zzaiX;
        private final FileUploadPreferences zzaiZ;

        private zzb(zzz com_google_android_gms_drive_internal_zzz, Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzaiX = com_google_android_gms_drive_internal_zzz;
            this.zzQA = status;
            this.zzaiZ = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzaiZ;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private class zza extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<FileUploadPreferencesResult> zzQz;
        final /* synthetic */ zzz zzaiX;

        private zza(zzz com_google_android_gms_drive_internal_zzz, com.google.android.gms.common.api.zzc.zzb<FileUploadPreferencesResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult) {
            this.zzaiX = com_google_android_gms_drive_internal_zzz;
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult;
        }

        public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.zzQz.zzn(new zzb(Status.zzaaD, onDeviceUsagePreferenceResponse.zzqP(), null));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zzb(status, null, null));
        }
    }

    private abstract class zzc extends zzs<FileUploadPreferencesResult> {
        final /* synthetic */ zzz zzaiX;

        public zzc(zzz com_google_android_gms_drive_internal_zzz, GoogleApiClient googleApiClient) {
            this.zzaiX = com_google_android_gms_drive_internal_zzz;
            super(googleApiClient);
        }

        protected FileUploadPreferencesResult zzF(Status status) {
            return new zzb(status, null, null);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzF(status);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzz.1 */
    class C12851 extends zzc {
        final /* synthetic */ zzz zzaiX;

        C12851(zzz com_google_android_gms_drive_internal_zzz, GoogleApiClient googleApiClient) {
            this.zzaiX = com_google_android_gms_drive_internal_zzz;
            super(com_google_android_gms_drive_internal_zzz, googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zzd(new zza(this, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.zzz.2 */
    class C12862 extends com.google.android.gms.drive.internal.zzs.zza {
        final /* synthetic */ zzz zzaiX;
        final /* synthetic */ FileUploadPreferencesImpl zzaiY;

        C12862(zzz com_google_android_gms_drive_internal_zzz, GoogleApiClient googleApiClient, FileUploadPreferencesImpl fileUploadPreferencesImpl) {
            this.zzaiX = com_google_android_gms_drive_internal_zzz;
            this.zzaiY = fileUploadPreferencesImpl;
            super(googleApiClient);
        }

        protected void zza(zzt com_google_android_gms_drive_internal_zzt) throws RemoteException {
            com_google_android_gms_drive_internal_zzt.zzqF().zza(new SetFileUploadPreferencesRequest(this.zzaiY), new zzbr(this));
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient apiClient) {
        return apiClient.zza(new C12851(this, apiClient));
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient apiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof FileUploadPreferencesImpl) {
            return apiClient.zzb(new C12862(this, apiClient, (FileUploadPreferencesImpl) fileUploadPreferences));
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}
