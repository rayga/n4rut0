package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.zzpe.zza;
import com.google.android.gms.nearby.connection.AppMetadata;

public abstract class zzpb extends zza {
    public void onConnectionRequest(String remoteEndpointId, String remoteDeviceId, String remoteEndpointName, byte[] payload) throws RemoteException {
    }

    public void onDisconnected(String remoteEndpointId) throws RemoteException {
    }

    public void onEndpointFound(String endpointId, String deviceId, String applicationId, String name) throws RemoteException {
    }

    public void onEndpointLost(String endpointId) throws RemoteException {
    }

    public void onMessageReceived(String remoteEndpointId, byte[] payload, boolean isReliable) throws RemoteException {
    }

    public void zza(String str, int i, byte[] bArr) throws RemoteException {
    }

    public void zza(String str, String str2, String str3, String str4, AppMetadata appMetadata) throws RemoteException {
    }

    public void zzeb(String str) throws RemoteException {
    }

    public void zzif(int i) throws RemoteException {
    }

    public void zzig(int i) throws RemoteException {
    }

    public void zzih(int i) throws RemoteException {
    }

    public void zzii(int i) throws RemoteException {
    }

    public void zzij(int i) throws RemoteException {
    }

    public void zzk(int i, String str) throws RemoteException {
    }
}
