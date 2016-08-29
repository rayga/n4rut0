package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class zzpi implements PanoramaApi {

    /* renamed from: com.google.android.gms.internal.zzpi.3 */
    static class C11493 extends com.google.android.gms.internal.zzpg.zza {
        final /* synthetic */ zzpg zzaKA;
        final /* synthetic */ Uri zzaKy;
        final /* synthetic */ Context zzrn;

        C11493(Context context, Uri uri, zzpg com_google_android_gms_internal_zzpg) {
            this.zzrn = context;
            this.zzaKy = uri;
            this.zzaKA = com_google_android_gms_internal_zzpg;
        }

        public void zza(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
            zzpi.zza(this.zzrn, this.zzaKy);
            this.zzaKA.zza(i, bundle, i2, intent);
        }
    }

    private static final class zzb extends com.google.android.gms.internal.zzpg.zza {
        private final com.google.android.gms.common.api.zzc.zzb<PanoramaResult> zzQz;

        public zzb(com.google.android.gms.common.api.zzc.zzb<PanoramaResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_panorama_PanoramaApi_PanoramaResult) {
            this.zzQz = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_panorama_PanoramaApi_PanoramaResult;
        }

        public void zza(int i, Bundle bundle, int i2, Intent intent) {
            this.zzQz.zzn(new zzpk(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static abstract class zzc<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzpj> {
        protected zzc(GoogleApiClient googleApiClient) {
            super(Panorama.zzQf, googleApiClient);
        }

        protected abstract void zza(Context context, zzph com_google_android_gms_internal_zzph) throws RemoteException;

        protected final void zza(zzpj com_google_android_gms_internal_zzpj) throws RemoteException {
            zza(com_google_android_gms_internal_zzpj.getContext(), (zzph) com_google_android_gms_internal_zzpj.zzoA());
        }
    }

    private static abstract class zza extends zzc<PanoramaResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected PanoramaResult zzaW(Status status) {
            return new zzpk(status, null);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzaW(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpi.1 */
    class C13841 extends zza {
        final /* synthetic */ Uri zzaKy;
        final /* synthetic */ zzpi zzaKz;

        C13841(zzpi com_google_android_gms_internal_zzpi, GoogleApiClient googleApiClient, Uri uri) {
            this.zzaKz = com_google_android_gms_internal_zzpi;
            this.zzaKy = uri;
            super(googleApiClient);
        }

        protected void zza(Context context, zzph com_google_android_gms_internal_zzph) throws RemoteException {
            com_google_android_gms_internal_zzph.zza(new zzb(this), this.zzaKy, null, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpi.2 */
    class C13852 extends zza {
        final /* synthetic */ Uri zzaKy;
        final /* synthetic */ zzpi zzaKz;

        C13852(zzpi com_google_android_gms_internal_zzpi, GoogleApiClient googleApiClient, Uri uri) {
            this.zzaKz = com_google_android_gms_internal_zzpi;
            this.zzaKy = uri;
            super(googleApiClient);
        }

        protected void zza(Context context, zzph com_google_android_gms_internal_zzph) throws RemoteException {
            zzpi.zza(context, com_google_android_gms_internal_zzph, new zzb(this), this.zzaKy, null);
        }
    }

    private static void zza(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    private static void zza(Context context, zzph com_google_android_gms_internal_zzph, zzpg com_google_android_gms_internal_zzpg, Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        try {
            com_google_android_gms_internal_zzph.zza(new C11493(context, uri, com_google_android_gms_internal_zzpg), uri, bundle, true);
        } catch (RemoteException e) {
            zza(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            zza(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, Uri uri) {
        return client.zza(new C13841(this, client, uri));
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, Uri uri) {
        return client.zza(new C13852(this, client, uri));
    }
}
