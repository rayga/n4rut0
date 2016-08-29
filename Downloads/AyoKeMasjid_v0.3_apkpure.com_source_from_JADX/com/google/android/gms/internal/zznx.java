package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.identity.intents.AddressConstants.ErrorCodes;
import com.google.android.gms.identity.intents.AddressConstants.Extras;
import com.google.android.gms.identity.intents.UserAddressRequest;

public class zznx extends zzj<zznz> {
    private Activity mActivity;
    private final int mTheme;
    private final String zzQE;
    private zza zzaAB;

    public static final class zza extends com.google.android.gms.internal.zzny.zza {
        private Activity mActivity;
        private final int zzadi;

        public zza(int i, Activity activity) {
            this.zzadi = i;
            this.mActivity = activity;
        }

        private void setActivity(Activity activity) {
            this.mActivity = activity;
        }

        public void zzh(int i, Bundle bundle) {
            PendingIntent createPendingResult;
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                createPendingResult = this.mActivity.createPendingResult(this.zzadi, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                        return;
                    } catch (Throwable e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                        return;
                    }
                }
                return;
            }
            createPendingResult = null;
            if (bundle != null) {
                createPendingResult = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, createPendingResult);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.mActivity, this.zzadi);
                    return;
                } catch (Throwable e2) {
                    Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    return;
                }
            }
            try {
                createPendingResult = this.mActivity.createPendingResult(this.zzadi, new Intent(), 1073741824);
                if (createPendingResult != null) {
                    createPendingResult.send(1);
                }
            } catch (Throwable e22) {
                Log.w("AddressClientImpl", "Exception setting pending result", e22);
            }
        }
    }

    public zznx(Activity activity, Looper looper, zzf com_google_android_gms_common_internal_zzf, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(activity, looper, 12, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzQE = com_google_android_gms_common_internal_zzf.getAccountName();
        this.mActivity = activity;
        this.mTheme = i;
    }

    public void disconnect() {
        super.disconnect();
        if (this.zzaAB != null) {
            this.zzaAB.setActivity(null);
            this.zzaAB = null;
        }
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzbS(iBinder);
    }

    public void zza(UserAddressRequest userAddressRequest, int i) {
        zzvw();
        this.zzaAB = new zza(i, this.mActivity);
        Bundle bundle;
        try {
            bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.zzQE)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.zzQE, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            zzvv().zza(this.zzaAB, userAddressRequest, bundle);
        } catch (Throwable e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            bundle = new Bundle();
            bundle.putInt(Extras.EXTRA_ERROR_CODE, ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.zzaAB.zzh(1, bundle);
        }
    }

    protected zznz zzbS(IBinder iBinder) {
        return com.google.android.gms.internal.zznz.zza.zzbU(iBinder);
    }

    protected String zzfA() {
        return "com.google.android.gms.identity.service.BIND";
    }

    protected String zzfB() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    public boolean zzoC() {
        return true;
    }

    protected zznz zzvv() throws DeadObjectException {
        return (zznz) super.zzoA();
    }

    protected void zzvw() {
        super.zzoz();
    }
}
