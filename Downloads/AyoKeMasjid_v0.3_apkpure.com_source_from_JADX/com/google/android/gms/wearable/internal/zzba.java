package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.ArrayList;
import java.util.List;

public final class zzba implements NodeApi {

    public static class zzb implements GetConnectedNodesResult {
        private final Status zzQA;
        private final List<Node> zzbaM;

        public zzb(Status status, List<Node> list) {
            this.zzQA = status;
            this.zzbaM = list;
        }

        public List<Node> getNodes() {
            return this.zzbaM;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public static class zzc implements GetLocalNodeResult {
        private final Status zzQA;
        private final Node zzbaN;

        public zzc(Status status, Node node) {
            this.zzQA = status;
            this.zzbaN = node;
        }

        public Node getNode() {
            return this.zzbaN;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzba.1 */
    class C12231 extends zzh<GetLocalNodeResult> {
        final /* synthetic */ zzba zzbaJ;

        C12231(zzba com_google_android_gms_wearable_internal_zzba, GoogleApiClient googleApiClient) {
            this.zzbaJ = com_google_android_gms_wearable_internal_zzba;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzo(this);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbu(status);
        }

        protected GetLocalNodeResult zzbu(Status status) {
            return new zzc(status, null);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzba.2 */
    class C12242 extends zzh<GetConnectedNodesResult> {
        final /* synthetic */ zzba zzbaJ;

        C12242(zzba com_google_android_gms_wearable_internal_zzba, GoogleApiClient googleApiClient) {
            this.zzbaJ = com_google_android_gms_wearable_internal_zzba;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzp(this);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbv(status);
        }

        protected GetConnectedNodesResult zzbv(Status status) {
            return new zzb(status, new ArrayList());
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzba.3 */
    class C12253 extends zzh<Status> {
        final /* synthetic */ zzba zzbaJ;
        final /* synthetic */ NodeListener zzbaK;

        C12253(zzba com_google_android_gms_wearable_internal_zzba, GoogleApiClient googleApiClient, NodeListener nodeListener) {
            this.zzbaJ = com_google_android_gms_wearable_internal_zzba;
            this.zzbaK = nodeListener;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzb(this, this.zzbaK);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    private static final class zza extends zzh<Status> {
        private NodeListener zzbaL;

        private zza(GoogleApiClient googleApiClient, NodeListener nodeListener) {
            super(googleApiClient);
            this.zzbaL = nodeListener;
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzbaL);
            this.zzbaL = null;
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            this.zzbaL = null;
            return status;
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, NodeListener listener) {
        return client.zza(new zza(listener, null));
    }

    public PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.zza(new C12242(this, client));
    }

    public PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.zza(new C12231(this, client));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, NodeListener listener) {
        return client.zza(new C12253(this, client, listener));
    }
}
