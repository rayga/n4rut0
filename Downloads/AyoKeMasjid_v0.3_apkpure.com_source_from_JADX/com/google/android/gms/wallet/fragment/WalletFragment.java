package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0197R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment extends Fragment {
    private boolean mCreated;
    private WalletFragmentOptions zzaXQ;
    private WalletFragmentInitParams zzaXR;
    private MaskedWalletRequest zzaXS;
    private MaskedWallet zzaXT;
    private Boolean zzaXU;
    private zzb zzaXZ;
    private final com.google.android.gms.dynamic.zzb zzaYa;
    private final zzc zzaYb;
    private zza zzaYc;
    private final Fragment zzamZ;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    private static class zzb implements LifecycleDelegate {
        private final zzra zzaXX;

        private zzb(zzra com_google_android_gms_internal_zzra) {
            this.zzaXX = com_google_android_gms_internal_zzra;
        }

        private int getState() {
            try {
                return this.zzaXX.getState();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void initialize(WalletFragmentInitParams startParams) {
            try {
                this.zzaXX.initialize(startParams);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.zzaXX.onActivityResult(requestCode, resultCode, data);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void setEnabled(boolean enabled) {
            try {
                this.zzaXX.setEnabled(enabled);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzaXX.updateMaskedWallet(maskedWallet);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        private void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.zzaXX.updateMaskedWalletRequest(request);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzaXX.onCreate(savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzp(this.zzaXX.onCreateView(zze.zzx(inflater), zze.zzx(container), savedInstanceState));
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzaXX.zza(zze.zzx(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.zzaXX.onPause();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaXX.onResume();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaXX.onSaveInstanceState(outState);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.zzaXX.onStart();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.zzaXX.onStop();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class zzc extends com.google.android.gms.dynamic.zza<zzb> implements OnClickListener {
        final /* synthetic */ WalletFragment zzaYf;

        private zzc(WalletFragment walletFragment) {
            this.zzaYf = walletFragment;
        }

        public void onClick(View view) {
            Context activity = this.zzaYf.zzamZ.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        protected void zza(FrameLayout frameLayout) {
            View button = new Button(this.zzaYf.zzamZ.getActivity());
            button.setText(C0197R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.zzaYf.zzaXQ != null) {
                WalletFragmentStyle fragmentStyle = this.zzaYf.zzaXQ.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.zzaYf.zzamZ.getResources().getDisplayMetrics();
                    i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void zza(zzf<zzb> com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_WalletFragment_zzb) {
            Activity activity = this.zzaYf.zzamZ.getActivity();
            if (this.zzaYf.zzaXZ == null && this.zzaYf.mCreated && activity != null) {
                try {
                    this.zzaYf.zzaXZ = new zzb(null);
                    this.zzaYf.zzaXQ = null;
                    com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_WalletFragment_zzb.zza(this.zzaYf.zzaXZ);
                    if (this.zzaYf.zzaXR != null) {
                        this.zzaYf.zzaXZ.initialize(this.zzaYf.zzaXR);
                        this.zzaYf.zzaXR = null;
                    }
                    if (this.zzaYf.zzaXS != null) {
                        this.zzaYf.zzaXZ.updateMaskedWalletRequest(this.zzaYf.zzaXS);
                        this.zzaYf.zzaXS = null;
                    }
                    if (this.zzaYf.zzaXT != null) {
                        this.zzaYf.zzaXZ.updateMaskedWallet(this.zzaYf.zzaXT);
                        this.zzaYf.zzaXT = null;
                    }
                    if (this.zzaYf.zzaXU != null) {
                        this.zzaYf.zzaXZ.setEnabled(this.zzaYf.zzaXU.booleanValue());
                        this.zzaYf.zzaXU = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    static class zza extends com.google.android.gms.internal.zzrb.zza {
        private OnStateChangedListener zzaYd;
        private final WalletFragment zzaYe;

        zza(WalletFragment walletFragment) {
            this.zzaYe = walletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzaYd != null) {
                this.zzaYd.onStateChanged(this.zzaYe, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzaYd = onStateChangedListener;
        }
    }

    public WalletFragment() {
        this.mCreated = false;
        this.zzaYa = com.google.android.gms.dynamic.zzb.zza(this);
        this.zzaYb = new zzc();
        this.zzaYc = new zza(this);
        this.zzamZ = this;
    }

    public static WalletFragment newInstance(WalletFragmentOptions options) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        walletFragment.zzamZ.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        return this.zzaXZ != null ? this.zzaXZ.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzaXZ != null) {
            this.zzaXZ.initialize(initParams);
            this.zzaXR = null;
        } else if (this.zzaXR == null) {
            this.zzaXR = initParams;
            if (this.zzaXS != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzaXT != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzaXZ != null) {
            this.zzaXZ.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzaXR != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzaXR = walletFragmentInitParams;
            }
            if (this.zzaXS == null) {
                this.zzaXS = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.zzaXT == null) {
                this.zzaXT = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.zzaXQ = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.zzaXU = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (this.zzamZ.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzamZ.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzaS(this.zzamZ.getActivity());
                this.zzaXQ = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzaYb.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaYb.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.zzaXQ == null) {
            this.zzaXQ = WalletFragmentOptions.zza((Context) activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.zzaXQ);
        this.zzaYb.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.zzaYb.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaYb.onResume();
        FragmentManager fragmentManager = this.zzamZ.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzamZ.getActivity()), this.zzamZ.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzaYb.onSaveInstanceState(outState);
        if (this.zzaXR != null) {
            outState.putParcelable("walletFragmentInitParams", this.zzaXR);
            this.zzaXR = null;
        }
        if (this.zzaXS != null) {
            outState.putParcelable("maskedWalletRequest", this.zzaXS);
            this.zzaXS = null;
        }
        if (this.zzaXT != null) {
            outState.putParcelable("maskedWallet", this.zzaXT);
            this.zzaXT = null;
        }
        if (this.zzaXQ != null) {
            outState.putParcelable("walletFragmentOptions", this.zzaXQ);
            this.zzaXQ = null;
        }
        if (this.zzaXU != null) {
            outState.putBoolean("enabled", this.zzaXU.booleanValue());
            this.zzaXU = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.zzaYb.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzaYb.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzaXZ != null) {
            this.zzaXZ.setEnabled(enabled);
            this.zzaXU = null;
            return;
        }
        this.zzaXU = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzaYc.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzaXZ != null) {
            this.zzaXZ.updateMaskedWallet(maskedWallet);
            this.zzaXT = null;
            return;
        }
        this.zzaXT = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzaXZ != null) {
            this.zzaXZ.updateMaskedWalletRequest(request);
            this.zzaXS = null;
            return;
        }
        this.zzaXS = request;
    }
}
