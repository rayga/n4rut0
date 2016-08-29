package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.HashMap;
import java.util.Map;

public class zza extends com.google.android.gms.fitness.request.zzn.zza {
    private final BleScanCallback zzapz;

    public static class zza {
        private static final zza zzapA;
        private final Map<BleScanCallback, zza> zzapB;

        static {
            zzapA = new zza();
        }

        private zza() {
            this.zzapB = new HashMap();
        }

        public static zza zzsa() {
            return zzapA;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza com_google_android_gms_fitness_request_zza;
            synchronized (this.zzapB) {
                com_google_android_gms_fitness_request_zza = (zza) this.zzapB.get(bleScanCallback);
                if (com_google_android_gms_fitness_request_zza == null) {
                    com_google_android_gms_fitness_request_zza = new zza(null);
                    this.zzapB.put(bleScanCallback, com_google_android_gms_fitness_request_zza);
                }
            }
            return com_google_android_gms_fitness_request_zza;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza com_google_android_gms_fitness_request_zza;
            synchronized (this.zzapB) {
                com_google_android_gms_fitness_request_zza = (zza) this.zzapB.get(bleScanCallback);
                if (com_google_android_gms_fitness_request_zza != null) {
                } else {
                    com_google_android_gms_fitness_request_zza = new zza(null);
                }
            }
            return com_google_android_gms_fitness_request_zza;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzapz = (BleScanCallback) zzx.zzv(bleScanCallback);
    }

    public void onDeviceFound(BleDevice device) throws RemoteException {
        this.zzapz.onDeviceFound(device);
    }

    public void onScanStopped() throws RemoteException {
        this.zzapz.onScanStopped();
    }
}
