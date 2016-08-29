package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.playlog.internal.zzb.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzf extends zzj<zza> {
    private final String zzOZ;
    private final zzd zzaKZ;
    private final zzb zzaLa;
    private boolean zzaLb;
    private final Object zzpc;

    public zzf(Context context, Looper looper, zzd com_google_android_gms_playlog_internal_zzd, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 24, com_google_android_gms_common_internal_zzf, com_google_android_gms_playlog_internal_zzd, com_google_android_gms_playlog_internal_zzd);
        this.zzOZ = context.getPackageName();
        this.zzaKZ = (zzd) zzx.zzv(com_google_android_gms_playlog_internal_zzd);
        this.zzaKZ.zza(this);
        this.zzaLa = new zzb();
        this.zzpc = new Object();
        this.zzaLb = true;
    }

    private void zzc(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzaLa.zza(playLoggerContext, logEvent);
    }

    private void zzd(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        try {
            zzyE();
            ((zza) zzoA()).zza(this.zzOZ, playLoggerContext, logEvent);
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            zzc(playLoggerContext, logEvent);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            zzc(playLoggerContext, logEvent);
        }
    }

    private void zzyE() {
        zzb.zzY(!this.zzaLb);
        if (!this.zzaLa.isEmpty()) {
            PlayLoggerContext playLoggerContext = null;
            try {
                List arrayList = new ArrayList();
                Iterator it = this.zzaLa.zzyC().iterator();
                while (it.hasNext()) {
                    zza com_google_android_gms_playlog_internal_zzb_zza = (zza) it.next();
                    if (com_google_android_gms_playlog_internal_zzb_zza.zzaKO != null) {
                        ((zza) zzoA()).zza(this.zzOZ, com_google_android_gms_playlog_internal_zzb_zza.zzaKM, zzrx.zzf(com_google_android_gms_playlog_internal_zzb_zza.zzaKO));
                    } else {
                        PlayLoggerContext playLoggerContext2;
                        if (com_google_android_gms_playlog_internal_zzb_zza.zzaKM.equals(playLoggerContext)) {
                            arrayList.add(com_google_android_gms_playlog_internal_zzb_zza.zzaKN);
                            playLoggerContext2 = playLoggerContext;
                        } else {
                            if (!arrayList.isEmpty()) {
                                ((zza) zzoA()).zza(this.zzOZ, playLoggerContext, arrayList);
                                arrayList.clear();
                            }
                            PlayLoggerContext playLoggerContext3 = com_google_android_gms_playlog_internal_zzb_zza.zzaKM;
                            arrayList.add(com_google_android_gms_playlog_internal_zzb_zza.zzaKN);
                            playLoggerContext2 = playLoggerContext3;
                        }
                        playLoggerContext = playLoggerContext2;
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((zza) zzoA()).zza(this.zzOZ, playLoggerContext, arrayList);
                }
                this.zzaLa.clear();
            } catch (RemoteException e) {
                Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    public void start() {
        synchronized (this.zzpc) {
            if (isConnecting() || isConnected()) {
                return;
            }
            this.zzaKZ.zzan(true);
            zzox();
        }
    }

    public void stop() {
        synchronized (this.zzpc) {
            this.zzaKZ.zzan(false);
            disconnect();
        }
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzdu(iBinder);
    }

    void zzao(boolean z) {
        synchronized (this.zzpc) {
            boolean z2 = this.zzaLb;
            this.zzaLb = z;
            if (z2 && !this.zzaLb) {
                zzyE();
            }
        }
    }

    public void zzb(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        synchronized (this.zzpc) {
            if (this.zzaLb) {
                zzc(playLoggerContext, logEvent);
            } else {
                zzd(playLoggerContext, logEvent);
            }
        }
    }

    protected zza zzdu(IBinder iBinder) {
        return zza.zza.zzdt(iBinder);
    }

    protected String zzfA() {
        return "com.google.android.gms.playlog.service.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }
}
