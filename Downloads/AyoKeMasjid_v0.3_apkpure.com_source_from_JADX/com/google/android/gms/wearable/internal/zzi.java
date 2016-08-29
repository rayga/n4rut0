package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Map;
import java.util.Set;

public class zzi implements CapabilityApi {

    public static class zzc implements CapabilityInfo {
        private final String mName;
        private final Set<Node> zzaZG;

        public zzc(CapabilityInfo capabilityInfo) {
            this(capabilityInfo.getName(), capabilityInfo.getNodes());
        }

        public zzc(String str, Set<Node> set) {
            this.mName = str;
            this.zzaZG = set;
        }

        public String getName() {
            return this.mName;
        }

        public Set<Node> getNodes() {
            return this.zzaZG;
        }
    }

    public static class zzb implements AddLocalCapabilityResult, RemoveLocalCapabilityResult {
        private final Status zzQA;

        public zzb(Status status) {
            this.zzQA = status;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public static class zzd implements GetAllCapabilitiesResult {
        private final Status zzQA;
        private final Map<String, CapabilityInfo> zzaZH;

        public zzd(Status status, Map<String, CapabilityInfo> map) {
            this.zzQA = status;
            this.zzaZH = map;
        }

        public Map<String, CapabilityInfo> getAllCapabilities() {
            return this.zzaZH;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public static class zze implements GetCapabilityResult {
        private final Status zzQA;
        private final CapabilityInfo zzaZI;

        public zze(Status status, CapabilityInfo capabilityInfo) {
            this.zzQA = status;
            this.zzaZI = capabilityInfo;
        }

        public CapabilityInfo getCapability() {
            return this.zzaZI;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzi.1 */
    class C12261 extends zzh<GetCapabilityResult> {
        final /* synthetic */ String zzaZB;
        final /* synthetic */ int zzaZC;
        final /* synthetic */ zzi zzaZD;

        C12261(zzi com_google_android_gms_wearable_internal_zzi, GoogleApiClient googleApiClient, String str, int i) {
            this.zzaZD = com_google_android_gms_wearable_internal_zzi;
            this.zzaZB = str;
            this.zzaZC = i;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzg(this, this.zzaZB, this.zzaZC);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbi(status);
        }

        protected GetCapabilityResult zzbi(Status status) {
            return new zze(status, null);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzi.2 */
    class C12272 extends zzh<GetAllCapabilitiesResult> {
        final /* synthetic */ int zzaZC;
        final /* synthetic */ zzi zzaZD;

        C12272(zzi com_google_android_gms_wearable_internal_zzi, GoogleApiClient googleApiClient, int i) {
            this.zzaZD = com_google_android_gms_wearable_internal_zzi;
            this.zzaZC = i;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzd(this, this.zzaZC);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbj(status);
        }

        protected GetAllCapabilitiesResult zzbj(Status status) {
            return new zzd(status, null);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzi.3 */
    class C12283 extends zzh<AddLocalCapabilityResult> {
        final /* synthetic */ String zzaZB;
        final /* synthetic */ zzi zzaZD;

        C12283(zzi com_google_android_gms_wearable_internal_zzi, GoogleApiClient googleApiClient, String str) {
            this.zzaZD = com_google_android_gms_wearable_internal_zzi;
            this.zzaZB = str;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzr(this, this.zzaZB);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbk(status);
        }

        protected AddLocalCapabilityResult zzbk(Status status) {
            return new zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.wearable.internal.zzi.4 */
    class C12294 extends zzh<RemoveLocalCapabilityResult> {
        final /* synthetic */ String zzaZB;
        final /* synthetic */ zzi zzaZD;

        C12294(zzi com_google_android_gms_wearable_internal_zzi, GoogleApiClient googleApiClient, String str) {
            this.zzaZD = com_google_android_gms_wearable_internal_zzi;
            this.zzaZB = str;
            super(googleApiClient);
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzs(this, this.zzaZB);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzbl(status);
        }

        protected RemoveLocalCapabilityResult zzbl(Status status) {
            return new zzb(status);
        }
    }

    private static final class zza extends zzh<Status> {
        private CapabilityListener zzaZE;
        private String zzaZF;

        private zza(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, String str) {
            super(googleApiClient);
            this.zzaZE = capabilityListener;
            this.zzaZF = str;
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zza((com.google.android.gms.common.api.zzc.zzb) this, this.zzaZE, this.zzaZF);
            this.zzaZE = null;
            this.zzaZF = null;
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            this.zzaZE = null;
            this.zzaZF = null;
            return status;
        }
    }

    private static final class zzf extends zzh<Status> {
        private CapabilityListener zzaZE;
        private String zzaZF;

        private zzf(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, String str) {
            super(googleApiClient);
            this.zzaZE = capabilityListener;
            this.zzaZF = str;
        }

        protected void zza(zzbn com_google_android_gms_wearable_internal_zzbn) throws RemoteException {
            com_google_android_gms_wearable_internal_zzbn.zzb((com.google.android.gms.common.api.zzc.zzb) this, this.zzaZE, this.zzaZF);
            this.zzaZE = null;
            this.zzaZF = null;
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzd(status);
        }

        public Status zzd(Status status) {
            this.zzaZE = null;
            this.zzaZF = null;
            return status;
        }
    }

    public PendingResult<Status> addCapabilityListener(GoogleApiClient client, CapabilityListener listener, String capability) {
        return client.zza(new zza(listener, capability, null));
    }

    public PendingResult<AddLocalCapabilityResult> addLocalCapability(GoogleApiClient client, String capability) {
        return client.zza(new C12283(this, client, capability));
    }

    public PendingResult<GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient client, int filter) {
        return client.zza(new C12272(this, client, filter));
    }

    public PendingResult<GetCapabilityResult> getCapability(GoogleApiClient client, String capability, int filter) {
        return client.zza(new C12261(this, client, capability, filter));
    }

    public PendingResult<Status> removeCapabilityListener(GoogleApiClient client, CapabilityListener listener, String capability) {
        return client.zza(new zzf(listener, capability, null));
    }

    public PendingResult<RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient client, String capability) {
        return client.zza(new C12294(this, client, capability));
    }
}
