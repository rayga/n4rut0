package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

public final class zzl<L> {
    private volatile L mListener;
    private final zza zzaaz;

    private final class zza extends Handler {
        final /* synthetic */ zzl zzaaA;

        public zza(zzl com_google_android_gms_common_api_zzl, Looper looper) {
            this.zzaaA = com_google_android_gms_common_api_zzl;
            super(looper);
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            if (msg.what != 1) {
                z = false;
            }
            zzx.zzZ(z);
            this.zzaaA.zzb((zzb) msg.obj);
        }
    }

    public interface zzb<L> {
        void zznh();

        void zzo(L l);
    }

    zzl(Looper looper, L l) {
        this.zzaaz = new zza(this, looper);
        this.mListener = zzx.zzb((Object) l, (Object) "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> com_google_android_gms_common_api_zzl_zzb__super_L) {
        zzx.zzb((Object) com_google_android_gms_common_api_zzl_zzb__super_L, (Object) "Notifier must not be null");
        this.zzaaz.sendMessage(this.zzaaz.obtainMessage(1, com_google_android_gms_common_api_zzl_zzb__super_L));
    }

    void zzb(zzb<? super L> com_google_android_gms_common_api_zzl_zzb__super_L) {
        Object obj = this.mListener;
        if (obj == null) {
            com_google_android_gms_common_api_zzl_zzb__super_L.zznh();
            return;
        }
        try {
            com_google_android_gms_common_api_zzl_zzb__super_L.zzo(obj);
        } catch (RuntimeException e) {
            com_google_android_gms_common_api_zzl_zzb__super_L.zznh();
            throw e;
        }
    }
}
