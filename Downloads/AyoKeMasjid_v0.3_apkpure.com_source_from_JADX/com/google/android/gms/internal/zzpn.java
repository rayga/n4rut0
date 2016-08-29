package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;

public final class zzpn implements Account {

    private static abstract class zza extends com.google.android.gms.plus.Plus.zza<Status> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpn.1 */
    class C13861 extends zza {
        final /* synthetic */ zzpn zzaLE;

        C13861(zzpn com_google_android_gms_internal_zzpn, GoogleApiClient googleApiClient) {
            this.zzaLE = com_google_android_gms_internal_zzpn;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzm(this);
        }
    }

    public void clearDefaultAccount(GoogleApiClient googleApiClient) {
        zze zzf = Plus.zzf(googleApiClient, false);
        if (zzf != null) {
            zzf.zzyG();
        }
    }

    public String getAccountName(GoogleApiClient googleApiClient) {
        return Plus.zzf(googleApiClient, true).getAccountName();
    }

    public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C13861(this, googleApiClient));
    }
}
