package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

public class zzk extends com.google.android.gms.fitness.data.zzj.zza {
    private final OnDataPointListener zzaor;

    public static class zza {
        private static final zza zzaos;
        private final Map<OnDataPointListener, zzk> zzaot;

        static {
            zzaos = new zza();
        }

        private zza() {
            this.zzaot = new HashMap();
        }

        public static zza zzrL() {
            return zzaos;
        }

        public zzk zza(OnDataPointListener onDataPointListener) {
            zzk com_google_android_gms_fitness_data_zzk;
            synchronized (this.zzaot) {
                com_google_android_gms_fitness_data_zzk = (zzk) this.zzaot.get(onDataPointListener);
                if (com_google_android_gms_fitness_data_zzk == null) {
                    com_google_android_gms_fitness_data_zzk = new zzk(null);
                    this.zzaot.put(onDataPointListener, com_google_android_gms_fitness_data_zzk);
                }
            }
            return com_google_android_gms_fitness_data_zzk;
        }

        public zzk zzb(OnDataPointListener onDataPointListener) {
            zzk com_google_android_gms_fitness_data_zzk;
            synchronized (this.zzaot) {
                com_google_android_gms_fitness_data_zzk = (zzk) this.zzaot.get(onDataPointListener);
            }
            return com_google_android_gms_fitness_data_zzk;
        }

        public zzk zzc(OnDataPointListener onDataPointListener) {
            zzk com_google_android_gms_fitness_data_zzk;
            synchronized (this.zzaot) {
                com_google_android_gms_fitness_data_zzk = (zzk) this.zzaot.remove(onDataPointListener);
                if (com_google_android_gms_fitness_data_zzk != null) {
                } else {
                    com_google_android_gms_fitness_data_zzk = new zzk(null);
                }
            }
            return com_google_android_gms_fitness_data_zzk;
        }
    }

    private zzk(OnDataPointListener onDataPointListener) {
        this.zzaor = (OnDataPointListener) zzx.zzv(onDataPointListener);
    }

    public void zzc(DataPoint dataPoint) throws RemoteException {
        this.zzaor.onDataPoint(dataPoint);
    }
}
