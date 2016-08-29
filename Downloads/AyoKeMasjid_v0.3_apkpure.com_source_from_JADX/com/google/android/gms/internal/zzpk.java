package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class zzpk implements PanoramaResult {
    private final Status zzQA;
    private final Intent zzaKB;

    public zzpk(Status status, Intent intent) {
        this.zzQA = (Status) zzx.zzv(status);
        this.zzaKB = intent;
    }

    public Status getStatus() {
        return this.zzQA;
    }

    public Intent getViewerIntent() {
        return this.zzaKB;
    }
}
