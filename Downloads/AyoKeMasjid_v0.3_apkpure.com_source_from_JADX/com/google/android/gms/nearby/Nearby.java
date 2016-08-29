package com.google.android.gms.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.nearby.bootstrap.zza;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzh;
import com.google.android.gms.nearby.messages.internal.zzi;
import com.google.android.gms.nearby.messages.zzc;
import com.google.android.gms.nearby.sharing.zzd;
import com.google.android.gms.nearby.sharing.zze;

public final class Nearby {
    public static final Api<NoOptions> CONNECTIONS_API;
    public static final Connections Connections;
    public static final Api<MessagesOptions> MESSAGES_API;
    public static final Messages Messages;
    public static final zzc zzaIT;
    public static final Api<NoOptions> zzaIU;
    public static final zzd zzaIV;
    public static final zze zzaIW;
    public static final Api<NoOptions> zzaIX;
    public static final zza zzaIY;

    static {
        CONNECTIONS_API = new Api("Nearby.CONNECTIONS_API", zzpd.zzQg, zzpd.zzQf);
        Connections = new zzpd();
        MESSAGES_API = new Api("Nearby.MESSAGES_API", zzh.zzQg, zzh.zzQf);
        Messages = new zzh();
        zzaIT = new zzi();
        zzaIU = new Api("Nearby.SHARING_API", com.google.android.gms.nearby.sharing.internal.zzh.zzQg, com.google.android.gms.nearby.sharing.internal.zzh.zzQf);
        zzaIV = new com.google.android.gms.nearby.sharing.internal.zzh();
        zzaIW = new com.google.android.gms.nearby.sharing.internal.zzi();
        zzaIX = new Api("Nearby.BOOTSTRAP_API", zzov.zzQg, zzov.zzQf);
        zzaIY = new zzov();
    }

    private Nearby() {
    }
}
