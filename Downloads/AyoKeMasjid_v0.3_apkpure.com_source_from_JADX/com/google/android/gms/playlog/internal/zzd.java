package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzpm.zza;

public class zzd implements ConnectionCallbacks, OnConnectionFailedListener {
    private zzf zzaKE;
    private final zza zzaKP;
    private boolean zzaKQ;

    public zzd(zza com_google_android_gms_internal_zzpm_zza) {
        this.zzaKP = com_google_android_gms_internal_zzpm_zza;
        this.zzaKE = null;
        this.zzaKQ = true;
    }

    public void onConnected(Bundle connectionHint) {
        this.zzaKE.zzao(false);
        if (this.zzaKQ && this.zzaKP != null) {
            this.zzaKP.zzyA();
        }
        this.zzaKQ = false;
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.zzaKE.zzao(true);
        if (this.zzaKQ && this.zzaKP != null) {
            if (result.hasResolution()) {
                this.zzaKP.zzh(result.getResolution());
            } else {
                this.zzaKP.zzyB();
            }
        }
        this.zzaKQ = false;
    }

    public void onConnectionSuspended(int cause) {
        this.zzaKE.zzao(true);
    }

    public void zza(zzf com_google_android_gms_playlog_internal_zzf) {
        this.zzaKE = com_google_android_gms_playlog_internal_zzf;
    }

    public void zzan(boolean z) {
        this.zzaKQ = z;
    }
}
