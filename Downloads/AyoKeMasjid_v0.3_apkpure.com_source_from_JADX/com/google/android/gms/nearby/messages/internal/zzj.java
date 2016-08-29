package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.nearby.messages.internal.zzc.zza;

final class zzj extends zza {
    private final zzb<Status> zzaKb;

    private zzj(zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
        this.zzaKb = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status;
    }

    static zzj zzj(zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
        return new zzj(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
    }

    public void zzaU(Status status) throws RemoteException {
        this.zzaKb.zzn(status);
    }
}
