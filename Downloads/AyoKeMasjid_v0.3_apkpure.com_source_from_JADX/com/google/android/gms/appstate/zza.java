package com.google.android.gms.appstate;

import com.google.android.gms.common.internal.zzw;

public final class zza implements AppState {
    private final int zzQm;
    private final String zzQn;
    private final byte[] zzQo;
    private final boolean zzQp;
    private final String zzQq;
    private final byte[] zzQr;

    public zza(AppState appState) {
        this.zzQm = appState.getKey();
        this.zzQn = appState.getLocalVersion();
        this.zzQo = appState.getLocalData();
        this.zzQp = appState.hasConflict();
        this.zzQq = appState.getConflictVersion();
        this.zzQr = appState.getConflictData();
    }

    static int zza(AppState appState) {
        return zzw.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    static boolean zza(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return zzw.equal(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && zzw.equal(appState2.getLocalVersion(), appState.getLocalVersion()) && zzw.equal(appState2.getLocalData(), appState.getLocalData()) && zzw.equal(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && zzw.equal(appState2.getConflictVersion(), appState.getConflictVersion()) && zzw.equal(appState2.getConflictData(), appState.getConflictData());
    }

    static String zzb(AppState appState) {
        return zzw.zzu(appState).zzg("Key", Integer.valueOf(appState.getKey())).zzg("LocalVersion", appState.getLocalVersion()).zzg("LocalData", appState.getLocalData()).zzg("HasConflict", Boolean.valueOf(appState.hasConflict())).zzg("ConflictVersion", appState.getConflictVersion()).zzg("ConflictData", appState.getConflictData()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzlk();
    }

    public byte[] getConflictData() {
        return this.zzQr;
    }

    public String getConflictVersion() {
        return this.zzQq;
    }

    public int getKey() {
        return this.zzQm;
    }

    public byte[] getLocalData() {
        return this.zzQo;
    }

    public String getLocalVersion() {
        return this.zzQn;
    }

    public boolean hasConflict() {
        return this.zzQp;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public AppState zzlk() {
        return this;
    }
}
