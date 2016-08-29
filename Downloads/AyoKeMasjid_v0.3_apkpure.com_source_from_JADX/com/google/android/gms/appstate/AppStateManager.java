package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjn;
import java.util.Arrays;
import java.util.List;

@Deprecated
public final class AppStateManager {
    public static final Api<NoOptions> API;
    public static final Scope SCOPE_APP_STATE;
    static final com.google.android.gms.common.api.Api.zzc<zzjn> zzQf;
    private static final com.google.android.gms.common.api.Api.zza<zzjn, NoOptions> zzQg;

    /* renamed from: com.google.android.gms.appstate.AppStateManager.1 */
    static class C06921 extends com.google.android.gms.common.api.Api.zza<zzjn, NoOptions> {
        C06921() {
        }

        public /* synthetic */ com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzc(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public List<Scope> zza(NoOptions noOptions) {
            return Arrays.asList(new Scope[]{AppStateManager.SCOPE_APP_STATE});
        }

        public zzjn zzc(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjn(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }

        public /* synthetic */ List zzl(Object obj) {
            return zza((NoOptions) obj);
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.2 */
    static class C09062 implements StateResult {
        final /* synthetic */ Status zzQs;

        C09062(Status status) {
            this.zzQs = status;
        }

        public StateConflictResult getConflictResult() {
            return null;
        }

        public StateLoadedResult getLoadedResult() {
            return null;
        }

        public Status getStatus() {
            return this.zzQs;
        }

        public void release() {
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzjn> {
        public zza(GoogleApiClient googleApiClient) {
            super(AppStateManager.zzQf, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<StateDeletedResult> {
        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }
    }

    private static abstract class zzc extends zza<StateListResult> {

        /* renamed from: com.google.android.gms.appstate.AppStateManager.zzc.1 */
        class C09081 implements StateListResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ zzc zzQy;

            C09081(zzc com_google_android_gms_appstate_AppStateManager_zzc, Status status) {
                this.zzQy = com_google_android_gms_appstate_AppStateManager_zzc;
                this.zzQs = status;
            }

            public AppStateBuffer getStateBuffer() {
                return new AppStateBuffer(null);
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzi(status);
        }

        public StateListResult zzi(Status status) {
            return new C09081(this, status);
        }
    }

    private static abstract class zzd extends zza<Status> {
        public zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    private static abstract class zze extends zza<StateResult> {
        public zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzj(status);
        }

        public StateResult zzj(Status status) {
            return AppStateManager.zzf(status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.3 */
    static class C12393 extends zze {
        final /* synthetic */ int zzQt;
        final /* synthetic */ byte[] zzQu;

        C12393(GoogleApiClient googleApiClient, int i, byte[] bArr) {
            this.zzQt = i;
            this.zzQu = bArr;
            super(googleApiClient);
        }

        protected void zza(zzjn com_google_android_gms_internal_zzjn) throws RemoteException {
            com_google_android_gms_internal_zzjn.zza(null, this.zzQt, this.zzQu);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.4 */
    static class C12404 extends zze {
        final /* synthetic */ int zzQt;
        final /* synthetic */ byte[] zzQu;

        C12404(GoogleApiClient googleApiClient, int i, byte[] bArr) {
            this.zzQt = i;
            this.zzQu = bArr;
            super(googleApiClient);
        }

        protected void zza(zzjn com_google_android_gms_internal_zzjn) throws RemoteException {
            com_google_android_gms_internal_zzjn.zza(this, this.zzQt, this.zzQu);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.5 */
    static class C12415 extends zzb {
        final /* synthetic */ int zzQt;

        /* renamed from: com.google.android.gms.appstate.AppStateManager.5.1 */
        class C09071 implements StateDeletedResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ C12415 zzQv;

            C09071(C12415 c12415, Status status) {
                this.zzQv = c12415;
                this.zzQs = status;
            }

            public int getStateKey() {
                return this.zzQv.zzQt;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        C12415(GoogleApiClient googleApiClient, int i) {
            this.zzQt = i;
            super(googleApiClient);
        }

        protected void zza(zzjn com_google_android_gms_internal_zzjn) throws RemoteException {
            com_google_android_gms_internal_zzjn.zza(this, this.zzQt);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzh(status);
        }

        public StateDeletedResult zzh(Status status) {
            return new C09071(this, status);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.6 */
    static class C12426 extends zze {
        final /* synthetic */ int zzQt;

        C12426(GoogleApiClient googleApiClient, int i) {
            this.zzQt = i;
            super(googleApiClient);
        }

        protected void zza(zzjn com_google_android_gms_internal_zzjn) throws RemoteException {
            com_google_android_gms_internal_zzjn.zzb(this, this.zzQt);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.7 */
    static class C12437 extends zzc {
        C12437(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(zzjn com_google_android_gms_internal_zzjn) throws RemoteException {
            com_google_android_gms_internal_zzjn.zza((com.google.android.gms.common.api.zzc.zzb) this);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.8 */
    static class C12448 extends zze {
        final /* synthetic */ int zzQt;
        final /* synthetic */ String zzQw;
        final /* synthetic */ byte[] zzQx;

        C12448(GoogleApiClient googleApiClient, int i, String str, byte[] bArr) {
            this.zzQt = i;
            this.zzQw = str;
            this.zzQx = bArr;
            super(googleApiClient);
        }

        protected void zza(zzjn com_google_android_gms_internal_zzjn) throws RemoteException {
            com_google_android_gms_internal_zzjn.zza(this, this.zzQt, this.zzQw, this.zzQx);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager.9 */
    static class C12459 extends zzd {
        C12459(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(zzjn com_google_android_gms_internal_zzjn) throws RemoteException {
            com_google_android_gms_internal_zzjn.zzb(this);
        }
    }

    static {
        zzQf = new com.google.android.gms.common.api.Api.zzc();
        zzQg = new C06921();
        SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
        API = new Api("AppStateManager.API", zzQg, zzQf);
    }

    private AppStateManager() {
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, int stateKey) {
        return googleApiClient.zzb(new C12415(googleApiClient, stateKey));
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return zza(googleApiClient).zzlo();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return zza(googleApiClient).zzln();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C12437(googleApiClient));
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, int stateKey) {
        return googleApiClient.zza(new C12426(googleApiClient, stateKey));
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, int stateKey, String resolvedVersion, byte[] resolvedData) {
        return googleApiClient.zzb(new C12448(googleApiClient, stateKey, resolvedVersion, resolvedData));
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new C12459(googleApiClient));
    }

    public static void update(GoogleApiClient googleApiClient, int stateKey, byte[] data) {
        googleApiClient.zzb(new C12393(googleApiClient, stateKey, data));
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, int stateKey, byte[] data) {
        return googleApiClient.zzb(new C12404(googleApiClient, stateKey, data));
    }

    public static zzjn zza(GoogleApiClient googleApiClient) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return (zzjn) googleApiClient.zza(zzQf);
    }

    private static StateResult zzf(Status status) {
        return new C09062(status);
    }
}
