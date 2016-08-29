package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class zzpr implements People {

    private static abstract class zza extends com.google.android.gms.plus.Plus.zza<LoadPeopleResult> {

        /* renamed from: com.google.android.gms.internal.zzpr.zza.1 */
        class C11511 implements LoadPeopleResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ zza zzaLR;

            C11511(zza com_google_android_gms_internal_zzpr_zza, Status status) {
                this.zzaLR = com_google_android_gms_internal_zzpr_zza;
                this.zzQs = status;
            }

            public String getNextPageToken() {
                return null;
            }

            public PersonBuffer getPersonBuffer() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }

            public void release() {
            }
        }

        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPeopleResult zzaZ(Status status) {
            return new C11511(this, status);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzaZ(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpr.1 */
    class C13911 extends zza {
        final /* synthetic */ String zzaLG;
        final /* synthetic */ int zzaLN;
        final /* synthetic */ zzpr zzaLO;

        C13911(zzpr com_google_android_gms_internal_zzpr, GoogleApiClient googleApiClient, int i, String str) {
            this.zzaLO = com_google_android_gms_internal_zzpr;
            this.zzaLN = i;
            this.zzaLG = str;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            zza(com_google_android_gms_plus_internal_zze.zza(this, this.zzaLN, this.zzaLG));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpr.2 */
    class C13922 extends zza {
        final /* synthetic */ String zzaLG;
        final /* synthetic */ zzpr zzaLO;

        C13922(zzpr com_google_android_gms_internal_zzpr, GoogleApiClient googleApiClient, String str) {
            this.zzaLO = com_google_android_gms_internal_zzpr;
            this.zzaLG = str;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            zza(com_google_android_gms_plus_internal_zze.zzq(this, this.zzaLG));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpr.3 */
    class C13933 extends zza {
        final /* synthetic */ zzpr zzaLO;

        C13933(zzpr com_google_android_gms_internal_zzpr, GoogleApiClient googleApiClient) {
            this.zzaLO = com_google_android_gms_internal_zzpr;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzl(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpr.4 */
    class C13944 extends zza {
        final /* synthetic */ zzpr zzaLO;
        final /* synthetic */ Collection zzaLP;

        C13944(zzpr com_google_android_gms_internal_zzpr, GoogleApiClient googleApiClient, Collection collection) {
            this.zzaLO = com_google_android_gms_internal_zzpr;
            this.zzaLP = collection;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zza((zzb) this, this.zzaLP);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzpr.5 */
    class C13955 extends zza {
        final /* synthetic */ zzpr zzaLO;
        final /* synthetic */ String[] zzaLQ;

        C13955(zzpr com_google_android_gms_internal_zzpr, GoogleApiClient googleApiClient, String[] strArr) {
            this.zzaLO = com_google_android_gms_internal_zzpr;
            this.zzaLQ = strArr;
            super(null);
        }

        protected void zza(zze com_google_android_gms_plus_internal_zze) {
            com_google_android_gms_plus_internal_zze.zzd(this, this.zzaLQ);
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.zzf(googleApiClient, true).zzyI();
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, Collection<String> personIds) {
        return googleApiClient.zza(new C13944(this, googleApiClient, personIds));
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, String... personIds) {
        return googleApiClient.zza(new C13955(this, googleApiClient, personIds));
    }

    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C13933(this, googleApiClient));
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, int orderBy, String pageToken) {
        return googleApiClient.zza(new C13911(this, googleApiClient, orderBy, pageToken));
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, String pageToken) {
        return googleApiClient.zza(new C13922(this, googleApiClient, pageToken));
    }
}
