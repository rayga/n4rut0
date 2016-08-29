package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Request;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.zzk;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class zzjh implements zzk, AppIndexApi {

    @Deprecated
    private static final class zza implements ActionResult {
        private zzjh zzQa;
        private PendingResult<Status> zzQb;
        private Action zzQc;

        zza(zzjh com_google_android_gms_internal_zzjh, PendingResult<Status> pendingResult, Action action) {
            this.zzQa = com_google_android_gms_internal_zzjh;
            this.zzQb = pendingResult;
            this.zzQc = action;
        }

        public PendingResult<Status> end(GoogleApiClient apiClient) {
            String packageName = apiClient.getContext().getPackageName();
            UsageInfo zza = zzjg.zza(this.zzQc, System.currentTimeMillis(), packageName, 2);
            return this.zzQa.zza(apiClient, zza);
        }

        public PendingResult<Status> getPendingResult() {
            return this.zzQb;
        }
    }

    private static final class zzd extends zzje<Status> {
        public zzd(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
        }

        public void zzc(Status status) {
            this.zzPW.zzn(status);
        }
    }

    private static abstract class zzb<T extends Result> extends com.google.android.gms.common.api.zzc.zza<T, zzjf> {
        public zzb(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.appdatasearch.zza.zzOO, googleApiClient);
        }

        protected abstract void zza(zzjc com_google_android_gms_internal_zzjc) throws RemoteException;

        protected final void zza(zzjf com_google_android_gms_internal_zzjf) throws RemoteException {
            zza(com_google_android_gms_internal_zzjf.zzlg());
        }
    }

    private static abstract class zzc<T extends Result> extends zzb<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        protected Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzjh.1 */
    class C13601 extends zzc<Status> {
        final /* synthetic */ String zzPX;
        final /* synthetic */ UsageInfo[] zzPY;
        final /* synthetic */ zzjh zzPZ;

        C13601(zzjh com_google_android_gms_internal_zzjh, GoogleApiClient googleApiClient, String str, UsageInfo[] usageInfoArr) {
            this.zzPZ = com_google_android_gms_internal_zzjh;
            this.zzPX = str;
            this.zzPY = usageInfoArr;
            super(googleApiClient);
        }

        protected void zza(zzjc com_google_android_gms_internal_zzjc) throws RemoteException {
            com_google_android_gms_internal_zzjc.zza(new zzd(this), this.zzPX, this.zzPY);
        }
    }

    public static Intent zza(String str, Uri uri) {
        zzb(str, uri);
        List pathSegments = uri.getPathSegments();
        String str2 = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str2);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath((String) pathSegments.get(i));
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return new Intent("android.intent.action.VIEW", builder.build());
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Action action, int i) {
        String packageName = googleApiClient.getContext().getPackageName();
        return zza(googleApiClient, zzjg.zza(action, System.currentTimeMillis(), packageName, i));
    }

    private static void zzb(String str, Uri uri) {
        if ("android-app".equals(uri.getScheme())) {
            String host = uri.getHost();
            if (str == null || str.equals(host)) {
                List pathSegments = uri.getPathSegments();
                if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                    throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
                }
                return;
            }
            throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
        throw new IllegalArgumentException("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
    }

    public static void zzi(List<AppIndexingLink> list) {
        if (list != null) {
            for (AppIndexingLink appIndexingLink : list) {
                zzb(null, appIndexingLink.appIndexingUrl);
            }
        }
    }

    public ActionResult action(GoogleApiClient apiClient, Action action) {
        return new zza(this, zza(apiClient, action, 1), action);
    }

    public PendingResult<Status> end(GoogleApiClient apiClient, Action action) {
        return zza(apiClient, action, 2);
    }

    public PendingResult<Status> start(GoogleApiClient apiClient, Action action) {
        return zza(apiClient, action, 1);
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Intent viewIntent, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = apiClient.getContext().getPackageName();
        zzi(outLinks);
        return zza(apiClient, new UsageInfo(packageName, viewIntent, title, webUrl, null, outLinks, 1));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = apiClient.getContext().getPackageName();
        zzb(packageName, appIndexingUrl);
        return view(apiClient, activity, zza(packageName, appIndexingUrl), title, webUrl, (List) outLinks);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Intent viewIntent) {
        String packageName = apiClient.getContext().getPackageName();
        return zza(apiClient, new com.google.android.gms.appdatasearch.UsageInfo.zza().zza(UsageInfo.zza(packageName, viewIntent)).zzw(System.currentTimeMillis()).zzam(0).zzan(2).zzlf());
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Uri appUri) {
        return viewEnd(apiClient, activity, zza(apiClient.getContext().getPackageName(), appUri));
    }

    public PendingResult<Response> zza(GoogleApiClient googleApiClient, Request request) {
        return googleApiClient.zza(new com.google.android.gms.appdatasearch.GetRecentContextCall.zza(request, googleApiClient));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, UsageInfo... usageInfoArr) {
        return googleApiClient.zza(new C13601(this, googleApiClient, googleApiClient.getContext().getPackageName(), usageInfoArr));
    }
}
