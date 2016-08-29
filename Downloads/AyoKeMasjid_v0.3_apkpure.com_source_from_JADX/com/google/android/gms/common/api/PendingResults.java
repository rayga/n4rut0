package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzx;

public final class PendingResults {

    private static final class zza<R extends Result> extends zzb<R> {
        private final R zzaaB;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzaaB = r;
        }

        protected R zzb(Status status) {
            if (status.getStatusCode() == this.zzaaB.getStatus().getStatusCode()) {
                return this.zzaaB;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private static final class zzb<R extends Result> extends zza<R> {
        public zzb() {
            super(Looper.getMainLooper());
        }

        protected R zzb(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        PendingResult com_google_android_gms_common_api_zzo = new zzo(Looper.getMainLooper());
        com_google_android_gms_common_api_zzo.cancel();
        return com_google_android_gms_common_api_zzo;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R result) {
        zzx.zzb((Object) result, (Object) "Result must not be null");
        zzx.zzb(result.getStatus().getStatusCode() == 16, (Object) "Status code must be CommonStatusCodes.CANCELED");
        PendingResult com_google_android_gms_common_api_PendingResults_zza = new zza(result);
        com_google_android_gms_common_api_PendingResults_zza.cancel();
        return com_google_android_gms_common_api_PendingResults_zza;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R result) {
        zzx.zzb((Object) result, (Object) "Result must not be null");
        OptionalPendingResult com_google_android_gms_common_api_PendingResults_zzb = new zzb();
        com_google_android_gms_common_api_PendingResults_zzb.zza((Result) result);
        return com_google_android_gms_common_api_PendingResults_zzb;
    }

    public static PendingResult<Status> immediatePendingResult(Status result) {
        zzx.zzb((Object) result, (Object) "Result must not be null");
        PendingResult com_google_android_gms_common_api_zzo = new zzo(Looper.getMainLooper());
        com_google_android_gms_common_api_zzo.zza((Result) result);
        return com_google_android_gms_common_api_zzo;
    }
}
