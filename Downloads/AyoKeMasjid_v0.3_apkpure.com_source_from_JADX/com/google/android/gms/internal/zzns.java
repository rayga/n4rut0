package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

public class zzns implements SessionsApi {

    private static class zza extends com.google.android.gms.internal.zznf.zza {
        private final com.google.android.gms.common.api.zzc.zzb<SessionReadResult> zzQz;

        private zza(com.google.android.gms.common.api.zzc.zzb<SessionReadResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_SessionReadResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_SessionReadResult;
        }

        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.zzQz.zzn(sessionReadResult);
        }
    }

    private static class zzb extends com.google.android.gms.internal.zzng.zza {
        private final com.google.android.gms.common.api.zzc.zzb<SessionStopResult> zzQz;

        private zzb(com.google.android.gms.common.api.zzc.zzb<SessionStopResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_SessionStopResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_fitness_result_SessionStopResult;
        }

        public void zza(SessionStopResult sessionStopResult) {
            this.zzQz.zzn(sessionStopResult);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzns.2 */
    class C12072 extends zza<SessionStopResult> {
        final /* synthetic */ String val$name;
        final /* synthetic */ zzns zzapt;
        final /* synthetic */ String zzapu;

        C12072(zzns com_google_android_gms_internal_zzns, GoogleApiClient googleApiClient, String str, String str2) {
            this.zzapt = com_google_android_gms_internal_zzns;
            this.val$name = str;
            this.zzapu = str2;
            super(googleApiClient);
        }

        protected SessionStopResult zzN(Status status) {
            return SessionStopResult.zzV(status);
        }

        protected void zza(zzmq com_google_android_gms_internal_zzmq) throws RemoteException {
            ((zznb) com_google_android_gms_internal_zzmq.zzoA()).zza(new SessionStopRequest(this.val$name, this.zzapu, new zzb(null), com_google_android_gms_internal_zzmq.getContext().getPackageName()));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzN(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzns.4 */
    class C12084 extends zza<SessionReadResult> {
        final /* synthetic */ zzns zzapt;
        final /* synthetic */ SessionReadRequest zzapw;

        C12084(zzns com_google_android_gms_internal_zzns, GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest) {
            this.zzapt = com_google_android_gms_internal_zzns;
            this.zzapw = sessionReadRequest;
            super(googleApiClient);
        }

        protected SessionReadResult zzO(Status status) {
            return SessionReadResult.zzU(status);
        }

        protected void zza(zzmq com_google_android_gms_internal_zzmq) throws RemoteException {
            ((zznb) com_google_android_gms_internal_zzmq.zzoA()).zza(new SessionReadRequest(this.zzapw, new zza(null), com_google_android_gms_internal_zzmq.getContext().getPackageName()));
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzO(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzns.1 */
    class C13751 extends zzc {
        final /* synthetic */ Session zzaps;
        final /* synthetic */ zzns zzapt;

        C13751(zzns com_google_android_gms_internal_zzns, GoogleApiClient googleApiClient, Session session) {
            this.zzapt = com_google_android_gms_internal_zzns;
            this.zzaps = session;
            super(googleApiClient);
        }

        protected void zza(zzmq com_google_android_gms_internal_zzmq) throws RemoteException {
            ((zznb) com_google_android_gms_internal_zzmq.zzoA()).zza(new SessionStartRequest(this.zzaps, new zznt(this), com_google_android_gms_internal_zzmq.getContext().getPackageName()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzns.3 */
    class C13763 extends zzc {
        final /* synthetic */ zzns zzapt;
        final /* synthetic */ SessionInsertRequest zzapv;

        C13763(zzns com_google_android_gms_internal_zzns, GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest) {
            this.zzapt = com_google_android_gms_internal_zzns;
            this.zzapv = sessionInsertRequest;
            super(googleApiClient);
        }

        protected void zza(zzmq com_google_android_gms_internal_zzmq) throws RemoteException {
            ((zznb) com_google_android_gms_internal_zzmq.zzoA()).zza(new SessionInsertRequest(this.zzapv, new zznt(this), com_google_android_gms_internal_zzmq.getContext().getPackageName()));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzns.5 */
    class C13775 extends zzc {
        final /* synthetic */ PendingIntent zzapm;
        final /* synthetic */ zzns zzapt;
        final /* synthetic */ int zzapx;

        C13775(zzns com_google_android_gms_internal_zzns, GoogleApiClient googleApiClient, PendingIntent pendingIntent, int i) {
            this.zzapt = com_google_android_gms_internal_zzns;
            this.zzapm = pendingIntent;
            this.zzapx = i;
            super(googleApiClient);
        }

        protected void zza(zzmq com_google_android_gms_internal_zzmq) throws RemoteException {
            ((zznb) com_google_android_gms_internal_zzmq.zzoA()).zza(new SessionRegistrationRequest(this.zzapm, new zznt(this), com_google_android_gms_internal_zzmq.getContext().getPackageName(), this.zzapx));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzns.6 */
    class C13786 extends zzc {
        final /* synthetic */ PendingIntent zzapm;
        final /* synthetic */ zzns zzapt;

        C13786(zzns com_google_android_gms_internal_zzns, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
            this.zzapt = com_google_android_gms_internal_zzns;
            this.zzapm = pendingIntent;
            super(googleApiClient);
        }

        protected void zza(zzmq com_google_android_gms_internal_zzmq) throws RemoteException {
            ((zznb) com_google_android_gms_internal_zzmq.zzoA()).zza(new SessionUnregistrationRequest(this.zzapm, new zznt(this), com_google_android_gms_internal_zzmq.getContext().getPackageName()));
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, String str, String str2) {
        return googleApiClient.zzb(new C12072(this, googleApiClient, str, str2));
    }

    public PendingResult<Status> insertSession(GoogleApiClient client, SessionInsertRequest request) {
        return client.zza(new C13763(this, client, request));
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient client, SessionReadRequest request) {
        return client.zza(new C12084(this, client, request));
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient client, PendingIntent intent) {
        return zza(client, intent, 0);
    }

    public PendingResult<Status> startSession(GoogleApiClient client, Session session) {
        zzx.zzb((Object) session, (Object) "Session cannot be null");
        zzx.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
        return client.zzb(new C13751(this, client, session));
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient client, String identifier) {
        return zza(client, null, identifier);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient client, PendingIntent intent) {
        return client.zzb(new C13786(this, client, intent));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, PendingIntent pendingIntent, int i) {
        return googleApiClient.zzb(new C13775(this, googleApiClient, pendingIntent, i));
    }
}
