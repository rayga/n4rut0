package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaFragment extends Fragment {
    private final zzb zzaGp;
    private StreetViewPanorama zzaGq;

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private Activity mActivity;
        protected zzf<zza> zzaFZ;
        private final List<OnStreetViewPanoramaReadyCallback> zzaGu;
        private final Fragment zzamZ;

        zzb(Fragment fragment) {
            this.zzaGu = new ArrayList();
            this.zzamZ = fragment;
        }

        private void setActivity(Activity activity) {
            this.mActivity = activity;
            zzwP();
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
            if (zzrn() != null) {
                ((zza) zzrn()).getStreetViewPanoramaAsync(callback);
            } else {
                this.zzaGu.add(callback);
            }
        }

        protected void zza(zzf<zza> com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_StreetViewPanoramaFragment_zza) {
            this.zzaFZ = com_google_android_gms_dynamic_zzf_com_google_android_gms_maps_StreetViewPanoramaFragment_zza;
            zzwP();
        }

        public void zzwP() {
            if (this.mActivity != null && this.zzaFZ != null && zzrn() == null) {
                try {
                    MapsInitializer.initialize(this.mActivity);
                    this.zzaFZ.zza(new zza(this.zzamZ, zzy.zzaF(this.mActivity).zzu(zze.zzx(this.mActivity))));
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
        private final IStreetViewPanoramaFragmentDelegate zzaGr;
        private final Fragment zzamZ;

        /* renamed from: com.google.android.gms.maps.StreetViewPanoramaFragment.zza.1 */
        class C11671 extends com.google.android.gms.maps.internal.zzv.zza {
            final /* synthetic */ OnStreetViewPanoramaReadyCallback zzaGs;
            final /* synthetic */ zza zzaGt;

            C11671(zza com_google_android_gms_maps_StreetViewPanoramaFragment_zza, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
                this.zzaGt = com_google_android_gms_maps_StreetViewPanoramaFragment_zza;
                this.zzaGs = onStreetViewPanoramaReadyCallback;
            }

            public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                this.zzaGs.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
            }
        }

        public zza(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.zzaGr = (IStreetViewPanoramaFragmentDelegate) zzx.zzv(iStreetViewPanoramaFragmentDelegate);
            this.zzamZ = (Fragment) zzx.zzv(fragment);
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
            try {
                this.zzaGr.getStreetViewPanoramaAsync(new C11671(this, callback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.zzamZ.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                com.google.android.gms.maps.internal.zzx.zza(savedInstanceState, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.zzaGr.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzp(this.zzaGr.onCreateView(zze.zzx(inflater), zze.zzx(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.zzaGr.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.zzaGr.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzaGr.onInflate(zze.zzx(activity), null, savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.zzaGr.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaGr.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaGr.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaGr.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IStreetViewPanoramaFragmentDelegate zzwS() {
            return this.zzaGr;
        }
    }

    public StreetViewPanoramaFragment() {
        this.zzaGp = new zzb(this);
    }

    public static StreetViewPanoramaFragment newInstance() {
        return new StreetViewPanoramaFragment();
    }

    public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions options) {
        StreetViewPanoramaFragment streetViewPanoramaFragment = new StreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", options);
        streetViewPanoramaFragment.setArguments(bundle);
        return streetViewPanoramaFragment;
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate zzwS = zzwS();
        if (zzwS == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = zzwS.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.zzaGq == null || this.zzaGq.zzwR().asBinder() != streetViewPanorama.asBinder()) {
                this.zzaGq = new StreetViewPanorama(streetViewPanorama);
            }
            return this.zzaGq;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
        zzx.zzch("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zzaGp.getStreetViewPanoramaAsync(callback);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzaGp.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzaGp.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaGp.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.zzaGp.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzaGp.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.zzaGp.setActivity(activity);
        this.zzaGp.onInflate(activity, new Bundle(), savedInstanceState);
    }

    public void onLowMemory() {
        this.zzaGp.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzaGp.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaGp.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.zzaGp.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    protected IStreetViewPanoramaFragmentDelegate zzwS() {
        this.zzaGp.zzwP();
        return this.zzaGp.zzrn() == null ? null : ((zza) this.zzaGp.zzrn()).zzwS();
    }
}
