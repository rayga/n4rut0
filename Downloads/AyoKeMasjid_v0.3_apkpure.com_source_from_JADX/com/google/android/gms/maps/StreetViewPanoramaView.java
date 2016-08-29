package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
    private final zzb zzaGC;
    private StreetViewPanorama zzaGq;

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private final Context mContext;
        protected zzf<zza> zzaFZ;
        private final StreetViewPanoramaOptions zzaGG;
        private final ViewGroup zzaGg;
        private final List<OnStreetViewPanoramaReadyCallback> zzaGu;

        zzb(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.zzaGu = new ArrayList();
            this.zzaGg = viewGroup;
            this.mContext = context;
            this.zzaGG = streetViewPanoramaOptions;
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
            if (zzrn() != null) {
                ((zza) zzrn()).getStreetViewPanoramaAsync(callback);
            } else {
                this.zzaGu.add(callback);
            }
        }

        protected void zza(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_StreetViewPanoramaView_zza) {
            this.zzaFZ = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_StreetViewPanoramaView_zza;
            zzwP();
        }

        public void zzwP() {
            if (this.zzaFZ != null && zzrn() == null) {
                try {
                    this.zzaFZ.zza(new zza(this.zzaGg, zzy.zzaF(this.mContext).zza(zze.zzx(this.mContext), this.zzaGG)));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.zzaGu) {
                        ((zza) zzrn()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.zzaGu.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    static class zza implements StreetViewLifecycleDelegate {
        private final IStreetViewPanoramaViewDelegate zzaGD;
        private View zzaGE;
        private final ViewGroup zzaGc;

        /* renamed from: com.google.android.gms.maps.StreetViewPanoramaView.zza.1 */
        class C11681 extends com.google.android.gms.maps.internal.zzv.zza {
            final /* synthetic */ zza zzaGF;
            final /* synthetic */ OnStreetViewPanoramaReadyCallback zzaGs;

            C11681(zza com_google_android_gms_maps_StreetViewPanoramaView_zza, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
                this.zzaGF = com_google_android_gms_maps_StreetViewPanoramaView_zza;
                this.zzaGs = onStreetViewPanoramaReadyCallback;
            }

            public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                this.zzaGs.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
            }
        }

        public zza(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.zzaGD = (IStreetViewPanoramaViewDelegate) zzx.zzv(iStreetViewPanoramaViewDelegate);
            this.zzaGc = (ViewGroup) zzx.zzv(viewGroup);
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
            try {
                this.zzaGD.getStreetViewPanoramaAsync(new C11681(this, callback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzaGD.onCreate(savedInstanceState);
                this.zzaGE = (View) zze.zzp(this.zzaGD.getView());
                this.zzaGc.removeAllViews();
                this.zzaGc.addView(this.zzaGE);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onDestroy() {
            try {
                this.zzaGD.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.zzaGD.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaGD.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaGD.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaGD.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IStreetViewPanoramaViewDelegate zzwW() {
            return this.zzaGD;
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.zzaGC = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.zzaGC = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzaGC = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions options) {
        super(context);
        this.zzaGC = new zzb(this, context, options);
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        if (this.zzaGq != null) {
            return this.zzaGq;
        }
        this.zzaGC.zzwP();
        if (this.zzaGC.zzrn() == null) {
            return null;
        }
        try {
            this.zzaGq = new StreetViewPanorama(((zza) this.zzaGC.zzrn()).zzwW().getStreetViewPanorama());
            return this.zzaGq;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
        zzx.zzch("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zzaGC.getStreetViewPanoramaAsync(callback);
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.zzaGC.onCreate(savedInstanceState);
        if (this.zzaGC.zzrn() == null) {
            com.google.android.gms.dynamic.zza.zzb((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.zzaGC.onDestroy();
    }

    public final void onLowMemory() {
        this.zzaGC.onLowMemory();
    }

    public final void onPause() {
        this.zzaGC.onPause();
    }

    public final void onResume() {
        this.zzaGC.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.zzaGC.onSaveInstanceState(outState);
    }
}
