package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;
import java.util.List;

public final class zzpd implements Connections {
    public static final com.google.android.gms.common.api.Api.zzc<zzpc> zzQf;
    public static final com.google.android.gms.common.api.Api.zza<zzpc, NoOptions> zzQg;

    /* renamed from: com.google.android.gms.internal.zzpd.1 */
    static class C08101 extends com.google.android.gms.common.api.Api.zza<zzpc, NoOptions> {
        C08101() {
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzo(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzpc zzo(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzpc(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    private static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzpc> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzpd.zzQf, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<StartAdvertisingResult> {

        /* renamed from: com.google.android.gms.internal.zzpd.zzb.1 */
        class C11481 implements StartAdvertisingResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ zzb zzaJH;

            C11481(zzb com_google_android_gms_internal_zzpd_zzb, Status status) {
                this.zzaJH = com_google_android_gms_internal_zzpd_zzb;
                this.zzQs = status;
            }

            public String getLocalEndpointName() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public StartAdvertisingResult zzaV(Status status) {
            return new C11481(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaV(status);
        }
    }

    private static abstract class zzc extends zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpd.2 */
    class C13792 extends zzb {
        final /* synthetic */ String val$name;
        final /* synthetic */ AppMetadata zzaJA;
        final /* synthetic */ long zzaJB;
        final /* synthetic */ zzl zzaJC;
        final /* synthetic */ zzpd zzaJD;

        C13792(zzpd com_google_android_gms_internal_zzpd, GoogleApiClient googleApiClient, String str, AppMetadata appMetadata, long j, zzl com_google_android_gms_common_api_zzl) {
            this.zzaJD = com_google_android_gms_internal_zzpd;
            this.val$name = str;
            this.zzaJA = appMetadata;
            this.zzaJB = j;
            this.zzaJC = com_google_android_gms_common_api_zzl;
            super(null);
        }

        protected void zza(zzpc com_google_android_gms_internal_zzpc) throws RemoteException {
            com_google_android_gms_internal_zzpc.zza(this, this.val$name, this.zzaJA, this.zzaJB, this.zzaJC);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpd.3 */
    class C13803 extends zzc {
        final /* synthetic */ long zzaJB;
        final /* synthetic */ zzpd zzaJD;
        final /* synthetic */ zzl zzaJE;
        final /* synthetic */ String zzaJy;

        C13803(zzpd com_google_android_gms_internal_zzpd, GoogleApiClient googleApiClient, String str, long j, zzl com_google_android_gms_common_api_zzl) {
            this.zzaJD = com_google_android_gms_internal_zzpd;
            this.zzaJy = str;
            this.zzaJB = j;
            this.zzaJE = com_google_android_gms_common_api_zzl;
            super(null);
        }

        protected void zza(zzpc com_google_android_gms_internal_zzpc) throws RemoteException {
            com_google_android_gms_internal_zzpc.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzaJy, this.zzaJB, this.zzaJE);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpd.4 */
    class C13814 extends zzc {
        final /* synthetic */ String val$name;
        final /* synthetic */ zzpd zzaJD;
        final /* synthetic */ zzl zzaJF;
        final /* synthetic */ zzl zzaJG;
        final /* synthetic */ String zzaJl;
        final /* synthetic */ byte[] zzavP;

        C13814(zzpd com_google_android_gms_internal_zzpd, GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, zzl com_google_android_gms_common_api_zzl, zzl com_google_android_gms_common_api_zzl2) {
            this.zzaJD = com_google_android_gms_internal_zzpd;
            this.val$name = str;
            this.zzaJl = str2;
            this.zzavP = bArr;
            this.zzaJF = com_google_android_gms_common_api_zzl;
            this.zzaJG = com_google_android_gms_common_api_zzl2;
            super(null);
        }

        protected void zza(zzpc com_google_android_gms_internal_zzpc) throws RemoteException {
            com_google_android_gms_internal_zzpc.zza(this, this.val$name, this.zzaJl, this.zzavP, this.zzaJF, this.zzaJG);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpd.5 */
    class C13825 extends zzc {
        final /* synthetic */ zzpd zzaJD;
        final /* synthetic */ zzl zzaJG;
        final /* synthetic */ String zzaJl;
        final /* synthetic */ byte[] zzavP;

        C13825(zzpd com_google_android_gms_internal_zzpd, GoogleApiClient googleApiClient, String str, byte[] bArr, zzl com_google_android_gms_common_api_zzl) {
            this.zzaJD = com_google_android_gms_internal_zzpd;
            this.zzaJl = str;
            this.zzavP = bArr;
            this.zzaJG = com_google_android_gms_common_api_zzl;
            super(null);
        }

        protected void zza(zzpc com_google_android_gms_internal_zzpc) throws RemoteException {
            com_google_android_gms_internal_zzpc.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzaJl, this.zzavP, this.zzaJG);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpd.6 */
    class C13836 extends zzc {
        final /* synthetic */ zzpd zzaJD;
        final /* synthetic */ String zzaJl;

        C13836(zzpd com_google_android_gms_internal_zzpd, GoogleApiClient googleApiClient, String str) {
            this.zzaJD = com_google_android_gms_internal_zzpd;
            this.zzaJl = str;
            super(null);
        }

        protected void zza(zzpc com_google_android_gms_internal_zzpc) throws RemoteException {
            com_google_android_gms_internal_zzpc.zzp(this, this.zzaJl);
        }
    }

    static {
        zzQf = new com.google.android.gms.common.api.Api.zzc();
        zzQg = new C08101();
    }

    public static zzpc zzd(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzpc zze(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza(Nearby.CONNECTIONS_API), (Object) "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (zzpc) googleApiClient.zza(zzQf) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
    }

    public PendingResult<Status> acceptConnectionRequest(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload, MessageListener messageListener) {
        return apiClient.zzb(new C13825(this, apiClient, remoteEndpointId, payload, apiClient.zzp(messageListener)));
    }

    public void disconnectFromEndpoint(GoogleApiClient apiClient, String remoteEndpointId) {
        zzd(apiClient, false).zzed(remoteEndpointId);
    }

    public String getLocalDeviceId(GoogleApiClient apiClient) {
        return zzd(apiClient, true).zzyl();
    }

    public String getLocalEndpointId(GoogleApiClient apiClient) {
        return zzd(apiClient, true).zzyk();
    }

    public PendingResult<Status> rejectConnectionRequest(GoogleApiClient apiClient, String remoteEndpointId) {
        return apiClient.zzb(new C13836(this, apiClient, remoteEndpointId));
    }

    public PendingResult<Status> sendConnectionRequest(GoogleApiClient apiClient, String name, String remoteEndpointId, byte[] payload, ConnectionResponseCallback connectionResponseCallback, MessageListener messageListener) {
        return apiClient.zzb(new C13814(this, apiClient, name, remoteEndpointId, payload, apiClient.zzp(connectionResponseCallback), apiClient.zzp(messageListener)));
    }

    public void sendReliableMessage(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload) {
        zzd(apiClient, false).zza(new String[]{remoteEndpointId}, payload);
    }

    public void sendReliableMessage(GoogleApiClient apiClient, List<String> remoteEndpointIds, byte[] payload) {
        zzd(apiClient, false).zza((String[]) remoteEndpointIds.toArray(new String[remoteEndpointIds.size()]), payload);
    }

    public void sendUnreliableMessage(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload) {
        zzd(apiClient, false).zzb(new String[]{remoteEndpointId}, payload);
    }

    public void sendUnreliableMessage(GoogleApiClient apiClient, List<String> remoteEndpointIds, byte[] payload) {
        zzd(apiClient, false).zzb((String[]) remoteEndpointIds.toArray(new String[remoteEndpointIds.size()]), payload);
    }

    public PendingResult<StartAdvertisingResult> startAdvertising(GoogleApiClient apiClient, String name, AppMetadata appMetadata, long durationMillis, ConnectionRequestListener connectionRequestListener) {
        return apiClient.zzb(new C13792(this, apiClient, name, appMetadata, durationMillis, apiClient.zzp(connectionRequestListener)));
    }

    public PendingResult<Status> startDiscovery(GoogleApiClient apiClient, String serviceId, long durationMillis, EndpointDiscoveryListener listener) {
        return apiClient.zzb(new C13803(this, apiClient, serviceId, durationMillis, apiClient.zzp(listener)));
    }

    public void stopAdvertising(GoogleApiClient apiClient) {
        zzd(apiClient, false).zzym();
    }

    public void stopAllEndpoints(GoogleApiClient apiClient) {
        zzd(apiClient, false).zzyn();
    }

    public void stopDiscovery(GoogleApiClient apiClient, String serviceId) {
        zzd(apiClient, false).zzec(serviceId);
    }
}
