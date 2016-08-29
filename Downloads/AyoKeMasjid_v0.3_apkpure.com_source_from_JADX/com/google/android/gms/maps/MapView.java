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
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
    private GoogleMap zzaFV;
    private final zzb zzaGb;

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private final Context mContext;
        protected zzf<zza> zzaFZ;
        private final List<OnMapReadyCallback> zzaGa;
        private final ViewGroup zzaGg;
        private final GoogleMapOptions zzaGh;

        zzb(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.zzaGa = new ArrayList();
            this.zzaGg = viewGroup;
            this.mContext = context;
            this.zzaGh = googleMapOptions;
        }

        public void getMapAsync(OnMapReadyCallback callback) {
            if (zzrn() != null) {
                ((zza) zzrn()).getMapAsync(callback);
            } else {
                this.zzaGa.add(callback);
            }
        }

        protected void zza(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapView_zza) {
            this.zzaFZ = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_MapView_zza;
            zzwP();
        }

        public void zzwP() {
            if (this.zzaFZ != null && zzrn() == null) {
                try {
                    MapsInitializer.initialize(this.mContext);
                    IMapViewDelegate zza = zzy.zzaF(this.mContext).zza(zze.zzx(this.mContext), this.zzaGh);
                    if (zza != null) {
                        this.zzaFZ.zza(new zza(this.zzaGg, zza));
                        for (OnMapReadyCallback mapAsync : this.zzaGa) {
                            ((zza) zzrn()).getMapAsync(mapAsync);
                        }
                        this.zzaGa.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    static class zza implements MapLifecycleDelegate {
        private final ViewGroup zzaGc;
        private final IMapViewDelegate zzaGd;
        private View zzaGe;

        /* renamed from: com.google.android.gms.maps.MapView.zza.1 */
        class C11621 extends com.google.android.gms.maps.internal.zzl.zza {
            final /* synthetic */ OnMapReadyCallback zzaFX;
            final /* synthetic */ zza zzaGf;

            C11621(zza com_google_android_gms_maps_MapView_zza, OnMapReadyCallback onMapReadyCallback) {
                this.zzaGf = com_google_android_gms_maps_MapView_zza;
                this.zzaFX = onMapReadyCallback;
            }

            public void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
                this.zzaFX.onMapReady(new GoogleMap(iGoogleMapDelegate));
            }
        }

        public zza(ViewGroup viewGroup, IMapViewDelegate iMapViewDelegate) {
            this.zzaGd = (IMapViewDelegate) zzx.zzv(iMapViewDelegate);
            this.zzaGc = (ViewGroup) zzx.zzv(viewGroup);
        }

        public void getMapAsync(OnMapReadyCallback callback) {
            try {
                this.zzaGd.getMapAsync(new C11621(this, callback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzaGd.onCreate(savedInstanceState);
                this.zzaGe = (View) zze.zzp(this.zzaGd.getView());
                this.zzaGc.removeAllViews();
                this.zzaGc.addView(this.zzaGe);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public void onDestroy() {
            try {
                this.zzaGd.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public void onLowMemory() {
            try {
                this.zzaGd.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaGd.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaGd.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaGd.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IMapViewDelegate zzwQ() {
            return this.zzaGd;
        }
    }

    public MapView(Context context) {
        super(context);
        this.zzaGb = new zzb(this, context, null);
        init();
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.zzaGb = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
        init();
    }

    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzaGb = new zzb(this, context, GoogleMapOptions.createFromAttributes(context, attrs));
        init();
    }

    public MapView(Context context, GoogleMapOptions options) {
        super(context);
        this.zzaGb = new zzb(this, context, options);
        init();
    }

    private void init() {
        setClickable(true);
    }

    @Deprecated
    public final GoogleMap getMap() {
        if (this.zzaFV != null) {
            return this.zzaFV;
        }
        this.zzaGb.zzwP();
        if (this.zzaGb.zzrn() == null) {
            return null;
        }
        try {
            this.zzaFV = new GoogleMap(((zza) this.zzaGb.zzrn()).zzwQ().getMap());
            return this.zzaFV;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getMapAsync(OnMapReadyCallback callback) {
        zzx.zzch("getMapAsync() must be called on the main thread");
        this.zzaGb.getMapAsync(callback);
    }

    public final void onCreate(Bundle savedInstanceState) {
        this.zzaGb.onCreate(savedInstanceState);
        if (this.zzaGb.zzrn() == null) {
            com.google.android.gms.dynamic.zza.zzb((FrameLayout) this);
        }
    }

    public final void onDestroy() {
        this.zzaGb.onDestroy();
    }

    public final void onLowMemory() {
        this.zzaGb.onLowMemory();
    }

    public final void onPause() {
        this.zzaGb.onPause();
    }

    public final void onResume() {
        this.zzaGb.onResume();
    }

    public final void onSaveInstanceState(Bundle outState) {
        this.zzaGb.onSaveInstanceState(outState);
    }
}
