package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class zzd {
    protected final zzl zzWK;
    private final String zzWL;
    private zzn zzWM;

    protected zzd(String str, String str2, String str3) {
        zzf.zzbL(str);
        this.zzWL = str;
        this.zzWK = new zzl(str2);
        setSessionLabel(str3);
    }

    public final String getNamespace() {
        return this.zzWL;
    }

    public void setSessionLabel(String sessionLabel) {
        if (!TextUtils.isEmpty(sessionLabel)) {
            this.zzWK.zzbR(sessionLabel);
        }
    }

    public final void zza(zzn com_google_android_gms_cast_internal_zzn) {
        this.zzWM = com_google_android_gms_cast_internal_zzn;
        if (this.zzWM == null) {
            zzmt();
        }
    }

    protected final void zza(String str, long j, String str2) throws IOException {
        this.zzWK.zza("Sending text message: %s to: %s", str, str2);
        this.zzWM.zza(this.zzWL, str, j, str2);
    }

    public void zzb(long j, int i) {
    }

    public void zzbJ(String str) {
    }

    public void zzmt() {
    }

    protected final long zzmu() {
        return this.zzWM.zzme();
    }
}
