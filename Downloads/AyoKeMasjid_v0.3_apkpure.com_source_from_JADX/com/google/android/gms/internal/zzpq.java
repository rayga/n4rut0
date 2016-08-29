package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class zzpq implements Moments {

    private static abstract class zza extends com.google.android.gms.plus.Plus.zza<LoadMomentsResult> {

        /* renamed from: com.google.android.gms.internal.zzpq.zza.1 */
        class C11501 implements LoadMomentsResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ zza zzaLM;

            C11501(zza com_google_android_gms_internal_zzpq_zza, Status status) {
                this.zzaLM = com_google_android_gms_internal_zzpq_zza;
                this.zzQs = status;
            }

            public MomentBuffer getMomentBuffer() {
                return null;
            }

            public String getNextPageToken() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public String getUpdated() {
                return null;
            }

            public void release() {
            }
        }

        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMomentsResult zzaY(Status status) {
            return new C11501(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaY(status);
        }
    }

    private static abstract class zzb extends com.google.android.gms.plus.Plus.zza<Status> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    private static abstract class zzc extends com.google.android.gms.plus.Plus.zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpq.1 */
    class C13871 extends zza {
        final /* synthetic */ zzpq zzaLF;

        C13871(zzpq com_google_android_gms_internal_zzpq, GoogleApiClient googleApiClient) {
            this.zzaLF = com_google_android_gms_internal_zzpq;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzk(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpq.2 */
    class C13882 extends zza {
        final /* synthetic */ zzpq zzaLF;
        final /* synthetic */ String zzaLG;
        final /* synthetic */ Uri zzaLH;
        final /* synthetic */ String zzaLI;
        final /* synthetic */ String zzaLJ;
        final /* synthetic */ int zzauY;

        C13882(zzpq com_google_android_gms_internal_zzpq, GoogleApiClient googleApiClient, int i, String str, Uri uri, String str2, String str3) {
            this.zzaLF = com_google_android_gms_internal_zzpq;
            this.zzauY = i;
            this.zzaLG = str;
            this.zzaLH = uri;
            this.zzaLI = str2;
            this.zzaLJ = str3;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zza(this, this.zzauY, this.zzaLG, this.zzaLH, this.zzaLI, this.zzaLJ);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpq.3 */
    class C13893 extends zzc {
        final /* synthetic */ zzpq zzaLF;
        final /* synthetic */ Moment zzaLK;

        C13893(zzpq com_google_android_gms_internal_zzpq, GoogleApiClient googleApiClient, Moment moment) {
            this.zzaLF = com_google_android_gms_internal_zzpq;
            this.zzaLK = moment;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzaLK);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpq.4 */
    class C13904 extends zzb {
        final /* synthetic */ zzpq zzaLF;
        final /* synthetic */ String zzaLL;

        C13904(zzpq com_google_android_gms_internal_zzpq, GoogleApiClient googleApiClient, String str) {
            this.zzaLF = com_google_android_gms_internal_zzpq;
            this.zzaLL = str;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzej(this.zzaLL);
            zza(Status.zzaaD);
        }
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C13871(this, googleApiClient));
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        return googleApiClient.zza(new C13882(this, googleApiClient, maxResults, pageToken, targetUrl, type, userId));
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, String momentId) {
        return googleApiClient.zzb(new C13904(this, googleApiClient, momentId));
    }

    public PendingResult<Status> write(GoogleApiClient googleApiClient, Moment moment) {
        return googleApiClient.zzb(new C13893(this, googleApiClient, moment));
    }
}
