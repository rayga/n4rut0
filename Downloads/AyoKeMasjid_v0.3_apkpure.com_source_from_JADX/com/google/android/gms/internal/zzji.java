package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzji implements AppInviteApi {

    static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzjj> {
        public zza(GoogleApiClient googleApiClient) {
            super(AppInvite.zzQf, googleApiClient);
        }
    }

    final class zzb extends zza<Status> {
        private final String zzQh;
        final /* synthetic */ zzji zzQi;

        /* renamed from: com.google.android.gms.internal.zzji.zzb.1 */
        class C11431 extends com.google.android.gms.internal.zzjk.zza {
            final /* synthetic */ zzb zzQj;

            C11431(zzb com_google_android_gms_internal_zzji_zzb) {
                this.zzQj = com_google_android_gms_internal_zzji_zzb;
            }

            public void zze(Status status) throws RemoteException {
                this.zzQj.zza((Result) status);
            }
        }

        public zzb(zzji com_google_android_gms_internal_zzji, GoogleApiClient googleApiClient, String str) {
            this.zzQi = com_google_android_gms_internal_zzji;
            super(googleApiClient);
            this.zzQh = str;
        }

        protected void zza(zzjj com_google_android_gms_internal_zzjj) throws RemoteException {
            com_google_android_gms_internal_zzjj.zzb(new C11431(this), this.zzQh);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    final class zzc extends zza<Status> {
        private final String zzQh;
        final /* synthetic */ zzji zzQi;

        /* renamed from: com.google.android.gms.internal.zzji.zzc.1 */
        class C11441 extends com.google.android.gms.internal.zzjk.zza {
            final /* synthetic */ zzc zzQk;

            C11441(zzc com_google_android_gms_internal_zzji_zzc) {
                this.zzQk = com_google_android_gms_internal_zzji_zzc;
            }

            public void zze(Status status) throws RemoteException {
                this.zzQk.zza((Result) status);
            }
        }

        public zzc(zzji com_google_android_gms_internal_zzji, GoogleApiClient googleApiClient, String str) {
            this.zzQi = com_google_android_gms_internal_zzji;
            super(googleApiClient);
            this.zzQh = str;
        }

        protected void zza(zzjj com_google_android_gms_internal_zzjj) throws RemoteException {
            com_google_android_gms_internal_zzjj.zza(new C11441(this), this.zzQh);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    public PendingResult<Status> convertInvitation(GoogleApiClient client, String invitationId) {
        return client.zza(new zzc(this, client, invitationId));
    }

    public PendingResult<Status> updateInvitationOnInstall(GoogleApiClient client, String invitationId) {
        return client.zza(new zzb(this, client, invitationId));
    }
}
