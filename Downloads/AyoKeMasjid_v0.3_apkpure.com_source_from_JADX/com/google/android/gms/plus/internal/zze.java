package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class zze extends zzj<zzd> {
    private Person zzaLo;
    private final PlusSession zzaLp;

    static final class zza implements LoadMomentsResult {
        private final Status zzQA;
        private final String zzaLq;
        private final String zzaLr;
        private final MomentBuffer zzaLs;

        public zza(Status status, DataHolder dataHolder, String str, String str2) {
            this.zzQA = status;
            this.zzaLq = str;
            this.zzaLr = str2;
            this.zzaLs = dataHolder != null ? new MomentBuffer(dataHolder) : null;
        }

        public MomentBuffer getMomentBuffer() {
            return this.zzaLs;
        }

        public String getNextPageToken() {
            return this.zzaLq;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public String getUpdated() {
            return this.zzaLr;
        }

        public void release() {
            if (this.zzaLs != null) {
                this.zzaLs.release();
            }
        }
    }

    static final class zzb implements LoadPeopleResult {
        private final Status zzQA;
        private final String zzaLq;
        private final PersonBuffer zzaLt;

        public zzb(Status status, DataHolder dataHolder, String str) {
            this.zzQA = status;
            this.zzaLq = str;
            this.zzaLt = dataHolder != null ? new PersonBuffer(dataHolder) : null;
        }

        public String getNextPageToken() {
            return this.zzaLq;
        }

        public PersonBuffer getPersonBuffer() {
            return this.zzaLt;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzaLt != null) {
                this.zzaLt.release();
            }
        }
    }

    static final class zzc extends zza {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzaCS;

        public zzc(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            this.zzaCS = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzaX(Status status) {
            this.zzaCS.zzn(status);
        }
    }

    static final class zzd extends zza {
        private final com.google.android.gms.common.api.zzc.zzb<LoadMomentsResult> zzaCS;

        public zzd(com.google.android.gms.common.api.zzc.zzb<LoadMomentsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) {
            this.zzaCS = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult;
        }

        public void zza(DataHolder dataHolder, String str, String str2) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zznP() != null ? (PendingIntent) dataHolder.zznP().getParcelable("pendingIntent") : null);
            if (!(status.isSuccess() || dataHolder == null)) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaCS.zzn(new zza(status, dataHolder, str, str2));
        }
    }

    static final class zze extends zza {
        private final com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> zzaCS;

        public zze(com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_People_LoadPeopleResult) {
            this.zzaCS = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_People_LoadPeopleResult;
        }

        public void zza(DataHolder dataHolder, String str) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zznP() != null ? (PendingIntent) dataHolder.zznP().getParcelable("pendingIntent") : null);
            if (!(status.isSuccess() || dataHolder == null)) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaCS.zzn(new zzb(status, dataHolder, str));
        }
    }

    static final class zzf extends zza {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzaCS;

        public zzf(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
            this.zzaCS = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzi(int i, Bundle bundle) {
            this.zzaCS.zzn(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, PlusSession plusSession, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzaLp = plusSession;
    }

    public static boolean zzd(Set<Scope> set) {
        return (set == null || set.isEmpty()) ? false : (set.size() == 1 && set.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }

    private Bundle zzlj() {
        Bundle zzyS = this.zzaLp.zzyS();
        zzyS.putStringArray(GoogleAuthUtil.KEY_REQUEST_VISIBLE_ACTIVITIES, this.zzaLp.zzyM());
        zzyS.putString("auth_package", this.zzaLp.zzyO());
        return zzyS;
    }

    public String getAccountName() {
        zzoz();
        try {
            return ((zzd) zzoA()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzdy(iBinder);
    }

    public zzq zza(com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_People_LoadPeopleResult, int i, String str) {
        zzoz();
        Object com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            return ((zzd) zzoA()).zza(com_google_android_gms_plus_internal_zze_zze, 1, i, -1, str);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzbp(8), null);
            return null;
        }
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.zzaLo = PersonEntity.zzp(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<LoadMomentsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult, int i, String str, Uri uri, String str2, String str3) {
        zzoz();
        Object com_google_android_gms_plus_internal_zze_zzd = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult != null ? new zzd(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) : null;
        try {
            ((zzd) zzoA()).zza(com_google_android_gms_plus_internal_zze_zzd, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzd.zza(DataHolder.zzbp(8), null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status, Moment moment) {
        zzoz();
        zzb com_google_android_gms_plus_internal_zze_zzc = com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status != null ? new zzc(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) : null;
        try {
            ((zzd) zzoA()).zza(com_google_android_gms_plus_internal_zze_zzc, SafeParcelResponse.zza((MomentEntity) moment));
        } catch (Throwable e) {
            if (com_google_android_gms_plus_internal_zze_zzc == null) {
                throw new IllegalStateException(e);
            }
            com_google_android_gms_plus_internal_zze_zzc.zzaX(new Status(8, null, null));
        }
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_People_LoadPeopleResult, Collection<String> collection) {
        zzoz();
        zzb com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            ((zzd) zzoA()).zza(com_google_android_gms_plus_internal_zze_zze, new ArrayList(collection));
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzbp(8), null);
        }
    }

    public void zzd(com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_People_LoadPeopleResult, String[] strArr) {
        zza((com.google.android.gms.common.api.zzc.zzb) com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_People_LoadPeopleResult, Arrays.asList(strArr));
    }

    protected zzd zzdy(IBinder iBinder) {
        return com.google.android.gms.plus.internal.zzd.zza.zzdx(iBinder);
    }

    public void zzej(String str) {
        zzoz();
        try {
            ((zzd) zzoA()).zzej(str);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected String zzfA() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public void zzk(com.google.android.gms.common.api.zzc.zzb<LoadMomentsResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult) {
        zza(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_Moments_LoadMomentsResult, 20, null, null, null, "me");
    }

    public void zzl(com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_People_LoadPeopleResult) {
        zzoz();
        Object com_google_android_gms_plus_internal_zze_zze = new zze(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_People_LoadPeopleResult);
        try {
            ((zzd) zzoA()).zza(com_google_android_gms_plus_internal_zze_zze, 2, 1, -1, null);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zze.zza(DataHolder.zzbp(8), null);
        }
    }

    protected Bundle zzli() {
        return zzlj();
    }

    public boolean zzlm() {
        return zzd(zzoy().zzb(Plus.API));
    }

    public void zzm(com.google.android.gms.common.api.zzc.zzb<Status> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status) {
        zzoz();
        zzyG();
        Object com_google_android_gms_plus_internal_zze_zzf = new zzf(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_common_api_Status);
        try {
            ((zzd) zzoA()).zzb(com_google_android_gms_plus_internal_zze_zzf);
        } catch (RemoteException e) {
            com_google_android_gms_plus_internal_zze_zzf.zzi(8, null);
        }
    }

    protected Bundle zzoB() {
        return zzlj();
    }

    public zzq zzq(com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_People_LoadPeopleResult, String str) {
        return zza(com_google_android_gms_common_api_zzc_zzb_com_google_android_gms_plus_People_LoadPeopleResult, 0, str);
    }

    public void zzyG() {
        zzoz();
        try {
            this.zzaLo = null;
            ((zzd) zzoA()).zzyG();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person zzyI() {
        zzoz();
        return this.zzaLo;
    }
}
