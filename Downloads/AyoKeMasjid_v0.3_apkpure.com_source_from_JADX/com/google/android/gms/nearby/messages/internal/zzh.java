package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.Strategy;

public class zzh implements Messages {
    public static final zzc<zzg> zzQf;
    public static final com.google.android.gms.common.api.Api.zza<zzg, MessagesOptions> zzQg;

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzh.1 */
    static class C08191 extends com.google.android.gms.common.api.Api.zza<zzg, MessagesOptions> {
        C08191() {
        }

        public int getPriority() {
            return Strategy.TTL_SECONDS_INFINITE;
        }

        public zzg zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, MessagesOptions messagesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzg(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf, messagesOptions);
        }
    }

    static abstract class zza extends com.google.android.gms.common.api.zzc.zza<Status, zzg> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzh.zzQf, googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzh.2 */
    class C12102 extends zza {
        final /* synthetic */ Message zzaJW;
        final /* synthetic */ Strategy zzaJX;
        final /* synthetic */ zzh zzaJY;

        C12102(zzh com_google_android_gms_nearby_messages_internal_zzh, GoogleApiClient googleApiClient, Message message, Strategy strategy) {
            this.zzaJY = com_google_android_gms_nearby_messages_internal_zzh;
            this.zzaJW = message;
            this.zzaJX = strategy;
            super(googleApiClient);
        }

        protected void zza(zzg com_google_android_gms_nearby_messages_internal_zzg) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzg.zza(this, MessageWrapper.zza(this.zzaJW), this.zzaJX);
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzh.3 */
    class C12113 extends zza {
        final /* synthetic */ Message zzaJW;
        final /* synthetic */ zzh zzaJY;

        C12113(zzh com_google_android_gms_nearby_messages_internal_zzh, GoogleApiClient googleApiClient, Message message) {
            this.zzaJY = com_google_android_gms_nearby_messages_internal_zzh;
            this.zzaJW = message;
            super(googleApiClient);
        }

        protected void zza(zzg com_google_android_gms_nearby_messages_internal_zzg) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzg.zza((zzb) this, MessageWrapper.zza(this.zzaJW));
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzh.4 */
    class C12124 extends zza {
        final /* synthetic */ Strategy zzaJX;
        final /* synthetic */ zzh zzaJY;
        final /* synthetic */ MessageListener zzaJZ;
        final /* synthetic */ MessageFilter zzaKa;

        C12124(zzh com_google_android_gms_nearby_messages_internal_zzh, GoogleApiClient googleApiClient, MessageListener messageListener, Strategy strategy, MessageFilter messageFilter) {
            this.zzaJY = com_google_android_gms_nearby_messages_internal_zzh;
            this.zzaJZ = messageListener;
            this.zzaJX = strategy;
            this.zzaKa = messageFilter;
            super(googleApiClient);
        }

        protected void zza(zzg com_google_android_gms_nearby_messages_internal_zzg) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzg.zza(this, this.zzaJZ, this.zzaJX, this.zzaKa);
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzh.5 */
    class C12135 extends zza {
        final /* synthetic */ zzh zzaJY;
        final /* synthetic */ MessageListener zzaJZ;

        C12135(zzh com_google_android_gms_nearby_messages_internal_zzh, GoogleApiClient googleApiClient, MessageListener messageListener) {
            this.zzaJY = com_google_android_gms_nearby_messages_internal_zzh;
            this.zzaJZ = messageListener;
            super(googleApiClient);
        }

        protected void zza(zzg com_google_android_gms_nearby_messages_internal_zzg) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzg.zza((zzb) this, this.zzaJZ);
        }
    }

    /* renamed from: com.google.android.gms.nearby.messages.internal.zzh.6 */
    class C12146 extends zza {
        final /* synthetic */ zzh zzaJY;

        C12146(zzh com_google_android_gms_nearby_messages_internal_zzh, GoogleApiClient googleApiClient) {
            this.zzaJY = com_google_android_gms_nearby_messages_internal_zzh;
            super(googleApiClient);
        }

        protected void zza(zzg com_google_android_gms_nearby_messages_internal_zzg) throws RemoteException {
            com_google_android_gms_nearby_messages_internal_zzg.zzi(this);
        }
    }

    static {
        zzQf = new zzc();
        zzQg = new C08191();
    }

    public PendingResult<Status> getPermissionStatus(GoogleApiClient client) {
        return client.zzb(new C12146(this, client));
    }

    public PendingResult<Status> publish(GoogleApiClient client, Message message) {
        return publish(client, message, Strategy.DEFAULT);
    }

    public PendingResult<Status> publish(GoogleApiClient client, Message message, Strategy strategy) {
        zzx.zzv(message);
        zzx.zzv(strategy);
        return client.zzb(new C12102(this, client, message, strategy));
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener) {
        return subscribe(client, listener, Strategy.DEFAULT, MessageFilter.INCLUDE_ALL_MY_TYPES);
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, Strategy strategy) {
        return subscribe(client, listener, strategy, MessageFilter.INCLUDE_ALL_MY_TYPES);
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, Strategy strategy, MessageFilter filter) {
        zzx.zzv(listener);
        zzx.zzv(strategy);
        zzx.zzv(filter);
        return client.zzb(new C12124(this, client, listener, strategy, filter));
    }

    public PendingResult<Status> unpublish(GoogleApiClient client, Message message) {
        zzx.zzv(message);
        return client.zzb(new C12113(this, client, message));
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, MessageListener listener) {
        zzx.zzv(listener);
        return client.zzb(new C12135(this, client, listener));
    }
}
