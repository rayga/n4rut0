package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

@zzgk
public class zzcf implements CustomRenderedAd {
    private final zzcg zzvy;

    public zzcf(zzcg com_google_android_gms_internal_zzcg) {
        this.zzvy = com_google_android_gms_internal_zzcg;
    }

    public String getBaseUrl() {
        try {
            return this.zzvy.zzdp();
        } catch (Throwable e) {
            zzb.zzd("Could not delegate getBaseURL to CustomRenderedAd", e);
            return null;
        }
    }

    public String getContent() {
        try {
            return this.zzvy.getContent();
        } catch (Throwable e) {
            zzb.zzd("Could not delegate getContent to CustomRenderedAd", e);
            return null;
        }
    }

    public void onAdRendered(View view) {
        try {
            this.zzvy.zza(view != null ? zze.zzx(view) : null);
        } catch (Throwable e) {
            zzb.zzd("Could not delegate onAdRendered to CustomRenderedAd", e);
        }
    }

    public void recordClick() {
        try {
            this.zzvy.recordClick();
        } catch (Throwable e) {
            zzb.zzd("Could not delegate recordClick to CustomRenderedAd", e);
        }
    }

    public void recordImpression() {
        try {
            this.zzvy.recordImpression();
        } catch (Throwable e) {
            zzb.zzd("Could not delegate recordImpression to CustomRenderedAd", e);
        }
    }
}
