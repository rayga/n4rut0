package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.Strategy;

class zzg extends zzj<zzd> {
    private String zzQl;
    private String zzaJT;
    private boolean zzaJU;

    private static class zza extends com.google.android.gms.nearby.messages.internal.zzb.zza {
        private final MessageListener zzaJV;

        private zza(MessageListener messageListener) {
            this.zzaJV = messageListener;
        }

        public void zza(MessageWrapper messageWrapper) throws RemoteException {
            this.zzaJV.onFound(messageWrapper.zzaJS);
        }

        public void zzb(MessageWrapper messageWrapper) throws RemoteException {
            this.zzaJV.onLost(messageWrapper.zzaJS);
        }
    }

    zzg(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf, MessagesOptions messagesOptions) {
        super(context, looper, 62, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzQl = com_google_android_gms_common_internal_zzf.zzol();
        if (messagesOptions != null) {
            this.zzaJT = messagesOptions.zzaCr;
            this.zzaJU = messagesOptions.zzaJJ;
        }
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzdk(iBinder);
    }

    void zza(zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, MessageListener messageListener) throws RemoteException {
        zzoz();
        ((zzd) zzoA()).zza(new UnsubscribeRequest(new zza(null), zzj.zzj(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status), null, messageListener.hashCode(), this.zzaJT, this.zzQl));
    }

    void zza(zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, MessageListener messageListener, Strategy strategy, MessageFilter messageFilter) throws RemoteException {
        zzoz();
        ((zzd) zzoA()).zza(new SubscribeRequest(new zza(null), strategy, zzj.zzj(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status), messageFilter, null, messageListener.hashCode(), this.zzaJT, this.zzQl, null, this.zzaJU));
    }

    void zza(zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, MessageWrapper messageWrapper) throws RemoteException {
        zzoz();
        ((zzd) zzoA()).zza(new UnpublishRequest(messageWrapper, zzj.zzj(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status), this.zzaJT, this.zzQl));
    }

    void zza(zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, MessageWrapper messageWrapper, Strategy strategy) throws RemoteException {
        zzoz();
        ((zzd) zzoA()).zza(new PublishRequest(messageWrapper, strategy, zzj.zzj(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status), this.zzaJT, this.zzQl, this.zzaJU));
    }

    protected zzd zzdk(IBinder iBinder) {
        return com.google.android.gms.nearby.messages.internal.zzd.zza.zzdj(iBinder);
    }

    protected String zzfA() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    void zzi(zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        zzoz();
        ((zzd) zzoA()).zza(new GetPermissionStatusRequest(zzj.zzj(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status), this.zzaJT));
    }
}
