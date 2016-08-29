package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;

public class zzka implements ProxyApi {

    /* renamed from: com.google.android.gms.internal.zzka.1 */
    class C11961 extends zzjz {
        final /* synthetic */ ProxyRequest zzRK;
        final /* synthetic */ zzka zzRL;

        /* renamed from: com.google.android.gms.internal.zzka.1.1 */
        class C11791 extends zzjv {
            final /* synthetic */ C11961 zzRM;

            C11791(C11961 c11961) {
                this.zzRM = c11961;
            }

            public void zza(ProxyResponse proxyResponse) {
                this.zzRM.zza(new zzkb(proxyResponse));
            }
        }

        C11961(zzka com_google_android_gms_internal_zzka, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
            this.zzRL = com_google_android_gms_internal_zzka;
            this.zzRK = proxyRequest;
            super(googleApiClient);
        }

        protected void zza(Context context, zzjy com_google_android_gms_internal_zzjy) throws RemoteException {
            com_google_android_gms_internal_zzjy.zza(new C11791(this), this.zzRK);
        }
    }

    public PendingResult<ProxyResult> performProxyRequest(GoogleApiClient client, ProxyRequest request) {
        zzx.zzv(client);
        zzx.zzv(request);
        return client.zzb(new C11961(this, client, request));
    }
}
