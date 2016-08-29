package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zzc.zza;
import com.google.android.gms.safetynet.SafetyNet;

abstract class zzpt<R extends Result> extends zza<R, zzpx> {
    public zzpt(GoogleApiClient googleApiClient) {
        super(SafetyNet.zzQf, googleApiClient);
    }
}
