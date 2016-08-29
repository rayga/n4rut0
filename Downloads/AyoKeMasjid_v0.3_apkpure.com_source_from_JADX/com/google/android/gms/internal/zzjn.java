package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.GamesStatusCodes;
import java.util.Set;

public final class zzjn extends zzj<zzjp> {

    private static final class zzb implements StateDeletedResult {
        private final Status zzQA;
        private final int zzQB;

        public zzb(Status status, int i) {
            this.zzQA = status;
            this.zzQB = i;
        }

        public int getStateKey() {
            return this.zzQB;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static final class zzd extends com.google.android.gms.common.api.zze implements StateListResult {
        private final AppStateBuffer zzQC;

        public zzd(DataHolder dataHolder) {
            super(dataHolder);
            this.zzQC = new AppStateBuffer(dataHolder);
        }

        public AppStateBuffer getStateBuffer() {
            return this.zzQC;
        }
    }

    private static final class zzf extends com.google.android.gms.common.api.zze implements StateConflictResult, StateLoadedResult, StateResult {
        private final int zzQB;
        private final AppStateBuffer zzQC;

        public zzf(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.zzQB = i;
            this.zzQC = new AppStateBuffer(dataHolder);
        }

        private boolean zzlp() {
            return this.zzQA.getStatusCode() == GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS;
        }

        public StateConflictResult getConflictResult() {
            return zzlp() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return zzlp() ? null : this;
        }

        public byte[] getLocalData() {
            return this.zzQC.getCount() == 0 ? null : this.zzQC.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.zzQC.getCount() == 0 ? null : this.zzQC.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.zzQC.getCount() == 0 ? null : this.zzQC.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.zzQB;
        }

        public void release() {
            this.zzQC.release();
        }
    }

    private static final class zza extends zzjm {
        private final com.google.android.gms.common.api.zzc.zzb<StateDeletedResult> zzQz;

        public zza(com.google.android.gms.common.api.zzc.zzb<StateDeletedResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateDeletedResult) {
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateDeletedResult, (Object) "Result holder must not be null");
        }

        public void zzg(int i, int i2) {
            this.zzQz.zzn(new zzb(new Status(i), i2));
        }
    }

    private static final class zzc extends zzjm {
        private final com.google.android.gms.common.api.zzc.zzb<StateListResult> zzQz;

        public zzc(com.google.android.gms.common.api.zzc.zzb<StateListResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateListResult) {
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateListResult, (Object) "Result holder must not be null");
        }

        public void zza(DataHolder dataHolder) {
            this.zzQz.zzn(new zzd(dataHolder));
        }
    }

    private static final class zze extends zzjm {
        private final com.google.android.gms.common.api.zzc.zzb<StateResult> zzQz;

        public zze(com.google.android.gms.common.api.zzc.zzb<StateResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateResult) {
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateResult, (Object) "Result holder must not be null");
        }

        public void zza(int i, DataHolder dataHolder) {
            this.zzQz.zzn(new zzf(i, dataHolder));
        }
    }

    private static final class zzg extends zzjm {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzQz;

        public zzg(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzb((Object) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, (Object) "Holder must not be null");
        }

        public void zzll() {
            this.zzQz.zzn(new Status(0));
        }
    }

    public zzjn(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 7, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzal(iBinder);
    }

    protected Set<Scope> zza(Set<Scope> set) {
        zzx.zza(set.contains(new Scope(Scopes.APP_STATE)), String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
        return set;
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<StateListResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateListResult) throws RemoteException {
        ((zzjp) zzoA()).zza(new zzc(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateListResult));
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<StateDeletedResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateDeletedResult, int i) throws RemoteException {
        ((zzjp) zzoA()).zzb(new zza(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateDeletedResult), i);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<StateResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateResult, int i, String str, byte[] bArr) throws RemoteException {
        ((zzjp) zzoA()).zza(new zze(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateResult), i, str, bArr);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<StateResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateResult, int i, byte[] bArr) throws RemoteException {
        zzjo com_google_android_gms_internal_zzjo;
        if (com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateResult == null) {
            com_google_android_gms_internal_zzjo = null;
        } else {
            Object com_google_android_gms_internal_zzjn_zze = new zze(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateResult);
        }
        ((zzjp) zzoA()).zza(com_google_android_gms_internal_zzjo, i, bArr);
    }

    protected zzjp zzal(IBinder iBinder) {
        return com.google.android.gms.internal.zzjp.zza.zzan(iBinder);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        ((zzjp) zzoA()).zzb(new zzg(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status));
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb<StateResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateResult, int i) throws RemoteException {
        ((zzjp) zzoA()).zza(new zze(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_appstate_AppStateManager_StateResult), i);
    }

    protected String zzfA() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public boolean zzlm() {
        return true;
    }

    public int zzln() {
        try {
            return ((zzjp) zzoA()).zzln();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int zzlo() {
        try {
            return ((zzjp) zzoA()).zzlo();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }
}
