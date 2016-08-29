package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zzkz<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzla> {

    static abstract class zza extends zzkz<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    public zzkz(GoogleApiClient googleApiClient) {
        super(zzkw.zzQf, googleApiClient);
    }
}
