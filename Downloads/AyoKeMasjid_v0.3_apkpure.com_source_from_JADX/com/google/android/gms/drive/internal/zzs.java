package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;

public abstract class zzs<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzt> {

    public static abstract class zza extends zzs<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    public zzs(GoogleApiClient googleApiClient) {
        super(Drive.zzQf, googleApiClient);
    }
}
