package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznx;

public final class Address {
    public static final Api<AddressOptions> API;
    static final zzc<zznx> zzQf;
    private static final com.google.android.gms.common.api.Api.zza<zznx, AddressOptions> zzQg;

    /* renamed from: com.google.android.gms.identity.intents.Address.1 */
    static class C07431 extends com.google.android.gms.common.api.Api.zza<zznx, AddressOptions> {
        C07431() {
        }

        public zznx zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new zznx((Activity) context, looper, com_google_android_gms_common_internal_zzf, addressOptions.theme, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    private static abstract class zza extends com.google.android.gms.common.api.zzc.zza<Status, zznx> {
        public zza(GoogleApiClient googleApiClient) {
            super(Address.zzQf, googleApiClient);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address.2 */
    static class C11952 extends zza {
        final /* synthetic */ UserAddressRequest zzaAx;
        final /* synthetic */ int zzaAy;

        C11952(GoogleApiClient googleApiClient, UserAddressRequest userAddressRequest, int i) {
            this.zzaAx = userAddressRequest;
            this.zzaAy = i;
            super(googleApiClient);
        }

        protected void zza(zznx com_google_android_gms_internal_zznx) throws RemoteException {
            com_google_android_gms_internal_zznx.zza(this.zzaAx, this.zzaAy);
            zza(Status.zzaaD);
        }
    }

    static {
        zzQf = new zzc();
        zzQg = new C07431();
        API = new Api("Address.API", zzQg, zzQf);
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, UserAddressRequest request, int requestCode) {
        googleApiClient.zza(new C11952(googleApiClient, request, requestCode));
    }
}
