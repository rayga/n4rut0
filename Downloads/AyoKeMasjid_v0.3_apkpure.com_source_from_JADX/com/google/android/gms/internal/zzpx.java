package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzpv.zza;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzpx extends zzj<zzpv> {
    private final Context mContext;

    public zzpx(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 45, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.mContext = context;
    }

    private String zzlK() {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.mContext.getPackageName(), Barcode.ITF);
            if (applicationInfo == null) {
                return null;
            }
            Bundle bundle = applicationInfo.metaData;
            return bundle == null ? null : (String) bundle.get("com.google.android.safetynet.API_KEY");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    protected /* synthetic */ IInterface zzV(IBinder iBinder) {
        return zzdC(iBinder);
    }

    public void zza(zzpu com_google_android_gms_internal_zzpu, List<Integer> list, int i, String str) throws RemoteException {
        int[] iArr = new int[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            iArr[i2] = ((Integer) list.get(i2)).intValue();
        }
        ((zzpv) zzoA()).zza(com_google_android_gms_internal_zzpu, zzlK(), iArr, i, str);
    }

    public void zza(zzpu com_google_android_gms_internal_zzpu, byte[] bArr) throws RemoteException {
        ((zzpv) zzoA()).zza(com_google_android_gms_internal_zzpu, bArr);
    }

    protected zzpv zzdC(IBinder iBinder) {
        return zza.zzdB(iBinder);
    }

    protected String zzfA() {
        return "com.google.android.gms.safetynet.service.START";
    }

    protected String zzfB() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }
}
