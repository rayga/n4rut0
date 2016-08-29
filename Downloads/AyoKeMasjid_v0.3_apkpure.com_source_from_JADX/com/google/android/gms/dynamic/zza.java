package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzg;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    private T zzamN;
    private Bundle zzamO;
    private LinkedList<zza> zzamP;
    private final zzf<T> zzamQ;

    /* renamed from: com.google.android.gms.dynamic.zza.5 */
    static class C02815 implements OnClickListener {
        final /* synthetic */ int zzamY;
        final /* synthetic */ Context zzrn;

        C02815(Context context, int i) {
            this.zzrn = context;
            this.zzamY = i;
        }

        public void onClick(View v) {
            this.zzrn.startActivity(GooglePlayServicesUtil.zzbc(this.zzamY));
        }
    }

    private interface zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    /* renamed from: com.google.android.gms.dynamic.zza.1 */
    class C07311 implements zzf<T> {
        final /* synthetic */ zza zzamR;

        C07311(zza com_google_android_gms_dynamic_zza) {
            this.zzamR = com_google_android_gms_dynamic_zza;
        }

        public void zza(T t) {
            this.zzamR.zzamN = t;
            Iterator it = this.zzamR.zzamP.iterator();
            while (it.hasNext()) {
                ((zza) it.next()).zzb(this.zzamR.zzamN);
            }
            this.zzamR.zzamP.clear();
            this.zzamR.zzamO = null;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.2 */
    class C07322 implements zza {
        final /* synthetic */ zza zzamR;
        final /* synthetic */ Activity zzamS;
        final /* synthetic */ Bundle zzamT;
        final /* synthetic */ Bundle zzamU;

        C07322(zza com_google_android_gms_dynamic_zza, Activity activity, Bundle bundle, Bundle bundle2) {
            this.zzamR = com_google_android_gms_dynamic_zza;
            this.zzamS = activity;
            this.zzamT = bundle;
            this.zzamU = bundle2;
        }

        public int getState() {
            return 0;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzamR.zzamN.onInflate(this.zzamS, this.zzamT, this.zzamU);
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.3 */
    class C07333 implements zza {
        final /* synthetic */ zza zzamR;
        final /* synthetic */ Bundle zzamU;

        C07333(zza com_google_android_gms_dynamic_zza, Bundle bundle) {
            this.zzamR = com_google_android_gms_dynamic_zza;
            this.zzamU = bundle;
        }

        public int getState() {
            return 1;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzamR.zzamN.onCreate(this.zzamU);
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.4 */
    class C07344 implements zza {
        final /* synthetic */ zza zzamR;
        final /* synthetic */ Bundle zzamU;
        final /* synthetic */ FrameLayout zzamV;
        final /* synthetic */ LayoutInflater zzamW;
        final /* synthetic */ ViewGroup zzamX;

        C07344(zza com_google_android_gms_dynamic_zza, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.zzamR = com_google_android_gms_dynamic_zza;
            this.zzamV = frameLayout;
            this.zzamW = layoutInflater;
            this.zzamX = viewGroup;
            this.zzamU = bundle;
        }

        public int getState() {
            return 2;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzamV.removeAllViews();
            this.zzamV.addView(this.zzamR.zzamN.onCreateView(this.zzamW, this.zzamX, this.zzamU));
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.6 */
    class C07356 implements zza {
        final /* synthetic */ zza zzamR;

        C07356(zza com_google_android_gms_dynamic_zza) {
            this.zzamR = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 4;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzamR.zzamN.onStart();
        }
    }

    /* renamed from: com.google.android.gms.dynamic.zza.7 */
    class C07367 implements zza {
        final /* synthetic */ zza zzamR;

        C07367(zza com_google_android_gms_dynamic_zza) {
            this.zzamR = com_google_android_gms_dynamic_zza;
        }

        public int getState() {
            return 5;
        }

        public void zzb(LifecycleDelegate lifecycleDelegate) {
            this.zzamR.zzamN.onResume();
        }
    }

    public zza() {
        this.zzamQ = new C07311(this);
    }

    private void zza(Bundle bundle, zza com_google_android_gms_dynamic_zza_zza) {
        if (this.zzamN != null) {
            com_google_android_gms_dynamic_zza_zza.zzb(this.zzamN);
            return;
        }
        if (this.zzamP == null) {
            this.zzamP = new LinkedList();
        }
        this.zzamP.add(com_google_android_gms_dynamic_zza_zza);
        if (bundle != null) {
            if (this.zzamO == null) {
                this.zzamO = (Bundle) bundle.clone();
            } else {
                this.zzamO.putAll(bundle);
            }
        }
        zza(this.zzamQ);
    }

    public static void zzb(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence zzb = zzg.zzb(context, isGooglePlayServicesAvailable, GooglePlayServicesUtil.zzaf(context));
        CharSequence zzh = zzg.zzh(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(zzb);
        linearLayout.addView(textView);
        if (zzh != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(zzh);
            linearLayout.addView(button);
            button.setOnClickListener(new C02815(context, isGooglePlayServicesAvailable));
        }
    }

    private void zzei(int i) {
        while (!this.zzamP.isEmpty() && ((zza) this.zzamP.getLast()).getState() >= i) {
            this.zzamP.removeLast();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        zza(savedInstanceState, new C07333(this, savedInstanceState));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        zza(savedInstanceState, new C07344(this, frameLayout, inflater, container, savedInstanceState));
        if (this.zzamN == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.zzamN != null) {
            this.zzamN.onDestroy();
        } else {
            zzei(1);
        }
    }

    public void onDestroyView() {
        if (this.zzamN != null) {
            this.zzamN.onDestroyView();
        } else {
            zzei(2);
        }
    }

    public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
        zza(savedInstanceState, new C07322(this, activity, attrs, savedInstanceState));
    }

    public void onLowMemory() {
        if (this.zzamN != null) {
            this.zzamN.onLowMemory();
        }
    }

    public void onPause() {
        if (this.zzamN != null) {
            this.zzamN.onPause();
        } else {
            zzei(5);
        }
    }

    public void onResume() {
        zza(null, new C07367(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.zzamN != null) {
            this.zzamN.onSaveInstanceState(outState);
        } else if (this.zzamO != null) {
            outState.putAll(this.zzamO);
        }
    }

    public void onStart() {
        zza(null, new C07356(this));
    }

    public void onStop() {
        if (this.zzamN != null) {
            this.zzamN.onStop();
        } else {
            zzei(4);
        }
    }

    protected void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    protected abstract void zza(zzf<T> com_google_android_gms_dynamic_zzf_T);

    public T zzrn() {
        return this.zzamN;
    }
}
