package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zze.zza;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding {
    private final zzd zzaHk;

    public IndoorBuilding(zzd delegate) {
        this.zzaHk = (zzd) zzx.zzv(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.zzaHk.zzb(((IndoorBuilding) other).zzaHk);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getActiveLevelIndex() {
        try {
            return this.zzaHk.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.zzaHk.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            List<IBinder> levels = this.zzaHk.getLevels();
            List<IndoorLevel> arrayList = new ArrayList(levels.size());
            for (IBinder zzcS : levels) {
                arrayList.add(new IndoorLevel(zza.zzcS(zzcS)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.zzaHk.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUnderground() {
        try {
            return this.zzaHk.isUnderground();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
