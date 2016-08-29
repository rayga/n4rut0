package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private final zzm zzUV;
    private final zza zzUW;
    private OnPreloadStatusUpdatedListener zzUX;
    private OnQueueStatusUpdatedListener zzUY;
    private OnMetadataUpdatedListener zzUZ;
    private OnStatusUpdatedListener zzVa;
    private final Object zzpc;

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    private class zza implements zzn {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        private GoogleApiClient zzVy;
        private long zzVz;

        private final class zza implements ResultCallback<Status> {
            private final long zzVA;
            final /* synthetic */ zza zzVB;

            zza(zza com_google_android_gms_cast_RemoteMediaPlayer_zza, long j) {
                this.zzVB = com_google_android_gms_cast_RemoteMediaPlayer_zza;
                this.zzVA = j;
            }

            public /* synthetic */ void onResult(Result x0) {
                zzr((Status) x0);
            }

            public void zzr(Status status) {
                if (!status.isSuccess()) {
                    this.zzVB.zzVb.zzUV.zzb(this.zzVA, status.getStatusCode());
                }
            }
        }

        public zza(RemoteMediaPlayer remoteMediaPlayer) {
            this.zzVb = remoteMediaPlayer;
            this.zzVz = 0;
        }

        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzVy == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzVy, str, str2).setResultCallback(new zza(this, j));
        }

        public void zzb(GoogleApiClient googleApiClient) {
            this.zzVy = googleApiClient;
        }

        public long zzme() {
            long j = this.zzVz + 1;
            this.zzVz = j;
            return j;
        }
    }

    private static final class zzc implements MediaChannelResult {
        private final Status zzQA;
        private final JSONObject zzUl;

        zzc(Status status, JSONObject jSONObject) {
            this.zzQA = status;
            this.zzUl = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.zzUl;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.1 */
    class C11771 extends zzm {
        final /* synthetic */ RemoteMediaPlayer zzVb;

        C11771(RemoteMediaPlayer remoteMediaPlayer, String str) {
            this.zzVb = remoteMediaPlayer;
            super(str);
        }

        protected void onMetadataUpdated() {
            this.zzVb.onMetadataUpdated();
        }

        protected void onPreloadStatusUpdated() {
            this.zzVb.onPreloadStatusUpdated();
        }

        protected void onQueueStatusUpdated() {
            this.zzVb.onQueueStatusUpdated();
        }

        protected void onStatusUpdated() {
            this.zzVb.onStatusUpdated();
        }
    }

    private static abstract class zzb extends com.google.android.gms.cast.internal.zzb<MediaChannelResult> {
        zzo zzVC;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.zzb.1 */
        class C07051 implements zzo {
            final /* synthetic */ zzb zzVD;

            C07051(zzb com_google_android_gms_cast_RemoteMediaPlayer_zzb) {
                this.zzVD = com_google_android_gms_cast_RemoteMediaPlayer_zzb;
            }

            public void zza(long j, int i, Object obj) {
                this.zzVD.zza(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }

            public void zzy(long j) {
                this.zzVD.zza(this.zzVD.zzs(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        }

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.zzb.2 */
        class C09102 implements MediaChannelResult {
            final /* synthetic */ Status zzQs;
            final /* synthetic */ zzb zzVD;

            C09102(zzb com_google_android_gms_cast_RemoteMediaPlayer_zzb, Status status) {
                this.zzVD = com_google_android_gms_cast_RemoteMediaPlayer_zzb;
                this.zzQs = status;
            }

            public JSONObject getCustomData() {
                return null;
            }

            public Status getStatus() {
                return this.zzQs;
            }
        }

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzVC = new C07051(this);
        }

        public /* synthetic */ Result zzb(Status status) {
            return zzs(status);
        }

        public MediaChannelResult zzs(Status status) {
            return new C09102(this, status);
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.10 */
    class AnonymousClass10 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;

        AnonymousClass10(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, null, (int) RemoteMediaPlayer.RESUME_STATE_PLAY, null, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.11 */
    class AnonymousClass11 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ int zzVh;
        final /* synthetic */ JSONObject zzVi;

        AnonymousClass11(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, int i, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVh = i;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, null, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, Integer.valueOf(this.zzVh), this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.12 */
    class AnonymousClass12 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;
        final /* synthetic */ MediaInfo zzVo;
        final /* synthetic */ boolean zzVp;
        final /* synthetic */ long zzVq;
        final /* synthetic */ long[] zzVr;

        AnonymousClass12(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVo = mediaInfo;
            this.zzVp = z;
            this.zzVq = j;
            this.zzVr = jArr;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, this.zzVo, this.zzVp, this.zzVq, this.zzVr, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.13 */
    class AnonymousClass13 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;
        final /* synthetic */ int zzVs;

        AnonymousClass13(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVs = i;
            this.zzVc = googleApiClient2;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                if (this.zzVb.zzaP(this.zzVs) == -1) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_SUCCEEDED)));
                    return;
                }
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    zzm zzg = this.zzVb.zzUV;
                    zzo com_google_android_gms_cast_internal_zzo = this.zzVC;
                    int[] iArr = new int[RemoteMediaPlayer.RESUME_STATE_PLAY];
                    iArr[RemoteMediaPlayer.STATUS_SUCCEEDED] = this.zzVs;
                    zzg.zza(com_google_android_gms_cast_internal_zzo, iArr, this.zzVi);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                } finally {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.14 */
    class AnonymousClass14 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;
        final /* synthetic */ int zzVs;

        AnonymousClass14(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVs = i;
            this.zzVc = googleApiClient2;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                if (this.zzVb.zzaP(this.zzVs) == -1) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_SUCCEEDED)));
                    return;
                }
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, this.zzVs, null, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, null, this.zzVi);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                } finally {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.15 */
    class AnonymousClass15 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;
        final /* synthetic */ int zzVs;
        final /* synthetic */ int zzVt;

        AnonymousClass15(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, int i2, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVs = i;
            this.zzVt = i2;
            this.zzVc = googleApiClient2;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            int i = RemoteMediaPlayer.STATUS_SUCCEEDED;
            synchronized (this.zzVb.zzpc) {
                int zza = this.zzVb.zzaP(this.zzVs);
                if (zza == -1) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_SUCCEEDED)));
                } else if (this.zzVt < 0) {
                    Object[] objArr = new Object[RemoteMediaPlayer.RESUME_STATE_PLAY];
                    objArr[RemoteMediaPlayer.STATUS_SUCCEEDED] = Integer.valueOf(this.zzVt);
                    zza(zzs(new Status(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", objArr))));
                } else if (zza == this.zzVt) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_SUCCEEDED)));
                } else {
                    MediaQueueItem queueItem = this.zzVb.getMediaStatus().getQueueItem(this.zzVt > zza ? this.zzVt + RemoteMediaPlayer.RESUME_STATE_PLAY : this.zzVt);
                    if (queueItem != null) {
                        i = queueItem.getItemId();
                    }
                    this.zzVb.zzUW.zzb(this.zzVc);
                    try {
                        zzm zzg = this.zzVb.zzUV;
                        zzo com_google_android_gms_cast_internal_zzo = this.zzVC;
                        int[] iArr = new int[RemoteMediaPlayer.RESUME_STATE_PLAY];
                        iArr[RemoteMediaPlayer.STATUS_SUCCEEDED] = this.zzVs;
                        zzg.zza(com_google_android_gms_cast_internal_zzo, iArr, i, this.zzVi);
                    } catch (IOException e) {
                        zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    } finally {
                        this.zzVb.zzUW.zzb(null);
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.16 */
    class AnonymousClass16 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;

        AnonymousClass16(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.17 */
    class AnonymousClass17 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;

        AnonymousClass17(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zzb(this.zzVC, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.18 */
    class AnonymousClass18 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;

        AnonymousClass18(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zzc(this.zzVC, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.19 */
    class AnonymousClass19 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;
        final /* synthetic */ long zzVu;
        final /* synthetic */ int zzVv;

        AnonymousClass19(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, long j, int i, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVu = j;
            this.zzVv = i;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, this.zzVu, this.zzVv, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.20 */
    class AnonymousClass20 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;
        final /* synthetic */ double zzVw;

        AnonymousClass20(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, double d, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVw = d;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, this.zzVw, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IllegalStateException e) {
                    try {
                        zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.zzVb.zzUW.zzb(null);
                    } catch (Throwable th) {
                        this.zzVb.zzUW.zzb(null);
                    }
                } catch (IllegalArgumentException e2) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e3) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.21 */
    class AnonymousClass21 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;
        final /* synthetic */ boolean zzVx;

        AnonymousClass21(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, boolean z, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVx = z;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, this.zzVx, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IllegalStateException e) {
                    try {
                        zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                        this.zzVb.zzUW.zzb(null);
                    } catch (Throwable th) {
                        this.zzVb.zzUW.zzb(null);
                    }
                } catch (IOException e2) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.22 */
    class AnonymousClass22 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;

        AnonymousClass22(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.2 */
    class C12552 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ long[] zzVd;

        C12552(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, long[] jArr) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVd = jArr;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, this.zzVd);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.3 */
    class C12563 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ TextTrackStyle zzVe;

        C12563(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, TextTrackStyle textTrackStyle) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVe = textTrackStyle;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, this.zzVe);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.4 */
    class C12574 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ MediaQueueItem[] zzVf;
        final /* synthetic */ int zzVg;
        final /* synthetic */ int zzVh;
        final /* synthetic */ JSONObject zzVi;

        C12574(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaQueueItem[] mediaQueueItemArr, int i, int i2, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVf = mediaQueueItemArr;
            this.zzVg = i;
            this.zzVh = i2;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, this.zzVf, this.zzVg, this.zzVh, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.5 */
    class C12585 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;
        final /* synthetic */ MediaQueueItem[] zzVj;
        final /* synthetic */ int zzVk;

        C12585(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVj = mediaQueueItemArr;
            this.zzVk = i;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, this.zzVj, this.zzVk, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.6 */
    class C12596 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;
        final /* synthetic */ MediaQueueItem[] zzVl;

        C12596(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVl = mediaQueueItemArr;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, this.zzVl, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, null, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.7 */
    class C12607 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;
        final /* synthetic */ int[] zzVm;

        C12607(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, int[] iArr, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVm = iArr;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, this.zzVm, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.8 */
    class C12618 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;
        final /* synthetic */ int zzVk;
        final /* synthetic */ int[] zzVn;

        C12618(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, int[] iArr, int i, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVn = iArr;
            this.zzVk = i;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, this.zzVn, this.zzVk, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.9 */
    class C12629 extends zzb {
        final /* synthetic */ RemoteMediaPlayer zzVb;
        final /* synthetic */ GoogleApiClient zzVc;
        final /* synthetic */ JSONObject zzVi;

        C12629(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, GoogleApiClient googleApiClient2, JSONObject jSONObject) {
            this.zzVb = remoteMediaPlayer;
            this.zzVc = googleApiClient2;
            this.zzVi = jSONObject;
            super(googleApiClient);
        }

        protected void zza(zze com_google_android_gms_cast_internal_zze) {
            synchronized (this.zzVb.zzpc) {
                this.zzVb.zzUW.zzb(this.zzVc);
                try {
                    this.zzVb.zzUV.zza(this.zzVC, (int) RemoteMediaPlayer.STATUS_SUCCEEDED, null, -1, null, this.zzVi);
                    this.zzVb.zzUW.zzb(null);
                } catch (IOException e) {
                    zza(zzs(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.zzVb.zzUW.zzb(null);
                } catch (Throwable th) {
                    this.zzVb.zzUW.zzb(null);
                }
            }
        }
    }

    public RemoteMediaPlayer() {
        this.zzpc = new Object();
        this.zzUW = new zza(this);
        this.zzUV = new C11771(this, null);
        this.zzUV.zza(this.zzUW);
    }

    private void onMetadataUpdated() {
        if (this.zzUZ != null) {
            this.zzUZ.onMetadataUpdated();
        }
    }

    private void onPreloadStatusUpdated() {
        if (this.zzUX != null) {
            this.zzUX.onPreloadStatusUpdated();
        }
    }

    private void onQueueStatusUpdated() {
        if (this.zzUY != null) {
            this.zzUY.onQueueStatusUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.zzVa != null) {
            this.zzVa.onStatusUpdated();
        }
    }

    private int zzaP(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = STATUS_SUCCEEDED; i2 < mediaStatus.getQueueItemCount(); i2 += RESUME_STATE_PLAY) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzpc) {
            approximateStreamPosition = this.zzUV.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzpc) {
            mediaInfo = this.zzUV.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzpc) {
            mediaStatus = this.zzUV.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzUV.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzpc) {
            streamDuration = this.zzUV.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, customData);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, long[] activeTrackIds, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass12(this, apiClient, apiClient, mediaInfo, autoplay, playPosition, activeTrackIds, customData));
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.zzUV.zzbJ(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass16(this, apiClient, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass18(this, apiClient, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> queueAppendItem(GoogleApiClient apiClient, MediaQueueItem item, JSONObject customData) throws IllegalArgumentException {
        MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[RESUME_STATE_PLAY];
        mediaQueueItemArr[STATUS_SUCCEEDED] = item;
        return queueInsertItems(apiClient, mediaQueueItemArr, STATUS_SUCCEEDED, customData);
    }

    public PendingResult<MediaChannelResult> queueInsertItems(GoogleApiClient apiClient, MediaQueueItem[] itemsToInsert, int insertBeforeItemId, JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new C12585(this, apiClient, apiClient, itemsToInsert, insertBeforeItemId, customData));
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass14(this, apiClient, itemId, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient apiClient, MediaQueueItem[] items, int startIndex, int repeatMode, JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new C12574(this, apiClient, apiClient, items, startIndex, repeatMode, customData));
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(GoogleApiClient apiClient, int itemId, int newIndex, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass15(this, apiClient, itemId, newIndex, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> queueNext(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass10(this, apiClient, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> queuePrev(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.zzb(new C12629(this, apiClient, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass13(this, apiClient, itemId, apiClient, customData));
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(GoogleApiClient apiClient, int[] itemIdsToRemove, JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new C12607(this, apiClient, apiClient, itemIdsToRemove, customData));
    }

    public PendingResult<MediaChannelResult> queueReorderItems(GoogleApiClient apiClient, int[] itemIdsToReorder, int insertBeforeItemId, JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new C12618(this, apiClient, apiClient, itemIdsToReorder, insertBeforeItemId, customData));
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(GoogleApiClient apiClient, int repeatMode, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass11(this, apiClient, apiClient, repeatMode, customData));
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(GoogleApiClient apiClient, MediaQueueItem[] itemsToUpdate, JSONObject customData) {
        return apiClient.zzb(new C12596(this, apiClient, apiClient, itemsToUpdate, customData));
    }

    public PendingResult<MediaChannelResult> requestStatus(GoogleApiClient apiClient) {
        return apiClient.zzb(new AnonymousClass22(this, apiClient, apiClient));
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, STATUS_SUCCEEDED, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass19(this, apiClient, apiClient, position, resumeState, customData));
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(GoogleApiClient apiClient, long[] trackIds) {
        if (trackIds != null) {
            return apiClient.zzb(new C12552(this, apiClient, apiClient, trackIds));
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.zzUZ = listener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener listener) {
        this.zzUX = listener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener listener) {
        this.zzUY = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.zzVa = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass21(this, apiClient, apiClient, muteState, customData));
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (!Double.isInfinite(volume) && !Double.isNaN(volume)) {
            return apiClient.zzb(new AnonymousClass20(this, apiClient, apiClient, volume, customData));
        }
        throw new IllegalArgumentException("Volume cannot be " + volume);
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(GoogleApiClient apiClient, TextTrackStyle trackStyle) {
        if (trackStyle != null) {
            return apiClient.zzb(new C12563(this, apiClient, apiClient, trackStyle));
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.zzb(new AnonymousClass17(this, apiClient, apiClient, customData));
    }
}
