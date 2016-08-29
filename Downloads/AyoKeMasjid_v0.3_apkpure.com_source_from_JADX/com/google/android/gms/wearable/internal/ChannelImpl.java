package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR;
    private final String mPath;
    final int mVersionCode;
    private final String zzaYR;
    private final String zzaZM;

    static final class zza implements GetInputStreamResult {
        private final Status zzQA;
        private final InputStream zzaZW;

        zza(Status status, InputStream inputStream) {
            this.zzQA = (Status) zzx.zzv(status);
            this.zzaZW = inputStream;
        }

        public InputStream getInputStream() {
            return this.zzaZW;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzaZW != null) {
                try {
                    this.zzaZW.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static final class zzb implements GetOutputStreamResult {
        private final Status zzQA;
        private final OutputStream zzaZX;

        zzb(Status status, OutputStream outputStream) {
            this.zzQA = (Status) zzx.zzv(status);
            this.zzaZX = outputStream;
        }

        public OutputStream getOutputStream() {
            return this.zzaZX;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzaZX != null) {
                try {
                    this.zzaZX.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.1 */
    class C12151 extends zzh<Status> {
        final /* synthetic */ ChannelImpl zzaZS;

        C12151(ChannelImpl channelImpl, GoogleApiClient googleApiClient) {
            this.zzaZS = channelImpl;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzt(this, this.zzaZS.zzaZM);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.2 */
    class C12162 extends zzh<Status> {
        final /* synthetic */ ChannelImpl zzaZS;
        final /* synthetic */ int zzamY;

        C12162(ChannelImpl channelImpl, GoogleApiClient googleApiClient, int i) {
            this.zzaZS = channelImpl;
            this.zzamY = i;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzh(this, this.zzaZS.zzaZM, this.zzamY);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.3 */
    class C12173 extends zzh<GetInputStreamResult> {
        final /* synthetic */ ChannelImpl zzaZS;

        C12173(ChannelImpl channelImpl, GoogleApiClient googleApiClient) {
            this.zzaZS = channelImpl;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzu(this, this.zzaZS.zzaZM);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzbn(status);
        }

        public GetInputStreamResult zzbn(Status status) {
            return new zza(status, null);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.4 */
    class C12184 extends zzh<GetOutputStreamResult> {
        final /* synthetic */ ChannelImpl zzaZS;

        C12184(ChannelImpl channelImpl, GoogleApiClient googleApiClient) {
            this.zzaZS = channelImpl;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzv(this, this.zzaZS.zzaZM);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzbo(status);
        }

        public GetOutputStreamResult zzbo(Status status) {
            return new zzb(status, null);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.5 */
    class C12195 extends zzh<Status> {
        final /* synthetic */ Uri zzaKy;
        final /* synthetic */ ChannelImpl zzaZS;
        final /* synthetic */ boolean zzaZT;

        C12195(ChannelImpl channelImpl, GoogleApiClient googleApiClient, Uri uri, boolean z) {
            this.zzaZS = channelImpl;
            this.zzaKy = uri;
            this.zzaZT = z;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzaZS.zzaZM, this.zzaKy, this.zzaZT);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.ChannelImpl.6 */
    class C12206 extends zzh<Status> {
        final /* synthetic */ Uri zzaKy;
        final /* synthetic */ ChannelImpl zzaZS;
        final /* synthetic */ long zzaZU;
        final /* synthetic */ long zzaZV;

        C12206(ChannelImpl channelImpl, GoogleApiClient googleApiClient, Uri uri, long j, long j2) {
            this.zzaZS = channelImpl;
            this.zzaKy = uri;
            this.zzaZU = j;
            this.zzaZV = j2;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza(this, this.zzaZS.zzaZM, this.zzaKy, this.zzaZU, this.zzaZV);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    static {
        CREATOR = new zzn();
    }

    ChannelImpl(int versionCode, String token, String nodeId, String path) {
        this.mVersionCode = versionCode;
        this.zzaZM = (String) zzx.zzv(token);
        this.zzaYR = (String) zzx.zzv(nodeId);
        this.mPath = (String) zzx.zzv(path);
    }

    public PendingResult<Status> addListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zza(client, listener, this.zzaZM));
    }

    public PendingResult<Status> close(GoogleApiClient client) {
        return client.zzb(new C12151(this, client));
    }

    public PendingResult<Status> close(GoogleApiClient client, int errorCode) {
        return client.zzb(new C12162(this, client, errorCode));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) other;
        return this.zzaZM.equals(channelImpl.zzaZM) && zzw.equal(channelImpl.zzaYR, this.zzaYR) && zzw.equal(channelImpl.mPath, this.mPath) && channelImpl.mVersionCode == this.mVersionCode;
    }

    public PendingResult<GetInputStreamResult> getInputStream(GoogleApiClient client) {
        return client.zzb(new C12173(this, client));
    }

    public String getNodeId() {
        return this.zzaYR;
    }

    public PendingResult<GetOutputStreamResult> getOutputStream(GoogleApiClient client) {
        return client.zzb(new C12184(this, client));
    }

    public String getPath() {
        return this.mPath;
    }

    public String getToken() {
        return this.zzaZM;
    }

    public int hashCode() {
        return this.zzaZM.hashCode();
    }

    public PendingResult<Status> receiveFile(GoogleApiClient client, Uri uri, boolean append) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) uri, (Object) "uri is null");
        return client.zzb(new C12195(this, client, uri, append));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb((Object) listener, (Object) "listener is null");
        return client.zza(new zzc(client, listener, this.zzaZM));
    }

    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri) {
        return sendFile(client, uri, 0, -1);
    }

    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri, long startOffset, long length) {
        zzx.zzb((Object) client, (Object) "client is null");
        zzx.zzb(this.zzaZM, (Object) "token is null");
        zzx.zzb((Object) uri, (Object) "uri is null");
        zzx.zzb(startOffset >= 0, "startOffset is negative: %s", Long.valueOf(startOffset));
        boolean z = length >= 0 || length == -1;
        zzx.zzb(z, "invalid length: %s", Long.valueOf(length));
        return client.zzb(new C12206(this, client, uri, startOffset, length));
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.zzaZM + '\'' + ", nodeId='" + this.zzaYR + '\'' + ", path='" + this.mPath + '\'' + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }
}
