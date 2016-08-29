package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;

public final class zzk implements ChannelApi {

    static final class zzb implements OpenChannelResult {
        private final Status zzQA;
        private final Channel zzaZO;

        zzb(Status status, Channel channel) {
            this.zzQA = (Status) zzx.zzv(status);
            this.zzaZO = channel;
        }

        public Channel getChannel() {
            return this.zzaZO;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzk.1 */
    class C12301 extends zzh<OpenChannelResult> {
        final /* synthetic */ String zzaZK;
        final /* synthetic */ zzk zzaZL;
        final /* synthetic */ String zzrr;

        C12301(zzk com_google_android_gms_wearable_internal_zzk, GoogleApiClient googleApiClient, String str, String str2) {
            this.zzaZL = com_google_android_gms_wearable_internal_zzk;
            this.zzaZK = str;
            this.zzrr = str2;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zze(this, this.zzaZK, this.zzrr);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzbm(status);
        }

        public OpenChannelResult zzbm(Status status) {
            return new zzb(status, null);
        }
    }

    static final class zza extends zzh<Status> {
        private final String zzaZM;
        private ChannelListener zzaZN;

        zza(GoogleApiClient googleApiClient, ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzaZN = (ChannelListener) zzx.zzv(channelListener);
            this.zzaZM = str;
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzaZN, this.zzaZM);
            this.zzaZN = null;
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            this.zzaZN = null;
            return status;
        }
    }

    static final class zzc extends zzh<Status> {
        private final String zzaZM;
        private ChannelListener zzaZN;

        zzc(GoogleApiClient googleApiClient, ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzaZN = (ChannelListener) zzx.zzv(channelListener);
            this.zzaZM = str;
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzb((com.google.android.gms.common.api.zzc.zzb) this, this.zzaZN, this.zzaZM);
            this.zzaZN = null;
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            this.zzaZN = null;
            return status;
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zza(client, listener, null));
    }

    public PendingResult<OpenChannelResult> openChannel(GoogleApiClient client, String nodeId, String path) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) nodeId, (Object) "nodeId is null");
        zzx.zzb((Object) path, (Object) "path is null");
        return client.zzb(new C12301(this, client, nodeId, path));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zzc(client, listener, null));
    }
}
