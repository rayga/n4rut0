package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zza;

public abstract class zzb<R extends Result> extends zza<R, zze> {
    public zzb(GoogleApiClient googleApiClient) {
        super(zzk.zzQf, googleApiClient);
    }

    public void zzaT(int i) {
        zza(zzb(new Status(i)));
    }

    public void zzd(int i, String str) {
        zza(zzb(new Status(i, str, null)));
    }
}
