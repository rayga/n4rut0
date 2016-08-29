package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.drive.internal.zzab;
import com.google.android.gms.drive.internal.zzr;
import com.google.android.gms.drive.internal.zzt;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.internal.zzz;

public final class Drive {
    public static final Api<NoOptions> API;
    public static final DriveApi DriveApi;
    public static final DrivePreferencesApi DrivePreferencesApi;
    public static final Scope SCOPE_APPFOLDER;
    public static final Scope SCOPE_FILE;
    public static final zzc<zzt> zzQf;
    public static final zzc zzagA;
    public static final zzf zzagB;
    public static final Scope zzagx;
    public static final Scope zzagy;
    public static final Api<zzb> zzagz;

    public static abstract class zza<O extends ApiOptions> extends com.google.android.gms.common.api.Api.zza<zzt, O> {
        protected abstract Bundle zza(O o);

        public zzt zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzt(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener, zza(o));
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive.1 */
    static class C10941 extends zza<NoOptions> {
        C10941() {
        }

        protected /* synthetic */ Bundle zza(ApiOptions apiOptions) {
            return zzb((NoOptions) apiOptions);
        }

        protected Bundle zzb(NoOptions noOptions) {
            return new Bundle();
        }
    }

    /* renamed from: com.google.android.gms.drive.Drive.2 */
    static class C10952 extends zza<zzb> {
        C10952() {
        }

        protected Bundle zza(zzb com_google_android_gms_drive_Drive_zzb) {
            return com_google_android_gms_drive_Drive_zzb == null ? new Bundle() : com_google_android_gms_drive_Drive_zzb.zzqg();
        }
    }

    public static class zzb implements Optional {
        private final Bundle zzQe;

        private zzb() {
            this(new Bundle());
        }

        private zzb(Bundle bundle) {
            this.zzQe = bundle;
        }

        public Bundle zzqg() {
            return this.zzQe;
        }
    }

    static {
        zzQf = new zzc();
        SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
        SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
        zzagx = new Scope("https://www.googleapis.com/auth/drive");
        zzagy = new Scope("https://www.googleapis.com/auth/drive.apps");
        API = new Api("Drive.API", new C10941(), zzQf);
        zzagz = new Api("Drive.INTERNAL_API", new C10952(), zzQf);
        DriveApi = new zzr();
        zzagA = new zzw();
        zzagB = new zzab();
        DrivePreferencesApi = new zzz();
    }

    private Drive() {
    }
}
