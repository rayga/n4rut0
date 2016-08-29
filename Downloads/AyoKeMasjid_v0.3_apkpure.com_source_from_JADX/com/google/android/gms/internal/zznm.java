package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zznm implements BleApi {

    private static class zza extends com.google.android.gms.internal.zznv.zza {
        private final zzb<BleDevicesResult> zzQz;

        private zza(zzb<BleDevicesResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_BleDevicesResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_BleDevicesResult;
        }

        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzQz.zzn(bleDevicesResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznm.6 */
    class C11996 extends zza<BleDevicesResult> {
        final /* synthetic */ zznm zzaoP;

        C11996(zznm com_google_android_gms_internal_zznm, GoogleApiClient googleApiClient) {
            this.zzaoP = com_google_android_gms_internal_zznm;
            super(googleApiClient);
        }

        protected BleDevicesResult zzH(Status status) {
            return BleDevicesResult.zzP(status);
        }

        protected void zza(zzmk com_google_android_gms_internal_zzmk) throws RemoteException {
            ((zzmv) com_google_android_gms_internal_zzmk.zzoA()).zza(new ListClaimedBleDevicesRequest(new zza(null), com_google_android_gms_internal_zzmk.getContext().getPackageName()));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzH(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zznm.1 */
    class C13621 extends zzc {
        final /* synthetic */ StartBleScanRequest zzaoO;
        final /* synthetic */ zznm zzaoP;

        C13621(zznm com_google_android_gms_internal_zznm, GoogleApiClient googleApiClient, StartBleScanRequest startBleScanRequest) {
            this.zzaoP = com_google_android_gms_internal_zznm;
            this.zzaoO = startBleScanRequest;
            super(googleApiClient);
        }

        protected void zza(zzmk com_google_android_gms_internal_zzmk) throws RemoteException {
            ((zzmv) com_google_android_gms_internal_zzmk.zzoA()).zza(new StartBleScanRequest(this.zzaoO, new zznt(this), com_google_android_gms_internal_zzmk.getContext().getPackageName()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zznm.2 */
    class C13632 extends zzc {
        final /* synthetic */ zznm zzaoP;
        final /* synthetic */ BleScanCallback zzaoQ;

        C13632(zznm com_google_android_gms_internal_zznm, GoogleApiClient googleApiClient, BleScanCallback bleScanCallback) {
            this.zzaoP = com_google_android_gms_internal_zznm;
            this.zzaoQ = bleScanCallback;
            super(googleApiClient);
        }

        protected void zza(zzmk com_google_android_gms_internal_zzmk) throws RemoteException {
            ((zzmv) com_google_android_gms_internal_zzmk.zzoA()).zza(new StopBleScanRequest(this.zzaoQ, new zznt(this), com_google_android_gms_internal_zzmk.getContext().getPackageName()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zznm.3 */
    class C13643 extends zzc {
        final /* synthetic */ zznm zzaoP;
        final /* synthetic */ String zzaoR;

        C13643(zznm com_google_android_gms_internal_zznm, GoogleApiClient googleApiClient, String str) {
            this.zzaoP = com_google_android_gms_internal_zznm;
            this.zzaoR = str;
            super(googleApiClient);
        }

        protected void zza(zzmk com_google_android_gms_internal_zzmk) throws RemoteException {
            ((zzmv) com_google_android_gms_internal_zzmk.zzoA()).zza(new ClaimBleDeviceRequest(this.zzaoR, null, new zznt(this), com_google_android_gms_internal_zzmk.getContext().getPackageName()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zznm.4 */
    class C13654 extends zzc {
        final /* synthetic */ zznm zzaoP;
        final /* synthetic */ BleDevice zzaoS;

        C13654(zznm com_google_android_gms_internal_zznm, GoogleApiClient googleApiClient, BleDevice bleDevice) {
            this.zzaoP = com_google_android_gms_internal_zznm;
            this.zzaoS = bleDevice;
            super(googleApiClient);
        }

        protected void zza(zzmk com_google_android_gms_internal_zzmk) throws RemoteException {
            ((zzmv) com_google_android_gms_internal_zzmk.zzoA()).zza(new ClaimBleDeviceRequest(this.zzaoS.getAddress(), this.zzaoS, new zznt(this), com_google_android_gms_internal_zzmk.getContext().getPackageName()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zznm.5 */
    class C13665 extends zzc {
        final /* synthetic */ zznm zzaoP;
        final /* synthetic */ String zzaoR;

        C13665(zznm com_google_android_gms_internal_zznm, GoogleApiClient googleApiClient, String str) {
            this.zzaoP = com_google_android_gms_internal_zznm;
            this.zzaoR = str;
            super(googleApiClient);
        }

        protected void zza(zzmk com_google_android_gms_internal_zzmk) throws RemoteException {
            ((zzmv) com_google_android_gms_internal_zzmk.zzoA()).zza(new UnclaimBleDeviceRequest(this.zzaoR, new zznt(this), com_google_android_gms_internal_zzmk.getContext().getPackageName()));
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return client.zzb(new C13654(this, client, bleDevice));
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, String deviceAddress) {
        return client.zzb(new C13643(this, client, deviceAddress));
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return client.zza(new C11996(this, client));
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, StartBleScanRequest request) {
        return client.zza(new C13621(this, client, request));
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, BleScanCallback requestCallback) {
        return client.zza(new C13632(this, client, requestCallback));
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return unclaimBleDevice(client, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, String deviceAddress) {
        return client.zzb(new C13665(this, client, deviceAddress));
    }
}
