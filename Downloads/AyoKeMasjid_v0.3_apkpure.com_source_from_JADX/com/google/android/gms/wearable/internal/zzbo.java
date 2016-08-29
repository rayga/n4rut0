package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.zzav.zza;
import com.google.android.gms.wearable.zzc;
import java.util.List;

final class zzbo<T> extends zza {
    private final String zzaZF;
    private final IntentFilter[] zzbal;
    private com.google.android.gms.wearable.zza.zza zzbbg;
    private zzc.zza zzbbh;
    private DataListener zzbbi;
    private MessageListener zzbbj;
    private NodeListener zzbbk;
    private NodeApi.zza zzbbl;
    private ChannelListener zzbbm;
    private CapabilityListener zzbbn;
    private final String zzbbo;

    private zzbo(com.google.android.gms.wearable.zza.zza com_google_android_gms_wearable_zza_zza, zzc.zza com_google_android_gms_wearable_zzc_zza, DataListener dataListener, MessageListener messageListener, NodeListener nodeListener, NodeApi.zza com_google_android_gms_wearable_NodeApi_zza, ChannelListener channelListener, CapabilityListener capabilityListener, IntentFilter[] intentFilterArr, String str, String str2) {
        this.zzbbg = com_google_android_gms_wearable_zza_zza;
        this.zzbbh = com_google_android_gms_wearable_zzc_zza;
        this.zzbbi = dataListener;
        this.zzbbj = messageListener;
        this.zzbbk = nodeListener;
        this.zzbbl = com_google_android_gms_wearable_NodeApi_zza;
        this.zzbbm = channelListener;
        this.zzbbn = capabilityListener;
        this.zzbal = intentFilterArr;
        this.zzbbo = str;
        this.zzaZF = str2;
    }

    public static zzbo<CapabilityListener> zza(CapabilityListener capabilityListener, String str) {
        return new zzbo(null, null, null, null, null, null, null, (CapabilityListener) zzx.zzv(capabilityListener), null, null, str);
    }

    public static zzbo<ChannelListener> zza(ChannelListener channelListener, String str) {
        return new zzbo(null, null, null, null, null, null, (ChannelListener) zzx.zzv(channelListener), null, null, (String) zzx.zzv(str), null);
    }

    public static zzbo<DataListener> zza(DataListener dataListener, IntentFilter[] intentFilterArr) {
        return new zzbo(null, null, (DataListener) zzx.zzv(dataListener), null, null, null, null, null, intentFilterArr, null, null);
    }

    public static zzbo<MessageListener> zza(MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return new zzbo(null, null, null, (MessageListener) zzx.zzv(messageListener), null, null, null, null, intentFilterArr, null, null);
    }

    public static zzbo<NodeListener> zza(NodeListener nodeListener) {
        return new zzbo(null, null, null, null, (NodeListener) zzx.zzv(nodeListener), null, null, null, null, null, null);
    }

    public static zzbo<ChannelListener> zzb(ChannelListener channelListener) {
        return new zzbo(null, null, null, null, null, null, (ChannelListener) zzx.zzv(channelListener), null, null, null, null);
    }

    public void clear() {
        this.zzbbg = null;
        this.zzbbh = null;
        this.zzbbi = null;
        this.zzbbj = null;
        this.zzbbk = null;
        this.zzbbl = null;
        this.zzbbm = null;
        this.zzbbn = null;
    }

    public void onConnectedNodes(List<NodeParcelable> connectedNodes) {
        if (this.zzbbl != null) {
            this.zzbbl.onConnectedNodes(connectedNodes);
        }
    }

    public IntentFilter[] zzCJ() {
        return this.zzbal;
    }

    public String zzCK() {
        return this.zzbbo;
    }

    public String zzCL() {
        return this.zzaZF;
    }

    public void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        if (this.zzbbg != null) {
            this.zzbbg.zza(amsEntityUpdateParcelable);
        }
    }

    public void zza(AncsNotificationParcelable ancsNotificationParcelable) {
        if (this.zzbbh != null) {
            this.zzbbh.zza(ancsNotificationParcelable);
        }
    }

    public void zza(CapabilityInfoParcelable capabilityInfoParcelable) {
        if (this.zzbbn != null) {
            this.zzbbn.onCapabilityChanged(capabilityInfoParcelable);
        }
    }

    public void zza(ChannelEventParcelable channelEventParcelable) {
        if (this.zzbbm != null) {
            channelEventParcelable.zza(this.zzbbm);
        }
    }

    public void zza(MessageEventParcelable messageEventParcelable) {
        if (this.zzbbj != null) {
            this.zzbbj.onMessageReceived(messageEventParcelable);
        }
    }

    public void zza(NodeParcelable nodeParcelable) {
        if (this.zzbbk != null) {
            this.zzbbk.onPeerConnected(nodeParcelable);
        }
    }

    public void zzad(DataHolder dataHolder) {
        if (this.zzbbi != null) {
            try {
                this.zzbbi.onDataChanged(new DataEventBuffer(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            dataHolder.close();
        }
    }

    public void zzb(NodeParcelable nodeParcelable) {
        if (this.zzbbk != null) {
            this.zzbbk.onPeerDisconnected(nodeParcelable);
        }
    }
}
