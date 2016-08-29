package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;

public class zzbr extends zzd {
    private final zzb<Status> zzQz;

    public zzbr(zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
        this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status;
    }

    public void onSuccess() throws RemoteException {
        this.zzQz.zzn(Status.zzaaD);
    }

    public void zzy(Status status) throws RemoteException {
        this.zzQz.zzn(status);
    }
}
