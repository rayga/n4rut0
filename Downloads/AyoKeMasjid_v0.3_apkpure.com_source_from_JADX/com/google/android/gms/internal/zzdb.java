package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.internal.zzcw.zza;

@zzgk
public class zzdb extends zza {
    private final OnCustomTemplateAdLoadedListener zzwG;

    public zzdb(OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzwG = onCustomTemplateAdLoadedListener;
    }

    public void zza(zzcr com_google_android_gms_internal_zzcr) {
        this.zzwG.onCustomTemplateAdLoaded(new zzcs(com_google_android_gms_internal_zzcr));
    }
}
