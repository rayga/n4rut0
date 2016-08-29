package com.google.android.gms.internal;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzkl implements CastRemoteDisplayApi {
    private static final zzl zzTy;
    private com.google.android.gms.common.api.Api.zzc<zzkm> zzXW;
    private VirtualDisplay zzXX;
    private final zzkp zzXY;

    /* renamed from: com.google.android.gms.internal.zzkl.1 */
    class C11451 extends com.google.android.gms.internal.zzkp.zza {
        final /* synthetic */ zzkl zzXZ;

        C11451(zzkl com_google_android_gms_internal_zzkl) {
            this.zzXZ = com_google_android_gms_internal_zzkl;
        }

        public void zzaZ(int i) {
            zzkl.zzTy.zzb("onRemoteDisplayEnded", new Object[0]);
            this.zzXZ.zzmP();
        }
    }

    private abstract class zza extends com.google.android.gms.internal.zzkn.zza {
        final /* synthetic */ zzkl zzXZ;

        private zza(zzkl com_google_android_gms_internal_zzkl) {
            this.zzXZ = com_google_android_gms_internal_zzkl;
        }

        public void onDisconnected() throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void onError(int statusCode) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zza(int i, int i2, Surface surface) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zzmR() throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    private static final class zzc implements CastRemoteDisplaySessionResult {
        private final Status zzQA;
        private final Display zzTK;

        public zzc(Display display) {
            this.zzQA = Status.zzaaD;
            this.zzTK = display;
        }

        public zzc(Status status) {
            this.zzQA = status;
            this.zzTK = null;
        }

        public Display getPresentationDisplay() {
            return this.zzTK;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private abstract class zzb extends com.google.android.gms.common.api.zzc.zza<CastRemoteDisplaySessionResult, zzkm> {
        final /* synthetic */ zzkl zzXZ;

        protected final class zza extends zza {
            private final zzkm zzYb;
            final /* synthetic */ zzb zzYc;

            public zza(zzb com_google_android_gms_internal_zzkl_zzb, zzkm com_google_android_gms_internal_zzkm) {
                this.zzYc = com_google_android_gms_internal_zzkl_zzb;
                super(null);
                this.zzYb = com_google_android_gms_internal_zzkm;
            }

            private int zzj(int i, int i2) {
                if (i >= i2) {
                    i = i2;
                }
                return (i * 320) / 1080;
            }

            public void onError(int statusCode) throws RemoteException {
                zzkl.zzTy.zzb("onError: %d", Integer.valueOf(statusCode));
                this.zzYc.zzXZ.zzmP();
                this.zzYc.zza(new zzc(Status.zzaaF));
            }

            public void zza(int i, int i2, Surface surface) {
                zzkl.zzTy.zzb("onConnected", new Object[0]);
                DisplayManager displayManager = (DisplayManager) this.zzYb.getContext().getSystemService("display");
                if (displayManager == null) {
                    zzkl.zzTy.zzc("Unable to get the display manager", new Object[0]);
                    this.zzYc.zza(new zzc(Status.zzaaF));
                    return;
                }
                this.zzYc.zzXZ.zzmP();
                this.zzYc.zzXZ.zzXX = displayManager.createVirtualDisplay("private_display", i, i2, zzj(i, i2), surface, 2);
                if (this.zzYc.zzXZ.zzXX == null) {
                    zzkl.zzTy.zzc("Unable to create virtual display", new Object[0]);
                    this.zzYc.zza(new zzc(Status.zzaaF));
                } else if (this.zzYc.zzXZ.zzXX.getDisplay() == null) {
                    zzkl.zzTy.zzc("Virtual display does not have a display", new Object[0]);
                    this.zzYc.zza(new zzc(Status.zzaaF));
                } else {
                    try {
                        this.zzYb.zza(this, this.zzYc.zzXZ.zzXX.getDisplay().getDisplayId());
                    } catch (RemoteException e) {
                        zzkl.zzTy.zzc("Unable to provision the route's new virtual Display", new Object[0]);
                        this.zzYc.zza(new zzc(Status.zzaaF));
                    } catch (IllegalStateException e2) {
                        zzkl.zzTy.zzc("Unable to provision the route's new virtual Display", new Object[0]);
                        this.zzYc.zza(new zzc(Status.zzaaF));
                    }
                }
            }

            public void zzmR() {
                zzkl.zzTy.zzb("onConnectedWithDisplay", new Object[0]);
                Display display = this.zzYc.zzXZ.zzXX.getDisplay();
                if (display != null) {
                    this.zzYc.zza(new zzc(display));
                    return;
                }
                zzkl.zzTy.zzc("Virtual display no longer has a display", new Object[0]);
                this.zzYc.zza(new zzc(Status.zzaaF));
            }
        }

        protected final class zzb extends zza {
            final /* synthetic */ zzb zzYc;

            protected zzb(zzb com_google_android_gms_internal_zzkl_zzb) {
                this.zzYc = com_google_android_gms_internal_zzkl_zzb;
                super(null);
            }

            public void onDisconnected() throws RemoteException {
                zzkl.zzTy.zzb("onDisconnected", new Object[0]);
                this.zzYc.zzXZ.zzmP();
                this.zzYc.zza(new zzc(Status.zzaaD));
            }

            public void onError(int statusCode) throws RemoteException {
                zzkl.zzTy.zzb("onError: %d", Integer.valueOf(statusCode));
                this.zzYc.zzXZ.zzmP();
                this.zzYc.zza(new zzc(Status.zzaaF));
            }
        }

        public zzb(zzkl com_google_android_gms_internal_zzkl, GoogleApiClient googleApiClient) {
            this.zzXZ = com_google_android_gms_internal_zzkl;
            super(com_google_android_gms_internal_zzkl.zzXW, googleApiClient);
        }

        protected /* synthetic */ Result zzb(Status status) {
            return zzv(status);
        }

        protected CastRemoteDisplaySessionResult zzv(Status status) {
            return new zzc(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkl.2 */
    class C11972 extends zzb {
        final /* synthetic */ zzkl zzXZ;
        final /* synthetic */ String zzYa;

        C11972(zzkl com_google_android_gms_internal_zzkl, GoogleApiClient googleApiClient, String str) {
            this.zzXZ = com_google_android_gms_internal_zzkl;
            this.zzYa = str;
            super(com_google_android_gms_internal_zzkl, googleApiClient);
        }

        protected void zza(zzkm com_google_android_gms_internal_zzkm) throws RemoteException {
            com_google_android_gms_internal_zzkm.zza(new zza(this, com_google_android_gms_internal_zzkm), this.zzXZ.zzXY, this.zzYa);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkl.3 */
    class C11983 extends zzb {
        final /* synthetic */ zzkl zzXZ;

        C11983(zzkl com_google_android_gms_internal_zzkl, GoogleApiClient googleApiClient) {
            this.zzXZ = com_google_android_gms_internal_zzkl;
            super(com_google_android_gms_internal_zzkl, googleApiClient);
        }

        protected void zza(zzkm com_google_android_gms_internal_zzkm) throws RemoteException {
            com_google_android_gms_internal_zzkm.zza(new zzb(this));
        }
    }

    static {
        zzTy = new zzl("CastRemoteDisplayApiImpl");
    }

    public zzkl(com.google.android.gms.common.api.Api.zzc<zzkm> com_google_android_gms_common_api_Api_zzc_com_google_android_gms_internal_zzkm) {
        this.zzXY = new C11451(this);
        this.zzXW = com_google_android_gms_common_api_Api_zzc_com_google_android_gms_internal_zzkm;
    }

    private void zzmP() {
        if (this.zzXX != null) {
            if (this.zzXX.getDisplay() != null) {
                zzTy.zzb("releasing virtual display: " + this.zzXX.getDisplay().getDisplayId(), new Object[0]);
            }
            this.zzXX.release();
            this.zzXX = null;
        }
    }

    public PendingResult<CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient apiClient, String appId) {
        zzTy.zzb("startRemoteDisplay", new Object[0]);
        return apiClient.zzb(new C11972(this, apiClient, appId));
    }

    public PendingResult<CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient apiClient) {
        zzTy.zzb("stopRemoteDisplay", new Object[0]);
        return apiClient.zzb(new C11983(this, apiClient));
    }
}
