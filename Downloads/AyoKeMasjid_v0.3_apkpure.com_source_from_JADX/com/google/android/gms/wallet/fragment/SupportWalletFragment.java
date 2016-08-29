package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    private boolean mCreated;
    private zzb zzaXM;
    private final zzh zzaXN;
    private final zzc zzaXO;
    private zza zzaXP;
    private WalletFragmentOptions zzaXQ;
    private WalletFragmentInitParams zzaXR;
    private MaskedWalletRequest zzaXS;
    private MaskedWallet zzaXT;
    private Boolean zzaXU;
    private final Fragment zzadh;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
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
        final /* synthetic */ SupportWalletFragment zzaXY;

        private zzc(SupportWalletFragment supportWalletFragment) {
            this.zzaXY = supportWalletFragment;
        }

        public void onClick(View view) {
            Context activity = this.zzaXY.zzadh.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        protected void zza(FrameLayout frameLayout) {
            View button = new Button(this.zzaXY.zzadh.getActivity());
            button.setText(C0197R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (this.zzaXY.zzaXQ != null) {
                WalletFragmentStyle fragmentStyle = this.zzaXY.zzaXQ.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = this.zzaXY.zzadh.getResources().getDisplayMetrics();
                    i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        protected void zza(zzf<zzb> com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_SupportWalletFragment_zzb) {
            Activity activity = this.zzaXY.zzadh.getActivity();
            if (this.zzaXY.zzaXM == null && this.zzaXY.mCreated && activity != null) {
                try {
                    this.zzaXY.zzaXM = new zzb(null);
                    this.zzaXY.zzaXQ = null;
                    com_google_android_gms_dynamic_zzf_com_google_android_gms_wallet_fragment_SupportWalletFragment_zzb.zza(this.zzaXY.zzaXM);
                    if (this.zzaXY.zzaXR != null) {
                        this.zzaXY.zzaXM.initialize(this.zzaXY.zzaXR);
                        this.zzaXY.zzaXR = null;
                    }
                    if (this.zzaXY.zzaXS != null) {
                        this.zzaXY.zzaXM.updateMaskedWalletRequest(this.zzaXY.zzaXS);
                        this.zzaXY.zzaXS = null;
                    }
                    if (this.zzaXY.zzaXT != null) {
                        this.zzaXY.zzaXM.updateMaskedWallet(this.zzaXY.zzaXT);
                        this.zzaXY.zzaXT = null;
                    }
                    if (this.zzaXY.zzaXU != null) {
                        this.zzaXY.zzaXM.setEnabled(this.zzaXY.zzaXU.booleanValue());
                        this.zzaXY.zzaXU = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    static class zza extends com.google.android.gms.internal.zzrb.zza {
        private OnStateChangedListener zzaXV;
        private final SupportWalletFragment zzaXW;

        zza(SupportWalletFragment supportWalletFragment) {
            this.zzaXW = supportWalletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzaXV != null) {
                this.zzaXV.onStateChanged(this.zzaXW, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzaXV = onStateChangedListener;
        }
    }

    public SupportWalletFragment() {
        this.mCreated = false;
        this.zzaXN = zzh.zza(this);
        this.zzaXO = new zzc();
        this.zzaXP = new zza(this);
        this.zzadh = this;
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions options) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        supportWalletFragment.zzadh.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        return this.zzaXM != null ? this.zzaXM.getState() : 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzaXM != null) {
            this.zzaXM.initialize(initParams);
            this.zzaXR = null;
        } else if (this.zzaXR == null) {
            this.zzaXR = initParams;
            if (this.zzaXS != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzaXT != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzaXM != null) {
            this.zzaXM.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzaXR != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        } else if (this.zzadh.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzadh.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzaS(this.zzadh.getActivity());
                this.zzaXQ = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzaXO.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaXO.onCreateView(inflater, container, savedInstanceState);
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
        this.zzaXO.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.zzaXO.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaXO.onResume();
        FragmentManager supportFragmentManager = this.zzadh.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzadh.getActivity()), this.zzadh.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzaXO.onSaveInstanceState(outState);
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
        this.zzaXO.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzaXO.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzaXM != null) {
            this.zzaXM.setEnabled(enabled);
            this.zzaXU = null;
            return;
        }
        this.zzaXU = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzaXP.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzaXM != null) {
            this.zzaXM.updateMaskedWallet(maskedWallet);
            this.zzaXT = null;
            return;
        }
        this.zzaXT = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzaXM != null) {
            this.zzaXM.updateMaskedWalletRequest(request);
            this.zzaXS = null;
            return;
        }
        this.zzaXS = request;
    }
}
