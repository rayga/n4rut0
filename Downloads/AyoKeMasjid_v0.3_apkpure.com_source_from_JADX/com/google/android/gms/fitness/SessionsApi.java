package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;

public interface SessionsApi {

    public static class ViewIntentBuilder {
        private final Context mContext;
        private String zzano;
        private Session zzanp;
        private boolean zzanq;

        public ViewIntentBuilder(Context context) {
            this.zzanq = false;
            this.mContext = context;
        }

        private Intent zzj(Intent intent) {
            if (this.zzano == null) {
                return intent;
            }
            Intent intent2 = new Intent(intent).setPackage(this.zzano);
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent2, 0);
            if (resolveActivity == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.zzano, resolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            zzx.zza(this.zzanp != null, (Object) "Session must be set");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(Session.getMimeType(this.zzanp.getActivity()));
            zzc.zza(this.zzanp, intent, Session.EXTRA_SESSION);
            if (!this.zzanq) {
                this.zzano = this.zzanp.getAppPackageName();
            }
            return zzj(intent);
        }

        public ViewIntentBuilder setPreferredApplication(String packageName) {
            this.zzano = packageName;
            this.zzanq = true;
            return this;
        }

        public ViewIntentBuilder setSession(Session session) {
            this.zzanp = session;
            return this;
        }
    }

    PendingResult<Status> insertSession(GoogleApiClient googleApiClient, SessionInsertRequest sessionInsertRequest);

    PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, SessionReadRequest sessionReadRequest);

    PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> startSession(GoogleApiClient googleApiClient, Session session);

    PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str);

    PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent);
}
