package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

public final class zzpc extends zzj<zzpf> {
    private final long zzasQ;

    private static final class zzf implements StartAdvertisingResult {
        private final Status zzQA;
        private final String zzaJv;

        zzf(Status status, String str) {
            this.zzQA = status;
            this.zzaJv = str;
        }

        public String getLocalEndpointName() {
            return this.zzaJv;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static class zzb extends zzpb {
        private final zzl<MessageListener> zzaJk;

        /* renamed from: com.google.android.gms.internal.zzpc.zzb.1 */
        class C08041 implements com.google.android.gms.common.api.zzl.zzb<MessageListener> {
            final /* synthetic */ String zzaJl;
            final /* synthetic */ boolean zzaJm;
            final /* synthetic */ zzb zzaJn;
            final /* synthetic */ byte[] zzavP;

            C08041(zzb com_google_android_gms_internal_zzpc_zzb, String str, byte[] bArr, boolean z) {
                this.zzaJn = com_google_android_gms_internal_zzpc_zzb;
                this.zzaJl = str;
                this.zzavP = bArr;
                this.zzaJm = z;
            }

            public void zza(MessageListener messageListener) {
                messageListener.onMessageReceived(this.zzaJl, this.zzavP, this.zzaJm);
            }

            public void zznh() {
            }

            public /* synthetic */ void zzo(Object obj) {
                zza((MessageListener) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzpc.zzb.2 */
        class C08052 implements com.google.android.gms.common.api.zzl.zzb<MessageListener> {
            final /* synthetic */ String zzaJl;
            final /* synthetic */ zzb zzaJn;

            C08052(zzb com_google_android_gms_internal_zzpc_zzb, String str) {
                this.zzaJn = com_google_android_gms_internal_zzpc_zzb;
                this.zzaJl = str;
            }

            public void zza(MessageListener messageListener) {
                messageListener.onDisconnected(this.zzaJl);
            }

            public void zznh() {
            }

            public /* synthetic */ void zzo(Object obj) {
                zza((MessageListener) obj);
            }
        }

        zzb(zzl<MessageListener> com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            this.zzaJk = com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_MessageListener;
        }

        public void onDisconnected(String remoteEndpointId) throws RemoteException {
            this.zzaJk.zza(new C08052(this, remoteEndpointId));
        }

        public void onMessageReceived(String remoteEndpointId, byte[] payload, boolean isReliable) throws RemoteException {
            this.zzaJk.zza(new C08041(this, remoteEndpointId, payload, isReliable));
        }
    }

    private static class zzc extends zzpb {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzaJo;

        zzc(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            this.zzaJo = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzij(int i) throws RemoteException {
            this.zzaJo.zzn(new Status(i));
        }
    }

    private static final class zze extends zzpb {
        private final com.google.android.gms.common.api.zzc.zzb<StartAdvertisingResult> zzQz;
        private final zzl<ConnectionRequestListener> zzaJr;

        /* renamed from: com.google.android.gms.internal.zzpc.zze.1 */
        class C08071 implements com.google.android.gms.common.api.zzl.zzb<ConnectionRequestListener> {
            final /* synthetic */ String zzaJl;
            final /* synthetic */ String zzaJs;
            final /* synthetic */ String zzaJt;
            final /* synthetic */ zze zzaJu;
            final /* synthetic */ byte[] zzavP;

            C08071(zze com_google_android_gms_internal_zzpc_zze, String str, String str2, String str3, byte[] bArr) {
                this.zzaJu = com_google_android_gms_internal_zzpc_zze;
                this.zzaJl = str;
                this.zzaJs = str2;
                this.zzaJt = str3;
                this.zzavP = bArr;
            }

            public void zza(ConnectionRequestListener connectionRequestListener) {
                connectionRequestListener.onConnectionRequest(this.zzaJl, this.zzaJs, this.zzaJt, this.zzavP);
            }

            public void zznh() {
            }

            public /* synthetic */ void zzo(Object obj) {
                zza((ConnectionRequestListener) obj);
            }
        }

        zze(com.google.android.gms.common.api.zzc.zzb<StartAdvertisingResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, zzl<ConnectionRequestListener> com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) {
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzv(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult);
            this.zzaJr = (zzl) zzx.zzv(com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener);
        }

        public void onConnectionRequest(String remoteEndpointId, String remoteDeviceId, String remoteEndpointName, byte[] payload) throws RemoteException {
            this.zzaJr.zza(new C08071(this, remoteEndpointId, remoteDeviceId, remoteEndpointName, payload));
        }

        public void zzk(int i, String str) throws RemoteException {
            this.zzQz.zzn(new zzf(new Status(i), str));
        }
    }

    private static final class zzg extends zzpb {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzQz;
        private final zzl<EndpointDiscoveryListener> zzaJr;

        /* renamed from: com.google.android.gms.internal.zzpc.zzg.1 */
        class C08081 implements com.google.android.gms.common.api.zzl.zzb<EndpointDiscoveryListener> {
            final /* synthetic */ String val$name;
            final /* synthetic */ String zzaJw;
            final /* synthetic */ String zzaJx;
            final /* synthetic */ String zzaJy;
            final /* synthetic */ zzg zzaJz;

            C08081(zzg com_google_android_gms_internal_zzpc_zzg, String str, String str2, String str3, String str4) {
                this.zzaJz = com_google_android_gms_internal_zzpc_zzg;
                this.zzaJw = str;
                this.zzaJx = str2;
                this.zzaJy = str3;
                this.val$name = str4;
            }

            public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                endpointDiscoveryListener.onEndpointFound(this.zzaJw, this.zzaJx, this.zzaJy, this.val$name);
            }

            public void zznh() {
            }

            public /* synthetic */ void zzo(Object obj) {
                zza((EndpointDiscoveryListener) obj);
            }
        }

        /* renamed from: com.google.android.gms.internal.zzpc.zzg.2 */
        class C08092 implements com.google.android.gms.common.api.zzl.zzb<EndpointDiscoveryListener> {
            final /* synthetic */ String zzaJw;
            final /* synthetic */ zzg zzaJz;

            C08092(zzg com_google_android_gms_internal_zzpc_zzg, String str) {
                this.zzaJz = com_google_android_gms_internal_zzpc_zzg;
                this.zzaJw = str;
            }

            public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                endpointDiscoveryListener.onEndpointLost(this.zzaJw);
            }

            public void zznh() {
            }

            public /* synthetic */ void zzo(Object obj) {
                zza((EndpointDiscoveryListener) obj);
            }
        }

        zzg(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, zzl<EndpointDiscoveryListener> com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) {
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzv(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
            this.zzaJr = (zzl) zzx.zzv(com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener);
        }

        public void onEndpointFound(String endpointId, String deviceId, String serviceId, String name) throws RemoteException {
            this.zzaJr.zza(new C08081(this, endpointId, deviceId, serviceId, name));
        }

        public void onEndpointLost(String endpointId) throws RemoteException {
            this.zzaJr.zza(new C08092(this, endpointId));
        }

        public void zzif(int i) throws RemoteException {
            this.zzQz.zzn(new Status(i));
        }
    }

    private static final class zza extends zzb {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzQz;

        public zza(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, zzl<MessageListener> com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzv(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
        }

        public void zzii(int i) throws RemoteException {
            this.zzQz.zzn(new Status(i));
        }
    }

    private static final class zzd extends zzb {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzQz;
        private final zzl<ConnectionResponseCallback> zzaJp;

        /* renamed from: com.google.android.gms.internal.zzpc.zzd.1 */
        class C08061 implements com.google.android.gms.common.api.zzl.zzb<ConnectionResponseCallback> {
            final /* synthetic */ int zzXm;
            final /* synthetic */ String zzaJl;
            final /* synthetic */ zzd zzaJq;
            final /* synthetic */ byte[] zzavP;

            C08061(zzd com_google_android_gms_internal_zzpc_zzd, String str, int i, byte[] bArr) {
                this.zzaJq = com_google_android_gms_internal_zzpc_zzd;
                this.zzaJl = str;
                this.zzXm = i;
                this.zzavP = bArr;
            }

            public void zza(ConnectionResponseCallback connectionResponseCallback) {
                connectionResponseCallback.onConnectionResponse(this.zzaJl, new Status(this.zzXm), this.zzavP);
            }

            public void zznh() {
            }

            public /* synthetic */ void zzo(Object obj) {
                zza((ConnectionResponseCallback) obj);
            }
        }

        public zzd(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, zzl<ConnectionResponseCallback> com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, zzl<MessageListener> com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzv(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
            this.zzaJp = (zzl) zzx.zzv(com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback);
        }

        public void zza(String str, int i, byte[] bArr) throws RemoteException {
            this.zzaJp.zza(new C08061(this, str, i, bArr));
        }

        public void zzih(int i) throws RemoteException {
            this.zzQz.zzn(new Status(i));
        }
    }

    public zzpc(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzasQ = (long) hashCode();
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzpf) zzoA()).zzE(this.zzasQ);
            } catch (Throwable e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzde(iBinder);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, String str, long j, zzl<EndpointDiscoveryListener> com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) throws RemoteException {
        ((zzpf) zzoA()).zza(new zzg(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener), str, j, this.zzasQ);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<StartAdvertisingResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, String str, AppMetadata appMetadata, long j, zzl<ConnectionRequestListener> com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) throws RemoteException {
        ((zzpf) zzoA()).zza(new zze(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener), str, appMetadata, j, this.zzasQ);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, String str, String str2, byte[] bArr, zzl<ConnectionResponseCallback> com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, zzl<MessageListener> com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_MessageListener) throws RemoteException {
        ((zzpf) zzoA()).zza(new zzd(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_MessageListener), str, str2, bArr, this.zzasQ);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, String str, byte[] bArr, zzl<MessageListener> com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_MessageListener) throws RemoteException {
        ((zzpf) zzoA()).zza(new zza(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_common_api_zzl_com_google_android_gms_nearby_connection_Connections_MessageListener), str, bArr, this.zzasQ);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            ((zzpf) zzoA()).zza(strArr, bArr, this.zzasQ);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            ((zzpf) zzoA()).zzb(strArr, bArr, this.zzasQ);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    protected zzpf zzde(IBinder iBinder) {
        return com.google.android.gms.internal.zzpf.zza.zzdg(iBinder);
    }

    public void zzec(String str) {
        try {
            ((zzpf) zzoA()).zzf(str, this.zzasQ);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    public void zzed(String str) {
        try {
            ((zzpf) zzoA()).zzg(str, this.zzasQ);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    protected String zzfA() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    public void zzp(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, String str) throws RemoteException {
        ((zzpf) zzoA()).zza(new zzc(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status), str, this.zzasQ);
    }

    public String zzyk() {
        try {
            return ((zzpf) zzoA()).zzQ(this.zzasQ);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String zzyl() {
        try {
            return ((zzpf) zzoA()).zzyl();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void zzym() {
        try {
            ((zzpf) zzoA()).zzN(this.zzasQ);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public void zzyn() {
        try {
            ((zzpf) zzoA()).zzP(this.zzasQ);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }
}
